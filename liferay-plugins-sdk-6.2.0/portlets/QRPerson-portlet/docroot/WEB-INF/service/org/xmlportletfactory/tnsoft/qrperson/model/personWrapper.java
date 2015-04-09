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

package org.xmlportletfactory.tnsoft.qrperson.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link person}.
 * </p>
 *
 * @author Jack A. Rider
 * @see person
 * @generated
 */
public class personWrapper implements person, ModelWrapper<person> {
	public personWrapper(person person) {
		_person = person;
	}

	@Override
	public Class<?> getModelClass() {
		return person.class;
	}

	@Override
	public String getModelClassName() {
		return person.class.getName();
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
		attributes.put("Firstname", getFirstname());
		attributes.put("Middlename", getMiddlename());
		attributes.put("Lastname", getLastname());
		attributes.put("kundeDescription", getKundeDescription());
		attributes.put("userDocument", getUserDocument());
		attributes.put("City", getCity());
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

		String Firstname = (String)attributes.get("Firstname");

		if (Firstname != null) {
			setFirstname(Firstname);
		}

		String Middlename = (String)attributes.get("Middlename");

		if (Middlename != null) {
			setMiddlename(Middlename);
		}

		String Lastname = (String)attributes.get("Lastname");

		if (Lastname != null) {
			setLastname(Lastname);
		}

		String kundeDescription = (String)attributes.get("kundeDescription");

		if (kundeDescription != null) {
			setKundeDescription(kundeDescription);
		}

		Long userDocument = (Long)attributes.get("userDocument");

		if (userDocument != null) {
			setUserDocument(userDocument);
		}

		String City = (String)attributes.get("City");

		if (City != null) {
			setCity(City);
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
	* Returns the primary key of this person.
	*
	* @return the primary key of this person
	*/
	@Override
	public long getPrimaryKey() {
		return _person.getPrimaryKey();
	}

	/**
	* Sets the primary key of this person.
	*
	* @param primaryKey the primary key of this person
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_person.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the kunde ID of this person.
	*
	* @return the kunde ID of this person
	*/
	@Override
	public long getKundeId() {
		return _person.getKundeId();
	}

	/**
	* Sets the kunde ID of this person.
	*
	* @param kundeId the kunde ID of this person
	*/
	@Override
	public void setKundeId(long kundeId) {
		_person.setKundeId(kundeId);
	}

	/**
	* Returns the company ID of this person.
	*
	* @return the company ID of this person
	*/
	@Override
	public long getCompanyId() {
		return _person.getCompanyId();
	}

	/**
	* Sets the company ID of this person.
	*
	* @param companyId the company ID of this person
	*/
	@Override
	public void setCompanyId(long companyId) {
		_person.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this person.
	*
	* @return the group ID of this person
	*/
	@Override
	public long getGroupId() {
		return _person.getGroupId();
	}

	/**
	* Sets the group ID of this person.
	*
	* @param groupId the group ID of this person
	*/
	@Override
	public void setGroupId(long groupId) {
		_person.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this person.
	*
	* @return the user ID of this person
	*/
	@Override
	public long getUserId() {
		return _person.getUserId();
	}

	/**
	* Sets the user ID of this person.
	*
	* @param userId the user ID of this person
	*/
	@Override
	public void setUserId(long userId) {
		_person.setUserId(userId);
	}

	/**
	* Returns the user uuid of this person.
	*
	* @return the user uuid of this person
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _person.getUserUuid();
	}

	/**
	* Sets the user uuid of this person.
	*
	* @param userUuid the user uuid of this person
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_person.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this person.
	*
	* @return the user name of this person
	*/
	@Override
	public java.lang.String getUserName() {
		return _person.getUserName();
	}

	/**
	* Sets the user name of this person.
	*
	* @param userName the user name of this person
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_person.setUserName(userName);
	}

	/**
	* Returns the create date of this person.
	*
	* @return the create date of this person
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _person.getCreateDate();
	}

	/**
	* Sets the create date of this person.
	*
	* @param createDate the create date of this person
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_person.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this person.
	*
	* @return the modified date of this person
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _person.getModifiedDate();
	}

	/**
	* Sets the modified date of this person.
	*
	* @param modifiedDate the modified date of this person
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_person.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the firstname of this person.
	*
	* @return the firstname of this person
	*/
	@Override
	public java.lang.String getFirstname() {
		return _person.getFirstname();
	}

	/**
	* Sets the firstname of this person.
	*
	* @param Firstname the firstname of this person
	*/
	@Override
	public void setFirstname(java.lang.String Firstname) {
		_person.setFirstname(Firstname);
	}

	/**
	* Returns the middlename of this person.
	*
	* @return the middlename of this person
	*/
	@Override
	public java.lang.String getMiddlename() {
		return _person.getMiddlename();
	}

	/**
	* Sets the middlename of this person.
	*
	* @param Middlename the middlename of this person
	*/
	@Override
	public void setMiddlename(java.lang.String Middlename) {
		_person.setMiddlename(Middlename);
	}

	/**
	* Returns the lastname of this person.
	*
	* @return the lastname of this person
	*/
	@Override
	public java.lang.String getLastname() {
		return _person.getLastname();
	}

	/**
	* Sets the lastname of this person.
	*
	* @param Lastname the lastname of this person
	*/
	@Override
	public void setLastname(java.lang.String Lastname) {
		_person.setLastname(Lastname);
	}

	/**
	* Returns the kunde description of this person.
	*
	* @return the kunde description of this person
	*/
	@Override
	public java.lang.String getKundeDescription() {
		return _person.getKundeDescription();
	}

	/**
	* Sets the kunde description of this person.
	*
	* @param kundeDescription the kunde description of this person
	*/
	@Override
	public void setKundeDescription(java.lang.String kundeDescription) {
		_person.setKundeDescription(kundeDescription);
	}

	/**
	* Returns the user document of this person.
	*
	* @return the user document of this person
	*/
	@Override
	public long getUserDocument() {
		return _person.getUserDocument();
	}

	/**
	* Sets the user document of this person.
	*
	* @param userDocument the user document of this person
	*/
	@Override
	public void setUserDocument(long userDocument) {
		_person.setUserDocument(userDocument);
	}

	/**
	* Returns the city of this person.
	*
	* @return the city of this person
	*/
	@Override
	public java.lang.String getCity() {
		return _person.getCity();
	}

	/**
	* Sets the city of this person.
	*
	* @param City the city of this person
	*/
	@Override
	public void setCity(java.lang.String City) {
		_person.setCity(City);
	}

	/**
	* Returns the user email of this person.
	*
	* @return the user email of this person
	*/
	@Override
	public java.lang.String getUserEmail() {
		return _person.getUserEmail();
	}

	/**
	* Sets the user email of this person.
	*
	* @param userEmail the user email of this person
	*/
	@Override
	public void setUserEmail(java.lang.String userEmail) {
		_person.setUserEmail(userEmail);
	}

	/**
	* Returns the folder d l ID of this person.
	*
	* @return the folder d l ID of this person
	*/
	@Override
	public long getFolderDLId() {
		return _person.getFolderDLId();
	}

	/**
	* Sets the folder d l ID of this person.
	*
	* @param folderDLId the folder d l ID of this person
	*/
	@Override
	public void setFolderDLId(long folderDLId) {
		_person.setFolderDLId(folderDLId);
	}

	@Override
	public boolean isNew() {
		return _person.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_person.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _person.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_person.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _person.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _person.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_person.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _person.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_person.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_person.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_person.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new personWrapper((person)_person.clone());
	}

	@Override
	public int compareTo(
		org.xmlportletfactory.tnsoft.qrperson.model.person person) {
		return _person.compareTo(person);
	}

	@Override
	public int hashCode() {
		return _person.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.xmlportletfactory.tnsoft.qrperson.model.person> toCacheModel() {
		return _person.toCacheModel();
	}

	@Override
	public org.xmlportletfactory.tnsoft.qrperson.model.person toEscapedModel() {
		return new personWrapper(_person.toEscapedModel());
	}

	@Override
	public org.xmlportletfactory.tnsoft.qrperson.model.person toUnescapedModel() {
		return new personWrapper(_person.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _person.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _person.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_person.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof personWrapper)) {
			return false;
		}

		personWrapper personWrapper = (personWrapper)obj;

		if (Validator.equals(_person, personWrapper._person)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public person getWrappedperson() {
		return _person;
	}

	@Override
	public person getWrappedModel() {
		return _person;
	}

	@Override
	public void resetOriginalValues() {
		_person.resetOriginalValues();
	}

	private person _person;
}