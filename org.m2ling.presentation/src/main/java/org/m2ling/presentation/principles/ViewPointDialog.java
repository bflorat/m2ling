/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.Arrays;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Nullable;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.Msg;
import org.m2ling.presentation.events.Events;
import org.m2ling.presentation.events.ObservationManager;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.widgets.Command;
import org.m2ling.presentation.widgets.OKCancel;
import org.m2ling.service.principles.ViewPointService;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * Create or change view point form
 */
@SuppressWarnings("serial")
public class ViewPointDialog extends Window {

	/** Is it a new view point ? */
	private boolean newVP = true;

	private ViewPointBean bean;

	private ViewPointService service;

	private Logger logger;

	private ObservationManager obs;

	private DTOConverter.ToDTO toDTO;

	/**
	 * Build a view point dialog
	 * 
	 */
	@Inject
	public ViewPointDialog(Logger logger, @Assisted @Nullable ViewPointBean vp, ViewPointService service,
			ObservationManager obs, DTOConverter.ToDTO toDTO) {
		super(vp == null ? Msg.get("pr.10") : vp.getName());
		this.bean = vp;
		this.service = service;
		this.logger = logger;
		this.obs = obs;
		this.toDTO = toDTO;
		// We need a bean to attach data to
		if (vp == null) {
			bean = new ViewPointBean();
			bean.setId(UUID.randomUUID().toString());
			newVP = true;
		} else {
			this.bean = vp;
			newVP = false;
		}
		setWidth("650px");
		setClosable(true);
	}

	@Override
	public void attach() {
		((VerticalLayout) getContent()).setSizeFull();
		final Form form = new Form();
		form.setCaption(Msg.get("pr.4"));
		// setFormFieldFactory() must be called before setting the data source or it is not token into
		// account
		form.setFormFieldFactory(new ViewPointDialogFieldFactory());
		form.setItemDataSource(new BeanItem<ViewPointBean>(bean));
		form.setVisibleItemProperties(Arrays.asList(new String[] { "name", "statusLiterals", "tags", "description",
				"comment" }));
		form.setValidationVisibleOnCommit(true);
		Command ok = new Command() {
			public void execute() {
				form.commit();
				ViewPointDTO vpDTO = toDTO.getViewPointDTO(bean);
				try {
					if (newVP) {
						service.createViewPoint(vpDTO);
					} else {
						service.updateViewPoint(vpDTO);
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
		ViewPointIconUploader uploader = new ViewPointIconUploader(bean, logger);
		OKCancel okc = new OKCancel(ok, cancel);
		addComponent(form);
		addComponent(uploader);
		addComponent(okc);
		((VerticalLayout) getContent()).setComponentAlignment(okc, Alignment.MIDDLE_LEFT);
		((VerticalLayout) getContent()).setComponentAlignment(uploader, Alignment.MIDDLE_CENTER);
	}

	private class ViewPointDialogFieldFactory extends DefaultFieldFactory {
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
			} else if ("statusLiterals".equals(propertyId)) {
				Field statusLiterals = super.createField(item, propertyId, uiContext);
				statusLiterals.setDescription(Msg.get("pr.9"));
				return statusLiterals;
			} else {
				return super.createField(item, propertyId, uiContext);
			}
		}
	}
}
