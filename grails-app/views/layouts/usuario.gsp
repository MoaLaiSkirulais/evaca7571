<g:applyLayout name="containerLeftBar">

    <content tag="sidebar">
		<div class="widgets">
			<div class="widget widget-categories">
				<h3 class="widget-title">Usuario</h3>
				<div class="usuario-perfil">
					${usuario.email} (#${usuario.id})<br>
					${usuario.username}
				</div>
				<ul>
					<li></li>
					<li>
						<g:link params="${[id:1]}" action="showProfile">Perfil</g:link>
					</li>
					<li>
						<g:link params="${[id:1]}" action="editPassword">Cambiar contraseña</g:link>
					</li>
					<li>
						<g:link params="${[id:1]}" action="editProfile">Modificar perfil</g:link>
					</li>
					<li>
						<g:link params="${[id:1]}" action="editAvatar">Cambiar avatar</g:link>
					</li>
					<li>
						<g:link params="${[id:1]}" action="admin">Administrar</g:link>
					</li>
				</ul>
			</div><!-- /.widget-categories -->
		</div><!-- /.widgets -->
	</content>
	
	
    <content tag="left1" >
	
		<div class="widgets">
			<div class="widget widget-categories">

				<evaca:cruderror modelo="${usuario}"/>
				<g:pageProperty name="page.left1" />

			</div><!-- /.widget-categories -->
		</div><!-- /.widgets -->
		
	</content>
	
</g:applyLayout>