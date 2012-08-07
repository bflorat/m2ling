/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.utils;

import java.io.File;
import java.io.FilenameFilter;

import org.m2ling.common.configuration.Conf;
import org.m2ling.common.utils.Consts;
import org.m2ling.presentation.principles.model.ViewPointBean;

/**
 * Manages icons
 */
public class IconManager {
	/**
	 * Return matching icon file for given bean id or null of none.
	 * 
	 * @return icon file for given bean id or null of none
	 */
	public static File getVPIconFile(final ViewPointBean bean) {
		File iconDir = new File(Conf.getHomeDirectoryPath() + File.separatorChar + Consts.CONF_VP_ICONS_LOCATION);
		File icon = null;
		String[] matchingFile = iconDir.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if (name.matches(bean.getId() + ".*")) {
					return true;
				}
				return false;
			}
		});
		if (matchingFile == null) {
			return null;
		}
		if (matchingFile.length > 0) {
			icon = new File(iconDir.getAbsolutePath() + File.separatorChar + matchingFile[0]);
		}
		return icon;
	}
}
