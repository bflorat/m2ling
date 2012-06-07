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
import com.vaadin.ui.Window;

/**
 * Main m2principles panel
 */
public class PrinciplesMainFrame extends VerticalLayout {

	private static final long serialVersionUID = -3580103313824507265L;

	private List<ViewPointDTO> vps;
	
	private ViewPointService vpService;
	
	@Inject
	public PrinciplesMainFrame(ViewPointService vpService){
		this.vpService = vpService;
		setSizeFull();
		setSpacing(false);
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
			noneVPLabel.setSizeUndefined();
			noneVPLabel.setIcon(new ThemeResource("img/16/information.png"));
			// Use caption to set text to keep icon and label on the same line
			noneVPLabel.setCaption("None view point found.");
			Button create = new Button("Create a view point",new Button.ClickListener() {
				
				public void buttonClick(ClickEvent event) {
					Window vpDialog = new ViewPointDialog(null);
					vpDialog.setModal(true);
					getWindow().addWindow(vpDialog);
					
				}
			});
			addComponent(noneVPLabel);
			setComponentAlignment(noneVPLabel, Alignment.MIDDLE_CENTER);
			addComponent(create);
			setComponentAlignment(create, Alignment.MIDDLE_CENTER);
		}
	}
	
}
