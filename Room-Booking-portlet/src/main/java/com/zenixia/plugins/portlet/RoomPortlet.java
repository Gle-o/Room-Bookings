
package com.zenixia.plugins.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeFormatter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.zenixia.plugins.model.Equipment;
import com.zenixia.plugins.model.EquipmentType;
import com.zenixia.plugins.model.Room;
import com.zenixia.plugins.service.EquipmentLocalServiceUtil;
import com.zenixia.plugins.service.EquipmentTypeServiceUtil;
import com.zenixia.plugins.service.RoomLocalServiceUtil;
import com.zenixia.plugins.service.RoomServiceUtil;
import com.zenixia.plugins.validator.RoomValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class RoomPortlet
 */
public class RoomPortlet extends MVCPortlet {

	/**
	 * ManagementPortlet Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(RoomPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();
		Locale locale = themeDisplay.getLocale();
		List<KeyValuePair> typesLeftList = null;
		List<KeyValuePair> typesRightList = null;
		List<EquipmentType> equipmentTypes = null;
		long roomId = ParamUtil.getLong(renderRequest, "roomId");
		Room room = null;
		String description = StringPool.BLANK;
		
		try {

			// Edit
			if (Validator.isNotNull(roomId)) {
				room = RoomServiceUtil.getRoom(roomId);
				description = UnicodeFormatter.toString(room.getDescription(locale));
			}

			equipmentTypes = EquipmentTypeServiceUtil.getEquipmentTypeByGroupId(groupId);

			for (EquipmentType equipmentType : equipmentTypes) {

				// Left list
				typesLeftList = new ArrayList<KeyValuePair>();

				if (Validator.isNotNull(room)) {
					List<Equipment> equipmentsLeft = EquipmentLocalServiceUtil.getEquipmentByEquipmentTypeIdRoomId(equipmentType.getEquipmentTypeId(), roomId);
					for (Equipment equipment : equipmentsLeft) {
						typesLeftList.add(new KeyValuePair(String.valueOf(equipment.getEquipmentId()), equipment.getName(locale)));
					}
				}

				// Right list
				typesRightList = new ArrayList<KeyValuePair>();

				List<Equipment> equipmentsRight = EquipmentLocalServiceUtil.getAvailableEquipmentByGroupIdEquipementTypeId(groupId, equipmentType.getEquipmentTypeId());

				for (Equipment equipment : equipmentsRight) {
					typesRightList.add(new KeyValuePair(String.valueOf(equipment.getEquipmentId()), equipment.getName(locale)));
				}

				equipmentType.setTypesLeftList(typesLeftList);
				equipmentType.setTypesRightList(typesRightList);
			}
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("PortalException: impossible to initiate room " + roomId);
			LOGGER.error(e.getMessage());
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("PortalException: impossible to initiate room " + roomId);
			LOGGER.error(e.getMessage());
		}

		renderRequest.setAttribute("typesLeftList", typesLeftList);
		renderRequest.setAttribute("typesRightList", typesRightList);
		renderRequest.setAttribute("equipmentTypes", equipmentTypes);
		renderRequest.setAttribute("model", Room.class);
		renderRequest.setAttribute("room", room);
		renderRequest.setAttribute("content", description);

		super.doView(renderRequest, renderResponse);
	}

	/**
	 * Process action
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void addRoom(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Room room = null;

		long roomId = ParamUtil.getLong(actionRequest, "roomId");

		try {
			room = roomFromRequest(actionRequest, themeDisplay);
			if (RoomValidator.validate(room, actionRequest, themeDisplay.getLocale())) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Room.class.getName(), actionRequest);

				if (room.isNew()) {
					RoomServiceUtil.addRoom(room, serviceContext);
				}
				else {
					RoomServiceUtil.updateRoom(room, serviceContext);
				}
			}

			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("PortalException: impossible to save/update room " + roomId);
			LOGGER.error(e.getMessage());
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException: impossible to save/update room" + roomId);
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * Delete equipment type
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void deleteRoom(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		long roomId = ParamUtil.getLong(actionRequest, "roomId");

		try {
			RoomServiceUtil.deleteRoom(roomId);
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("PortalException: impossible to delete room " + roomId);
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException: impossible to delete room" + roomId);
		}

		sendRedirect(actionRequest, actionResponse);

	}

	/**
	 * Convenience method to create a Equipment type object out of the request.
	 * Used by the Add / Edit methods.
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 * @return
	 * @throws IOException
	 * @throws PortalException
	 * @throws SystemException
	 */
	private Room roomFromRequest(ActionRequest actionRequest, ThemeDisplay themeDisplay)
		throws PortalException, SystemException {

		Room room = null;
		Locale locale = themeDisplay.getLocale();

		long[] currentEquipementIds = ParamUtil.getLongValues(actionRequest, "currentEquipementIds");

		long roomId = ParamUtil.getLong(actionRequest, "roomId");
		String description = ParamUtil.getString(actionRequest, "description");

		int capacity = ParamUtil.getInteger(actionRequest, "capacity");
		int level = ParamUtil.getInteger(actionRequest, "level");

		if (Validator.isNotNull(roomId)) {
			room = RoomLocalServiceUtil.getRoom(roomId);
		}
		else {
			room = RoomLocalServiceUtil.createRoom(0);
		}

		room.setNameMap(LocalizationUtil.getLocalizationMap(actionRequest, "name"));
		room.setDescription(description, locale);
		room.setCapacity(capacity);
		room.setLevel(level);
		room.setCurrentEquipementIds(currentEquipementIds);

		return room;
	}

}
