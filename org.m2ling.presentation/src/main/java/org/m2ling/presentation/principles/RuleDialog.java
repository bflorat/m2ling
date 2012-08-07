/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Nullable;

import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.events.Events;
import org.m2ling.presentation.events.ObservationManager;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.widgets.Command;
import org.m2ling.presentation.widgets.OKCancel;
import org.m2ling.service.principles.RuleService;
import org.m2ling.service.principles.ViewPointService;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * Create or change rule form
 */
@SuppressWarnings("serial")
public class RuleDialog extends Window {
	/** Is it a new rule ? */
	private boolean newRule = true;
	private RuleBean bean;
	private Logger logger;
	private ObservationManager obs;
	private DTOConverter.ToDTO toDTO;
	private DTOConverter.FromDTO fromDTO;
	private RuleService ruleService;
	private ViewPointService vpService;
	private ViewPointBean vpBean;
	private Panel panel;
	private final Msg msg;

	/**
	 * Build a rule dialog
	 * 
	 */
	@Inject
	public RuleDialog(Logger logger, @Assisted @Nullable RuleBean ruleBean, RuleService ruleService,
			ViewPointService vpService, ObservationManager obs, DTOConverter.ToDTO toDTO, DTOConverter.FromDTO fromDTO,
			Msg msg) {
		super(Strings.isNullOrEmpty(ruleBean.getId()) ? msg.get("pr.18") : msg.get("pr.17") + ruleBean.getName());
		this.bean = ruleBean;
		this.ruleService = ruleService;
		this.vpService = vpService;
		this.logger = logger;
		this.obs = obs;
		this.toDTO = toDTO;
		this.fromDTO = fromDTO;
		this.msg = msg;
		newRule = Strings.isNullOrEmpty(ruleBean.getId());
		if (newRule) {
			bean.setId(UUID.randomUUID().toString());
			bean.setPriority(msg.get("rule_priority." + RulePriority.MEDIUM.name()));
		}
		this.bean = ruleBean;
		setWidth("650px");
		setClosable(true);
	}

	@Override
	public void attach() {
		panel = new Panel();
		panel.setSizeFull();
		panel.getContent().setHeight("-1");
		// Refresh associated viewpoint data
		ViewPointDTO vpDTO = vpService.getViewPointByID(null, bean.getViewPointId());
		vpBean = fromDTO.getViewPointBean(vpDTO);
		((VerticalLayout) getContent()).setSizeFull();
		final Form form = new Form();
		// setFormFieldFactory() must be called before setting the data source or it is not token into
		// account
		form.setFormFieldFactory(new RuleDialogFieldFactory());
		form.setItemDataSource(new BeanItem<RuleBean>(bean));
		form.setVisibleItemProperties(Arrays.asList(new String[] { "name", "status", "priority", "tags", "description",
				"rationale", "exceptions", "comment" }));
		Command ok = new Command() {
			public void execute() {
				try {
					form.commit();
				} catch (Exception e) {
					// Ignored, we'll let the Form handle the errors
					logger.finest(e.getMessage());
					return;
				}
				RuleDTO ruleDTO = toDTO.getRuleDTO(bean);
				try {
					if (newRule) {
						ruleService.createRule(null, ruleDTO);
					} else {
						ruleService.updateRule(null, ruleDTO);
					}
					close();
					obs.notifySync(new org.m2ling.presentation.events.Event(Events.VP_CHANGE));
				} catch (FunctionalException e) {
					logger.log(Level.SEVERE, e.getDetailedMessage(), e);
					getWindow().showNotification(msg.humanMessage(e), Notification.TYPE_ERROR_MESSAGE);
				}
			}

			@Override
			public String getLabel() {
				return msg.get("gal.5");
			}
		};
		Command cancel = new Command() {
			public void execute() {
				close();
			}

			@Override
			public String getLabel() {
				return msg.get("gal.6");
			}
		};
		OKCancel okc = new OKCancel(ok, cancel);
		panel.addComponent(form);
		panel.addComponent(okc);
		((VerticalLayout) panel.getContent()).setComponentAlignment(okc, Alignment.MIDDLE_LEFT);
		addComponent(panel);
	}

	private class RuleDialogFieldFactory extends DefaultFieldFactory {
		@Override
		public Field createField(Item item, Object propertyId, Component uiContext) {
			if ("name".equals(propertyId)) {
				Field name = super.createField(item, propertyId, uiContext);
				name.setRequired(true);
				name.setRequiredError(msg.get("error.5"));
				name.setDescription(msg.get("pr.27"));
				return name;
			} else if ("description".equals(propertyId)) {
				TextArea description = new TextArea();
				description.setCaption(msg.get("gal.1"));
				description.setHeight(12, UNITS_EX);
				description.setWidth("100%");
				description.setDescription(msg.get("pr.27"));
				description.setRequired(true);
				return description;
			} else if ("rationale".equals(propertyId)) {
				TextArea rationale = new TextArea();
				rationale.setCaption(msg.get("gal.9"));
				rationale.setHeight(12, UNITS_EX);
				rationale.setWidth("100%");
				rationale.setDescription(msg.get("pr.22"));
				rationale.setRequired(true);
				return rationale;
			} else if ("exceptions".equals(propertyId)) {
				TextArea exceptions = new TextArea();
				exceptions.setCaption(msg.get("pr.23"));
				exceptions.setHeight(12, UNITS_EX);
				exceptions.setWidth("100%");
				exceptions.setDescription(msg.get("pr.24"));
				return exceptions;
			} else if ("comment".equals(propertyId)) {
				TextArea comment = new TextArea();
				comment.setHeight(12, UNITS_EX);
				comment.setWidth("100%");
				comment.setCaption(msg.get("mf.comments"));
				comment.setDescription(msg.get("pr.7"));
				return comment;
			} else if ("tags".equals(propertyId)) {
				Field tags = super.createField(item, propertyId, uiContext);
				tags.setDescription(msg.get("pr.8"));
				return tags;
			} else if ("status".equals(propertyId)) {
				ComboBox status = new ComboBox();
				List<String> statusList = Utils.stringListFromString(vpBean.getStatusLiterals());
				for (String st : statusList) {
					status.addItem(st);
				}
				status.setDescription(msg.get("pr.20"));
				status.setCaption(msg.get("gal.7"));
				status.setRequired(true);
				status.setRequiredError(msg.get("error.5"));
				status.setNullSelectionAllowed(false);
				return status;
			} else if ("priority".equals(propertyId)) {
				Select priority = new Select();
				priority.setNullSelectionAllowed(false);
				for (RulePriority pr : RulePriority.values()) {
					priority.addItem(msg.get("rule_priority." + pr.name()));
				}
				priority.setDescription(msg.get("pr.21"));
				priority.setCaption(msg.get("gal.8"));
				priority.setRequired(true);
				return priority;
			} else {
				return super.createField(item, propertyId, uiContext);
			}
		}
	}
}
