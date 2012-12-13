/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.presentation.M2App;
import org.m2ling.presentation.events.Events;
import org.m2ling.presentation.events.ObservationManager;
import org.m2ling.presentation.events.Observer;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.service.principles.ViewPointService;

import com.google.inject.Inject;
import com.google.inject.servlet.SessionScoped;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

/**
 * Main m2principles panel
 */
@SuppressWarnings("serial")
@SessionScoped
public class PrinciplesM2App extends M2App implements Observer {
	private List<ViewPointDTO> vpsDTO;

	private ViewPointService vpService;

	private Logger logger;

	private PrinciplesGUIFactory dialogFactory;

	private PrinciplesGUIFactory factory;

	private ObservationManager obs;

	private DTOConverter.FromDTO fromDTO;

	private final Msg msg;

	private VerticalLayout root;

	@Inject
	public PrinciplesM2App(ViewPointService vpService, Logger logger, PrinciplesGUIFactory dialogFactory,
			PrinciplesGUIFactory panelFactory, ObservationManager obs, DTOConverter.FromDTO fromDTO, Msg msg) {
		super();
		this.vpService = vpService;
		this.logger = logger;
		this.factory = panelFactory;
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
		vpsDTO = vpService.getAllViewPoints(null);
		if (vpsDTO.size() == 0) {
			VerticalLayout vert = getNoneVPPanel();
			addComponent(vert);
			root.setComponentAlignment(vert, Alignment.MIDDLE_CENTER);
		} else {
			Button create = new Button(msg.get("pr.2"), new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					ViewPointDialog vpDialog = dialogFactory.getViewPointDialogFor(null);
					vpDialog.setModal(true);
					getWindow().addWindow(vpDialog);
				}
			});
			create.setStyleName(BaseTheme.BUTTON_LINK);
			addComponent(create);
			root.setComponentAlignment(create, Alignment.MIDDLE_RIGHT);
			addComponent(new Label("<br/>", Label.CONTENT_RAW));
			for (ViewPointDTO dto : vpsDTO) {
				ViewPointBean bean = fromDTO.getViewPointBean(dto);
				ViewPointPanel panel = factory.getViewPointPanelFor(bean);
				addComponent(panel);
			}
		}
	}

	private VerticalLayout getNoneVPPanel() {
		VerticalLayout vert = new VerticalLayout();
		vert.setSizeUndefined();
		vert.setSpacing(true);
		Label noneVPLabel = new Label("");
		noneVPLabel.setSizeUndefined();
		noneVPLabel.setIcon(new ThemeResource("img/16/information.png"));
		// Use caption to set text to keep icon and label on the same line
		noneVPLabel.setCaption("None view point found");
		Button create = new Button(msg.get("pr.2"), new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				ViewPointDialog vpDialog = dialogFactory.getViewPointDialogFor(null);
				vpDialog.setModal(true);
				getWindow().addWindow(vpDialog);
			}
		});
		create.setStyleName(BaseTheme.BUTTON_LINK);
		vert.addComponent(noneVPLabel);
		vert.addComponent(create);
		return vert;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.presentation.events.Observer#update(org.m2ling.presentation.events.Event)
	 */
	@Override
	public void update(org.m2ling.presentation.events.Event event) {
		if (event.getSubject() == Events.VP_CHANGE) {
			removeAllComponents();
			attach();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.presentation.events.Observer#getRegistrationKeys()
	 */
	@Override
	public Set<Events> getRegistrationKeys() {
		Set<Events> events = new HashSet<Events>();
		events.add(Events.VP_CHANGE);
		return events;
	}
}
