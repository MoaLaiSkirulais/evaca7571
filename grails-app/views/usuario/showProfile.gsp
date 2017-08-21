<g:applyLayout name="layoutUserLogged">

    <content tag="left1">
	
		<h3 class="widget-title">Perfil</h3>

		<div style="font-size: 16px; font-weight: 300; line-height: 32.85px; ">
			
			Ingreso: ${usuario.fechaCreacion}<br>
			Acceso: ${usuario.state}<br>
			Nombre: ${usuario.nombre}<br>
			Apellido: ${usuario.apellido}<br>
			Perfil: ${usuario.profile}<br>
			Comisión: ${usuario.comision}<br>
			
			<img src="<g:createLink controller='usuario' action='getAvatarImage' id='1'/>"/>
			
		</div>
	
	</content>
	
    <content tag="left2">
		<h2>Avatar</h2>
		<img src="${usuario.avatar}"/>
	</content>

</g:applyLayout>