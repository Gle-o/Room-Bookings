package com.zenixia.plugins.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Equipment service. Represents a row in the &quot;RoomBooking_Equipment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Guillaume Lenoir
 * @see EquipmentModel
 * @see com.zenixia.plugins.model.impl.EquipmentImpl
 * @see com.zenixia.plugins.model.impl.EquipmentModelImpl
 * @generated
 */
public interface Equipment extends EquipmentModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.zenixia.plugins.model.impl.EquipmentImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public java.lang.String getEquipmentTypeName(java.util.Locale locale);
}
