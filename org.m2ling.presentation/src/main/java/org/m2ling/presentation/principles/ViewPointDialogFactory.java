/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles;

import org.m2ling.presentation.principles.model.ViewPointBean;

/**
 * Produces viewpoint dialogs using the assisted injection pattern
 */
public interface ViewPointDialogFactory {
	/**
	 * Build a ViewPointDialog for given arguments
	 * 
	 * @param bean
	 *           the viewpoint bean encapsulating all VP data
	 * @return a ViewPointDialog for given arguments
	 */
	ViewPointDialog getViewPointDialogFor(ViewPointBean bean);
}
