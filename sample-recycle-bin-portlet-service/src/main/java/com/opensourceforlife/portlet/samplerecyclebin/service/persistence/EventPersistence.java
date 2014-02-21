package com.opensourceforlife.portlet.samplerecyclebin.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.opensourceforlife.portlet.samplerecyclebin.model.Event;

/**
 * The persistence interface for the event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Opensourceforlife
 * @see EventPersistenceImpl
 * @see EventUtil
 * @generated
 */
public interface EventPersistence extends BasePersistence<Event> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EventUtil} to access the event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the events where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the first event in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the last event in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set where uuid = &#63;.
    *
    * @param eventId the primary key of the current event
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByUuid_PrevAndNext(
        long eventId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Removes all the events where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event where uuid = &#63; and groupId = &#63; or throws a {@link com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the event where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the event that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the number of events where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the events where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the first event in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the last event in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param eventId the primary key of the current event
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByUuid_C_PrevAndNext(
        long eventId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Removes all the events where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the events where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the first event in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the last event in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set where groupId = &#63;.
    *
    * @param eventId the primary key of the current event
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByGroupId_PrevAndNext(
        long eventId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns all the events that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events that the user has permission to view where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events that the user has permissions to view where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set of events that the user has permission to view where groupId = &#63;.
    *
    * @param eventId the primary key of the current event
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] filterFindByGroupId_PrevAndNext(
        long eventId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Removes all the events where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public int filterCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the events where companyId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_NotS(
        long companyId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events where companyId = &#63; and status &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_NotS(
        long companyId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events where companyId = &#63; and status &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_NotS(
        long companyId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event in the ordered set where companyId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_NotS_First(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the first event in the ordered set where companyId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_NotS_First(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event in the ordered set where companyId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_NotS_Last(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the last event in the ordered set where companyId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_NotS_Last(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set where companyId = &#63; and status &ne; &#63;.
    *
    * @param eventId the primary key of the current event
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByC_NotS_PrevAndNext(
        long eventId, long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Removes all the events where companyId = &#63; and status &ne; &#63; from the database.
    *
    * @param companyId the company ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_NotS(long companyId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events where companyId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public int countByC_NotS(long companyId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the events where companyId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_S(
        long companyId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events where companyId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_S(
        long companyId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events where companyId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_S(
        long companyId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event in the ordered set where companyId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_S_First(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the first event in the ordered set where companyId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_S_First(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event in the ordered set where companyId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_S_Last(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the last event in the ordered set where companyId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_S_Last(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set where companyId = &#63; and status = &#63;.
    *
    * @param eventId the primary key of the current event
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByC_S_PrevAndNext(
        long eventId, long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Removes all the events where companyId = &#63; and status = &#63; from the database.
    *
    * @param companyId the company ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_S(long companyId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events where companyId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public int countByC_S(long companyId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the events where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_NotS(
        long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events where groupId = &#63; and status &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_NotS(
        long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events where groupId = &#63; and status &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_NotS(
        long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event in the ordered set where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_NotS_First(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the first event in the ordered set where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_NotS_First(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event in the ordered set where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_NotS_Last(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the last event in the ordered set where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_NotS_Last(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set where groupId = &#63; and status &ne; &#63;.
    *
    * @param eventId the primary key of the current event
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByG_NotS_PrevAndNext(
        long eventId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns all the events that the user has permission to view where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_NotS(
        long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events that the user has permission to view where groupId = &#63; and status &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_NotS(
        long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events that the user has permissions to view where groupId = &#63; and status &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_NotS(
        long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set of events that the user has permission to view where groupId = &#63; and status &ne; &#63;.
    *
    * @param eventId the primary key of the current event
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] filterFindByG_NotS_PrevAndNext(
        long eventId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Removes all the events where groupId = &#63; and status &ne; &#63; from the database.
    *
    * @param groupId the group ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_NotS(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public int countByG_NotS(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events that the user has permission to view where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public int filterCountByG_NotS(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the events where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_S(
        long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events where groupId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_S(
        long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events where groupId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_S(
        long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_S_First(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the first event in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_S_First(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_S_Last(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the last event in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_S_Last(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param eventId the primary key of the current event
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByG_S_PrevAndNext(
        long eventId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns all the events that the user has permission to view where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_S(
        long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events that the user has permission to view where groupId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_S(
        long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events that the user has permissions to view where groupId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_S(
        long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set of events that the user has permission to view where groupId = &#63; and status = &#63;.
    *
    * @param eventId the primary key of the current event
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] filterFindByG_S_PrevAndNext(
        long eventId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Removes all the events where groupId = &#63; and status = &#63; from the database.
    *
    * @param groupId the group ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_S(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public int countByG_S(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events that the user has permission to view where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public int filterCountByG_S(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the events where companyId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_U_NotS(
        long companyId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events where companyId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_U_NotS(
        long companyId, long userId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events where companyId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_U_NotS(
        long companyId, long userId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event in the ordered set where companyId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_U_NotS_First(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the first event in the ordered set where companyId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_U_NotS_First(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event in the ordered set where companyId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_U_NotS_Last(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the last event in the ordered set where companyId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_U_NotS_Last(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set where companyId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param eventId the primary key of the current event
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByC_U_NotS_PrevAndNext(
        long eventId, long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Removes all the events where companyId = &#63; and userId = &#63; and status &ne; &#63; from the database.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_U_NotS(long companyId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events where companyId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public int countByC_U_NotS(long companyId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the events where companyId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_U_S(
        long companyId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events where companyId = &#63; and userId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_U_S(
        long companyId, long userId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events where companyId = &#63; and userId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_U_S(
        long companyId, long userId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_U_S_First(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the first event in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_U_S_First(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_U_S_Last(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the last event in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_U_S_Last(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param eventId the primary key of the current event
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByC_U_S_PrevAndNext(
        long eventId, long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Removes all the events where companyId = &#63; and userId = &#63; and status = &#63; from the database.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_U_S(long companyId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events where companyId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public int countByC_U_S(long companyId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the events where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_U_NotS(
        long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_U_NotS(
        long groupId, long userId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_U_NotS(
        long groupId, long userId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event in the ordered set where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_U_NotS_First(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the first event in the ordered set where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_U_NotS_First(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event in the ordered set where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_U_NotS_Last(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the last event in the ordered set where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_U_NotS_Last(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param eventId the primary key of the current event
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByG_U_NotS_PrevAndNext(
        long eventId, long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns all the events that the user has permission to view where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_U_NotS(
        long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events that the user has permission to view where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_U_NotS(
        long groupId, long userId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events that the user has permissions to view where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_U_NotS(
        long groupId, long userId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set of events that the user has permission to view where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param eventId the primary key of the current event
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] filterFindByG_U_NotS_PrevAndNext(
        long eventId, long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Removes all the events where groupId = &#63; and userId = &#63; and status &ne; &#63; from the database.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_U_NotS(long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public int countByG_U_NotS(long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events that the user has permission to view where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the number of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public int filterCountByG_U_NotS(long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the events where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_U_S(
        long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_U_S(
        long groupId, long userId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_U_S(
        long groupId, long userId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_U_S_First(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the first event in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_U_S_First(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_U_S_Last(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the last event in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_U_S_Last(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param eventId the primary key of the current event
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByG_U_S_PrevAndNext(
        long eventId, long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns all the events that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_U_S(
        long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_U_S(
        long groupId, long userId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_U_S(
        long groupId, long userId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the events before and after the current event in the ordered set of events that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param eventId the primary key of the current event
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event[] filterFindByG_U_S_PrevAndNext(
        long eventId, long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Removes all the events where groupId = &#63; and userId = &#63; and status = &#63; from the database.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_U_S(long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public int countByG_U_S(long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the number of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public int filterCountByG_U_S(long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the event in the entity cache if it is enabled.
    *
    * @param event the event
    */
    public void cacheResult(
        com.opensourceforlife.portlet.samplerecyclebin.model.Event event);

    /**
    * Caches the events in the entity cache if it is enabled.
    *
    * @param events the events
    */
    public void cacheResult(
        java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> events);

    /**
    * Creates a new event with the primary key. Does not add the event to the database.
    *
    * @param eventId the primary key for the new event
    * @return the new event
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event create(
        long eventId);

    /**
    * Removes the event with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param eventId the primary key of the event
    * @return the event that was removed
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event remove(
        long eventId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    public com.opensourceforlife.portlet.samplerecyclebin.model.Event updateImpl(
        com.opensourceforlife.portlet.samplerecyclebin.model.Event event)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event with the primary key or throws a {@link com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException} if it could not be found.
    *
    * @param eventId the primary key of the event
    * @return the event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event findByPrimaryKey(
        long eventId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;

    /**
    * Returns the event with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param eventId the primary key of the event
    * @return the event, or <code>null</code> if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByPrimaryKey(
        long eventId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the events.
    *
    * @return the events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the events.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @return the range of events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the events.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of events
    * @param end the upper bound of the range of events (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of events
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the events from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of events.
    *
    * @return the number of events
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
