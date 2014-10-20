package com.glenoir.plugins.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.glenoir.plugins.service.http.RoomServiceSoap}.
 *
 * @author guillaume Lenoir
 * @see com.glenoir.plugins.service.http.RoomServiceSoap
 * @generated
 */
public class RoomSoap implements Serializable {
    private String _uuid;
    private long _roomId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private int _capacity;
    private int _level;

    public RoomSoap() {
    }

    public static RoomSoap toSoapModel(Room model) {
        RoomSoap soapModel = new RoomSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setRoomId(model.getRoomId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setCapacity(model.getCapacity());
        soapModel.setLevel(model.getLevel());

        return soapModel;
    }

    public static RoomSoap[] toSoapModels(Room[] models) {
        RoomSoap[] soapModels = new RoomSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static RoomSoap[][] toSoapModels(Room[][] models) {
        RoomSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new RoomSoap[models.length][models[0].length];
        } else {
            soapModels = new RoomSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static RoomSoap[] toSoapModels(List<Room> models) {
        List<RoomSoap> soapModels = new ArrayList<RoomSoap>(models.size());

        for (Room model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RoomSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _roomId;
    }

    public void setPrimaryKey(long pk) {
        setRoomId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getRoomId() {
        return _roomId;
    }

    public void setRoomId(long roomId) {
        _roomId = roomId;
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

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public int getCapacity() {
        return _capacity;
    }

    public void setCapacity(int capacity) {
        _capacity = capacity;
    }

    public int getLevel() {
        return _level;
    }

    public void setLevel(int level) {
        _level = level;
    }
}
