/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.studio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.m2ling.common.dto.core.ViewDTO;
import org.m2ling.presentation.M2App;
import org.m2ling.presentation.events.Events;
import org.m2ling.presentation.events.ObservationManager;
import org.m2ling.presentation.events.Observer;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.service.models.ViewService;

import com.google.inject.Inject;
import com.google.inject.servlet.SessionScoped;
import com.vaadin.ui.VerticalLayout;

/**
 * Main studio panel
 */
@SuppressWarnings("serial")
@SessionScoped
public class StudioM2App extends M2App implements Observer {
	private List<ViewDTO> viewsDTO;

	private ViewService viewService;

	private Logger logger;

	private StudioGUIFactory factory;

	private ObservationManager obs;

	private DTOConverter.FromDTO fromDTO;

	private final Msg msg;

	private VerticalLayout root;

	@Inject
	public StudioM2App(ViewService viewService, Logger logger, StudioGUIFactory factory,
			StudioGUIFactory panelFactory, ObservationManager obs, DTOConverter.FromDTO fromDTO, Msg msg) {
		super();
		this.viewService = viewService;
		this.logger = logger;
		this.factory = factory;
		this.obs = obs;
		this.fromDTO = fromDTO;
		this.msg = msg;
		obs.register(this);
		setWidth("100%");
		setHeight("100%");
		root = (VerticalLayout) getContent();
		root.setWidth("100%");
		root.setHeight("-1");
	}

	/**
	 * Populate the panel with actual viewpoints. Can take a while as it calls services.
	 */
	@Override
	public void attach() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.presentation.events.Observer#update(org.m2ling.presentation.events.Event)
	 */
	@Override
	public void update(org.m2ling.presentation.events.Event event) {
		//if (event.getSubject() == Events.VP_CHANGE) {
	//		removeAllComponents();
		//	attach();
	//	}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.presentation.events.Observer#getRegistrationKeys()
	 */
	@Override
	public Set<Events> getRegistrationKeys() {
		Set<Events> events = new HashSet<Events>();
	//	events.add(Events.VP_CHANGE);
		return events;
	}
}
