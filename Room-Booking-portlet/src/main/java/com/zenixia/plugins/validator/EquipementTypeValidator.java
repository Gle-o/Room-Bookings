
package com.zenixia.plugins.validator;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Validator;
import com.zenixia.plugins.model.EquipmentType;

import java.util.Locale;

import javax.portlet.ActionRequest;

public class EquipementTypeValidator {

	/**
	 * Validate equipement type
	 * 
	 * @param equipmentType
	 * @param actionRequest
	 * @param locale
	 * @return
	 */
	public static boolean validate(EquipmentType equipmentType, ActionRequest actionRequest, Locale locale) {

		if (Validator.isNull(equipmentType)) {
			SessionErrors.add(actionRequest, "label-required");
		}
		else if (Validator.isBlank(equipmentType.getName(locale))) {
			SessionErrors.add(actionRequest, "label-required");
		}

		return SessionErrors.isEmpty(actionRequest);
	}

}
