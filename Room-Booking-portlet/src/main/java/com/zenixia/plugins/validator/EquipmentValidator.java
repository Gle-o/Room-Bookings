package com.zenixia.plugins.validator;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Validator;
import com.zenixia.plugins.model.Equipment;

import java.util.Locale;

import javax.portlet.ActionRequest;


public class EquipmentValidator {

	/**
	 * Validate equipement
	 * 
	 * @param equipment
	 * @param actionRequest
	 * @param locale
	 * @return
	 */
	public static boolean validate(Equipment equipment, ActionRequest actionRequest, Locale locale) {

		if (Validator.isNull(equipment)) {
			SessionErrors.add(actionRequest, "name-required");
		}
		else if (Validator.isBlank(equipment.getName(locale))) {
			SessionErrors.add(actionRequest, "name-required");
		}
		
		if (Validator.isNull(equipment.getReference())) {
			SessionErrors.add(actionRequest, "equipment-type-required");
		}
		
		if (Validator.isNull(equipment.getEquipmentTypeId())) {
			SessionErrors.add(actionRequest, "equipment-type-required");
		}

		return SessionErrors.isEmpty(actionRequest);
	}
}
