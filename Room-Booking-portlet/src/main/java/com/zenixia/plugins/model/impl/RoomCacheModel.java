package com.zenixia.plugins.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.zenixia.plugins.model.Room;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Room in entity cache.
 *
 * @author Guillaume Lenoir
 * @see Room
 * @generated
 */
public class RoomCacheModel implements CacheModel<Room>, Externalizable {
    public String uuid;
    public long roomId;
    public long companyId;
    public long groupId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String description;
    public int capacity;
    public int level;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", roomId=");
        sb.append(roomId);
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
        sb.append(", description=");
        sb.append(description);
        sb.append(", capacity=");
        sb.append(capacity);
        sb.append(", level=");
        sb.append(level);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Room toEntityModel() {
        RoomImpl roomImpl = new RoomImpl();

        if (uuid == null) {
            roomImpl.setUuid(StringPool.BLANK);
        } else {
            roomImpl.setUuid(uuid);
        }

        roomImpl.setRoomId(roomId);
        roomImpl.setCompanyId(companyId);
        roomImpl.setGroupId(groupId);
        roomImpl.setUserId(userId);

        if (userName == null) {
            roomImpl.setUserName(StringPool.BLANK);
        } else {
            roomImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            roomImpl.setCreateDate(null);
        } else {
            roomImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            roomImpl.setModifiedDate(null);
        } else {
            roomImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            roomImpl.setName(StringPool.BLANK);
        } else {
            roomImpl.setName(name);
        }

        if (description == null) {
            roomImpl.setDescription(StringPool.BLANK);
        } else {
            roomImpl.setDescription(description);
        }

        roomImpl.setCapacity(capacity);
        roomImpl.setLevel(level);

        roomImpl.resetOriginalValues();

        return roomImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        roomId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        capacity = objectInput.readInt();
        level = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(roomId);
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

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeInt(capacity);
        objectOutput.writeInt(level);
    }
}
