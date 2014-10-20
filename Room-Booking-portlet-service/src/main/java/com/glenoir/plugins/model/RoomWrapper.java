package com.glenoir.plugins.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Room}.
 * </p>
 *
 * @author guillaume Lenoir
 * @see Room
 * @generated
 */
public class RoomWrapper implements Room, ModelWrapper<Room> {
    private Room _room;

    public RoomWrapper(Room room) {
        _room = room;
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
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("roomId", getRoomId());
        attributes.put("companyId", getCompanyId());
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

    /**
    * Returns the primary key of this room.
    *
    * @return the primary key of this room
    */
    @Override
    public long getPrimaryKey() {
        return _room.getPrimaryKey();
    }

    /**
    * Sets the primary key of this room.
    *
    * @param primaryKey the primary key of this room
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _room.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this room.
    *
    * @return the uuid of this room
    */
    @Override
    public java.lang.String getUuid() {
        return _room.getUuid();
    }

    /**
    * Sets the uuid of this room.
    *
    * @param uuid the uuid of this room
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _room.setUuid(uuid);
    }

    /**
    * Returns the room ID of this room.
    *
    * @return the room ID of this room
    */
    @Override
    public long getRoomId() {
        return _room.getRoomId();
    }

    /**
    * Sets the room ID of this room.
    *
    * @param roomId the room ID of this room
    */
    @Override
    public void setRoomId(long roomId) {
        _room.setRoomId(roomId);
    }

    /**
    * Returns the company ID of this room.
    *
    * @return the company ID of this room
    */
    @Override
    public long getCompanyId() {
        return _room.getCompanyId();
    }

    /**
    * Sets the company ID of this room.
    *
    * @param companyId the company ID of this room
    */
    @Override
    public void setCompanyId(long companyId) {
        _room.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this room.
    *
    * @return the user ID of this room
    */
    @Override
    public long getUserId() {
        return _room.getUserId();
    }

    /**
    * Sets the user ID of this room.
    *
    * @param userId the user ID of this room
    */
    @Override
    public void setUserId(long userId) {
        _room.setUserId(userId);
    }

    /**
    * Returns the user uuid of this room.
    *
    * @return the user uuid of this room
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _room.getUserUuid();
    }

    /**
    * Sets the user uuid of this room.
    *
    * @param userUuid the user uuid of this room
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _room.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this room.
    *
    * @return the user name of this room
    */
    @Override
    public java.lang.String getUserName() {
        return _room.getUserName();
    }

    /**
    * Sets the user name of this room.
    *
    * @param userName the user name of this room
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _room.setUserName(userName);
    }

    /**
    * Returns the create date of this room.
    *
    * @return the create date of this room
    */
    @Override
    public java.util.Date getCreateDate() {
        return _room.getCreateDate();
    }

    /**
    * Sets the create date of this room.
    *
    * @param createDate the create date of this room
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _room.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this room.
    *
    * @return the modified date of this room
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _room.getModifiedDate();
    }

    /**
    * Sets the modified date of this room.
    *
    * @param modifiedDate the modified date of this room
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _room.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this room.
    *
    * @return the name of this room
    */
    @Override
    public java.lang.String getName() {
        return _room.getName();
    }

    /**
    * Returns the localized name of this room in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized name of this room
    */
    @Override
    public java.lang.String getName(java.util.Locale locale) {
        return _room.getName(locale);
    }

    /**
    * Returns the localized name of this room in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this room. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
        return _room.getName(locale, useDefault);
    }

    /**
    * Returns the localized name of this room in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized name of this room
    */
    @Override
    public java.lang.String getName(java.lang.String languageId) {
        return _room.getName(languageId);
    }

    /**
    * Returns the localized name of this room in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this room
    */
    @Override
    public java.lang.String getName(java.lang.String languageId,
        boolean useDefault) {
        return _room.getName(languageId, useDefault);
    }

    @Override
    public java.lang.String getNameCurrentLanguageId() {
        return _room.getNameCurrentLanguageId();
    }

    @Override
    public java.lang.String getNameCurrentValue() {
        return _room.getNameCurrentValue();
    }

    /**
    * Returns a map of the locales and localized names of this room.
    *
    * @return the locales and localized names of this room
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
        return _room.getNameMap();
    }

    /**
    * Sets the name of this room.
    *
    * @param name the name of this room
    */
    @Override
    public void setName(java.lang.String name) {
        _room.setName(name);
    }

    /**
    * Sets the localized name of this room in the language.
    *
    * @param name the localized name of this room
    * @param locale the locale of the language
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale) {
        _room.setName(name, locale);
    }

    /**
    * Sets the localized name of this room in the language, and sets the default locale.
    *
    * @param name the localized name of this room
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _room.setName(name, locale, defaultLocale);
    }

    @Override
    public void setNameCurrentLanguageId(java.lang.String languageId) {
        _room.setNameCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized names of this room from the map of locales and localized names.
    *
    * @param nameMap the locales and localized names of this room
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap) {
        _room.setNameMap(nameMap);
    }

    /**
    * Sets the localized names of this room from the map of locales and localized names, and sets the default locale.
    *
    * @param nameMap the locales and localized names of this room
    * @param defaultLocale the default locale
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Locale defaultLocale) {
        _room.setNameMap(nameMap, defaultLocale);
    }

    /**
    * Returns the description of this room.
    *
    * @return the description of this room
    */
    @Override
    public java.lang.String getDescription() {
        return _room.getDescription();
    }

    /**
    * Returns the localized description of this room in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized description of this room
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale) {
        return _room.getDescription(locale);
    }

    /**
    * Returns the localized description of this room in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this room. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale,
        boolean useDefault) {
        return _room.getDescription(locale, useDefault);
    }

    /**
    * Returns the localized description of this room in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized description of this room
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId) {
        return _room.getDescription(languageId);
    }

    /**
    * Returns the localized description of this room in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this room
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId,
        boolean useDefault) {
        return _room.getDescription(languageId, useDefault);
    }

    @Override
    public java.lang.String getDescriptionCurrentLanguageId() {
        return _room.getDescriptionCurrentLanguageId();
    }

    @Override
    public java.lang.String getDescriptionCurrentValue() {
        return _room.getDescriptionCurrentValue();
    }

    /**
    * Returns a map of the locales and localized descriptions of this room.
    *
    * @return the locales and localized descriptions of this room
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
        return _room.getDescriptionMap();
    }

    /**
    * Sets the description of this room.
    *
    * @param description the description of this room
    */
    @Override
    public void setDescription(java.lang.String description) {
        _room.setDescription(description);
    }

    /**
    * Sets the localized description of this room in the language.
    *
    * @param description the localized description of this room
    * @param locale the locale of the language
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale) {
        _room.setDescription(description, locale);
    }

    /**
    * Sets the localized description of this room in the language, and sets the default locale.
    *
    * @param description the localized description of this room
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale, java.util.Locale defaultLocale) {
        _room.setDescription(description, locale, defaultLocale);
    }

    @Override
    public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
        _room.setDescriptionCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized descriptions of this room from the map of locales and localized descriptions.
    *
    * @param descriptionMap the locales and localized descriptions of this room
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
        _room.setDescriptionMap(descriptionMap);
    }

    /**
    * Sets the localized descriptions of this room from the map of locales and localized descriptions, and sets the default locale.
    *
    * @param descriptionMap the locales and localized descriptions of this room
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.util.Locale defaultLocale) {
        _room.setDescriptionMap(descriptionMap, defaultLocale);
    }

    /**
    * Returns the capacity of this room.
    *
    * @return the capacity of this room
    */
    @Override
    public int getCapacity() {
        return _room.getCapacity();
    }

    /**
    * Sets the capacity of this room.
    *
    * @param capacity the capacity of this room
    */
    @Override
    public void setCapacity(int capacity) {
        _room.setCapacity(capacity);
    }

    /**
    * Returns the level of this room.
    *
    * @return the level of this room
    */
    @Override
    public int getLevel() {
        return _room.getLevel();
    }

    /**
    * Sets the level of this room.
    *
    * @param level the level of this room
    */
    @Override
    public void setLevel(int level) {
        _room.setLevel(level);
    }

    @Override
    public boolean isNew() {
        return _room.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _room.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _room.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _room.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _room.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _room.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _room.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _room.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _room.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _room.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _room.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _room.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _room.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _room.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _room.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new RoomWrapper((Room) _room.clone());
    }

    @Override
    public int compareTo(Room room) {
        return _room.compareTo(room);
    }

    @Override
    public int hashCode() {
        return _room.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Room> toCacheModel() {
        return _room.toCacheModel();
    }

    @Override
    public Room toEscapedModel() {
        return new RoomWrapper(_room.toEscapedModel());
    }

    @Override
    public Room toUnescapedModel() {
        return new RoomWrapper(_room.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _room.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _room.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _room.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RoomWrapper)) {
            return false;
        }

        RoomWrapper roomWrapper = (RoomWrapper) obj;

        if (Validator.equals(_room, roomWrapper._room)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _room.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Room getWrappedRoom() {
        return _room;
    }

    @Override
    public Room getWrappedModel() {
        return _room;
    }

    @Override
    public void resetOriginalValues() {
        _room.resetOriginalValues();
    }
}
