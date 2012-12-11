/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.dto.core.HasNameAndIdDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.service.models.ComponentService;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Select;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

/**
 * Provides the CT enumeration popup content
 */
@SuppressWarnings("serial")
public class EnumerationPopupContent implements PopupView.Content {
	private final ComponentTypeBean ctBean;

	private final Msg msg;

	private final Logger logger;

	private final Window window;

	private final ComponentService compService;

	@Override
	public Component getPopupComponent() {
		if (ctBean.getBoundType() == null) {
			window.showNotification(msg.get("error.6"), Notification.TYPE_ERROR_MESSAGE);
			return null;
		}
		BeanItemContainer<HasNameAndIDBean> container = new BeanItemContainer<HasNameAndIDBean>(HasNameAndIDBean.class);
		final TwinColSelect tcsEnumeration = new TwinColSelect(msg.get("pr.54"), container);
		tcsEnumeration.setItemCaptionMode(Select.ITEM_CAPTION_MODE_PROPERTY);
		tcsEnumeration.setItemCaptionPropertyId("name");
		try {
			List<HasNameAndIdDTO> comps = compService.getComponentsAndGroupByCT(null, ctBean.getBoundType().getId());
			for (HasNameAndIdDTO compDTO : comps) {
				HasNameAndIDBean hsi = HasNameAndIDBean.newInstance(compDTO.getId(), compDTO.getName());
				container.addItem(hsi);
				if (ctBean.getEnumeration().contains(hsi)) {
					tcsEnumeration.select(hsi);
				}
			}
		} catch (FunctionalException fe) {
			logger.log(Level.SEVERE, fe.getDetailedMessage(), fe);
			window.showNotification(msg.humanMessage(fe), Notification.TYPE_ERROR_MESSAGE);
		}
		tcsEnumeration.addListener(new Property.ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				ctBean.getEnumeration().clear();
				@SuppressWarnings("unchecked")
				java.util.Set<HasNameAndIDBean> selectedItems = (java.util.Set<HasNameAndIDBean>) tcsEnumeration.getValue();
				for (HasNameAndIDBean selected : selectedItems) {
					ctBean.getEnumeration().add(selected);
				}
			}
		});
		tcsEnumeration.setRows(10);
		// can be none selection
		tcsEnumeration.setNullSelectionAllowed(true);
		tcsEnumeration.setMultiSelect(true);
		tcsEnumeration.setLeftColumnCaption(msg.get("gal.14"));
		tcsEnumeration.setRightColumnCaption(msg.get("gal.15"));
		tcsEnumeration.setWidth("350px");
		tcsEnumeration.setImmediate(true);
		return tcsEnumeration;
	}

	@Override
	public String getMinimizedValueAsHTML() {
		return (ctBean.getEnumeration().size() == 0) ? "[" + msg.get("pr.54") + "]" : ctBean.getEnumerationAsString();
	}

	@Inject
	public EnumerationPopupContent(@Assisted ComponentTypeBean ctBean, ComponentService compService,
			@Assisted Window window, Msg msg, Logger logger) {
		super();
		this.ctBean = ctBean;
		this.window = window;
		this.logger = logger;
		this.msg = msg;
		this.compService = compService;
	}
}
