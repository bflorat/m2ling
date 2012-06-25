/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.Msg;
import org.m2ling.presentation.events.Events;
import org.m2ling.presentation.events.ObservationManager;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.service.principles.RuleService;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.themes.BaseTheme;

/**
 * List all rules for a given viewpoint
 */
@SuppressWarnings("serial")
public class RulesPanel extends VerticalLayout {

	private String vp;

	private RuleService service;

	private Logger logger;

	private ObservationManager obs;

	private DTOConverter.ToDTO toDTO;

	private DTOConverter.FromDTO fromDTO;

	/**
	 * Build a rules dialog
	 * 
	 */
	@Inject
	public RulesPanel(Logger logger, @Assisted String vp, RuleService service, ObservationManager obs,
			DTOConverter.ToDTO toDTO, DTOConverter.FromDTO fromDTO) {
		super();
		this.vp = vp;
		this.service = service;
		this.logger = logger;
		this.obs = obs;
		this.vp = vp;
		this.toDTO = toDTO;
		this.fromDTO = fromDTO;
		setSizeFull();
		setStyleName("principles_rules-panel");
	}

	@Override
	public void attach() {
		try {
			List<RuleDTO> rules = service.getAllRules(vp);
			if (rules.size() == 0) {
				addComponent(new Label(Msg.get("pr.1")));
			} else {
				for (RuleDTO dto : rules) {
					RuleBean rule = fromDTO.getRuleBean(dto);
					addRule(rule);
				}
			}
		} catch (FunctionalException e) {
			logger.log(Level.SEVERE, e.getDetailedMessage(), e);
			getWindow().showNotification(e.getDetailedMessage(), Notification.TYPE_ERROR_MESSAGE);
		}
	}

	private void addRule(final RuleBean rule) {
		// Name
		Label name = new Label(rule.getName());
		name.setStyleName("name");
		name.setSizeUndefined();
		Button edit = new Button("Edit");
		edit.setStyleName(BaseTheme.BUTTON_LINK);
		edit.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO
				// ViewPointDialog vpDialog = factory.getViewPointDialogFor(bean);
				// vpDialog.setModal(true);
				// getWindow().addWindow(vpDialog);
			}
		});

		Button delete = new Button("Delete");
		delete.setStyleName(BaseTheme.BUTTON_LINK);
		delete.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				try {
					RuleDTO ruleDTO = toDTO.getRuleDTO(rule);
					service.deleteRule(ruleDTO);
					obs.notifySync(new org.m2ling.presentation.events.Event(Events.VP_CHANGE));
				} catch (FunctionalException e) {
					logger.log(Level.SEVERE, e.getDetailedMessage(), e.getCause());
					getWindow().showNotification(Msg.get("error.1") + " : " + e.getDetailedMessage(),
							Notification.TYPE_ERROR_MESSAGE);
				}
			}
		});

		Label description = new Label(rule.getDescription());
		description.setDescription(rule.getDescription());
		description.setStyleName("desc");
		description.setWidth("100%");
		description.setHeight(null);

		Label comment = new Label(rule.getComment());
		comment.setDescription(rule.getComment());
		comment.setStyleName("comment");
		comment.setWidth("100%");
		comment.setHeight(null);

		Label tags = new Label(rule.getTags());
		tags.setDescription(rule.getTags());
		tags.setStyleName("tags");
		tags.setWidth("100%");
		tags.setHeight(null);

		// Layout
		HorizontalLayout hl1 = new HorizontalLayout();
		hl1.setSpacing(true);
		hl1.addComponent(name);
		hl1.setComponentAlignment(name, Alignment.MIDDLE_RIGHT);
		hl1.addComponent(edit);
		hl1.addComponent(delete);

		HorizontalLayout hl3 = new HorizontalLayout();
		hl3.setSpacing(true);
		hl3.addComponent(new Label("Tags:"));
		hl3.addComponent(tags);

		addComponent(hl1);
		if (!Strings.isNullOrEmpty(rule.getTags())) {
			addComponent(hl3);
		}
		addComponent(description);
		if (!Strings.isNullOrEmpty(rule.getComment())) {
			addComponent(comment);
		}
	}

}
