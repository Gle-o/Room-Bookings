package com.glenoir.plugins.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.glenoir.plugins.service.http.RoomBookingServiceSoap}.
 *
 * @author guillaume Lenoir
 * @see com.glenoir.plugins.service.http.RoomBookingServiceSoap
 * @generated
 */
public class RoomBookingSoap implements Serializable {
    private String _uuid;
    private long _roomBookingId;
    private long _companyId;
    private long _groupId;
    private Date _createDate;
    private Date _modifiedDate;
    private long _userId;
    private String _userName;
    private long _roomId;
    private String _title;
    private String _description;
    private long _startTime;
    private long _endTime;
    private boolean _allDay;
    private String _recurrence;
    private long _firstReminder;
    private String _firstReminderType;
    private long _secondReminder;
    private String _secondReminderType;
    private int _status;
    private long _statusByUserId;
    private String _statusByUserName;
    private Date _statusDate;

    public RoomBookingSoap() {
    }

    public static RoomBookingSoap toSoapModel(RoomBooking model) {
        RoomBookingSoap soapModel = new RoomBookingSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setRoomBookingId(model.getRoomBookingId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setRoomId(model.getRoomId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setStartTime(model.getStartTime());
        soapModel.setEndTime(model.getEndTime());
        soapModel.setAllDay(model.getAllDay());
        soapModel.setRecurrence(model.getRecurrence());
        soapModel.setFirstReminder(model.getFirstReminder());
        soapModel.setFirstReminderType(model.getFirstReminderType());
        soapModel.setSecondReminder(model.getSecondReminder());
        soapModel.setSecondReminderType(model.getSecondReminderType());
        soapModel.setStatus(model.getStatus());
        soapModel.setStatusByUserId(model.getStatusByUserId());
        soapModel.setStatusByUserName(model.getStatusByUserName());
        soapModel.setStatusDate(model.getStatusDate());

        return soapModel;
    }

    public static RoomBookingSoap[] toSoapModels(RoomBooking[] models) {
        RoomBookingSoap[] soapModels = new RoomBookingSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static RoomBookingSoap[][] toSoapModels(RoomBooking[][] models) {
        RoomBookingSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new RoomBookingSoap[models.length][models[0].length];
        } else {
            soapModels = new RoomBookingSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static RoomBookingSoap[] toSoapModels(List<RoomBooking> models) {
        List<RoomBookingSoap> soapModels = new ArrayList<RoomBookingSoap>(models.size());

        for (RoomBooking model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RoomBookingSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _roomBookingId;
    }

    public void setPrimaryKey(long pk) {
        setRoomBookingId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getRoomBookingId() {
        return _roomBookingId;
    }

    public void setRoomBookingId(long roomBookingId) {
        _roomBookingId = roomBookingId;
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

    public long getRoomId() {
        return _roomId;
    }

    public void setRoomId(long roomId) {
        _roomId = roomId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public long getStartTime() {
        return _startTime;
    }

    public void setStartTime(long startTime) {
        _startTime = startTime;
    }

    public long getEndTime() {
        return _endTime;
    }

    public void setEndTime(long endTime) {
        _endTime = endTime;
    }

    public boolean getAllDay() {
        return _allDay;
    }

    public boolean isAllDay() {
        return _allDay;
    }

    public void setAllDay(boolean allDay) {
        _allDay = allDay;
    }

    public String getRecurrence() {
        return _recurrence;
    }

    public void setRecurrence(String recurrence) {
        _recurrence = recurrence;
    }

    public long getFirstReminder() {
        return _firstReminder;
    }

    public void setFirstReminder(long firstReminder) {
        _firstReminder = firstReminder;
    }

    public String getFirstReminderType() {
        return _firstReminderType;
    }

    public void setFirstReminderType(String firstReminderType) {
        _firstReminderType = firstReminderType;
    }

    public long getSecondReminder() {
        return _secondReminder;
    }

    public void setSecondReminder(long secondReminder) {
        _secondReminder = secondReminder;
    }

    public String getSecondReminderType() {
        return _secondReminderType;
    }

    public void setSecondReminderType(String secondReminderType) {
        _secondReminderType = secondReminderType;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public long getStatusByUserId() {
        return _statusByUserId;
    }

    public void setStatusByUserId(long statusByUserId) {
        _statusByUserId = statusByUserId;
    }

    public String getStatusByUserName() {
        return _statusByUserName;
    }

    public void setStatusByUserName(String statusByUserName) {
        _statusByUserName = statusByUserName;
    }

    public Date getStatusDate() {
        return _statusDate;
    }

    public void setStatusDate(Date statusDate) {
        _statusDate = statusDate;
    }
}
