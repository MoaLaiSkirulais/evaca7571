<g:applyLayout name="usuario">

    <content tag="left1">

		<evaca:cruderror modelo="${usuario}"/>

		<form method="post">
			
				<g:link action="index" class="btn btn-default">admin.buscar</g:link>
				<g:actionSubmit action="aprobar" class="btn btn-default" value="admin.aprobar"/>
				<g:actionSubmit action="desaprobar" class="btn btn-default" value="admin.desaprobar"/>

				<br><br>

				<g:link params="${[usuario,[id:usuario.id]]}" controller="aviso" action="index" class="btn btn-default green">Avisos</g:link>
				<g:link params="${[usuario,[id:usuario.id]]}" controller="lote" action="index" class="btn btn-default green">Lotes</g:link>
				<g:link params="${[usuario,[id:usuario.id]]}" controller="oferta" action="index" class="btn btn-default green">Ofertas</g:link>
				<g:link params="${[usuario,[id:usuario.id]]}" controller="resena" action="index" class="btn btn-default green">Resenas</g:link>
				<g:link params="${[usuario,[id:usuario.id]]}" controller="venta" action="index" class="btn btn-default green">Ventas</g:link>

		</form>
	
	</content>
	
    <content tag="left2">
		<h2>Avatar</h2>
		<img src="${usuario.avatar}"/>
	</content>

</g:applyLayout>