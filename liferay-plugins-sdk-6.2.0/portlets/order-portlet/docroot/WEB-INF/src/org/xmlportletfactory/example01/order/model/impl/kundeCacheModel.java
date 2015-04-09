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

package org.xmlportletfactory.example01.order.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.xmlportletfactory.example01.order.model.kunde;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing kunde in entity cache.
 *
 * @author Jack A. Rider
 * @see kunde
 * @generated
 */
public class kundeCacheModel implements CacheModel<kunde>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{kundeId=");
		sb.append(kundeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", kundeDescription=");
		sb.append(kundeDescription);
		sb.append(", userKunde=");
		sb.append(userKunde);
		sb.append(", userDocument=");
		sb.append(userDocument);
		sb.append(", userCity=");
		sb.append(userCity);
		sb.append(", userEmail=");
		sb.append(userEmail);
		sb.append(", folderDLId=");
		sb.append(folderDLId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public kunde toEntityModel() {
		kundeImpl kundeImpl = new kundeImpl();

		kundeImpl.setKundeId(kundeId);
		kundeImpl.setCompanyId(companyId);
		kundeImpl.setGroupId(groupId);
		kundeImpl.setUserId(userId);

		if (userName == null) {
			kundeImpl.setUserName(StringPool.BLANK);
		}
		else {
			kundeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kundeImpl.setCreateDate(null);
		}
		else {
			kundeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kundeImpl.setModifiedDate(null);
		}
		else {
			kundeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (kundeDescription == null) {
			kundeImpl.setKundeDescription(StringPool.BLANK);
		}
		else {
			kundeImpl.setKundeDescription(kundeDescription);
		}

		if (userKunde == null) {
			kundeImpl.setUserKunde(StringPool.BLANK);
		}
		else {
			kundeImpl.setUserKunde(userKunde);
		}

		kundeImpl.setUserDocument(userDocument);

		if (userCity == null) {
			kundeImpl.setUserCity(StringPool.BLANK);
		}
		else {
			kundeImpl.setUserCity(userCity);
		}

		if (userEmail == null) {
			kundeImpl.setUserEmail(StringPool.BLANK);
		}
		else {
			kundeImpl.setUserEmail(userEmail);
		}

		kundeImpl.setFolderDLId(folderDLId);

		kundeImpl.resetOriginalValues();

		return kundeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		kundeId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		kundeDescription = objectInput.readUTF();
		userKunde = objectInput.readUTF();
		userDocument = objectInput.readLong();
		userCity = objectInput.readUTF();
		userEmail = objectInput.readUTF();
		folderDLId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kundeId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (kundeDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kundeDescription);
		}

		if (userKunde == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userKunde);
		}

		objectOutput.writeLong(userDocument);

		if (userCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userCity);
		}

		if (userEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userEmail);
		}

		objectOutput.writeLong(folderDLId);
	}

	public long kundeId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String kundeDescription;
	public String userKunde;
	public long userDocument;
	public String userCity;
	public String userEmail;
	public long folderDLId;
}