/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.persistence;

import org.m2ling.domain.core.CoreFactory;
import org.m2ling.domain.core.Root;

/**
 * Provide a model root
 * TODO : replace this by several injected implemntations :
 * - A in-memory void model
 * - A file-based read-only mock  implementation
 * - The production implementation based upon Teneo / database
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 *
 */
public class ModelFactory {
	
	private static Root root = CoreFactory.eINSTANCE.createRoot();
	
	public static Root getRoot(){
		return root;
	}

}
