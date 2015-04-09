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
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntry" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="javax.script.ScriptEngine" %>
<%@ page import="javax.script.ScriptEngineManager" %>	


<jsp:useBean class="java.lang.String" id="editpersonURL" scope="request" />
<jsp:useBean id="person" type="org.xmlportletfactory.tnsoft.qrperson.model.person" scope="request"/>


<portlet:defineObjects />



<portlet:renderURL var="redirect"></portlet:renderURL>

<div class="entry">




			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="kunde-firstname" />
				</label>
				<span class="aui-field-element">
					<%= person.getFirstname() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="kunde-middlename" />
				</label>
				<span class="aui-field-element">
					<%= person.getMiddlename() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="kunde-lastname" />
				</label>
				<span class="aui-field-element">
					<%= person.getLastname() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="kunde-kundedescription" />
				</label>
				<span class="aui-field-element">
					<%= person.getKundeDescription() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="kunde-userdocument" />
				</label>
				<span class="aui-field-element">
					<%= person.getUserDocument() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="kunde-city" />
				</label>
				<span class="aui-field-element">
					<%= person.getCity() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="kunde-useremail" />
				</label>
				<span class="aui-field-element">
					<%= person.getUserEmail() %>
				</span>
			</span>



</div>
