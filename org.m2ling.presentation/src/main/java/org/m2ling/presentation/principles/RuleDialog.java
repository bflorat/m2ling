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
import org.m2ling.common.utils.Msg;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.events.Events;
import org.m2ling.presentation.events.ObservationManager;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.widgets.Command;
import org.m2ling.presentation.widgets.OKCancel;
import org.m2ling.service.principles.RuleService;
import org.m2ling.service.principles.ViewPointService;

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
import com.vaadin.ui.RichTextArea;
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

	/**
	 * Build a rule dialog
	 * 
	 */
	@Inject
	public RuleDialog(Logger logger, @Assisted @Nullable RuleBean ruleBean, RuleService ruleService,
			ViewPointService vpService, ObservationManager obs, DTOConverter.ToDTO toDTO, DTOConverter.FromDTO fromDTO) {
		super(ruleBean == null ? Msg.get("pr.18") : Msg.get("pr.17") + ruleBean.getName());
		this.bean = ruleBean;
		this.ruleService = ruleService;
		this.vpService = vpService;
		this.logger = logger;
		this.obs = obs;
		this.toDTO = toDTO;
		this.fromDTO = fromDTO;
		newRule = (ruleBean == null);
		// We need a bean to attach data to
		if (newRule) {
			bean = new RuleBean();
			bean.setId(UUID.randomUUID().toString());
		} else {
			this.bean = ruleBean;
		}
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
		form.setCaption(Msg.get("pr.4"));
		// setFormFieldFactory() must be called before setting the data source or it is not token into
		// account
		form.setFormFieldFactory(new RuleDialogFieldFactory());
		form.setItemDataSource(new BeanItem<RuleBean>(bean));
		form.setVisibleItemProperties(Arrays.asList(new String[] { "name", "status", "priority", "tags", "description",
				"rationale", "exceptions", "comment" }));
		form.setValidationVisibleOnCommit(true);
		Command ok = new Command() {
			public void execute() {
				form.commit();
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
					logger.log(Level.SEVERE, e.getDetailedMessage(), e.getCause());
					getWindow().showNotification(Msg.get("error.1"), Notification.TYPE_ERROR_MESSAGE);
				}
			}
		};
		Command cancel = new Command() {
			public void execute() {
				close();
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
				name.setRequiredError(Msg.get("error.2"));
				name.setDescription(Msg.get("pr.5"));
				return name;
			} else if ("description".equals(propertyId)) {
				RichTextArea description = new RichTextArea();
				description.setCaption(Msg.get("gal.1"));
				description.setHeight(20, UNITS_EX);
				description.setWidth("100%");
				description.setDescription(Msg.get("pr.6"));
				return description;
			} else if ("rationale".equals(propertyId)) {
				RichTextArea rationale = new RichTextArea();
				rationale.setCaption(Msg.get("gal.9"));
				rationale.setHeight(20, UNITS_EX);
				rationale.setWidth("100%");
				rationale.setDescription(Msg.get("pr.22"));
				return rationale;
			} else if ("exceptions".equals(propertyId)) {
				RichTextArea exceptions = new RichTextArea();
				exceptions.setCaption(Msg.get("pr.23"));
				exceptions.setHeight(20, UNITS_EX);
				exceptions.setWidth("100%");
				exceptions.setDescription(Msg.get("pr.24"));
				return exceptions;
			} else if ("comment".equals(propertyId)) {
				TextArea comment = new TextArea();
				comment.addStyleName("principles_vp_dialog_comment");
				comment.setHeight(12, UNITS_EX);
				comment.setWidth("100%");
				comment.setCaption(Msg.get("mf.comments"));
				comment.setDescription(Msg.get("pr.7"));
				return comment;
			} else if ("tags".equals(propertyId)) {
				Field tags = super.createField(item, propertyId, uiContext);
				tags.setDescription(Msg.get("pr.8"));
				return tags;
			} else if ("status".equals(propertyId)) {
				ComboBox status = new ComboBox();
				List<String> statusList = Utils.stringListFromString(vpBean.getStatusLiterals());
				for (String st : statusList) {
					status.addItem(st);
				}
				status.setDescription(Msg.get("pr.20"));
				status.setCaption(Msg.get("gal.7"));
				return status;
			} else if ("priority".equals(propertyId)) {
				ComboBox priority = new ComboBox();
				for (RulePriority pr : RulePriority.values()) {
					priority.addItem(pr.name());
				}
				priority.setDescription(Msg.get("pr.21"));
				priority.setCaption(Msg.get("gal.8"));
				return priority;
			} else {
				return super.createField(item, propertyId, uiContext);
			}
		}
	}
}
