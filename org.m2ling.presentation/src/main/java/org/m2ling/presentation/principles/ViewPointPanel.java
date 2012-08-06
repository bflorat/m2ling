/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.presentation.events.Events;
import org.m2ling.presentation.events.ObservationManager;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.principles.utils.IconManager;
import org.m2ling.service.principles.ViewPointService;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.terminal.FileResource;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.themes.BaseTheme;

/**
 * View point summary
 */
@SuppressWarnings("serial")
public class ViewPointPanel extends VerticalLayout {
	private final Logger logger;
	private final ViewPointBean bean;
	private ViewPointDialogFactory vpDialogFactory;
	private RulesPanelFactory rulesPanelFactory;
	private ViewPointService service;
	private ObservationManager obs;
	private DTOConverter.ToDTO toDTO;

	/**
	 * Build an VP panel
	 * 
	 * @param vp
	 *           the associated view point
	 * @throws IllegalArgumentException
	 *            if bean is null
	 */
	@Inject
	public ViewPointPanel(@Assisted ViewPointBean bean, Logger logger, ViewPointDialogFactory factory,
			ViewPointService service, ObservationManager obs, DTOConverter.ToDTO toDTO, RulesPanelFactory rulesPanelFactory) {
		super();
		this.logger = logger;
		this.bean = bean;
		this.vpDialogFactory = factory;
		this.service = service;
		this.obs = obs;
		this.toDTO = toDTO;
		this.rulesPanelFactory = rulesPanelFactory;
		if (bean == null) {
			throw new IllegalArgumentException("Null viewpoint");
		}
		setSpacing(true);
		setMargin(true);
		setHeight(null);
		setWidth("100%");
		setStyleName("principles_vp-panel");
	}

	@Override
	public void attach() {
		super.attach();
		// Build icon if any or use default icon otherwise
		Embedded icon = null;
		File iconFile = IconManager.getVPIconFile(bean);
		Resource res = null;
		if (iconFile != null) {
			res = new FileResource(iconFile, getApplication());
		} else {
			res = new ThemeResource("img/256/view_point_default.png");
		}
		icon = new Embedded("", res);
		icon.setWidth("50px");
		icon.setHeight("50px");
		icon.requestRepaint();
		// Name
		Label name = new Label(bean.getName()
				+ (!Strings.isNullOrEmpty(bean.getTags()) ? " [" + bean.getTags() + "]" : ""));
		name.setStyleName("principles_vp-panel-name");
		name.setSizeUndefined();
		Button edit = new Button(Msg.get("gal.2"));
		edit.setStyleName(BaseTheme.BUTTON_LINK);
		edit.addStyleName("command");
		edit.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				ViewPointDialog vpDialog = vpDialogFactory.getViewPointDialogFor(bean);
				vpDialog.setModal(true);
				getWindow().addWindow(vpDialog);
			}
		});
		Button delete = new Button(Msg.get("gal.3"));
		delete.setStyleName(BaseTheme.BUTTON_LINK);
		delete.addStyleName("command");
		delete.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				try {
					ViewPointDTO vpDTO = toDTO.getViewPointDTO(bean);
					service.deleteViewPoint(null, vpDTO);
					obs.notifySync(new org.m2ling.presentation.events.Event(Events.VP_CHANGE));
				} catch (FunctionalException e) {
					logger.log(Level.SEVERE, e.getDetailedMessage(), e.getCause());
					getWindow().showNotification(Msg.humanMessage(e), Notification.TYPE_ERROR_MESSAGE);
				}
			}
		});
		final Panel rulesHiddenPane = new Panel();
		rulesHiddenPane.setVisible(false);
		rulesHiddenPane.setWidth("100%");
		rulesHiddenPane.setHeight(null);
		RulesPanel rulesPanel = rulesPanelFactory.getRulesPanelFor(bean.getId());
		rulesHiddenPane.setContent(rulesPanel);
		Button rules = new Button(Msg.get("pr.13"));
		rules.setStyleName(BaseTheme.BUTTON_LINK);
		rules.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				rulesHiddenPane.setVisible(!rulesHiddenPane.isVisible());
			}
		});
		Button componentTypes = new Button(Msg.get("pr.14"));
		componentTypes.setStyleName(BaseTheme.BUTTON_LINK);
		componentTypes.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO
			}
		});
		Button linkTypes = new Button(Msg.get("pr.15"));
		linkTypes.setStyleName(BaseTheme.BUTTON_LINK);
		linkTypes.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO
			}
		});
		Button activities = new Button(Msg.get("pr.25"));
		activities.setStyleName(BaseTheme.BUTTON_LINK);
		activities.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO
			}
		});
		Label description = new Label(bean.getDescription());
		description.setDescription(bean.getDescription());
		description.setStyleName("principles_vp-panel-desc");
		description.setWidth("100%");
		description.setHeight(null);
		Label comment = new Label(bean.getComment());
		comment.setDescription(bean.getComment());
		comment.setStyleName("comment");
		comment.setWidth("100%");
		comment.setHeight(null);
		// Layout
		HorizontalLayout hl1 = new HorizontalLayout();
		hl1.setSpacing(true);
		hl1.addComponent(icon);
		hl1.setComponentAlignment(icon, Alignment.MIDDLE_RIGHT);
		hl1.addComponent(name);
		hl1.setComponentAlignment(name, Alignment.MIDDLE_RIGHT);
		hl1.addComponent(edit);
		hl1.addComponent(delete);
		addComponent(hl1);
		addComponent(description);
		if (!Strings.isNullOrEmpty(bean.getComment())) {
			addComponent(comment);
		}
		addComponent(componentTypes);
		addComponent(linkTypes);
		addComponent(activities);
		addComponent(rules);
		addComponent(rulesHiddenPane);
	}
}
