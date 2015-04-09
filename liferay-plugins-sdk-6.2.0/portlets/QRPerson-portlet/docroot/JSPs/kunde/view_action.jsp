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

<%
String containerStart = (String) request.getAttribute("containerStart");
String containerEnd =  (String) request.getAttribute("containerEnd");
String orderByType = (String) request.getAttribute("orderByType");
String orderByCol =  (String) request.getAttribute("orderByCol");
Integer cur          =  (Integer) request.getAttribute("cur");
String personFilter = ParamUtil.getString(request, "personFilter");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
person person = (person)row.getObject();

long groupId = person.getGroupId();
String name = person.class.getName();
String primKey = String.valueOf(person.getPrimaryKey());

%>
<c:if test="<%= personEntryPermission.contains(permissionChecker, person, ActionKeys.UPDATE) %>">
    <portlet:actionURL name="eventperson" var="eventpersonURL">
        <portlet:param name="resourcePrimKey" value="<%=primKey %>" />
        <portlet:param name="containerStart" value="<%= containerStart %>" />
        <portlet:param name="containerEnd" value="<%= containerEnd %>" />
		<portlet:param name="cur" value="<%= String.valueOf(cur)  %>" />
        <portlet:param name="personFilter" value="<%= personFilter %>" />
    </portlet:actionURL>
<%
	if (primKey.equalsIgnoreCase((String)request.getAttribute("highlightRowWithKey"))) {
%>
    <liferay-ui:icon image="forward" url="<%=eventpersonURL.toString() %>" />
<%
	} else {
%>
    <liferay-ui:icon image="view" url="<%=eventpersonURL.toString() %>" />
<%
	}
%>
</c:if>
