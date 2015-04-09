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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Jack A. Rider
 * @generated
 */
public class personSoap implements Serializable {
	public static personSoap toSoapModel(person model) {
		personSoap soapModel = new personSoap();

		soapModel.setKundeId(model.getKundeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstname(model.getFirstname());
		soapModel.setMiddlename(model.getMiddlename());
		soapModel.setLastname(model.getLastname());
		soapModel.setKundeDescription(model.getKundeDescription());
		soapModel.setUserDocument(model.getUserDocument());
		soapModel.setCity(model.getCity());
		soapModel.setUserEmail(model.getUserEmail());
		soapModel.setFolderDLId(model.getFolderDLId());

		return soapModel;
	}

	public static personSoap[] toSoapModels(person[] models) {
		personSoap[] soapModels = new personSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static personSoap[][] toSoapModels(person[][] models) {
		personSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new personSoap[models.length][models[0].length];
		}
		else {
			soapModels = new personSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static personSoap[] toSoapModels(List<person> models) {
		List<personSoap> soapModels = new ArrayList<personSoap>(models.size());

		for (person model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new personSoap[soapModels.size()]);
	}

	public personSoap() {
	}

	public long getPrimaryKey() {
		return _kundeId;
	}

	public void setPrimaryKey(long pk) {
		setKundeId(pk);
	}

	public long getKundeId() {
		return _kundeId;
	}

	public void setKundeId(long kundeId) {
		_kundeId = kundeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFirstname() {
		return _Firstname;
	}

	public void setFirstname(String Firstname) {
		_Firstname = Firstname;
	}

	public String getMiddlename() {
		return _Middlename;
	}

	public void setMiddlename(String Middlename) {
		_Middlename = Middlename;
	}

	public String getLastname() {
		return _Lastname;
	}

	public void setLastname(String Lastname) {
		_Lastname = Lastname;
	}

	public String getKundeDescription() {
		return _kundeDescription;
	}

	public void setKundeDescription(String kundeDescription) {
		_kundeDescription = kundeDescription;
	}

	public long getUserDocument() {
		return _userDocument;
	}

	public void setUserDocument(long userDocument) {
		_userDocument = userDocument;
	}

	public String getCity() {
		return _City;
	}

	public void setCity(String City) {
		_City = City;
	}

	public String getUserEmail() {
		return _userEmail;
	}

	public void setUserEmail(String userEmail) {
		_userEmail = userEmail;
	}

	public long getFolderDLId() {
		return _folderDLId;
	}

	public void setFolderDLId(long folderDLId) {
		_folderDLId = folderDLId;
	}

	private long _kundeId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _Firstname;
	private String _Middlename;
	private String _Lastname;
	private String _kundeDescription;
	private long _userDocument;
	private String _City;
	private String _userEmail;
	private long _folderDLId;
}