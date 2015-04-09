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
 
 

package org.xmlportletfactory.example01.order;

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

import org.xmlportletfactory.example01.order.model.kunde;
import org.xmlportletfactory.example01.order.model.impl.kundeImpl;
import org.xmlportletfactory.example01.order.service.kundeLocalServiceUtil;
import org.xmlportletfactory.example01.order.service.permission.kundePermission;
import org.xmlportletfactory.example01.order.service.permission.kundeEntryPermission;


import org.xmlportletfactory.example01.order.util.kundeUtil;

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
 * Portlet implementation class kunde
 */
public class kundePortlet extends MVCPortlet {


	private kundeUpload uploadManager;

	public void init() throws PortletException {

		// Edit Mode Pages
		editJSP = getInitParameter("edit-jsp");

		// Help Mode Pages
		helpJSP = getInitParameter("help-jsp");

		// View Mode Pages
		viewJSP = getInitParameter("view-jsp");

		// View Mode Edit kunde
		editkundeJSP = getInitParameter("edit-kunde-jsp");

		// View Mode Entry kunde
		viewkundeJSP = getInitParameter("view-kunde-jsp");
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
		} else if (jsp.equalsIgnoreCase("editkunde")) {
			try {
				showViewEditkunde(renderRequest, renderResponse);
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

		boolean hasAddPermission = kundePermission.contains(permissionChecker, groupId, "ADD_KUNDE");

		boolean hasModelPermissions = kundePermission.contains(permissionChecker, groupId, ActionKeys.PERMISSIONS);

		List<kunde> tempResults = Collections.EMPTY_LIST;

		PortletPreferences prefs = renderRequest.getPreferences();

		String kundeFilter = ParamUtil.getString(renderRequest, "kundeFilter");

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

		if (Validator.isNotNull(kundeFilter) || !kundeFilter.equalsIgnoreCase("")) {
			rowsPerPage = "100";
			cur = 1;
		}

		containerStart = (cur - 1) * Integer.parseInt(rowsPerPage);
		containerEnd = containerStart + Integer.parseInt(rowsPerPage);

		int total = 0;
		try {
			PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			if (Validator.isNull(orderByCol) && Validator.isNull(orderByType)) {
				orderByCol = portalPrefs.getValue("kunde_order", "kunde-order-by-col", "kundeId");
				orderByType = portalPrefs.getValue("kunde_order", "kunde-order-by-type", "asc");
			}
			OrderByComparator comparator = kundeComparator.getkundeOrderByComparator(orderByCol,orderByType);


			if (kundeFilter.equalsIgnoreCase("")) {

				if (viewType.equals("0")){
					tempResults = kundeLocalServiceUtil.findAllInGroup(groupId, containerStart, containerEnd, comparator);
					total = kundeLocalServiceUtil.countAllInGroup(groupId);								
				}else if (viewType.equals("1")){
					tempResults = kundeLocalServiceUtil.findAllInUser(themeDisplay.getUserId(), containerStart, containerEnd, comparator);
					total = kundeLocalServiceUtil.countAllInUser(themeDisplay.getUserId());
				}else{
					tempResults = kundeLocalServiceUtil.findAllInUserAndGroup(themeDisplay.getUserId(), groupId, containerStart, containerEnd, comparator);
					total = kundeLocalServiceUtil.countAllInUserAndGroup(themeDisplay.getUserId(), groupId);
				}

			} else {

				Indexer indexer = IndexerRegistryUtil.getIndexer(kunde.class);

				SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));

				searchContext.setEnd(containerEnd);
				searchContext.setKeywords(kundeFilter);
				searchContext.setStart(containerStart);

				Hits results = indexer.search(searchContext);

				total = results.getLength();

				if (total > 0) {
					tempResults = new ArrayList<kunde>(total);
				}
				for (int i = 0; i < results.getDocs().length; i++) {
					Document doc = results.doc(i);

					kunde resReg = null;

					// Entry
					long entryId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

					try {
						resReg = kundeLocalServiceUtil.getkunde(entryId);

						resReg = resReg.toEscapedModel();

						tempResults.add(resReg);
					}
					catch (Exception e) {
						if (_log.isWarnEnabled()) {
							_log.warn("kunde search index is stale and contains entry " + entryId);
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
		renderRequest.setAttribute("kundeFilter", kundeFilter);

		PortletURL addkundeURL = renderResponse.createActionURL();
		addkundeURL.setParameter("javax.portlet.action", "newkunde");
		renderRequest.setAttribute("addkundeURL", addkundeURL.toString());

		PortletURL kundeFilterURL = renderResponse.createRenderURL();
		kundeFilterURL.setParameter("javax.portlet.action", "doView");
		renderRequest.setAttribute("kundeFilterURL", kundeFilterURL.toString());

		include(viewJSP, renderRequest, renderResponse);
	}

	public void showViewEditkunde(RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		PortletURL editkundeURL = renderResponse.createActionURL();
		String editType = (String) renderRequest.getParameter("editType");

		kunde kunde = null;
		boolean viewEntryMode=false;
		if (editType.equalsIgnoreCase("edit")) {
			
			editkundeURL.setParameter("javax.portlet.action", "updatekunde");

			long $fname = Long.parseLong(renderRequest.getParameter("kundeId"));
			kunde = kundeLocalServiceUtil.getkunde($fname);

			if (!kundeEntryPermission.contains(
				permissionChecker, kunde, ActionKeys.UPDATE)){							
				SessionErrors.add(renderRequest, "permission-error");
				return;
	     		}

		    	String folderDLId = kunde.getFolderDLId()+"";
			renderRequest.setAttribute("folderDLId", folderDLId);
            	     	renderRequest.setAttribute("kunde", kunde);
		} else if (editType.equalsIgnoreCase("view")) {

			viewEntryMode= true;

			long $fname = Long.parseLong(renderRequest.getParameter("kundeId"));
			kunde = kundeLocalServiceUtil.getkunde($fname);


			if (!kundeEntryPermission.contains(
				permissionChecker, kunde, ActionKeys.VIEW)){							
				SessionErrors.add(renderRequest, "permission-error");
				return;
	     		}
			
			renderRequest.setAttribute("kunde", kunde);
		} else {

			if (!kundePermission.contains(
					permissionChecker, themeDisplay.getScopeGroupId(), "ADD_KUNDE")){	
						SessionErrors.add(renderRequest, "permission-error");
						return;
	    		}

			editkundeURL.setParameter("javax.portlet.action", "addkunde");
			kunde errorkunde = (kunde) renderRequest.getAttribute("errorkunde");
			if (errorkunde != null) {
				if (editType.equalsIgnoreCase("update")) {
					editkundeURL.setParameter("javax.portlet.action", "updatekunde");
                		}
				renderRequest.setAttribute("kunde", errorkunde);

		        	String folderDLId = errorkunde.getFolderDLId()+"";
				renderRequest.setAttribute("folderDLId",folderDLId);
			} else {				
				
				kunde addkunde = null;


				if (Validator.isNull(renderRequest.getParameter("addErrors"))){
				
					addkunde = new kundeImpl();
					addkunde.setKundeId(0);
					addkunde.setKundeDescription("");
					addkunde.setUserKunde("");
					addkunde.setUserCity("");
					addkunde.setUserEmail("");
				}else{
					addkunde = kundeFromRequest(renderRequest);
				}
				renderRequest.setAttribute("kunde", addkunde);
			}

		}		

        renderRequest.setAttribute("editType", editType);

		if (!viewEntryMode){
			renderRequest.setAttribute("editkundeURL", editkundeURL.toString());		
			include(editkundeJSP, renderRequest, renderResponse);
		}else{
			include(viewkundeJSP, renderRequest, renderResponse);
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

	@ProcessAction(name = "newkunde")
	public void newkunde(ActionRequest request, ActionResponse response) throws Exception{
		kundeUtil.addParametersForAdd(response);
	}

	@ProcessAction(name = "addkunde")
	public void addkunde(ActionRequest request, ActionResponse response) throws Exception {
            boolean isMultipart = PortletFileUpload.isMultipartContent(request);
            if (isMultipart) {
            	uploadManager = new kundeUpload();
				request = extractFields(request,false);
            }
            kunde kunde = kundeFromRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

	    if (!kundePermission.contains(
					permissionChecker, themeDisplay.getScopeGroupId(), "ADD_KUNDE")){	
				kundeUtil.addParametersForDefaultView(response);						
				SessionErrors.add(request, "permission-error");
				return;
	    }
            ArrayList<String> errors = kundeValidator.validatekunde(kunde, request);

            if (errors.isEmpty()) {
	            kunde = uploadManager.uploadFiles(request,kunde);
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(kunde.class.getName(), request);
			kundeLocalServiceUtil.addkunde(kunde, serviceContext);

			kundeUtil.addParametersForDefaultView(response);
                	SessionMessages.add(request, "kunde-added-successfully");

            	} catch (Exception cvex) {
            		SessionErrors.add(request, "please-enter-a-unique-code");
			PortalUtil.copyRequestParameters(request, response);			
			kundeUtil.addParametersForAddWithErrors(response);		
            	}
            } else {
                for (String error : errors) {
                        SessionErrors.add(request, error);
                }
		PortalUtil.copyRequestParameters(request, response);			
		kundeUtil.addParametersForAddWithErrors(response);	
            }
	}

	@ProcessAction(name = "eventkunde")
	public void eventkunde(ActionRequest request, ActionResponse response)
			throws Exception {
		long key = ParamUtil.getLong(request, "resourcePrimKey");
		int containerStart = ParamUtil.getInteger(request, "containerStart");
		int containerEnd = ParamUtil.getInteger(request, "containerEnd");
		int cur = ParamUtil.getInteger(request, "cur");
		String orderByType = ParamUtil.getString(request, "orderByType");
		String orderByCol = ParamUtil.getString(request, "orderByCol");
		String kundeFilter = ParamUtil.getString(request, "kundeFilter");
		if (Validator.isNotNull(key)) {
            		response.setRenderParameter("highlightRowWithKey", Long.toString(key));
            		response.setRenderParameter("containerStart", Integer.toString(containerStart));
            		response.setRenderParameter("containerEnd", Integer.toString(containerEnd));
			response.setRenderParameter("cur", Integer.toString(cur));
			response.setRenderParameter("orderByType", orderByType);
			response.setRenderParameter("orderByCol", orderByCol);
			response.setRenderParameter("kundeFilter", kundeFilter);
		}
	}

	@ProcessAction(name = "editkunde")

	public void editkunde(ActionRequest request, ActionResponse response)
			throws Exception {
		long key = ParamUtil.getLong(request, "resourcePrimKey");
		if (Validator.isNotNull(key)) {
			kundeUtil.addParametersForEdit(response, key);
			
		}
	}

	@ProcessAction(name = "deletekunde")
	public void deletekunde(ActionRequest request, ActionResponse response)throws Exception {		

		long id = ParamUtil.getLong(request, "resourcePrimKey");

		if (Validator.isNotNull(id)) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

			if (!kundeEntryPermission.contains(
					permissionChecker, id, ActionKeys.DELETE)){	
				kundeUtil.addParametersForDefaultView(response);						
				SessionErrors.add(request, "permission-error");
				return;
			}

			kunde kunde = kundeLocalServiceUtil.getkunde(id);
			kundeLocalServiceUtil.deletekundeEntry(kunde);
			SessionMessages.add(request, "kunde-deleted-successfully");
            		response.setRenderParameter("kundeId", "0");
		} else {
			SessionErrors.add(request, "kunde-error-deleting");
		}
	}


	@ProcessAction(name = "updatekunde")
	public void updatekunde(ActionRequest request, ActionResponse response) throws Exception {
            boolean isMultipart = PortletFileUpload.isMultipartContent(request);
            if (isMultipart) {
				uploadManager = new kundeUpload();
				request = extractFields(request,true);
            }
            kunde kunde = kundeFromRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

	    if (!kundeEntryPermission.contains(
				permissionChecker, kunde, ActionKeys.UPDATE)){	
				kundeUtil.addParametersForDefaultView(response);						
				SessionErrors.add(request, "permission-error");
				return;
	     }

            ArrayList<String> errors = kundeValidator.validatekunde(kunde, request);

		    kunde = uploadManager.uploadFiles(request, kunde);
            if (errors.isEmpty()) {
            	try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(kunde.class.getName(), request);
                	kundeLocalServiceUtil.updatekunde(kunde, serviceContext);

			kundeUtil.addParametersForDefaultView(response);
                	SessionMessages.add(request, "kunde-updated-successfully");

            	} catch (Exception cvex) {
            	    SessionErrors.add(request, "please-enter-a-unique-code");
		    		kundeUtil.addParametersForEdit(response, null);
					request.setAttribute("kunde",kunde);
            	}
            } else {
                for (String error : errors) {
                        SessionErrors.add(request, error);
                }
				kundeUtil.addParametersForEdit(response, Long.toString(kunde.getPrimaryKey()));
				request.setAttribute("kunde",kunde);
            }
        }

	@ProcessAction(name = "setkundePref")
	public void setkundePref(ActionRequest request, ActionResponse response) throws Exception {

		String rowsPerPage = ParamUtil.getString(request, "rows-per-page");
		String viewType = ParamUtil.getString(request, "view-type");
		String dateFormat = ParamUtil.getString(request, "date-format");
		String datetimeFormat = ParamUtil.getString(request, "datetime-format");

		ArrayList<String> errors = new ArrayList();
		if (kundeValidator.validateEditkunde(rowsPerPage, dateFormat, datetimeFormat, errors)) {
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

	private kunde kundeFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		kundeImpl kunde = new kundeImpl();
        	try {
		    	kunde.setKundeId(Long.valueOf(request.getAttribute("kundeId").toString()));
        	} catch (Exception nfe) {
		    //Controled en Validator
        	}
		kunde.setKundeDescription(request.getAttribute("kundeDescription").toString());
		kunde.setUserKunde(request.getAttribute("userKunde").toString());
		kunde.setUserCity(request.getAttribute("userCity").toString());
		kunde.setUserEmail(request.getAttribute("userEmail").toString());
		try {
			kunde.setPrimaryKey(Long.valueOf(request.getAttribute("resourcePrimKey").toString()));
		} catch (NumberFormatException nfe) {
			//Controled en Validator
        	}

		kunde.setCompanyId(themeDisplay.getCompanyId());
		kunde.setGroupId(themeDisplay.getScopeGroupId());
		kunde.setUserId(themeDisplay.getUserId());
		return kunde;
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
					if(formField.startsWith(kundeUpload.HIDDEN)) {
						uploadManager.addHidden(formField,Long.parseLong(item.getString()));
					} else if (formField.endsWith(kundeUpload.DOCUMENT_DELETE)) {
						int pos = formField.indexOf(kundeUpload.DOCUMENT_DELETE);
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

			if(resourceId.equalsIgnoreCase("exportFullkundeResourceURL")) {

		    		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		    		Locale locale = themeDisplay.getLocale();
		    		PortletConfig portletConfig = (PortletConfig)resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		    		resourceResponse.setContentType("application/vnd.ms-excel");
		    		resourceResponse.setProperty("expires","-1d");
		    		resourceResponse.setProperty("Pragma","no-cache");
		    		resourceResponse.setProperty("Cache-control","no-cache");
				resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\" kunde\"");

				try {
					Workbook book = kundeExporter.generateFullExcel(themeDisplay.getScopeGroupId(), portletConfig, locale);
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

	protected String editkundeJSP;
	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;
	protected String viewkundeJSP;

	private static Log _log = LogFactoryUtil.getLog(kundePortlet.class);

}
