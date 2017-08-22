<h3 class="widget-title">Usuario</h3>
<div class="usuario-perfil">
	${usuario?.email} (#${usuario?.id})<br>
	${usuario?.username}
</div>
<ul>
	<li></li>
	<li>
		<g:link controller="usuario" params="${[id:1]}" action="show_profile">Perfil</g:link>
	</li>
	<li>
		<g:link controller="usuario" params="${[id:1]}" action="edit_password">Cambiar contraseña</g:link>
	</li>
	<li>
		<g:link controller="usuario" params="${[id:1]}" action="edit_profile">Modificar perfil</g:link>
	</li>
	<li>
		<g:link controller="usuario" params="${[id:1]}" action="edit_avatar">Cambiar avatar</g:link>
	</li>
	<li>
		<g:link controller="usuario" params="${[id:1]}" action="admin">Administrar</g:link>
	</li>	
</ul>