<g:applyLayout name="crudContainer">
						
	<h2>Resena</h2>
	<evaca:cruderror modelo="${resena}"/>
	
	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
			
				<myform:display label="#id" value="${resena.id}"/>
				<myform:display label="propietario" value="${resena.propietario}"/>
				<myform:display label="Fecha" value="${resena.fechaCreacion}"/>
				<myform:display label="Venta" value="${resena.venta}"/>
				<myform:radio name="puntaje" label="puntaje" from="${1..5}" value="${resena.puntaje}" type="inline"/>
				<myform:field name="venta.id" label="" value="${resena.venta?.id}" style="display:none"/>

				<myform:select 
					label="venta" 	
					name="venta.id" 
					from="${ventas}" value="${resena.venta?.id}" 
					optionKey="id"
				/>

				<g:each status="i" in="${resena.respuestas}" var="respuesta">
					<myform:display label="" value="${respuesta.pregunta.label}"/>
					<myform:field label="" name="respuestas[${i}].pregunta.id" value="${respuesta.pregunta.id}" style="display:none"/>
					<myform:radio label="Puntaje" name="respuestas[${i}].puntaje" from="${1..5}" value="${respuesta.puntaje}" type="inline"/>
					<myform:field label="Comentarios" name="respuestas[${i}].respuesta" value="${respuesta.respuesta}"/>					
				</g:each>
				
			</tbody>
		</table>
		
		<div class="buttons">

			<g:actionSubmit action="postular" class="btn btn-default" value="vendedor.comprador.postular()"/>
			
			<br><br>
			
			<g:actionSubmit action="aprobar" class="btn btn-default" value="admin.aprobar()"/>
			<g:actionSubmit action="rechazar" class="btn btn-default" value="admin.rechazar()"/>
			<br><br>

			<g:link action="index" class="btn btn-default">Buscar aviso</g:link>
			<g:link action="create" class="btn btn-default">Nuevo aviso</g:link>
		</div>

	</form>
					
</g:applyLayout>
							