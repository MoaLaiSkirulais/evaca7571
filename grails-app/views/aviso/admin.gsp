<g:applyLayout name="crudContainer">

	<h2>aviso</h2>
	<evaca:cruderror modelo="${aviso}"/>

	<form method="post">
		<table class="table table-condensed" cellspacing="0">
			<tbody>
				
				<myform:display name="id" label="#id" value="${aviso.id}"/>
				<myform:display label="State" value="${aviso.state}"/>
				<myform:display label="Propietario" value="${aviso.propietario}"/>
				<myform:display label="Ingreso" value="${aviso.fechaCreacion}"/>
				<myform:display label="Precio" value="${aviso.precio}"/>				
				<myform:display	label="Consignatario" value="${aviso?.consignatario}"/>
				<myform:display label="Lote" value="${aviso?.lote}"/>

			</tbody>
		</table>
		
		<div class="buttons">

			<g:actionSubmit action="aprobar" class="btn btn-default" value="admin.aprobar()"/>
			<g:actionSubmit action="rechazar" class="btn btn-default" value="admin.rechazar()"/>

		</div>
			
	</form>
	
</g:applyLayout>