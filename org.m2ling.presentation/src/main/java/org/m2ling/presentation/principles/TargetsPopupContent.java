/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.model.ReferenceBean;
import org.m2ling.presentation.principles.utils.DTOConverter.FromDTO;
import org.m2ling.service.principles.ComponentTypeService;

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
 * Provides the content of a popup to select a reference targets
 */
@SuppressWarnings("serial")
public class TargetsPopupContent implements PopupView.Content {
	private final ReferenceBean refBean;

	private final ComponentTypeBean ctBean;

	private final Msg msg;

	private final Logger logger;

	private final Window window;

	private final FromDTO fromDTO;

	private final ComponentTypeService ctService;
	
	@Inject
	public TargetsPopupContent(@Assisted ComponentTypeBean ctBean, @Assisted ReferenceBean refBean,
			ComponentTypeService ctService, @Assisted Window window, Msg msg, Logger logger, FromDTO fromDTO) {
		super();
		this.ctBean = ctBean;
		this.refBean = refBean;
		this.window = window;
		this.logger = logger;
		this.msg = msg;
		this.ctService = ctService;
		this.fromDTO = fromDTO;
	}

	public Component getPopupComponent() {
		List<ComponentTypeDTO> cts = null;
		BeanItemContainer<HasNameAndIDBean> container = new BeanItemContainer<HasNameAndIDBean>(HasNameAndIDBean.class);
		final TwinColSelect tcsTargets = new TwinColSelect(msg.get("pr.41"), container);
		tcsTargets.setItemCaptionMode(Select.ITEM_CAPTION_MODE_PROPERTY);
		tcsTargets.setItemCaptionPropertyId("name");
		try {
			// Add all CT (including itself)
			cts = ctService.getAllCT(null, ctBean.getViewPoint().getId());
			for (ComponentTypeDTO ctDTO : cts) {
				ComponentTypeBean ctBean = fromDTO.getComponentTypeBean(ctDTO);
				HasNameAndIDBean hsi = HasNameAndIDBean.newInstance(ctBean.getId(), ctBean.getName());
				container.addItem(hsi);
			}
		} catch (FunctionalException fe) {
			logger.log(Level.SEVERE, fe.getDetailedMessage(), fe);
			window.showNotification(msg.humanMessage(fe), Notification.TYPE_ERROR_MESSAGE);
		}
		tcsTargets.setRows(10);
		tcsTargets.setNullSelectionAllowed(false);
		tcsTargets.setMultiSelect(true);
		tcsTargets.setLeftColumnCaption(msg.get("gal.14"));
		tcsTargets.setRightColumnCaption(msg.get("gal.15"));
		tcsTargets.setWidth("350px");
		tcsTargets.setImmediate(true);
		tcsTargets.addListener(new Property.ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				refBean.getTargets().clear();
				@SuppressWarnings("unchecked")
				java.util.Set<HasNameAndIDBean> selectedItems = (java.util.Set<HasNameAndIDBean>) tcsTargets.getValue();
				for (HasNameAndIDBean selected : selectedItems) {
					refBean.getTargets().add(selected);
				}
			}
		});
		return tcsTargets;
	}

	@Override
	public String getMinimizedValueAsHTML() {
		return (refBean.getTargets().size() == 0) ? "[" + msg.get("pr.41") + "]" : refBean.toTargetsString();
	}

	
}
