/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.Arrays;
import java.util.UUID;
import java.util.logging.Logger;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.presentation.M2lingGuiceServletContextListener;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.utils.Converter;
import org.m2ling.presentation.principles.widgets.ViewPointIconUploader;
import org.m2ling.presentation.widgets.Command;
import org.m2ling.presentation.widgets.OKCancel;
import org.m2ling.service.principles.ViewPointService;

import com.google.inject.Inject;
import com.google.inject.Injector;
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

	@Inject
	ViewPointService service;

	@Inject
	Logger logger;

	/**
	 * Build a view point dialog
	 * 
	 * @param vp
	 *           an optional pre-filling view point (null when creating a new vp)
	 */
	public ViewPointDialog(ViewPointBean vp) {
		super(vp == null ? "New View Point" : vp.getName());
		// Perform a on-demand injection of fields. We can't perform regular injection of this class
		// because the bean is built on the fly and we need it in the constructor.
		Injector inj = M2lingGuiceServletContextListener.getCachedInjector();
		inj.injectMembers(this);
		// We need a bean to attach data to
		if (vp == null) {
			bean = new ViewPointBean();
			bean.setId(UUID.randomUUID().toString());
			newVP = true;
		} else {
			this.bean = vp;
		}
		setWidth("650px");
		setClosable(false);
	}

	@Override
	public void attach() {
		((VerticalLayout) getContent()).setSizeFull();
		final Form form = new Form();
		form.setCaption("Set view point settings");
		// setFormFieldFactory() must be called before setting the datasource or it is token into
		// account
		form.setFormFieldFactory(new ViewPointDialogFieldFactory());
		form.setItemDataSource(new BeanItem<ViewPointBean>(bean));
		form.setVisibleItemProperties(Arrays.asList(new String[] { "name", "statusLiterals", "tags", "description",
				"comment" }));
		form.setValidationVisibleOnCommit(true);
		Command ok = new Command() {
			public void execute() {
				form.commit();
				ViewPointDTO vpDTO = Converter.ViewPointConverter.convertToDTO(bean);
				if (newVP) {
					service.createViewPoint(vpDTO);
				} else {
					service.updateViewPoint(vpDTO);
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
				name.setRequiredError("View point name is mandatory");
				name.setDescription("Name of the view point like 'Physical Architecture'");
				return name;
			} else if ("description".equals(propertyId)) {
				RichTextArea description = new RichTextArea();
				description.setCaption("Description");
				description.setHeight(20,UNITS_EX);
				description.setWidth("100%");
				description.setDescription("Additional information describing the view point");
				return description;
			} else if ("comment".equals(propertyId)) {
				TextArea comment = new TextArea();
				comment.setHeight(12,UNITS_EX);
				comment.setWidth("100%");
				comment.setCaption("Comments");
				comment
						.setDescription("Any comment about the view point, can be used a as reminder.<br/>Example : 'Work in progress, some component types missing.'");
				return comment;
			} else if ("tags".equals(propertyId)) {
				Field tags = super.createField(item, propertyId, uiContext);
				tags.setDescription("Comma-separated strings used to group related items together and ease searches.<br/>Example : 'physical;team A;2012'");
				return tags;
			} else if ("statusLiterals".equals(propertyId)) {
				Field statusLiterals = super.createField(item, propertyId, uiContext);
				statusLiterals
						.setDescription("Comma-separated ordered strings defining available status for this view point items.<br/>Example : 'READY,RETIRED,FULL,AVAILABLE'");
				return statusLiterals;
			} else {
				return super.createField(item, propertyId, uiContext);
			}
		}
	}
}
