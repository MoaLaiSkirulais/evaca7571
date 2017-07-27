<g:applyLayout name="crudContainer">

	<h2>usuario</h2>
	<evaca:cruderror modelo="${usuario}"/>

	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
				<myform:display name="id" label="#id" value="${usuario.id}"/>
				<myform:display name="fechaCreacion" label="Fecha creacion" value="${usuario.fechaCreacion}"/>

				<myform:field name="nombre" label="nombre" value="${usuario.nombre}"/>
				<myform:field name="apellido" label="apellido" value="${usuario.apellido}"/>
				<myform:field name="email" label="email" value="${usuario.email}"/>
				<myform:field name="username" label="username" value="${usuario.username}"/>
				
				<myform:display name="tbState" label="tbState" value="${usuario.state}"/>

				<myform:radio name="profile" label="profile" from="${profiles}" value="${usuario.profile}"/>
				

				<myform:field name="comision" label="comision" value="${usuario.comision}"/>
				<myform:field name="password" label="password" value="${usuario.password}"/>
				<myform:field name="repassword" label="repassword" value=""/>

				<tr class="order-total">
					<th></th>
					<td class="text-right">
						<div class="form-group text-right">

							<g:link action="index" class="btn btn-default">Buscar</g:link>
							<g:link action="create" class="btn btn-default">Nuevo</g:link>
							<g:actionSubmit action="save" value="Guardar" class="btn btn-default"/>
							
							<br><br>

							<g:actionSubmit name="changeState" action="changeState" class="btn btn-default" value="ACTIVO"/>
							<g:actionSubmit name="changeState" action="changeState" class="btn btn-default" value="INACTIVO"/>
							
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	

</g:applyLayout>