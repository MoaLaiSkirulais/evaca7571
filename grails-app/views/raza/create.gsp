<g:applyLayout name="crudContainer">
						
	<h2>Raza</h2>
	<evaca:cruderror modelo="${raza}"/>
	
	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
			
				<myform:display label="#id" value="${raza.id}"/>
				<myform:display label="Usuario" value="${raza.usuario}"/>
				<myform:display label="Fecha creacion" value="${raza.fechaCreacion}"/>
				<myform:field label="Nombre" name="nombre" value="${raza.nombre}"/>

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
							