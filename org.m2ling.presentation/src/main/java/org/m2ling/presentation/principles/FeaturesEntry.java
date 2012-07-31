package org.m2ling.presentation.principles;

import org.m2ling.presentation.i18n.Msg;
import org.m2ling.presentation.widgets.SidebarEntry;

import com.google.inject.Inject;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.BaseTheme;

@SuppressWarnings("serial")
public class FeaturesEntry extends SidebarEntry {
	ViewPointDialogFactory factory;

	@Inject
	public FeaturesEntry(ViewPointDialogFactory factory) {
		super();
		this.factory = factory;
		setSizeFull();
	}

	@Override
	public void attach() {
		// Make sure to reset all previously displayed items
		removeAllComponents();
		Button create = new Button(Msg.get("pr.2"), new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				ViewPointDialog vpDialog = factory.getViewPointDialogFor(null);
				vpDialog.setModal(true);
				getWindow().addWindow(vpDialog);
			}
		});
		create.setStyleName(BaseTheme.BUTTON_LINK);
		addComponent(create);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.presentation.principles.widgets.AccordionEntry#getLabel()
	 */
	@Override
	public String getLabel() {
		return Msg.get("pr.3");
	}
}
