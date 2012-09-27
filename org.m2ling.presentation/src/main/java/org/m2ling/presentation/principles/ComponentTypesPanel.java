/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.dto.core.ComponentTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.presentation.events.Events;
import org.m2ling.presentation.events.ObservationManager;
import org.m2ling.presentation.events.Observer;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.ComponentTypeBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.widgets.HelpPanel;
import org.m2ling.service.principles.ComponentTypeService;
import org.vaadin.dialogs.ConfirmDialog;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbstractSelect.ItemDescriptionGenerator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.themes.BaseTheme;

/**
 * List all component types (CT) for a given viewpoint
 */
@SuppressWarnings("serial")
public class ComponentTypesPanel extends VerticalLayout implements Observer {
	private final String vpID;
	private final ComponentTypeService serviceCT;
	private final Logger logger;
	private final DTOConverter.ToDTO toDTO;
	private final DTOConverter.FromDTO fromDTO;
	// private final RuleDialogFactory factory;
	private final Msg msg;
	private final PrinciplesGUIFactory factory;
	/** Current data **/
	private BeanContainer<String, ComponentTypeBean> data;

	@Inject
	public ComponentTypesPanel(Logger logger, @Assisted String vpID, ComponentTypeService serviceCT,
			DTOConverter.ToDTO toDTO, DTOConverter.FromDTO fromDTO, Msg msg, ObservationManager obs,
			PrinciplesGUIFactory factory) {
		super();
		this.vpID = vpID;
		this.serviceCT = serviceCT;
		// this.factory = factory;
		this.logger = logger;
		this.toDTO = toDTO;
		this.fromDTO = fromDTO;
		this.msg = msg;
		this.factory = factory;
		setHeight(null);
		setWidth("98%");
		setMargin(true);
		obs.register(this);
	}

	@Override
	public void attach() {
		try {
			List<ComponentTypeDTO> cts = serviceCT.getAllCT(null, vpID);
			if (cts.size() == 0) {
				addComponent(new Label(msg.get("pr.35")));
				Button create = getCreateButton();
				addComponent(create);
				setComponentAlignment(create, Alignment.TOP_RIGHT);
			} else {
				data = new BeanContainer<String, ComponentTypeBean>(ComponentTypeBean.class);
				data.setBeanIdProperty("id");
				for (ComponentTypeDTO dto : cts) {
					ComponentTypeBean ctBean = fromDTO.getComponentTypeBean(dto);
					data.addBean(ctBean);
				}
				final Table table = new Table(null, data);
				table.setWidth("100%");
				table.setHeight("300px");
				table.setVisibleColumns(new String[] { "drop", "name", "description", "instantiationFactor", "boundType",
						"enumeration", "references", "tags" });
				table.setColumnExpandRatio("description", 0.4f);
				table.setColumnExpandRatio("boundType", 0.2f);
				table.setColumnExpandRatio("references", 0.2f);
				table.setColumnExpandRatio("enumeration", 0.2f);
				table.setItemDescriptionGenerator(new ItemDescriptionGenerator() {
					public String generateDescription(Component source, Object itemId, Object propertyId) {
						ComponentTypeBean bean = (ComponentTypeBean) data.getItem(itemId).getBean();
						return getHtmlDetails(bean);
					}
				});
				table.setColumnHeaders(new String[] { msg.get("gal.3"), msg.get("gal.12"),
						msg.get("gal.1") + " (" + msg.get("gal.10") + ")", msg.get("pr.30"), msg.get("pr.36"),
						msg.get("pr.32"), msg.get("pr.33"), msg.get("gal.4") });
				table.addGeneratedColumn("name", new Table.ColumnGenerator() {
					public Component generateCell(Table table, Object itemId, Object columnId) {
						final BeanItem<ComponentTypeBean> item = data.getItem(itemId);
						Button edit = new Button(item.getBean().getName());
						edit.setStyleName(BaseTheme.BUTTON_LINK);
						edit.addListener(new Button.ClickListener() {
							public void buttonClick(ClickEvent event) {
								ComponentTypeDialog dialog = factory.getComponentTypeDialogFor(item);
								dialog.setModal(true);
								getWindow().addWindow(dialog);
							}
						});
						return edit;
					}
				});
				table.addGeneratedColumn("drop", new Table.ColumnGenerator() {
					public Component generateCell(Table table, Object itemId, Object columnId) {
						BeanItem<ComponentTypeBean> item = data.getItem(itemId);
						final ComponentTypeBean ctBean = item.getBean();
						NativeButton drop = new NativeButton("");
						drop.setDescription(msg.get("gal.3"));
						drop.setSizeFull();
						drop.setStyleName("borderless");
						drop.setIcon(new ThemeResource("img/16/delete.png"));
						drop.addListener(new Button.ClickListener() {
							public void buttonClick(ClickEvent event) {
								drop(ctBean);
							}
						});
						return drop;
					}
				});
				table.addGeneratedColumn("boundType", new Table.ColumnGenerator() {
					@Override
					public Object generateCell(Table source, Object itemId, Object columnId) {
						BeanItem<ComponentTypeBean> item = data.getItem(itemId);
						final ComponentTypeBean ctBean = item.getBean();
						Label label = new Label("");
						if (ctBean.getBoundType() != null) {
							label = new Label(ctBean.getViewPoint().getName() + "/ " + ctBean.getBoundType().getName());
						}
						label.setDescription(getHtmlDetails(ctBean));
						return label;
					}
				});
				table.addGeneratedColumn("enumeration", new Table.ColumnGenerator() {
					@Override
					public Object generateCell(Table source, Object itemId, Object columnId) {
						BeanItem<ComponentTypeBean> item = data.getItem(itemId);
						final ComponentTypeBean ctBean = item.getBean();
						Label label = new Label("");
						if (ctBean.getBoundType() != null) {
							label = new Label(ctBean.getEnumerationAsString());
						}
						label.setDescription(getHtmlDetails(ctBean));
						return label;
					}
				});
				table.addGeneratedColumn("references", new Table.ColumnGenerator() {
					@Override
					public Object generateCell(Table source, Object itemId, Object columnId) {
						BeanItem<ComponentTypeBean> item = data.getItem(itemId);
						final ComponentTypeBean ctBean = item.getBean();
						Label label = new Label(ctBean.getReferencesAsString(), Label.CONTENT_RAW);
						label.setDescription(getHtmlDetails(ctBean));
						return label;
					}
				});
				HorizontalLayout hl = new HorizontalLayout();
				hl.setWidth("100%");
				// help
				HelpPanel help = new HelpPanel(msg.get("help.1"));
				hl.addComponent(help);
				hl.setComponentAlignment(help, Alignment.TOP_RIGHT);
				// Create
				Button create = getCreateButton();
				hl.addComponent(create);
				hl.setComponentAlignment(create, Alignment.TOP_RIGHT);
				// Global aggregation
				addComponent(hl);
				hl.setExpandRatio(help, 0.9f);
				setComponentAlignment(hl, Alignment.TOP_RIGHT);
				addComponent(new Label("<br/>", Label.CONTENT_RAW));
				addComponent(table);
			}
		} catch (FunctionalException e) {
			logger.log(Level.SEVERE, e.getDetailedMessage(), e);
			getWindow().showNotification(msg.humanMessage(e), Notification.TYPE_ERROR_MESSAGE);
		}
	}

	private void drop(final ComponentTypeBean ctBean) {
		ConfirmDialog.show(getApplication().getMainWindow(), msg.get("confirm.1") + " " + msg.get("confirm.2"),
				new ConfirmDialog.Listener() {
					public void onClose(ConfirmDialog dialog) {
						if (dialog.isConfirmed()) {
							try {
								ComponentTypeDTO ctDTO = toDTO.getComponentTypeDTO(ctBean);
								serviceCT.deleteCT(null, ctDTO);
								removeAllComponents();
								attach();
							} catch (FunctionalException e) {
								logger.log(Level.SEVERE, e.getDetailedMessage(), e.getCause());
								getWindow().showNotification(msg.humanMessage(e), Notification.TYPE_ERROR_MESSAGE);
							}
						}
					}
				});
	}

	/**
	 * Return HTML tooltip for a CT
	 * 
	 * @param bean
	 * @return HTML tooltip for a CT
	 */
	private String getHtmlDetails(ComponentTypeBean bean) {
		String out = "<b>" + msg.get("gal.1") + " : </b>";
		out += bean.getDescription();
		out += "</br></br>";
		if (!Strings.isNullOrEmpty(bean.getComment())) {
			out += "<b>" + msg.get("gal.11") + " : </b>";
			out += bean.getComment();
			out += "</br></br>";
		}
		if (!Strings.isNullOrEmpty(bean.getTags())) {
			out += "<b>" + msg.get("gal.4") + " : </b>";
			out += bean.getTags();
			out += "</br></br>";
		}
		if (bean.getBoundType() != null) {
			out += "<b>" + msg.get("pr.36") + " : </b>";
			out += bean.getViewPoint().getName() + "/ " + bean.getBoundType().getName();
			out += "</br></br>";
		}
		if (bean.getEnumeration().size() > 0) {
			out += "<b>" + msg.get("pr.32") + " : </b>";
			out += bean.getEnumerationAsString();
			out += "</br></br>";
		}
		if (bean.getReferences().size() > 0) {
			out += "<b>" + msg.get("pr.33") + " : </b>";
			out += bean.getReferencesAsString();
			out += "</br></br>";
		}
		return out;
	}

	private Button getCreateButton() {
		Button create = new Button(msg.get("pr.34"));
		create.setStyleName(BaseTheme.BUTTON_LINK);
		create.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// CT with null ID means "new CT"
				ComponentTypeBean bean = new ComponentTypeBean();
				ComponentTypeDialog dialog = factory.getComponentTypeDialogFor(new BeanItem<ComponentTypeBean>(bean));
				dialog.setModal(true);
				getWindow().addWindow(dialog);
			}
		});
		return create;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.presentation.events.Observer#update(org.m2ling.presentation.events.Event)
	 */
	@Override
	public void update(org.m2ling.presentation.events.Event event) {
		// Forced refresh of a ct (mainly after an error, otherwise, the table is synchronized with the dialog using
		// regular container/beanitem references)
		if (event.getSubject() == Events.CT_CHANGE && event.getDetails().get(Events.DETAIL_VP.name()).equals(vpID)) {
			removeAllComponents();
			attach();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.presentation.events.Observer#getRegistrationKeys()
	 */
	@Override
	public Set<Events> getRegistrationKeys() {
		Set<Events> events = new HashSet<Events>();
		events.add(Events.CT_CHANGE);
		return events;
	}
}
