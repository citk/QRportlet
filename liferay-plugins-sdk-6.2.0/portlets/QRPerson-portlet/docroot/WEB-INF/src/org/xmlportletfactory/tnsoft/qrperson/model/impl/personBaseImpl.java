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

package org.xmlportletfactory.tnsoft.qrperson.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import org.xmlportletfactory.tnsoft.qrperson.model.person;
import org.xmlportletfactory.tnsoft.qrperson.service.personLocalServiceUtil;

/**
 * The extended model base implementation for the person service. Represents a row in the &quot;qrperson_person&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link personImpl}.
 * </p>
 *
 * @author Jack A. Rider
 * @see personImpl
 * @see org.xmlportletfactory.tnsoft.qrperson.model.person
 * @generated
 */
public abstract class personBaseImpl extends personModelImpl implements person {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a person model instance should use the {@link person} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			personLocalServiceUtil.addperson(this);
		}
		else {
			personLocalServiceUtil.updateperson(this);
		}
	}
}