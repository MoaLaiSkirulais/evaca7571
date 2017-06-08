<g:applyLayout name="crudContainer">

	<h2>usuario</h2>
	<evaca:cruderror modelo="${model.usuario}"/>

	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
				<myform:display name="id" label="#id" value="${model.usuario.id}"/>
				<myform:display name="fechaCreacion" label="Fecha creacion" value="${model.usuario.fechaCreacion}"/>

				<myform:field name="nombre" label="nombre" value="${model.usuario.nombre}"/>
				<myform:field name="apellido" label="apellido" value="${model.usuario.apellido}"/>
				<myform:field name="email" label="email" value="${model.usuario.email}"/>
				<myform:field name="username" label="username" value="${model.usuario.username}"/>
				
				<myform:radio name="tbState" label="tbState" from="['Activo', 'Inactivo', 'Pendiente']" value="${model.usuario.tbState}"/>
				<myform:radio name="tbTipo" label="tbTipo" from="['Consignatario', 'Productor']" value="${model.usuario.tbTipo}"/>

				<myform:field name="comision" label="comision" value="${model.usuario.comision}"/>
				<myform:field name="password" label="password" value="${model.usuario.password}"/>
				<myform:field name="repassword" label="repassword" value=""/>

				<tr class="order-total">
					<th></th>
					<td class="text-right">
						<div class="form-group text-right">
							<g:link action="index" class="btn btn-default">Buscar</g:link>
							<g:link action="create" class="btn btn-default">Nuevo</g:link>
							<g:actionSubmit action="save" value="Guardar" class="btn btn-default"/>	
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

</g:applyLayout>