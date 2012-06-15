/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.widgets;

import java.io.File;
import java.util.logging.Logger;

import org.m2ling.presentation.principles.ViewPointDialog;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.utils.IconManager;

import com.vaadin.terminal.FileResource;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

/**
 * View point summary
 */
@SuppressWarnings("serial")
public class ViewPointPanel extends Panel {

	private final Logger logger;

	private final VerticalLayout vert;

	private final ViewPointBean bean;

	/**
	 * Build an VP panel
	 * 
	 * @param vp
	 *           the associated view point
	 * @throws IllegalArgumentException
	 *            if bean is null
	 */
	public ViewPointPanel(ViewPointBean bean, Logger logger) {
		super();
		this.logger = logger;
		this.bean = bean;
		if (bean == null) {
			throw new IllegalArgumentException("Null viewpoint");
		}
		vert = (VerticalLayout) getContent();
		vert.setSpacing(true);
		vert.setMargin(true);
		vert.setSizeUndefined();
		setStyleName("principles_vp-panel");
	}

	@Override
	public void attach() {
		super.attach();

		// Build icon if any or use default icon otherwise
		Embedded icon = null;
		File iconFile = IconManager.getVPIconFile(bean);
		Resource res = null;
		if (iconFile != null) {
			res = new FileResource(iconFile, getApplication());
		} else {
			res = new ThemeResource("img/256/view_point_default.png");
		}
		icon = new Embedded("", res);
		icon.setWidth("50px");
		icon.setHeight("50px");
		icon.requestRepaint();
		
		// Name
		Label name = new Label(bean.getName());
		name.setStyleName("principles_vp-panel-name");
		name.setSizeUndefined();
		Button edit = new Button("Edit");
		edit.setStyleName(BaseTheme.BUTTON_LINK);
		edit.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				ViewPointDialog vpDialog = new ViewPointDialog(bean);
				vpDialog.setModal(true);
				getWindow().addWindow(vpDialog);
			}
		});

		Button delete = new Button("Delete");
		delete.setStyleName(BaseTheme.BUTTON_LINK);
		delete.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO
			}
		});

		Button rules = new Button("Rules");
		rules.setStyleName(BaseTheme.BUTTON_LINK);
		rules.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO
			}
		});

		Button activities = new Button("Activities");
		activities.setStyleName(BaseTheme.BUTTON_LINK);
		activities.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO
			}
		});

		Button componentTypes = new Button("Component types");
		componentTypes.setStyleName(BaseTheme.BUTTON_LINK);
		componentTypes.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO
			}
		});

		Button linkTypes = new Button("Link types");
		linkTypes.setStyleName(BaseTheme.BUTTON_LINK);
		linkTypes.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO
			}
		});

		// Layout
		HorizontalLayout hl1 = new HorizontalLayout();
		hl1.setSpacing(true);
		hl1.addComponent(icon);
		hl1.setComponentAlignment(icon, Alignment.MIDDLE_RIGHT);
		hl1.addComponent(name);
		hl1.setComponentAlignment(name, Alignment.MIDDLE_RIGHT);
		hl1.addComponent(edit);
		hl1.addComponent(delete);
	
		HorizontalLayout hl2 = new HorizontalLayout();
		hl2.setSpacing(true);
		hl2.addComponent(componentTypes);
		hl2.addComponent(linkTypes);
		hl2.addComponent(rules);
		hl2.addComponent(activities);
		addComponent(hl1);
		addComponent(hl2);
	}

}
