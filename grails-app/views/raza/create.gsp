<g:applyLayout name="crudContainer">
						
	<h2>Raza</h2>
	<evaca:cruderror modelo="${model.raza}"/>
	
	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
			
				<myform:display label="#id" value="${model.raza.id}"/>									
				<myform:display label="Usuario" value="${model.raza.usuario}"/>
				<myform:display label="Fecha creacion" value="${model.raza.fechaCreacion}"/>
				<myform:field label="Nombre" name="nombre" value="${model.raza.nombre}"/>

				<tr class="order-total">
					<th></th>
					<td class="text-right">
						<div class="form-group text-right">
							<g:link action="index" class="btn btn-default">search</g:link>
							<g:link action="create" class="btn btn-default">create</g:link>
							<g:actionSubmit action="save" value="save" class="btn btn-default"/>	
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
					
</g:applyLayout>
							