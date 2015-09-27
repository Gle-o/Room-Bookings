package com.zenixia.plugins.validator;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Validator;
import com.zenixia.plugins.model.Room;

import java.util.Locale;

import javax.portlet.ActionRequest;


public class RoomValidator {

	/**
	 * Validate Room
	 * 
	 * @param room
	 * @param actionRequest
	 * @param locale
	 * @return
	 */
	public static boolean validate(Room room, ActionRequest actionRequest, Locale locale) {

		if (Validator.isNull(room)) {
			SessionErrors.add(actionRequest, "name-required");
		}
		else if (Validator.isBlank(room.getName(locale))) {
			SessionErrors.add(actionRequest, "name-required");
		}
		if (Validator.isNull(room.getDescription(locale))) {
			SessionErrors.add(actionRequest, "description-required");
		}
		if (Validator.isNull(room.getCapacity())) {
			SessionErrors.add(actionRequest, "capacity-required");
		} else if (!Validator.isNumber(String.valueOf(room.getCapacity()))) {
			SessionErrors.add(actionRequest, "capacity-number-required");
		}
		if (Validator.isNull(room.getLevel())) {
			SessionErrors.add(actionRequest, "getLevel-required");
		} else if (!Validator.isNumber(String.valueOf(room.getLevel()))) {
			SessionErrors.add(actionRequest, "getLevel-number-required");
		}
		
		return SessionErrors.isEmpty(actionRequest);
	}
}
