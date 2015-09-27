package com.zenixia.plugins.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Room. This utility wraps
 * {@link com.zenixia.plugins.service.impl.RoomServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Guillaume Lenoir
 * @see RoomService
 * @see com.zenixia.plugins.service.base.RoomServiceBaseImpl
 * @see com.zenixia.plugins.service.impl.RoomServiceImpl
 * @generated
 */
public class RoomServiceUtil {
    private static RoomService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.zenixia.plugins.service.impl.RoomServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.zenixia.plugins.model.Room addRoom(
        com.zenixia.plugins.model.Room room,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().addRoom(room, serviceContext);
    }

    public static com.zenixia.plugins.model.Room updateRoom(
        com.zenixia.plugins.model.Room room,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().updateRoom(room, serviceContext);
    }

    public static com.zenixia.plugins.model.Room deleteRoom(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().deleteRoom(roomId);
    }

    public static com.zenixia.plugins.model.Room getRoom(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoom(roomId);
    }

    public static java.util.List<com.zenixia.plugins.model.Room> getRoomByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoomByGroupId(groupId);
    }

    public static java.util.List<com.zenixia.plugins.model.Room> getRoomByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoomByGroupId(groupId, start, end);
    }

    public static int getRoomCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoomCountByGroupId(groupId);
    }

    public static void clearService() {
        _service = null;
    }

    public static RoomService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    RoomService.class.getName());

            if (invokableService instanceof RoomService) {
                _service = (RoomService) invokableService;
            } else {
                _service = new RoomServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(RoomServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(RoomService service) {
    }
}
