<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

    <meta content="initial-scale=1.0, user-scalable=0, width=device-width" name="viewport" />

	${theme.include(top_head_include)}
</head>

<body class="${css_class}">

<a href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

${theme.include(body_top_include)}

<#if is_signed_in && is_some_sort_of_admin>
	<@liferay.dockbar />
<#else>
    <#if show_top_menu>
        <#include "${full_templates_path}/user_bar.ftl" />
    </#if>
</#if>

<div class="container-fluid" id="wrapper">
	<header id="banner" role="banner">
		<div id="heading">
			<div id="logo">
				<img src="${custom_logo}" />
			</div>
		</div>
		<div class="clearfix"></div>

		<#if has_navigation || is_signed_in>
            <#if show_main_menu>
                <#include "${full_templates_path}/navigation.ftl" />
            </#if>
		</#if>
	</header>

	<div id="content">

		<#if selectable>
			${theme.include(content_include)}
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			${theme.wrapPortlet("portlet.ftl", content_include)}
		</#if>
	</div>

	<footer id="footer" role="contentinfo">

	</footer>
</div>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>