/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.Stakeholder;
import org.m2ling.domain.core.Tag;
import org.m2ling.domain.core.TagGroup;
import org.m2ling.domain.core.View;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.service.principles.ViewPointService;

import com.google.inject.Singleton;

/**
 * @author Bertrand Florat <bertrand@florat.net>
 * 
 */
@Singleton
public final class ViewPointServiceMockImpl implements ViewPointService {

	/** A predefined list of mock viewpoints */
	private final Map<String, ViewPoint> mockVPs = new HashMap<String, ViewPoint>();

	/** A predefined list of mock views */
	private final Map<String, View> mockViews = new HashMap<String, View>();

	/** A predefined list of mock stakeholders */
	private final Map<String, Stakeholder> mockStakeholders = new HashMap<String, Stakeholder>();

	ViewPointServiceMockImpl() {
		super();
		populateViewPoints();
		populateViews();
	}

	private void populateViewPoints() {
		// Project architecture viewpoint (application / technical layers)
		ViewPoint vpApp = CoreFactory.eINSTANCE.createViewPoint();
		vpApp.setName("Project Architecture");
		mockVPs.put(vpApp.getName(), vpApp);
	}

	private void populateViews() {
		// Create some views
		View vBikesOnline = CoreFactory.eINSTANCE.createView();
		vBikesOnline.setName("BikesOnline");
		// create a tag to tell this is an "online" app,
		// we may get another "offline" tag for others views.
		Tag tag = CoreFactory.eINSTANCE.createTag();
		tag.setText("online");
		vBikesOnline.getTags().add(tag);
		// create a tag group of the same dimension : the organization
		// this view is built by "Dev1" team and exploited by "Op2" team.
		TagGroup group = CoreFactory.eINSTANCE.createTagGroup();
		Tag tag1 = CoreFactory.eINSTANCE.createTag();
		tag1.setText("Dev1");
		Tag tag2 = CoreFactory.eINSTANCE.createTag();
		tag2.setText("Op2");
		group.getTags().add(tag1);
		group.getTags().add(tag2);
		vBikesOnline.getTagGroups().add(group);
	}
	
	private void populateStakeHolders() {
	//	Stakeholder vpApp = CoreFactory.eINSTANCE.createViewPoint();
	//	vpApp.setName("Project Architecture");
	//	mockVPs.put(vpApp.getName(), vpApp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.ViewPointService#createViewPoint(java.lang.String)
	 */
	public ViewPoint createViewPoint(String name) {
		// This mock implementation can't actually create viewpoints for now.
		throw new IllegalStateException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.ViewPointService#getAllViewPoints()
	 */
	public List<ViewPoint> getAllViewPoints() {
		return new ArrayList<ViewPoint>(mockVPs.values());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.m2ling.service.principles.ViewPointService#getViewpointByName(java.lang.String)
	 */
	@Override
	public ViewPoint getViewPointByName(String name) {
		return mockVPs.get(name);
	}

}
