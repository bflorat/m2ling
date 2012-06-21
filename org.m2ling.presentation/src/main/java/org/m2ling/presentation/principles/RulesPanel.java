/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.logging.Logger;

import org.m2ling.presentation.events.ObservationManager;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.service.principles.ViewPointService;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.ui.VerticalLayout;

/**
 * List all rules for a given viewpoint
 */
@SuppressWarnings("serial")
public class RulesPanel extends VerticalLayout {

	private ViewPointBean bean;

	private ViewPointService service;

	private Logger logger;

	private ObservationManager obs;

	/**
	 * Build a rules dialog
	 * 
	 */
	@Inject
	public RulesPanel(Logger logger, @Assisted ViewPointBean vp, ViewPointService service, ObservationManager obs) {
		super();
		this.bean = vp;
		this.service = service;
		this.logger = logger;
		this.obs = obs;
		this.bean = vp;
		setSizeFull();
	}

	@Override
	public void attach() {
		
	}

}
