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

package org.xmlportletfactory.tnsoft.qrperson.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.xmlportletfactory.tnsoft.qrperson.service.base.personServiceBaseImpl;

/**
 * The implementation of the person remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.xmlportletfactory.tnsoft.qrperson.service.personService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jack A. Rider
 * @see org.xmlportletfactory.tnsoft.qrperson.service.base.personServiceBaseImpl
 * @see org.xmlportletfactory.tnsoft.qrperson.service.personServiceUtil
 */
public class personServiceImpl extends personServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.xmlportletfactory.tnsoft.qrperson.service.personServiceUtil} to access the person remote service.
	 */
    private static final Log LOG = LogFactoryUtil.getLog(personServiceImpl.class);
    public void helloWorld(){
        LOG.info("lOGGER");
    }
}