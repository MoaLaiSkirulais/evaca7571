<g:applyLayout name="crudContainer">

	<h2>aviso</h2>
	<evaca:cruderror modelo="${aviso}"/>

	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
				
				<myform:display name="id" label="#id" value="${aviso.id}"/>
				<myform:display name="state" label="State" value="${aviso.state}"/>
				<myform:display name="propietario" label="Propietario" value="${aviso.propietario}"/>
				<myform:display name="fechaCreacion" label="Ingreso" value="${aviso.fechaCreacion}"/>
				<myform:field name="precio" label="Precio" value="${aviso.precio}"/>
				
				<myform:select 
					label="Consignatario" 	
					name="consignatario.id" 
					from="${consignatarios}" value="${aviso?.consignatario?.id}" 
					optionKey="id"
				/>
				
				<myform:select label="Lote" name="lote.id" from="${lotes}" value="${aviso?.lote?.id}" optionKey="id"/>

			</tbody>
		</table>
		
		<div class="buttons">
			<g:actionSubmit action="postular" class="btn btn-default" value="vendedor.postular()"/>
			<g:actionSubmit action="cancelar" class="btn btn-default" value="vendedor.cancelar()"/>
			
			<br><br>
			
			<g:actionSubmit action="aprobar" class="btn btn-default" value="admin.aprobar()"/>
			<g:actionSubmit action="rechazar" class="btn btn-default" value="admin.rechazar()"/>
			<br><br>

			<g:link action="index" class="btn btn-default">Buscar aviso</g:link>
			<g:link action="create" class="btn btn-default">Nuevo aviso</g:link>
		</div>
			
	</form>
	
</g:applyLayout>