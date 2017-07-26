<g:applyLayout name="crudContainerTwoCols">

    <content tag="left1">

		<h2>Oferta</h2>
		<evaca:cruderror modelo="${oferta}"/>

		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:display name="id" label="#id" value="${oferta.id}"/>
					<myform:display name="usuario" label="Usuario" value="${oferta.usuario}"/>
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
					
					<myform:display name="state" label="state" value="${oferta.state}"/>

					<tr class="order-total">
						<th></th>
						<td class="text-right">
							<div class="form-group text-right">
								<g:link action="index" class="btn btn-default">Buscar</g:link>
								<g:link action="create" class="btn btn-default">Nuevo</g:link>
								<g:actionSubmit action="save" value="Guardar" class="btn btn-default"/>	
								<br><br>								
								
								<g:actionSubmit name="changeState" action="changeState" class="btn btn-default" value="ACEPTADO"/>
								<g:actionSubmit name="changeState" action="changeState" class="btn btn-default" value="PUBLICADO"/>
								<g:actionSubmit name="changeState" action="changeState" class="btn btn-default" value="RECHAZADO"/>
								<g:actionSubmit name="changeState" action="changeState" class="btn btn-default" value="CANCELADO"/>
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