package com.zenixia.plugins.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Room service. Represents a row in the &quot;RoomBooking_Room&quot; database table, with each column mapped to a property of this class.
 *
 * @author Guillaume Lenoir
 * @see RoomModel
 * @see com.zenixia.plugins.model.impl.RoomImpl
 * @see com.zenixia.plugins.model.impl.RoomModelImpl
 * @generated
 */
public interface Room extends RoomModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.zenixia.plugins.model.impl.RoomImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public long[] getCurrentEquipementIds();

    public void setCurrentEquipementIds(long[] currentEquipementIds);

    public java.util.List<com.zenixia.plugins.model.Equipment> getEquipements();
}
