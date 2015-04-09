<#--
This file allows you to override and define new FreeMarker variables.
-->
<#-- Default controls should be hidden -->
<#assign liferay_toggle_controls = sessionClicks.get(request, "liferay_toggle_controls", "hidden") />
<#assign css_class = css_class?replace("controls-visible","") />
<#assign css_class = css_class?replace("controls-hidden","") />
<#if liferay_toggle_controls = "visible">
	<#assign css_class = css_class + " controls-visible" />
<#else>
	<#assign css_class = css_class + " controls-hidden" />
</#if>

<#assign user_roles = user.getRoles() />

<#-- Regular user, or some sort of admin? (used for displaying dockbar) -->
<#assign is_some_sort_of_admin = false />
<#if permissionChecker.isOmniadmin()>
	<#assign is_some_sort_of_admin = true />
</#if>
<#if site_type == "company-site" && permissionChecker.isCompanyAdmin(page_group.getCompanyId())>
	<#assign is_some_sort_of_admin = true />
</#if>
<#if site_type == "organization-site" && permissionChecker.isOrganizationAdmin(page_group.getOrganizationId())>
	<#assign is_some_sort_of_admin = true />
</#if>
<#if site_type == "site" && permissionChecker.isGroupAdmin(page_group.getGroupId())>
	<#assign is_some_sort_of_admin = true />
</#if>

<#-- Page settings -->
<#assign show_top_menu = true />
<#if page.getExpandoBridge().hasAttribute("hide-top-menu")>
    <#if (page.getExpandoBridge().getAttribute("hide-top-menu") != "")>
        <#assign show_top_menu = false />
    </#if>
</#if>
<#assign show_main_menu = true />
<#if page.getExpandoBridge().hasAttribute("hide-main-menu")>
    <#if (page.getExpandoBridge().getAttribute("hide-main-menu") != "")>
        <#assign show_main_menu = false />
    </#if>
</#if>

<#-- Strings -->
<#assign str_sign_out = languageUtil.get(locale, "sign-out") />

<#-- paths -->
<#assign custom_logo = images_folder + "/audi-logo.png" />
