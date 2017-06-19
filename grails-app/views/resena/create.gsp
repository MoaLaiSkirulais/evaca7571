<g:applyLayout name="crudContainer">
						
	<h2>Resena</h2>
	<evaca:cruderror modelo="${model.resena}"/>
	
	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
			
				<myform:display label="#id" value="${model.resena.id}"/>
				<myform:display label="Usuario" value="${model.resena.usuario}"/>
				<myform:display label="Fecha" value="${model.resena.fechaCreacion}"/>
				<myform:radio name="resena.puntaje" label="puntaje" from="${1..5}" value="${model.resena.puntaje}" type="inline"/>
					
				<myform:field name="resena.venta.id" label="Venta" value="${model.resena.venta.id}"/>	
	
				<g:each in="${model.resena.respuestas}" var="respuesta">
					<myform:display label="Pregunta" value="${respuesta.pregunta.label}"/>
					
					<myform:field label="pregunta" name="respuesta.pregunta.id" value="${respuesta.pregunta.id}"/>
					<myform:field label="respuesta" name="respuesta.respuesta" value="${respuesta.respuesta}"/>
					<myform:radio name="respuesta.puntaje" label="puntaje" from="${1..5}" value="${respuesta.puntaje}" type="inline"/>
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
							