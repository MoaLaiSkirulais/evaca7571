<g:applyLayout name="crudContainer">
						
	<h2>Resena</h2>
	<evaca:cruderror modelo="${model.resena}"/>
	
	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
			
				<myform:display label="#id" value="${model.resena.id}"/>
				<myform:display label="Usuario" value="${model.resena.usuario}"/>
				<myform:display label="Fecha" value="${model.resena.fechaCreacion}"/>
				<myform:field label="Puntaje" name="puntaje" value="${model.resena.puntaje}"/>

				<g:each in="${model.resena.respuestas}" var="respuesta">
					<myform:display label="Pregunta" value="${respuesta.pregunta.label}"/>
					<myform:field label="respuesta" name="respuesta" value="${respuesta.respuesta}"/>
					<myform:field label="puntaje" name="puntaje" value="${respuesta.puntaje}"/>
				</g:each>

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
							