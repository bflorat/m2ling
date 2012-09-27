/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.presentation.principles.utils;

import java.io.File;
import java.io.FilenameFilter;

import org.m2ling.common.configuration.Conf;

/**
 * Manages icons
 */
public class IconManager {
	/**
	 * Return an icon file or null if it doesn't exist
	 * 
	 * @param prefix
	 *           parent directory path of the icon starting from m2ling home
	 * @param name
	 *           name of the icon file without extension
	 * @return an icon file or null if it doesn't exist
	 */
	public static File getIconFile(String prefix, final String name) {
		File icon = null;
		File iconDir = new File(Conf.getHomeDirectoryPath() + File.separatorChar + prefix);
		String[] matchingFile = iconDir.list(new FilenameFilter() {
			public boolean accept(File dir, String tested) {
				if (tested.contains(name)) {
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