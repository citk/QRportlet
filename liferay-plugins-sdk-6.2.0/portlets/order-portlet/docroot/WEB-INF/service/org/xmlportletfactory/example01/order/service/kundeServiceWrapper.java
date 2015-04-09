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
 * Provides a wrapper for {@link kundeService}.
 *
 * @author Jack A. Rider
 * @see kundeService
 * @generated
 */
public class kundeServiceWrapper implements kundeService,
	ServiceWrapper<kundeService> {
	public kundeServiceWrapper(kundeService kundeService) {
		_kundeService = kundeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _kundeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_kundeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _kundeService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void helloWorld() {
		_kundeService.helloWorld();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public kundeService getWrappedkundeService() {
		return _kundeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedkundeService(kundeService kundeService) {
		_kundeService = kundeService;
	}

	@Override
	public kundeService getWrappedService() {
		return _kundeService;
	}

	@Override
	public void setWrappedService(kundeService kundeService) {
		_kundeService = kundeService;
	}

	private kundeService _kundeService;
}