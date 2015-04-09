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

<%@ page import="org.xmlportletfactory.example01.order.model.kunde"%>
<%@ page import="org.xmlportletfactory.example01.order.service.kundeLocalServiceUtil"%>
<%@ page import="org.xmlportletfactory.example01.order.service.permission.kundeEntryPermission"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
kunde kunde = (kunde)row.getObject();

long groupId = kunde.getGroupId();
String name = kunde.class.getName();
String primKey = String.valueOf(kunde.getPrimaryKey());
boolean noDetailsRows = true;

%>
<liferay-ui:icon-menu cssClass="">

	<c:if test="<%= kundeEntryPermission.contains(permissionChecker, kunde, ActionKeys.UPDATE) %>">
		<portlet:actionURL name="editkunde" var="editkundeURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon image="edit" url="<%=editkundeURL.toString() %>" />
	</c:if>
	<c:if test="<%= kundeEntryPermission.contains (permissionChecker, kunde, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deletekunde" var="deletekundeURL">
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>
		<c:choose>
			<c:when test="<%= !noDetailsRows %>">
			<%
			String deleteUrl = null;
			deleteUrl = "javascript:if(confirm('" + UnicodeLanguageUtil.get(pageContext, "confirm-delete") + "')){submitForm(document.hrefFm, '" + HttpUtil.encodeURL(deletekundeURL) + "');}";
			 
			%>
			<liferay-ui:icon image="delete" url="<%=deleteUrl %>" />

			</c:when>
			<c:otherwise>
		    		<liferay-ui:icon image="delete" url="<%=deletekundeURL.toString() %>" />
		        </c:otherwise>
		</c:choose>
	</c:if>



<c:if test="<%= kundeEntryPermission.contains(permissionChecker, kunde, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="org.xmlportletfactory.example01.order.model.kunde"
			modelResourceDescription="kunde"
			resourcePrimKey="<%= String.valueOf(primKey) %>"
			var="permissionsEntryURL"
		/>

		<liferay-ui:icon
			image="permissions"
			url="<%= permissionsEntryURL %>"
		/>
</c:if>
</liferay-ui:icon-menu>
