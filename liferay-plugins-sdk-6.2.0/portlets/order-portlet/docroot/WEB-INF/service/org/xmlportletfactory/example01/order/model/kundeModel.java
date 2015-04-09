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

package org.xmlportletfactory.example01.order.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the kunde service. Represents a row in the &quot;order_kunde&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.xmlportletfactory.example01.order.model.impl.kundeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.xmlportletfactory.example01.order.model.impl.kundeImpl}.
 * </p>
 *
 * @author Jack A. Rider
 * @see kunde
 * @see org.xmlportletfactory.example01.order.model.impl.kundeImpl
 * @see org.xmlportletfactory.example01.order.model.impl.kundeModelImpl
 * @generated
 */
public interface kundeModel extends BaseModel<kunde>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kunde model instance should use the {@link kunde} interface instead.
	 */

	/**
	 * Returns the primary key of this kunde.
	 *
	 * @return the primary key of this kunde
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kunde.
	 *
	 * @param primaryKey the primary key of this kunde
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the kunde ID of this kunde.
	 *
	 * @return the kunde ID of this kunde
	 */
	public long getKundeId();

	/**
	 * Sets the kunde ID of this kunde.
	 *
	 * @param kundeId the kunde ID of this kunde
	 */
	public void setKundeId(long kundeId);

	/**
	 * Returns the company ID of this kunde.
	 *
	 * @return the company ID of this kunde
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this kunde.
	 *
	 * @param companyId the company ID of this kunde
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this kunde.
	 *
	 * @return the group ID of this kunde
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this kunde.
	 *
	 * @param groupId the group ID of this kunde
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this kunde.
	 *
	 * @return the user ID of this kunde
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this kunde.
	 *
	 * @param userId the user ID of this kunde
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this kunde.
	 *
	 * @return the user uuid of this kunde
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this kunde.
	 *
	 * @param userUuid the user uuid of this kunde
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this kunde.
	 *
	 * @return the user name of this kunde
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this kunde.
	 *
	 * @param userName the user name of this kunde
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this kunde.
	 *
	 * @return the create date of this kunde
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this kunde.
	 *
	 * @param createDate the create date of this kunde
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this kunde.
	 *
	 * @return the modified date of this kunde
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this kunde.
	 *
	 * @param modifiedDate the modified date of this kunde
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the kunde description of this kunde.
	 *
	 * @return the kunde description of this kunde
	 */
	@AutoEscape
	public String getKundeDescription();

	/**
	 * Sets the kunde description of this kunde.
	 *
	 * @param kundeDescription the kunde description of this kunde
	 */
	public void setKundeDescription(String kundeDescription);

	/**
	 * Returns the user kunde of this kunde.
	 *
	 * @return the user kunde of this kunde
	 */
	@AutoEscape
	public String getUserKunde();

	/**
	 * Sets the user kunde of this kunde.
	 *
	 * @param userKunde the user kunde of this kunde
	 */
	public void setUserKunde(String userKunde);

	/**
	 * Returns the user document of this kunde.
	 *
	 * @return the user document of this kunde
	 */
	public long getUserDocument();

	/**
	 * Sets the user document of this kunde.
	 *
	 * @param userDocument the user document of this kunde
	 */
	public void setUserDocument(long userDocument);

	/**
	 * Returns the user city of this kunde.
	 *
	 * @return the user city of this kunde
	 */
	@AutoEscape
	public String getUserCity();

	/**
	 * Sets the user city of this kunde.
	 *
	 * @param userCity the user city of this kunde
	 */
	public void setUserCity(String userCity);

	/**
	 * Returns the user email of this kunde.
	 *
	 * @return the user email of this kunde
	 */
	@AutoEscape
	public String getUserEmail();

	/**
	 * Sets the user email of this kunde.
	 *
	 * @param userEmail the user email of this kunde
	 */
	public void setUserEmail(String userEmail);

	/**
	 * Returns the folder d l ID of this kunde.
	 *
	 * @return the folder d l ID of this kunde
	 */
	public long getFolderDLId();

	/**
	 * Sets the folder d l ID of this kunde.
	 *
	 * @param folderDLId the folder d l ID of this kunde
	 */
	public void setFolderDLId(long folderDLId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(kunde kunde);

	@Override
	public int hashCode();

	@Override
	public CacheModel<kunde> toCacheModel();

	@Override
	public kunde toEscapedModel();

	@Override
	public kunde toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}