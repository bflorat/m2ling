/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.studio;

import org.m2ling.domain.core.ReferenceType;
import org.m2ling.presentation.i18n.Msg;

import com.google.inject.Inject;
import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

/**
 * Studio sidebar
 */
class Sidebar extends VerticalLayout {
	private ComboBox cbViewType;

	private ComboBox cbSortBy;

	private Tree tree;

	private Msg msg;

	@Inject
	public Sidebar(Msg msg) {
		super();
		setSpacing(true);
		setMargin(true);
		setHeight("-1");
		setWidth("100%");
		this.msg = msg;
	}

	public void attach() {
		cbViewType = createShowCombo();
		cbSortBy = createSortByCombo();
		tree= createTree();
		addComponent(cbViewType);
		addComponent(cbSortBy);
		addComponent(tree);
	}

	private ComboBox createShowCombo() {
		ComboBox out = new ComboBox(msg.get("stu.1"));
		out.setWidth("100%");
		out.setHeight("-1");
		out.addItem(msg.get("stu.2"));
		out.addItem(msg.get("stu.3"));
		Item both = out.addItem(msg.get("stu.4"));
		out.select(both);
		return out;
	}

	private ComboBox createSortByCombo() {
		ComboBox out = new ComboBox(msg.get("stu.5"));
		out.setWidth("100%");
		out.setHeight("-1");
		for (ReferenceType refType : ReferenceType.values()) {
			cbSortBy.addItem(refType.name());
		}
		return out;
	}
	
	private Tree createTree(){
		Tree out = new Tree();
		return tree;
	}
}
