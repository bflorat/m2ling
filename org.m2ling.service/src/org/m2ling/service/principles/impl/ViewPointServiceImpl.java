/**
 * Copyright (C) Bertrand Florat
 */
package org.m2ling.service.principles.impl;

import java.util.Collections;
import java.util.List;

import org.m2ling.domain.core.ViewPoint;
import org.m2ling.service.principles.ViewPointService;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public final class ViewPointServiceImpl implements ViewPointService {
	
	@Inject
	ViewPointServiceImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see org.m2ling.service.principles.ViewPointService#createViewPoint(java.lang.String)
	 */
	public ViewPoint createViewPoint(String name){
		//TODO
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.m2ling.service.principles.ViewPointService#getAllViewPoints()
	 */
	public List<ViewPoint> getAllViewPoints(){
		//TODO
		return Collections.emptyList();
	}

	/* (non-Javadoc)
	 * @see org.m2ling.service.principles.ViewPointService#getViewpointByName(java.lang.String)
	 */
	@Override
	public ViewPoint getViewpointByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
