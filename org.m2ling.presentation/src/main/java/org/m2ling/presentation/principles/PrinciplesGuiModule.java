/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.presentation.GuiModule;
import org.m2ling.presentation.principles.FeaturesEntry;
import org.m2ling.presentation.principles.ViewPointDialog;
import org.m2ling.presentation.principles.ViewPointDialogFactory;
import org.m2ling.presentation.principles.ViewPointPanelFactory;
import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.utils.Converter;
import org.m2ling.presentation.principles.widgets.AccordionEntry;
import org.m2ling.presentation.principles.widgets.ViewPointPanel;
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
public class PrinciplesGuiModule extends GuiModule {

	private static final long serialVersionUID = -3580103313824507265L;

	private List<ViewPointDTO> vpsDTO;

	private ViewPointService vpService;

	private Button create;

	private Logger logger;

	private FeaturesEntry features;

	private ViewPointDialogFactory dialogFactory;

	private ViewPointPanelFactory panelFactory;

	@Inject
	public PrinciplesGuiModule(ViewPointService vpService, Logger logger, FeaturesEntry features,
			ViewPointDialogFactory dialogFactory, ViewPointPanelFactory panelFactory) {
		super();
		setSizeFull();
		this.vpService = vpService;
		this.logger = logger;
		this.features = features;
		this.dialogFactory = dialogFactory;
		this.panelFactory = panelFactory;
		((VerticalLayout) getContent()).setSpacing(false);
	}

	/**
	 * Populate the panel with actual viewpoints. Can take a while as it calls services.
	 */
	@Override
	public void attach() {
		vpsDTO = vpService.getAllViewPoints();
		create = new Button("Create a view point", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				ViewPointDialog vpDialog = dialogFactory.getViewPointDialogFor(null);
				vpDialog.setModal(true);
				getWindow().addWindow(vpDialog);
			}
		});
		create.setStyleName(BaseTheme.BUTTON_LINK);
		if (vpsDTO.size() == 0) {
			VerticalLayout vert = getNoneVPPanel();
			addComponent(vert);
			((VerticalLayout) getContent()).setComponentAlignment(vert, Alignment.MIDDLE_CENTER);
			addComponent(create);
		} else {
			for (ViewPointDTO dto : vpsDTO) {
				ViewPointBean bean = Converter.ViewPointConverter.convertFromDTO(dto);
				ViewPointPanel panel = panelFactory.getViewPointPanelFor(bean);
				addComponent(panel);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.presentation.GuiModule#getAccordionEntries()
	 */
	@Override
	public List<AccordionEntry> getAccordionEntries() {
		List<AccordionEntry> out = new ArrayList<AccordionEntry>(5);

		// Features entry
		features.setDefaultEntry(true);

		out.add(features);
		return out;
	}

}
