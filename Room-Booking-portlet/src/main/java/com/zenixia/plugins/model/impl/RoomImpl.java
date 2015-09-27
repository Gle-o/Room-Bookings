
package com.zenixia.plugins.model.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.zenixia.plugins.model.Equipment;
import com.zenixia.plugins.service.EquipmentLocalServiceUtil;

import java.util.List;

/**
 * The extended model implementation for the Room service. Represents a row in
 * the &quot;RoomBooking_Room&quot; database table, with each column mapped to a
 * property of this class. <p> Helper methods and all application logic should
 * be put in this class. Whenever methods are added, rerun ServiceBuilder to
 * copy their definitions into the {@link com.zenixia.plugins.model.Room}
 * interface. </p>
 * 
 * @author Guillaume Lenoir
 */
public class RoomImpl extends RoomBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. All methods
	 * that expect a room model instance should use the {@link
	 * com.zenixia.plugins.model.Room} interface instead.
	 */
	public RoomImpl() {

	}

	/**
	 * RoomImpl Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(RoomImpl.class);

	private transient long[] currentEquipementIds;

	public long[] getCurrentEquipementIds() {

		return currentEquipementIds;
	}

	public void setCurrentEquipementIds(long[] currentEquipementIds) {

		this.currentEquipementIds = currentEquipementIds;
	}

	public List<Equipment> getEquipements() {

		List<Equipment> equipments = null;

		try {
			equipments = EquipmentLocalServiceUtil.getEquipmentByRoomId(getRoomId());
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error(e.getMessage());
		}

		return equipments;
	}

}
