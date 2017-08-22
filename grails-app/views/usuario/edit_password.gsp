<g:applyLayout name="layoutUserLogged">

    <content tag="left1">

		<h3 class="widget-title">cambiar contraseña</h3>

		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:field name="usuarioId" label="usuarioId" value="1"/>
					<myform:field name="currentPassword" label="Actual"/>
					<myform:field name="password" label="Password"/>
					<myform:field name="rePassword" label="Repassword" value=""/>
					
				</tbody>
			</table>
			
			<div class="buttons">
				<g:actionSubmit action="savePassword" class="btn btn-default" value="Cambiar"/>
			</div>
			
		</form>
	
	</content>
	
    <content tag="left2">	
	</content>

</g:applyLayout>