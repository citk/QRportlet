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

package org.xmlportletfactory.example01.order.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.documentlibrary.service.persistence.DLFolderPersistence;

import org.xmlportletfactory.example01.order.model.kunde;
import org.xmlportletfactory.example01.order.service.kundeService;
import org.xmlportletfactory.example01.order.service.persistence.kundePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the kunde remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.xmlportletfactory.example01.order.service.impl.kundeServiceImpl}.
 * </p>
 *
 * @author Jack A. Rider
 * @see org.xmlportletfactory.example01.order.service.impl.kundeServiceImpl
 * @see org.xmlportletfactory.example01.order.service.kundeServiceUtil
 * @generated
 */
public abstract class kundeServiceBaseImpl extends BaseServiceImpl
	implements kundeService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.xmlportletfactory.example01.order.service.kundeServiceUtil} to access the kunde remote service.
	 */

	/**
	 * Returns the kunde local service.
	 *
	 * @return the kunde local service
	 */
	public org.xmlportletfactory.example01.order.service.kundeLocalService getkundeLocalService() {
		return kundeLocalService;
	}

	/**
	 * Sets the kunde local service.
	 *
	 * @param kundeLocalService the kunde local service
	 */
	public void setkundeLocalService(
		org.xmlportletfactory.example01.order.service.kundeLocalService kundeLocalService) {
		this.kundeLocalService = kundeLocalService;
	}

	/**
	 * Returns the kunde remote service.
	 *
	 * @return the kunde remote service
	 */
	public org.xmlportletfactory.example01.order.service.kundeService getkundeService() {
		return kundeService;
	}

	/**
	 * Sets the kunde remote service.
	 *
	 * @param kundeService the kunde remote service
	 */
	public void setkundeService(
		org.xmlportletfactory.example01.order.service.kundeService kundeService) {
		this.kundeService = kundeService;
	}

	/**
	 * Returns the kunde persistence.
	 *
	 * @return the kunde persistence
	 */
	public kundePersistence getkundePersistence() {
		return kundePersistence;
	}

	/**
	 * Sets the kunde persistence.
	 *
	 * @param kundePersistence the kunde persistence
	 */
	public void setkundePersistence(kundePersistence kundePersistence) {
		this.kundePersistence = kundePersistence;
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
	 * Returns the document library folder local service.
	 *
	 * @return the document library folder local service
	 */
	public com.liferay.portlet.documentlibrary.service.DLFolderLocalService getDLFolderLocalService() {
		return dlFolderLocalService;
	}

	/**
	 * Sets the document library folder local service.
	 *
	 * @param dlFolderLocalService the document library folder local service
	 */
	public void setDLFolderLocalService(
		com.liferay.portlet.documentlibrary.service.DLFolderLocalService dlFolderLocalService) {
		this.dlFolderLocalService = dlFolderLocalService;
	}

	/**
	 * Returns the document library folder remote service.
	 *
	 * @return the document library folder remote service
	 */
	public com.liferay.portlet.documentlibrary.service.DLFolderService getDLFolderService() {
		return dlFolderService;
	}

	/**
	 * Sets the document library folder remote service.
	 *
	 * @param dlFolderService the document library folder remote service
	 */
	public void setDLFolderService(
		com.liferay.portlet.documentlibrary.service.DLFolderService dlFolderService) {
		this.dlFolderService = dlFolderService;
	}

	/**
	 * Returns the document library folder persistence.
	 *
	 * @return the document library folder persistence
	 */
	public DLFolderPersistence getDLFolderPersistence() {
		return dlFolderPersistence;
	}

	/**
	 * Sets the document library folder persistence.
	 *
	 * @param dlFolderPersistence the document library folder persistence
	 */
	public void setDLFolderPersistence(DLFolderPersistence dlFolderPersistence) {
		this.dlFolderPersistence = dlFolderPersistence;
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
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return kunde.class;
	}

	protected String getModelClassName() {
		return kunde.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = kundePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.xmlportletfactory.example01.order.service.kundeLocalService.class)
	protected org.xmlportletfactory.example01.order.service.kundeLocalService kundeLocalService;
	@BeanReference(type = org.xmlportletfactory.example01.order.service.kundeService.class)
	protected org.xmlportletfactory.example01.order.service.kundeService kundeService;
	@BeanReference(type = kundePersistence.class)
	protected kundePersistence kundePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = com.liferay.portlet.documentlibrary.service.DLFolderLocalService.class)
	protected com.liferay.portlet.documentlibrary.service.DLFolderLocalService dlFolderLocalService;
	@BeanReference(type = com.liferay.portlet.documentlibrary.service.DLFolderService.class)
	protected com.liferay.portlet.documentlibrary.service.DLFolderService dlFolderService;
	@BeanReference(type = DLFolderPersistence.class)
	protected DLFolderPersistence dlFolderPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private kundeServiceClpInvoker _clpInvoker = new kundeServiceClpInvoker();
}