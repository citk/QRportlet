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

<%@ page import="org.xmlportletfactory.tnsoft.qrperson.model.person"%>
<%@ page import="org.xmlportletfactory.tnsoft.qrperson.service.personLocalServiceUtil"%>
<%@ page import="org.xmlportletfactory.tnsoft.qrperson.service.permission.personEntryPermission"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
person person = (person)row.getObject();

long groupId = person.getGroupId();
String name = person.class.getName();
String primKey = String.valueOf(person.getPrimaryKey());
boolean noDetailsRows = true;

%>
<liferay-ui:icon-menu cssClass="">

	<c:if test="<%= personEntryPermission.contains(permissionChecker, person, ActionKeys.UPDATE) %>">
		<portlet:actionURL name="editperson" var="editpersonURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon image="edit" url="<%=editpersonURL.toString() %>" />
	</c:if>
	<c:if test="<%= personEntryPermission.contains (permissionChecker, person, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteperson" var="deletepersonURL">
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>
		<c:choose>
			<c:when test="<%= !noDetailsRows %>">
			<%
			String deleteUrl = null;
			deleteUrl = "javascript:if(confirm('" + UnicodeLanguageUtil.get(pageContext, "confirm-delete") + "')){submitForm(document.hrefFm, '" + HttpUtil.encodeURL(deletepersonURL) + "');}";
			 
			%>
			<liferay-ui:icon image="delete" url="<%=deleteUrl %>" />

			</c:when>
			<c:otherwise>
		    		<liferay-ui:icon image="delete" url="<%=deletepersonURL.toString() %>" />
		        </c:otherwise>
		</c:choose>
	</c:if>



<c:if test="<%= personEntryPermission.contains(permissionChecker, person, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="org.xmlportletfactory.tnsoft.qrperson.model.person"
			modelResourceDescription="person"
			resourcePrimKey="<%= String.valueOf(primKey) %>"
			var="permissionsEntryURL"
		/>

		<liferay-ui:icon
			image="permissions"
			url="<%= permissionsEntryURL %>"
		/>
</c:if>
</liferay-ui:icon-menu>
