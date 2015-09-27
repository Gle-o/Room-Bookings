
package com.zenixia.plugins.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.zenixia.plugins.model.Equipment;
import com.zenixia.plugins.model.EquipmentType;
import com.zenixia.plugins.model.Room;
import com.zenixia.plugins.permissions.BookingPermission;
import com.zenixia.plugins.service.EquipmentServiceUtil;
import com.zenixia.plugins.service.EquipmentTypeServiceUtil;
import com.zenixia.plugins.service.RoomServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class ManagementPortlet
 */
public class ManagementPortlet extends MVCPortlet {

	/**
	 * ManagementPortlet Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(ManagementPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		String result_jsp = StringPool.BLANK;
		
		int action = ParamUtil.getInteger(renderRequest, "action");

		boolean addEquipmentType = BookingPermission.contains(permissionChecker, groupId, "ADD_EQUIPMENT_TYPE");
		boolean addEquipment = BookingPermission.contains(permissionChecker, groupId, "ADD_EQUIPMENT");
		boolean addRoom = BookingPermission.contains(permissionChecker, groupId, "ADD_ROOM");
		
		PortletURL iteratorURL = renderResponse.createRenderURL();
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM , SearchContainer.DEFAULT_CUR);

		switch (action) {
			case 1:
				result_jsp = "/html/equipment_type/view.jsp";
				break;
			case 2:
				result_jsp = "/html/booking/view.jsp";
				break;
			case 3:
				result_jsp = processRoom(renderRequest, groupId, iteratorURL, delta, cur);
				break;
			case 4:
				result_jsp = processEquipment(renderRequest, groupId, iteratorURL, delta, cur);
				break;
			default:
				result_jsp = processEquipmentType(renderRequest, groupId, iteratorURL, delta, cur);
				break;
		}

		renderRequest.setAttribute("addEquipmentType", addEquipmentType);
		renderRequest.setAttribute("addEquipment", addEquipment);
		renderRequest.setAttribute("addRoom", addRoom);
		
		renderRequest.setAttribute("result_jsp", result_jsp);
		renderRequest.setAttribute("action", action);

		super.doView(renderRequest, renderResponse);
	}

	private String processEquipmentType(RenderRequest renderRequest, long groupId, PortletURL iteratorURL, int delta, int cur) {

		SearchContainer<EquipmentType> searchContainer = new SearchContainer<EquipmentType>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, iteratorURL, null, "emptyResultsMessage");

		int total = 0;
		int start = searchContainer.getStart();
		int end = searchContainer.getEnd();
		
		try {
			List<EquipmentType> equipmentTypes = EquipmentTypeServiceUtil.getEquipmentTypeByGroupId(groupId, start, end);
			total = EquipmentTypeServiceUtil.getEquipmentCountTypeByGroupId(groupId);
			searchContainer.setResults(equipmentTypes);
			searchContainer.setTotal(total);
			renderRequest.setAttribute("searchContainer", searchContainer);
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException : impossible to get Equipment Type By GroupId");
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("PortalException : impossible to get Equipment Type By GroupId");
		}

		return "/html/equipment_type/view.jsp";
	}

	private String processEquipment(RenderRequest renderRequest, long groupId, PortletURL iteratorURL, int delta, int cur) {

		SearchContainer<Equipment> searchContainer = new SearchContainer<Equipment>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, iteratorURL, null, "emptyResultsMessage");

		int total = 0;
		int start = searchContainer.getStart();
		int end = searchContainer.getEnd();
		
		List<Equipment> equipments = null;
		try {
			equipments = EquipmentServiceUtil.getEquipmentByGroupId(groupId, start, end);
			total = EquipmentServiceUtil.getEquipmentCountByGroupId(groupId);
			searchContainer.setResults(equipments);
			searchContainer.setTotal(total);
			renderRequest.setAttribute("searchContainer", searchContainer);
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException : impossible to get Equipment By GroupId");
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("PortalException : impossible to get Equipment By GroupId");
		}
		
		return "/html/equipment/view.jsp";
	}
	
	private String processRoom(RenderRequest renderRequest, long groupId, PortletURL iteratorURL, int delta, int cur) {

		SearchContainer<Room> searchContainer = new SearchContainer<Room>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, iteratorURL, null, "emptyResultsMessage");

		int total = 0;
		int start = searchContainer.getStart();
		int end = searchContainer.getEnd();
		
		List<Room> rooms = null;
		try {
			rooms = RoomServiceUtil.getRoomByGroupId(groupId, start, end);
			total = RoomServiceUtil.getRoomCountByGroupId(groupId);
			searchContainer.setResults(rooms);
			searchContainer.setTotal(total);
			renderRequest.setAttribute("searchContainer", searchContainer);
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException : impossible to get Rooms By GroupId");
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("PortalException : impossible to get Rooms By GroupId");
		}
		
		return "/html/rooms/view.jsp";
	}
}
