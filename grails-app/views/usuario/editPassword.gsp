<g:applyLayout name="usuario">

    <content tag="left1">
		<h2>cambiar contraseña</h2>

		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:field name="currentPassword" label="Actual"/>
					<myform:field name="newPassword" label="Password"/>
					<myform:field name="newRePassword" label="Repassword" value=""/>
					
				</tbody>
			</table>
			
			<div class="buttons">
				<g:actionSubmit action="setPassword" class="btn btn-default" value="Cambiar"/>
			</div>
			
		</form>
	
	</content>
	
    <content tag="left2">	
	</content>

</g:applyLayout>