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
import com.google.inject.servlet.SessionScoped;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 * Main m2principles panel
 */
@SessionScoped
public class PrinciplesMainFrame extends Panel {

	private static final long serialVersionUID = -3580103313824507265L;

	private List<ViewPointDTO> vps;
	
	private ViewPointService vpService;
	
	@Inject
	public PrinciplesMainFrame(ViewPointService vpService){
		this.vpService = vpService;
		populate();
	}
	
	/**
	 * Populate the panel with actual viewpoints. 
	 * Can take a while as it calls services.
	 */
	public void populate(){
		//vps = vpService.getAllViewPoints();
		vps = new ArrayList<ViewPointDTO>();
		if (vps.size() == 0){
			Label noneVPLabel = new Label("");
			noneVPLabel.setSizeFull();
			noneVPLabel.setIcon(new ThemeResource("img/information.png"));
			// Use caption to set text to keep icon and label on the same line
			noneVPLabel.setCaption("None view point found. View points creation are available from the view point tree on the left sidebar.");
			addComponent(noneVPLabel);
		}
	}
	
}
