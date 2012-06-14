/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.utils.Converter;
import org.m2ling.presentation.principles.widgets.ViewPointPanel;
import org.m2ling.service.principles.ViewPointService;

import com.google.inject.Inject;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

/**
 * Main m2principles panel
 */
public class PrinciplesMainFrame extends Panel {

	private static final long serialVersionUID = -3580103313824507265L;

	private List<ViewPointDTO> vpsDTO;

	private ViewPointService vpService;

	private Button create;

	private Logger logger;

	@Inject
	public PrinciplesMainFrame(ViewPointService vpService, Logger logger) {
		super();
		setSizeFull();
		this.vpService = vpService;
		this.logger = logger;
		((VerticalLayout)getContent()).setSpacing(false);
		populate();
	}

	/**
	 * Populate the panel with actual viewpoints. Can take a while as it calls services.
	 */
	public void populate() {
		vpsDTO = vpService.getAllViewPoints();
		create = new Button("Create a view point", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				ViewPointDialog vpDialog = new ViewPointDialog(null);
				vpDialog.setModal(true);
				getWindow().addWindow(vpDialog);
			}
		});
		create.setStyleName(BaseTheme.BUTTON_LINK);
		if (vpsDTO.size() == 0) {
			VerticalLayout vert = getNoneVPPanel();
			addComponent(vert);
			((VerticalLayout)getContent()).setComponentAlignment(vert, Alignment.MIDDLE_CENTER);
			addComponent(create);
		} else {
			for (ViewPointDTO dto : vpsDTO) {
				ViewPointBean bean = Converter.ViewPointConverter.convertFromDTO(dto);
				addComponent(new ViewPointPanel(bean, logger));
			}
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
		vert.addComponent(noneVPLabel);
		vert.addComponent(create);
		return vert;
	}
}
