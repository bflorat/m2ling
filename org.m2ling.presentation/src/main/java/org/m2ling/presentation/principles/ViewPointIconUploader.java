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
import com.vaadin.terminal.FileResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Window.Notification;

/**
 * View point image uploader
 */
@SuppressWarnings("serial")
public class ViewPointIconUploader extends CustomComponent implements Upload.SucceededListener,
		Upload.ProgressListener, Upload.FailedListener, Upload.Receiver {
	private Panel root;
	private Panel imagePanel;
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
	ViewPointIconUploader(ViewPointBean bean, Logger logger) {
		this.logger = logger;
		if (bean == null) {
			throw new IllegalArgumentException("Null viewpoint");
		}
		this.bean = bean;
		root = new Panel();
		setCompositionRoot(root);
		upload = new Upload("Upload an icon for this view point", this);
		upload.setButtonCaption("Upload icon");
		upload.addListener((Upload.SucceededListener) this);
		upload.addListener((Upload.FailedListener) this);
		root.addComponent(upload);
		// Create a panel for displaying the uploaded image.
		imagePanel = new Panel("Current icon");
		imagePanel.addComponent(new Label("No icon uploaded yet"));
		root.addComponent(imagePanel);
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

	// This is called if the upload is finished.
	public void uploadSucceeded(Upload.SucceededEvent event) {
		// Display the uploaded file in the image panel.
		final FileResource imageResource = new FileResource(target, getApplication());
		imagePanel.removeAllComponents();
		imagePanel.addComponent(new Embedded("", imageResource));
	}

	// This is called if the upload fails.
	public void uploadFailed(Upload.FailedEvent event) {
		// Log the failure on screen.
		root.addComponent(new Label("Uploading " + event.getFilename() + " of type '" + event.getMIMEType() + "' failed."));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vaadin.ui.Upload.ProgressListener#updateProgress(long, long)
	 */
	public void updateProgress(long readBytes, long contentLength) {
		if (contentLength > Consts.CONF_ICONS_MAX_SIZE_BYTES) {
			upload.interruptUpload();
			getWindow().showNotification("File too large", contentLength + " B", Notification.TYPE_ERROR_MESSAGE);
		}

	}
}
