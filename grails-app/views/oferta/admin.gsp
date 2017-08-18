<g:applyLayout name="crudContainerTwoCols">

    <content tag="left1">

		<h2>Oferta</h2>
		<evaca:cruderror modelo="${oferta}"/>

		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>

					<myform:display label="#id" value="${oferta.id}"/>
					<myform:display label="State" value="${oferta.state}"/>
					<myform:display label="Propietario" value="${oferta.propietario}"/>
					<myform:display label="Ingreso" value="${oferta.fechaCreacion}"/>
					<myform:display label="Precio" value="${oferta.precio}"/>
					<myform:display label="Aviso" value="${oferta?.aviso}"/>
					<myform:display label="Plazo" value="${oferta?.plazo}"/>
					
				</tbody>
			</table>
			
			<div class="buttons">

				<g:actionSubmit action="aprobar" class="btn btn-default" value="admin.aprobar()"/>
				<g:actionSubmit action="desaprobar" class="btn btn-default" value="admin.desaprobar()"/>

			</div>
		</form>
	</content>

    <content tag="left2">
	</content>

</g:applyLayout>