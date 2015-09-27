
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
import com.zenixia.plugins.model.EquipmentType;
import com.zenixia.plugins.service.EquipmentTypeLocalServiceUtil;
import com.zenixia.plugins.service.EquipmentTypeServiceUtil;
import com.zenixia.plugins.validator.EquipementTypeValidator;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class EquipementType
 */
public class EquipementTypePortlet extends MVCPortlet {

	/**
	 * EquipementTypePortlet Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(EquipementTypePortlet.class);

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

		long equipmentTypeId = ParamUtil.getLong(renderRequest, "equipmentTypeId");
		
		EquipmentType equipmentType = null;
		if (Validator.isNotNull(equipmentTypeId)) {
			try {
				equipmentType = EquipmentTypeServiceUtil.getEquipmentType(equipmentTypeId);
				renderRequest.setAttribute("equipmentType", equipmentType);
			}
			catch (PortalException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("PortalException: impossible to get equipmentType " + equipmentTypeId);
			}
			catch (SystemException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("SystemException: impossible to get equipmentType " + equipmentTypeId);
			}
		}

		renderRequest.setAttribute("model", EquipmentType.class);
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
	public void addEquipmentType(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		EquipmentType equipmentType = null;

		long equipmentTypeId = ParamUtil.getLong(actionRequest, "equipmentTypeId");
		
		try {
			equipmentType = equipmentTypeFromRequest(actionRequest, themeDisplay);
			if (EquipementTypeValidator.validate(equipmentType, actionRequest, themeDisplay.getLocale())) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(EquipmentType.class.getName(), actionRequest);

				if (equipmentType.isNew()) {
					EquipmentTypeServiceUtil.addEquipmentType(equipmentType, serviceContext);
				} else {
					EquipmentTypeServiceUtil.updateEquipmentType(equipmentType, serviceContext);
				}
			}
			
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("PortalException: impossible to save/update equipmentType " + equipmentTypeId);
			LOGGER.error(e.getMessage());
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException: impossible to save/update equipmentType" + equipmentTypeId);
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
	public void deleteEquipmentType(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		long equipmentTypeId = ParamUtil.getLong(actionRequest, "equipmentTypeId");
		
		try {
			EquipmentTypeServiceUtil.deleteEquipmentType(equipmentTypeId);
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("PortalException: impossible to delete equipmentType " + equipmentTypeId);
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException: impossible to delete equipmentType" + equipmentTypeId);
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
	private EquipmentType equipmentTypeFromRequest(ActionRequest actionRequest, ThemeDisplay themeDisplay)
		throws PortalException, SystemException {

		EquipmentType equipmentType = null;

		long equipmentTypeId = ParamUtil.getLong(actionRequest, "equipmentTypeId");

		if (Validator.isNotNull(equipmentTypeId)) {
			equipmentType = EquipmentTypeLocalServiceUtil.getEquipmentType(equipmentTypeId);
		}
		else {
			equipmentType = EquipmentTypeLocalServiceUtil.createEquipmentType(0);
		}

		equipmentType.setNameMap(LocalizationUtil.getLocalizationMap(actionRequest, "name"));

		return equipmentType;
	}

}
