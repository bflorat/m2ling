/**
 * Copyright (C) 2012 Bertrand Florat
 */
package org.m2ling.service.principles;

import org.eclipse.emf.common.util.EList;
import org.m2ling.common.dto.core.AccessType;
import org.m2ling.common.dto.core.ViewPointDTO;
import org.m2ling.common.exceptions.FunctionalException;
import org.m2ling.common.utils.Consts;
import org.m2ling.common.utils.Utils;
import org.m2ling.domain.core.Type;
import org.m2ling.domain.core.ViewPoint;
import org.m2ling.persistence.PersistenceManager;
import org.m2ling.service.common.ReferenceHelper;
import org.m2ling.service.common.ServiceChecker;
import org.m2ling.service.util.DomainExplorer;
import org.m2ling.service.util.DTOConverter.FromDTO;

import com.google.inject.Inject;

/**
 * @author "Bertrand Florat <bertrand@florat.net>"
 * 
 */
public class ViewPointServiceChecker extends ServiceChecker {
	@Inject
	protected ViewPointServiceChecker(PersistenceManager pm, DomainExplorer explorer, FromDTO fromDTO, ReferenceHelper refHelper) {
		super(pm, explorer, fromDTO, refHelper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type getManagedType() {
		return Type.VIEWPOINT;
	}

	void checkDTO(final ViewPointDTO dto, final AccessType access) throws FunctionalException {
		ViewPoint vp = null;
		checkNullDTO(dto);
		checkID(dto, access);
		// TODO : check status (status of the VP itself, not status literals)
		if (access == AccessType.CREATE || access == AccessType.UPDATE) {
			checkNameWhenRequired(dto, access);
			vp = explorer.getViewPointByID(dto.getId());
			// Status literals
			if (dto.getStatusLiterals() == null) {
				throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "(statusLiteral)");
			}
			int index = 1;
			for (String literal : dto.getStatusLiterals()) {
				if (literal == null) {
					throw new FunctionalException(FunctionalException.Code.NULL_ARGUMENT, null, "statusLiteral #" + index);
				}
				if (Utils.isNullOrEmptyAfterTrim(literal)) {
					throw new FunctionalException(FunctionalException.Code.VOID_ARGUMENT, null, "statusLiteral #" + index);
				}
				if (literal.length() > Consts.MAX_LABEL_SIZE) {
					throw new FunctionalException(FunctionalException.Code.SIZE_EXCEEDED, null, "statusLiteral #" + index);
				}
				index++;
			}
			checkDescriptionMandatory(dto.getDescription());
			checkComment(dto.getComment());
			checkTags(dto.getTags());
			if (access == AccessType.UPDATE) {
				checkStatus(dto.getId(), dto.getStatus());
				EList<String> droppedStatusLiterals = vp.getStatusLiterals();
				for (String literal : dto.getStatusLiterals()) {
					droppedStatusLiterals.remove(literal);
				}
				// Check if a HasStatus item maps a status that has has been dropped
				for (String sl : droppedStatusLiterals) {
					if (explorer.containsStatusLiteral(vp.getId(), sl)) {
						throw new FunctionalException(FunctionalException.Code.STATUS_USED, null, "(status literal)");
					}
				}
			}
		}
	}
}
