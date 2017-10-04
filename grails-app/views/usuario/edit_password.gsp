<g:applyLayout name="layoutThreeColumnsUserLogged">

    <content tag="left1">

		<h3 class="widget-title">cambiar contraseña</h3>
		
		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:field name="usuario.id" label="" value="${usuario.id}" style="display:none"/>
					<myform:field name="currentPassword" label="Actual" type="password"/>
					<myform:field name="newPassword" label="Password" type="password" value=""/>
					<myform:field name="newRepassword" label="Repassword" value="" type="password"/>
				</tbody>
			</table>
			
			<div class="buttons">
				<g:actionSubmit action="save_password" class="btn btn-default" value="Cambiar"/>
			</div>
			
		</form>
	
	</content>
	
    <content tag="left2">	
	</content>

</g:applyLayout>