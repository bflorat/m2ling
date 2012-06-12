/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.ArrayList;
import java.util.List;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.service.principles.ViewPointService;

import com.google.inject.Inject;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

/**
 * Main m2principles panel
 */
public class PrinciplesMainFrame extends VerticalLayout {

	private static final long serialVersionUID = -3580103313824507265L;

	private List<ViewPointDTO> vps;

	private ViewPointService vpService;

	@Inject
	public PrinciplesMainFrame(ViewPointService vpService) {
		this.vpService = vpService;
		setSizeFull();
		setSpacing(false);
		populate();
	}

	/**
	 * Populate the panel with actual viewpoints. Can take a while as it calls services.
	 */
	public void populate() {
		vps = vpService.getAllViewPoints();
		if (vps.size() == 0) {
			VerticalLayout vert = getNoneVPPanel();
			addComponent(vert);
			setComponentAlignment(vert, Alignment.MIDDLE_CENTER);
		} else {
			addComponent(new Label(vps.toString()));
		}
	}

	private VerticalLayout getNoneVPPanel() {
		VerticalLayout vert = new VerticalLayout();
		vert.setSizeUndefined();
		vert.setSpacing(true);
		Label noneVPLabel = new Label("");
		noneVPLabel.setSizeUndefined();
		noneVPLabel.setIcon(new ThemeResource("img/16/information.png"));
		// Use caption to set text to keep icon and label on the same line
		noneVPLabel.setCaption("None view point found");
		Button create = new Button("Create a view point", new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				ViewPointDialog vpDialog = new ViewPointDialog(null);
				vpDialog.setModal(true);
				getWindow().addWindow(vpDialog);
			}
		});
		create.setStyleName(BaseTheme.BUTTON_LINK);

		vert.addComponent(noneVPLabel);
		vert.addComponent(create);
		return vert;
	}
}
