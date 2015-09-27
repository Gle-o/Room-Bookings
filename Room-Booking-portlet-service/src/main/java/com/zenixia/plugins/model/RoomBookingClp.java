package com.zenixia.plugins.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.zenixia.plugins.service.ClpSerializer;
import com.zenixia.plugins.service.RoomBookingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class RoomBookingClp extends BaseModelImpl<RoomBooking>
    implements RoomBooking {
    private String _uuid;
    private long _roomBookingId;
    private long _companyId;
    private long _groupId;
    private Date _createDate;
    private Date _modifiedDate;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private long _roomId;
    private String _vEventUid;
    private String _title;
    private String _titleCurrentLanguageId;
    private String _description;
    private String _descriptionCurrentLanguageId;
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
    private String _statusByUserUuid;
    private String _statusByUserName;
    private Date _statusDate;
    private BaseModel<?> _roomBookingRemoteModel;
    private Class<?> _clpSerializerClass = com.zenixia.plugins.service.ClpSerializer.class;

    public RoomBookingClp() {
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
    public long getPrimaryKey() {
        return _roomBookingId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setRoomBookingId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _roomBookingId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_roomBookingRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getRoomBookingId() {
        return _roomBookingId;
    }

    @Override
    public void setRoomBookingId(long roomBookingId) {
        _roomBookingId = roomBookingId;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setRoomBookingId", long.class);

                method.invoke(_roomBookingRemoteModel, roomBookingId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_roomBookingRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_roomBookingRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_roomBookingRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_roomBookingRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_roomBookingRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_roomBookingRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getRoomId() {
        return _roomId;
    }

    @Override
    public void setRoomId(long roomId) {
        _roomId = roomId;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setRoomId", long.class);

                method.invoke(_roomBookingRemoteModel, roomId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getVEventUid() {
        return _vEventUid;
    }

    @Override
    public void setVEventUid(String vEventUid) {
        _vEventUid = vEventUid;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setVEventUid", String.class);

                method.invoke(_roomBookingRemoteModel, vEventUid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public String getTitle(Locale locale) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getTitle(languageId);
    }

    @Override
    public String getTitle(Locale locale, boolean useDefault) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getTitle(languageId, useDefault);
    }

    @Override
    public String getTitle(String languageId) {
        return LocalizationUtil.getLocalization(getTitle(), languageId);
    }

    @Override
    public String getTitle(String languageId, boolean useDefault) {
        return LocalizationUtil.getLocalization(getTitle(), languageId,
            useDefault);
    }

    @Override
    public String getTitleCurrentLanguageId() {
        return _titleCurrentLanguageId;
    }

    @Override
    public String getTitleCurrentValue() {
        Locale locale = getLocale(_titleCurrentLanguageId);

        return getTitle(locale);
    }

    @Override
    public Map<Locale, String> getTitleMap() {
        return LocalizationUtil.getLocalizationMap(getTitle());
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_roomBookingRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public void setTitle(String title, Locale locale) {
        setTitle(title, locale, LocaleUtil.getDefault());
    }

    @Override
    public void setTitle(String title, Locale locale, Locale defaultLocale) {
        String languageId = LocaleUtil.toLanguageId(locale);
        String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

        if (Validator.isNotNull(title)) {
            setTitle(LocalizationUtil.updateLocalization(getTitle(), "Title",
                    title, languageId, defaultLanguageId));
        } else {
            setTitle(LocalizationUtil.removeLocalization(getTitle(), "Title",
                    languageId));
        }
    }

    @Override
    public void setTitleCurrentLanguageId(String languageId) {
        _titleCurrentLanguageId = languageId;
    }

    @Override
    public void setTitleMap(Map<Locale, String> titleMap) {
        setTitleMap(titleMap, LocaleUtil.getDefault());
    }

    @Override
    public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
        if (titleMap == null) {
            return;
        }

        ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(portalClassLoader);
            }

            setTitle(LocalizationUtil.updateLocalization(titleMap, getTitle(),
                    "Title", LocaleUtil.toLanguageId(defaultLocale)));
        } finally {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public String getDescription(Locale locale) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getDescription(languageId);
    }

    @Override
    public String getDescription(Locale locale, boolean useDefault) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getDescription(languageId, useDefault);
    }

    @Override
    public String getDescription(String languageId) {
        return LocalizationUtil.getLocalization(getDescription(), languageId);
    }

    @Override
    public String getDescription(String languageId, boolean useDefault) {
        return LocalizationUtil.getLocalization(getDescription(), languageId,
            useDefault);
    }

    @Override
    public String getDescriptionCurrentLanguageId() {
        return _descriptionCurrentLanguageId;
    }

    @Override
    public String getDescriptionCurrentValue() {
        Locale locale = getLocale(_descriptionCurrentLanguageId);

        return getDescription(locale);
    }

    @Override
    public Map<Locale, String> getDescriptionMap() {
        return LocalizationUtil.getLocalizationMap(getDescription());
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_roomBookingRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public void setDescription(String description, Locale locale) {
        setDescription(description, locale, LocaleUtil.getDefault());
    }

    @Override
    public void setDescription(String description, Locale locale,
        Locale defaultLocale) {
        String languageId = LocaleUtil.toLanguageId(locale);
        String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

        if (Validator.isNotNull(description)) {
            setDescription(LocalizationUtil.updateLocalization(
                    getDescription(), "Description", description, languageId,
                    defaultLanguageId));
        } else {
            setDescription(LocalizationUtil.removeLocalization(
                    getDescription(), "Description", languageId));
        }
    }

    @Override
    public void setDescriptionCurrentLanguageId(String languageId) {
        _descriptionCurrentLanguageId = languageId;
    }

    @Override
    public void setDescriptionMap(Map<Locale, String> descriptionMap) {
        setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
    }

    @Override
    public void setDescriptionMap(Map<Locale, String> descriptionMap,
        Locale defaultLocale) {
        if (descriptionMap == null) {
            return;
        }

        ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(portalClassLoader);
            }

            setDescription(LocalizationUtil.updateLocalization(descriptionMap,
                    getDescription(), "Description",
                    LocaleUtil.toLanguageId(defaultLocale)));
        } finally {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    @Override
    public long getStartTime() {
        return _startTime;
    }

    @Override
    public void setStartTime(long startTime) {
        _startTime = startTime;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setStartTime", long.class);

                method.invoke(_roomBookingRemoteModel, startTime);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getEndTime() {
        return _endTime;
    }

    @Override
    public void setEndTime(long endTime) {
        _endTime = endTime;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setEndTime", long.class);

                method.invoke(_roomBookingRemoteModel, endTime);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getAllDay() {
        return _allDay;
    }

    @Override
    public boolean isAllDay() {
        return _allDay;
    }

    @Override
    public void setAllDay(boolean allDay) {
        _allDay = allDay;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setAllDay", boolean.class);

                method.invoke(_roomBookingRemoteModel, allDay);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRecurrence() {
        return _recurrence;
    }

    @Override
    public void setRecurrence(String recurrence) {
        _recurrence = recurrence;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setRecurrence", String.class);

                method.invoke(_roomBookingRemoteModel, recurrence);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getFirstReminder() {
        return _firstReminder;
    }

    @Override
    public void setFirstReminder(long firstReminder) {
        _firstReminder = firstReminder;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setFirstReminder", long.class);

                method.invoke(_roomBookingRemoteModel, firstReminder);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFirstReminderType() {
        return _firstReminderType;
    }

    @Override
    public void setFirstReminderType(String firstReminderType) {
        _firstReminderType = firstReminderType;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setFirstReminderType",
                        String.class);

                method.invoke(_roomBookingRemoteModel, firstReminderType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getSecondReminder() {
        return _secondReminder;
    }

    @Override
    public void setSecondReminder(long secondReminder) {
        _secondReminder = secondReminder;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setSecondReminder", long.class);

                method.invoke(_roomBookingRemoteModel, secondReminder);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSecondReminderType() {
        return _secondReminderType;
    }

    @Override
    public void setSecondReminderType(String secondReminderType) {
        _secondReminderType = secondReminderType;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setSecondReminderType",
                        String.class);

                method.invoke(_roomBookingRemoteModel, secondReminderType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_roomBookingRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getStatusByUserId() {
        return _statusByUserId;
    }

    @Override
    public void setStatusByUserId(long statusByUserId) {
        _statusByUserId = statusByUserId;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusByUserId", long.class);

                method.invoke(_roomBookingRemoteModel, statusByUserId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatusByUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
            _statusByUserUuid);
    }

    @Override
    public void setStatusByUserUuid(String statusByUserUuid) {
        _statusByUserUuid = statusByUserUuid;
    }

    @Override
    public String getStatusByUserName() {
        return _statusByUserName;
    }

    @Override
    public void setStatusByUserName(String statusByUserName) {
        _statusByUserName = statusByUserName;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusByUserName",
                        String.class);

                method.invoke(_roomBookingRemoteModel, statusByUserName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getStatusDate() {
        return _statusDate;
    }

    @Override
    public void setStatusDate(Date statusDate) {
        _statusDate = statusDate;

        if (_roomBookingRemoteModel != null) {
            try {
                Class<?> clazz = _roomBookingRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusDate", Date.class);

                method.invoke(_roomBookingRemoteModel, statusDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public com.zenixia.plugins.model.Room getRoom() {
        try {
            String methodName = "getRoom";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            com.zenixia.plugins.model.Room returnObj = (com.zenixia.plugins.model.Room) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                RoomBooking.class.getName()));
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #isApproved}
     */
    @Override
    public boolean getApproved() {
        return isApproved();
    }

    @Override
    public boolean isApproved() {
        if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDenied() {
        if (getStatus() == WorkflowConstants.STATUS_DENIED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDraft() {
        if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isExpired() {
        if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isInactive() {
        if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isIncomplete() {
        if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isPending() {
        if (getStatus() == WorkflowConstants.STATUS_PENDING) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isScheduled() {
        if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
            return true;
        } else {
            return false;
        }
    }

    public BaseModel<?> getRoomBookingRemoteModel() {
        return _roomBookingRemoteModel;
    }

    public void setRoomBookingRemoteModel(BaseModel<?> roomBookingRemoteModel) {
        _roomBookingRemoteModel = roomBookingRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _roomBookingRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_roomBookingRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            RoomBookingLocalServiceUtil.addRoomBooking(this);
        } else {
            RoomBookingLocalServiceUtil.updateRoomBooking(this);
        }
    }

    @Override
    public String[] getAvailableLanguageIds() {
        Set<String> availableLanguageIds = new TreeSet<String>();

        Map<Locale, String> titleMap = getTitleMap();

        for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
            Locale locale = entry.getKey();
            String value = entry.getValue();

            if (Validator.isNotNull(value)) {
                availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
            }
        }

        Map<Locale, String> descriptionMap = getDescriptionMap();

        for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
            Locale locale = entry.getKey();
            String value = entry.getValue();

            if (Validator.isNotNull(value)) {
                availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
            }
        }

        return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
    }

    @Override
    public String getDefaultLanguageId() {
        String xml = getTitle();

        if (xml == null) {
            return StringPool.BLANK;
        }

        return LocalizationUtil.getDefaultLanguageId(xml);
    }

    @Override
    public void prepareLocalizedFieldsForImport() throws LocaleException {
        prepareLocalizedFieldsForImport(null);
    }

    @Override
    @SuppressWarnings("unused")
    public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
        throws LocaleException {
        Locale defaultLocale = LocaleUtil.getDefault();

        String modelDefaultLanguageId = getDefaultLanguageId();

        String title = getTitle(defaultLocale);

        if (Validator.isNull(title)) {
            setTitle(getTitle(modelDefaultLanguageId), defaultLocale);
        } else {
            setTitle(getTitle(defaultLocale), defaultLocale, defaultLocale);
        }

        String description = getDescription(defaultLocale);

        if (Validator.isNull(description)) {
            setDescription(getDescription(modelDefaultLanguageId), defaultLocale);
        } else {
            setDescription(getDescription(defaultLocale), defaultLocale,
                defaultLocale);
        }
    }

    @Override
    public RoomBooking toEscapedModel() {
        return (RoomBooking) ProxyUtil.newProxyInstance(RoomBooking.class.getClassLoader(),
            new Class[] { RoomBooking.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        RoomBookingClp clone = new RoomBookingClp();

        clone.setUuid(getUuid());
        clone.setRoomBookingId(getRoomBookingId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setRoomId(getRoomId());
        clone.setVEventUid(getVEventUid());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setStartTime(getStartTime());
        clone.setEndTime(getEndTime());
        clone.setAllDay(getAllDay());
        clone.setRecurrence(getRecurrence());
        clone.setFirstReminder(getFirstReminder());
        clone.setFirstReminderType(getFirstReminderType());
        clone.setSecondReminder(getSecondReminder());
        clone.setSecondReminderType(getSecondReminderType());
        clone.setStatus(getStatus());
        clone.setStatusByUserId(getStatusByUserId());
        clone.setStatusByUserName(getStatusByUserName());
        clone.setStatusDate(getStatusDate());

        return clone;
    }

    @Override
    public int compareTo(RoomBooking roomBooking) {
        int value = 0;

        if (getStartTime() < roomBooking.getStartTime()) {
            value = -1;
        } else if (getStartTime() > roomBooking.getStartTime()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RoomBookingClp)) {
            return false;
        }

        RoomBookingClp roomBooking = (RoomBookingClp) obj;

        long primaryKey = roomBooking.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(49);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", roomBookingId=");
        sb.append(getRoomBookingId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", roomId=");
        sb.append(getRoomId());
        sb.append(", vEventUid=");
        sb.append(getVEventUid());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", startTime=");
        sb.append(getStartTime());
        sb.append(", endTime=");
        sb.append(getEndTime());
        sb.append(", allDay=");
        sb.append(getAllDay());
        sb.append(", recurrence=");
        sb.append(getRecurrence());
        sb.append(", firstReminder=");
        sb.append(getFirstReminder());
        sb.append(", firstReminderType=");
        sb.append(getFirstReminderType());
        sb.append(", secondReminder=");
        sb.append(getSecondReminder());
        sb.append(", secondReminderType=");
        sb.append(getSecondReminderType());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", statusByUserId=");
        sb.append(getStatusByUserId());
        sb.append(", statusByUserName=");
        sb.append(getStatusByUserName());
        sb.append(", statusDate=");
        sb.append(getStatusDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(76);

        sb.append("<model><model-name>");
        sb.append("com.zenixia.plugins.model.RoomBooking");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>roomBookingId</column-name><column-value><![CDATA[");
        sb.append(getRoomBookingId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>roomId</column-name><column-value><![CDATA[");
        sb.append(getRoomId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>vEventUid</column-name><column-value><![CDATA[");
        sb.append(getVEventUid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>startTime</column-name><column-value><![CDATA[");
        sb.append(getStartTime());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>endTime</column-name><column-value><![CDATA[");
        sb.append(getEndTime());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>allDay</column-name><column-value><![CDATA[");
        sb.append(getAllDay());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>recurrence</column-name><column-value><![CDATA[");
        sb.append(getRecurrence());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>firstReminder</column-name><column-value><![CDATA[");
        sb.append(getFirstReminder());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>firstReminderType</column-name><column-value><![CDATA[");
        sb.append(getFirstReminderType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>secondReminder</column-name><column-value><![CDATA[");
        sb.append(getSecondReminder());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>secondReminderType</column-name><column-value><![CDATA[");
        sb.append(getSecondReminderType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
        sb.append(getStatusByUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
        sb.append(getStatusByUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusDate</column-name><column-value><![CDATA[");
        sb.append(getStatusDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
