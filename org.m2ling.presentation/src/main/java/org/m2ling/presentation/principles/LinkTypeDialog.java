/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Nullable;

import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.events.Events;
import org.m2ling.presentation.events.ObservationManager;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.model.LinkTypeBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.widgets.Command;
import org.m2ling.presentation.widgets.HelpPanel;
import org.m2ling.presentation.widgets.OKCancel;
import org.m2ling.service.principles.ComponentTypeService;
import org.m2ling.service.principles.LinkTypeService;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * Create or change LT (Component Type) form
 */
@SuppressWarnings("serial")
public class LinkTypeDialog extends Window {
	/** Is it a new LT ? */
	private boolean newLT = true;

	private final BeanItem<LinkTypeBean> beanItem;

	private final LinkTypeBean ltBean;

	private final Logger logger;

	private final DTOConverter.ToDTO toDTO;

	private final DTOConverter.FromDTO fromDTO;

	private final LinkTypeService ltService;

	private final Msg msg;

	private final ComponentTypeService ctService;

	private Form form;

	private final ObservationManager obs;

	private Command ok = new Command() {
		public void execute() {
			try {
				form.commit();
			} catch (Exception e) {
				// Ignored, we'll let the Form handle the errors
				logger.finest(e.getMessage());
				return;
			}
			LinkTypeDTO ctDTO = toDTO.getLinkTypeDTO(ltBean);
			try {
				if (newLT) {
					ltService.createLT(null, ctDTO);
				} else {
					ltService.updateLT(null, ctDTO);
				}
				close();
				// Make sure to reset stored data in case of functional or technical issue
			} catch (FunctionalException e) {
				logger.log(Level.SEVERE, e.getDetailedMessage(), e);
				getWindow().showNotification(msg.humanMessage(e), Notification.TYPE_ERROR_MESSAGE);
			}
			// Force panel refresh (required to update due to error or to reflect new rows)
			Properties details = Utils.newProperties(Events.DETAIL_VP, ctDTO.getViewPoint().getId());
			details.put(Events.DETAIL_TARGET, ltBean.getId());
			obs.notifySync(new org.m2ling.presentation.events.Event(Events.LT_CHANGE, details));
		}

		@Override
		public String getLabel() {
			return msg.get("gal.5");
		}
	};

	private Command cancel = new Command() {
		public void execute() {
			close();
		}

		@Override
		public String getLabel() {
			return msg.get("gal.6");
		}
	};

	/**
	 * Build the dialog
	 * 
	 */
	@Inject
	public LinkTypeDialog(Logger logger, @Assisted @Nullable BeanItem<LinkTypeBean> ltBeanItem,
			LinkTypeService ltService, DTOConverter.ToDTO toDTO, DTOConverter.FromDTO fromDTO, Msg msg,
			ComponentTypeService ctService, ObservationManager obs) {
		super(Strings.isNullOrEmpty(ltBeanItem.getBean().getId()) ? msg.get("pr.49") : ltBeanItem.getBean().getName());
		this.beanItem = ltBeanItem;
		this.ltService = ltService;
		this.ctService = ctService;
		this.logger = logger;
		this.toDTO = toDTO;
		this.fromDTO = fromDTO;
		this.msg = msg;
		this.obs = obs;
		newLT = Strings.isNullOrEmpty(ltBeanItem.getBean().getId());
		if (newLT) {
			beanItem.getItemProperty("id").setValue(UUID.randomUUID().toString());
		}
		ltBean = ltBeanItem.getBean();
	}

	@Override
	public void attach() {
		setWidth("650px");
		setHeight("800px");
		setClosable(true);
		((VerticalLayout) getContent()).setSizeFull();
		Panel panel = new Panel();
		panel.setSizeFull();
		panel.getContent().setHeight("-1");
		form = new Form();
		form.setImmediate(true);
		form.setFormFieldFactory(new LTDialogFieldFactory());
		form.setItemDataSource(beanItem);
		form.setVisibleItemProperties(Arrays.asList(new String[] { "name", "tags", "description", "linkTemporality",
				"linkAccessType", "sourcesTypes", "destinationsTypes", "comment" }));
		// Icon uploader
		HasNameAndIDBean hniBean = HasNameAndIDBean.newInstance(ltBean.getId(), ltBean.getName());
		IconUploader uploader = new IconUploader(hniBean, Consts.CONF_LT_ICONS_LOCATION, logger, msg);
		// Command buttons
		OKCancel okc = new OKCancel(ok, cancel);
		panel.addComponent(new HelpPanel(msg.get("help.1")));
		panel.addComponent(form);
		panel.addComponent(uploader);
		panel.addComponent(okc);
		((VerticalLayout) panel.getContent()).setComponentAlignment(okc, Alignment.MIDDLE_LEFT);
		((VerticalLayout) panel.getContent()).setComponentAlignment(uploader, Alignment.MIDDLE_CENTER);
		addComponent(panel);
	}

	private class LTDialogFieldFactory extends DefaultFieldFactory {
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
			} else if ("linkTemporality".equals(propertyId)) {
				Select linkTemporality = new Select();
				for (LinkTemporality lt : LinkTemporality.values()) {
					linkTemporality.addItem(lt);
				}
				linkTemporality.setCaption(msg.get("pr.45"));
				linkTemporality.setDescription(msg.get("pr.50"));
				linkTemporality.setRequired(true);
				return linkTemporality;
			} else if ("linkAccessType".equals(propertyId)) {
				Select linkAccessType = new Select();
				for (LinkAccessType lat : LinkAccessType.values()) {
					linkAccessType.addItem(lat);
				}
				linkAccessType.setCaption(msg.get("pr.46"));
				linkAccessType.setNullSelectionAllowed(true);
				linkAccessType.setDescription(msg.get("pr.51"));
				linkAccessType.setImmediate(true);
				linkAccessType.setRequired(true);
				return linkAccessType;
			} else if ("sourcesTypes".equals(propertyId)) {
				SourceDestSelection l = new SourceDestSelection(msg.get("pr.47"));
				l.setRequired(true);
				return l;
			} else if ("destinationsTypes".equals(propertyId)) {
				SourceDestSelection l = new SourceDestSelection(msg.get("pr.48"));
				l.setRequired(true);
				return l;
			} else {
				return super.createField(item, propertyId, uiContext);
			}
		}
	}

	/**
	 * Common code for source and destination types selection
	 */
	private class SourceDestSelection extends ListSelect {
		SourceDestSelection(String caption) {
			super(caption);
			try {
				// Add all CTs
				List<ComponentTypeDTO> cts = ctService.getAllCT(null, ltBean.getViewPoint().getId());
				for (ComponentTypeDTO ctDTO : cts) {
					ComponentTypeBean ctBean = fromDTO.getComponentTypeBean(ctDTO);
					// TODO For some unknown reasons, the two following lines doesn't work,
					// the caption used is still the toString() value of the bean,
					// we have to override toString() method by ourselves.
					// setItemCaptionMode(Select.ITEM_CAPTION_MODE_PROPERTY);
					// setItemCaptionPropertyId("name");
					HasNameAndIDBean hsi = new HasNameAndIDBean() {
						public String toString() {
							return getName();
						}
					};
					hsi.setId(ctBean.getId());
					hsi.setName(ctBean.getName());
					addItem(hsi);
				}
			} catch (FunctionalException fe) {
				logger.log(Level.SEVERE, fe.getDetailedMessage(), fe);
				getWindow().showNotification(msg.humanMessage(fe), Notification.TYPE_ERROR_MESSAGE);
			}
			setDescription(msg.get("pr.52"));
			setRows(6);
			setNullSelectionAllowed(true);
			setMultiSelect(true);
			setImmediate(true);
		}
	}
}
