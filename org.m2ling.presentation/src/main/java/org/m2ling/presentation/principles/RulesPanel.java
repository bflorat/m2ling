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
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.service.principles.RuleService;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
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
	private String vpID;
	private RuleService service;
	private Logger logger;
	private DTOConverter.ToDTO toDTO;
	private DTOConverter.FromDTO fromDTO;
	private RuleDialogFactory factory;

	/**
	 * Build a rules dialog
	 * 
	 */
	@Inject
	public RulesPanel(Logger logger, @Assisted String vpID, RuleService service, DTOConverter.ToDTO toDTO,
			DTOConverter.FromDTO fromDTO, RuleDialogFactory factory) {
		super();
		this.vpID = vpID;
		this.service = service;
		this.factory = factory;
		this.logger = logger;
		this.toDTO = toDTO;
		this.fromDTO = fromDTO;
		setHeight(null);
		setWidth("95%");
		addStyleName("principles_rules-panel");
	}

	@Override
	public void attach() {
		try {
			List<RuleDTO> rules = service.getAllRules(null, vpID);
			if (rules.size() == 0) {
				addComponent(new Label(Msg.get("pr.1")));
			} else {
				for (RuleDTO dto : rules) {
					RuleBean rule = fromDTO.getRuleBean(dto);
					addRule(rule);
				}
			}
			addComponent(getCreateRuleButton());
		} catch (FunctionalException e) {
			logger.log(Level.SEVERE, e.getDetailedMessage(), e);
			getWindow().showNotification(Msg.humanMessage(e), Notification.TYPE_ERROR_MESSAGE);
		}
	}

	private Button getCreateRuleButton() {
		Button createRule = new Button(Msg.get("pr.16"));
		createRule.setStyleName(BaseTheme.BUTTON_LINK);
		createRule.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// rule with null ID means "new rule". We can't pass null rule because VP'id is got from
				// it
				RuleBean bean = new RuleBean();
				bean.setViewPointId(vpID);
				RuleDialog dialog = factory.getRuleDialogFor(bean);
				dialog.setModal(true);
				getWindow().addWindow(dialog);
			}
		});
		return createRule;
	}

	private void addRule(final RuleBean rule) {
		// Name
		String nameString = Msg.get("pr.17") + rule.getName()
				+ (!Strings.isNullOrEmpty(rule.getTags()) ? " [" + rule.getTags() + "]  " : " ");
		nameString += "<br/>" + Msg.get("gal.7") + ": " + rule.getStatus() + ", " + Msg.get("gal.8") + ": "
				+ rule.getPriority();
		Label name = new Label(nameString, Label.CONTENT_RAW);
		name.setStyleName("principles_rules-name");
		name.setSizeUndefined();
		Button edit = new Button(Msg.get("gal.2"));
		edit.setStyleName(BaseTheme.BUTTON_LINK);
		edit.addStyleName("command");
		edit.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				RuleDialog dialog = factory.getRuleDialogFor(rule);
				dialog.setModal(true);
				getWindow().addWindow(dialog);
			}
		});
		Button delete = new Button(Msg.get("gal.3"));
		delete.setStyleName(BaseTheme.BUTTON_LINK);
		delete.addStyleName("command");
		delete.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				try {
					RuleDTO ruleDTO = toDTO.getRuleDTO(rule);
					service.deleteRule(null, ruleDTO);
					removeAllComponents();
					attach();
				} catch (FunctionalException e) {
					logger.log(Level.SEVERE, e.getDetailedMessage(), e.getCause());
					getWindow().showNotification(Msg.humanMessage(e), Notification.TYPE_ERROR_MESSAGE);
				}
			}
		});
		Label description = new Label(rule.getDescription(), Label.CONTENT_RAW);
		description.setStyleName("principles_rules-description");
		description.setWidth("100%");
		description.setHeight(null);
		String rat = rule.getRationale();
		Label rationale = new Label(Strings.isNullOrEmpty(rat) ? "" : Msg.get("gal.9") + " : " + rat, Label.CONTENT_RAW);
		rationale.setWidth("100%");
		rationale.setHeight(null);
		String ex = rule.getExceptions();
		Label exceptions = new Label(Strings.isNullOrEmpty(ex) ? "" : Msg.get("pr.23") + " : " + ex, Label.CONTENT_RAW);
		exceptions.setWidth("100%");
		exceptions.setHeight(null);
		Label comment = new Label(rule.getComment(), Label.CONTENT_RAW);
		comment.setDescription(rule.getComment());
		comment.setStyleName("comment");
		comment.setWidth("100%");
		comment.setHeight(null);
		// Layout
		HorizontalLayout hl1 = new HorizontalLayout();
		hl1.setSpacing(true);
		hl1.addComponent(name);
		hl1.addComponent(edit);
		hl1.addComponent(delete);
		addComponent(hl1);
		addComponent(description);
		addComponent(rationale);
		addComponent(exceptions);
		if (!Strings.isNullOrEmpty(rule.getComment())) {
			addComponent(comment);
		}
		addComponent(new Label("<br/>", Label.CONTENT_RAW));
	}
}
