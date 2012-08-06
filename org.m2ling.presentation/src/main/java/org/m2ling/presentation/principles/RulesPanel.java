/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.m2ling.common.dto.core.RuleDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.RuleBean;
import org.m2ling.presentation.principles.utils.DTOConverter;
import org.m2ling.service.principles.RuleService;
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
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.themes.BaseTheme;

/**
 * List all rules for a given viewpoint
 */
@SuppressWarnings("serial")
public class RulesPanel extends VerticalLayout {
	private final String vpID;
	private final RuleService service;
	private final Logger logger;
	private final DTOConverter.ToDTO toDTO;
	private final DTOConverter.FromDTO fromDTO;
	private final RuleDialogFactory factory;

	/**
	 * Build a rules dialog
	 * 
	 */
	@Inject
	public RulesPanel(Logger logger, @Assisted String vpID, RuleService service, DTOConverter.ToDTO toDTO,
			DTOConverter.FromDTO fromDTO, RuleDialogFactory factory) {
		super();
		this.vpID = vpID;
		this.service = service;
		this.factory = factory;
		this.logger = logger;
		this.toDTO = toDTO;
		this.fromDTO = fromDTO;
		setHeight(null);
		setWidth("98%");
		setMargin(true);
	}

	@Override
	public void attach() {
		try {
			List<RuleDTO> rules = service.getAllRules(null, vpID);
			if (rules.size() == 0) {
				addComponent(new Label(Msg.get("pr.1")));
				Button create = getCreateRuleButton();
				addComponent(create);
				setComponentAlignment(create, Alignment.TOP_RIGHT);
			} else {
				BeanContainer<String, RuleBean> data = new BeanContainer<String, RuleBean>(RuleBean.class);
				data.setBeanIdProperty("id");
				for (RuleDTO dto : rules) {
					RuleBean rule = fromDTO.getRuleBean(dto);
					data.addBean(rule);
				}
				final Table table = new Table(null, data);
				table.setWidth("100%");
				table.setHeight("300px");
				table.setVisibleColumns(new String[] { "drop", "name", "status", "priority", "description" });
				table.setColumnExpandRatio("description", 1);
				table.setItemDescriptionGenerator(new ItemDescriptionGenerator() {
					public String generateDescription(Component source, Object itemId, Object propertyId) {
						@SuppressWarnings("unchecked")
						BeanContainer<String, RuleBean> data = (BeanContainer<String, RuleBean>) table
								.getContainerDataSource();
						RuleBean bean = (RuleBean) data.getItem(itemId).getBean();
						return getHtmlDetails(bean);
					}
				});
				table.setColumnHeaders(new String[] { Msg.get("gal.3"), Msg.get("gal.12"), Msg.get("gal.7"),
						Msg.get("gal.8"), Msg.get("gal.1") + " (" + Msg.get("gal.10") + ")", });
				table.addGeneratedColumn("name", new Table.ColumnGenerator() {
					public Component generateCell(Table table, Object itemId, Object columnId) {
						@SuppressWarnings("unchecked")
						BeanContainer<String, RuleBean> data = (BeanContainer<String, RuleBean>) table
								.getContainerDataSource();
						BeanItem<RuleBean> item = data.getItem(itemId);
						final RuleBean bean = item.getBean();
						Button edit = new Button(bean.getName());
						edit.setStyleName(BaseTheme.BUTTON_LINK);
						edit.addListener(new Button.ClickListener() {
							public void buttonClick(ClickEvent event) {
								RuleDialog dialog = factory.getRuleDialogFor(bean);
								dialog.setModal(true);
								getWindow().addWindow(dialog);
							}
						});
						return edit;
					}
				});
				table.addGeneratedColumn("drop", new Table.ColumnGenerator() {
					public Component generateCell(Table table, Object itemId, Object columnId) {
						@SuppressWarnings("unchecked")
						BeanContainer<String, RuleBean> data = (BeanContainer<String, RuleBean>) table
								.getContainerDataSource();
						BeanItem<RuleBean> item = data.getItem(itemId);
						final RuleBean rule = item.getBean();
						NativeButton drop = new NativeButton("");
						drop.setSizeFull();
						drop.setStyleName("borderless");
						drop.setIcon(new ThemeResource("img/16/delete.png"));
						drop.addListener(new Button.ClickListener() {
							public void buttonClick(ClickEvent event) {
								dropRule(rule);
							}
						});
						return drop;
					}
				});
				Button create = getCreateRuleButton();
				addComponent(create);
				setComponentAlignment(create, Alignment.TOP_RIGHT);
				addComponent(new Label("<br/>",Label.CONTENT_RAW));
				addComponent(table);
			}
		} catch (FunctionalException e) {
			logger.log(Level.SEVERE, e.getDetailedMessage(), e);
			getWindow().showNotification(Msg.humanMessage(e), Notification.TYPE_ERROR_MESSAGE);
		}
	}

	private void dropRule(final RuleBean rule) {
		ConfirmDialog.show(getApplication().getMainWindow(), Msg.get("confirm.1") + " " + Msg.get("confirm.2"),
				new ConfirmDialog.Listener() {
					public void onClose(ConfirmDialog dialog) {
						if (dialog.isConfirmed()) {
							try {
								RuleDTO ruleDTO = toDTO.getRuleDTO(rule);
								service.deleteRule(null, ruleDTO);
								removeAllComponents();
								attach();
							} catch (FunctionalException e) {
								logger.log(Level.SEVERE, e.getDetailedMessage(), e.getCause());
								getWindow().showNotification(Msg.humanMessage(e), Notification.TYPE_ERROR_MESSAGE);
							}
						}
					}
				});
	}

	/**
	 * Return HTML tooltip for a rule
	 * 
	 * @param bean
	 * @return HTML tooltip for a rule
	 */
	private String getHtmlDetails(RuleBean bean) {
		String out = "<b>" + Msg.get("gal.1") + " : </b>";
		out += bean.getDescription();
		out += "</br></br>";
		out += "<b>Rationale : </b>";
		out += bean.getRationale();
		out += "</br></br>";
		if (!Strings.isNullOrEmpty(bean.getExceptions())) {
			out += "<b>" + Msg.get("pr.23") + " : </b>";
			out += bean.getExceptions();
			out += "</br></br>";
		}
		if (!Strings.isNullOrEmpty(bean.getComment())) {
			out += "<b>" + Msg.get("gal.11") + " : </b>";
			out += bean.getComment();
			out += "</br></br>";
		}
		return out;
	}

	private Button getCreateRuleButton() {
		Button createRule = new Button(Msg.get("pr.16"));
		createRule.setStyleName(BaseTheme.BUTTON_LINK);
		createRule.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// rule with null ID means "new rule". We can't pass null rule because VP'id is got from
				// it
				RuleBean bean = new RuleBean();
				bean.setViewPointId(vpID);
				RuleDialog dialog = factory.getRuleDialogFor(bean);
				dialog.setModal(true);
				getWindow().addWindow(dialog);
			}
		});
		return createRule;
	}
}
