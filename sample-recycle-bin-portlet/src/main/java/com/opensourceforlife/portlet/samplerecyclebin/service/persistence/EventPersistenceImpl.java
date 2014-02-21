package com.opensourceforlife.portlet.samplerecyclebin.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException;
import com.opensourceforlife.portlet.samplerecyclebin.model.Event;
import com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventImpl;
import com.opensourceforlife.portlet.samplerecyclebin.model.impl.EventModelImpl;
import com.opensourceforlife.portlet.samplerecyclebin.service.persistence.EventPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Opensourceforlife
 * @see EventPersistence
 * @see EventUtil
 * @generated
 */
public class EventPersistenceImpl extends BasePersistenceImpl<Event>
    implements EventPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link EventUtil} to access the event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = EventImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            EventModelImpl.UUID_COLUMN_BITMASK |
            EventModelImpl.DATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "event.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "event.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(event.uuid IS NULL OR event.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            EventModelImpl.UUID_COLUMN_BITMASK |
            EventModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "event.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "event.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(event.uuid IS NULL OR event.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "event.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            EventModelImpl.UUID_COLUMN_BITMASK |
            EventModelImpl.COMPANYID_COLUMN_BITMASK |
            EventModelImpl.DATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "event.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "event.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(event.uuid IS NULL OR event.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "event.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            EventModelImpl.GROUPID_COLUMN_BITMASK |
            EventModelImpl.DATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "event.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOTS = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_NotS",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_NOTS = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_NotS",
            new String[] { Long.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_C_NOTS_COMPANYID_2 = "event.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_NOTS_STATUS_2 = "event.status != ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_S = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_S",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_S",
            new String[] { Long.class.getName(), Integer.class.getName() },
            EventModelImpl.COMPANYID_COLUMN_BITMASK |
            EventModelImpl.STATUS_COLUMN_BITMASK |
            EventModelImpl.DATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_S = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S",
            new String[] { Long.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_C_S_COMPANYID_2 = "event.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_S_STATUS_2 = "event.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_NOTS = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_NotS",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_NOTS = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_NotS",
            new String[] { Long.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_G_NOTS_GROUPID_2 = "event.groupId = ? AND ";
    private static final String _FINDER_COLUMN_G_NOTS_STATUS_2 = "event.status != ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
            new String[] { Long.class.getName(), Integer.class.getName() },
            EventModelImpl.GROUPID_COLUMN_BITMASK |
            EventModelImpl.STATUS_COLUMN_BITMASK |
            EventModelImpl.DATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
            new String[] { Long.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "event.groupId = ? AND ";
    private static final String _FINDER_COLUMN_G_S_STATUS_2 = "event.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_U_NOTS = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_U_NotS",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_U_NOTS =
        new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_U_NotS",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            });
    private static final String _FINDER_COLUMN_C_U_NOTS_COMPANYID_2 = "event.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_U_NOTS_USERID_2 = "event.userId = ? AND ";
    private static final String _FINDER_COLUMN_C_U_NOTS_STATUS_2 = "event.status != ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_U_S = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_U_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U_S = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_U_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            },
            EventModelImpl.COMPANYID_COLUMN_BITMASK |
            EventModelImpl.USERID_COLUMN_BITMASK |
            EventModelImpl.STATUS_COLUMN_BITMASK |
            EventModelImpl.DATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_U_S = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            });
    private static final String _FINDER_COLUMN_C_U_S_COMPANYID_2 = "event.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_U_S_USERID_2 = "event.userId = ? AND ";
    private static final String _FINDER_COLUMN_C_U_S_STATUS_2 = "event.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U_NOTS = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U_NotS",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_U_NOTS =
        new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_U_NotS",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            });
    private static final String _FINDER_COLUMN_G_U_NOTS_GROUPID_2 = "event.groupId = ? AND ";
    private static final String _FINDER_COLUMN_G_U_NOTS_USERID_2 = "event.userId = ? AND ";
    private static final String _FINDER_COLUMN_G_U_NOTS_STATUS_2 = "event.status != ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U_S = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_S = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, EventImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            },
            EventModelImpl.GROUPID_COLUMN_BITMASK |
            EventModelImpl.USERID_COLUMN_BITMASK |
            EventModelImpl.STATUS_COLUMN_BITMASK |
            EventModelImpl.DATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_G_U_S = new FinderPath(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            });
    private static final String _FINDER_COLUMN_G_U_S_GROUPID_2 = "event.groupId = ? AND ";
    private static final String _FINDER_COLUMN_G_U_S_USERID_2 = "event.userId = ? AND ";
    private static final String _FINDER_COLUMN_G_U_S_STATUS_2 = "event.status = ?";
    private static final String _SQL_SELECT_EVENT = "SELECT event FROM Event event";
    private static final String _SQL_SELECT_EVENT_WHERE = "SELECT event FROM Event event WHERE ";
    private static final String _SQL_COUNT_EVENT = "SELECT COUNT(event) FROM Event event";
    private static final String _SQL_COUNT_EVENT_WHERE = "SELECT COUNT(event) FROM Event event WHERE ";
    private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "event.eventId";
    private static final String _FILTER_SQL_SELECT_EVENT_WHERE = "SELECT DISTINCT {event.*} FROM SRB_Event event WHERE ";
    private static final String _FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_1 =
        "SELECT {SRB_Event.*} FROM (SELECT DISTINCT event.eventId FROM SRB_Event event WHERE ";
    private static final String _FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_2 =
        ") TEMP_TABLE INNER JOIN SRB_Event ON TEMP_TABLE.eventId = SRB_Event.eventId";
    private static final String _FILTER_SQL_COUNT_EVENT_WHERE = "SELECT COUNT(DISTINCT event.eventId) AS COUNT_VALUE FROM SRB_Event event WHERE ";
    private static final String _FILTER_ENTITY_ALIAS = "event";
    private static final String _FILTER_ENTITY_TABLE = "SRB_Event";
    private static final String _ORDER_BY_ENTITY_ALIAS = "event.";
    private static final String _ORDER_BY_ENTITY_TABLE = "SRB_Event.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Event exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Event exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(EventPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid", "date"
            });
    private static Event _nullEvent = new EventImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Event> toCacheModel() {
                return _nullEventCacheModel;
            }
        };

    private static CacheModel<Event> _nullEventCacheModel = new CacheModel<Event>() {
            @Override
            public Event toEntityModel() {
                return _nullEvent;
            }
        };

    public EventPersistenceImpl() {
        setModelClass(Event.class);
    }

    /**
     * Returns all the events where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Event> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
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
    @Override
    public List<Event> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Event> list = (List<Event>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Event event : list) {
                if (!Validator.equals(uuid, event.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_EVENT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Event>(list);
                } else {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Event findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByUuid_First(uuid, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
    }

    /**
     * Returns the first event in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event, or <code>null</code> if a matching event could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Event fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Event> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByUuid_Last(uuid, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
    }

    /**
     * Returns the last event in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event, or <code>null</code> if a matching event could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Event fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Event> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event[] findByUuid_PrevAndNext(long eventId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = getByUuid_PrevAndNext(session, event, uuid,
                    orderByComparator, true);

            array[1] = event;

            array[2] = getByUuid_PrevAndNext(session, event, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event getByUuid_PrevAndNext(Session session, Event event,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENT_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EventModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the events where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Event event : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(event);
        }
    }

    /**
     * Returns the number of events where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EVENT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
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
    @Override
    public Event findByUUID_G(String uuid, long groupId)
        throws NoSuchEventException, SystemException {
        Event event = fetchByUUID_G(uuid, groupId);

        if (event == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchEventException(msg.toString());
        }

        return event;
    }

    /**
     * Returns the event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching event, or <code>null</code> if a matching event could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Event fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
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
    @Override
    public Event fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Event) {
            Event event = (Event) result;

            if (!Validator.equals(uuid, event.getUuid()) ||
                    (groupId != event.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_EVENT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Event> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Event event = list.get(0);

                    result = event;

                    cacheResult(event);

                    if ((event.getUuid() == null) ||
                            !event.getUuid().equals(uuid) ||
                            (event.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, event);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Event) result;
        }
    }

    /**
     * Removes the event where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the event that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Event removeByUUID_G(String uuid, long groupId)
        throws NoSuchEventException, SystemException {
        Event event = findByUUID_G(uuid, groupId);

        return remove(event);
    }

    /**
     * Returns the number of events where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_EVENT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the events where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Event> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
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
    @Override
    public List<Event> findByUuid_C(String uuid, long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Event> list = (List<Event>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Event event : list) {
                if (!Validator.equals(uuid, event.getUuid()) ||
                        (companyId != event.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_EVENT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Event>(list);
                } else {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Event findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Event> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Event> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event[] findByUuid_C_PrevAndNext(long eventId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, event, uuid, companyId,
                    orderByComparator, true);

            array[1] = event;

            array[2] = getByUuid_C_PrevAndNext(session, event, uuid, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event getByUuid_C_PrevAndNext(Session session, Event event,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENT_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EventModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the events where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Event event : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(event);
        }
    }

    /**
     * Returns the number of events where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_EVENT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the events where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Event> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
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
    @Override
    public List<Event> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<Event> list = (List<Event>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Event event : list) {
                if ((groupId != event.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Event>(list);
                } else {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Event findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByGroupId_First(groupId, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
    }

    /**
     * Returns the first event in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event, or <code>null</code> if a matching event could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Event fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Event> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByGroupId_Last(groupId, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
    }

    /**
     * Returns the last event in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event, or <code>null</code> if a matching event could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Event fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<Event> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event[] findByGroupId_PrevAndNext(long eventId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, event, groupId,
                    orderByComparator, true);

            array[1] = event;

            array[2] = getByGroupId_PrevAndNext(session, event, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event getByGroupId_PrevAndNext(Session session, Event event,
        long groupId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EventModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the events that the user has permission to view where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching events that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Event> filterFindByGroupId(long groupId)
        throws SystemException {
        return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> filterFindByGroupId(long groupId, int start, int end)
        throws SystemException {
        return filterFindByGroupId(groupId, start, end, null);
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
    @Override
    public List<Event> filterFindByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupId(groupId, start, end, orderByComparator);
        }

        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(3 +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            if (getDB().isSupportsInlineDistinct()) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator, true);
            } else {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
                    orderByComparator, true);
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EventModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, EventImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, EventImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            return (List<Event>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
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
    @Override
    public Event[] filterFindByGroupId_PrevAndNext(long eventId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupId_PrevAndNext(eventId, groupId, orderByComparator);
        }

        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = filterGetByGroupId_PrevAndNext(session, event, groupId,
                    orderByComparator, true);

            array[1] = event;

            array[2] = filterGetByGroupId_PrevAndNext(session, event, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event filterGetByGroupId_PrevAndNext(Session session,
        Event event, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EventModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, EventImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, EventImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the events where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (Event event : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(event);
        }
    }

    /**
     * Returns the number of events where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupId(long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of events that the user has permission to view where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching events that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int filterCountByGroupId(long groupId) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByGroupId(groupId);
        }

        StringBundler query = new StringBundler(2);

        query.append(_FILTER_SQL_COUNT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            q.addScalar(COUNT_COLUMN_NAME,
                com.liferay.portal.kernel.dao.orm.Type.LONG);

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            Long count = (Long) q.uniqueResult();

            return count.intValue();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Returns all the events where companyId = &#63; and status &ne; &#63;.
     *
     * @param companyId the company ID
     * @param status the status
     * @return the matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Event> findByC_NotS(long companyId, int status)
        throws SystemException {
        return findByC_NotS(companyId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> findByC_NotS(long companyId, int status, int start,
        int end) throws SystemException {
        return findByC_NotS(companyId, status, start, end, null);
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
    @Override
    public List<Event> findByC_NotS(long companyId, int status, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOTS;
        finderArgs = new Object[] {
                companyId, status,
                
                start, end, orderByComparator
            };

        List<Event> list = (List<Event>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Event event : list) {
                if ((companyId != event.getCompanyId()) ||
                        (status == event.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_C_NOTS_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_NOTS_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Event>(list);
                } else {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Event findByC_NotS_First(long companyId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByC_NotS_First(companyId, status, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByC_NotS_First(long companyId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Event> list = findByC_NotS(companyId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event findByC_NotS_Last(long companyId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByC_NotS_Last(companyId, status, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByC_NotS_Last(long companyId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_NotS(companyId, status);

        if (count == 0) {
            return null;
        }

        List<Event> list = findByC_NotS(companyId, status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event[] findByC_NotS_PrevAndNext(long eventId, long companyId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = getByC_NotS_PrevAndNext(session, event, companyId,
                    status, orderByComparator, true);

            array[1] = event;

            array[2] = getByC_NotS_PrevAndNext(session, event, companyId,
                    status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event getByC_NotS_PrevAndNext(Session session, Event event,
        long companyId, int status, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_C_NOTS_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_NOTS_STATUS_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EventModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the events where companyId = &#63; and status &ne; &#63; from the database.
     *
     * @param companyId the company ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_NotS(long companyId, int status)
        throws SystemException {
        for (Event event : findByC_NotS(companyId, status, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(event);
        }
    }

    /**
     * Returns the number of events where companyId = &#63; and status &ne; &#63;.
     *
     * @param companyId the company ID
     * @param status the status
     * @return the number of matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByC_NotS(long companyId, int status)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_NOTS;

        Object[] finderArgs = new Object[] { companyId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_C_NOTS_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_NOTS_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(status);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the events where companyId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param status the status
     * @return the matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Event> findByC_S(long companyId, int status)
        throws SystemException {
        return findByC_S(companyId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> findByC_S(long companyId, int status, int start, int end)
        throws SystemException {
        return findByC_S(companyId, status, start, end, null);
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
    @Override
    public List<Event> findByC_S(long companyId, int status, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S;
            finderArgs = new Object[] { companyId, status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_S;
            finderArgs = new Object[] {
                    companyId, status,
                    
                    start, end, orderByComparator
                };
        }

        List<Event> list = (List<Event>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Event event : list) {
                if ((companyId != event.getCompanyId()) ||
                        (status != event.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_C_S_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Event>(list);
                } else {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Event findByC_S_First(long companyId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByC_S_First(companyId, status, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByC_S_First(long companyId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Event> list = findByC_S(companyId, status, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event findByC_S_Last(long companyId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByC_S_Last(companyId, status, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByC_S_Last(long companyId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_S(companyId, status);

        if (count == 0) {
            return null;
        }

        List<Event> list = findByC_S(companyId, status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event[] findByC_S_PrevAndNext(long eventId, long companyId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = getByC_S_PrevAndNext(session, event, companyId, status,
                    orderByComparator, true);

            array[1] = event;

            array[2] = getByC_S_PrevAndNext(session, event, companyId, status,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event getByC_S_PrevAndNext(Session session, Event event,
        long companyId, int status, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_C_S_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_S_STATUS_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EventModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the events where companyId = &#63; and status = &#63; from the database.
     *
     * @param companyId the company ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_S(long companyId, int status)
        throws SystemException {
        for (Event event : findByC_S(companyId, status, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(event);
        }
    }

    /**
     * Returns the number of events where companyId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param status the status
     * @return the number of matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByC_S(long companyId, int status) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_C_S;

        Object[] finderArgs = new Object[] { companyId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_C_S_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_S_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(status);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the events where groupId = &#63; and status &ne; &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @return the matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Event> findByG_NotS(long groupId, int status)
        throws SystemException {
        return findByG_NotS(groupId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> findByG_NotS(long groupId, int status, int start, int end)
        throws SystemException {
        return findByG_NotS(groupId, status, start, end, null);
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
    @Override
    public List<Event> findByG_NotS(long groupId, int status, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_NOTS;
        finderArgs = new Object[] { groupId, status, start, end, orderByComparator };

        List<Event> list = (List<Event>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Event event : list) {
                if ((groupId != event.getGroupId()) ||
                        (status == event.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_G_NOTS_GROUPID_2);

            query.append(_FINDER_COLUMN_G_NOTS_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Event>(list);
                } else {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Event findByG_NotS_First(long groupId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByG_NotS_First(groupId, status, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByG_NotS_First(long groupId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Event> list = findByG_NotS(groupId, status, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event findByG_NotS_Last(long groupId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByG_NotS_Last(groupId, status, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByG_NotS_Last(long groupId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByG_NotS(groupId, status);

        if (count == 0) {
            return null;
        }

        List<Event> list = findByG_NotS(groupId, status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event[] findByG_NotS_PrevAndNext(long eventId, long groupId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = getByG_NotS_PrevAndNext(session, event, groupId, status,
                    orderByComparator, true);

            array[1] = event;

            array[2] = getByG_NotS_PrevAndNext(session, event, groupId, status,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event getByG_NotS_PrevAndNext(Session session, Event event,
        long groupId, int status, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_G_NOTS_GROUPID_2);

        query.append(_FINDER_COLUMN_G_NOTS_STATUS_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EventModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the events that the user has permission to view where groupId = &#63; and status &ne; &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @return the matching events that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Event> filterFindByG_NotS(long groupId, int status)
        throws SystemException {
        return filterFindByG_NotS(groupId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> filterFindByG_NotS(long groupId, int status, int start,
        int end) throws SystemException {
        return filterFindByG_NotS(groupId, status, start, end, null);
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
    @Override
    public List<Event> filterFindByG_NotS(long groupId, int status, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByG_NotS(groupId, status, start, end, orderByComparator);
        }

        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(4 +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(4);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_G_NOTS_GROUPID_2);

        query.append(_FINDER_COLUMN_G_NOTS_STATUS_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            if (getDB().isSupportsInlineDistinct()) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator, true);
            } else {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
                    orderByComparator, true);
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EventModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, EventImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, EventImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(status);

            return (List<Event>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
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
    @Override
    public Event[] filterFindByG_NotS_PrevAndNext(long eventId, long groupId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByG_NotS_PrevAndNext(eventId, groupId, status,
                orderByComparator);
        }

        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = filterGetByG_NotS_PrevAndNext(session, event, groupId,
                    status, orderByComparator, true);

            array[1] = event;

            array[2] = filterGetByG_NotS_PrevAndNext(session, event, groupId,
                    status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event filterGetByG_NotS_PrevAndNext(Session session, Event event,
        long groupId, int status, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_G_NOTS_GROUPID_2);

        query.append(_FINDER_COLUMN_G_NOTS_STATUS_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EventModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, EventImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, EventImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the events where groupId = &#63; and status &ne; &#63; from the database.
     *
     * @param groupId the group ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByG_NotS(long groupId, int status)
        throws SystemException {
        for (Event event : findByG_NotS(groupId, status, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(event);
        }
    }

    /**
     * Returns the number of events where groupId = &#63; and status &ne; &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @return the number of matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByG_NotS(long groupId, int status)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_NOTS;

        Object[] finderArgs = new Object[] { groupId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_G_NOTS_GROUPID_2);

            query.append(_FINDER_COLUMN_G_NOTS_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(status);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of events that the user has permission to view where groupId = &#63; and status &ne; &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @return the number of matching events that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int filterCountByG_NotS(long groupId, int status)
        throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByG_NotS(groupId, status);
        }

        StringBundler query = new StringBundler(3);

        query.append(_FILTER_SQL_COUNT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_G_NOTS_GROUPID_2);

        query.append(_FINDER_COLUMN_G_NOTS_STATUS_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            q.addScalar(COUNT_COLUMN_NAME,
                com.liferay.portal.kernel.dao.orm.Type.LONG);

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(status);

            Long count = (Long) q.uniqueResult();

            return count.intValue();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Returns all the events where groupId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @return the matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Event> findByG_S(long groupId, int status)
        throws SystemException {
        return findByG_S(groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Event> findByG_S(long groupId, int status, int start, int end)
        throws SystemException {
        return findByG_S(groupId, status, start, end, null);
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
    @Override
    public List<Event> findByG_S(long groupId, int status, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S;
            finderArgs = new Object[] { groupId, status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S;
            finderArgs = new Object[] {
                    groupId, status,
                    
                    start, end, orderByComparator
                };
        }

        List<Event> list = (List<Event>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Event event : list) {
                if ((groupId != event.getGroupId()) ||
                        (status != event.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_G_S_GROUPID_2);

            query.append(_FINDER_COLUMN_G_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Event>(list);
                } else {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Event findByG_S_First(long groupId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByG_S_First(groupId, status, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByG_S_First(long groupId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Event> list = findByG_S(groupId, status, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event findByG_S_Last(long groupId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByG_S_Last(groupId, status, orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByG_S_Last(long groupId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByG_S(groupId, status);

        if (count == 0) {
            return null;
        }

        List<Event> list = findByG_S(groupId, status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event[] findByG_S_PrevAndNext(long eventId, long groupId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = getByG_S_PrevAndNext(session, event, groupId, status,
                    orderByComparator, true);

            array[1] = event;

            array[2] = getByG_S_PrevAndNext(session, event, groupId, status,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event getByG_S_PrevAndNext(Session session, Event event,
        long groupId, int status, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_G_S_GROUPID_2);

        query.append(_FINDER_COLUMN_G_S_STATUS_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EventModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the events that the user has permission to view where groupId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @return the matching events that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Event> filterFindByG_S(long groupId, int status)
        throws SystemException {
        return filterFindByG_S(groupId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> filterFindByG_S(long groupId, int status, int start,
        int end) throws SystemException {
        return filterFindByG_S(groupId, status, start, end, null);
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
    @Override
    public List<Event> filterFindByG_S(long groupId, int status, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByG_S(groupId, status, start, end, orderByComparator);
        }

        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(4 +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(4);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_G_S_GROUPID_2);

        query.append(_FINDER_COLUMN_G_S_STATUS_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            if (getDB().isSupportsInlineDistinct()) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator, true);
            } else {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
                    orderByComparator, true);
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EventModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, EventImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, EventImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(status);

            return (List<Event>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
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
    @Override
    public Event[] filterFindByG_S_PrevAndNext(long eventId, long groupId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByG_S_PrevAndNext(eventId, groupId, status,
                orderByComparator);
        }

        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = filterGetByG_S_PrevAndNext(session, event, groupId,
                    status, orderByComparator, true);

            array[1] = event;

            array[2] = filterGetByG_S_PrevAndNext(session, event, groupId,
                    status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event filterGetByG_S_PrevAndNext(Session session, Event event,
        long groupId, int status, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_G_S_GROUPID_2);

        query.append(_FINDER_COLUMN_G_S_STATUS_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EventModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, EventImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, EventImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the events where groupId = &#63; and status = &#63; from the database.
     *
     * @param groupId the group ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByG_S(long groupId, int status) throws SystemException {
        for (Event event : findByG_S(groupId, status, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(event);
        }
    }

    /**
     * Returns the number of events where groupId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @return the number of matching events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByG_S(long groupId, int status) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S;

        Object[] finderArgs = new Object[] { groupId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_G_S_GROUPID_2);

            query.append(_FINDER_COLUMN_G_S_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(status);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of events that the user has permission to view where groupId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @return the number of matching events that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int filterCountByG_S(long groupId, int status)
        throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByG_S(groupId, status);
        }

        StringBundler query = new StringBundler(3);

        query.append(_FILTER_SQL_COUNT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_G_S_GROUPID_2);

        query.append(_FINDER_COLUMN_G_S_STATUS_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            q.addScalar(COUNT_COLUMN_NAME,
                com.liferay.portal.kernel.dao.orm.Type.LONG);

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(status);

            Long count = (Long) q.uniqueResult();

            return count.intValue();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
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
    @Override
    public List<Event> findByC_U_NotS(long companyId, long userId, int status)
        throws SystemException {
        return findByC_U_NotS(companyId, userId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> findByC_U_NotS(long companyId, long userId, int status,
        int start, int end) throws SystemException {
        return findByC_U_NotS(companyId, userId, status, start, end, null);
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
    @Override
    public List<Event> findByC_U_NotS(long companyId, long userId, int status,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_U_NOTS;
        finderArgs = new Object[] {
                companyId, userId, status,
                
                start, end, orderByComparator
            };

        List<Event> list = (List<Event>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Event event : list) {
                if ((companyId != event.getCompanyId()) ||
                        (userId != event.getUserId()) ||
                        (status == event.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_C_U_NOTS_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_U_NOTS_USERID_2);

            query.append(_FINDER_COLUMN_C_U_NOTS_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(userId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Event>(list);
                } else {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Event findByC_U_NotS_First(long companyId, long userId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByC_U_NotS_First(companyId, userId, status,
                orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByC_U_NotS_First(long companyId, long userId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Event> list = findByC_U_NotS(companyId, userId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event findByC_U_NotS_Last(long companyId, long userId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByC_U_NotS_Last(companyId, userId, status,
                orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByC_U_NotS_Last(long companyId, long userId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_U_NotS(companyId, userId, status);

        if (count == 0) {
            return null;
        }

        List<Event> list = findByC_U_NotS(companyId, userId, status, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event[] findByC_U_NotS_PrevAndNext(long eventId, long companyId,
        long userId, int status, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = getByC_U_NotS_PrevAndNext(session, event, companyId,
                    userId, status, orderByComparator, true);

            array[1] = event;

            array[2] = getByC_U_NotS_PrevAndNext(session, event, companyId,
                    userId, status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event getByC_U_NotS_PrevAndNext(Session session, Event event,
        long companyId, long userId, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_C_U_NOTS_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_U_NOTS_USERID_2);

        query.append(_FINDER_COLUMN_C_U_NOTS_STATUS_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EventModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(userId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the events where companyId = &#63; and userId = &#63; and status &ne; &#63; from the database.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_U_NotS(long companyId, long userId, int status)
        throws SystemException {
        for (Event event : findByC_U_NotS(companyId, userId, status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(event);
        }
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
    @Override
    public int countByC_U_NotS(long companyId, long userId, int status)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_U_NOTS;

        Object[] finderArgs = new Object[] { companyId, userId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_C_U_NOTS_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_U_NOTS_USERID_2);

            query.append(_FINDER_COLUMN_C_U_NOTS_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(userId);

                qPos.add(status);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
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
    @Override
    public List<Event> findByC_U_S(long companyId, long userId, int status)
        throws SystemException {
        return findByC_U_S(companyId, userId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> findByC_U_S(long companyId, long userId, int status,
        int start, int end) throws SystemException {
        return findByC_U_S(companyId, userId, status, start, end, null);
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
    @Override
    public List<Event> findByC_U_S(long companyId, long userId, int status,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U_S;
            finderArgs = new Object[] { companyId, userId, status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_U_S;
            finderArgs = new Object[] {
                    companyId, userId, status,
                    
                    start, end, orderByComparator
                };
        }

        List<Event> list = (List<Event>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Event event : list) {
                if ((companyId != event.getCompanyId()) ||
                        (userId != event.getUserId()) ||
                        (status != event.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_U_S_USERID_2);

            query.append(_FINDER_COLUMN_C_U_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(userId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Event>(list);
                } else {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Event findByC_U_S_First(long companyId, long userId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByC_U_S_First(companyId, userId, status,
                orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByC_U_S_First(long companyId, long userId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Event> list = findByC_U_S(companyId, userId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event findByC_U_S_Last(long companyId, long userId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByC_U_S_Last(companyId, userId, status,
                orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByC_U_S_Last(long companyId, long userId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_U_S(companyId, userId, status);

        if (count == 0) {
            return null;
        }

        List<Event> list = findByC_U_S(companyId, userId, status, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event[] findByC_U_S_PrevAndNext(long eventId, long companyId,
        long userId, int status, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = getByC_U_S_PrevAndNext(session, event, companyId,
                    userId, status, orderByComparator, true);

            array[1] = event;

            array[2] = getByC_U_S_PrevAndNext(session, event, companyId,
                    userId, status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event getByC_U_S_PrevAndNext(Session session, Event event,
        long companyId, long userId, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_U_S_USERID_2);

        query.append(_FINDER_COLUMN_C_U_S_STATUS_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EventModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(userId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the events where companyId = &#63; and userId = &#63; and status = &#63; from the database.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_U_S(long companyId, long userId, int status)
        throws SystemException {
        for (Event event : findByC_U_S(companyId, userId, status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(event);
        }
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
    @Override
    public int countByC_U_S(long companyId, long userId, int status)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_C_U_S;

        Object[] finderArgs = new Object[] { companyId, userId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_C_U_S_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_U_S_USERID_2);

            query.append(_FINDER_COLUMN_C_U_S_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(userId);

                qPos.add(status);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
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
    @Override
    public List<Event> findByG_U_NotS(long groupId, long userId, int status)
        throws SystemException {
        return findByG_U_NotS(groupId, userId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> findByG_U_NotS(long groupId, long userId, int status,
        int start, int end) throws SystemException {
        return findByG_U_NotS(groupId, userId, status, start, end, null);
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
    @Override
    public List<Event> findByG_U_NotS(long groupId, long userId, int status,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U_NOTS;
        finderArgs = new Object[] {
                groupId, userId, status,
                
                start, end, orderByComparator
            };

        List<Event> list = (List<Event>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Event event : list) {
                if ((groupId != event.getGroupId()) ||
                        (userId != event.getUserId()) ||
                        (status == event.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_G_U_NOTS_GROUPID_2);

            query.append(_FINDER_COLUMN_G_U_NOTS_USERID_2);

            query.append(_FINDER_COLUMN_G_U_NOTS_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(userId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Event>(list);
                } else {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Event findByG_U_NotS_First(long groupId, long userId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByG_U_NotS_First(groupId, userId, status,
                orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByG_U_NotS_First(long groupId, long userId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Event> list = findByG_U_NotS(groupId, userId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event findByG_U_NotS_Last(long groupId, long userId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByG_U_NotS_Last(groupId, userId, status,
                orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByG_U_NotS_Last(long groupId, long userId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByG_U_NotS(groupId, userId, status);

        if (count == 0) {
            return null;
        }

        List<Event> list = findByG_U_NotS(groupId, userId, status, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event[] findByG_U_NotS_PrevAndNext(long eventId, long groupId,
        long userId, int status, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = getByG_U_NotS_PrevAndNext(session, event, groupId,
                    userId, status, orderByComparator, true);

            array[1] = event;

            array[2] = getByG_U_NotS_PrevAndNext(session, event, groupId,
                    userId, status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event getByG_U_NotS_PrevAndNext(Session session, Event event,
        long groupId, long userId, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_G_U_NOTS_GROUPID_2);

        query.append(_FINDER_COLUMN_G_U_NOTS_USERID_2);

        query.append(_FINDER_COLUMN_G_U_NOTS_STATUS_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EventModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(userId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
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
    @Override
    public List<Event> filterFindByG_U_NotS(long groupId, long userId,
        int status) throws SystemException {
        return filterFindByG_U_NotS(groupId, userId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> filterFindByG_U_NotS(long groupId, long userId,
        int status, int start, int end) throws SystemException {
        return filterFindByG_U_NotS(groupId, userId, status, start, end, null);
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
    @Override
    public List<Event> filterFindByG_U_NotS(long groupId, long userId,
        int status, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByG_U_NotS(groupId, userId, status, start, end,
                orderByComparator);
        }

        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(5 +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(5);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_G_U_NOTS_GROUPID_2);

        query.append(_FINDER_COLUMN_G_U_NOTS_USERID_2);

        query.append(_FINDER_COLUMN_G_U_NOTS_STATUS_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            if (getDB().isSupportsInlineDistinct()) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator, true);
            } else {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
                    orderByComparator, true);
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EventModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, EventImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, EventImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(userId);

            qPos.add(status);

            return (List<Event>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
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
    @Override
    public Event[] filterFindByG_U_NotS_PrevAndNext(long eventId, long groupId,
        long userId, int status, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByG_U_NotS_PrevAndNext(eventId, groupId, userId, status,
                orderByComparator);
        }

        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = filterGetByG_U_NotS_PrevAndNext(session, event, groupId,
                    userId, status, orderByComparator, true);

            array[1] = event;

            array[2] = filterGetByG_U_NotS_PrevAndNext(session, event, groupId,
                    userId, status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event filterGetByG_U_NotS_PrevAndNext(Session session,
        Event event, long groupId, long userId, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_G_U_NOTS_GROUPID_2);

        query.append(_FINDER_COLUMN_G_U_NOTS_USERID_2);

        query.append(_FINDER_COLUMN_G_U_NOTS_STATUS_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EventModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, EventImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, EventImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(userId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the events where groupId = &#63; and userId = &#63; and status &ne; &#63; from the database.
     *
     * @param groupId the group ID
     * @param userId the user ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByG_U_NotS(long groupId, long userId, int status)
        throws SystemException {
        for (Event event : findByG_U_NotS(groupId, userId, status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(event);
        }
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
    @Override
    public int countByG_U_NotS(long groupId, long userId, int status)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_U_NOTS;

        Object[] finderArgs = new Object[] { groupId, userId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_G_U_NOTS_GROUPID_2);

            query.append(_FINDER_COLUMN_G_U_NOTS_USERID_2);

            query.append(_FINDER_COLUMN_G_U_NOTS_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(userId);

                qPos.add(status);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
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
    @Override
    public int filterCountByG_U_NotS(long groupId, long userId, int status)
        throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByG_U_NotS(groupId, userId, status);
        }

        StringBundler query = new StringBundler(4);

        query.append(_FILTER_SQL_COUNT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_G_U_NOTS_GROUPID_2);

        query.append(_FINDER_COLUMN_G_U_NOTS_USERID_2);

        query.append(_FINDER_COLUMN_G_U_NOTS_STATUS_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            q.addScalar(COUNT_COLUMN_NAME,
                com.liferay.portal.kernel.dao.orm.Type.LONG);

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(userId);

            qPos.add(status);

            Long count = (Long) q.uniqueResult();

            return count.intValue();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
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
    @Override
    public List<Event> findByG_U_S(long groupId, long userId, int status)
        throws SystemException {
        return findByG_U_S(groupId, userId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> findByG_U_S(long groupId, long userId, int status,
        int start, int end) throws SystemException {
        return findByG_U_S(groupId, userId, status, start, end, null);
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
    @Override
    public List<Event> findByG_U_S(long groupId, long userId, int status,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_S;
            finderArgs = new Object[] { groupId, userId, status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U_S;
            finderArgs = new Object[] {
                    groupId, userId, status,
                    
                    start, end, orderByComparator
                };
        }

        List<Event> list = (List<Event>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Event event : list) {
                if ((groupId != event.getGroupId()) ||
                        (userId != event.getUserId()) ||
                        (status != event.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

            query.append(_FINDER_COLUMN_G_U_S_USERID_2);

            query.append(_FINDER_COLUMN_G_U_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(userId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Event>(list);
                } else {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Event findByG_U_S_First(long groupId, long userId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByG_U_S_First(groupId, userId, status,
                orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByG_U_S_First(long groupId, long userId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Event> list = findByG_U_S(groupId, userId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event findByG_U_S_Last(long groupId, long userId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = fetchByG_U_S_Last(groupId, userId, status,
                orderByComparator);

        if (event != null) {
            return event;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventException(msg.toString());
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
    @Override
    public Event fetchByG_U_S_Last(long groupId, long userId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByG_U_S(groupId, userId, status);

        if (count == 0) {
            return null;
        }

        List<Event> list = findByG_U_S(groupId, userId, status, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Event[] findByG_U_S_PrevAndNext(long eventId, long groupId,
        long userId, int status, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = getByG_U_S_PrevAndNext(session, event, groupId, userId,
                    status, orderByComparator, true);

            array[1] = event;

            array[2] = getByG_U_S_PrevAndNext(session, event, groupId, userId,
                    status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event getByG_U_S_PrevAndNext(Session session, Event event,
        long groupId, long userId, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

        query.append(_FINDER_COLUMN_G_U_S_USERID_2);

        query.append(_FINDER_COLUMN_G_U_S_STATUS_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EventModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(userId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
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
    @Override
    public List<Event> filterFindByG_U_S(long groupId, long userId, int status)
        throws SystemException {
        return filterFindByG_U_S(groupId, userId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> filterFindByG_U_S(long groupId, long userId, int status,
        int start, int end) throws SystemException {
        return filterFindByG_U_S(groupId, userId, status, start, end, null);
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
    @Override
    public List<Event> filterFindByG_U_S(long groupId, long userId, int status,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByG_U_S(groupId, userId, status, start, end,
                orderByComparator);
        }

        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(5 +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(5);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

        query.append(_FINDER_COLUMN_G_U_S_USERID_2);

        query.append(_FINDER_COLUMN_G_U_S_STATUS_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            if (getDB().isSupportsInlineDistinct()) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator, true);
            } else {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
                    orderByComparator, true);
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EventModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, EventImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, EventImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(userId);

            qPos.add(status);

            return (List<Event>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
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
    @Override
    public Event[] filterFindByG_U_S_PrevAndNext(long eventId, long groupId,
        long userId, int status, OrderByComparator orderByComparator)
        throws NoSuchEventException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByG_U_S_PrevAndNext(eventId, groupId, userId, status,
                orderByComparator);
        }

        Event event = findByPrimaryKey(eventId);

        Session session = null;

        try {
            session = openSession();

            Event[] array = new EventImpl[3];

            array[0] = filterGetByG_U_S_PrevAndNext(session, event, groupId,
                    userId, status, orderByComparator, true);

            array[1] = event;

            array[2] = filterGetByG_U_S_PrevAndNext(session, event, groupId,
                    userId, status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Event filterGetByG_U_S_PrevAndNext(Session session, Event event,
        long groupId, long userId, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

        query.append(_FINDER_COLUMN_G_U_S_USERID_2);

        query.append(_FINDER_COLUMN_G_U_S_STATUS_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_EVENT_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(EventModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(EventModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, EventImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, EventImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(userId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(event);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Event> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the events where groupId = &#63; and userId = &#63; and status = &#63; from the database.
     *
     * @param groupId the group ID
     * @param userId the user ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByG_U_S(long groupId, long userId, int status)
        throws SystemException {
        for (Event event : findByG_U_S(groupId, userId, status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(event);
        }
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
    @Override
    public int countByG_U_S(long groupId, long userId, int status)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_G_U_S;

        Object[] finderArgs = new Object[] { groupId, userId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_EVENT_WHERE);

            query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

            query.append(_FINDER_COLUMN_G_U_S_USERID_2);

            query.append(_FINDER_COLUMN_G_U_S_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(userId);

                qPos.add(status);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
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
    @Override
    public int filterCountByG_U_S(long groupId, long userId, int status)
        throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByG_U_S(groupId, userId, status);
        }

        StringBundler query = new StringBundler(4);

        query.append(_FILTER_SQL_COUNT_EVENT_WHERE);

        query.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

        query.append(_FINDER_COLUMN_G_U_S_USERID_2);

        query.append(_FINDER_COLUMN_G_U_S_STATUS_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Event.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            q.addScalar(COUNT_COLUMN_NAME,
                com.liferay.portal.kernel.dao.orm.Type.LONG);

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(userId);

            qPos.add(status);

            Long count = (Long) q.uniqueResult();

            return count.intValue();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Caches the event in the entity cache if it is enabled.
     *
     * @param event the event
     */
    @Override
    public void cacheResult(Event event) {
        EntityCacheUtil.putResult(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventImpl.class, event.getPrimaryKey(), event);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { event.getUuid(), event.getGroupId() }, event);

        event.resetOriginalValues();
    }

    /**
     * Caches the events in the entity cache if it is enabled.
     *
     * @param events the events
     */
    @Override
    public void cacheResult(List<Event> events) {
        for (Event event : events) {
            if (EntityCacheUtil.getResult(EventModelImpl.ENTITY_CACHE_ENABLED,
                        EventImpl.class, event.getPrimaryKey()) == null) {
                cacheResult(event);
            } else {
                event.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all events.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(EventImpl.class.getName());
        }

        EntityCacheUtil.clearCache(EventImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the event.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Event event) {
        EntityCacheUtil.removeResult(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventImpl.class, event.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(event);
    }

    @Override
    public void clearCache(List<Event> events) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Event event : events) {
            EntityCacheUtil.removeResult(EventModelImpl.ENTITY_CACHE_ENABLED,
                EventImpl.class, event.getPrimaryKey());

            clearUniqueFindersCache(event);
        }
    }

    protected void cacheUniqueFindersCache(Event event) {
        if (event.isNew()) {
            Object[] args = new Object[] { event.getUuid(), event.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, event);
        } else {
            EventModelImpl eventModelImpl = (EventModelImpl) event;

            if ((eventModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { event.getUuid(), event.getGroupId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    event);
            }
        }
    }

    protected void clearUniqueFindersCache(Event event) {
        EventModelImpl eventModelImpl = (EventModelImpl) event;

        Object[] args = new Object[] { event.getUuid(), event.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((eventModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    eventModelImpl.getOriginalUuid(),
                    eventModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new event with the primary key. Does not add the event to the database.
     *
     * @param eventId the primary key for the new event
     * @return the new event
     */
    @Override
    public Event create(long eventId) {
        Event event = new EventImpl();

        event.setNew(true);
        event.setPrimaryKey(eventId);

        String uuid = PortalUUIDUtil.generate();

        event.setUuid(uuid);

        return event;
    }

    /**
     * Removes the event with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param eventId the primary key of the event
     * @return the event that was removed
     * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Event remove(long eventId)
        throws NoSuchEventException, SystemException {
        return remove((Serializable) eventId);
    }

    /**
     * Removes the event with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the event
     * @return the event that was removed
     * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Event remove(Serializable primaryKey)
        throws NoSuchEventException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Event event = (Event) session.get(EventImpl.class, primaryKey);

            if (event == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(event);
        } catch (NoSuchEventException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Event removeImpl(Event event) throws SystemException {
        event = toUnwrappedModel(event);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(event)) {
                event = (Event) session.get(EventImpl.class,
                        event.getPrimaryKeyObj());
            }

            if (event != null) {
                session.delete(event);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (event != null) {
            clearCache(event);
        }

        return event;
    }

    @Override
    public Event updateImpl(
        com.opensourceforlife.portlet.samplerecyclebin.model.Event event)
        throws SystemException {
        event = toUnwrappedModel(event);

        boolean isNew = event.isNew();

        EventModelImpl eventModelImpl = (EventModelImpl) event;

        if (Validator.isNull(event.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            event.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (event.isNew()) {
                session.save(event);

                event.setNew(false);
            } else {
                session.merge(event);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !EventModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((eventModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { eventModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { eventModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((eventModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        eventModelImpl.getOriginalUuid(),
                        eventModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        eventModelImpl.getUuid(), eventModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((eventModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { eventModelImpl.getOriginalGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { eventModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((eventModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        eventModelImpl.getOriginalCompanyId(),
                        eventModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S,
                    args);

                args = new Object[] {
                        eventModelImpl.getCompanyId(),
                        eventModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S,
                    args);
            }

            if ((eventModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        eventModelImpl.getOriginalGroupId(),
                        eventModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
                    args);

                args = new Object[] {
                        eventModelImpl.getGroupId(), eventModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
                    args);
            }

            if ((eventModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        eventModelImpl.getOriginalCompanyId(),
                        eventModelImpl.getOriginalUserId(),
                        eventModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_U_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U_S,
                    args);

                args = new Object[] {
                        eventModelImpl.getCompanyId(),
                        eventModelImpl.getUserId(), eventModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_U_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U_S,
                    args);
            }

            if ((eventModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        eventModelImpl.getOriginalGroupId(),
                        eventModelImpl.getOriginalUserId(),
                        eventModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_S,
                    args);

                args = new Object[] {
                        eventModelImpl.getGroupId(), eventModelImpl.getUserId(),
                        eventModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_S,
                    args);
            }
        }

        EntityCacheUtil.putResult(EventModelImpl.ENTITY_CACHE_ENABLED,
            EventImpl.class, event.getPrimaryKey(), event);

        clearUniqueFindersCache(event);
        cacheUniqueFindersCache(event);

        return event;
    }

    protected Event toUnwrappedModel(Event event) {
        if (event instanceof EventImpl) {
            return event;
        }

        EventImpl eventImpl = new EventImpl();

        eventImpl.setNew(event.isNew());
        eventImpl.setPrimaryKey(event.getPrimaryKey());

        eventImpl.setUuid(event.getUuid());
        eventImpl.setEventId(event.getEventId());
        eventImpl.setCompanyId(event.getCompanyId());
        eventImpl.setGroupId(event.getGroupId());
        eventImpl.setUserId(event.getUserId());
        eventImpl.setCreateDate(event.getCreateDate());
        eventImpl.setModifiedDate(event.getModifiedDate());
        eventImpl.setName(event.getName());
        eventImpl.setDescription(event.getDescription());
        eventImpl.setDate(event.getDate());
        eventImpl.setStatus(event.getStatus());
        eventImpl.setStatusByUserId(event.getStatusByUserId());
        eventImpl.setStatusByUserName(event.getStatusByUserName());
        eventImpl.setStatusDate(event.getStatusDate());

        return eventImpl;
    }

    /**
     * Returns the event with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the event
     * @return the event
     * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Event findByPrimaryKey(Serializable primaryKey)
        throws NoSuchEventException, SystemException {
        Event event = fetchByPrimaryKey(primaryKey);

        if (event == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return event;
    }

    /**
     * Returns the event with the primary key or throws a {@link com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException} if it could not be found.
     *
     * @param eventId the primary key of the event
     * @return the event
     * @throws com.opensourceforlife.portlet.samplerecyclebin.NoSuchEventException if a event with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Event findByPrimaryKey(long eventId)
        throws NoSuchEventException, SystemException {
        return findByPrimaryKey((Serializable) eventId);
    }

    /**
     * Returns the event with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the event
     * @return the event, or <code>null</code> if a event with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Event fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Event event = (Event) EntityCacheUtil.getResult(EventModelImpl.ENTITY_CACHE_ENABLED,
                EventImpl.class, primaryKey);

        if (event == _nullEvent) {
            return null;
        }

        if (event == null) {
            Session session = null;

            try {
                session = openSession();

                event = (Event) session.get(EventImpl.class, primaryKey);

                if (event != null) {
                    cacheResult(event);
                } else {
                    EntityCacheUtil.putResult(EventModelImpl.ENTITY_CACHE_ENABLED,
                        EventImpl.class, primaryKey, _nullEvent);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(EventModelImpl.ENTITY_CACHE_ENABLED,
                    EventImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return event;
    }

    /**
     * Returns the event with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param eventId the primary key of the event
     * @return the event, or <code>null</code> if a event with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Event fetchByPrimaryKey(long eventId) throws SystemException {
        return fetchByPrimaryKey((Serializable) eventId);
    }

    /**
     * Returns all the events.
     *
     * @return the events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Event> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Event> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Event> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Event> list = (List<Event>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_EVENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_EVENT;

                if (pagination) {
                    sql = sql.concat(EventModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Event>(list);
                } else {
                    list = (List<Event>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the events from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Event event : findAll()) {
            remove(event);
        }
    }

    /**
     * Returns the number of events.
     *
     * @return the number of events
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_EVENT);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the event persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.opensourceforlife.portlet.samplerecyclebin.model.Event")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Event>> listenersList = new ArrayList<ModelListener<Event>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Event>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(EventImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
