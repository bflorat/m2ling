import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.m2ling.domain.core.RulePriority;

/**
 * Copyright (C) 2012 Bertrand Florat
 *
 * @author "Bertrand Florat <bertrand@florat.net>"
 */
/**
 * This test case intends to check any difference between some domain-layer enums and presentation
 * layer one (they have been duplicated to avoid direct dependency between layers)
 */
public class CheckEnumUnsync {
	@Test
	public void checkRulePriority() {
		org.m2ling.presentation.principles.RulePriority[] presentationPriorities = org.m2ling.presentation.principles.RulePriority
				.values();
		String p = "";
		for (org.m2ling.presentation.principles.RulePriority rp : presentationPriorities) {
			p += rp.name();
		}
		org.m2ling.domain.core.RulePriority[] domainPriority = org.m2ling.domain.core.RulePriority.values();
		String d = "";
		for (RulePriority dp : domainPriority) {
			d += dp.name();
		}
		assertTrue(p.equals(d));
	}

	@Test
	public void checkReferenceType() {
		org.m2ling.presentation.principles.ReferenceType[] presentationReferencesTypes = org.m2ling.presentation.principles.ReferenceType
				.values();
		String p = "";
		for (org.m2ling.presentation.principles.ReferenceType rp : presentationReferencesTypes) {
			p += rp.name();
		}
		org.m2ling.domain.core.ReferenceType[] domainReferenceTypes = org.m2ling.domain.core.ReferenceType.values();
		String d = "";
		for (org.m2ling.domain.core.ReferenceType rd : domainReferenceTypes) {
			d += rd.name();
		}
		assertTrue(p.equals(d));
	}
}
