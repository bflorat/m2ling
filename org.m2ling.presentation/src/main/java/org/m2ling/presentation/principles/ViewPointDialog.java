/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.Arrays;
import java.util.List;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.widgets.Command;
import org.m2ling.presentation.widgets.OKCancel;
import org.m2ling.service.principles.ViewPointService;

import com.google.inject.Inject;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.RichTextArea;
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

	/**
	 * Build a view point dialog
	 * 
	 * @param vp
	 *           an optional pre-filling view point (null when creating a new vp)
	 */
	ViewPointDialog(ViewPointBean vp) {
		super(vp == null ? "New View Point" : vp.getName());
		// We need a bean to attach data to
		if (vp == null) {
			bean = new ViewPointBean();
			newVP = true;
		} else {
			this.bean = vp;
		}
		setWidth("650px");
		setClosable(false);
		populate();
	}

	private void populate() {
		final Form form = new Form();
		form.setCaption("Set view point settings");
		// setFormFieldFactory() must be called before setting the datasource or it is token into
		// account
		form.setFormFieldFactory(new ViewPointDialogFieldFactory());
		form.setItemDataSource(new BeanItem<ViewPointBean>(bean));
		form.setVisibleItemProperties(Arrays.asList(new String[] { "name", "label", "tags" }));
		form.setValidationVisibleOnCommit(true);
		addComponent(form);
		Command ok = new Command() {
			public void execute() {
				form.commit();
				List<String> tags = Utils.tagsFromString(bean.getTags());
				ViewPointDTO vpDTO = new ViewPointDTO.Builder(bean.getName()).label(bean.getLabel()).tags(tags).build();
				if (newVP) {
					service.createViewPoint(vpDTO);
				}
				else{
					//TODO : appel du service
				}
			}
		};
		Command cancel = new Command() {
			public void execute() {
				close();
			}
		};
		OKCancel okc = new OKCancel(ok, cancel);
		addComponent(okc);
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
			} else if ("label".equals(propertyId)) {
				RichTextArea label = new RichTextArea();
				label.setCaption("Label");
				label.setDescription("Additional information describing the view point");
				return label;
			} else if ("tags".equals(propertyId)) {
				Field tags = super.createField(item, propertyId, uiContext);
				tags.setDescription("Comma-separated strings used to group related items together and ease searches.<br/>Example : 'physical;team A;2012'");
				return tags;
			} else {
				return super.createField(item, propertyId, uiContext);
			}
		}
	}
}
