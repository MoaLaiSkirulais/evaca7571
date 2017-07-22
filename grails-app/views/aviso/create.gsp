<g:applyLayout name="crudContainer">

	<h2>aviso</h2>
	<evaca:cruderror modelo="${model.aviso}"/>

	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
				
				<myform:display name="id" label="#id" value="${model.aviso.id}"/>
				<myform:display name="id" label="#id" value="${model.aviso.state}"/>
				
				<myform:display name="fechaCreacion" label="Fecha creacion" value="${model.aviso.fechaCreacion}"/>				
				<myform:field name="precio" label="precio" value="${model.aviso.precio}"/>
				
				<myform:display name="tbState" label="tbState" value="${model.aviso.state}"/>
				
				<myform:select 
					label="consignatario" 	
					name="consignatario.id" 
					from="${model.consignatarios}" value="${model.aviso?.consignatario?.id}" 
					optionKey="id"
				/>
				
				<!-- <myform:select label="lote" name="lote.id" from="${model.lotes}" value="${model.aviso?.lote?.id}" optionKey="id"/> -->
				
				<tr class="order-total">
					<th></th>
					<td class="text-right">
						<div class="form-group text-right">
							<g:link action="create" class="btn btn-default">Nuevo</g:link>
							
							<g:actionSubmit action="save" value="Guardar" class="btn btn-default"/>	
							<br><br>
							<g:actionSubmit name="changeState" action="changeState" class="btn btn-default"
							value="AvisoState.PUBLICADO"/>
							
							
							<g:actionSubmit name="changeState" action="changeState" class="btn btn-default"
							value="AvisoState.RECHAZADO"/>
							
							
							<g:actionSubmit name="changeState" action="changeState" class="btn btn-default"
							value="AvisoState.CANCELADO"/>
							
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<h2>Actividad</h2>
	
		<table class="table table-condensed" cellspacing="0">
			<tbody>
				
				<myform:display name="tbState" label="tbState" value="${model.aviso.state}"/>

				<tr class="order-total">
					<th></th>
					<td class="text-right">
						<div class="form-group text-right">

							<form method="post">
								<myform:display name="id" label="#id" value="${model.aviso.id}"/>
								<myform:field name="newTbState" label="newTbState" value="AvisoState.PUBLICADO"/>
								<g:actionSubmit value="Publicar" action="changeState" class="btn btn-default"/>								
							</form>

							<form method="post">
								<myform:display name="id" label="#id" value="${model.aviso.id}"/>
								<myform:field name="newTbState" label="newTbState" value="AvisoState.RECHAZADO"/>
								<g:actionSubmit value="Rechazar" action="changeState" class="btn btn-default"/>								
							</form>

							<form method="post">
								<myform:display name="id" label="#id" value="${model.aviso.id}"/>
								<myform:field name="newTbState" label="newTbState" value="AvisoState.CANCELADO"/>
								<g:actionSubmit value="Cancelar" action="changeState" class="btn btn-default"/>								
							</form>

						</div>
					</td>
				</tr>
			</tbody>
		</table>
	

</g:applyLayout>