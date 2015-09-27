package com.zenixia.plugins.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.zenixia.plugins.model.Equipment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Equipment in entity cache.
 *
 * @author Guillaume Lenoir
 * @see Equipment
 * @generated
 */
public class EquipmentCacheModel implements CacheModel<Equipment>,
    Externalizable {
    public String uuid;
    public long equipmentId;
    public long companyId;
    public long groupId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String reference;
    public long equipmentTypeId;
    public long roomId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", equipmentId=");
        sb.append(equipmentId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
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
        sb.append(", reference=");
        sb.append(reference);
        sb.append(", equipmentTypeId=");
        sb.append(equipmentTypeId);
        sb.append(", roomId=");
        sb.append(roomId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Equipment toEntityModel() {
        EquipmentImpl equipmentImpl = new EquipmentImpl();

        if (uuid == null) {
            equipmentImpl.setUuid(StringPool.BLANK);
        } else {
            equipmentImpl.setUuid(uuid);
        }

        equipmentImpl.setEquipmentId(equipmentId);
        equipmentImpl.setCompanyId(companyId);
        equipmentImpl.setGroupId(groupId);
        equipmentImpl.setUserId(userId);

        if (userName == null) {
            equipmentImpl.setUserName(StringPool.BLANK);
        } else {
            equipmentImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            equipmentImpl.setCreateDate(null);
        } else {
            equipmentImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            equipmentImpl.setModifiedDate(null);
        } else {
            equipmentImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            equipmentImpl.setName(StringPool.BLANK);
        } else {
            equipmentImpl.setName(name);
        }

        if (reference == null) {
            equipmentImpl.setReference(StringPool.BLANK);
        } else {
            equipmentImpl.setReference(reference);
        }

        equipmentImpl.setEquipmentTypeId(equipmentTypeId);
        equipmentImpl.setRoomId(roomId);

        equipmentImpl.resetOriginalValues();

        return equipmentImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        equipmentId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        reference = objectInput.readUTF();
        equipmentTypeId = objectInput.readLong();
        roomId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(equipmentId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
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

        if (reference == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(reference);
        }

        objectOutput.writeLong(equipmentTypeId);
        objectOutput.writeLong(roomId);
    }
}
