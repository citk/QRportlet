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

<%
String containerStart = (String) request.getAttribute("containerStart");
String containerEnd =  (String) request.getAttribute("containerEnd");
String orderByType = (String) request.getAttribute("orderByType");
String orderByCol =  (String) request.getAttribute("orderByCol");
Integer cur          =  (Integer) request.getAttribute("cur");
String kundeFilter = ParamUtil.getString(request, "kundeFilter");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
kunde kunde = (kunde)row.getObject();

long groupId = kunde.getGroupId();
String name = kunde.class.getName();
String primKey = String.valueOf(kunde.getPrimaryKey());

%>
<c:if test="<%= kundeEntryPermission.contains(permissionChecker, kunde, ActionKeys.UPDATE) %>">
    <portlet:actionURL name="eventkunde" var="eventkundeURL">
        <portlet:param name="resourcePrimKey" value="<%=primKey %>" />
        <portlet:param name="containerStart" value="<%= containerStart %>" />
        <portlet:param name="containerEnd" value="<%= containerEnd %>" />
		<portlet:param name="cur" value="<%= String.valueOf(cur)  %>" />
        <portlet:param name="kundeFilter" value="<%= kundeFilter %>" />
    </portlet:actionURL>
<%
	if (primKey.equalsIgnoreCase((String)request.getAttribute("highlightRowWithKey"))) {
%>
    <liferay-ui:icon image="forward" url="<%=eventkundeURL.toString() %>" />
<%
	} else {
%>
    <liferay-ui:icon image="view" url="<%=eventkundeURL.toString() %>" />
<%
	}
%>
</c:if>
