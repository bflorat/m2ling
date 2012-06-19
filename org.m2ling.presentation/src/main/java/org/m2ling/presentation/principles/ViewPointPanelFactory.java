/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import org.m2ling.presentation.principles.model.ViewPointBean;
import org.m2ling.presentation.principles.widgets.ViewPointPanel;

/**
 * Produces viewpoint panels using the assisted injection pattern
 */
public interface ViewPointPanelFactory {

	
	ViewPointPanel getViewPointPanelFor(ViewPointBean bean);

}
