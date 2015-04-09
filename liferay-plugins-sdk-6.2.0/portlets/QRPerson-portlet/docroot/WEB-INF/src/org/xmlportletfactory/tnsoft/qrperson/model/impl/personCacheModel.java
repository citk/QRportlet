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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.xmlportletfactory.tnsoft.qrperson.model.person;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing person in entity cache.
 *
 * @author Jack A. Rider
 * @see person
 * @generated
 */
public class personCacheModel implements CacheModel<person>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

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
		sb.append(", Firstname=");
		sb.append(Firstname);
		sb.append(", Middlename=");
		sb.append(Middlename);
		sb.append(", Lastname=");
		sb.append(Lastname);
		sb.append(", kundeDescription=");
		sb.append(kundeDescription);
		sb.append(", userDocument=");
		sb.append(userDocument);
		sb.append(", City=");
		sb.append(City);
		sb.append(", userEmail=");
		sb.append(userEmail);
		sb.append(", folderDLId=");
		sb.append(folderDLId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public person toEntityModel() {
		personImpl personImpl = new personImpl();

		personImpl.setKundeId(kundeId);
		personImpl.setCompanyId(companyId);
		personImpl.setGroupId(groupId);
		personImpl.setUserId(userId);

		if (userName == null) {
			personImpl.setUserName(StringPool.BLANK);
		}
		else {
			personImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			personImpl.setCreateDate(null);
		}
		else {
			personImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			personImpl.setModifiedDate(null);
		}
		else {
			personImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (Firstname == null) {
			personImpl.setFirstname(StringPool.BLANK);
		}
		else {
			personImpl.setFirstname(Firstname);
		}

		if (Middlename == null) {
			personImpl.setMiddlename(StringPool.BLANK);
		}
		else {
			personImpl.setMiddlename(Middlename);
		}

		if (Lastname == null) {
			personImpl.setLastname(StringPool.BLANK);
		}
		else {
			personImpl.setLastname(Lastname);
		}

		if (kundeDescription == null) {
			personImpl.setKundeDescription(StringPool.BLANK);
		}
		else {
			personImpl.setKundeDescription(kundeDescription);
		}

		personImpl.setUserDocument(userDocument);

		if (City == null) {
			personImpl.setCity(StringPool.BLANK);
		}
		else {
			personImpl.setCity(City);
		}

		if (userEmail == null) {
			personImpl.setUserEmail(StringPool.BLANK);
		}
		else {
			personImpl.setUserEmail(userEmail);
		}

		personImpl.setFolderDLId(folderDLId);

		personImpl.resetOriginalValues();

		return personImpl;
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
		Firstname = objectInput.readUTF();
		Middlename = objectInput.readUTF();
		Lastname = objectInput.readUTF();
		kundeDescription = objectInput.readUTF();
		userDocument = objectInput.readLong();
		City = objectInput.readUTF();
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

		if (Firstname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Firstname);
		}

		if (Middlename == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Middlename);
		}

		if (Lastname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Lastname);
		}

		if (kundeDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kundeDescription);
		}

		objectOutput.writeLong(userDocument);

		if (City == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(City);
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
	public String Firstname;
	public String Middlename;
	public String Lastname;
	public String kundeDescription;
	public long userDocument;
	public String City;
	public String userEmail;
	public long folderDLId;
}