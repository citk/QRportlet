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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.xmlportletfactory.tnsoft.qrperson.service.ClpSerializer;
import org.xmlportletfactory.tnsoft.qrperson.service.personLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jack A. Rider
 */
public class personClp extends BaseModelImpl<person> implements person {
	public personClp() {
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
	public long getPrimaryKey() {
		return _kundeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setKundeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kundeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getKundeId() {
		return _kundeId;
	}

	@Override
	public void setKundeId(long kundeId) {
		_kundeId = kundeId;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setKundeId", long.class);

				method.invoke(_personRemoteModel, kundeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_personRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_personRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_personRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_personRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_personRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_personRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstname() {
		return _Firstname;
	}

	@Override
	public void setFirstname(String Firstname) {
		_Firstname = Firstname;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstname", String.class);

				method.invoke(_personRemoteModel, Firstname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMiddlename() {
		return _Middlename;
	}

	@Override
	public void setMiddlename(String Middlename) {
		_Middlename = Middlename;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setMiddlename", String.class);

				method.invoke(_personRemoteModel, Middlename);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastname() {
		return _Lastname;
	}

	@Override
	public void setLastname(String Lastname) {
		_Lastname = Lastname;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setLastname", String.class);

				method.invoke(_personRemoteModel, Lastname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKundeDescription() {
		return _kundeDescription;
	}

	@Override
	public void setKundeDescription(String kundeDescription) {
		_kundeDescription = kundeDescription;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setKundeDescription",
						String.class);

				method.invoke(_personRemoteModel, kundeDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserDocument() {
		return _userDocument;
	}

	@Override
	public void setUserDocument(long userDocument) {
		_userDocument = userDocument;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setUserDocument", long.class);

				method.invoke(_personRemoteModel, userDocument);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _City;
	}

	@Override
	public void setCity(String City) {
		_City = City;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_personRemoteModel, City);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserEmail() {
		return _userEmail;
	}

	@Override
	public void setUserEmail(String userEmail) {
		_userEmail = userEmail;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setUserEmail", String.class);

				method.invoke(_personRemoteModel, userEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFolderDLId() {
		return _folderDLId;
	}

	@Override
	public void setFolderDLId(long folderDLId) {
		_folderDLId = folderDLId;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setFolderDLId", long.class);

				method.invoke(_personRemoteModel, folderDLId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getpersonRemoteModel() {
		return _personRemoteModel;
	}

	public void setpersonRemoteModel(BaseModel<?> personRemoteModel) {
		_personRemoteModel = personRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _personRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_personRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			personLocalServiceUtil.addperson(this);
		}
		else {
			personLocalServiceUtil.updateperson(this);
		}
	}

	@Override
	public person toEscapedModel() {
		return (person)ProxyUtil.newProxyInstance(person.class.getClassLoader(),
			new Class[] { person.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		personClp clone = new personClp();

		clone.setKundeId(getKundeId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFirstname(getFirstname());
		clone.setMiddlename(getMiddlename());
		clone.setLastname(getLastname());
		clone.setKundeDescription(getKundeDescription());
		clone.setUserDocument(getUserDocument());
		clone.setCity(getCity());
		clone.setUserEmail(getUserEmail());
		clone.setFolderDLId(getFolderDLId());

		return clone;
	}

	@Override
	public int compareTo(person person) {
		long primaryKey = person.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof personClp)) {
			return false;
		}

		personClp person = (personClp)obj;

		long primaryKey = person.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{kundeId=");
		sb.append(getKundeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", Firstname=");
		sb.append(getFirstname());
		sb.append(", Middlename=");
		sb.append(getMiddlename());
		sb.append(", Lastname=");
		sb.append(getLastname());
		sb.append(", kundeDescription=");
		sb.append(getKundeDescription());
		sb.append(", userDocument=");
		sb.append(getUserDocument());
		sb.append(", City=");
		sb.append(getCity());
		sb.append(", userEmail=");
		sb.append(getUserEmail());
		sb.append(", folderDLId=");
		sb.append(getFolderDLId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("org.xmlportletfactory.tnsoft.qrperson.model.person");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kundeId</column-name><column-value><![CDATA[");
		sb.append(getKundeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Firstname</column-name><column-value><![CDATA[");
		sb.append(getFirstname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Middlename</column-name><column-value><![CDATA[");
		sb.append(getMiddlename());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Lastname</column-name><column-value><![CDATA[");
		sb.append(getLastname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kundeDescription</column-name><column-value><![CDATA[");
		sb.append(getKundeDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userDocument</column-name><column-value><![CDATA[");
		sb.append(getUserDocument());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>City</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userEmail</column-name><column-value><![CDATA[");
		sb.append(getUserEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderDLId</column-name><column-value><![CDATA[");
		sb.append(getFolderDLId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _kundeId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _personRemoteModel;
}