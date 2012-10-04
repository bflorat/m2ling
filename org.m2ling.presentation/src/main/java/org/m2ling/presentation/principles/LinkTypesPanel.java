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

import org.m2ling.common.dto.core.LinkTypeDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.presentation.events.Events;
import org.m2ling.presentation.events.ObservationManager;
import org.m2ling.presentation.events.Observer;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.HasNameAndIDBean;
import org.m2ling.presentation.principles.model.LinkTypeBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.presentation.widgets.HelpPanel;
import org.m2ling.service.principles.LinkTypeService;
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
 * List all link types (LT) for a given viewpoint
 */
@SuppressWarnings("serial")
public class LinkTypesPanel extends VerticalLayout implements Observer {
	private final String vpID;

	private final LinkTypeService serviceLT;

	private final Logger logger;

	private final DTOConverter.ToDTO toDTO;

	private final DTOConverter.FromDTO fromDTO;

	// private final RuleDialogFactory factory;
	private final Msg msg;

	private final PrinciplesGUIFactory factory;

	/** Current data **/
	private BeanContainer<String, LinkTypeBean> data;

	@Inject
	public LinkTypesPanel(Logger logger, @Assisted String vpID, LinkTypeService serviceLT, DTOConverter.ToDTO toDTO,
			DTOConverter.FromDTO fromDTO, Msg msg, ObservationManager obs, PrinciplesGUIFactory factory) {
		super();
		this.vpID = vpID;
		this.serviceLT = serviceLT;
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
			List<LinkTypeDTO> lts = serviceLT.getAllLT(null, vpID);
			if (lts.size() == 0) {
				addComponent(new HelpPanel(msg.get("help.2")));
				addComponent(new Label(msg.get("pr.44")));
				Button create = getCreateButton();
				addComponent(create);
				setComponentAlignment(create, Alignment.TOP_RIGHT);
			} else {
				data = new BeanContainer<String, LinkTypeBean>(LinkTypeBean.class);
				data.setBeanIdProperty("id");
				for (LinkTypeDTO dto : lts) {
					LinkTypeBean ctBean = fromDTO.getLinkTypeBean(dto);
					data.addBean(ctBean);
				}
				final Table table = new Table(null, data);
				table.setWidth("100%");
				// We set a guess height for table depending on the nb of items + a fixed size for the
				// header
				// Note that UNITS_EM doesn't work for some reasons and that a row can be multi-lines.
				table.setHeight(lts.size() * 40 + 10, UNITS_PIXELS);
				table.setVisibleColumns(new String[] { "drop", "name", "description", "linkTemporality", "linkAccessType",
						"sourcesTypes", "destinationsTypes", "tags" });
				table.setColumnExpandRatio("description", 0.6f);
				table.setColumnExpandRatio("sourcesTypes", 0.2f);
				table.setColumnExpandRatio("destinationsTypes", 0.2f);
				table.setItemDescriptionGenerator(new ItemDescriptionGenerator() {
					public String generateDescription(Component source, Object itemId, Object propertyId) {
						LinkTypeBean bean = (LinkTypeBean) data.getItem(itemId).getBean();
						return getHtmlDetails(bean);
					}
				});
				table.setColumnHeaders(new String[] { msg.get("gal.3"), msg.get("gal.12"),
						msg.get("gal.1") + " (" + msg.get("gal.10") + ")", msg.get("pr.45"), msg.get("pr.46"),
						msg.get("pr.47"), msg.get("pr.48"), msg.get("gal.4") });
				table.addGeneratedColumn("name", new Table.ColumnGenerator() {
					public Component generateCell(Table table, Object itemId, Object columnId) {
						final BeanItem<LinkTypeBean> item = data.getItem(itemId);
						Button edit = new Button(item.getBean().getName());
						edit.setStyleName(BaseTheme.BUTTON_LINK);
						edit.addListener(new Button.ClickListener() {
							public void buttonClick(ClickEvent event) {
								LinkTypeDialog dialog = factory.getLinkTypeDialogFor(item);
								dialog.setModal(true);
								getWindow().addWindow(dialog);
							}
						});
						return edit;
					}
				});
				table.addGeneratedColumn("drop", new Table.ColumnGenerator() {
					public Component generateCell(Table table, Object itemId, Object columnId) {
						BeanItem<LinkTypeBean> item = data.getItem(itemId);
						final LinkTypeBean ctBean = item.getBean();
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
				table.addGeneratedColumn("sourcesTypes", new Table.ColumnGenerator() {
					@Override
					public Object generateCell(Table source, Object itemId, Object columnId) {
						BeanItem<LinkTypeBean> item = data.getItem(itemId);
						final LinkTypeBean ltBean = item.getBean();
						Label label = new Label(ltBean.getSourcesTypesAsString());
						label.setDescription(getHtmlDetails(ltBean));
						return label;
					}
				});
				table.addGeneratedColumn("destinationsTypes", new Table.ColumnGenerator() {
					@Override
					public Object generateCell(Table source, Object itemId, Object columnId) {
						BeanItem<LinkTypeBean> item = data.getItem(itemId);
						final LinkTypeBean ltBean = item.getBean();
						Label label = new Label(ltBean.getDestinationsTypesAsString());
						label.setDescription(getHtmlDetails(ltBean));
						return label;
					}
				});
				HorizontalLayout hl = new HorizontalLayout();
				hl.setWidth("100%");
				// help
				HelpPanel help = new HelpPanel(msg.get("help.2"));
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

	private void drop(final LinkTypeBean ctBean) {
		ConfirmDialog.show(getApplication().getMainWindow(), msg.get("confirm.1") + " " + msg.get("confirm.2"),
				new ConfirmDialog.Listener() {
					public void onClose(ConfirmDialog dialog) {
						if (dialog.isConfirmed()) {
							try {
								LinkTypeDTO ctDTO = toDTO.getLinkTypeDTO(ctBean);
								serviceLT.deleteLT(null, ctDTO);
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
	private String getHtmlDetails(LinkTypeBean bean) {
		String out = "<b>" + msg.get("gal.1") + " : </b>";
		out += bean.getDescription();
		out += "</br></br>";
		// temporality
		out += "<b>" + msg.get("pr.45") + " : </b>";
		out += bean.getLinkTemporality();
		out += "</br></br>";
		// Access type
		out += "<b>" + msg.get("pr.46") + " : </b>";
		out += bean.getLinkAccessType();
		out += "</br></br>";
		// Sources
		out += "<b>" + msg.get("pr.47") + " : </b>";
		out += bean.getSourcesTypesAsString();
		out += "</br></br>";
		// Destinations
		out += "<b>" + msg.get("pr.48") + " : </b>";
		out += bean.getDestinationsTypesAsString();
		out += "</br></br>";
		// Comments
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
		return out;
	}

	private Button getCreateButton() {
		Button create = new Button(msg.get("pr.49"));
		create.setStyleName(BaseTheme.BUTTON_LINK);
		create.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// lt with null ID means "new LT"
				LinkTypeBean bean = new LinkTypeBean();
				HasNameAndIDBean vp = HasNameAndIDBean.newInstance(vpID, null);
				bean.setViewPoint(vp);
				LinkTypeDialog dialog = factory.getLinkTypeDialogFor(new BeanItem<LinkTypeBean>(bean));
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
		// Forced refresh of a lt (mainly after an error, otherwise, the table is synchronized with
		// the dialog using
		// regular container/beanitem references)
		if (event.getSubject() == Events.LT_CHANGE && event.getDetails().get(Events.DETAIL_VP.name()).equals(vpID)) {
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
		events.add(Events.LT_CHANGE);
		return events;
	}
}
