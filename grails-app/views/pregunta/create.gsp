<g:applyLayout name="crudContainer">
						
	<h2>Pregunta</h2>
	<evaca:cruderror modelo="${model.pregunta}"/>
	
	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
			
				<myform:display label="#id" value="${model.pregunta.id}"/>									
				<myform:display label="Usuario" value="${model.pregunta.usuario}"/>
				<myform:display label="Fecha creacion" value="${model.pregunta.fechaCreacion}"/>
				<myform:field label="Nombre" name="label" value="${model.pregunta.label}"/>

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
							