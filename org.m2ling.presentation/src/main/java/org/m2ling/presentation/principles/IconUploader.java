/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.utils.Consts;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.utils.IconManager;

import com.google.common.io.Files;
import com.vaadin.terminal.FileResource;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Window.Notification;

/**
 * Image uploader
 */
@SuppressWarnings("serial")
public class IconUploader extends CustomComponent implements Upload.Receiver {
	private HasNameAndIDBean bean;
	private Logger logger;
	private final Upload upload;
	private final Msg msg;
	private final String prefix;

	/**
	 * Build an icon uploader
	 * 
	 * @param bean
	 *           the associated bean
	 * @param prefix
	 *           parent directory name of the icons
	 * @throws IllegalArgumentException
	 *            if bean is null
	 */
	public IconUploader(HasNameAndIDBean bean, String prefix, Logger logger, Msg msg) {
		this.logger = logger;
		this.msg = msg;
		this.prefix = prefix;
		if (bean == null) {
			throw new IllegalArgumentException("Null bean");
		}
		this.bean = bean;
		upload = new Upload(msg.get("pr.11"), this);
		upload.addListener(new SucceededListener());
		upload.addListener(new ProgressListener());
	}

	public void attach() {
		super.attach();
		HorizontalLayout hl = new HorizontalLayout();
		hl.setSpacing(true);
		setSizeUndefined();
		setCompositionRoot(hl);
		Resource res = null;
		File iconFile = IconManager.getIconFile(prefix, bean.getId());
		if (iconFile != null && iconFile.exists()) {
			res = new FileResource(iconFile, getApplication());
		} else {
			// Default "empty" icon
			res = new ThemeResource("img/48/empty.png");
		}
		Embedded preview = new Embedded("", res);
		preview.requestRepaint();
		preview.setWidth("32px");
		preview.setHeight("32px");
		upload.setImmediate(true);
		hl.addComponent(upload);
		hl.addComponent(preview);
	}

	public OutputStream receiveUpload(String filename, String MIMEType) {
		FileOutputStream fos = null;
		String home = Conf.getHomeDirectoryPath();
		// Store the uploaded icon as <vp id>.<original file extension> in the m2ling home
		// directory/icons directory
		File target = new File(home + File.separatorChar + prefix + File.separatorChar + bean.getId() + '.'
				+ Files.getFileExtension(filename));
		try {
			// create structure if required
			target.getParentFile().mkdirs();
			fos = new FileOutputStream(target);
		} catch (final Exception e) {
			logger.log(Level.SEVERE, "Can't create icon image for item: " + bean.getId(), e);
			getWindow().showNotification(msg.get("error.3") + " : " + bean.getId(), e.getMessage(),
					Notification.TYPE_ERROR_MESSAGE);
			return null;
		}
		return fos; // Return the output stream to write to
	}

	private class ProgressListener implements Upload.ProgressListener {
		/*
		 * (non-Javadoc)
		 * 
		 * @see com.vaadin.ui.Upload.ProgressListener#updateProgress(long, long)
		 */
		public void updateProgress(long readBytes, long contentLength) {
			if (contentLength > Consts.ICONS_MAX_SIZE_BYTES) {
				upload.interruptUpload();
				getWindow().showNotification(msg.get("error.4"), contentLength + " B", Notification.TYPE_ERROR_MESSAGE);
			}
		}
	}

	private class SucceededListener implements Upload.SucceededListener {
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.vaadin.ui.Upload.SucceededListener#uploadSucceeded(com.vaadin.ui.Upload.SucceededEvent)
		 */
		@Override
		public void uploadSucceeded(SucceededEvent event) {
			// refresh preview once upload complete
			attach();
		}
	}
}
