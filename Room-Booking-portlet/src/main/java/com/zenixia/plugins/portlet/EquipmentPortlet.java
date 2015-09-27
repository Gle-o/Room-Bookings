
package com.zenixia.plugins.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.zenixia.plugins.model.Equipment;
import com.zenixia.plugins.model.EquipmentType;
import com.zenixia.plugins.service.EquipmentLocalServiceUtil;
import com.zenixia.plugins.service.EquipmentServiceUtil;
import com.zenixia.plugins.service.EquipmentTypeServiceUtil;
import com.zenixia.plugins.validator.EquipmentValidator;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class Equipement
 */
public class EquipmentPortlet extends MVCPortlet {

	/**
	 * EquipmentPortlet Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(EquipmentPortlet.class);

	/**
	 * Do view
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		long equipmentId = ParamUtil.getLong(renderRequest, "equipmentId");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Equipment equipment = null;
		List<EquipmentType> equipmentTypes = null;
		try {
			if (Validator.isNotNull(equipmentId)) {

				equipment = EquipmentServiceUtil.getEquipment(equipmentId);
				renderRequest.setAttribute("equipment", equipment);
			}
			
			equipmentTypes = EquipmentTypeServiceUtil.getEquipmentTypeByGroupId(themeDisplay.getScopeGroupId());
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error(e.getMessage());
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error(e.getMessage());
		}
		renderRequest.setAttribute("equipmentTypes", equipmentTypes);
		renderRequest.setAttribute("model", Equipment.class);
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
	public void addEquipment(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Equipment equipment = null;

		long equipmentId = ParamUtil.getLong(actionRequest, "equipmentId");

		try {
			equipment = equipmentFromRequest(actionRequest, themeDisplay);
			if (EquipmentValidator.validate(equipment, actionRequest, themeDisplay.getLocale())) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Equipment.class.getName(), actionRequest);

				if (equipment.isNew()) {
					EquipmentServiceUtil.addEquipment(equipment, serviceContext);
				}
				else {
					EquipmentServiceUtil.updateEquipment(equipment, serviceContext);
				}
			}

			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("PortalException: impossible to save/update equipment " + equipmentId);
			LOGGER.error(e.getMessage());
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException: impossible to save/update equipment" + equipmentId);
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
	public void deleteEquipment(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		long equipmentId = ParamUtil.getLong(actionRequest, "equipmentId");
		
		try {
			EquipmentServiceUtil.deleteEquipment(equipmentId);
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("PortalException: impossible to delete equipment " + equipmentId);
			LOGGER.error(e.getMessage());
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException: impossible to delete equipment " + equipmentId);
			LOGGER.error(e.getMessage());
		}
		
		sendRedirect(actionRequest, actionResponse);
	}

	/**
	 * Convenience method to create a Equipment object out of the request. Used
	 * by the Add / Edit methods.
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 * @return
	 * @throws IOException
	 * @throws PortalException
	 * @throws SystemException
	 */
	private Equipment equipmentFromRequest(ActionRequest actionRequest, ThemeDisplay themeDisplay)
		throws PortalException, SystemException {

		Equipment equipment = null;

		long equipmentId = ParamUtil.getLong(actionRequest, "equipmentId");
		String reference = ParamUtil.getString(actionRequest, "reference");
		long equipmentTypeId = ParamUtil.getLong(actionRequest, "equipmentTypeId");

		if (Validator.isNotNull(equipmentId)) {
			equipment = EquipmentLocalServiceUtil.getEquipment(equipmentId);
		}
		else {
			equipment = EquipmentLocalServiceUtil.createEquipment(0);
		}

		equipment.setEquipmentTypeId(equipmentTypeId);
		equipment.setReference(reference);
		equipment.setNameMap(LocalizationUtil.getLocalizationMap(actionRequest, "name"));

		return equipment;
	}
}
