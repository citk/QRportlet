/**
 *     Copyright (C) 2009-2014  Jack A. Rider All rights reserved.
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 */
 
 
package org.xmlportletfactory.tnsoft.qrperson.service.impl;

import java.util.List;

import org.xmlportletfactory.tnsoft.qrperson.NoSuchpersonException;
import org.xmlportletfactory.tnsoft.qrperson.model.person;
import org.xmlportletfactory.tnsoft.qrperson.service.base.personLocalServiceBaseImpl;
import org.xmlportletfactory.tnsoft.qrperson.util.personIndexer;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.kernel.exception.PortalException;
import java.util.Date;


/**
 * @author Jack A. Rider
 * @author Juan Gonzalez P.
 */
public class personLocalServiceImpl extends personLocalServiceBaseImpl {

	@SuppressWarnings("unchecked")
	public List<person> getCompanyEntries(
			long companyId, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		return personPersistence.findByCompanyId(
				companyId, start, end, obc);
	}

	@SuppressWarnings("unchecked")
	public List<person> getCompanyEntries(
			long companyId, int start, int end)
		throws SystemException {

		return personPersistence.findByCompanyId(
				companyId, start, end);
	}

	@SuppressWarnings("unchecked")
	public int getCompanyEntriesCount(
			long companyId)
		throws SystemException {

		return personPersistence.countByCompanyId(companyId);
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId)throws SystemException {
		List<person> list = (List<person>) personPersistence.findByUserId(userId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllInUser(long userId)throws SystemException {
		int count = personPersistence.countByUserId(userId);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId, OrderByComparator orderByComparator) throws SystemException {

		List<person> list = (List<person>) findAllInUser(userId, QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		List<person> list = (List<person>) personPersistence.findByUserId(userId, start, end, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId) throws SystemException {
		List<person> list = (List<person>) personPersistence.filterFindByGroupId(groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllInGroup(long groupId) throws SystemException {
		int count = personPersistence.filterCountByGroupId(groupId);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId, OrderByComparator orderByComparator) throws SystemException{
		List <person> list = (List<person>) findAllInGroup (groupId, QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException{
		List <person> list = (List<person>) personPersistence.filterFindByGroupId(groupId, start, end, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId) throws SystemException {
		List<person> list = (List<person>) personPersistence.filterFindByUserIdGroupId(userId, groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllInUserAndGroup(long userId, long groupId) throws SystemException {
		int count = personPersistence.filterCountByUserIdGroupId(userId, groupId);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId, OrderByComparator orderByComparator) throws SystemException {

		List<person> list = (List<person>) findAllInUserAndGroup(groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		List<person> list = (List<person>) personPersistence.filterFindByUserIdGroupId(userId, groupId, start, end, orderByComparator);
		return list;
	}




	public person addperson (person validperson, ServiceContext serviceContext) throws PortalException, SystemException {
	    person retVal = _addperson (validperson, serviceContext);

		// Resources
		if (serviceContext.isAddGroupPermissions() ||
			serviceContext.isAddGuestPermissions()) {

			addEntryResources(
				retVal, serviceContext.isAddGroupPermissions(),
				serviceContext.isAddGuestPermissions());
		}
		else {
			addEntryResources(
				retVal, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}


		// Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(person.class);

		indexer.reindex(retVal);
		return retVal;
	}

	public person updateperson (person validperson, ServiceContext serviceContext) throws PortalException, SystemException {
	
		person entry = personPersistence.findByPrimaryKey(validperson.getPrimaryKey());
		validperson.setCreateDate(entry.getCreateDate());	
     	User user = userPersistence.findByPrimaryKey(validperson.getUserId());
		validperson.setUserName(user.getFullName());	

		validperson.setModifiedDate(serviceContext.getModifiedDate(null));

		person retVal = personPersistence.update(validperson);

		// Resources

		if ((serviceContext.getGroupPermissions() != null) ||
				(serviceContext.getGuestPermissions() != null)) {

			updateEntryResources(
				retVal, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}

		
		//Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(person.class);

		indexer.reindex(retVal);

		return retVal;
	}

	private person _addperson (person validperson, ServiceContext serviceContext) throws PortalException, SystemException {
		person fileobj = personPersistence.create(counterLocalService.increment(person.class.getName()));

	     	User user = userPersistence.findByPrimaryKey(validperson.getUserId());

	     	Date now =new Date();
	    	fileobj.setCompanyId(validperson.getCompanyId());
	    	fileobj.setGroupId(validperson.getGroupId());
	    	fileobj.setUserId(user.getUserId());
	    	fileobj.setUserName(user.getFullName());
	    	fileobj.setCreateDate(now);
	    	fileobj.setModifiedDate(now);


	    	fileobj.setFirstname(validperson.getFirstname());
	    	fileobj.setMiddlename(validperson.getMiddlename());
	    	fileobj.setLastname(validperson.getLastname());
	    	fileobj.setKundeDescription(validperson.getKundeDescription());
	    	fileobj.setUserDocument(validperson.getUserDocument());
	    	fileobj.setCity(validperson.getCity());
	    	fileobj.setUserEmail(validperson.getUserEmail());
	     	fileobj.setFolderDLId(validperson.getFolderDLId());

	 		return personPersistence.update(fileobj);
	}

	public void deletepersonEntry (person fileobj) throws PortalException, SystemException {

		personPersistence.remove(fileobj.getPrimaryKey());

		// Resources

		resourceLocalService.deleteResource(
			fileobj.getCompanyId(), person.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, fileobj.getPrimaryKey());
		//Remove DocumentFile dir
		Long dlFolder = fileobj.getFolderDLId();
		if(dlFolder!=null && dlFolder!=0L) {
			dlFolderPersistence.remove(dlFolder);
		}

		// Indexer

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(person.class);

		indexer.delete(fileobj);


	}



	public void addEntryResources(
			person entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
			person.class.getName(), entry.getPrimaryKey(), false,
			addGroupPermissions, addGuestPermissions);
	}

	public void addEntryResources(
			person entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
			person.class.getName(), entry.getPrimaryKey(), groupPermissions,
			guestPermissions);
	}

	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		person entry = personPersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, addGroupPermissions, addGuestPermissions);
	}

	public void addEntryResources(
			long entryId, String[] groupPermissions, String[] guestPermissions)
		throws PortalException, SystemException {

		person entry = personPersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, groupPermissions, guestPermissions);
	}

	public void updateEntryResources(
			person entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.updateResources(
			entry.getCompanyId(), entry.getGroupId(),
			person.class.getName(), entry.getPrimaryKey(), groupPermissions,
			guestPermissions);
	}
}
