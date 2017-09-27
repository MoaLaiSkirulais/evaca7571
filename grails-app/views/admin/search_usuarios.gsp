<g:applyLayout name="admin_layout">
	
    <content tag="body">
	
		<h2>usuarios</h2>
		
		<evaca:cruderror modelo="${usuario}"/>
		
		<div class="table-responsive" id="admin">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th class="product-name">id</th>
						<th class="product-name">fechaCreacion</th>
						<th class="product-name">username</th>
						<th class="product-name">email</th>
						<th class="product-name">tbTipo</th>
						<th class="product-name">tbSate</th>
					</tr>
				</thead>
				
				<tbody>
					<g:each in="${usuarios}" var="usuario" status="i">

						<tr class="item">
							<td class="product-name">${usuario.id}</td>			
							<td class="product-name">${usuario.fechaCreacion}</td>
							<td class="product-name">${usuario.username}</td>
							<td class="product-name">${usuario.email}</td>
							<td class="product-name">${usuario.profile}</td>
							<td class="product-name"><usuario:state value="${usuario.state}"/></td>
						</tr>

						<tr class="actions">
							<td class="product-name" colspan="6" style="text-align:right">
								<g:link class="admin-action" action="admin" id="${usuario.id}">ver Avisos (${usuario.lotes.size()})|</g:link>
								<g:link class="admin-action" action="admin" id="${usuario.id}">ver Ofertas |</g:link>
								<g:link class="admin-action" action="admin" id="${usuario.id}">ver Reseñas</g:link>&nbsp;&nbsp;&nbsp;&nbsp;
								<g:link params="['usuario.id': usuario.id]" class="admin-action" action="aprobar_usuario" id="${usuario.id}">Aprobar | </g:link>
								<g:link params="['usuario.id': usuario.id]" class="admin-action" action="desaprobar_usuario" id="${usuario.id}">Desaprobar</g:link>
							</td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>

	</content>

</g:applyLayout>