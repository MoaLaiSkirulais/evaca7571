<g:applyLayout name="layoutTwoColumnsUserLogged">

    <content tag="left1">
		
		<h3 class="widget-title">Modificar Perfil</h3>

		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:field name="usuarioId" label="usuarioId" value="1"/>
					<myform:field name="nombre" label="Nombre" value="${usuario.nombre}"/>
					<myform:field name="apellido" label="Apellido" value="${usuario.apellido}"/>
					<myform:field name="comision" label="Comisión" value="${usuario.comision}"/>					
				</tbody>
			</table>
			
			<div class="buttons">
				<g:actionSubmit action="saveProfile" class="btn btn-default" value="guardar"/>
			</div>			
			
		</form>
	
	</content>
	
    <content tag="left2">
		<h2>Avatar</h2>
		<img src="${usuario.avatar}"/>
		


	</content>

</g:applyLayout>