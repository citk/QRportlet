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

package org.xmlportletfactory.tnsoft.qrperson.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link personService}.
 *
 * @author Jack A. Rider
 * @see personService
 * @generated
 */
public class personServiceWrapper implements personService,
	ServiceWrapper<personService> {
	public personServiceWrapper(personService personService) {
		_personService = personService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _personService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_personService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _personService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void helloWorld() {
		_personService.helloWorld();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public personService getWrappedpersonService() {
		return _personService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedpersonService(personService personService) {
		_personService = personService;
	}

	@Override
	public personService getWrappedService() {
		return _personService;
	}

	@Override
	public void setWrappedService(personService personService) {
		_personService = personService;
	}

	private personService _personService;
}