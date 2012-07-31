/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.widgets;

import org.m2ling.presentation.i18n.Msg;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

/**
 * OK Cancel panel
 */
public class OKCancel extends CustomComponent {
	private static final long serialVersionUID = -5102018433538734852L;
	private Button okButton;
	private Button cancelButton;

	/**
	 * Build a OKCancel panel
	 * 
	 * @param ok
	 *           what to do when clicking on "ok"
	 * @param cancel
	 *           what to do when clicking on "cancel"
	 */
	@SuppressWarnings("serial")
	public OKCancel(final Command ok, final Command cancel) {
		HorizontalLayout hz = new HorizontalLayout();
		hz.setSpacing(true);
		hz.setMargin(true);
		okButton = new Button(Msg.get("gal.5"), new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				try {
					// Makes sure user can't click anymore
					okButton.setDisableOnClick(true);
					ok.execute();
				} finally {
					okButton.setDisableOnClick(false);
				}
			}
		});
		okButton.setIcon(new ThemeResource("../runo/icons/16/ok.png"));
		cancelButton = new Button(Msg.get("gal.6"), new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				cancel.execute();
			}
		});
		cancelButton.setIcon(new ThemeResource("img/16/cancel.png"));
		hz.addComponent(okButton);
		hz.addComponent(cancelButton);
		hz.setSizeUndefined();
		setSizeUndefined();
		setCompositionRoot(hz);
	}
}
