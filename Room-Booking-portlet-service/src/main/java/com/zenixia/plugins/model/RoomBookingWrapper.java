package com.zenixia.plugins.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RoomBooking}.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see RoomBooking
 * @generated
 */
public class RoomBookingWrapper implements RoomBooking,
    ModelWrapper<RoomBooking> {
    private RoomBooking _roomBooking;

    public RoomBookingWrapper(RoomBooking roomBooking) {
        _roomBooking = roomBooking;
    }

    @Override
    public Class<?> getModelClass() {
        return RoomBooking.class;
    }

    @Override
    public String getModelClassName() {
        return RoomBooking.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("roomBookingId", getRoomBookingId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("roomId", getRoomId());
        attributes.put("vEventUid", getVEventUid());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("startTime", getStartTime());
        attributes.put("endTime", getEndTime());
        attributes.put("allDay", getAllDay());
        attributes.put("recurrence", getRecurrence());
        attributes.put("firstReminder", getFirstReminder());
        attributes.put("firstReminderType", getFirstReminderType());
        attributes.put("secondReminder", getSecondReminder());
        attributes.put("secondReminderType", getSecondReminderType());
        attributes.put("status", getStatus());
        attributes.put("statusByUserId", getStatusByUserId());
        attributes.put("statusByUserName", getStatusByUserName());
        attributes.put("statusDate", getStatusDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long roomBookingId = (Long) attributes.get("roomBookingId");

        if (roomBookingId != null) {
            setRoomBookingId(roomBookingId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Long roomId = (Long) attributes.get("roomId");

        if (roomId != null) {
            setRoomId(roomId);
        }

        String vEventUid = (String) attributes.get("vEventUid");

        if (vEventUid != null) {
            setVEventUid(vEventUid);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long startTime = (Long) attributes.get("startTime");

        if (startTime != null) {
            setStartTime(startTime);
        }

        Long endTime = (Long) attributes.get("endTime");

        if (endTime != null) {
            setEndTime(endTime);
        }

        Boolean allDay = (Boolean) attributes.get("allDay");

        if (allDay != null) {
            setAllDay(allDay);
        }

        String recurrence = (String) attributes.get("recurrence");

        if (recurrence != null) {
            setRecurrence(recurrence);
        }

        Long firstReminder = (Long) attributes.get("firstReminder");

        if (firstReminder != null) {
            setFirstReminder(firstReminder);
        }

        String firstReminderType = (String) attributes.get("firstReminderType");

        if (firstReminderType != null) {
            setFirstReminderType(firstReminderType);
        }

        Long secondReminder = (Long) attributes.get("secondReminder");

        if (secondReminder != null) {
            setSecondReminder(secondReminder);
        }

        String secondReminderType = (String) attributes.get(
                "secondReminderType");

        if (secondReminderType != null) {
            setSecondReminderType(secondReminderType);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Long statusByUserId = (Long) attributes.get("statusByUserId");

        if (statusByUserId != null) {
            setStatusByUserId(statusByUserId);
        }

        String statusByUserName = (String) attributes.get("statusByUserName");

        if (statusByUserName != null) {
            setStatusByUserName(statusByUserName);
        }

        Date statusDate = (Date) attributes.get("statusDate");

        if (statusDate != null) {
            setStatusDate(statusDate);
        }
    }

    /**
    * Returns the primary key of this room booking.
    *
    * @return the primary key of this room booking
    */
    @Override
    public long getPrimaryKey() {
        return _roomBooking.getPrimaryKey();
    }

    /**
    * Sets the primary key of this room booking.
    *
    * @param primaryKey the primary key of this room booking
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _roomBooking.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this room booking.
    *
    * @return the uuid of this room booking
    */
    @Override
    public java.lang.String getUuid() {
        return _roomBooking.getUuid();
    }

    /**
    * Sets the uuid of this room booking.
    *
    * @param uuid the uuid of this room booking
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _roomBooking.setUuid(uuid);
    }

    /**
    * Returns the room booking ID of this room booking.
    *
    * @return the room booking ID of this room booking
    */
    @Override
    public long getRoomBookingId() {
        return _roomBooking.getRoomBookingId();
    }

    /**
    * Sets the room booking ID of this room booking.
    *
    * @param roomBookingId the room booking ID of this room booking
    */
    @Override
    public void setRoomBookingId(long roomBookingId) {
        _roomBooking.setRoomBookingId(roomBookingId);
    }

    /**
    * Returns the company ID of this room booking.
    *
    * @return the company ID of this room booking
    */
    @Override
    public long getCompanyId() {
        return _roomBooking.getCompanyId();
    }

    /**
    * Sets the company ID of this room booking.
    *
    * @param companyId the company ID of this room booking
    */
    @Override
    public void setCompanyId(long companyId) {
        _roomBooking.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this room booking.
    *
    * @return the group ID of this room booking
    */
    @Override
    public long getGroupId() {
        return _roomBooking.getGroupId();
    }

    /**
    * Sets the group ID of this room booking.
    *
    * @param groupId the group ID of this room booking
    */
    @Override
    public void setGroupId(long groupId) {
        _roomBooking.setGroupId(groupId);
    }

    /**
    * Returns the create date of this room booking.
    *
    * @return the create date of this room booking
    */
    @Override
    public java.util.Date getCreateDate() {
        return _roomBooking.getCreateDate();
    }

    /**
    * Sets the create date of this room booking.
    *
    * @param createDate the create date of this room booking
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _roomBooking.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this room booking.
    *
    * @return the modified date of this room booking
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _roomBooking.getModifiedDate();
    }

    /**
    * Sets the modified date of this room booking.
    *
    * @param modifiedDate the modified date of this room booking
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _roomBooking.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the user ID of this room booking.
    *
    * @return the user ID of this room booking
    */
    @Override
    public long getUserId() {
        return _roomBooking.getUserId();
    }

    /**
    * Sets the user ID of this room booking.
    *
    * @param userId the user ID of this room booking
    */
    @Override
    public void setUserId(long userId) {
        _roomBooking.setUserId(userId);
    }

    /**
    * Returns the user uuid of this room booking.
    *
    * @return the user uuid of this room booking
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomBooking.getUserUuid();
    }

    /**
    * Sets the user uuid of this room booking.
    *
    * @param userUuid the user uuid of this room booking
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _roomBooking.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this room booking.
    *
    * @return the user name of this room booking
    */
    @Override
    public java.lang.String getUserName() {
        return _roomBooking.getUserName();
    }

    /**
    * Sets the user name of this room booking.
    *
    * @param userName the user name of this room booking
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _roomBooking.setUserName(userName);
    }

    /**
    * Returns the room ID of this room booking.
    *
    * @return the room ID of this room booking
    */
    @Override
    public long getRoomId() {
        return _roomBooking.getRoomId();
    }

    /**
    * Sets the room ID of this room booking.
    *
    * @param roomId the room ID of this room booking
    */
    @Override
    public void setRoomId(long roomId) {
        _roomBooking.setRoomId(roomId);
    }

    /**
    * Returns the v event uid of this room booking.
    *
    * @return the v event uid of this room booking
    */
    @Override
    public java.lang.String getVEventUid() {
        return _roomBooking.getVEventUid();
    }

    /**
    * Sets the v event uid of this room booking.
    *
    * @param vEventUid the v event uid of this room booking
    */
    @Override
    public void setVEventUid(java.lang.String vEventUid) {
        _roomBooking.setVEventUid(vEventUid);
    }

    /**
    * Returns the title of this room booking.
    *
    * @return the title of this room booking
    */
    @Override
    public java.lang.String getTitle() {
        return _roomBooking.getTitle();
    }

    /**
    * Returns the localized title of this room booking in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized title of this room booking
    */
    @Override
    public java.lang.String getTitle(java.util.Locale locale) {
        return _roomBooking.getTitle(locale);
    }

    /**
    * Returns the localized title of this room booking in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized title of this room booking. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
        return _roomBooking.getTitle(locale, useDefault);
    }

    /**
    * Returns the localized title of this room booking in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized title of this room booking
    */
    @Override
    public java.lang.String getTitle(java.lang.String languageId) {
        return _roomBooking.getTitle(languageId);
    }

    /**
    * Returns the localized title of this room booking in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized title of this room booking
    */
    @Override
    public java.lang.String getTitle(java.lang.String languageId,
        boolean useDefault) {
        return _roomBooking.getTitle(languageId, useDefault);
    }

    @Override
    public java.lang.String getTitleCurrentLanguageId() {
        return _roomBooking.getTitleCurrentLanguageId();
    }

    @Override
    public java.lang.String getTitleCurrentValue() {
        return _roomBooking.getTitleCurrentValue();
    }

    /**
    * Returns a map of the locales and localized titles of this room booking.
    *
    * @return the locales and localized titles of this room booking
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
        return _roomBooking.getTitleMap();
    }

    /**
    * Sets the title of this room booking.
    *
    * @param title the title of this room booking
    */
    @Override
    public void setTitle(java.lang.String title) {
        _roomBooking.setTitle(title);
    }

    /**
    * Sets the localized title of this room booking in the language.
    *
    * @param title the localized title of this room booking
    * @param locale the locale of the language
    */
    @Override
    public void setTitle(java.lang.String title, java.util.Locale locale) {
        _roomBooking.setTitle(title, locale);
    }

    /**
    * Sets the localized title of this room booking in the language, and sets the default locale.
    *
    * @param title the localized title of this room booking
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setTitle(java.lang.String title, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _roomBooking.setTitle(title, locale, defaultLocale);
    }

    @Override
    public void setTitleCurrentLanguageId(java.lang.String languageId) {
        _roomBooking.setTitleCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized titles of this room booking from the map of locales and localized titles.
    *
    * @param titleMap the locales and localized titles of this room booking
    */
    @Override
    public void setTitleMap(
        java.util.Map<java.util.Locale, java.lang.String> titleMap) {
        _roomBooking.setTitleMap(titleMap);
    }

    /**
    * Sets the localized titles of this room booking from the map of locales and localized titles, and sets the default locale.
    *
    * @param titleMap the locales and localized titles of this room booking
    * @param defaultLocale the default locale
    */
    @Override
    public void setTitleMap(
        java.util.Map<java.util.Locale, java.lang.String> titleMap,
        java.util.Locale defaultLocale) {
        _roomBooking.setTitleMap(titleMap, defaultLocale);
    }

    /**
    * Returns the description of this room booking.
    *
    * @return the description of this room booking
    */
    @Override
    public java.lang.String getDescription() {
        return _roomBooking.getDescription();
    }

    /**
    * Returns the localized description of this room booking in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized description of this room booking
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale) {
        return _roomBooking.getDescription(locale);
    }

    /**
    * Returns the localized description of this room booking in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this room booking. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale,
        boolean useDefault) {
        return _roomBooking.getDescription(locale, useDefault);
    }

    /**
    * Returns the localized description of this room booking in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized description of this room booking
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId) {
        return _roomBooking.getDescription(languageId);
    }

    /**
    * Returns the localized description of this room booking in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this room booking
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId,
        boolean useDefault) {
        return _roomBooking.getDescription(languageId, useDefault);
    }

    @Override
    public java.lang.String getDescriptionCurrentLanguageId() {
        return _roomBooking.getDescriptionCurrentLanguageId();
    }

    @Override
    public java.lang.String getDescriptionCurrentValue() {
        return _roomBooking.getDescriptionCurrentValue();
    }

    /**
    * Returns a map of the locales and localized descriptions of this room booking.
    *
    * @return the locales and localized descriptions of this room booking
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
        return _roomBooking.getDescriptionMap();
    }

    /**
    * Sets the description of this room booking.
    *
    * @param description the description of this room booking
    */
    @Override
    public void setDescription(java.lang.String description) {
        _roomBooking.setDescription(description);
    }

    /**
    * Sets the localized description of this room booking in the language.
    *
    * @param description the localized description of this room booking
    * @param locale the locale of the language
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale) {
        _roomBooking.setDescription(description, locale);
    }

    /**
    * Sets the localized description of this room booking in the language, and sets the default locale.
    *
    * @param description the localized description of this room booking
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale, java.util.Locale defaultLocale) {
        _roomBooking.setDescription(description, locale, defaultLocale);
    }

    @Override
    public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
        _roomBooking.setDescriptionCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized descriptions of this room booking from the map of locales and localized descriptions.
    *
    * @param descriptionMap the locales and localized descriptions of this room booking
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
        _roomBooking.setDescriptionMap(descriptionMap);
    }

    /**
    * Sets the localized descriptions of this room booking from the map of locales and localized descriptions, and sets the default locale.
    *
    * @param descriptionMap the locales and localized descriptions of this room booking
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.util.Locale defaultLocale) {
        _roomBooking.setDescriptionMap(descriptionMap, defaultLocale);
    }

    /**
    * Returns the start time of this room booking.
    *
    * @return the start time of this room booking
    */
    @Override
    public long getStartTime() {
        return _roomBooking.getStartTime();
    }

    /**
    * Sets the start time of this room booking.
    *
    * @param startTime the start time of this room booking
    */
    @Override
    public void setStartTime(long startTime) {
        _roomBooking.setStartTime(startTime);
    }

    /**
    * Returns the end time of this room booking.
    *
    * @return the end time of this room booking
    */
    @Override
    public long getEndTime() {
        return _roomBooking.getEndTime();
    }

    /**
    * Sets the end time of this room booking.
    *
    * @param endTime the end time of this room booking
    */
    @Override
    public void setEndTime(long endTime) {
        _roomBooking.setEndTime(endTime);
    }

    /**
    * Returns the all day of this room booking.
    *
    * @return the all day of this room booking
    */
    @Override
    public boolean getAllDay() {
        return _roomBooking.getAllDay();
    }

    /**
    * Returns <code>true</code> if this room booking is all day.
    *
    * @return <code>true</code> if this room booking is all day; <code>false</code> otherwise
    */
    @Override
    public boolean isAllDay() {
        return _roomBooking.isAllDay();
    }

    /**
    * Sets whether this room booking is all day.
    *
    * @param allDay the all day of this room booking
    */
    @Override
    public void setAllDay(boolean allDay) {
        _roomBooking.setAllDay(allDay);
    }

    /**
    * Returns the recurrence of this room booking.
    *
    * @return the recurrence of this room booking
    */
    @Override
    public java.lang.String getRecurrence() {
        return _roomBooking.getRecurrence();
    }

    /**
    * Sets the recurrence of this room booking.
    *
    * @param recurrence the recurrence of this room booking
    */
    @Override
    public void setRecurrence(java.lang.String recurrence) {
        _roomBooking.setRecurrence(recurrence);
    }

    /**
    * Returns the first reminder of this room booking.
    *
    * @return the first reminder of this room booking
    */
    @Override
    public long getFirstReminder() {
        return _roomBooking.getFirstReminder();
    }

    /**
    * Sets the first reminder of this room booking.
    *
    * @param firstReminder the first reminder of this room booking
    */
    @Override
    public void setFirstReminder(long firstReminder) {
        _roomBooking.setFirstReminder(firstReminder);
    }

    /**
    * Returns the first reminder type of this room booking.
    *
    * @return the first reminder type of this room booking
    */
    @Override
    public java.lang.String getFirstReminderType() {
        return _roomBooking.getFirstReminderType();
    }

    /**
    * Sets the first reminder type of this room booking.
    *
    * @param firstReminderType the first reminder type of this room booking
    */
    @Override
    public void setFirstReminderType(java.lang.String firstReminderType) {
        _roomBooking.setFirstReminderType(firstReminderType);
    }

    /**
    * Returns the second reminder of this room booking.
    *
    * @return the second reminder of this room booking
    */
    @Override
    public long getSecondReminder() {
        return _roomBooking.getSecondReminder();
    }

    /**
    * Sets the second reminder of this room booking.
    *
    * @param secondReminder the second reminder of this room booking
    */
    @Override
    public void setSecondReminder(long secondReminder) {
        _roomBooking.setSecondReminder(secondReminder);
    }

    /**
    * Returns the second reminder type of this room booking.
    *
    * @return the second reminder type of this room booking
    */
    @Override
    public java.lang.String getSecondReminderType() {
        return _roomBooking.getSecondReminderType();
    }

    /**
    * Sets the second reminder type of this room booking.
    *
    * @param secondReminderType the second reminder type of this room booking
    */
    @Override
    public void setSecondReminderType(java.lang.String secondReminderType) {
        _roomBooking.setSecondReminderType(secondReminderType);
    }

    /**
    * Returns the status of this room booking.
    *
    * @return the status of this room booking
    */
    @Override
    public int getStatus() {
        return _roomBooking.getStatus();
    }

    /**
    * Sets the status of this room booking.
    *
    * @param status the status of this room booking
    */
    @Override
    public void setStatus(int status) {
        _roomBooking.setStatus(status);
    }

    /**
    * Returns the status by user ID of this room booking.
    *
    * @return the status by user ID of this room booking
    */
    @Override
    public long getStatusByUserId() {
        return _roomBooking.getStatusByUserId();
    }

    /**
    * Sets the status by user ID of this room booking.
    *
    * @param statusByUserId the status by user ID of this room booking
    */
    @Override
    public void setStatusByUserId(long statusByUserId) {
        _roomBooking.setStatusByUserId(statusByUserId);
    }

    /**
    * Returns the status by user uuid of this room booking.
    *
    * @return the status by user uuid of this room booking
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getStatusByUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _roomBooking.getStatusByUserUuid();
    }

    /**
    * Sets the status by user uuid of this room booking.
    *
    * @param statusByUserUuid the status by user uuid of this room booking
    */
    @Override
    public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
        _roomBooking.setStatusByUserUuid(statusByUserUuid);
    }

    /**
    * Returns the status by user name of this room booking.
    *
    * @return the status by user name of this room booking
    */
    @Override
    public java.lang.String getStatusByUserName() {
        return _roomBooking.getStatusByUserName();
    }

    /**
    * Sets the status by user name of this room booking.
    *
    * @param statusByUserName the status by user name of this room booking
    */
    @Override
    public void setStatusByUserName(java.lang.String statusByUserName) {
        _roomBooking.setStatusByUserName(statusByUserName);
    }

    /**
    * Returns the status date of this room booking.
    *
    * @return the status date of this room booking
    */
    @Override
    public java.util.Date getStatusDate() {
        return _roomBooking.getStatusDate();
    }

    /**
    * Sets the status date of this room booking.
    *
    * @param statusDate the status date of this room booking
    */
    @Override
    public void setStatusDate(java.util.Date statusDate) {
        _roomBooking.setStatusDate(statusDate);
    }

    /**
    * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
    */
    @Override
    public boolean getApproved() {
        return _roomBooking.getApproved();
    }

    /**
    * Returns <code>true</code> if this room booking is approved.
    *
    * @return <code>true</code> if this room booking is approved; <code>false</code> otherwise
    */
    @Override
    public boolean isApproved() {
        return _roomBooking.isApproved();
    }

    /**
    * Returns <code>true</code> if this room booking is denied.
    *
    * @return <code>true</code> if this room booking is denied; <code>false</code> otherwise
    */
    @Override
    public boolean isDenied() {
        return _roomBooking.isDenied();
    }

    /**
    * Returns <code>true</code> if this room booking is a draft.
    *
    * @return <code>true</code> if this room booking is a draft; <code>false</code> otherwise
    */
    @Override
    public boolean isDraft() {
        return _roomBooking.isDraft();
    }

    /**
    * Returns <code>true</code> if this room booking is expired.
    *
    * @return <code>true</code> if this room booking is expired; <code>false</code> otherwise
    */
    @Override
    public boolean isExpired() {
        return _roomBooking.isExpired();
    }

    /**
    * Returns <code>true</code> if this room booking is inactive.
    *
    * @return <code>true</code> if this room booking is inactive; <code>false</code> otherwise
    */
    @Override
    public boolean isInactive() {
        return _roomBooking.isInactive();
    }

    /**
    * Returns <code>true</code> if this room booking is incomplete.
    *
    * @return <code>true</code> if this room booking is incomplete; <code>false</code> otherwise
    */
    @Override
    public boolean isIncomplete() {
        return _roomBooking.isIncomplete();
    }

    /**
    * Returns <code>true</code> if this room booking is pending.
    *
    * @return <code>true</code> if this room booking is pending; <code>false</code> otherwise
    */
    @Override
    public boolean isPending() {
        return _roomBooking.isPending();
    }

    /**
    * Returns <code>true</code> if this room booking is scheduled.
    *
    * @return <code>true</code> if this room booking is scheduled; <code>false</code> otherwise
    */
    @Override
    public boolean isScheduled() {
        return _roomBooking.isScheduled();
    }

    @Override
    public boolean isNew() {
        return _roomBooking.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _roomBooking.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _roomBooking.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _roomBooking.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _roomBooking.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _roomBooking.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _roomBooking.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _roomBooking.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _roomBooking.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _roomBooking.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _roomBooking.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _roomBooking.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _roomBooking.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _roomBooking.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _roomBooking.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new RoomBookingWrapper((RoomBooking) _roomBooking.clone());
    }

    @Override
    public int compareTo(RoomBooking roomBooking) {
        return _roomBooking.compareTo(roomBooking);
    }

    @Override
    public int hashCode() {
        return _roomBooking.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<RoomBooking> toCacheModel() {
        return _roomBooking.toCacheModel();
    }

    @Override
    public RoomBooking toEscapedModel() {
        return new RoomBookingWrapper(_roomBooking.toEscapedModel());
    }

    @Override
    public RoomBooking toUnescapedModel() {
        return new RoomBookingWrapper(_roomBooking.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _roomBooking.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _roomBooking.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _roomBooking.persist();
    }

    /**
    * Get Room
    *
    * @return room
    */
    @Override
    public com.zenixia.plugins.model.Room getRoom() {
        return _roomBooking.getRoom();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RoomBookingWrapper)) {
            return false;
        }

        RoomBookingWrapper roomBookingWrapper = (RoomBookingWrapper) obj;

        if (Validator.equals(_roomBooking, roomBookingWrapper._roomBooking)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _roomBooking.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public RoomBooking getWrappedRoomBooking() {
        return _roomBooking;
    }

    @Override
    public RoomBooking getWrappedModel() {
        return _roomBooking;
    }

    @Override
    public void resetOriginalValues() {
        _roomBooking.resetOriginalValues();
    }
}
