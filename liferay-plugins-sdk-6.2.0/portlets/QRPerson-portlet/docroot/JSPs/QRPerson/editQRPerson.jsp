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
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.portal.portletfilerepository.PortletFileRepositoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.MimeTypesUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>



<jsp:useBean class="java.lang.String" id="editpersonURL" scope="request" />
<jsp:useBean id="person" type="org.xmlportletfactory.tnsoft.qrperson.model.person" scope="request"/>
<jsp:useBean id="editType" class="java.lang.String" scope="request"/>

<jsp:useBean id="folderDLId" class="java.lang.String" scope="request" />

<portlet:defineObjects />



<portlet:renderURL var="redirect"></portlet:renderURL>


<liferay-ui:success key="qrperson-added-successfully" message="qrperson-added-successfully" />
<aui:form name="addperson" action="<%=editpersonURL %>" method="post" enctype='multipart/form-data'>

	<aui:input type="hidden" name="resourcePrimKey" value="<%=person.getPrimaryKey() %>"/>
	<c:if test='<%= "add".equals(editType) %>'>
    	<aui:input type="hidden" name="addGuestPermissions" value="true"/>
    	<aui:input type="hidden" name="addGroupPermissions" value="true"/>
	</c:if>
	<aui:input type="hidden" name="HIDDEN_userDocument" value="<%=person.getUserDocument() %>"/>
	<aui:input type="hidden" name="HIDDEN_folderDLId" value="<%=person.getFolderDLId() %>"/>

	<aui:model-context bean="<%= person %>" model="<%= person.class %>" />

	<aui:fieldset>


<% String requiredLabel=""; %>


	<% requiredLabel ="*"; %>
			<aui:input name="Firstname" disabled="false" label='<%= LanguageUtil.get(pageContext, "qrperson-firstname") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="qrperson-firstname-required" message="qrperson-firstname-required" />

			<aui:input name="Middlename" disabled="false" label='<%= LanguageUtil.get(pageContext, "qrperson-middlename") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="qrperson-middlename-required" message="qrperson-middlename-required" />

	<% requiredLabel ="*"; %>
			<aui:input name="Lastname" disabled="false" label='<%= LanguageUtil.get(pageContext, "qrperson-lastname") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="qrperson-lastname-required" message="qrperson-lastname-required" />

			<aui:input name="kundeDescription" disabled="false" label='<%= LanguageUtil.get(pageContext, "qrperson-kundedescription") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="qrperson-kundedescription-required" message="qrperson-kundedescription-required" />




<% requiredLabel =""; %>

<% if (person.getUserDocument()!=0){
	FileEntry userDocument_doc = PortletFileRepositoryUtil.getPortletFileEntry(person.getUserDocument());
	String userDocument_url = PortletFileRepositoryUtil.getPortletFileEntryURL(themeDisplay, userDocument_doc, StringPool.BLANK);
%>
<%	if (MimeTypesUtil.isWebImage(userDocument_doc.getMimeType())) { %>			
		<aui:a href="<%= userDocument_url %>" target="_blank"><img alt="" src="<%= userDocument_url %>" width="100"><%= userDocument_doc.getTitle() %></aui:a>
<%     } else { 
%>
        	<liferay-ui:icon
        		cssClass="top-link"
        		image='<%= "../file_system/small/" + userDocument_doc.getIcon() %>'
        		label="<%= true %>"
        		message="<%= userDocument_doc.getTitle() %>"
        		url='<%= userDocument_url %>'
        		target="_blank"
        	/>
<%     } %>
        	<aui:input name="userDocument_DELETEDOCUMENT" label="delete-field" type="checkbox" inlineField="true"/>
<% } %>
	        <aui:input name="userDocument_DOCUMENTFILE" label="" type="file" />

				<liferay-ui:error key="qrperson-userdocument-required" message="qrperson-userdocument-required" />

			<aui:input name="City" disabled="false" label='<%= LanguageUtil.get(pageContext, "qrperson-city") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="qrperson-city-required" message="qrperson-city-required" />

	<% requiredLabel ="*"; %>
			<aui:input name="userEmail" disabled="false" label='<%= LanguageUtil.get(pageContext, "qrperson-useremail") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="qrperson-useremail-required" message="qrperson-useremail-required" />
				<liferay-ui:error key="email_error" message="email_error" />

   
	<!-- </table> -->

	<aui:button-row>
<% String publishButtonLabel = "submit"; %>

		<aui:button type="submit" value="<%=publishButtonLabel %>" />
		<aui:button onClick="<%= redirect %>" type="cancel"/>
	</aui:button-row>

	</aui:fieldset>

</aui:form>


