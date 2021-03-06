<%
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
%> 
<%@include file="../init.jsp" %>

<%@ page import="org.xmlportletfactory.tnsoft.qrperson.model.person" %>
<%@ page import="org.xmlportletfactory.tnsoft.qrperson.service.personLocalServiceUtil" %>

<%@ page import="com.liferay.portlet.PortalPreferences" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="org.xmlportletfactory.tnsoft.qrperson.personComparator" %>
<%@ page import="javax.script.ScriptEngine" %>
<%@ page import="javax.script.ScriptEngineManager" %>


<jsp:useBean id="addpersonURL" class="java.lang.String" scope="request" />
<jsp:useBean id="QRPersonFilterURL" class="java.lang.String" scope="request" />
<jsp:useBean id="QRPersonFilter" class="java.lang.String" scope="request" />
<liferay-ui:success key="prefs-success" message="prefs-success" />
<liferay-ui:success key="qrperson-added-successfully" message="qrperson-added-successfully" />
<liferay-ui:success key="qrperson-deleted-successfully" message="qrperson-deleted-successfully" />
<liferay-ui:success key="qrperson-updated-successfully" message="qrperson-updated-successfully" />
<liferay-ui:error key="qrperson-error-deleting" message="qrperson-error-deleting" />
<liferay-ui:error key="permission-error" message="permission-error" />


<aui:nav-bar>
	<aui:nav>		
<c:choose>
	<c:when test='<%= (Boolean)request.getAttribute("hasAddPermission") %>'>
		<aui:nav-item name="addQRPersonButton" href="<%=addpersonURL %>" label="qrperson-add"/>
	</c:when>
</c:choose>

<c:choose>
	<c:when test='<%= (Boolean)request.getAttribute("hasModelPermissions") %>'>
		<liferay-security:permissionsURL
			modelResource="org.xmlportletfactory.tnsoft.qrperson.person"
			modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
			resourcePrimKey="<%= String.valueOf(themeDisplay.getScopeGroupId()) %>"
			var="modelPermissionsURL"
		/>
		<aui:nav-item name="addQRPersonButton" href="<%= modelPermissionsURL %>" label="permissions"/>
	</c:when>
</c:choose>
	</aui:nav>

<aui:form name="QRPersonFilterForm" action="<%=QRPersonFilterURL %>" method="post">
	<aui:nav-bar-search cssClass="pull-right">
				<div class="form-search">
					<liferay-ui:input-search id="QRPersonFilter" name="QRPersonFilter" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
				</div>
	</aui:nav-bar-search>
</aui:form>
</aui:nav-bar>
<%
	String iconChecked = "checked";
	String iconUnchecked = "unchecked";
	int rows_per_page = Integer.parseInt((String)request.getAttribute("rowsPerPage"));

	SimpleDateFormat dateFormat = new SimpleDateFormat(prefs.getValue("date-format", "yyyy/MM/dd"));
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat(prefs.getValue("datetime-format","yyyy/MM/dd HH:mm"));

	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);

	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");

	if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
		portalPrefs.setValue("QRPerson_order", "QRPerson-order-by-col", orderByCol);
		portalPrefs.setValue("QRPerson_order", "QRPerson-order-by-type", orderByType);
	} else {
		orderByCol = portalPrefs.getValue("QRPerson_order", "QRPerson-order-by-col", "kundeId");
		orderByType = portalPrefs.getValue("QRPerson_order", "QRPerson-order-by-type", "asc");
	}

	List<person> tempResults = (List<person>)request.getAttribute("tempResults");
	Integer totalCount = (Integer)request.getAttribute("totalCount");

	int containerStart;
	int containerEnd;
	try {
		containerStart = ParamUtil.getInteger(request, "containerStart");
		containerEnd = ParamUtil.getInteger(request, "containerEnd");
	} catch (Exception e) {
		containerStart = 0;
		containerEnd = rows_per_page;
	}

%>
<liferay-ui:search-container deltaConfigurable="false" delta='<%= rows_per_page %>' emptyResultsMessage="qrperson-empty-results-message" orderByCol="<%= orderByCol%>" orderByType="<%= orderByType%>">
	<liferay-ui:search-container-results total="<%= totalCount %>" results="<%= tempResults %>">

		<%
		request.setAttribute("containerStart",String.valueOf(containerStart));
		request.setAttribute("containerEnd",String.valueOf(containerEnd));
		request.setAttribute("orderByCol", orderByCol);
		request.setAttribute("orderByType", orderByType);
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="org.xmlportletfactory.tnsoft.qrperson.model.person"
		keyProperty="kundeId"
		modelVar="person"
	>

		<liferay-ui:search-container-column-text
			name="firstname"
		    property="firstname"
			align="left"
		/>
		<liferay-ui:search-container-column-text
			name="middlename"
		    property="middlename"
			align="left"
		/>
		<liferay-ui:search-container-column-text
			name="lastname"
		    property="lastname"
			align="left"
		/>
		<liferay-ui:search-container-column-text
			name="kunde Description"
		    property="kundeDescription"
			align="left"
		/>
		<liferay-ui:search-container-column-text name="Document" align="center">
			<%
 				String userDocumentIcon = iconUnchecked;
				Long userDocument = person.getUserDocument();
				if (userDocument.compareTo(new Long(0))>0) {
 					userDocumentIcon= iconChecked;
 				}
 			  %>
 			  <liferay-ui:icon image="<%=userDocumentIcon %>"/>
 		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text
			name="City"
		    property="city"
			orderable="true"
			orderableProperty="City"
			align="left"
		/>
		<liferay-ui:search-container-column-text
			name="Email"
		    property="userEmail"
			align="left"
		/>
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/JSPs/QRPerson/edit_actions.jsp"
		/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
