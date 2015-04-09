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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.xmlportletfactory.example01.order.service.http.kundeServiceSoap}.
 *
 * @author Jack A. Rider
 * @see org.xmlportletfactory.example01.order.service.http.kundeServiceSoap
 * @generated
 */
public class kundeSoap implements Serializable {
	public static kundeSoap toSoapModel(kunde model) {
		kundeSoap soapModel = new kundeSoap();

		soapModel.setKundeId(model.getKundeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setKundeDescription(model.getKundeDescription());
		soapModel.setUserKunde(model.getUserKunde());
		soapModel.setUserDocument(model.getUserDocument());
		soapModel.setUserCity(model.getUserCity());
		soapModel.setUserEmail(model.getUserEmail());
		soapModel.setFolderDLId(model.getFolderDLId());

		return soapModel;
	}

	public static kundeSoap[] toSoapModels(kunde[] models) {
		kundeSoap[] soapModels = new kundeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static kundeSoap[][] toSoapModels(kunde[][] models) {
		kundeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new kundeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new kundeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static kundeSoap[] toSoapModels(List<kunde> models) {
		List<kundeSoap> soapModels = new ArrayList<kundeSoap>(models.size());

		for (kunde model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new kundeSoap[soapModels.size()]);
	}

	public kundeSoap() {
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

	public String getKundeDescription() {
		return _kundeDescription;
	}

	public void setKundeDescription(String kundeDescription) {
		_kundeDescription = kundeDescription;
	}

	public String getUserKunde() {
		return _userKunde;
	}

	public void setUserKunde(String userKunde) {
		_userKunde = userKunde;
	}

	public long getUserDocument() {
		return _userDocument;
	}

	public void setUserDocument(long userDocument) {
		_userDocument = userDocument;
	}

	public String getUserCity() {
		return _userCity;
	}

	public void setUserCity(String userCity) {
		_userCity = userCity;
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
	private String _kundeDescription;
	private String _userKunde;
	private long _userDocument;
	private String _userCity;
	private String _userEmail;
	private long _folderDLId;
}