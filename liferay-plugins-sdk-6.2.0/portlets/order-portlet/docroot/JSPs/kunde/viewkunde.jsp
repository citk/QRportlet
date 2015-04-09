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
<%@ page import="org.xmlportletfactory.example01.order.model.kunde" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntry" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="javax.script.ScriptEngine" %>
<%@ page import="javax.script.ScriptEngineManager" %>	


<jsp:useBean class="java.lang.String" id="editkundeURL" scope="request" />
<jsp:useBean id="kunde" type="org.xmlportletfactory.example01.order.model.kunde" scope="request"/>


<portlet:defineObjects />



<portlet:renderURL var="redirect"></portlet:renderURL>

<div class="entry">




			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="kunde-kundedescription" />
				</label>
				<span class="aui-field-element">
					<%= kunde.getKundeDescription() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="kunde-userkunde" />
				</label>
				<span class="aui-field-element">
					<%= kunde.getUserKunde() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="kunde-userdocument" />
				</label>
				<span class="aui-field-element">
					<%= kunde.getUserDocument() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="kunde-usercity" />
				</label>
				<span class="aui-field-element">
					<%= kunde.getUserCity() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="kunde-useremail" />
				</label>
				<span class="aui-field-element">
					<%= kunde.getUserEmail() %>
				</span>
			</span>



</div>
