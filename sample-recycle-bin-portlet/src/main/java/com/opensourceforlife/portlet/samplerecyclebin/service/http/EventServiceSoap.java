package com.opensourceforlife.portlet.samplerecyclebin.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.opensourceforlife.portlet.samplerecyclebin.service.EventServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.opensourceforlife.portlet.samplerecyclebin.service.EventServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.opensourceforlife.portlet.samplerecyclebin.model.EventSoap}.
 * If the method in the service utility returns a
 * {@link com.opensourceforlife.portlet.samplerecyclebin.model.Event}, that is translated to a
 * {@link com.opensourceforlife.portlet.samplerecyclebin.model.EventSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Opensourceforlife
 * @see EventServiceHttp
 * @see com.opensourceforlife.portlet.samplerecyclebin.model.EventSoap
 * @see com.opensourceforlife.portlet.samplerecyclebin.service.EventServiceUtil
 * @generated
 */
public class EventServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(EventServiceSoap.class);

    public static com.opensourceforlife.portlet.samplerecyclebin.model.EventSoap addEvent(
        long groupId, java.lang.String name, java.lang.String description,
        int month, int day, int year, int hour, int minute,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.opensourceforlife.portlet.samplerecyclebin.model.Event returnValue =
                EventServiceUtil.addEvent(groupId, name, description, month,
                    day, year, hour, minute, serviceContext);

            return com.opensourceforlife.portlet.samplerecyclebin.model.EventSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.opensourceforlife.portlet.samplerecyclebin.model.EventSoap deleteEvent(
        long eventId) throws RemoteException {
        try {
            com.opensourceforlife.portlet.samplerecyclebin.model.Event returnValue =
                EventServiceUtil.deleteEvent(eventId);

            return com.opensourceforlife.portlet.samplerecyclebin.model.EventSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.opensourceforlife.portlet.samplerecyclebin.model.EventSoap getEvent(
        long eventId) throws RemoteException {
        try {
            com.opensourceforlife.portlet.samplerecyclebin.model.Event returnValue =
                EventServiceUtil.getEvent(eventId);

            return com.opensourceforlife.portlet.samplerecyclebin.model.EventSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.opensourceforlife.portlet.samplerecyclebin.model.EventSoap updateEvent(
        long userId, long eventId, java.lang.String name,
        java.lang.String description, int month, int day, int year, int hour,
        int minute, com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.opensourceforlife.portlet.samplerecyclebin.model.Event returnValue =
                EventServiceUtil.updateEvent(userId, eventId, name,
                    description, month, day, year, hour, minute, serviceContext);

            return com.opensourceforlife.portlet.samplerecyclebin.model.EventSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
