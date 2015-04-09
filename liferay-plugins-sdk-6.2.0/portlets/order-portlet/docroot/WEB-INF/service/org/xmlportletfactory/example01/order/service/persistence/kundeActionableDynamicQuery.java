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

package org.xmlportletfactory.example01.order.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.xmlportletfactory.example01.order.model.kunde;
import org.xmlportletfactory.example01.order.service.kundeLocalServiceUtil;

/**
 * @author Jack A. Rider
 * @generated
 */
public abstract class kundeActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public kundeActionableDynamicQuery() throws SystemException {
		setBaseLocalService(kundeLocalServiceUtil.getService());
		setClass(kunde.class);

		setClassLoader(org.xmlportletfactory.example01.order.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("kundeId");
	}
}