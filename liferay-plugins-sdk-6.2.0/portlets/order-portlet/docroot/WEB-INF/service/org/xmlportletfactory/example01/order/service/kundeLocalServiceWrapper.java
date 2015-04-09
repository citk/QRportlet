/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.xmlportletfactory.example01.order.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link kundeLocalService}.
 *
 * @author Jack A. Rider
 * @see kundeLocalService
 * @generated
 */
public class kundeLocalServiceWrapper implements kundeLocalService,
	ServiceWrapper<kundeLocalService> {
	public kundeLocalServiceWrapper(kundeLocalService kundeLocalService) {
		_kundeLocalService = kundeLocalService;
	}

	/**
	* Adds the kunde to the database. Also notifies the appropriate model listeners.
	*
	* @param kunde the kunde
	* @return the kunde that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.xmlportletfactory.example01.order.model.kunde addkunde(
		org.xmlportletfactory.example01.order.model.kunde kunde)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.addkunde(kunde);
	}

	/**
	* Creates a new kunde with the primary key. Does not add the kunde to the database.
	*
	* @param kundeId the primary key for the new kunde
	* @return the new kunde
	*/
	@Override
	public org.xmlportletfactory.example01.order.model.kunde createkunde(
		long kundeId) {
		return _kundeLocalService.createkunde(kundeId);
	}

	/**
	* Deletes the kunde with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kundeId the primary key of the kunde
	* @return the kunde that was removed
	* @throws PortalException if a kunde with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.xmlportletfactory.example01.order.model.kunde deletekunde(
		long kundeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.deletekunde(kundeId);
	}

	/**
	* Deletes the kunde from the database. Also notifies the appropriate model listeners.
	*
	* @param kunde the kunde
	* @return the kunde that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.xmlportletfactory.example01.order.model.kunde deletekunde(
		org.xmlportletfactory.example01.order.model.kunde kunde)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.deletekunde(kunde);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _kundeLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.xmlportletfactory.example01.order.model.kunde fetchkunde(
		long kundeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.fetchkunde(kundeId);
	}

	/**
	* Returns the kunde with the primary key.
	*
	* @param kundeId the primary key of the kunde
	* @return the kunde
	* @throws PortalException if a kunde with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.xmlportletfactory.example01.order.model.kunde getkunde(
		long kundeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.getkunde(kundeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the kundes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kundes
	* @param end the upper bound of the range of kundes (not inclusive)
	* @return the range of kundes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> getkundes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.getkundes(start, end);
	}

	/**
	* Returns the number of kundes.
	*
	* @return the number of kundes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getkundesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.getkundesCount();
	}

	/**
	* Updates the kunde in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kunde the kunde
	* @return the kunde that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.xmlportletfactory.example01.order.model.kunde updatekunde(
		org.xmlportletfactory.example01.order.model.kunde kunde)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.updatekunde(kunde);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _kundeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_kundeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _kundeLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> getCompanyEntries(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.getCompanyEntries(companyId, start, end, obc);
	}

	@Override
	public java.util.List<org.xmlportletfactory.example01.order.model.kunde> getCompanyEntries(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.getCompanyEntries(companyId, start, end);
	}

	@Override
	public int getCompanyEntriesCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.getCompanyEntriesCount(companyId);
	}

	@Override
	public java.util.List findAllInUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.findAllInUser(userId);
	}

	@Override
	public int countAllInUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.countAllInUser(userId);
	}

	@Override
	public java.util.List findAllInUser(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.findAllInUser(userId, orderByComparator);
	}

	@Override
	public java.util.List findAllInUser(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.findAllInUser(userId, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List findAllInGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.findAllInGroup(groupId);
	}

	@Override
	public int countAllInGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.countAllInGroup(groupId);
	}

	@Override
	public java.util.List findAllInGroup(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.findAllInGroup(groupId, orderByComparator);
	}

	@Override
	public java.util.List findAllInGroup(long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.findAllInGroup(groupId, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List findAllInUserAndGroup(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.findAllInUserAndGroup(userId, groupId);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.countAllInUserAndGroup(userId, groupId);
	}

	@Override
	public java.util.List findAllInUserAndGroup(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.findAllInUserAndGroup(userId, groupId,
			orderByComparator);
	}

	@Override
	public java.util.List findAllInUserAndGroup(long userId, long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.findAllInUserAndGroup(userId, groupId, start,
			end, orderByComparator);
	}

	@Override
	public org.xmlportletfactory.example01.order.model.kunde addkunde(
		org.xmlportletfactory.example01.order.model.kunde validkunde,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.addkunde(validkunde, serviceContext);
	}

	@Override
	public org.xmlportletfactory.example01.order.model.kunde updatekunde(
		org.xmlportletfactory.example01.order.model.kunde validkunde,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kundeLocalService.updatekunde(validkunde, serviceContext);
	}

	@Override
	public void deletekundeEntry(
		org.xmlportletfactory.example01.order.model.kunde fileobj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_kundeLocalService.deletekundeEntry(fileobj);
	}

	@Override
	public void addEntryResources(
		org.xmlportletfactory.example01.order.model.kunde entry,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_kundeLocalService.addEntryResources(entry, addGroupPermissions,
			addGuestPermissions);
	}

	@Override
	public void addEntryResources(
		org.xmlportletfactory.example01.order.model.kunde entry,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_kundeLocalService.addEntryResources(entry, groupPermissions,
			guestPermissions);
	}

	@Override
	public void addEntryResources(long entryId, boolean addGroupPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_kundeLocalService.addEntryResources(entryId, addGroupPermissions,
			addGuestPermissions);
	}

	@Override
	public void addEntryResources(long entryId,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_kundeLocalService.addEntryResources(entryId, groupPermissions,
			guestPermissions);
	}

	@Override
	public void updateEntryResources(
		org.xmlportletfactory.example01.order.model.kunde entry,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_kundeLocalService.updateEntryResources(entry, groupPermissions,
			guestPermissions);
	}

	@Override
	public void helloWorld() {
		_kundeLocalService.helloWorld();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public kundeLocalService getWrappedkundeLocalService() {
		return _kundeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedkundeLocalService(kundeLocalService kundeLocalService) {
		_kundeLocalService = kundeLocalService;
	}

	@Override
	public kundeLocalService getWrappedService() {
		return _kundeLocalService;
	}

	@Override
	public void setWrappedService(kundeLocalService kundeLocalService) {
		_kundeLocalService = kundeLocalService;
	}

	private kundeLocalService _kundeLocalService;
}