<g:applyLayout name="crudContainerTwoCols">

    <content tag="left1">

		<h2>Oferta</h2>
		<evaca:cruderror modelo="${oferta}"/>

		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:display name="id" label="#id" value="${oferta.id}"/>
					<myform:display name="state" label="state" value="${oferta.state}"/>
					<myform:display name="propietario" label="propietario" value="${oferta.propietario}"/>
					<myform:display name="fechaCreacion" label="Fecha creacion" value="${oferta.fechaCreacion}"/>

					<myform:field name="precio" label="Precio" value="${oferta.precio}"/>

					<myform:select 
						label="Aviso" 	
						name="aviso.id" 
						from="${avisos}" value="${oferta?.aviso?.id}" 
						optionKey="id"
					/>

					<myform:select 
						label="Plazo" 	
						name="plazo.id" 
						from="${plazos}" value="${oferta?.plazo?.id}" 
						optionKey="id"
					/>
					
					<tr class="order-total">
						<th></th>
						<td class="text-right">
							<div class="form-group text-right">

								<g:link action="index" class="btn btn-default">Buscar</g:link>
								<g:link action="create" class="btn btn-default">Nuevo</g:link>
								
								<br><br>
								
								<g:actionSubmit action="setStateAceptado" class="btn btn-default" value="vendedor.aceptar"/>
								<g:actionSubmit action="setStateRechazado" class="btn btn-default" value="vendedor.rechazar"/>
								
								<br><br>

								<g:actionSubmit action="setStateAprobado" class="btn btn-default" value="administrador.aprobar"/>
								<g:actionSubmit action="setStateDesaprobado" class="btn btn-default" value="administrador.desaprobar"/>
								
								<br><br>
								
								<g:actionSubmit action="setStateAprobacion" class="btn btn-default" value="ofertante.publicar"/>
								<g:actionSubmit action="setStateCancelado" class="btn btn-default" value="ofertante.cancelar"/>
								
								
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