<g:applyLayout name="layoutThreeColumns">

    <content tag="sidebar">
		<div class="widgets">
			<div class="widget widget-categories">
				<h3 class="widget-title">Usuario</h3>
				<div class="usuario-perfil">
					${usuario?.email} (#${usuario?.id})<br>
					${usuario?.username}
				</div>
				<ul>
					<li></li>
					<li>
						<g:link controller="usuario" params="${[id:1]}" action="showProfile">Perfil</g:link>
					</li>
					<li>
						<g:link controller="usuario" params="${[id:1]}" action="editPassword">Cambiar contraseña</g:link>
					</li>
					<li>
						<g:link controller="usuario" params="${[id:1]}" action="editProfile">Modificar perfil</g:link>
					</li>
					<li>
						<g:link controller="usuario" params="${[id:1]}" action="editAvatar">Cambiar avatar</g:link>
					</li>
					<li>
						<g:link controller="usuario" params="${[id:1]}" action="admin">Administrar</g:link>
					</li>
					
				</ul>
					
				<ul>		
					<li><br><br><h3>Accesos</h3></li>
					<li><g:link controller="lote" action="search">Lotes</g:link></li>
					<li><g:link controller="aviso" action="search">Avisos</g:link></li>
					<li><g:link controller="oferta" action="index">Ofertas</g:link></li>
					<li><g:link controller="venta" action="index">Ventas</g:link></li>
					<li><g:link controller="resena" action="index">Resena</g:link></li>
				</ul>	
				
				<ul>		
					<li><br><br><h3>Tablas</h3></li>
					<li><g:link controller="categoria" action="search">Categorias</g:link></li>
					<li><g:link controller="plazo" action="search">Plazos</g:link></li>
					<li><g:link controller="pregunta" action="search">Preguntas</g:link></li>
					<li><g:link controller="raza" action="search">Razas</g:link></li>
					<li><g:link controller="usuario" action="search">Usuarios</g:link></li>
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