<g:applyLayout name="crudContainer">
						
	<h2>Categoria</h2>
	<evaca:cruderror modelo="${categoria}"/>
	
	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
			
				<myform:display label="Nombre" value="${categoria.id}"/>									
				<myform:display label="Usuario" value="${categoria.usuario}"/>
				<myform:display label="Fecha creacion" value="${categoria.fechaCreacion}"/>
				<myform:field label="Nombre" name="nombre" value="${categoria.nombre}"/>

				<tr class="order-total">
					<th></th>
					<td class="text-right">
						<div class="form-group text-right">
							<g:link action="create" class="btn btn-default">Nuevo</g:link>
							<g:actionSubmit action="save" value="Guardar" class="btn btn-default"/>	
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
								
</g:applyLayout>
							