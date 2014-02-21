package com.opensourceforlife.portlet.samplerecyclebin.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.opensourceforlife.portlet.samplerecyclebin.model.Event;

import java.util.List;

/**
 * The persistence utility for the event service. This utility wraps {@link EventPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Opensourceforlife
 * @see EventPersistence
 * @see EventPersistenceImpl
 * @generated
 */
public class EventUtil {
    private static EventPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Event event) {
        getPersistence().clearCache(event);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Event> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Event> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Event> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Event update(Event event) throws SystemException {
        return getPersistence().update(event);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Event update(Event event, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(event, serviceContext);
    }

    /**
    * Returns all the events where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first event in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first event in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last event in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last event in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByUuid_PrevAndNext(
        long eventId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByUuid_PrevAndNext(eventId, uuid, orderByComparator);
    }

    /**
    * Removes all the events where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of events where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the event where uuid = &#63; and groupId = &#63; or throws a {@link com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the event where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the event that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of events where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the events where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first event in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last event in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByUuid_C_PrevAndNext(
        long eventId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(eventId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the events where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid_C(uuid, companyId);
    }

    /**
    * Returns the number of events where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the events where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first event in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first event in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last event in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last event in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByGroupId_PrevAndNext(
        long eventId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(eventId, groupId,
            orderByComparator);
    }

    /**
    * Returns all the events that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByGroupId(groupId);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByGroupId(groupId, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByGroupId(groupId, start, end, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] filterFindByGroupId_PrevAndNext(
        long eventId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .filterFindByGroupId_PrevAndNext(eventId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the events where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of events where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns the number of events that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static int filterCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterCountByGroupId(groupId);
    }

    /**
    * Returns all the events where companyId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_NotS(
        long companyId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_NotS(companyId, status);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_NotS(
        long companyId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_NotS(companyId, status, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_NotS(
        long companyId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_NotS(companyId, status, start, end,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_NotS_First(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByC_NotS_First(companyId, status, orderByComparator);
    }

    /**
    * Returns the first event in the ordered set where companyId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_NotS_First(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_NotS_First(companyId, status, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_NotS_Last(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByC_NotS_Last(companyId, status, orderByComparator);
    }

    /**
    * Returns the last event in the ordered set where companyId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_NotS_Last(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_NotS_Last(companyId, status, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByC_NotS_PrevAndNext(
        long eventId, long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByC_NotS_PrevAndNext(eventId, companyId, status,
            orderByComparator);
    }

    /**
    * Removes all the events where companyId = &#63; and status &ne; &#63; from the database.
    *
    * @param companyId the company ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_NotS(long companyId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_NotS(companyId, status);
    }

    /**
    * Returns the number of events where companyId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_NotS(long companyId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_NotS(companyId, status);
    }

    /**
    * Returns all the events where companyId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_S(
        long companyId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_S(companyId, status);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_S(
        long companyId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_S(companyId, status, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_S(
        long companyId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_S(companyId, status, start, end, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_S_First(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByC_S_First(companyId, status, orderByComparator);
    }

    /**
    * Returns the first event in the ordered set where companyId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_S_First(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_S_First(companyId, status, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_S_Last(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByC_S_Last(companyId, status, orderByComparator);
    }

    /**
    * Returns the last event in the ordered set where companyId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_S_Last(
        long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_S_Last(companyId, status, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByC_S_PrevAndNext(
        long eventId, long companyId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByC_S_PrevAndNext(eventId, companyId, status,
            orderByComparator);
    }

    /**
    * Removes all the events where companyId = &#63; and status = &#63; from the database.
    *
    * @param companyId the company ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_S(long companyId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_S(companyId, status);
    }

    /**
    * Returns the number of events where companyId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_S(long companyId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_S(companyId, status);
    }

    /**
    * Returns all the events where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_NotS(
        long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_NotS(groupId, status);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_NotS(
        long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_NotS(groupId, status, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_NotS(
        long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_NotS(groupId, status, start, end, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_NotS_First(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByG_NotS_First(groupId, status, orderByComparator);
    }

    /**
    * Returns the first event in the ordered set where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_NotS_First(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_NotS_First(groupId, status, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_NotS_Last(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByG_NotS_Last(groupId, status, orderByComparator);
    }

    /**
    * Returns the last event in the ordered set where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_NotS_Last(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_NotS_Last(groupId, status, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByG_NotS_PrevAndNext(
        long eventId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByG_NotS_PrevAndNext(eventId, groupId, status,
            orderByComparator);
    }

    /**
    * Returns all the events that the user has permission to view where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_NotS(
        long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByG_NotS(groupId, status);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_NotS(
        long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByG_NotS(groupId, status, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_NotS(
        long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByG_NotS(groupId, status, start, end,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] filterFindByG_NotS_PrevAndNext(
        long eventId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .filterFindByG_NotS_PrevAndNext(eventId, groupId, status,
            orderByComparator);
    }

    /**
    * Removes all the events where groupId = &#63; and status &ne; &#63; from the database.
    *
    * @param groupId the group ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_NotS(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_NotS(groupId, status);
    }

    /**
    * Returns the number of events where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_NotS(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_NotS(groupId, status);
    }

    /**
    * Returns the number of events that the user has permission to view where groupId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static int filterCountByG_NotS(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterCountByG_NotS(groupId, status);
    }

    /**
    * Returns all the events where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_S(
        long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_S(groupId, status);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_S(
        long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_S(groupId, status, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_S(
        long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_S(groupId, status, start, end, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_S_First(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByG_S_First(groupId, status, orderByComparator);
    }

    /**
    * Returns the first event in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_S_First(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_S_First(groupId, status, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_S_Last(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByG_S_Last(groupId, status, orderByComparator);
    }

    /**
    * Returns the last event in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event, or <code>null</code> if a matching event could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_S_Last(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_S_Last(groupId, status, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByG_S_PrevAndNext(
        long eventId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByG_S_PrevAndNext(eventId, groupId, status,
            orderByComparator);
    }

    /**
    * Returns all the events that the user has permission to view where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_S(
        long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByG_S(groupId, status);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_S(
        long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByG_S(groupId, status, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_S(
        long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByG_S(groupId, status, start, end,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] filterFindByG_S_PrevAndNext(
        long eventId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .filterFindByG_S_PrevAndNext(eventId, groupId, status,
            orderByComparator);
    }

    /**
    * Removes all the events where groupId = &#63; and status = &#63; from the database.
    *
    * @param groupId the group ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_S(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_S(groupId, status);
    }

    /**
    * Returns the number of events where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_S(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_S(groupId, status);
    }

    /**
    * Returns the number of events that the user has permission to view where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static int filterCountByG_S(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterCountByG_S(groupId, status);
    }

    /**
    * Returns all the events where companyId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_U_NotS(
        long companyId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_U_NotS(companyId, userId, status);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_U_NotS(
        long companyId, long userId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_U_NotS(companyId, userId, status, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_U_NotS(
        long companyId, long userId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_U_NotS(companyId, userId, status, start, end,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_U_NotS_First(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByC_U_NotS_First(companyId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_U_NotS_First(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_U_NotS_First(companyId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_U_NotS_Last(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByC_U_NotS_Last(companyId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_U_NotS_Last(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_U_NotS_Last(companyId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByC_U_NotS_PrevAndNext(
        long eventId, long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByC_U_NotS_PrevAndNext(eventId, companyId, userId,
            status, orderByComparator);
    }

    /**
    * Removes all the events where companyId = &#63; and userId = &#63; and status &ne; &#63; from the database.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_U_NotS(long companyId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_U_NotS(companyId, userId, status);
    }

    /**
    * Returns the number of events where companyId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_U_NotS(long companyId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_U_NotS(companyId, userId, status);
    }

    /**
    * Returns all the events where companyId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_U_S(
        long companyId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_U_S(companyId, userId, status);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_U_S(
        long companyId, long userId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_U_S(companyId, userId, status, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByC_U_S(
        long companyId, long userId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_U_S(companyId, userId, status, start, end,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_U_S_First(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByC_U_S_First(companyId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_U_S_First(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_U_S_First(companyId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByC_U_S_Last(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByC_U_S_Last(companyId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByC_U_S_Last(
        long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_U_S_Last(companyId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByC_U_S_PrevAndNext(
        long eventId, long companyId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByC_U_S_PrevAndNext(eventId, companyId, userId, status,
            orderByComparator);
    }

    /**
    * Removes all the events where companyId = &#63; and userId = &#63; and status = &#63; from the database.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_U_S(long companyId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_U_S(companyId, userId, status);
    }

    /**
    * Returns the number of events where companyId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param userId the user ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_U_S(long companyId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_U_S(companyId, userId, status);
    }

    /**
    * Returns all the events where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_U_NotS(
        long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_U_NotS(groupId, userId, status);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_U_NotS(
        long groupId, long userId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_U_NotS(groupId, userId, status, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_U_NotS(
        long groupId, long userId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_U_NotS(groupId, userId, status, start, end,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_U_NotS_First(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByG_U_NotS_First(groupId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_U_NotS_First(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_U_NotS_First(groupId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_U_NotS_Last(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByG_U_NotS_Last(groupId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_U_NotS_Last(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_U_NotS_Last(groupId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByG_U_NotS_PrevAndNext(
        long eventId, long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByG_U_NotS_PrevAndNext(eventId, groupId, userId,
            status, orderByComparator);
    }

    /**
    * Returns all the events that the user has permission to view where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_U_NotS(
        long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByG_U_NotS(groupId, userId, status);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_U_NotS(
        long groupId, long userId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByG_U_NotS(groupId, userId, status, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_U_NotS(
        long groupId, long userId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByG_U_NotS(groupId, userId, status, start, end,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] filterFindByG_U_NotS_PrevAndNext(
        long eventId, long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .filterFindByG_U_NotS_PrevAndNext(eventId, groupId, userId,
            status, orderByComparator);
    }

    /**
    * Removes all the events where groupId = &#63; and userId = &#63; and status &ne; &#63; from the database.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_U_NotS(long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_U_NotS(groupId, userId, status);
    }

    /**
    * Returns the number of events where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_U_NotS(long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_U_NotS(groupId, userId, status);
    }

    /**
    * Returns the number of events that the user has permission to view where groupId = &#63; and userId = &#63; and status &ne; &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the number of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static int filterCountByG_U_NotS(long groupId, long userId,
        int status) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterCountByG_U_NotS(groupId, userId, status);
    }

    /**
    * Returns all the events where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the matching events
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_U_S(
        long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_U_S(groupId, userId, status);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_U_S(
        long groupId, long userId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_U_S(groupId, userId, status, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findByG_U_S(
        long groupId, long userId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_U_S(groupId, userId, status, start, end,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_U_S_First(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByG_U_S_First(groupId, userId, status, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_U_S_First(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_U_S_First(groupId, userId, status,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByG_U_S_Last(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByG_U_S_Last(groupId, userId, status, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByG_U_S_Last(
        long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_U_S_Last(groupId, userId, status, orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] findByG_U_S_PrevAndNext(
        long eventId, long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .findByG_U_S_PrevAndNext(eventId, groupId, userId, status,
            orderByComparator);
    }

    /**
    * Returns all the events that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_U_S(
        long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByG_U_S(groupId, userId, status);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_U_S(
        long groupId, long userId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByG_U_S(groupId, userId, status, start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> filterFindByG_U_S(
        long groupId, long userId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByG_U_S(groupId, userId, status, start, end,
            orderByComparator);
    }

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
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event[] filterFindByG_U_S_PrevAndNext(
        long eventId, long groupId, long userId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence()
                   .filterFindByG_U_S_PrevAndNext(eventId, groupId, userId,
            status, orderByComparator);
    }

    /**
    * Removes all the events where groupId = &#63; and userId = &#63; and status = &#63; from the database.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_U_S(long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_U_S(groupId, userId, status);
    }

    /**
    * Returns the number of events where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the number of matching events
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_U_S(long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_U_S(groupId, userId, status);
    }

    /**
    * Returns the number of events that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param status the status
    * @return the number of matching events that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static int filterCountByG_U_S(long groupId, long userId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterCountByG_U_S(groupId, userId, status);
    }

    /**
    * Caches the event in the entity cache if it is enabled.
    *
    * @param event the event
    */
    public static void cacheResult(
        com.opensourceforlife.portlet.samplerecyclebin.model.Event event) {
        getPersistence().cacheResult(event);
    }

    /**
    * Caches the events in the entity cache if it is enabled.
    *
    * @param events the events
    */
    public static void cacheResult(
        java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> events) {
        getPersistence().cacheResult(events);
    }

    /**
    * Creates a new event with the primary key. Does not add the event to the database.
    *
    * @param eventId the primary key for the new event
    * @return the new event
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event create(
        long eventId) {
        return getPersistence().create(eventId);
    }

    /**
    * Removes the event with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param eventId the primary key of the event
    * @return the event that was removed
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event remove(
        long eventId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence().remove(eventId);
    }

    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event updateImpl(
        com.opensourceforlife.portlet.samplerecyclebin.model.Event event)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(event);
    }

    /**
    * Returns the event with the primary key or throws a {@link com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException} if it could not be found.
    *
    * @param eventId the primary key of the event
    * @return the event
    * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event findByPrimaryKey(
        long eventId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException {
        return getPersistence().findByPrimaryKey(eventId);
    }

    /**
    * Returns the event with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param eventId the primary key of the event
    * @return the event, or <code>null</code> if a event with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.opensourceforlife.portlet.samplerecyclebin.model.Event fetchByPrimaryKey(
        long eventId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(eventId);
    }

    /**
    * Returns all the events.
    *
    * @return the events
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.opensourceforlife.portlet.samplerecyclebin.model.Event> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the events from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of events.
    *
    * @return the number of events
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EventPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EventPersistence) PortletBeanLocatorUtil.locate(com.opensourceforlife.portlet.samplerecyclebin.service.ClpSerializer.getServletContextName(),
                    EventPersistence.class.getName());

            ReferenceRegistry.registerReference(EventUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(EventPersistence persistence) {
    }
}
