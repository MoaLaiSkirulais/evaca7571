<g:applyLayout name="crudContainerTwoCols">

    <content tag="left1">

		<h2>Oferta</h2>
		<evaca:cruderror modelo="${model.oferta}"/>

		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:display name="id" label="#id" value="${model.oferta.id}"/>
					<myform:display name="usuario" label="Usuario" value="${model.oferta.usuario}"/>
					<myform:display name="fechaCreacion" label="Fecha creacion" value="${model.oferta.fechaCreacion}"/>

					<myform:field name="precio" label="Precio" value="${model.oferta.precio}"/>

					<myform:select 
						label="Aviso" 	
						name="aviso.id" 
						from="${model.avisos}" value="${model.oferta?.aviso?.id}" 
						optionKey="id"
					/>

					<myform:select 
						label="Plazo" 	
						name="plazo.id" 
						from="${model.plazos}" value="${model.oferta?.plazo?.id}" 
						optionKey="id"
					/>
					
					<myform:radio name="tbState" label="tbState" from="['Activa', 'Rechazada', 'Aceptada', 'Cancelada']" value="${model.oferta.tbState}"/>

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
	</content>

    <content tag="left2">
	</content>

</g:applyLayout>