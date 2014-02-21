package com.opensourceforlife.portlet.samplerecyclebin.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Event}.
 * </p>
 *
 * @author Opensourceforlife
 * @see Event
 * @generated
 */
public class EventWrapper implements Event, ModelWrapper<Event> {
    private Event _event;

    public EventWrapper(Event event) {
        _event = event;
    }

    @Override
    public Class<?> getModelClass() {
        return Event.class;
    }

    @Override
    public String getModelClassName() {
        return Event.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("eventId", getEventId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("date", getDate());
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

        Long eventId = (Long) attributes.get("eventId");

        if (eventId != null) {
            setEventId(eventId);
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

        Date date = (Date) attributes.get("date");

        if (date != null) {
            setDate(date);
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

    /**
    * Returns the primary key of this event.
    *
    * @return the primary key of this event
    */
    @Override
    public long getPrimaryKey() {
        return _event.getPrimaryKey();
    }

    /**
    * Sets the primary key of this event.
    *
    * @param primaryKey the primary key of this event
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _event.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this event.
    *
    * @return the uuid of this event
    */
    @Override
    public java.lang.String getUuid() {
        return _event.getUuid();
    }

    /**
    * Sets the uuid of this event.
    *
    * @param uuid the uuid of this event
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _event.setUuid(uuid);
    }

    /**
    * Returns the event ID of this event.
    *
    * @return the event ID of this event
    */
    @Override
    public long getEventId() {
        return _event.getEventId();
    }

    /**
    * Sets the event ID of this event.
    *
    * @param eventId the event ID of this event
    */
    @Override
    public void setEventId(long eventId) {
        _event.setEventId(eventId);
    }

    /**
    * Returns the company ID of this event.
    *
    * @return the company ID of this event
    */
    @Override
    public long getCompanyId() {
        return _event.getCompanyId();
    }

    /**
    * Sets the company ID of this event.
    *
    * @param companyId the company ID of this event
    */
    @Override
    public void setCompanyId(long companyId) {
        _event.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this event.
    *
    * @return the group ID of this event
    */
    @Override
    public long getGroupId() {
        return _event.getGroupId();
    }

    /**
    * Sets the group ID of this event.
    *
    * @param groupId the group ID of this event
    */
    @Override
    public void setGroupId(long groupId) {
        _event.setGroupId(groupId);
    }

    /**
    * Returns the user ID of this event.
    *
    * @return the user ID of this event
    */
    @Override
    public long getUserId() {
        return _event.getUserId();
    }

    /**
    * Sets the user ID of this event.
    *
    * @param userId the user ID of this event
    */
    @Override
    public void setUserId(long userId) {
        _event.setUserId(userId);
    }

    /**
    * Returns the user uuid of this event.
    *
    * @return the user uuid of this event
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _event.getUserUuid();
    }

    /**
    * Sets the user uuid of this event.
    *
    * @param userUuid the user uuid of this event
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _event.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this event.
    *
    * @return the create date of this event
    */
    @Override
    public java.util.Date getCreateDate() {
        return _event.getCreateDate();
    }

    /**
    * Sets the create date of this event.
    *
    * @param createDate the create date of this event
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _event.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this event.
    *
    * @return the modified date of this event
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _event.getModifiedDate();
    }

    /**
    * Sets the modified date of this event.
    *
    * @param modifiedDate the modified date of this event
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _event.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this event.
    *
    * @return the name of this event
    */
    @Override
    public java.lang.String getName() {
        return _event.getName();
    }

    /**
    * Sets the name of this event.
    *
    * @param name the name of this event
    */
    @Override
    public void setName(java.lang.String name) {
        _event.setName(name);
    }

    /**
    * Returns the description of this event.
    *
    * @return the description of this event
    */
    @Override
    public java.lang.String getDescription() {
        return _event.getDescription();
    }

    /**
    * Sets the description of this event.
    *
    * @param description the description of this event
    */
    @Override
    public void setDescription(java.lang.String description) {
        _event.setDescription(description);
    }

    /**
    * Returns the date of this event.
    *
    * @return the date of this event
    */
    @Override
    public java.util.Date getDate() {
        return _event.getDate();
    }

    /**
    * Sets the date of this event.
    *
    * @param date the date of this event
    */
    @Override
    public void setDate(java.util.Date date) {
        _event.setDate(date);
    }

    /**
    * Returns the status of this event.
    *
    * @return the status of this event
    */
    @Override
    public int getStatus() {
        return _event.getStatus();
    }

    /**
    * Sets the status of this event.
    *
    * @param status the status of this event
    */
    @Override
    public void setStatus(int status) {
        _event.setStatus(status);
    }

    /**
    * Returns the status by user ID of this event.
    *
    * @return the status by user ID of this event
    */
    @Override
    public long getStatusByUserId() {
        return _event.getStatusByUserId();
    }

    /**
    * Sets the status by user ID of this event.
    *
    * @param statusByUserId the status by user ID of this event
    */
    @Override
    public void setStatusByUserId(long statusByUserId) {
        _event.setStatusByUserId(statusByUserId);
    }

    /**
    * Returns the status by user uuid of this event.
    *
    * @return the status by user uuid of this event
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getStatusByUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _event.getStatusByUserUuid();
    }

    /**
    * Sets the status by user uuid of this event.
    *
    * @param statusByUserUuid the status by user uuid of this event
    */
    @Override
    public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
        _event.setStatusByUserUuid(statusByUserUuid);
    }

    /**
    * Returns the status by user name of this event.
    *
    * @return the status by user name of this event
    */
    @Override
    public java.lang.String getStatusByUserName() {
        return _event.getStatusByUserName();
    }

    /**
    * Sets the status by user name of this event.
    *
    * @param statusByUserName the status by user name of this event
    */
    @Override
    public void setStatusByUserName(java.lang.String statusByUserName) {
        _event.setStatusByUserName(statusByUserName);
    }

    /**
    * Returns the status date of this event.
    *
    * @return the status date of this event
    */
    @Override
    public java.util.Date getStatusDate() {
        return _event.getStatusDate();
    }

    /**
    * Sets the status date of this event.
    *
    * @param statusDate the status date of this event
    */
    @Override
    public void setStatusDate(java.util.Date statusDate) {
        _event.setStatusDate(statusDate);
    }

    /**
    * Returns the trash entry created when this event was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this event.
    *
    * @return the trash entry created when this event was moved to the Recycle Bin
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.portlet.trash.model.TrashEntry getTrashEntry()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _event.getTrashEntry();
    }

    /**
    * Returns the class primary key of the trash entry for this event.
    *
    * @return the class primary key of the trash entry for this event
    */
    @Override
    public long getTrashEntryClassPK() {
        return _event.getTrashEntryClassPK();
    }

    /**
    * Returns the trash handler for this event.
    *
    * @return the trash handler for this event
    */
    @Override
    public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
        return _event.getTrashHandler();
    }

    /**
    * Returns <code>true</code> if this event is in the Recycle Bin.
    *
    * @return <code>true</code> if this event is in the Recycle Bin; <code>false</code> otherwise
    */
    @Override
    public boolean isInTrash() {
        return _event.isInTrash();
    }

    /**
    * Returns <code>true</code> if the parent of this event is in the Recycle Bin.
    *
    * @return <code>true</code> if the parent of this event is in the Recycle Bin; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean isInTrashContainer() {
        return _event.isInTrashContainer();
    }

    /**
    * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
    */
    @Override
    public boolean getApproved() {
        return _event.getApproved();
    }

    /**
    * Returns <code>true</code> if this event is approved.
    *
    * @return <code>true</code> if this event is approved; <code>false</code> otherwise
    */
    @Override
    public boolean isApproved() {
        return _event.isApproved();
    }

    /**
    * Returns <code>true</code> if this event is denied.
    *
    * @return <code>true</code> if this event is denied; <code>false</code> otherwise
    */
    @Override
    public boolean isDenied() {
        return _event.isDenied();
    }

    /**
    * Returns <code>true</code> if this event is a draft.
    *
    * @return <code>true</code> if this event is a draft; <code>false</code> otherwise
    */
    @Override
    public boolean isDraft() {
        return _event.isDraft();
    }

    /**
    * Returns <code>true</code> if this event is expired.
    *
    * @return <code>true</code> if this event is expired; <code>false</code> otherwise
    */
    @Override
    public boolean isExpired() {
        return _event.isExpired();
    }

    /**
    * Returns <code>true</code> if this event is inactive.
    *
    * @return <code>true</code> if this event is inactive; <code>false</code> otherwise
    */
    @Override
    public boolean isInactive() {
        return _event.isInactive();
    }

    /**
    * Returns <code>true</code> if this event is incomplete.
    *
    * @return <code>true</code> if this event is incomplete; <code>false</code> otherwise
    */
    @Override
    public boolean isIncomplete() {
        return _event.isIncomplete();
    }

    /**
    * Returns <code>true</code> if this event is pending.
    *
    * @return <code>true</code> if this event is pending; <code>false</code> otherwise
    */
    @Override
    public boolean isPending() {
        return _event.isPending();
    }

    /**
    * Returns <code>true</code> if this event is scheduled.
    *
    * @return <code>true</code> if this event is scheduled; <code>false</code> otherwise
    */
    @Override
    public boolean isScheduled() {
        return _event.isScheduled();
    }

    @Override
    public boolean isNew() {
        return _event.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _event.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _event.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _event.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _event.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _event.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _event.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _event.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _event.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _event.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _event.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EventWrapper((Event) _event.clone());
    }

    @Override
    public int compareTo(Event event) {
        return _event.compareTo(event);
    }

    @Override
    public int hashCode() {
        return _event.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Event> toCacheModel() {
        return _event.toCacheModel();
    }

    @Override
    public Event toEscapedModel() {
        return new EventWrapper(_event.toEscapedModel());
    }

    @Override
    public Event toUnescapedModel() {
        return new EventWrapper(_event.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _event.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _event.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _event.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EventWrapper)) {
            return false;
        }

        EventWrapper eventWrapper = (EventWrapper) obj;

        if (Validator.equals(_event, eventWrapper._event)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _event.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Event getWrappedEvent() {
        return _event;
    }

    @Override
    public Event getWrappedModel() {
        return _event;
    }

    @Override
    public void resetOriginalValues() {
        _event.resetOriginalValues();
    }
}
