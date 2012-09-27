/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.presentation.events.Events;
import org.m2ling.presentation.events.ObservationManager;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.model.ReferenceBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.widgets.Command;
import org.m2ling.presentation.widgets.HelpPanel;
import org.m2ling.presentation.widgets.OKCancel;
import org.m2ling.service.principles.ComponentTypeService;
import org.m2ling.service.principles.ViewPointService;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * Create or change CT (Component Type) form
 */
@SuppressWarnings("serial")
public class ComponentTypeDialog extends Window {
	/** Is it a new CT ? */
	private boolean newCT = true;
	private final BeanItem<ComponentTypeBean> beanItem;
	private final ComponentTypeBean ctBean;
	private final Logger logger;
	private final DTOConverter.ToDTO toDTO;
	private final DTOConverter.FromDTO fromDTO;
	private final ComponentTypeService ctService;
	private final Msg msg;
	private final ViewPointService vpService;
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
			ComponentTypeDTO ctDTO = toDTO.getComponentTypeDTO(ctBean);
			try {
				if (newCT) {
					ctService.createCT(null, ctDTO);
				} else {
					ctService.updateCT(null, ctDTO);
				}
				close();
				// Make sure to reset stored data in case of functional or technical issue
			} catch (FunctionalException e) {
				logger.log(Level.SEVERE, e.getDetailedMessage(), e);
				getWindow().showNotification(msg.humanMessage(e), Notification.TYPE_ERROR_MESSAGE);
				Properties details = Utils.newProperties(Events.DETAIL_VP, ctDTO.getViewPoint().getId());
				details.put(Events.DETAIL_TARGET, ctBean.getId());
				obs.notifySync(new org.m2ling.presentation.events.Event(Events.CT_CHANGE, details));
			}
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
	public ComponentTypeDialog(Logger logger, @Assisted @Nullable BeanItem<ComponentTypeBean> ctBeanItem,
			ComponentTypeService ctService, DTOConverter.ToDTO toDTO, DTOConverter.FromDTO fromDTO, Msg msg,
			ViewPointService vpService, ObservationManager obs) {
		super(Strings.isNullOrEmpty(ctBeanItem.getBean().getId()) ? msg.get("pr.38") : ctBeanItem.getBean().getName());
		this.beanItem = ctBeanItem;
		this.ctService = ctService;
		this.vpService = vpService;
		this.logger = logger;
		this.toDTO = toDTO;
		this.fromDTO = fromDTO;
		this.msg = msg;
		this.obs = obs;
		newCT = Strings.isNullOrEmpty(ctBeanItem.getBean().getId());
		if (newCT) {
			beanItem.getItemProperty("id").setValue(UUID.randomUUID().toString());
		}
		ctBean = ctBeanItem.getBean();
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
		form.setFormFieldFactory(new CTDialogFieldFactory());
		form.setItemDataSource(beanItem);
		form.setVisibleItemProperties(Arrays.asList(new String[] { "name", "tags", "description", "boundType",
				"instantiationFactor", "comment" }));
		// Icon uploader
		HasNameAndIDBean hniBean = HasNameAndIDBean.newInstance(ctBean.getId(), ctBean.getName());
		IconUploader uploader = new IconUploader(hniBean, Consts.CONF_CT_ICONS_LOCATION, logger, msg);
		// Command buttons
		OKCancel okc = new OKCancel(ok, cancel);
		panel.addComponent(new HelpPanel(msg.get("help.1")));
		panel.addComponent(form);
		// References
		Panel references = new Panel(msg.get("pr.33"));
		references.setWidth("100%");
		references.setHeight("-1");
		GridLayout gl = new GridLayout(4, ctBean.getReferences().size() + 1);
		gl.setMargin(true);
		gl.setSpacing(true);
		gl.setWidth("100%");
		gl.setHeight("-1");
		int row = 0;
		for (ReferenceBean refBean : ctBean.getReferences()) {
			addNewReference(refBean, gl, row);
			row++;
		}
		// Add a void row to enable a new reference creation
		ReferenceBean voidRefBean = new ReferenceBean();
		voidRefBean.setTargets(new ArrayList<HasNameAndIDBean>());
		addNewReference(voidRefBean, gl, row);
		references.addComponent(gl);
		panel.addComponent(references);
		panel.addComponent(uploader);
		panel.addComponent(okc);
		((VerticalLayout) panel.getContent()).setComponentAlignment(okc, Alignment.MIDDLE_LEFT);
		((VerticalLayout) panel.getContent()).setComponentAlignment(uploader, Alignment.MIDDLE_CENTER);
		addComponent(panel);
	}

	/**
	 * Add a reference edition row to the provided gridlayout
	 * 
	 * @param refBean
	 *           : the reference bean or null for a void editable row
	 * @param gl
	 * @param row
	 */
	private void addNewReference(final ReferenceBean refBean, final GridLayout gl, final int row) {
		NativeButton drop = new NativeButton("");
		drop.setDescription(msg.get("gal.3"));
		drop.setSizeUndefined();
		drop.setStyleName("borderless");
		drop.setIcon(new ThemeResource("img/16/delete.png"));
		drop.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				removeAllComponents();
				ctBean.getReferences().remove(refBean);
				attach();
			}
		});
		// Combo box to select type
		final ComboBox type = new ComboBox(msg.get("pr.40"));
		type.setImmediate(true);
		type.setNullSelectionAllowed(false);
		type.setInputPrompt("--" + msg.get("pr.42") + "--");
		for (ReferenceType refType : ReferenceType.values()) {
			type.addItem(refType.name());
		}
		type.select(refBean.getType());
		// We add the new reference once the type has been set
		type.addListener(new Property.ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				refBean.setType((String) type.getValue());
				if (!(ctBean.getReferences().contains(refBean))) {
					ctBean.getReferences().add(refBean);
					removeAllComponents();
					attach();
				}
			}
		});
		type.setSizeUndefined();
		PopupView targets = new PopupView(new PopupView.Content() {
			@Override
			public Component getPopupComponent() {
				List<ComponentTypeDTO> cts = null;
				BeanItemContainer<HasNameAndIDBean> container = new BeanItemContainer<HasNameAndIDBean>(
						HasNameAndIDBean.class);
				final TwinColSelect tcs = new TwinColSelect(msg.get("pr.41"), container);
				tcs.setItemCaptionMode(Select.ITEM_CAPTION_MODE_PROPERTY);
				tcs.setItemCaptionPropertyId("name");
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
					getWindow().showNotification(msg.humanMessage(fe), Notification.TYPE_ERROR_MESSAGE);
				}
				tcs.setRows(10);
				tcs.setNullSelectionAllowed(false);
				tcs.setMultiSelect(true);
				tcs.setLeftColumnCaption(msg.get("gal.14"));
				tcs.setRightColumnCaption(msg.get("gal.15"));
				tcs.setWidth("350px");
				tcs.setImmediate(true);
				tcs.addListener(new Property.ValueChangeListener() {
					@Override
					public void valueChange(ValueChangeEvent event) {
						refBean.getTargets().clear();
						@SuppressWarnings("unchecked")
						java.util.Set<HasNameAndIDBean> selectedItems = (java.util.Set<HasNameAndIDBean>) tcs.getValue();
						for (HasNameAndIDBean selected : selectedItems) {
							refBean.getTargets().add(selected);
						}
					}
				});
				return tcs;
			}

			@Override
			public String getMinimizedValueAsHTML() {
				return (refBean.getTargets().size() == 0) ? "[" + msg.get("pr.41") + "]" : refBean.toTargetsString();
			}
		});
		targets.setHideOnMouseOut(false);
		targets.setWidth("60%");
		gl.addComponent(drop, 0, row);
		gl.setComponentAlignment(drop, Alignment.MIDDLE_RIGHT);
		gl.addComponent(type, 1, row);
		gl.addComponent(new Label(": "), 2, row);
		gl.setComponentAlignment(type, Alignment.MIDDLE_LEFT);
		gl.addComponent(targets, 3, row);
		gl.setComponentAlignment(targets, Alignment.MIDDLE_CENTER);
		gl.setColumnExpandRatio(3, 1);
	}

	private class CTDialogFieldFactory extends DefaultFieldFactory {
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
			} else if ("instantiationFactor".equals(propertyId)) {
				Field ifactor = super.createField(item, propertyId, uiContext);
				ifactor.setCaption(msg.get("pr.37"));
				ifactor.setDescription(msg.get("pr.37"));
				ifactor.setRequired(true);
				ifactor.addValidator(new IFactorValidator());
				return ifactor;
			} else if ("boundType".equals(propertyId)) {
				Select boundType = new Select();
				boundType.setCaption(msg.get("pr.36"));
				boundType.setNullSelectionAllowed(true);
				boundType.setDescription(msg.get("pr.36"));
				boundType.setImmediate(true);
				try {
					List<ViewPointDTO> vpsDTO = vpService.getAllViewPoints(null);
					for (ViewPointDTO vpDTO : vpsDTO) {
						if (!(vpDTO.getId().equals(ctBean.getViewPoint().getId()))) {// Ignore CT from
																											// local VP
							List<ComponentTypeDTO> cts = ctService.getAllCT(null, vpDTO.getId());
							for (ComponentTypeDTO ctDTO : cts) {
								HasNameAndIDBean bound = HasNameAndIDBean.newInstance(ctDTO.getId(), ctDTO.getName());
								boundType.addItem(bound);
								boundType.setItemCaption(bound, ctDTO.getViewPoint().getName() + "/ " + ctDTO.getName());
							}
						}
					}
				} catch (FunctionalException fe) {
					logger.log(Level.SEVERE, fe.getDetailedMessage(), fe);
					getWindow().showNotification(msg.humanMessage(fe), Notification.TYPE_ERROR_MESSAGE);
				}
				return boundType;
			} else if ("enumeration".equals(propertyId)) {
				Select enumeration = new Select();
				enumeration.setCaption(msg.get("pr.32"));
				enumeration.setDescription(msg.get("pr.36"));
				// TODO : call future m2studio services to get components and component groups
				// from views of others viewpoints.
				// TODO : use a TwinColumnSelector like we use for references
				return enumeration;
			} else {
				return super.createField(item, propertyId, uiContext);
			}
		}
	}

	/**
	 * Instantiation factor GUI validator
	 */
	private class IFactorValidator extends AbstractValidator {
		public IFactorValidator() {
			super(msg.get("error.5"));
		}

		@Override
		public void validate(Object value) throws InvalidValueException {
			if (!isValid(value)) {
				throw new InvalidValueException("Invalid ifactor");
			}
		}

		@Override
		public boolean isValid(Object value) {
			if (!(value instanceof String)) {
				return false;
			}
			String ifactor = (String) value;
			Pattern p = Pattern.compile("[0-9]*");
			Matcher m = p.matcher(ifactor);
			return "*".equals(ifactor) || m.matches();
		}
	};
}
