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
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.portal.portletfilerepository.PortletFileRepositoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.MimeTypesUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>



<jsp:useBean class="java.lang.String" id="editkundeURL" scope="request" />
<jsp:useBean id="kunde" type="org.xmlportletfactory.example01.order.model.kunde" scope="request"/>
<jsp:useBean id="editType" class="java.lang.String" scope="request"/>

<jsp:useBean id="folderDLId" class="java.lang.String" scope="request" />

<portlet:defineObjects />



<portlet:renderURL var="redirect"></portlet:renderURL>


<liferay-ui:success key="kunde-added-successfully" message="kunde-added-successfully" />
<aui:form name="addkunde" action="<%=editkundeURL %>" method="post" enctype='multipart/form-data'>

	<aui:input type="hidden" name="resourcePrimKey" value="<%=kunde.getPrimaryKey() %>"/>
	<c:if test='<%= "add".equals(editType) %>'>
    	<aui:input type="hidden" name="addGuestPermissions" value="true"/>
    	<aui:input type="hidden" name="addGroupPermissions" value="true"/>
	</c:if>
	<aui:input type="hidden" name="HIDDEN_userDocument" value="<%=kunde.getUserDocument() %>"/>
	<aui:input type="hidden" name="HIDDEN_folderDLId" value="<%=kunde.getFolderDLId() %>"/>

	<aui:model-context bean="<%= kunde %>" model="<%= kunde.class %>" />

	<aui:fieldset>


<% String requiredLabel=""; %>


	<% requiredLabel ="*"; %>
			<aui:input name="kundeDescription" disabled="false" label='<%= LanguageUtil.get(pageContext, "kunde-kundedescription") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="kunde-kundedescription-required" message="kunde-kundedescription-required" />

			<aui:input name="userKunde" disabled="false" label='<%= LanguageUtil.get(pageContext, "kunde-userkunde") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="kunde-userkunde-required" message="kunde-userkunde-required" />




<% requiredLabel =""; %>

<% if (kunde.getUserDocument()!=0){
	FileEntry userDocument_doc = PortletFileRepositoryUtil.getPortletFileEntry(kunde.getUserDocument());
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

				<liferay-ui:error key="kunde-userdocument-required" message="kunde-userdocument-required" />

			<aui:input name="userCity" disabled="false" label='<%= LanguageUtil.get(pageContext, "kunde-usercity") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="kunde-usercity-required" message="kunde-usercity-required" />

	<% requiredLabel ="*"; %>
			<aui:input name="userEmail" disabled="false" label='<%= LanguageUtil.get(pageContext, "kunde-useremail") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="kunde-useremail-required" message="kunde-useremail-required" />
				<liferay-ui:error key="email_error" message="email_error" />

   
	<!-- </table> -->

	<aui:button-row>
<% String publishButtonLabel = "submit"; %>

		<aui:button type="submit" value="<%=publishButtonLabel %>" />
		<aui:button onClick="<%= redirect %>" type="cancel"/>
	</aui:button-row>

	</aui:fieldset>

</aui:form>


