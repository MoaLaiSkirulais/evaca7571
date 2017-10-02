<g:applyLayout name="layoutTwoColumnsUserLogged">
	
	<content tag="left1">
						
		<evaca:cruderror modelo="${resena}"/>
		<h3 class="widget-title">Resena</h3>

		<table class="table table-condensed" cellspacing="0">

			<tbody>

				<myform:show label="#id" value="${resena.id}"/>
				<myform:show label="State" value="${resena.state}"/>
				<myform:show label="propietario" value="${resena.propietario}"/>

				<!-- <myform:show label="propietario" value="${g.link([action:'show_profile', controller:'usuario', id:resena.propietario.id])}"/> -->
				
				<myform:show label="Fecha" value="${resena.fechaCreacion}"/>
				<myform:show label="Puntaje" value="${resena.puntaje}"/>
				

				<span class="star-rating">
					<span style="width:${resena.puntaje * 100 / 5}%">
				</span>
				
				<myform:separator label="Preguntas"/>
				<g:each status="i" in="${resena.respuestas}" var="respuesta">
					<myform:show label="#${i+1}" value="${respuesta.pregunta.label}"/>
					<myform:show label="Puntaje" value="${respuesta.puntaje}"/>
					<myform:show label="Comentarios" value="${respuesta.respuesta}"/>
					<myform:separator label=""/>
				</g:each>
				
			</tbody>
		</table>
		
	</content>

</g:applyLayout>
							