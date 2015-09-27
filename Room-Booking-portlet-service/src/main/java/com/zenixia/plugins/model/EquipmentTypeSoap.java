package com.zenixia.plugins.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.zenixia.plugins.service.http.EquipmentTypeServiceSoap}.
 *
 * @author Guillaume Lenoir
 * @see com.zenixia.plugins.service.http.EquipmentTypeServiceSoap
 * @generated
 */
public class EquipmentTypeSoap implements Serializable {
    private String _uuid;
    private long _equipmentTypeId;
    private long _companyId;
    private long _groupId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;

    public EquipmentTypeSoap() {
    }

    public static EquipmentTypeSoap toSoapModel(EquipmentType model) {
        EquipmentTypeSoap soapModel = new EquipmentTypeSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setEquipmentTypeId(model.getEquipmentTypeId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());

        return soapModel;
    }

    public static EquipmentTypeSoap[] toSoapModels(EquipmentType[] models) {
        EquipmentTypeSoap[] soapModels = new EquipmentTypeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EquipmentTypeSoap[][] toSoapModels(EquipmentType[][] models) {
        EquipmentTypeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EquipmentTypeSoap[models.length][models[0].length];
        } else {
            soapModels = new EquipmentTypeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EquipmentTypeSoap[] toSoapModels(List<EquipmentType> models) {
        List<EquipmentTypeSoap> soapModels = new ArrayList<EquipmentTypeSoap>(models.size());

        for (EquipmentType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EquipmentTypeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _equipmentTypeId;
    }

    public void setPrimaryKey(long pk) {
        setEquipmentTypeId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getEquipmentTypeId() {
        return _equipmentTypeId;
    }

    public void setEquipmentTypeId(long equipmentTypeId) {
        _equipmentTypeId = equipmentTypeId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}
