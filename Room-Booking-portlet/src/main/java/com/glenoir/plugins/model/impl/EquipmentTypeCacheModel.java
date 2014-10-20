package com.glenoir.plugins.model.impl;

import com.glenoir.plugins.model.EquipmentType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EquipmentType in entity cache.
 *
 * @author guillaume Lenoir
 * @see EquipmentType
 * @generated
 */
public class EquipmentTypeCacheModel implements CacheModel<EquipmentType>,
    Externalizable {
    public String uuid;
    public long equipmentTypeId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", equipmentTypeId=");
        sb.append(equipmentTypeId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", name=");
        sb.append(name);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public EquipmentType toEntityModel() {
        EquipmentTypeImpl equipmentTypeImpl = new EquipmentTypeImpl();

        if (uuid == null) {
            equipmentTypeImpl.setUuid(StringPool.BLANK);
        } else {
            equipmentTypeImpl.setUuid(uuid);
        }

        equipmentTypeImpl.setEquipmentTypeId(equipmentTypeId);
        equipmentTypeImpl.setCompanyId(companyId);
        equipmentTypeImpl.setUserId(userId);

        if (userName == null) {
            equipmentTypeImpl.setUserName(StringPool.BLANK);
        } else {
            equipmentTypeImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            equipmentTypeImpl.setCreateDate(null);
        } else {
            equipmentTypeImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            equipmentTypeImpl.setModifiedDate(null);
        } else {
            equipmentTypeImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            equipmentTypeImpl.setName(StringPool.BLANK);
        } else {
            equipmentTypeImpl.setName(name);
        }

        equipmentTypeImpl.resetOriginalValues();

        return equipmentTypeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        equipmentTypeId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(equipmentTypeId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }
    }
}
