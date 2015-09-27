
package com.zenixia.plugins.model.impl;

import com.liferay.portal.kernel.util.KeyValuePair;

import java.util.List;

/**
 * The extended model implementation for the EquipmentType service. Represents a
 * row in the &quot;RoomBooking_EquipmentType&quot; database table, with each
 * column mapped to a property of this class. <p> Helper methods and all
 * application logic should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.zenixia.plugins.model.EquipmentType} interface. </p>
 * 
 * @author Guillaume Lenoir
 */
public class EquipmentTypeImpl extends EquipmentTypeBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. All methods
	 * that expect a equipment type model instance should use the {@link
	 * com.zenixia.plugins.model.EquipmentType} interface instead.
	 */
	public EquipmentTypeImpl() {

	}

	private transient List<KeyValuePair> typesLeftList;

	private transient List<KeyValuePair> typesRightList;

	public List<KeyValuePair> getTypesLeftList() {

		return typesLeftList;
	}

	public void setTypesLeftList(List<KeyValuePair> typesLeftList) {

		this.typesLeftList = typesLeftList;
	}

	public List<KeyValuePair> getTypesRightList() {

		return typesRightList;
	}

	public void setTypesRightList(List<KeyValuePair> typesRightList) {

		this.typesRightList = typesRightList;
	}

}
