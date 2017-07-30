<g:applyLayout name="crudContainer">

	<h2>aviso</h2>
	<evaca:cruderror modelo="${aviso}"/>

	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
				
				<myform:display name="id" label="#id" value="${aviso.id}"/>
				<myform:display name="id" label="state" value="${aviso.state}"/>
				<myform:display name="propietario" label="propietario" value="${aviso.propietario}"/>
				<myform:display name="fechaCreacion" label="Fecha creacion" value="${aviso.fechaCreacion}"/>
				<myform:field name="precio" label="precio" value="${aviso.precio}"/>
				
				<myform:select 
					label="consignatario" 	
					name="consignatario.id" 
					from="${consignatarios}" value="${aviso?.consignatario?.id}" 
					optionKey="id"
				/>
				
				<myform:select label="lote" name="lote.id" from="${lotes}" value="${aviso?.lote?.id}" optionKey="id"/>
				
				<tr class="order-total">
					<th></th>
					<td class="text-right">
						<div class="form-group text-right">

							<g:actionSubmit name="1" action="save" class="btn btn-default" value="publicar()"/>
							<g:actionSubmit name="2" action="save" class="btn btn-default"	value="aprobar()"/>
							<g:actionSubmit name="3" action="save" class="btn btn-default" value="rechazar()"/>
							<br><br>

							<g:link action="index" class="btn btn-default">Buscar</g:link>
							<g:link action="create" class="btn btn-default">Nuevo</g:link>
							
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
</g:applyLayout>