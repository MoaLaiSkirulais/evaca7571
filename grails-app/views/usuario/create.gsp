<g:applyLayout name="crudContainerTwoCols">

    <content tag="left1">
		<h2>usuario</h2>
		<evaca:cruderror modelo="${usuario}"/>

		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:display name="id" label="#id" value="${usuario.id}"/>
					<myform:display name="fechaCreacion" label="Ingreso" value="${usuario.fechaCreacion}"/>
					<myform:display name="tbState" label="Acceso" value="${usuario.state}"/>

					<myform:field name="email" label="Email" value="${usuario.email}"/>
					<myform:field name="username" label="Username" value="${usuario.username}"/>
					<myform:field name="password" label="Password" value="${usuario.password}"/>
					<myform:field name="repassword" label="Repassword" value=""/>
		
					<myform:separator label="Perfil"/>
					<myform:field name="nombre" label="Nombre" value="${usuario.nombre}"/>
					<myform:field name="apellido" label="Apellido" value="${usuario.apellido}"/>
					<myform:select name="profile" label="Perfil" from="${profiles}" value="${usuario.profile}"/>
					<myform:field name="comision" label="Comisión" value="${usuario.comision}"/>
					
				</tbody>
			</table>
			
			<div class="buttons">

				<g:link action="create" class="btn btn-default">visitante.nuevo usuario</g:link>
				<g:actionSubmit action="postular" class="btn btn-default" value="visitante.postular"/>

				<br><br>

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