<g:applyLayout name="layoutTwoColumnsUserLogged">
	
    <content tag="left1">

		<h2>resenas</h2>
		
		<div class="table-responsive" id="admin">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr class="item">
						<th>id</th>
						<th>fechaCreacion</th>
						<th>aviso</th>
						<th>reviewer</th>
						<th>puntaje</th>
						<th>tbSate</th>
					</tr>
				</thead>

				<tbody>
					<g:each in="${resenas}" var="resena" status="i">
						<tr class="item">							
							<td>${resena.id}</td>
							<td>
								<g:formatDate date="${resena.fechaCreacion}" type="datetime"/>
							</td>
							<td>
								<user:avatar usuario="${resena.aviso.propietario}" size="30"/>
								<g:link controller="aviso" class="link" action="show" id="${resena.aviso.id}">
									${resena.aviso.id} ${resena.aviso.lote.raza} | $${resena.aviso.precio}
								</g:link>
							</td>
							<td>
								<user:avatar usuario="${resena.propietario}" size="30"/>
								<g:link controller="usuario" class="link" action="show_profile" id="${resena.propietario.id}">
									${resena.propietario}
								</g:link>
							</td>
							<td>
								<user:stars value="${resena.puntaje}"/>
							</td>
							<td><aviso:entityState state="${resena.state}"/></td>
						</tr>
						
						<tr class="actions">
							<td class="product-name" colspan="6" style="text-align:right">
								<g:link params="['resena.id': resena.id]" class="admin-action" action="aprobar_resena" id="${resena.id}">Aprobar | </g:link>
								<g:link params="['resena.id': resena.id]" class="admin-action" action="desaprobar_resena" id="${resena.id}">Desaprobar</g:link>
							</td>
						</tr>
					</g:each>					            
				</tbody>
			</table>
			
		</div>

	</content>	
	
</g:applyLayout>