package org.m2ling.presentation.principles;

import org.m2ling.presentation.principles.widgets.AccordionEntry;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.themes.BaseTheme;

@SuppressWarnings("serial")
public class FeaturesEntry extends AccordionEntry {

	public FeaturesEntry() {
		super();
	}

	@Override
	public void attach() {
		Panel features = new Panel();
		Button create = new Button("Create a view point", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				ViewPointDialog vpDialog = new ViewPointDialog(null);
				vpDialog.setModal(true);
				getWindow().addWindow(vpDialog);
			}
		});
		create.setStyleName(BaseTheme.BUTTON_LINK);
		features.setSizeFull();
		features.addComponent(create);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.presentation.principles.widgets.AccordionEntry#getLabel()
	 */
	@Override
	public String getLabel() {
		return "Features";
	}
}
