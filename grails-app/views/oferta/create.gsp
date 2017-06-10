<g:applyLayout name="crudContainerTwoCols">

	<h2>raza</h2>
	<evaca:cruderror modelo="${model.oferta}"/>

    <content tag="left1">
	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
				<myform:display name="id" label="#id" value="${model.oferta.id}"/>
				<myform:display name="usuario" label="Usuario" value="${model.oferta.usuario}"/>
				<myform:display name="fechaCreacion" label="Fecha creacion" value="${model.oferta.fechaCreacion}"/>

				<myform:select 
					label="Aviso" 	
					name="aviso.id" 
					from="${model.avisos}" value="${model.oferta?.aviso?.id}" 
					optionKey="id"
				/>

				<tr class="order-total">
					<th></th>
					<td class="text-right">
						<div class="form-group text-right">
							<g:link action="index" class="btn btn-default">Buscar</g:link>
							<g:link action="create" class="btn btn-default">create</g:link>
							<g:actionSubmit action="save" value="save" class="btn btn-default"/>	
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</content>
	
    <content tag="left2">

	</content>
	
	</div>
</g:applyLayout>