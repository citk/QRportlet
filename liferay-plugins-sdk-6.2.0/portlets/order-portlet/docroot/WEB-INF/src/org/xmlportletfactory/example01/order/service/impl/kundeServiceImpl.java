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

package org.xmlportletfactory.example01.order.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.xmlportletfactory.example01.order.service.base.kundeServiceBaseImpl;

/**
 * The implementation of the kunde remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.xmlportletfactory.example01.order.service.kundeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jack A. Rider
 * @see org.xmlportletfactory.example01.order.service.base.kundeServiceBaseImpl
 * @see org.xmlportletfactory.example01.order.service.kundeServiceUtil
 */
public class kundeServiceImpl extends kundeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.xmlportletfactory.example01.order.service.kundeServiceUtil} to access the kunde remote service.
	 */

    private static final Log LOG = LogFactoryUtil.getLog(kundeServiceImpl.class);
    public void helloWorld(){
        LOG.info("lOGGER");
    }
}