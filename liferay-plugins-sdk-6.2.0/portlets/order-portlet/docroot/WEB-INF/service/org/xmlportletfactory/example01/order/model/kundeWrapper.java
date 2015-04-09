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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link kunde}.
 * </p>
 *
 * @author Jack A. Rider
 * @see kunde
 * @generated
 */
public class kundeWrapper implements kunde, ModelWrapper<kunde> {
	public kundeWrapper(kunde kunde) {
		_kunde = kunde;
	}

	@Override
	public Class<?> getModelClass() {
		return kunde.class;
	}

	@Override
	public String getModelClassName() {
		return kunde.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kundeId", getKundeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("kundeDescription", getKundeDescription());
		attributes.put("userKunde", getUserKunde());
		attributes.put("userDocument", getUserDocument());
		attributes.put("userCity", getUserCity());
		attributes.put("userEmail", getUserEmail());
		attributes.put("folderDLId", getFolderDLId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long kundeId = (Long)attributes.get("kundeId");

		if (kundeId != null) {
			setKundeId(kundeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String kundeDescription = (String)attributes.get("kundeDescription");

		if (kundeDescription != null) {
			setKundeDescription(kundeDescription);
		}

		String userKunde = (String)attributes.get("userKunde");

		if (userKunde != null) {
			setUserKunde(userKunde);
		}

		Long userDocument = (Long)attributes.get("userDocument");

		if (userDocument != null) {
			setUserDocument(userDocument);
		}

		String userCity = (String)attributes.get("userCity");

		if (userCity != null) {
			setUserCity(userCity);
		}

		String userEmail = (String)attributes.get("userEmail");

		if (userEmail != null) {
			setUserEmail(userEmail);
		}

		Long folderDLId = (Long)attributes.get("folderDLId");

		if (folderDLId != null) {
			setFolderDLId(folderDLId);
		}
	}

	/**
	* Returns the primary key of this kunde.
	*
	* @return the primary key of this kunde
	*/
	@Override
	public long getPrimaryKey() {
		return _kunde.getPrimaryKey();
	}

	/**
	* Sets the primary key of this kunde.
	*
	* @param primaryKey the primary key of this kunde
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kunde.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the kunde ID of this kunde.
	*
	* @return the kunde ID of this kunde
	*/
	@Override
	public long getKundeId() {
		return _kunde.getKundeId();
	}

	/**
	* Sets the kunde ID of this kunde.
	*
	* @param kundeId the kunde ID of this kunde
	*/
	@Override
	public void setKundeId(long kundeId) {
		_kunde.setKundeId(kundeId);
	}

	/**
	* Returns the company ID of this kunde.
	*
	* @return the company ID of this kunde
	*/
	@Override
	public long getCompanyId() {
		return _kunde.getCompanyId();
	}

	/**
	* Sets the company ID of this kunde.
	*
	* @param companyId the company ID of this kunde
	*/
	@Override
	public void setCompanyId(long companyId) {
		_kunde.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this kunde.
	*
	* @return the group ID of this kunde
	*/
	@Override
	public long getGroupId() {
		return _kunde.getGroupId();
	}

	/**
	* Sets the group ID of this kunde.
	*
	* @param groupId the group ID of this kunde
	*/
	@Override
	public void setGroupId(long groupId) {
		_kunde.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this kunde.
	*
	* @return the user ID of this kunde
	*/
	@Override
	public long getUserId() {
		return _kunde.getUserId();
	}

	/**
	* Sets the user ID of this kunde.
	*
	* @param userId the user ID of this kunde
	*/
	@Override
	public void setUserId(long userId) {
		_kunde.setUserId(userId);
	}

	/**
	* Returns the user uuid of this kunde.
	*
	* @return the user uuid of this kunde
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kunde.getUserUuid();
	}

	/**
	* Sets the user uuid of this kunde.
	*
	* @param userUuid the user uuid of this kunde
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_kunde.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this kunde.
	*
	* @return the user name of this kunde
	*/
	@Override
	public java.lang.String getUserName() {
		return _kunde.getUserName();
	}

	/**
	* Sets the user name of this kunde.
	*
	* @param userName the user name of this kunde
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_kunde.setUserName(userName);
	}

	/**
	* Returns the create date of this kunde.
	*
	* @return the create date of this kunde
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _kunde.getCreateDate();
	}

	/**
	* Sets the create date of this kunde.
	*
	* @param createDate the create date of this kunde
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_kunde.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this kunde.
	*
	* @return the modified date of this kunde
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _kunde.getModifiedDate();
	}

	/**
	* Sets the modified date of this kunde.
	*
	* @param modifiedDate the modified date of this kunde
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_kunde.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the kunde description of this kunde.
	*
	* @return the kunde description of this kunde
	*/
	@Override
	public java.lang.String getKundeDescription() {
		return _kunde.getKundeDescription();
	}

	/**
	* Sets the kunde description of this kunde.
	*
	* @param kundeDescription the kunde description of this kunde
	*/
	@Override
	public void setKundeDescription(java.lang.String kundeDescription) {
		_kunde.setKundeDescription(kundeDescription);
	}

	/**
	* Returns the user kunde of this kunde.
	*
	* @return the user kunde of this kunde
	*/
	@Override
	public java.lang.String getUserKunde() {
		return _kunde.getUserKunde();
	}

	/**
	* Sets the user kunde of this kunde.
	*
	* @param userKunde the user kunde of this kunde
	*/
	@Override
	public void setUserKunde(java.lang.String userKunde) {
		_kunde.setUserKunde(userKunde);
	}

	/**
	* Returns the user document of this kunde.
	*
	* @return the user document of this kunde
	*/
	@Override
	public long getUserDocument() {
		return _kunde.getUserDocument();
	}

	/**
	* Sets the user document of this kunde.
	*
	* @param userDocument the user document of this kunde
	*/
	@Override
	public void setUserDocument(long userDocument) {
		_kunde.setUserDocument(userDocument);
	}

	/**
	* Returns the user city of this kunde.
	*
	* @return the user city of this kunde
	*/
	@Override
	public java.lang.String getUserCity() {
		return _kunde.getUserCity();
	}

	/**
	* Sets the user city of this kunde.
	*
	* @param userCity the user city of this kunde
	*/
	@Override
	public void setUserCity(java.lang.String userCity) {
		_kunde.setUserCity(userCity);
	}

	/**
	* Returns the user email of this kunde.
	*
	* @return the user email of this kunde
	*/
	@Override
	public java.lang.String getUserEmail() {
		return _kunde.getUserEmail();
	}

	/**
	* Sets the user email of this kunde.
	*
	* @param userEmail the user email of this kunde
	*/
	@Override
	public void setUserEmail(java.lang.String userEmail) {
		_kunde.setUserEmail(userEmail);
	}

	/**
	* Returns the folder d l ID of this kunde.
	*
	* @return the folder d l ID of this kunde
	*/
	@Override
	public long getFolderDLId() {
		return _kunde.getFolderDLId();
	}

	/**
	* Sets the folder d l ID of this kunde.
	*
	* @param folderDLId the folder d l ID of this kunde
	*/
	@Override
	public void setFolderDLId(long folderDLId) {
		_kunde.setFolderDLId(folderDLId);
	}

	@Override
	public boolean isNew() {
		return _kunde.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_kunde.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _kunde.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kunde.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _kunde.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _kunde.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_kunde.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kunde.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_kunde.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_kunde.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kunde.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new kundeWrapper((kunde)_kunde.clone());
	}

	@Override
	public int compareTo(
		org.xmlportletfactory.example01.order.model.kunde kunde) {
		return _kunde.compareTo(kunde);
	}

	@Override
	public int hashCode() {
		return _kunde.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.xmlportletfactory.example01.order.model.kunde> toCacheModel() {
		return _kunde.toCacheModel();
	}

	@Override
	public org.xmlportletfactory.example01.order.model.kunde toEscapedModel() {
		return new kundeWrapper(_kunde.toEscapedModel());
	}

	@Override
	public org.xmlportletfactory.example01.order.model.kunde toUnescapedModel() {
		return new kundeWrapper(_kunde.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _kunde.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kunde.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_kunde.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof kundeWrapper)) {
			return false;
		}

		kundeWrapper kundeWrapper = (kundeWrapper)obj;

		if (Validator.equals(_kunde, kundeWrapper._kunde)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public kunde getWrappedkunde() {
		return _kunde;
	}

	@Override
	public kunde getWrappedModel() {
		return _kunde;
	}

	@Override
	public void resetOriginalValues() {
		_kunde.resetOriginalValues();
	}

	private kunde _kunde;
}