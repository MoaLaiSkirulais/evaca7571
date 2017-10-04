<g:applyLayout name="layoutThreeColumnsUserLogged">

    <content tag="left1">
		
		<h3 class="widget-title">Modificar Perfil</h3>

		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:field name="usuario.id" label="" value="${usuario.id}" style="display:none"/>
					<myform:field name="usuario.nombre" label="Nombre" value="${usuario.nombre}"/>
					<myform:field name="usuario.apellido" label="Apellido" value="${usuario.apellido}"/>
					<myform:field name="usuario.comision" label="Comisión" value="${usuario.comision}"/>					
				</tbody>
			</table>
			
			<div class="buttons">
				<g:actionSubmit action="save_profile" class="btn btn-default" value="guardar"/>
			</div>			
			
		</form>
	
	</content>
	
</g:applyLayout>