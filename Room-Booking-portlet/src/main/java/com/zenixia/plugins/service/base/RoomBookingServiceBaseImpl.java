package com.zenixia.plugins.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.SubscriptionPersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetLinkPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence;
import com.liferay.portlet.ratings.service.persistence.RatingsStatsPersistence;
import com.liferay.portlet.social.service.persistence.SocialActivityCounterPersistence;
import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;
import com.liferay.portlet.trash.service.persistence.TrashEntryPersistence;

import com.zenixia.plugins.model.RoomBooking;
import com.zenixia.plugins.service.RoomBookingService;
import com.zenixia.plugins.service.persistence.EquipmentPersistence;
import com.zenixia.plugins.service.persistence.EquipmentTypePersistence;
import com.zenixia.plugins.service.persistence.RoomBookingPersistence;
import com.zenixia.plugins.service.persistence.RoomPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the room booking remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.zenixia.plugins.service.impl.RoomBookingServiceImpl}.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see com.zenixia.plugins.service.impl.RoomBookingServiceImpl
 * @see com.zenixia.plugins.service.RoomBookingServiceUtil
 * @generated
 */
public abstract class RoomBookingServiceBaseImpl extends BaseServiceImpl
    implements RoomBookingService, IdentifiableBean {
    @BeanReference(type = com.zenixia.plugins.service.EquipmentLocalService.class)
    protected com.zenixia.plugins.service.EquipmentLocalService equipmentLocalService;
    @BeanReference(type = com.zenixia.plugins.service.EquipmentService.class)
    protected com.zenixia.plugins.service.EquipmentService equipmentService;
    @BeanReference(type = EquipmentPersistence.class)
    protected EquipmentPersistence equipmentPersistence;
    @BeanReference(type = com.zenixia.plugins.service.EquipmentTypeLocalService.class)
    protected com.zenixia.plugins.service.EquipmentTypeLocalService equipmentTypeLocalService;
    @BeanReference(type = com.zenixia.plugins.service.EquipmentTypeService.class)
    protected com.zenixia.plugins.service.EquipmentTypeService equipmentTypeService;
    @BeanReference(type = EquipmentTypePersistence.class)
    protected EquipmentTypePersistence equipmentTypePersistence;
    @BeanReference(type = com.zenixia.plugins.service.RoomLocalService.class)
    protected com.zenixia.plugins.service.RoomLocalService roomLocalService;
    @BeanReference(type = com.zenixia.plugins.service.RoomService.class)
    protected com.zenixia.plugins.service.RoomService roomService;
    @BeanReference(type = RoomPersistence.class)
    protected RoomPersistence roomPersistence;
    @BeanReference(type = com.zenixia.plugins.service.RoomBookingLocalService.class)
    protected com.zenixia.plugins.service.RoomBookingLocalService roomBookingLocalService;
    @BeanReference(type = com.zenixia.plugins.service.RoomBookingService.class)
    protected com.zenixia.plugins.service.RoomBookingService roomBookingService;
    @BeanReference(type = RoomBookingPersistence.class)
    protected RoomBookingPersistence roomBookingPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.mail.service.MailService.class)
    protected com.liferay.mail.service.MailService mailService;
    @BeanReference(type = com.liferay.portal.service.CompanyLocalService.class)
    protected com.liferay.portal.service.CompanyLocalService companyLocalService;
    @BeanReference(type = com.liferay.portal.service.CompanyService.class)
    protected com.liferay.portal.service.CompanyService companyService;
    @BeanReference(type = CompanyPersistence.class)
    protected CompanyPersistence companyPersistence;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.SubscriptionLocalService.class)
    protected com.liferay.portal.service.SubscriptionLocalService subscriptionLocalService;
    @BeanReference(type = SubscriptionPersistence.class)
    protected SubscriptionPersistence subscriptionPersistence;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetEntryLocalService.class)
    protected com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetEntryService.class)
    protected com.liferay.portlet.asset.service.AssetEntryService assetEntryService;
    @BeanReference(type = AssetEntryPersistence.class)
    protected AssetEntryPersistence assetEntryPersistence;
    @BeanReference(type = com.liferay.portlet.asset.service.AssetLinkLocalService.class)
    protected com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService;
    @BeanReference(type = AssetLinkPersistence.class)
    protected AssetLinkPersistence assetLinkPersistence;
    @BeanReference(type = com.liferay.portlet.messageboards.service.MBMessageLocalService.class)
    protected com.liferay.portlet.messageboards.service.MBMessageLocalService mbMessageLocalService;
    @BeanReference(type = com.liferay.portlet.messageboards.service.MBMessageService.class)
    protected com.liferay.portlet.messageboards.service.MBMessageService mbMessageService;
    @BeanReference(type = MBMessagePersistence.class)
    protected MBMessagePersistence mbMessagePersistence;
    @BeanReference(type = com.liferay.portlet.ratings.service.RatingsStatsLocalService.class)
    protected com.liferay.portlet.ratings.service.RatingsStatsLocalService ratingsStatsLocalService;
    @BeanReference(type = RatingsStatsPersistence.class)
    protected RatingsStatsPersistence ratingsStatsPersistence;
    @BeanReference(type = com.liferay.portlet.social.service.SocialActivityLocalService.class)
    protected com.liferay.portlet.social.service.SocialActivityLocalService socialActivityLocalService;
    @BeanReference(type = com.liferay.portlet.social.service.SocialActivityService.class)
    protected com.liferay.portlet.social.service.SocialActivityService socialActivityService;
    @BeanReference(type = SocialActivityPersistence.class)
    protected SocialActivityPersistence socialActivityPersistence;
    @BeanReference(type = com.liferay.portlet.social.service.SocialActivityCounterLocalService.class)
    protected com.liferay.portlet.social.service.SocialActivityCounterLocalService socialActivityCounterLocalService;
    @BeanReference(type = SocialActivityCounterPersistence.class)
    protected SocialActivityCounterPersistence socialActivityCounterPersistence;
    @BeanReference(type = com.liferay.portlet.trash.service.TrashEntryLocalService.class)
    protected com.liferay.portlet.trash.service.TrashEntryLocalService trashEntryLocalService;
    @BeanReference(type = com.liferay.portlet.trash.service.TrashEntryService.class)
    protected com.liferay.portlet.trash.service.TrashEntryService trashEntryService;
    @BeanReference(type = TrashEntryPersistence.class)
    protected TrashEntryPersistence trashEntryPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private RoomBookingServiceClpInvoker _clpInvoker = new RoomBookingServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.zenixia.plugins.service.RoomBookingServiceUtil} to access the room booking remote service.
     */

    /**
     * Returns the equipment local service.
     *
     * @return the equipment local service
     */
    public com.zenixia.plugins.service.EquipmentLocalService getEquipmentLocalService() {
        return equipmentLocalService;
    }

    /**
     * Sets the equipment local service.
     *
     * @param equipmentLocalService the equipment local service
     */
    public void setEquipmentLocalService(
        com.zenixia.plugins.service.EquipmentLocalService equipmentLocalService) {
        this.equipmentLocalService = equipmentLocalService;
    }

    /**
     * Returns the equipment remote service.
     *
     * @return the equipment remote service
     */
    public com.zenixia.plugins.service.EquipmentService getEquipmentService() {
        return equipmentService;
    }

    /**
     * Sets the equipment remote service.
     *
     * @param equipmentService the equipment remote service
     */
    public void setEquipmentService(
        com.zenixia.plugins.service.EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    /**
     * Returns the equipment persistence.
     *
     * @return the equipment persistence
     */
    public EquipmentPersistence getEquipmentPersistence() {
        return equipmentPersistence;
    }

    /**
     * Sets the equipment persistence.
     *
     * @param equipmentPersistence the equipment persistence
     */
    public void setEquipmentPersistence(
        EquipmentPersistence equipmentPersistence) {
        this.equipmentPersistence = equipmentPersistence;
    }

    /**
     * Returns the equipment type local service.
     *
     * @return the equipment type local service
     */
    public com.zenixia.plugins.service.EquipmentTypeLocalService getEquipmentTypeLocalService() {
        return equipmentTypeLocalService;
    }

    /**
     * Sets the equipment type local service.
     *
     * @param equipmentTypeLocalService the equipment type local service
     */
    public void setEquipmentTypeLocalService(
        com.zenixia.plugins.service.EquipmentTypeLocalService equipmentTypeLocalService) {
        this.equipmentTypeLocalService = equipmentTypeLocalService;
    }

    /**
     * Returns the equipment type remote service.
     *
     * @return the equipment type remote service
     */
    public com.zenixia.plugins.service.EquipmentTypeService getEquipmentTypeService() {
        return equipmentTypeService;
    }

    /**
     * Sets the equipment type remote service.
     *
     * @param equipmentTypeService the equipment type remote service
     */
    public void setEquipmentTypeService(
        com.zenixia.plugins.service.EquipmentTypeService equipmentTypeService) {
        this.equipmentTypeService = equipmentTypeService;
    }

    /**
     * Returns the equipment type persistence.
     *
     * @return the equipment type persistence
     */
    public EquipmentTypePersistence getEquipmentTypePersistence() {
        return equipmentTypePersistence;
    }

    /**
     * Sets the equipment type persistence.
     *
     * @param equipmentTypePersistence the equipment type persistence
     */
    public void setEquipmentTypePersistence(
        EquipmentTypePersistence equipmentTypePersistence) {
        this.equipmentTypePersistence = equipmentTypePersistence;
    }

    /**
     * Returns the room local service.
     *
     * @return the room local service
     */
    public com.zenixia.plugins.service.RoomLocalService getRoomLocalService() {
        return roomLocalService;
    }

    /**
     * Sets the room local service.
     *
     * @param roomLocalService the room local service
     */
    public void setRoomLocalService(
        com.zenixia.plugins.service.RoomLocalService roomLocalService) {
        this.roomLocalService = roomLocalService;
    }

    /**
     * Returns the room remote service.
     *
     * @return the room remote service
     */
    public com.zenixia.plugins.service.RoomService getRoomService() {
        return roomService;
    }

    /**
     * Sets the room remote service.
     *
     * @param roomService the room remote service
     */
    public void setRoomService(
        com.zenixia.plugins.service.RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * Returns the room persistence.
     *
     * @return the room persistence
     */
    public RoomPersistence getRoomPersistence() {
        return roomPersistence;
    }

    /**
     * Sets the room persistence.
     *
     * @param roomPersistence the room persistence
     */
    public void setRoomPersistence(RoomPersistence roomPersistence) {
        this.roomPersistence = roomPersistence;
    }

    /**
     * Returns the room booking local service.
     *
     * @return the room booking local service
     */
    public com.zenixia.plugins.service.RoomBookingLocalService getRoomBookingLocalService() {
        return roomBookingLocalService;
    }

    /**
     * Sets the room booking local service.
     *
     * @param roomBookingLocalService the room booking local service
     */
    public void setRoomBookingLocalService(
        com.zenixia.plugins.service.RoomBookingLocalService roomBookingLocalService) {
        this.roomBookingLocalService = roomBookingLocalService;
    }

    /**
     * Returns the room booking remote service.
     *
     * @return the room booking remote service
     */
    public com.zenixia.plugins.service.RoomBookingService getRoomBookingService() {
        return roomBookingService;
    }

    /**
     * Sets the room booking remote service.
     *
     * @param roomBookingService the room booking remote service
     */
    public void setRoomBookingService(
        com.zenixia.plugins.service.RoomBookingService roomBookingService) {
        this.roomBookingService = roomBookingService;
    }

    /**
     * Returns the room booking persistence.
     *
     * @return the room booking persistence
     */
    public RoomBookingPersistence getRoomBookingPersistence() {
        return roomBookingPersistence;
    }

    /**
     * Sets the room booking persistence.
     *
     * @param roomBookingPersistence the room booking persistence
     */
    public void setRoomBookingPersistence(
        RoomBookingPersistence roomBookingPersistence) {
        this.roomBookingPersistence = roomBookingPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the mail remote service.
     *
     * @return the mail remote service
     */
    public com.liferay.mail.service.MailService getMailService() {
        return mailService;
    }

    /**
     * Sets the mail remote service.
     *
     * @param mailService the mail remote service
     */
    public void setMailService(com.liferay.mail.service.MailService mailService) {
        this.mailService = mailService;
    }

    /**
     * Returns the company local service.
     *
     * @return the company local service
     */
    public com.liferay.portal.service.CompanyLocalService getCompanyLocalService() {
        return companyLocalService;
    }

    /**
     * Sets the company local service.
     *
     * @param companyLocalService the company local service
     */
    public void setCompanyLocalService(
        com.liferay.portal.service.CompanyLocalService companyLocalService) {
        this.companyLocalService = companyLocalService;
    }

    /**
     * Returns the company remote service.
     *
     * @return the company remote service
     */
    public com.liferay.portal.service.CompanyService getCompanyService() {
        return companyService;
    }

    /**
     * Sets the company remote service.
     *
     * @param companyService the company remote service
     */
    public void setCompanyService(
        com.liferay.portal.service.CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * Returns the company persistence.
     *
     * @return the company persistence
     */
    public CompanyPersistence getCompanyPersistence() {
        return companyPersistence;
    }

    /**
     * Sets the company persistence.
     *
     * @param companyPersistence the company persistence
     */
    public void setCompanyPersistence(CompanyPersistence companyPersistence) {
        this.companyPersistence = companyPersistence;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the subscription local service.
     *
     * @return the subscription local service
     */
    public com.liferay.portal.service.SubscriptionLocalService getSubscriptionLocalService() {
        return subscriptionLocalService;
    }

    /**
     * Sets the subscription local service.
     *
     * @param subscriptionLocalService the subscription local service
     */
    public void setSubscriptionLocalService(
        com.liferay.portal.service.SubscriptionLocalService subscriptionLocalService) {
        this.subscriptionLocalService = subscriptionLocalService;
    }

    /**
     * Returns the subscription persistence.
     *
     * @return the subscription persistence
     */
    public SubscriptionPersistence getSubscriptionPersistence() {
        return subscriptionPersistence;
    }

    /**
     * Sets the subscription persistence.
     *
     * @param subscriptionPersistence the subscription persistence
     */
    public void setSubscriptionPersistence(
        SubscriptionPersistence subscriptionPersistence) {
        this.subscriptionPersistence = subscriptionPersistence;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    /**
     * Returns the asset entry local service.
     *
     * @return the asset entry local service
     */
    public com.liferay.portlet.asset.service.AssetEntryLocalService getAssetEntryLocalService() {
        return assetEntryLocalService;
    }

    /**
     * Sets the asset entry local service.
     *
     * @param assetEntryLocalService the asset entry local service
     */
    public void setAssetEntryLocalService(
        com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService) {
        this.assetEntryLocalService = assetEntryLocalService;
    }

    /**
     * Returns the asset entry remote service.
     *
     * @return the asset entry remote service
     */
    public com.liferay.portlet.asset.service.AssetEntryService getAssetEntryService() {
        return assetEntryService;
    }

    /**
     * Sets the asset entry remote service.
     *
     * @param assetEntryService the asset entry remote service
     */
    public void setAssetEntryService(
        com.liferay.portlet.asset.service.AssetEntryService assetEntryService) {
        this.assetEntryService = assetEntryService;
    }

    /**
     * Returns the asset entry persistence.
     *
     * @return the asset entry persistence
     */
    public AssetEntryPersistence getAssetEntryPersistence() {
        return assetEntryPersistence;
    }

    /**
     * Sets the asset entry persistence.
     *
     * @param assetEntryPersistence the asset entry persistence
     */
    public void setAssetEntryPersistence(
        AssetEntryPersistence assetEntryPersistence) {
        this.assetEntryPersistence = assetEntryPersistence;
    }

    /**
     * Returns the asset link local service.
     *
     * @return the asset link local service
     */
    public com.liferay.portlet.asset.service.AssetLinkLocalService getAssetLinkLocalService() {
        return assetLinkLocalService;
    }

    /**
     * Sets the asset link local service.
     *
     * @param assetLinkLocalService the asset link local service
     */
    public void setAssetLinkLocalService(
        com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService) {
        this.assetLinkLocalService = assetLinkLocalService;
    }

    /**
     * Returns the asset link persistence.
     *
     * @return the asset link persistence
     */
    public AssetLinkPersistence getAssetLinkPersistence() {
        return assetLinkPersistence;
    }

    /**
     * Sets the asset link persistence.
     *
     * @param assetLinkPersistence the asset link persistence
     */
    public void setAssetLinkPersistence(
        AssetLinkPersistence assetLinkPersistence) {
        this.assetLinkPersistence = assetLinkPersistence;
    }

    /**
     * Returns the message-boards message local service.
     *
     * @return the message-boards message local service
     */
    public com.liferay.portlet.messageboards.service.MBMessageLocalService getMBMessageLocalService() {
        return mbMessageLocalService;
    }

    /**
     * Sets the message-boards message local service.
     *
     * @param mbMessageLocalService the message-boards message local service
     */
    public void setMBMessageLocalService(
        com.liferay.portlet.messageboards.service.MBMessageLocalService mbMessageLocalService) {
        this.mbMessageLocalService = mbMessageLocalService;
    }

    /**
     * Returns the message-boards message remote service.
     *
     * @return the message-boards message remote service
     */
    public com.liferay.portlet.messageboards.service.MBMessageService getMBMessageService() {
        return mbMessageService;
    }

    /**
     * Sets the message-boards message remote service.
     *
     * @param mbMessageService the message-boards message remote service
     */
    public void setMBMessageService(
        com.liferay.portlet.messageboards.service.MBMessageService mbMessageService) {
        this.mbMessageService = mbMessageService;
    }

    /**
     * Returns the message-boards message persistence.
     *
     * @return the message-boards message persistence
     */
    public MBMessagePersistence getMBMessagePersistence() {
        return mbMessagePersistence;
    }

    /**
     * Sets the message-boards message persistence.
     *
     * @param mbMessagePersistence the message-boards message persistence
     */
    public void setMBMessagePersistence(
        MBMessagePersistence mbMessagePersistence) {
        this.mbMessagePersistence = mbMessagePersistence;
    }

    /**
     * Returns the ratings stats local service.
     *
     * @return the ratings stats local service
     */
    public com.liferay.portlet.ratings.service.RatingsStatsLocalService getRatingsStatsLocalService() {
        return ratingsStatsLocalService;
    }

    /**
     * Sets the ratings stats local service.
     *
     * @param ratingsStatsLocalService the ratings stats local service
     */
    public void setRatingsStatsLocalService(
        com.liferay.portlet.ratings.service.RatingsStatsLocalService ratingsStatsLocalService) {
        this.ratingsStatsLocalService = ratingsStatsLocalService;
    }

    /**
     * Returns the ratings stats persistence.
     *
     * @return the ratings stats persistence
     */
    public RatingsStatsPersistence getRatingsStatsPersistence() {
        return ratingsStatsPersistence;
    }

    /**
     * Sets the ratings stats persistence.
     *
     * @param ratingsStatsPersistence the ratings stats persistence
     */
    public void setRatingsStatsPersistence(
        RatingsStatsPersistence ratingsStatsPersistence) {
        this.ratingsStatsPersistence = ratingsStatsPersistence;
    }

    /**
     * Returns the social activity local service.
     *
     * @return the social activity local service
     */
    public com.liferay.portlet.social.service.SocialActivityLocalService getSocialActivityLocalService() {
        return socialActivityLocalService;
    }

    /**
     * Sets the social activity local service.
     *
     * @param socialActivityLocalService the social activity local service
     */
    public void setSocialActivityLocalService(
        com.liferay.portlet.social.service.SocialActivityLocalService socialActivityLocalService) {
        this.socialActivityLocalService = socialActivityLocalService;
    }

    /**
     * Returns the social activity remote service.
     *
     * @return the social activity remote service
     */
    public com.liferay.portlet.social.service.SocialActivityService getSocialActivityService() {
        return socialActivityService;
    }

    /**
     * Sets the social activity remote service.
     *
     * @param socialActivityService the social activity remote service
     */
    public void setSocialActivityService(
        com.liferay.portlet.social.service.SocialActivityService socialActivityService) {
        this.socialActivityService = socialActivityService;
    }

    /**
     * Returns the social activity persistence.
     *
     * @return the social activity persistence
     */
    public SocialActivityPersistence getSocialActivityPersistence() {
        return socialActivityPersistence;
    }

    /**
     * Sets the social activity persistence.
     *
     * @param socialActivityPersistence the social activity persistence
     */
    public void setSocialActivityPersistence(
        SocialActivityPersistence socialActivityPersistence) {
        this.socialActivityPersistence = socialActivityPersistence;
    }

    /**
     * Returns the social activity counter local service.
     *
     * @return the social activity counter local service
     */
    public com.liferay.portlet.social.service.SocialActivityCounterLocalService getSocialActivityCounterLocalService() {
        return socialActivityCounterLocalService;
    }

    /**
     * Sets the social activity counter local service.
     *
     * @param socialActivityCounterLocalService the social activity counter local service
     */
    public void setSocialActivityCounterLocalService(
        com.liferay.portlet.social.service.SocialActivityCounterLocalService socialActivityCounterLocalService) {
        this.socialActivityCounterLocalService = socialActivityCounterLocalService;
    }

    /**
     * Returns the social activity counter persistence.
     *
     * @return the social activity counter persistence
     */
    public SocialActivityCounterPersistence getSocialActivityCounterPersistence() {
        return socialActivityCounterPersistence;
    }

    /**
     * Sets the social activity counter persistence.
     *
     * @param socialActivityCounterPersistence the social activity counter persistence
     */
    public void setSocialActivityCounterPersistence(
        SocialActivityCounterPersistence socialActivityCounterPersistence) {
        this.socialActivityCounterPersistence = socialActivityCounterPersistence;
    }

    /**
     * Returns the trash entry local service.
     *
     * @return the trash entry local service
     */
    public com.liferay.portlet.trash.service.TrashEntryLocalService getTrashEntryLocalService() {
        return trashEntryLocalService;
    }

    /**
     * Sets the trash entry local service.
     *
     * @param trashEntryLocalService the trash entry local service
     */
    public void setTrashEntryLocalService(
        com.liferay.portlet.trash.service.TrashEntryLocalService trashEntryLocalService) {
        this.trashEntryLocalService = trashEntryLocalService;
    }

    /**
     * Returns the trash entry remote service.
     *
     * @return the trash entry remote service
     */
    public com.liferay.portlet.trash.service.TrashEntryService getTrashEntryService() {
        return trashEntryService;
    }

    /**
     * Sets the trash entry remote service.
     *
     * @param trashEntryService the trash entry remote service
     */
    public void setTrashEntryService(
        com.liferay.portlet.trash.service.TrashEntryService trashEntryService) {
        this.trashEntryService = trashEntryService;
    }

    /**
     * Returns the trash entry persistence.
     *
     * @return the trash entry persistence
     */
    public TrashEntryPersistence getTrashEntryPersistence() {
        return trashEntryPersistence;
    }

    /**
     * Sets the trash entry persistence.
     *
     * @param trashEntryPersistence the trash entry persistence
     */
    public void setTrashEntryPersistence(
        TrashEntryPersistence trashEntryPersistence) {
        this.trashEntryPersistence = trashEntryPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return RoomBooking.class;
    }

    protected String getModelClassName() {
        return RoomBooking.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = roomBookingPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
