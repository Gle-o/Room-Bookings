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
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.zenixia.plugins.service.ClpSerializer;
import com.zenixia.plugins.service.RoomLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class RoomClp extends BaseModelImpl<Room> implements Room {
    private String _uuid;
    private long _roomId;
    private long _companyId;
    private long _groupId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _nameCurrentLanguageId;
    private String _description;
    private String _descriptionCurrentLanguageId;
    private int _capacity;
    private int _level;
    private BaseModel<?> _roomRemoteModel;
    private Class<?> _clpSerializerClass = com.zenixia.plugins.service.ClpSerializer.class;

    public RoomClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Room.class;
    }

    @Override
    public String getModelClassName() {
        return Room.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _roomId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setRoomId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _roomId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("roomId", getRoomId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("capacity", getCapacity());
        attributes.put("level", getLevel());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long roomId = (Long) attributes.get("roomId");

        if (roomId != null) {
            setRoomId(roomId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Integer capacity = (Integer) attributes.get("capacity");

        if (capacity != null) {
            setCapacity(capacity);
        }

        Integer level = (Integer) attributes.get("level");

        if (level != null) {
            setLevel(level);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_roomRemoteModel != null) {
            try {
                Class<?> clazz = _roomRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_roomRemoteModel, uuid);
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

        if (_roomRemoteModel != null) {
            try {
                Class<?> clazz = _roomRemoteModel.getClass();

                Method method = clazz.getMethod("setRoomId", long.class);

                method.invoke(_roomRemoteModel, roomId);
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

        if (_roomRemoteModel != null) {
            try {
                Class<?> clazz = _roomRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_roomRemoteModel, companyId);
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

        if (_roomRemoteModel != null) {
            try {
                Class<?> clazz = _roomRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_roomRemoteModel, groupId);
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

        if (_roomRemoteModel != null) {
            try {
                Class<?> clazz = _roomRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_roomRemoteModel, userId);
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

        if (_roomRemoteModel != null) {
            try {
                Class<?> clazz = _roomRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_roomRemoteModel, userName);
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

        if (_roomRemoteModel != null) {
            try {
                Class<?> clazz = _roomRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_roomRemoteModel, createDate);
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

        if (_roomRemoteModel != null) {
            try {
                Class<?> clazz = _roomRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_roomRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public String getName(Locale locale) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getName(languageId);
    }

    @Override
    public String getName(Locale locale, boolean useDefault) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getName(languageId, useDefault);
    }

    @Override
    public String getName(String languageId) {
        return LocalizationUtil.getLocalization(getName(), languageId);
    }

    @Override
    public String getName(String languageId, boolean useDefault) {
        return LocalizationUtil.getLocalization(getName(), languageId,
            useDefault);
    }

    @Override
    public String getNameCurrentLanguageId() {
        return _nameCurrentLanguageId;
    }

    @Override
    public String getNameCurrentValue() {
        Locale locale = getLocale(_nameCurrentLanguageId);

        return getName(locale);
    }

    @Override
    public Map<Locale, String> getNameMap() {
        return LocalizationUtil.getLocalizationMap(getName());
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_roomRemoteModel != null) {
            try {
                Class<?> clazz = _roomRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_roomRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public void setName(String name, Locale locale) {
        setName(name, locale, LocaleUtil.getDefault());
    }

    @Override
    public void setName(String name, Locale locale, Locale defaultLocale) {
        String languageId = LocaleUtil.toLanguageId(locale);
        String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

        if (Validator.isNotNull(name)) {
            setName(LocalizationUtil.updateLocalization(getName(), "Name",
                    name, languageId, defaultLanguageId));
        } else {
            setName(LocalizationUtil.removeLocalization(getName(), "Name",
                    languageId));
        }
    }

    @Override
    public void setNameCurrentLanguageId(String languageId) {
        _nameCurrentLanguageId = languageId;
    }

    @Override
    public void setNameMap(Map<Locale, String> nameMap) {
        setNameMap(nameMap, LocaleUtil.getDefault());
    }

    @Override
    public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
        if (nameMap == null) {
            return;
        }

        ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(portalClassLoader);
            }

            setName(LocalizationUtil.updateLocalization(nameMap, getName(),
                    "Name", LocaleUtil.toLanguageId(defaultLocale)));
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

        if (_roomRemoteModel != null) {
            try {
                Class<?> clazz = _roomRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_roomRemoteModel, description);
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
    public int getCapacity() {
        return _capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        _capacity = capacity;

        if (_roomRemoteModel != null) {
            try {
                Class<?> clazz = _roomRemoteModel.getClass();

                Method method = clazz.getMethod("setCapacity", int.class);

                method.invoke(_roomRemoteModel, capacity);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getLevel() {
        return _level;
    }

    @Override
    public void setLevel(int level) {
        _level = level;

        if (_roomRemoteModel != null) {
            try {
                Class<?> clazz = _roomRemoteModel.getClass();

                Method method = clazz.getMethod("setLevel", int.class);

                method.invoke(_roomRemoteModel, level);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long[] getCurrentEquipementIds() {
        try {
            String methodName = "getCurrentEquipementIds";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            long[] returnObj = (long[]) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public java.util.List<com.zenixia.plugins.model.Equipment> getEquipements() {
        try {
            String methodName = "getEquipements";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            java.util.List<com.zenixia.plugins.model.Equipment> returnObj = (java.util.List<com.zenixia.plugins.model.Equipment>) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public void setCurrentEquipementIds(long[] currentEquipementIds) {
        try {
            String methodName = "setCurrentEquipementIds";

            Class<?>[] parameterTypes = new Class<?>[] { long.class };

            Object[] parameterValues = new Object[] { currentEquipementIds };

            invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Room.class.getName()));
    }

    public BaseModel<?> getRoomRemoteModel() {
        return _roomRemoteModel;
    }

    public void setRoomRemoteModel(BaseModel<?> roomRemoteModel) {
        _roomRemoteModel = roomRemoteModel;
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

        Class<?> remoteModelClass = _roomRemoteModel.getClass();

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

        Object returnValue = method.invoke(_roomRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            RoomLocalServiceUtil.addRoom(this);
        } else {
            RoomLocalServiceUtil.updateRoom(this);
        }
    }

    @Override
    public String[] getAvailableLanguageIds() {
        Set<String> availableLanguageIds = new TreeSet<String>();

        Map<Locale, String> nameMap = getNameMap();

        for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
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
        String xml = getName();

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

        String name = getName(defaultLocale);

        if (Validator.isNull(name)) {
            setName(getName(modelDefaultLanguageId), defaultLocale);
        } else {
            setName(getName(defaultLocale), defaultLocale, defaultLocale);
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
    public Room toEscapedModel() {
        return (Room) ProxyUtil.newProxyInstance(Room.class.getClassLoader(),
            new Class[] { Room.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        RoomClp clone = new RoomClp();

        clone.setUuid(getUuid());
        clone.setRoomId(getRoomId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setCapacity(getCapacity());
        clone.setLevel(getLevel());

        return clone;
    }

    @Override
    public int compareTo(Room room) {
        int value = 0;

        value = getName().compareTo(room.getName());

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

        if (!(obj instanceof RoomClp)) {
            return false;
        }

        RoomClp room = (RoomClp) obj;

        long primaryKey = room.getPrimaryKey();

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
        StringBundler sb = new StringBundler(25);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", roomId=");
        sb.append(getRoomId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", capacity=");
        sb.append(getCapacity());
        sb.append(", level=");
        sb.append(getLevel());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("com.zenixia.plugins.model.Room");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>roomId</column-name><column-value><![CDATA[");
        sb.append(getRoomId());
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
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
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
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>capacity</column-name><column-value><![CDATA[");
        sb.append(getCapacity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>level</column-name><column-value><![CDATA[");
        sb.append(getLevel());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
