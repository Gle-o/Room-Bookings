package com.zenixia.plugins.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the EquipmentType service. Represents a row in the &quot;RoomBooking_EquipmentType&quot; database table, with each column mapped to a property of this class.
 *
 * @author Guillaume Lenoir
 * @see EquipmentTypeModel
 * @see com.zenixia.plugins.model.impl.EquipmentTypeImpl
 * @see com.zenixia.plugins.model.impl.EquipmentTypeModelImpl
 * @generated
 */
public interface EquipmentType extends EquipmentTypeModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.zenixia.plugins.model.impl.EquipmentTypeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public java.util.List<com.liferay.portal.kernel.util.KeyValuePair> getTypesLeftList();

    public void setTypesLeftList(
        java.util.List<com.liferay.portal.kernel.util.KeyValuePair> typesLeftList);

    public java.util.List<com.liferay.portal.kernel.util.KeyValuePair> getTypesRightList();

    public void setTypesRightList(
        java.util.List<com.liferay.portal.kernel.util.KeyValuePair> typesRightList);
}
