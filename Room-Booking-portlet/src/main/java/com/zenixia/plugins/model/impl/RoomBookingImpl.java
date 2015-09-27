
package com.zenixia.plugins.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.zenixia.plugins.model.Room;
import com.zenixia.plugins.service.RoomLocalServiceUtil;

/**
 * The extended model implementation for the RoomBooking service. Represents a
 * row in the &quot;RoomBooking_RoomBooking&quot; database table, with each
 * column mapped to a property of this class. <p> Helper methods and all
 * application logic should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.zenixia.plugins.model.RoomBooking} interface. </p>
 * 
 * @author Guillaume Lenoir
 */
public class RoomBookingImpl extends RoomBookingBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. All methods
	 * that expect a room booking model instance should use the {@link
	 * com.zenixia.plugins.model.RoomBooking} interface instead.
	 */
	public RoomBookingImpl() {

	}

	/**
	 * RoomBookingImpl Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(RoomBookingImpl.class);

	/**
	 * Get Room 
	 * @return room
	 */
	public Room getRoom() {

		Room room = null;

		try {
			room = RoomLocalServiceUtil.getRoom(getRoomId());
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error(e.getMessage());
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error(e.getMessage());
		}

		return room;
	}
}
