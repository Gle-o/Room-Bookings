package com.glenoir.plugins.model.impl;

import com.glenoir.plugins.model.RoomBooking;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RoomBooking in entity cache.
 *
 * @author guillaume Lenoir
 * @see RoomBooking
 * @generated
 */
public class RoomBookingCacheModel implements CacheModel<RoomBooking>,
    Externalizable {
    public String uuid;
    public long roomBookingId;
    public long companyId;
    public long groupId;
    public long createDate;
    public long modifiedDate;
    public long userId;
    public String userName;
    public long roomId;
    public String title;
    public String description;
    public long startTime;
    public long endTime;
    public boolean allDay;
    public String recurrence;
    public long firstReminder;
    public String firstReminderType;
    public long secondReminder;
    public String secondReminderType;
    public int status;
    public long statusByUserId;
    public String statusByUserName;
    public long statusDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(47);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", roomBookingId=");
        sb.append(roomBookingId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", roomId=");
        sb.append(roomId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", startTime=");
        sb.append(startTime);
        sb.append(", endTime=");
        sb.append(endTime);
        sb.append(", allDay=");
        sb.append(allDay);
        sb.append(", recurrence=");
        sb.append(recurrence);
        sb.append(", firstReminder=");
        sb.append(firstReminder);
        sb.append(", firstReminderType=");
        sb.append(firstReminderType);
        sb.append(", secondReminder=");
        sb.append(secondReminder);
        sb.append(", secondReminderType=");
        sb.append(secondReminderType);
        sb.append(", status=");
        sb.append(status);
        sb.append(", statusByUserId=");
        sb.append(statusByUserId);
        sb.append(", statusByUserName=");
        sb.append(statusByUserName);
        sb.append(", statusDate=");
        sb.append(statusDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public RoomBooking toEntityModel() {
        RoomBookingImpl roomBookingImpl = new RoomBookingImpl();

        if (uuid == null) {
            roomBookingImpl.setUuid(StringPool.BLANK);
        } else {
            roomBookingImpl.setUuid(uuid);
        }

        roomBookingImpl.setRoomBookingId(roomBookingId);
        roomBookingImpl.setCompanyId(companyId);
        roomBookingImpl.setGroupId(groupId);

        if (createDate == Long.MIN_VALUE) {
            roomBookingImpl.setCreateDate(null);
        } else {
            roomBookingImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            roomBookingImpl.setModifiedDate(null);
        } else {
            roomBookingImpl.setModifiedDate(new Date(modifiedDate));
        }

        roomBookingImpl.setUserId(userId);

        if (userName == null) {
            roomBookingImpl.setUserName(StringPool.BLANK);
        } else {
            roomBookingImpl.setUserName(userName);
        }

        roomBookingImpl.setRoomId(roomId);

        if (title == null) {
            roomBookingImpl.setTitle(StringPool.BLANK);
        } else {
            roomBookingImpl.setTitle(title);
        }

        if (description == null) {
            roomBookingImpl.setDescription(StringPool.BLANK);
        } else {
            roomBookingImpl.setDescription(description);
        }

        roomBookingImpl.setStartTime(startTime);
        roomBookingImpl.setEndTime(endTime);
        roomBookingImpl.setAllDay(allDay);

        if (recurrence == null) {
            roomBookingImpl.setRecurrence(StringPool.BLANK);
        } else {
            roomBookingImpl.setRecurrence(recurrence);
        }

        roomBookingImpl.setFirstReminder(firstReminder);

        if (firstReminderType == null) {
            roomBookingImpl.setFirstReminderType(StringPool.BLANK);
        } else {
            roomBookingImpl.setFirstReminderType(firstReminderType);
        }

        roomBookingImpl.setSecondReminder(secondReminder);

        if (secondReminderType == null) {
            roomBookingImpl.setSecondReminderType(StringPool.BLANK);
        } else {
            roomBookingImpl.setSecondReminderType(secondReminderType);
        }

        roomBookingImpl.setStatus(status);
        roomBookingImpl.setStatusByUserId(statusByUserId);

        if (statusByUserName == null) {
            roomBookingImpl.setStatusByUserName(StringPool.BLANK);
        } else {
            roomBookingImpl.setStatusByUserName(statusByUserName);
        }

        if (statusDate == Long.MIN_VALUE) {
            roomBookingImpl.setStatusDate(null);
        } else {
            roomBookingImpl.setStatusDate(new Date(statusDate));
        }

        roomBookingImpl.resetOriginalValues();

        return roomBookingImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        roomBookingId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        roomId = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        startTime = objectInput.readLong();
        endTime = objectInput.readLong();
        allDay = objectInput.readBoolean();
        recurrence = objectInput.readUTF();
        firstReminder = objectInput.readLong();
        firstReminderType = objectInput.readUTF();
        secondReminder = objectInput.readLong();
        secondReminderType = objectInput.readUTF();
        status = objectInput.readInt();
        statusByUserId = objectInput.readLong();
        statusByUserName = objectInput.readUTF();
        statusDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(roomBookingId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(roomId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(startTime);
        objectOutput.writeLong(endTime);
        objectOutput.writeBoolean(allDay);

        if (recurrence == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(recurrence);
        }

        objectOutput.writeLong(firstReminder);

        if (firstReminderType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(firstReminderType);
        }

        objectOutput.writeLong(secondReminder);

        if (secondReminderType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(secondReminderType);
        }

        objectOutput.writeInt(status);
        objectOutput.writeLong(statusByUserId);

        if (statusByUserName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(statusByUserName);
        }

        objectOutput.writeLong(statusDate);
    }
}
