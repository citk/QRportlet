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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.xmlportletfactory.example01.order.service.ClpSerializer;
import org.xmlportletfactory.example01.order.service.kundeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jack A. Rider
 */
public class kundeClp extends BaseModelImpl<kunde> implements kunde {
	public kundeClp() {
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

	@Override
	public long getKundeId() {
		return _kundeId;
	}

	@Override
	public void setKundeId(long kundeId) {
		_kundeId = kundeId;

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setKundeId", long.class);

				method.invoke(_kundeRemoteModel, kundeId);
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

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_kundeRemoteModel, companyId);
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

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_kundeRemoteModel, groupId);
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

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_kundeRemoteModel, userId);
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

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_kundeRemoteModel, userName);
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

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_kundeRemoteModel, createDate);
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

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_kundeRemoteModel, modifiedDate);
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

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setKundeDescription",
						String.class);

				method.invoke(_kundeRemoteModel, kundeDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserKunde() {
		return _userKunde;
	}

	@Override
	public void setUserKunde(String userKunde) {
		_userKunde = userKunde;

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserKunde", String.class);

				method.invoke(_kundeRemoteModel, userKunde);
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

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserDocument", long.class);

				method.invoke(_kundeRemoteModel, userDocument);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserCity() {
		return _userCity;
	}

	@Override
	public void setUserCity(String userCity) {
		_userCity = userCity;

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserCity", String.class);

				method.invoke(_kundeRemoteModel, userCity);
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

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserEmail", String.class);

				method.invoke(_kundeRemoteModel, userEmail);
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

		if (_kundeRemoteModel != null) {
			try {
				Class<?> clazz = _kundeRemoteModel.getClass();

				Method method = clazz.getMethod("setFolderDLId", long.class);

				method.invoke(_kundeRemoteModel, folderDLId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getkundeRemoteModel() {
		return _kundeRemoteModel;
	}

	public void setkundeRemoteModel(BaseModel<?> kundeRemoteModel) {
		_kundeRemoteModel = kundeRemoteModel;
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

		Class<?> remoteModelClass = _kundeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_kundeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			kundeLocalServiceUtil.addkunde(this);
		}
		else {
			kundeLocalServiceUtil.updatekunde(this);
		}
	}

	@Override
	public kunde toEscapedModel() {
		return (kunde)ProxyUtil.newProxyInstance(kunde.class.getClassLoader(),
			new Class[] { kunde.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		kundeClp clone = new kundeClp();

		clone.setKundeId(getKundeId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setKundeDescription(getKundeDescription());
		clone.setUserKunde(getUserKunde());
		clone.setUserDocument(getUserDocument());
		clone.setUserCity(getUserCity());
		clone.setUserEmail(getUserEmail());
		clone.setFolderDLId(getFolderDLId());

		return clone;
	}

	@Override
	public int compareTo(kunde kunde) {
		long primaryKey = kunde.getPrimaryKey();

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

		if (!(obj instanceof kundeClp)) {
			return false;
		}

		kundeClp kunde = (kundeClp)obj;

		long primaryKey = kunde.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

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
		sb.append(", kundeDescription=");
		sb.append(getKundeDescription());
		sb.append(", userKunde=");
		sb.append(getUserKunde());
		sb.append(", userDocument=");
		sb.append(getUserDocument());
		sb.append(", userCity=");
		sb.append(getUserCity());
		sb.append(", userEmail=");
		sb.append(getUserEmail());
		sb.append(", folderDLId=");
		sb.append(getFolderDLId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.xmlportletfactory.example01.order.model.kunde");
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
			"<column><column-name>kundeDescription</column-name><column-value><![CDATA[");
		sb.append(getKundeDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userKunde</column-name><column-value><![CDATA[");
		sb.append(getUserKunde());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userDocument</column-name><column-value><![CDATA[");
		sb.append(getUserDocument());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userCity</column-name><column-value><![CDATA[");
		sb.append(getUserCity());
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
	private String _kundeDescription;
	private String _userKunde;
	private long _userDocument;
	private String _userCity;
	private String _userEmail;
	private long _folderDLId;
	private BaseModel<?> _kundeRemoteModel;
}