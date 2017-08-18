<g:applyLayout name="crudContainer">
						
	<h2>Resena</h2>
	<evaca:cruderror modelo="${resena}"/>
	
	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
			
				<myform:display label="#id" value="${resena.id}"/>
				<myform:display name="state" label="State" value="${resena.state}"/>
				<myform:display label="propietario" value="${resena.propietario}"/>
				<myform:display label="Fecha" value="${resena.fechaCreacion}"/>
				<myform:display label="Venta" value="${resena.venta}"/>
				<myform:display label="puntaje" value="${resena.puntaje}"/>
				<myform:display	label="venta" value="${resena.venta?.id}"/>

				<g:each status="i" in="${resena.respuestas}" var="respuesta">
					<myform:display label="" value="${respuesta.pregunta.label}"/>
					<myform:display label="Puntaje" value="${respuesta.puntaje}"/>
					<myform:display label="Comentarios" value="${respuesta.respuesta}"/>
				</g:each>
				
			</tbody>
		</table>
		
		<div class="buttons">

			<g:actionSubmit action="aprobar" class="btn btn-default" value="admin.aprobar()"/>
			<g:actionSubmit action="rechazar" class="btn btn-default" value="admin.rechazar()"/>
			
		</div>

	</form>
					
</g:applyLayout>
							