package com.zenixia.plugins.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the RoomBooking service. Represents a row in the &quot;RoomBooking_RoomBooking&quot; database table, with each column mapped to a property of this class.
 *
 * @author Guillaume Lenoir
 * @see RoomBookingModel
 * @see com.zenixia.plugins.model.impl.RoomBookingImpl
 * @see com.zenixia.plugins.model.impl.RoomBookingModelImpl
 * @generated
 */
public interface RoomBooking extends RoomBookingModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.zenixia.plugins.model.impl.RoomBookingImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Get Room
    *
    * @return room
    */
    public com.zenixia.plugins.model.Room getRoom();
}
