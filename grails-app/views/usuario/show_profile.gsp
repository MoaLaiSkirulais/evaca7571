<g:applyLayout name="layoutThreeColumnsUserLogged">

    <content tag="left1">
	
		<h3 class="widget-title">Perfil</h3>

		<table class="table table-condensed" cellspacing="0">
			<tbody>
				<myform:show label="Ingreso" value="${usuario.fechaCreacion}"/>
				<myform:show label="State" value="${aviso.entityState([state: usuario.state])}"/>				
				<myform:show label="username" value="${usuario.username}"/>
				<myform:show label="email" value="${usuario.email}"/>
				<myform:separator label="Detalle"/>
				<myform:show label="Nombre" value="${usuario.nombre}"/>
				<myform:show label="Apellido" value="${usuario.apellido}"/>
				<myform:show label="Perfil" value="${usuario.profile}"/>
				<myform:show label="Comisión" value="${usuario.comision}"/>
			</tbody>
		</table>
	
	</content>
	
    <content tag="left2">
		<h2>Avatar</h2>
		<img src="<g:createLink controller='usuario' action='get_image' id='${usuario.id}'/>"/>
		<ul>		
			<li><h3>Actividad</h3></li>

			<li>
				<g:link controller="lote" action="search">
					Avisos (${usuario.lotes.size()})
				</g:link>
			</li>

			<li>
				<g:link controller="resena" action="search">
					Resenas (${usuario.resenas.size()})
				</g:link>
			</li>
		</ul>
	</content>

</g:applyLayout>