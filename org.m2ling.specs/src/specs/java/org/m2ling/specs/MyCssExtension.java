/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
package org.m2ling.specs;

import org.concordion.api.Resource;
import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;

public class MyCssExtension implements ConcordionExtension {
	@Override
	public void addTo(ConcordionExtender concordionExtender) {
		concordionExtender.withLinkedCSS("/m2ling_specs.css", new Resource("/m2ling_specs.css"));
	}
}