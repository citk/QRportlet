<div class="navbar navbar-static-top dockbar">
	<div class="navbar-inner">
		<div class="container">
			<div id="user-bar-data" class="collapse nav-collapse">
				<ul class="nav">
					<#if !is_signed_in>
						<li class="dockbar-item">
							<a href="${sign_in_url}" data-redirect="${is_login_redirect_required?string}" rel="nofollow">${sign_in_text}</a>
						</li>
					<#else>				
						<li class="dockbar-item">
							<span>${user_name}</span>
						</li>
						<li class="dockbar-item">
				 			<a href="/c/portal/logout">${str_sign_out}</a>
				 		</li>	
				 	</#if>
			</div>
		</div>
	</div>
</div>