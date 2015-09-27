package com.zenixia.plugins.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.zenixia.plugins.model.EquipmentType;
import com.zenixia.plugins.portlet.EquipementTypePortlet;
import com.zenixia.plugins.service.EquipmentTypeLocalServiceUtil;

import java.util.Locale;

/**
 * The extended model implementation for the Equipment service. Represents a row in the &quot;RoomBooking_Equipment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.zenixia.plugins.model.Equipment} interface.
 * </p>
 *
 * @author Guillaume Lenoir
 */
public class EquipmentImpl extends EquipmentBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a equipment model instance should use the {@link com.zenixia.plugins.model.Equipment} interface instead.
     */
	/**
	 * EquipmentImpl Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(EquipmentImpl.class);
	
    public EquipmentImpl() {
    }
    
    public String getEquipmentTypeName(Locale locale) {
    	
    	String equipementTypeName = StringPool.BLANK;
    	
    	try {
			EquipmentType equipmentType = EquipmentTypeLocalServiceUtil.getEquipmentType(getEquipmentTypeId());
			equipementTypeName = equipmentType.getName(locale);
		}
		catch (PortalException e) {
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error(e.getMessage());
		}
		catch (SystemException e) {
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error(e.getMessage());
		}
    	
    	return equipementTypeName;
    }
}
