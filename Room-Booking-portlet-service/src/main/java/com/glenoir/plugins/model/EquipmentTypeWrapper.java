package com.glenoir.plugins.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EquipmentType}.
 * </p>
 *
 * @author guillaume Lenoir
 * @see EquipmentType
 * @generated
 */
public class EquipmentTypeWrapper implements EquipmentType,
    ModelWrapper<EquipmentType> {
    private EquipmentType _equipmentType;

    public EquipmentTypeWrapper(EquipmentType equipmentType) {
        _equipmentType = equipmentType;
    }

    @Override
    public Class<?> getModelClass() {
        return EquipmentType.class;
    }

    @Override
    public String getModelClassName() {
        return EquipmentType.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("equipmentTypeId", getEquipmentTypeId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long equipmentTypeId = (Long) attributes.get("equipmentTypeId");

        if (equipmentTypeId != null) {
            setEquipmentTypeId(equipmentTypeId);
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
    }

    /**
    * Returns the primary key of this equipment type.
    *
    * @return the primary key of this equipment type
    */
    @Override
    public long getPrimaryKey() {
        return _equipmentType.getPrimaryKey();
    }

    /**
    * Sets the primary key of this equipment type.
    *
    * @param primaryKey the primary key of this equipment type
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _equipmentType.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this equipment type.
    *
    * @return the uuid of this equipment type
    */
    @Override
    public java.lang.String getUuid() {
        return _equipmentType.getUuid();
    }

    /**
    * Sets the uuid of this equipment type.
    *
    * @param uuid the uuid of this equipment type
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _equipmentType.setUuid(uuid);
    }

    /**
    * Returns the equipment type ID of this equipment type.
    *
    * @return the equipment type ID of this equipment type
    */
    @Override
    public long getEquipmentTypeId() {
        return _equipmentType.getEquipmentTypeId();
    }

    /**
    * Sets the equipment type ID of this equipment type.
    *
    * @param equipmentTypeId the equipment type ID of this equipment type
    */
    @Override
    public void setEquipmentTypeId(long equipmentTypeId) {
        _equipmentType.setEquipmentTypeId(equipmentTypeId);
    }

    /**
    * Returns the company ID of this equipment type.
    *
    * @return the company ID of this equipment type
    */
    @Override
    public long getCompanyId() {
        return _equipmentType.getCompanyId();
    }

    /**
    * Sets the company ID of this equipment type.
    *
    * @param companyId the company ID of this equipment type
    */
    @Override
    public void setCompanyId(long companyId) {
        _equipmentType.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this equipment type.
    *
    * @return the user ID of this equipment type
    */
    @Override
    public long getUserId() {
        return _equipmentType.getUserId();
    }

    /**
    * Sets the user ID of this equipment type.
    *
    * @param userId the user ID of this equipment type
    */
    @Override
    public void setUserId(long userId) {
        _equipmentType.setUserId(userId);
    }

    /**
    * Returns the user uuid of this equipment type.
    *
    * @return the user uuid of this equipment type
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _equipmentType.getUserUuid();
    }

    /**
    * Sets the user uuid of this equipment type.
    *
    * @param userUuid the user uuid of this equipment type
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _equipmentType.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this equipment type.
    *
    * @return the user name of this equipment type
    */
    @Override
    public java.lang.String getUserName() {
        return _equipmentType.getUserName();
    }

    /**
    * Sets the user name of this equipment type.
    *
    * @param userName the user name of this equipment type
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _equipmentType.setUserName(userName);
    }

    /**
    * Returns the create date of this equipment type.
    *
    * @return the create date of this equipment type
    */
    @Override
    public java.util.Date getCreateDate() {
        return _equipmentType.getCreateDate();
    }

    /**
    * Sets the create date of this equipment type.
    *
    * @param createDate the create date of this equipment type
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _equipmentType.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this equipment type.
    *
    * @return the modified date of this equipment type
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _equipmentType.getModifiedDate();
    }

    /**
    * Sets the modified date of this equipment type.
    *
    * @param modifiedDate the modified date of this equipment type
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _equipmentType.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this equipment type.
    *
    * @return the name of this equipment type
    */
    @Override
    public java.lang.String getName() {
        return _equipmentType.getName();
    }

    /**
    * Returns the localized name of this equipment type in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized name of this equipment type
    */
    @Override
    public java.lang.String getName(java.util.Locale locale) {
        return _equipmentType.getName(locale);
    }

    /**
    * Returns the localized name of this equipment type in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this equipment type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
        return _equipmentType.getName(locale, useDefault);
    }

    /**
    * Returns the localized name of this equipment type in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized name of this equipment type
    */
    @Override
    public java.lang.String getName(java.lang.String languageId) {
        return _equipmentType.getName(languageId);
    }

    /**
    * Returns the localized name of this equipment type in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this equipment type
    */
    @Override
    public java.lang.String getName(java.lang.String languageId,
        boolean useDefault) {
        return _equipmentType.getName(languageId, useDefault);
    }

    @Override
    public java.lang.String getNameCurrentLanguageId() {
        return _equipmentType.getNameCurrentLanguageId();
    }

    @Override
    public java.lang.String getNameCurrentValue() {
        return _equipmentType.getNameCurrentValue();
    }

    /**
    * Returns a map of the locales and localized names of this equipment type.
    *
    * @return the locales and localized names of this equipment type
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
        return _equipmentType.getNameMap();
    }

    /**
    * Sets the name of this equipment type.
    *
    * @param name the name of this equipment type
    */
    @Override
    public void setName(java.lang.String name) {
        _equipmentType.setName(name);
    }

    /**
    * Sets the localized name of this equipment type in the language.
    *
    * @param name the localized name of this equipment type
    * @param locale the locale of the language
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale) {
        _equipmentType.setName(name, locale);
    }

    /**
    * Sets the localized name of this equipment type in the language, and sets the default locale.
    *
    * @param name the localized name of this equipment type
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _equipmentType.setName(name, locale, defaultLocale);
    }

    @Override
    public void setNameCurrentLanguageId(java.lang.String languageId) {
        _equipmentType.setNameCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized names of this equipment type from the map of locales and localized names.
    *
    * @param nameMap the locales and localized names of this equipment type
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap) {
        _equipmentType.setNameMap(nameMap);
    }

    /**
    * Sets the localized names of this equipment type from the map of locales and localized names, and sets the default locale.
    *
    * @param nameMap the locales and localized names of this equipment type
    * @param defaultLocale the default locale
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Locale defaultLocale) {
        _equipmentType.setNameMap(nameMap, defaultLocale);
    }

    @Override
    public boolean isNew() {
        return _equipmentType.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _equipmentType.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _equipmentType.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _equipmentType.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _equipmentType.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _equipmentType.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _equipmentType.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _equipmentType.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _equipmentType.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _equipmentType.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _equipmentType.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _equipmentType.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _equipmentType.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _equipmentType.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _equipmentType.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new EquipmentTypeWrapper((EquipmentType) _equipmentType.clone());
    }

    @Override
    public int compareTo(EquipmentType equipmentType) {
        return _equipmentType.compareTo(equipmentType);
    }

    @Override
    public int hashCode() {
        return _equipmentType.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<EquipmentType> toCacheModel() {
        return _equipmentType.toCacheModel();
    }

    @Override
    public EquipmentType toEscapedModel() {
        return new EquipmentTypeWrapper(_equipmentType.toEscapedModel());
    }

    @Override
    public EquipmentType toUnescapedModel() {
        return new EquipmentTypeWrapper(_equipmentType.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _equipmentType.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _equipmentType.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _equipmentType.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EquipmentTypeWrapper)) {
            return false;
        }

        EquipmentTypeWrapper equipmentTypeWrapper = (EquipmentTypeWrapper) obj;

        if (Validator.equals(_equipmentType, equipmentTypeWrapper._equipmentType)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _equipmentType.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public EquipmentType getWrappedEquipmentType() {
        return _equipmentType;
    }

    @Override
    public EquipmentType getWrappedModel() {
        return _equipmentType;
    }

    @Override
    public void resetOriginalValues() {
        _equipmentType.resetOriginalValues();
    }
}
