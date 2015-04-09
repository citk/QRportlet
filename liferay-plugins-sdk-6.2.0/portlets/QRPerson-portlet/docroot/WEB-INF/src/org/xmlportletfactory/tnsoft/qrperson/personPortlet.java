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
 
 

package org.xmlportletfactory.tnsoft.qrperson;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletConfig;
import javax.xml.namespace.QName;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.poi.ss.usermodel.Workbook;
import com.liferay.portal.kernel.servlet.HttpHeaders;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import org.xmlportletfactory.tnsoft.qrperson.model.person;
import org.xmlportletfactory.tnsoft.qrperson.model.impl.personImpl;
import org.xmlportletfactory.tnsoft.qrperson.service.personLocalServiceUtil;
import org.xmlportletfactory.tnsoft.qrperson.service.permission.personPermission;
import org.xmlportletfactory.tnsoft.qrperson.service.permission.personEntryPermission;


import org.xmlportletfactory.tnsoft.qrperson.util.personUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


/**
 * Portlet implementation class person
 */
public class personPortlet extends MVCPortlet {


	private personUpload uploadManager;

	public void init() throws PortletException {

		// Edit Mode Pages
		editJSP = getInitParameter("edit-jsp");

		// Help Mode Pages
		helpJSP = getInitParameter("help-jsp");

		// View Mode Pages
		viewJSP = getInitParameter("view-jsp");

		// View Mode Edit person
		editQRPersonJSP = getInitParameter("edit-QRPerson-jsp");

		// View Mode Entry person
		viewQRPersonJSP = getInitParameter("view-QRPerson-jsp");
	}

	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			// do nothing
			// _log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String jsp = (String) renderRequest.getParameter("view");
		if (jsp == null || jsp.equals("")) {
			showViewDefault(renderRequest, renderResponse);
		} else if (jsp.equalsIgnoreCase("editperson")) {
			try {
				showViewEditperson(renderRequest, renderResponse);
			} catch (Exception ex) {
				_log.debug(ex);
				try {
					showViewDefault(renderRequest, renderResponse);
				} catch (Exception ex1) {
					_log.debug(ex1);
				}
			}
		}
	}

	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		showEditDefault(renderRequest, renderResponse);
	}

	public void doHelp(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		include(helpJSP, renderRequest, renderResponse);
	}

	@SuppressWarnings("unchecked")
	public void showViewDefault(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();

		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

		boolean hasAddPermission = personPermission.contains(permissionChecker, groupId, "ADD_PERSON");

		boolean hasModelPermissions = personPermission.contains(permissionChecker, groupId, ActionKeys.PERMISSIONS);

		List<person> tempResults = Collections.EMPTY_LIST;

		PortletPreferences prefs = renderRequest.getPreferences();

		String QRPersonFilter = ParamUtil.getString(renderRequest, "QRPersonFilter");

		String rowsPerPage = prefs.getValue("rows-per-page","5");
		String viewType = prefs.getValue("view-type", "0");

		Integer cur = 1;
		int containerStart = 0;
		int containerEnd = 0;
		String orderByType = renderRequest.getParameter("orderByType");
		String orderByCol = renderRequest.getParameter("orderByCol");
		try{
			cur = ParamUtil.getInteger(renderRequest, "cur");

		}catch (Exception e){
			cur = 1;
		}

		if (cur < 1){
			cur = 1;
		}

		if (Validator.isNotNull(QRPersonFilter) || !QRPersonFilter.equalsIgnoreCase("")) {
			rowsPerPage = "100";
			cur = 1;
		}

		containerStart = (cur - 1) * Integer.parseInt(rowsPerPage);
		containerEnd = containerStart + Integer.parseInt(rowsPerPage);

		int total = 0;
		try {
			PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			if (Validator.isNull(orderByCol) && Validator.isNull(orderByType)) {
				orderByCol = portalPrefs.getValue("person_order", "person-order-by-col", "kundeId");
				orderByType = portalPrefs.getValue("person_order", "person-order-by-type", "asc");
			}
			OrderByComparator comparator = personComparator.getpersonOrderByComparator(orderByCol,orderByType);


			if (QRPersonFilter.equalsIgnoreCase("")) {

				if (viewType.equals("0")){
					tempResults = personLocalServiceUtil.findAllInGroup(groupId, containerStart, containerEnd, comparator);
					total = personLocalServiceUtil.countAllInGroup(groupId);								
				}else if (viewType.equals("1")){
					tempResults = personLocalServiceUtil.findAllInUser(themeDisplay.getUserId(), containerStart, containerEnd, comparator);
					total = personLocalServiceUtil.countAllInUser(themeDisplay.getUserId());
				}else{
					tempResults = personLocalServiceUtil.findAllInUserAndGroup(themeDisplay.getUserId(), groupId, containerStart, containerEnd, comparator);
					total = personLocalServiceUtil.countAllInUserAndGroup(themeDisplay.getUserId(), groupId);
				}

			} else {

				Indexer indexer = IndexerRegistryUtil.getIndexer(person.class);

				SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));

				searchContext.setEnd(containerEnd);
				searchContext.setKeywords(QRPersonFilter);
				searchContext.setStart(containerStart);

				Hits results = indexer.search(searchContext);

				total = results.getLength();

				if (total > 0) {
					tempResults = new ArrayList<person>(total);
				}
				for (int i = 0; i < results.getDocs().length; i++) {
					Document doc = results.doc(i);

					person resReg = null;

					// Entry
					long entryId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

					try {
						resReg = personLocalServiceUtil.getperson(entryId);

						resReg = resReg.toEscapedModel();

						tempResults.add(resReg);
					}
					catch (Exception e) {
						if (_log.isWarnEnabled()) {
							_log.warn("person search index is stale and contains entry " + entryId);
						}

						continue;
					}
				}
			}

		} catch (Exception e) {
			_log.debug(e);
		}
		renderRequest.setAttribute("highlightRowWithKey", renderRequest.getParameter("highlightRowWithKey"));
		renderRequest.setAttribute("containerStart", containerStart);
		renderRequest.setAttribute("containerEnd", containerEnd);
		renderRequest.setAttribute("cur", cur);
		renderRequest.setAttribute("tempResults", tempResults);
		renderRequest.setAttribute("totalCount", total);
		renderRequest.setAttribute("rowsPerPage", rowsPerPage);
		renderRequest.setAttribute("hasAddPermission", hasAddPermission);
		renderRequest.setAttribute("hasModelPermissions", hasModelPermissions);
		renderRequest.setAttribute("orderByType", orderByType);
		renderRequest.setAttribute("orderByCol", orderByCol);		
		renderRequest.setAttribute("QRPersonFilter", QRPersonFilter);

		PortletURL addpersonURL = renderResponse.createActionURL();
		addpersonURL.setParameter("javax.portlet.action", "newperson");
		renderRequest.setAttribute("addpersonURL", addpersonURL.toString());

		PortletURL QRPersonFilterURL = renderResponse.createRenderURL();
		QRPersonFilterURL.setParameter("javax.portlet.action", "doView");
		renderRequest.setAttribute("QRPersonFilterURL", QRPersonFilterURL.toString());

		include(viewJSP, renderRequest, renderResponse);
	}

	public void showViewEditperson(RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		PortletURL editpersonURL = renderResponse.createActionURL();
		String editType = (String) renderRequest.getParameter("editType");

		person person = null;
		boolean viewEntryMode=false;
		if (editType.equalsIgnoreCase("edit")) {
			
			editpersonURL.setParameter("javax.portlet.action", "updateperson");

			long $fname = Long.parseLong(renderRequest.getParameter("kundeId"));
			person = personLocalServiceUtil.getperson($fname);

			if (!personEntryPermission.contains(
				permissionChecker, person, ActionKeys.UPDATE)){							
				SessionErrors.add(renderRequest, "permission-error");
				return;
	     		}

		    	String folderDLId = person.getFolderDLId()+"";
			renderRequest.setAttribute("folderDLId", folderDLId);
            	     	renderRequest.setAttribute("person", person);
		} else if (editType.equalsIgnoreCase("view")) {

			viewEntryMode= true;

			long $fname = Long.parseLong(renderRequest.getParameter("kundeId"));
			person = personLocalServiceUtil.getperson($fname);


			if (!personEntryPermission.contains(
				permissionChecker, person, ActionKeys.VIEW)){							
				SessionErrors.add(renderRequest, "permission-error");
				return;
	     		}
			
			renderRequest.setAttribute("person", person);
		} else {

			if (!personPermission.contains(
					permissionChecker, themeDisplay.getScopeGroupId(), "ADD_PERSON")){	
						SessionErrors.add(renderRequest, "permission-error");
						return;
	    		}

			editpersonURL.setParameter("javax.portlet.action", "addperson");
			person errorperson = (person) renderRequest.getAttribute("errorperson");
			if (errorperson != null) {
				if (editType.equalsIgnoreCase("update")) {
					editpersonURL.setParameter("javax.portlet.action", "updateperson");
                		}
				renderRequest.setAttribute("person", errorperson);

		        	String folderDLId = errorperson.getFolderDLId()+"";
				renderRequest.setAttribute("folderDLId",folderDLId);
			} else {				
				
				person addperson = null;


				if (Validator.isNull(renderRequest.getParameter("addErrors"))){
				
					addperson = new personImpl();
					addperson.setKundeId(0);
					addperson.setFirstname("");
					addperson.setMiddlename("");
					addperson.setLastname("");
					addperson.setKundeDescription("");
					addperson.setCity("");
					addperson.setUserEmail("");
				}else{
					addperson = personFromRequest(renderRequest);
				}
				renderRequest.setAttribute("person", addperson);
			}

		}		

        renderRequest.setAttribute("editType", editType);

		if (!viewEntryMode){
			renderRequest.setAttribute("editpersonURL", editpersonURL.toString());		
			include(editQRPersonJSP, renderRequest, renderResponse);
		}else{
			include(viewQRPersonJSP, renderRequest, renderResponse);
		}
	}

	private String dateToJsp(ActionRequest request, Date date) {
		PortletPreferences prefs = request.getPreferences();
		return dateToJsp(prefs, date);
	}
	private String dateToJsp(RenderRequest request, Date date) {
		PortletPreferences prefs = request.getPreferences();
		return dateToJsp(prefs, date);
	}
	private String dateToJsp(PortletPreferences prefs, Date date) {
		SimpleDateFormat format = new SimpleDateFormat(prefs.getValue("date-format", "yyyy/MM/dd"));
		String stringDate = format.format(date);
		return stringDate;
	}
	private String dateTimeToJsp(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String stringDate = format.format(date);
		return stringDate;
	}

	public void showEditDefault(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		include(editJSP, renderRequest, renderResponse);
	}

	/* Portlet Actions */

	@ProcessAction(name = "newperson")
	public void newperson(ActionRequest request, ActionResponse response) throws Exception{
		personUtil.addParametersForAdd(response);
	}

	@ProcessAction(name = "addperson")
	public void addperson(ActionRequest request, ActionResponse response) throws Exception {
            boolean isMultipart = PortletFileUpload.isMultipartContent(request);
            if (isMultipart) {
            	uploadManager = new personUpload();
				request = extractFields(request,false);
            }
            person person = personFromRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

	    if (!personPermission.contains(
					permissionChecker, themeDisplay.getScopeGroupId(), "ADD_PERSON")){	
				personUtil.addParametersForDefaultView(response);						
				SessionErrors.add(request, "permission-error");
				return;
	    }
            ArrayList<String> errors = personValidator.validateperson(person, request);

            if (errors.isEmpty()) {
	            person = uploadManager.uploadFiles(request,person);
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(person.class.getName(), request);
			personLocalServiceUtil.addperson(person, serviceContext);

			personUtil.addParametersForDefaultView(response);
                	SessionMessages.add(request, "qrperson-added-successfully");

            	} catch (Exception cvex) {
            		SessionErrors.add(request, "please-enter-a-unique-code");
			PortalUtil.copyRequestParameters(request, response);			
			personUtil.addParametersForAddWithErrors(response);		
            	}
            } else {
                for (String error : errors) {
                        SessionErrors.add(request, error);
                }
		PortalUtil.copyRequestParameters(request, response);			
		personUtil.addParametersForAddWithErrors(response);	
            }
	}

	@ProcessAction(name = "eventperson")
	public void eventperson(ActionRequest request, ActionResponse response)
			throws Exception {
		long key = ParamUtil.getLong(request, "resourcePrimKey");
		int containerStart = ParamUtil.getInteger(request, "containerStart");
		int containerEnd = ParamUtil.getInteger(request, "containerEnd");
		int cur = ParamUtil.getInteger(request, "cur");
		String orderByType = ParamUtil.getString(request, "orderByType");
		String orderByCol = ParamUtil.getString(request, "orderByCol");
		String personFilter = ParamUtil.getString(request, "personFilter");
		if (Validator.isNotNull(key)) {
            		response.setRenderParameter("highlightRowWithKey", Long.toString(key));
            		response.setRenderParameter("containerStart", Integer.toString(containerStart));
            		response.setRenderParameter("containerEnd", Integer.toString(containerEnd));
			response.setRenderParameter("cur", Integer.toString(cur));
			response.setRenderParameter("orderByType", orderByType);
			response.setRenderParameter("orderByCol", orderByCol);
			response.setRenderParameter("personFilter", personFilter);
		}
	}

	@ProcessAction(name = "editperson")

	public void editperson(ActionRequest request, ActionResponse response)
			throws Exception {
		long key = ParamUtil.getLong(request, "resourcePrimKey");
		if (Validator.isNotNull(key)) {
			personUtil.addParametersForEdit(response, key);
			
		}
	}

	@ProcessAction(name = "deleteperson")
	public void deleteperson(ActionRequest request, ActionResponse response)throws Exception {		

		long id = ParamUtil.getLong(request, "resourcePrimKey");

		if (Validator.isNotNull(id)) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

			if (!personEntryPermission.contains(
					permissionChecker, id, ActionKeys.DELETE)){	
				personUtil.addParametersForDefaultView(response);						
				SessionErrors.add(request, "permission-error");
				return;
			}

			person person = personLocalServiceUtil.getperson(id);
			personLocalServiceUtil.deletepersonEntry(person);
			SessionMessages.add(request, "qrperson-deleted-successfully");
            		response.setRenderParameter("kundeId", "0");
		} else {
			SessionErrors.add(request, "qrperson-error-deleting");
		}
	}


	@ProcessAction(name = "updateperson")
	public void updateperson(ActionRequest request, ActionResponse response) throws Exception {
            boolean isMultipart = PortletFileUpload.isMultipartContent(request);
            if (isMultipart) {
				uploadManager = new personUpload();
				request = extractFields(request,true);
            }
            person person = personFromRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

	    if (!personEntryPermission.contains(
				permissionChecker, person, ActionKeys.UPDATE)){	
				personUtil.addParametersForDefaultView(response);						
				SessionErrors.add(request, "permission-error");
				return;
	     }

            ArrayList<String> errors = personValidator.validateperson(person, request);

		    person = uploadManager.uploadFiles(request, person);
            if (errors.isEmpty()) {
            	try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(person.class.getName(), request);
                	personLocalServiceUtil.updateperson(person, serviceContext);

			personUtil.addParametersForDefaultView(response);
                	SessionMessages.add(request, "qrperson-updated-successfully");

            	} catch (Exception cvex) {
            	    SessionErrors.add(request, "please-enter-a-unique-code");
		    		personUtil.addParametersForEdit(response, null);
					request.setAttribute("person",person);
            	}
            } else {
                for (String error : errors) {
                        SessionErrors.add(request, error);
                }
				personUtil.addParametersForEdit(response, Long.toString(person.getPrimaryKey()));
				request.setAttribute("person",person);
            }
        }

	@ProcessAction(name = "setpersonPref")
	public void setpersonPref(ActionRequest request, ActionResponse response) throws Exception {

		String rowsPerPage = ParamUtil.getString(request, "rows-per-page");
		String viewType = ParamUtil.getString(request, "view-type");
		String dateFormat = ParamUtil.getString(request, "date-format");
		String datetimeFormat = ParamUtil.getString(request, "datetime-format");

		ArrayList<String> errors = new ArrayList();
		if (personValidator.validateEditperson(rowsPerPage, dateFormat, datetimeFormat, errors)) {
			response.setRenderParameter("rows-per-page", "");
			response.setRenderParameter("date-format", "");
			response.setRenderParameter("datetime-format", "");
			response.setRenderParameter("view-type", "");

			PortletPreferences prefs = request.getPreferences();

			prefs.setValue("rows-per-page", rowsPerPage);
			prefs.setValue("view-type", viewType);
			prefs.setValue("date-format", dateFormat);
			prefs.setValue("datetime-format", datetimeFormat);
			prefs.store();

			SessionMessages.add(request, "prefs-success");
		}
	}

	private person personFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		personImpl person = new personImpl();
        	try {
		    	person.setKundeId(Long.valueOf(request.getAttribute("kundeId").toString()));
        	} catch (Exception nfe) {
		    //Controled en Validator
        	}
		person.setFirstname(request.getAttribute("Firstname").toString());
		person.setMiddlename(request.getAttribute("Middlename").toString());
		person.setLastname(request.getAttribute("Lastname").toString());
		person.setKundeDescription(request.getAttribute("kundeDescription").toString());
		person.setCity(request.getAttribute("City").toString());
		person.setUserEmail(request.getAttribute("userEmail").toString());
		try {
			person.setPrimaryKey(Long.valueOf(request.getAttribute("resourcePrimKey").toString()));
		} catch (NumberFormatException nfe) {
			//Controled en Validator
        	}

		person.setCompanyId(themeDisplay.getCompanyId());
		person.setGroupId(themeDisplay.getScopeGroupId());
		person.setUserId(themeDisplay.getUserId());
		return person;
	}

	private ActionRequest extractFields(ActionRequest request,boolean edit) throws FileUploadException{

		FileItemFactory factory = new DiskFileItemFactory();
        	PortletFileUpload uploadItems = new PortletFileUpload(factory);
        	List <FileItem>allItems = uploadItems.parseRequest(request);
         	//Separate formFields <-> fileItems
         	for(FileItem item : allItems){
         		String formField = item.getFieldName();
         		if (item.isFormField()) {
         			//Non-file items
         			//Push all to request object
					String portletName = "_"+request.getAttribute(WebKeys.PORTLET_ID)+"_";
					if(formField.startsWith(personUpload.HIDDEN)) {
						uploadManager.addHidden(formField,Long.parseLong(item.getString()));
					} else if (formField.endsWith(personUpload.DOCUMENT_DELETE)) {
						int pos = formField.indexOf(personUpload.DOCUMENT_DELETE);
						formField = formField.substring(0,pos-1);
						formField = formField.replaceAll(portletName, "");
						if(item.getString().equals("true")) uploadManager.addDeleted(formField);
					} else {
						formField=formField.replaceAll(portletName, "");
						try {
					    	request.setAttribute(formField,item.getString("UTF-8").trim());
						} catch (Exception e) {
						}
					}
         		} else {

         			uploadManager.add(item);
         		}
         	}
		return request;
	}


	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		resourceResponse.setContentType("text/javascript");
		String resourceId = resourceRequest.getResourceID();

		if (Validator.isNotNull(resourceId) && resourceId.length() != 0) {

			if(resourceId.equalsIgnoreCase("exportFullpersonResourceURL")) {

		    		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		    		Locale locale = themeDisplay.getLocale();
		    		PortletConfig portletConfig = (PortletConfig)resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		    		resourceResponse.setContentType("application/vnd.ms-excel");
		    		resourceResponse.setProperty("expires","-1d");
		    		resourceResponse.setProperty("Pragma","no-cache");
		    		resourceResponse.setProperty("Cache-control","no-cache");
				resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\" person\"");

				try {
					Workbook book = personExporter.generateFullExcel(themeDisplay.getScopeGroupId(), portletConfig, locale);
					OutputStream out = resourceResponse.getPortletOutputStream();
					book.write(out);
					out.flush();
					out.close();
				} catch (SystemException e) {
					e.printStackTrace();
					throw new PortletException("Export Excel Error",e);
				}
			}

		}
	}

	protected String editQRPersonJSP;
	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;
	protected String viewQRPersonJSP;

	private static Log _log = LogFactoryUtil.getLog(personPortlet.class);

}
