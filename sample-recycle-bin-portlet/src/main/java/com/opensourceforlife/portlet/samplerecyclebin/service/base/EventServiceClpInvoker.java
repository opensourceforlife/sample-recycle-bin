package com.opensourceforlife.portlet.samplerecyclebin.service.base;

import com.opensourceforlife.portlet.samplerecyclebin.service.EventServiceUtil;

import java.util.Arrays;

/**
 * @author Opensourceforlife
 * @generated
 */
public class EventServiceClpInvoker {
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName32;
    private String[] _methodParameterTypes32;
    private String _methodName33;
    private String[] _methodParameterTypes33;

    public EventServiceClpInvoker() {
        _methodName24 = "getBeanIdentifier";

        _methodParameterTypes24 = new String[] {  };

        _methodName25 = "setBeanIdentifier";

        _methodParameterTypes25 = new String[] { "java.lang.String" };

        _methodName30 = "addEvent";

        _methodParameterTypes30 = new String[] {
                "long", "java.lang.String", "java.lang.String", "int", "int",
                "int", "int", "int", "com.liferay.portal.service.ServiceContext"
            };

        _methodName31 = "deleteEvent";

        _methodParameterTypes31 = new String[] { "long" };

        _methodName32 = "getEvent";

        _methodParameterTypes32 = new String[] { "long" };

        _methodName33 = "updateEvent";

        _methodParameterTypes33 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String", "int",
                "int", "int", "int", "int",
                "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            return EventServiceUtil.getBeanIdentifier();
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            EventServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            return EventServiceUtil.addEvent(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                ((Integer) arguments[3]).intValue(),
                ((Integer) arguments[4]).intValue(),
                ((Integer) arguments[5]).intValue(),
                ((Integer) arguments[6]).intValue(),
                ((Integer) arguments[7]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[8]);
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            return EventServiceUtil.deleteEvent(((Long) arguments[0]).longValue());
        }

        if (_methodName32.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
            return EventServiceUtil.getEvent(((Long) arguments[0]).longValue());
        }

        if (_methodName33.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
            return EventServiceUtil.updateEvent(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Integer) arguments[4]).intValue(),
                ((Integer) arguments[5]).intValue(),
                ((Integer) arguments[6]).intValue(),
                ((Integer) arguments[7]).intValue(),
                ((Integer) arguments[8]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[9]);
        }

        throw new UnsupportedOperationException();
    }
}
