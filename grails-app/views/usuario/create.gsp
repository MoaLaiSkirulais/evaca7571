<g:applyLayout name="crudContainerTwoCols">

    <content tag="left1">
		<h3>nuevo usuario</h3>
		<!-- <evaca:cruderror modelo="${usuario}"/> -->

		<form method="post">

			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:field name="email" label="Email" value="${usuario.email}"/>
					<myform:field name="username" label="Username" value="${usuario.username}"/>
					<myform:field name="password" label="Password" value="${usuario.password}"/>
					<myform:field name="repassword" label="Repassword" value=""/>
		
					<myform:separator label="Perfil"/>
					<myform:field name="nombre" label="Nombre" value="${usuario.nombre}"/>
					<myform:field name="apellido" label="Apellido" value="${usuario.apellido}"/>
					<myform:select name="profile" label="Perfil" from="${profiles}" value="${usuario.profile}"/>
					<myform:field name="comision" label="Comisión" value="${usuario.comision}"/>
					
				</tbody>
			</table>
			
			<div class="buttons">
				<g:actionSubmit action="postular" class="btn btn-default" value="Postular"/>
			</div>			
			
		</form>
	
	</content>

    <content tag="left2">
	</content>

</g:applyLayout>