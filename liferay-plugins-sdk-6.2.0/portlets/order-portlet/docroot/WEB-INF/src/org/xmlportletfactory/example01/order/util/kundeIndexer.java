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
 
 
package org.xmlportletfactory.example01.order.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import org.xmlportletfactory.example01.order.model.kunde;
import org.xmlportletfactory.example01.order.service.kundeLocalServiceUtil;
import org.xmlportletfactory.example01.order.service.permission.kundeEntryPermission;
import org.xmlportletfactory.example01.order.util.kundeUtil;

import java.lang.Long;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

/**
 * @author Juan Gonzalez P. 
 */
public class kundeIndexer extends BaseIndexer{

	public static final String[] CLASS_NAMES = {kunde.class.getName()};

	public static final String PORTLET_ID = "kunde_WAR_orderportlet";
	

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	public boolean hasPermission(
			PermissionChecker permissionChecker, long entryClassPK,
			String actionId)
		throws Exception {

		return kundeEntryPermission.contains(
			permissionChecker, entryClassPK, ActionKeys.VIEW);
	}

	@Override
	public boolean isFilterSearch() {
		return _FILTER_SEARCH;
	}

	@Override
	public boolean isPermissionAware() {
		return _PERMISSION_AWARE;
	}

	@Override
	public void postProcessContextQuery(
			BooleanQuery contextQuery, SearchContext searchContext)
		throws Exception {

	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		kunde entry = (kunde)obj;

		deleteDocument(entry.getCompanyId(), entry.getPrimaryKey());
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery,
            SearchContext searchContext) throws Exception {   

		searchQuery.addTerm("userKunde", searchContext.getKeywords());	
		searchQuery.addTerm("userCity", searchContext.getKeywords());	

        	super.postProcessSearchQuery(searchQuery, searchContext);
    	}


	protected Document doGetDocument(Object obj) throws Exception {
		kunde entry = (kunde)obj;

		Document document = getBaseModelDocument(PORTLET_ID, entry);				

		//Document TITLE

		document.addText(
			Field.TITLE, HtmlUtil.extractText(entry.getUserKunde()));

		document.addText(
			"userKunde", HtmlUtil.extractText(entry.getUserKunde()));
		//userCity field
		document.addText(
			"userCity", HtmlUtil.extractText(entry.getUserCity()));

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet,
		PortletURL portletURL) {

		String title = document.get(Field.TITLE);

		String content = snippet;

		if (Validator.isNull(snippet)) {
			content = StringUtil.shorten(document.get(Field.CONTENT), 200);
		}

		String entryId = document.get(Field.ENTRY_CLASS_PK);	
		String groupId = document.get(Field.GROUP_ID);	

		long plid =0;

		try{
			plid =kundeUtil.getPlid(Long.parseLong(groupId));
		}catch (Exception e){					
		}

		portletURL.setParameter("p_l_id",String.valueOf(plid));
		portletURL.setParameter("view", "editkunde");
		portletURL.setParameter("kundeId",  String.valueOf(entryId));	
        	portletURL.setParameter("editType", "view");	

		return new Summary(title, content, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		kunde entry = (kunde)obj;

		Document document = getDocument(entry);

		SearchEngineUtil.updateDocument(
			getSearchEngineId(), entry.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		kunde entry = kundeLocalServiceUtil.getkunde(classPK);

		doReindex(entry);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexEntries(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void reindexEntries(long companyId) throws Exception {
		int count = kundeLocalServiceUtil.getCompanyEntriesCount(
			companyId);

		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = (i * Indexer.DEFAULT_INTERVAL);
			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexEntries(companyId, start, end);
		}
	}

	protected void reindexEntries(long companyId, int start, int end)
		throws Exception {
		List<kunde> entries = kundeLocalServiceUtil.getCompanyEntries(
			companyId, start, end);
		if (entries.isEmpty()) {
			return;
		}

		Collection<Document> documents = new ArrayList<Document>();

		for (kunde entry : entries) {
			Document document = getDocument(entry);

			documents.add(document);
		}

		SearchEngineUtil.updateDocuments(
			getSearchEngineId(), companyId, documents);
	}	

	private static final boolean _FILTER_SEARCH = true;

	private static final boolean _PERMISSION_AWARE = true;
}
