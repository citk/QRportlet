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
 
 
package org.xmlportletfactory.example01.order.service.impl;

import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.xmlportletfactory.example01.order.NoSuchkundeException;
import org.xmlportletfactory.example01.order.model.kunde;
import org.xmlportletfactory.example01.order.service.base.kundeLocalServiceBaseImpl;
import org.xmlportletfactory.example01.order.util.kundeIndexer;
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
public class kundeLocalServiceImpl extends kundeLocalServiceBaseImpl {

    private static final Log LOG = LogFactoryUtil.getLog(kundeLocalServiceImpl.class);

	@SuppressWarnings("unchecked")
	public List<kunde> getCompanyEntries(
			long companyId, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		return kundePersistence.findByCompanyId(
				companyId, start, end, obc);
	}

	@SuppressWarnings("unchecked")
	public List<kunde> getCompanyEntries(
			long companyId, int start, int end)
		throws SystemException {

		return kundePersistence.findByCompanyId(
				companyId, start, end);
	}

	@SuppressWarnings("unchecked")
	public int getCompanyEntriesCount(
			long companyId)
		throws SystemException {

		return kundePersistence.countByCompanyId(companyId);
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId)throws SystemException {
		List<kunde> list = (List<kunde>) kundePersistence.findByUserId(userId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllInUser(long userId)throws SystemException {
		int count = kundePersistence.countByUserId(userId);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId, OrderByComparator orderByComparator) throws SystemException {

		List<kunde> list = (List<kunde>) findAllInUser(userId, QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		List<kunde> list = (List<kunde>) kundePersistence.findByUserId(userId, start, end, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId) throws SystemException {
		List<kunde> list = (List<kunde>) kundePersistence.filterFindByGroupId(groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllInGroup(long groupId) throws SystemException {
		int count = kundePersistence.filterCountByGroupId(groupId);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId, OrderByComparator orderByComparator) throws SystemException{
		List <kunde> list = (List<kunde>) findAllInGroup (groupId, QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException{
		List <kunde> list = (List<kunde>) kundePersistence.filterFindByGroupId(groupId, start, end, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId) throws SystemException {
		List<kunde> list = (List<kunde>) kundePersistence.filterFindByUserIdGroupId(userId, groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllInUserAndGroup(long userId, long groupId) throws SystemException {
		int count = kundePersistence.filterCountByUserIdGroupId(userId, groupId);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId, OrderByComparator orderByComparator) throws SystemException {

		List<kunde> list = (List<kunde>) findAllInUserAndGroup(groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		List<kunde> list = (List<kunde>) kundePersistence.filterFindByUserIdGroupId(userId, groupId, start, end, orderByComparator);
		return list;
	}




	public kunde addkunde (kunde validkunde, ServiceContext serviceContext) throws PortalException, SystemException {
	    kunde retVal = _addkunde (validkunde, serviceContext);

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
		Indexer indexer = IndexerRegistryUtil.getIndexer(kunde.class);

		indexer.reindex(retVal);
		return retVal;
	}

	public kunde updatekunde (kunde validkunde, ServiceContext serviceContext) throws PortalException, SystemException {
	
		kunde entry = kundePersistence.findByPrimaryKey(validkunde.getPrimaryKey());
		validkunde.setCreateDate(entry.getCreateDate());	
     	User user = userPersistence.findByPrimaryKey(validkunde.getUserId());
		validkunde.setUserName(user.getFullName());	

		validkunde.setModifiedDate(serviceContext.getModifiedDate(null));

		kunde retVal = kundePersistence.update(validkunde);

		// Resources

		if ((serviceContext.getGroupPermissions() != null) ||
				(serviceContext.getGuestPermissions() != null)) {

			updateEntryResources(
				retVal, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}

		
		//Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(kunde.class);

		indexer.reindex(retVal);

		return retVal;
	}

	private kunde _addkunde (kunde validkunde, ServiceContext serviceContext) throws PortalException, SystemException {
		kunde fileobj = kundePersistence.create(counterLocalService.increment(kunde.class.getName()));

	     	User user = userPersistence.findByPrimaryKey(validkunde.getUserId());

	     	Date now =new Date();
	    	fileobj.setCompanyId(validkunde.getCompanyId());
	    	fileobj.setGroupId(validkunde.getGroupId());
	    	fileobj.setUserId(user.getUserId());
	    	fileobj.setUserName(user.getFullName());
	    	fileobj.setCreateDate(now);
	    	fileobj.setModifiedDate(now);


	    	fileobj.setKundeDescription(validkunde.getKundeDescription());
	    	fileobj.setUserKunde(validkunde.getUserKunde());
	    	fileobj.setUserDocument(validkunde.getUserDocument());
	    	fileobj.setUserCity(validkunde.getUserCity());
	    	fileobj.setUserEmail(validkunde.getUserEmail());
	     	fileobj.setFolderDLId(validkunde.getFolderDLId());

	 		return kundePersistence.update(fileobj);
	}

	public void deletekundeEntry (kunde fileobj) throws PortalException, SystemException {

		kundePersistence.remove(fileobj.getPrimaryKey());

		// Resources

		resourceLocalService.deleteResource(
			fileobj.getCompanyId(), kunde.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, fileobj.getPrimaryKey());
		//Remove DocumentFile dir
		Long dlFolder = fileobj.getFolderDLId();
		if(dlFolder!=null && dlFolder!=0L) {
			dlFolderPersistence.remove(dlFolder);
		}

		// Indexer

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(kunde.class);

		indexer.delete(fileobj);


	}



	public void addEntryResources(
			kunde entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
			kunde.class.getName(), entry.getPrimaryKey(), false,
			addGroupPermissions, addGuestPermissions);
	}

	public void addEntryResources(
			kunde entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
			kunde.class.getName(), entry.getPrimaryKey(), groupPermissions,
			guestPermissions);
	}

	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		kunde entry = kundePersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, addGroupPermissions, addGuestPermissions);
	}

	public void addEntryResources(
			long entryId, String[] groupPermissions, String[] guestPermissions)
		throws PortalException, SystemException {

		kunde entry = kundePersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, groupPermissions, guestPermissions);
	}

	public void updateEntryResources(
			kunde entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.updateResources(
			entry.getCompanyId(), entry.getGroupId(),
			kunde.class.getName(), entry.getPrimaryKey(), groupPermissions,
			guestPermissions);
	}

    public void helloWorld(){
        LOG.info("LOGGER");
    }
}
