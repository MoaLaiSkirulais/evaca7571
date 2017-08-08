<g:applyLayout name="crudContainer">
						
	<h2>Pregunta</h2>
	<evaca:cruderror modelo="${pregunta}"/>
	
	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
			
				<myform:display label="#id" value="${pregunta.id}"/>
				<myform:display label="Usuario" value="${pregunta.usuario}"/>
				<myform:display label="Fecha creacion" value="${pregunta.fechaCreacion}"/>
				<myform:field label="Nombre" name="label" value="${pregunta.label}"/>

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
