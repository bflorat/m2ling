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

import org.m2ling.common.configuration.Configuration;
import org.m2ling.common.utils.Consts;
import org.m2ling.presentation.principles.model.ViewPointBean;

import com.google.common.io.Files;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Window.Notification;

/**
 * View point image uploader
 */
@SuppressWarnings("serial")
public class ViewPointIconUploader extends CustomComponent implements Upload.ProgressListener, Upload.Receiver {
	private File target;
	private ViewPointBean bean;
	private Logger logger;
	private final Upload upload;

	/**
	 * Build an icon uploader
	 * 
	 * @param vp
	 *           the associated view point
	 * @throws IllegalArgumentException
	 *            if vp is null
	 */
	public ViewPointIconUploader(ViewPointBean bean, Logger logger) {
		this.logger = logger;
		if (bean == null) {
			throw new IllegalArgumentException("Null viewpoint");
		}
		this.bean = bean;
		HorizontalLayout hl = new HorizontalLayout();
		hl.setSpacing(true);
		setSizeUndefined();
		setCompositionRoot(hl);
		upload = new Upload("Upload an icon for this view point", this);
		upload.setImmediate(true);
		upload.setButtonCaption("Upload icon");
		hl.addComponent(upload);
	}

	public OutputStream receiveUpload(String filename, String MIMEType) {
		FileOutputStream fos = null;
		String home = Configuration.getHomeDirectoryPath();
		// Store the uploaded icon as <vp id>.<original file extension> in the m2ling home
		// directory/icons directory
		target = new File(home + File.separatorChar + Consts.CONF_VP_ICONS_LOCATION + File.separatorChar + bean.getId()
				+ '.' + Files.getFileExtension(filename));
		try {
			// create structure if required
			target.getParentFile().mkdirs();
			fos = new FileOutputStream(target);
		} catch (final Exception e) {
			logger.log(Level.SEVERE, "Can't create icon image for view point: " + bean.getId(), e);
			getWindow().showNotification("Can't create icon image for view point: " + bean.getId(), e.getMessage(),
					Notification.TYPE_ERROR_MESSAGE);
			return null;
		}
		return fos; // Return the output stream to write to
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vaadin.ui.Upload.ProgressListener#updateProgress(long, long)
	 */
	public void updateProgress(long readBytes, long contentLength) {
		if (contentLength > Consts.ICONS_MAX_SIZE_BYTES) {
			upload.interruptUpload();
			getWindow().showNotification("File too large", contentLength + " B", Notification.TYPE_ERROR_MESSAGE);
		}

	}
}
