package com.glenoir.plugins.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.glenoir.plugins.service.http.EquipmentServiceSoap}.
 *
 * @author guillaume Lenoir
 * @see com.glenoir.plugins.service.http.EquipmentServiceSoap
 * @generated
 */
public class EquipmentSoap implements Serializable {
    private String _uuid;
    private long _equipmentId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _equipmentTypeId;
    private String _name;
    private String _reference;

    public EquipmentSoap() {
    }

    public static EquipmentSoap toSoapModel(Equipment model) {
        EquipmentSoap soapModel = new EquipmentSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setEquipmentId(model.getEquipmentId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setEquipmentTypeId(model.getEquipmentTypeId());
        soapModel.setName(model.getName());
        soapModel.setReference(model.getReference());

        return soapModel;
    }

    public static EquipmentSoap[] toSoapModels(Equipment[] models) {
        EquipmentSoap[] soapModels = new EquipmentSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EquipmentSoap[][] toSoapModels(Equipment[][] models) {
        EquipmentSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EquipmentSoap[models.length][models[0].length];
        } else {
            soapModels = new EquipmentSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EquipmentSoap[] toSoapModels(List<Equipment> models) {
        List<EquipmentSoap> soapModels = new ArrayList<EquipmentSoap>(models.size());

        for (Equipment model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EquipmentSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _equipmentId;
    }

    public void setPrimaryKey(long pk) {
        setEquipmentId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getEquipmentId() {
        return _equipmentId;
    }

    public void setEquipmentId(long equipmentId) {
        _equipmentId = equipmentId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
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

    public long getEquipmentTypeId() {
        return _equipmentTypeId;
    }

    public void setEquipmentTypeId(long equipmentTypeId) {
        _equipmentTypeId = equipmentTypeId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getReference() {
        return _reference;
    }

    public void setReference(String reference) {
        _reference = reference;
    }
}
