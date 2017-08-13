<g:applyLayout name="crudContainerTwoCols">

    <content tag="left1">
		<h2>usuario</h2>
		<evaca:cruderror modelo="${usuario}"/>

		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:display label="#id" value="${usuario.id}"/>
					<myform:display label="Ingreso" value="${usuario.fechaCreacion}"/>
					<myform:display label="Acceso" value="${usuario.state}"/>

					<myform:display label="Email" value="${usuario.email}"/>
					<myform:display label="Username" value="${usuario.username}"/>
							
					<myform:separator label="Perfil"/>
					<myform:display label="Nombre" value="${usuario.nombre}"/>
					<myform:display label="Apellido" value="${usuario.apellido}"/>
					<myform:display label="Perfil" from="${profiles}" value="${usuario.profile}"/>
					<myform:display label="Comisión" value="${usuario.comision}"/>
					
				</tbody>
			</table>
			
			<div class="buttons">

				<g:link action="index" class="btn btn-default">admin.buscar</g:link>
				<g:actionSubmit action="aprobar" class="btn btn-default" value="admin.aprobar"/>
				<g:actionSubmit action="desaprobar" class="btn btn-default" value="admin.desaprobar"/>

			</div>			
			
		</form>
	
	</content>
	
    <content tag="left2">
		<h2>Avatar</h2>
		<img src="${usuario.avatar}"/>
	</content>

</g:applyLayout>