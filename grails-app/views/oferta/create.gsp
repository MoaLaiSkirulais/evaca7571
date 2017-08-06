<g:applyLayout name="crudContainerTwoCols">

    <content tag="left1">

		<h2>Oferta</h2>
		<evaca:cruderror modelo="${oferta}"/>

		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:display name="id" label="#id" value="${oferta.id}"/>
					<myform:display name="state" label="State" value="${oferta.state}"/>
					<myform:display name="propietario" label="Propietario" value="${oferta.propietario}"/>
					<myform:display name="fechaCreacion" label="Ingreso" value="${oferta.fechaCreacion}"/>

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

				</tbody>
			</table>
			
			<div class="buttons">

				<g:actionSubmit action="postular" class="btn btn-default" value="oferente.postular()"/>
				<g:actionSubmit action="cancelar" class="btn btn-default" value="oferente.cancelar()"/>
				
				<br><br>
				
				<g:actionSubmit action="aprobar" class="btn btn-default" value="admin.aprobar()"/>
				<g:actionSubmit action="desaprobar" class="btn btn-default" value="admin.desaprobar()"/>

				<br><br>

				<g:actionSubmit action="aceptar" class="btn btn-default" value="vendedor.aceptar()"/>
				<g:actionSubmit action="rechazar" class="btn btn-default" value="vendedor.rechazar()"/>

				<br><br>

				<g:link action="index" class="btn btn-default">all.buscar()</g:link>
				<g:link action="create" class="btn btn-default">oferente.nueva()</g:link>
			</div>
		</form>
	</content>

    <content tag="left2">
	</content>

</g:applyLayout>