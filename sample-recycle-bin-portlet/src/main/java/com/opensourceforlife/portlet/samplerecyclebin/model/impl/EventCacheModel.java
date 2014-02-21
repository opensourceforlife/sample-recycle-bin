package com.opensourceforlife.portlet.samplerecyclebin.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.opensourceforlife.portlet.samplerecyclebin.model.Event;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Event in entity cache.
 *
 * @author Opensourceforlife
 * @see Event
 * @generated
 */
public class EventCacheModel implements CacheModel<Event>, Externalizable {
    public String uuid;
    public long eventId;
    public long companyId;
    public long groupId;
    public long userId;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String description;
    public long date;
    public int status;
    public long statusByUserId;
    public String statusByUserName;
    public long statusDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", eventId=");
        sb.append(eventId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", date=");
        sb.append(date);
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
    public Event toEntityModel() {
        EventImpl eventImpl = new EventImpl();

        if (uuid == null) {
            eventImpl.setUuid(StringPool.BLANK);
        } else {
            eventImpl.setUuid(uuid);
        }

        eventImpl.setEventId(eventId);
        eventImpl.setCompanyId(companyId);
        eventImpl.setGroupId(groupId);
        eventImpl.setUserId(userId);

        if (createDate == Long.MIN_VALUE) {
            eventImpl.setCreateDate(null);
        } else {
            eventImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            eventImpl.setModifiedDate(null);
        } else {
            eventImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            eventImpl.setName(StringPool.BLANK);
        } else {
            eventImpl.setName(name);
        }

        if (description == null) {
            eventImpl.setDescription(StringPool.BLANK);
        } else {
            eventImpl.setDescription(description);
        }

        if (date == Long.MIN_VALUE) {
            eventImpl.setDate(null);
        } else {
            eventImpl.setDate(new Date(date));
        }

        eventImpl.setStatus(status);
        eventImpl.setStatusByUserId(statusByUserId);

        if (statusByUserName == null) {
            eventImpl.setStatusByUserName(StringPool.BLANK);
        } else {
            eventImpl.setStatusByUserName(statusByUserName);
        }

        if (statusDate == Long.MIN_VALUE) {
            eventImpl.setStatusDate(null);
        } else {
            eventImpl.setStatusDate(new Date(statusDate));
        }

        eventImpl.resetOriginalValues();

        return eventImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        eventId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        userId = objectInput.readLong();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        date = objectInput.readLong();
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

        objectOutput.writeLong(eventId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(userId);
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

        objectOutput.writeLong(date);
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
