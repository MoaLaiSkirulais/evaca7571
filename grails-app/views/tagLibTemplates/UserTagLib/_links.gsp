<h3 class="widget-title">Usuario</h3>
<div class="usuario-perfil">
	${usuario?.email} (#${usuario?.id})<br>
	${usuario?.username}
</div>
<ul>
	<li></li>
	<li>
		<g:link controller="usuario" params="${[id:usuario?.id]}" action="show_profile">Perfil</g:link>
	</li>
	<li>
		<g:link controller="usuario" params="${[id:usuario?.id]}" action="edit_password">Cambiar contraseña</g:link>
	</li>
	<li>
		<g:link controller="usuario" params="${[id:usuario?.id]}" action="edit_profile">Modificar perfil</g:link>
	</li>
	<li>
		<g:link controller="usuario" params="${[id:usuario?.id]}" action="edit_avatar">Cambiar avatar</g:link>
	</li>
	<li>
		<g:link controller="usuario" params="${[id:usuario?.id]}" action="admin">Administrar</g:link>
	</li>	
</ul>