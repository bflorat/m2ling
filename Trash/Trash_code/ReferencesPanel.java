/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import java.util.List;

import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.principles.model.ReferenceBean;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.sun.istack.internal.NotNull;
import com.vaadin.ui.Panel;

/**
 * Editable list of references between component types
 */
@SuppressWarnings("serial")
public class ReferencesPanel extends Panel {
	@Inject
	ReferencesPanel(Msg msg, @Assisted @NotNull List<ReferenceBean> initialReferences) {
		setWidth("100%");
		setHeight("200px");
		setCaption(msg.get("pr.33"));
	}

	@Override
	public void attach() {
	}
}
