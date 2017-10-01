<g:applyLayout name="layoutTwoColumnsUserLogged">
	
	<content tag="left1">
						
		<evaca:cruderror modelo="${resena}"/>
		<h2>Resena</h2>

		<table class="table table-condensed" cellspacing="0">
			<tbody>
			
				<myform:display label="#id" value="${resena.id}"/>
				<myform:display label="State" value="${resena.state}"/>
				<myform:display label="propietario" value="${resena.propietario}"/>
				<myform:display label="Fecha" value="${resena.fechaCreacion}"/>
				<myform:display label="Puntaje" value="${resena.puntaje}"/>
				
				<myform:separator label="Preguntas"/>
				<g:each status="i" in="${resena.respuestas}" var="respuesta"><br>
					<myform:display label="" value="${respuesta.pregunta.label}"/>
					<myform:display label="Puntaje" value="${respuesta.puntaje}"/>
					<myform:display label="Comentarios" value="${respuesta.respuesta}"/>
				</g:each>
				
			</tbody>
		</table>
		
	</content>

</g:applyLayout>
							