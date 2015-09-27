package com.zenixia.plugins.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Equipment}.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see Equipment
 * @generated
 */
public class EquipmentWrapper implements Equipment, ModelWrapper<Equipment> {
    private Equipment _equipment;

    public EquipmentWrapper(Equipment equipment) {
        _equipment = equipment;
    }

    @Override
    public Class<?> getModelClass() {
        return Equipment.class;
    }

    @Override
    public String getModelClassName() {
        return Equipment.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("equipmentId", getEquipmentId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("reference", getReference());
        attributes.put("equipmentTypeId", getEquipmentTypeId());
        attributes.put("roomId", getRoomId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long equipmentId = (Long) attributes.get("equipmentId");

        if (equipmentId != null) {
            setEquipmentId(equipmentId);
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

        String reference = (String) attributes.get("reference");

        if (reference != null) {
            setReference(reference);
        }

        Long equipmentTypeId = (Long) attributes.get("equipmentTypeId");

        if (equipmentTypeId != null) {
            setEquipmentTypeId(equipmentTypeId);
        }

        Long roomId = (Long) attributes.get("roomId");

        if (roomId != null) {
            setRoomId(roomId);
        }
    }

    /**
    * Returns the primary key of this equipment.
    *
    * @return the primary key of this equipment
    */
    @Override
    public long getPrimaryKey() {
        return _equipment.getPrimaryKey();
    }

    /**
    * Sets the primary key of this equipment.
    *
    * @param primaryKey the primary key of this equipment
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _equipment.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this equipment.
    *
    * @return the uuid of this equipment
    */
    @Override
    public java.lang.String getUuid() {
        return _equipment.getUuid();
    }

    /**
    * Sets the uuid of this equipment.
    *
    * @param uuid the uuid of this equipment
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _equipment.setUuid(uuid);
    }

    /**
    * Returns the equipment ID of this equipment.
    *
    * @return the equipment ID of this equipment
    */
    @Override
    public long getEquipmentId() {
        return _equipment.getEquipmentId();
    }

    /**
    * Sets the equipment ID of this equipment.
    *
    * @param equipmentId the equipment ID of this equipment
    */
    @Override
    public void setEquipmentId(long equipmentId) {
        _equipment.setEquipmentId(equipmentId);
    }

    /**
    * Returns the company ID of this equipment.
    *
    * @return the company ID of this equipment
    */
    @Override
    public long getCompanyId() {
        return _equipment.getCompanyId();
    }

    /**
    * Sets the company ID of this equipment.
    *
    * @param companyId the company ID of this equipment
    */
    @Override
    public void setCompanyId(long companyId) {
        _equipment.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this equipment.
    *
    * @return the group ID of this equipment
    */
    @Override
    public long getGroupId() {
        return _equipment.getGroupId();
    }

    /**
    * Sets the group ID of this equipment.
    *
    * @param groupId the group ID of this equipment
    */
    @Override
    public void setGroupId(long groupId) {
        _equipment.setGroupId(groupId);
    }

    /**
    * Returns the user ID of this equipment.
    *
    * @return the user ID of this equipment
    */
    @Override
    public long getUserId() {
        return _equipment.getUserId();
    }

    /**
    * Sets the user ID of this equipment.
    *
    * @param userId the user ID of this equipment
    */
    @Override
    public void setUserId(long userId) {
        _equipment.setUserId(userId);
    }

    /**
    * Returns the user uuid of this equipment.
    *
    * @return the user uuid of this equipment
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipment.getUserUuid();
    }

    /**
    * Sets the user uuid of this equipment.
    *
    * @param userUuid the user uuid of this equipment
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _equipment.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this equipment.
    *
    * @return the user name of this equipment
    */
    @Override
    public java.lang.String getUserName() {
        return _equipment.getUserName();
    }

    /**
    * Sets the user name of this equipment.
    *
    * @param userName the user name of this equipment
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _equipment.setUserName(userName);
    }

    /**
    * Returns the create date of this equipment.
    *
    * @return the create date of this equipment
    */
    @Override
    public java.util.Date getCreateDate() {
        return _equipment.getCreateDate();
    }

    /**
    * Sets the create date of this equipment.
    *
    * @param createDate the create date of this equipment
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _equipment.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this equipment.
    *
    * @return the modified date of this equipment
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _equipment.getModifiedDate();
    }

    /**
    * Sets the modified date of this equipment.
    *
    * @param modifiedDate the modified date of this equipment
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _equipment.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this equipment.
    *
    * @return the name of this equipment
    */
    @Override
    public java.lang.String getName() {
        return _equipment.getName();
    }

    /**
    * Returns the localized name of this equipment in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized name of this equipment
    */
    @Override
    public java.lang.String getName(java.util.Locale locale) {
        return _equipment.getName(locale);
    }

    /**
    * Returns the localized name of this equipment in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this equipment. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
        return _equipment.getName(locale, useDefault);
    }

    /**
    * Returns the localized name of this equipment in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized name of this equipment
    */
    @Override
    public java.lang.String getName(java.lang.String languageId) {
        return _equipment.getName(languageId);
    }

    /**
    * Returns the localized name of this equipment in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this equipment
    */
    @Override
    public java.lang.String getName(java.lang.String languageId,
        boolean useDefault) {
        return _equipment.getName(languageId, useDefault);
    }

    @Override
    public java.lang.String getNameCurrentLanguageId() {
        return _equipment.getNameCurrentLanguageId();
    }

    @Override
    public java.lang.String getNameCurrentValue() {
        return _equipment.getNameCurrentValue();
    }

    /**
    * Returns a map of the locales and localized names of this equipment.
    *
    * @return the locales and localized names of this equipment
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
        return _equipment.getNameMap();
    }

    /**
    * Sets the name of this equipment.
    *
    * @param name the name of this equipment
    */
    @Override
    public void setName(java.lang.String name) {
        _equipment.setName(name);
    }

    /**
    * Sets the localized name of this equipment in the language.
    *
    * @param name the localized name of this equipment
    * @param locale the locale of the language
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale) {
        _equipment.setName(name, locale);
    }

    /**
    * Sets the localized name of this equipment in the language, and sets the default locale.
    *
    * @param name the localized name of this equipment
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _equipment.setName(name, locale, defaultLocale);
    }

    @Override
    public void setNameCurrentLanguageId(java.lang.String languageId) {
        _equipment.setNameCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized names of this equipment from the map of locales and localized names.
    *
    * @param nameMap the locales and localized names of this equipment
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap) {
        _equipment.setNameMap(nameMap);
    }

    /**
    * Sets the localized names of this equipment from the map of locales and localized names, and sets the default locale.
    *
    * @param nameMap the locales and localized names of this equipment
    * @param defaultLocale the default locale
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Locale defaultLocale) {
        _equipment.setNameMap(nameMap, defaultLocale);
    }

    /**
    * Returns the reference of this equipment.
    *
    * @return the reference of this equipment
    */
    @Override
    public java.lang.String getReference() {
        return _equipment.getReference();
    }

    /**
    * Sets the reference of this equipment.
    *
    * @param reference the reference of this equipment
    */
    @Override
    public void setReference(java.lang.String reference) {
        _equipment.setReference(reference);
    }

    /**
    * Returns the equipment type ID of this equipment.
    *
    * @return the equipment type ID of this equipment
    */
    @Override
    public long getEquipmentTypeId() {
        return _equipment.getEquipmentTypeId();
    }

    /**
    * Sets the equipment type ID of this equipment.
    *
    * @param equipmentTypeId the equipment type ID of this equipment
    */
    @Override
    public void setEquipmentTypeId(long equipmentTypeId) {
        _equipment.setEquipmentTypeId(equipmentTypeId);
    }

    /**
    * Returns the room ID of this equipment.
    *
    * @return the room ID of this equipment
    */
    @Override
    public long getRoomId() {
        return _equipment.getRoomId();
    }

    /**
    * Sets the room ID of this equipment.
    *
    * @param roomId the room ID of this equipment
    */
    @Override
    public void setRoomId(long roomId) {
        _equipment.setRoomId(roomId);
    }

    @Override
    public boolean isNew() {
        return _equipment.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _equipment.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _equipment.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _equipment.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _equipment.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _equipment.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _equipment.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _equipment.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _equipment.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _equipment.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _equipment.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _equipment.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _equipment.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _equipment.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _equipment.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new EquipmentWrapper((Equipment) _equipment.clone());
    }

    @Override
    public int compareTo(Equipment equipment) {
        return _equipment.compareTo(equipment);
    }

    @Override
    public int hashCode() {
        return _equipment.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Equipment> toCacheModel() {
        return _equipment.toCacheModel();
    }

    @Override
    public Equipment toEscapedModel() {
        return new EquipmentWrapper(_equipment.toEscapedModel());
    }

    @Override
    public Equipment toUnescapedModel() {
        return new EquipmentWrapper(_equipment.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _equipment.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _equipment.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _equipment.persist();
    }

    @Override
    public java.lang.String getEquipmentTypeName(java.util.Locale locale) {
        return _equipment.getEquipmentTypeName(locale);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EquipmentWrapper)) {
            return false;
        }

        EquipmentWrapper equipmentWrapper = (EquipmentWrapper) obj;

        if (Validator.equals(_equipment, equipmentWrapper._equipment)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _equipment.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Equipment getWrappedEquipment() {
        return _equipment;
    }

    @Override
    public Equipment getWrappedModel() {
        return _equipment;
    }

    @Override
    public void resetOriginalValues() {
        _equipment.resetOriginalValues();
    }
}
