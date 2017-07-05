<g:applyLayout name="crudContainer">

	<h2>aviso</h2>
	<evaca:cruderror modelo="${model.aviso}"/>

	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
				
				<myform:display name="id" label="#id" value="${model.aviso.id}"/>
				<myform:display name="fechaCreacion" label="Fecha creacion" value="${model.aviso.fechaCreacion}"/>				
				<myform:field name="precio" label="precio" value="${model.aviso.precio}"/>
				
				<myform:select 
					label="consignatario" 	
					name="consignatario.id" 
					from="${model.consignatarios}" value="${model.aviso?.consignatario?.id}" 
					optionKey="id"
				/>
				
				<!-- <myform:select label="lote" name="lote.id" from="${model.lotes}" value="${model.aviso?.lote?.id}" optionKey="id"/> -->
				
				<!-- <myform:radio name="tbState" label="tbState" from="['Borrador', 'Publicado', 'Finalizado', 'Vendido','Aprobacion']" value="${model.aviso.tbState}"/> -->

				<tr class="order-total">
					<th></th>
					<td class="text-right">
						<div class="form-group text-right">
							<g:link action="create" class="btn btn-default">create</g:link>
							<g:actionSubmit action="save" value="save" class="btn btn-default"/>	
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<h2>Actividad</h2>
	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
				<myform:display name="id" label="#id" value="${model.aviso.id}"/>
				<myform:display name="tbState" label="tbState" value="${model.aviso.tbState}"/>
				<myform:display name="fechaActivacion" label="fechaActivacion" />
				<myform:display name="usuarioActivacion" label="usuarioActivacion" />
				
				<myform:display name="fechaPublicacion" label="Fecha Publicacion" value="${model.aviso.fechaPublicacion}"/>
				
				<tr class="order-total">
					<th></th>
					<td class="text-right">
						<div class="form-group text-right">
							<g:actionSubmit value="Pedir" action="setTbState" class="btn btn-default"/>
							<g:actionSubmit value="Aprobar" action="setTbState" class="btn btn-default"/>
							<g:actionSubmit value="Finalizar" action="setTbState" class="btn btn-default"/>	
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

</g:applyLayout>