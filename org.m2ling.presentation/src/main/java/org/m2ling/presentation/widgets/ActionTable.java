/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.widgets;

import java.util.Map;
import java.util.Set;

import org.m2ling.presentation.i18n.Msg;

import com.vaadin.data.Container;
import com.vaadin.event.Action;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 * Action table is a extended table providing following features : <u>
 * 
 * <li>An action selector (displayed as a combo box) with a list of possible actions to perform
 * against selected rows. Two actions are always provided by default (displayed at first) :
 * "Select All" and "Select none""</li>
 * 
 * <li>Sortable</li>
 * 
 * <li>Read-only (user has to click on the ID row to display a dialog)</li> element to show the
 * associated dialog</li>
 * 
 * Note that data should contain a boolean column to manage the row selection. </u>
 */
@SuppressWarnings("serial")
public class ActionTable extends CustomComponent {
	private final Table table;
	private final ComboBox actions;
	private final Container data;
	private final Map<String, Command> actionsCommands;
	private final int idColumn;
	private final Map<String, ClickListener> idEvents;
	

	/**
	 * Build an Action table
	 * 
	 * 
	 * @param data
	 *           table data container
	 * @param actionsCommands
	 *           maps some actions displayed in the action selector combo box with associated command
	 *           (action) to perform against selected rows
	 * @param idColumn
	 *           set the prperty ID of the column representing the row ID. This column will be displayed
	 *           as a Link.
	 * @param idEvents
	 *           maps the element Id with something to be done on click.
	 */
	public ActionTable(Container data, Map<String, Command> actionsCommands, int idColumn,
			Map<String, ClickListener> idEvents) {
		this.actionsCommands=actionsCommands;
		this.idColumn = idColumn;
		this.idEvents=idEvents;
		this.data = data;
		VerticalLayout vl = new VerticalLayout();
		vl.setSpacing(true);
		vl.setMargin(true);
		table = new Table(null, data);
		actions = new ComboBox();
		vl.addComponent(actions);
		vl.addComponent(table);
		vl.setSizeUndefined();
		setSizeUndefined();
		setCompositionRoot(vl);
	}
	
/*	private Container buildActionsContainer(actionsC){
		
	}*/
}
