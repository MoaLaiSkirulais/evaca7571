<g:applyLayout name="admin_layout">
	
    <content tag="body">

		<h2>resenas</h2>
		
		<div class="table-responsive" id="admin">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th class="product-name">id</th>
						<th class="product-name">fechaCreacion</th>
						<th class="product-name">usuario</th>
						<th class="product-name">venta</th>
						<th class="product-name">puntaje</th>
						<th class="product-name">tbSate</th>
					</tr>
				</thead>

				<tbody>

					<g:each in="${resenas}" var="resena" status="i">
						<tr class="item">							
							<td class="product-name">${resena.id}</td>
							<td class="product-name">${resena.fechaCreacion}</td>
							<td class="product-name">${resena.propietario}</td>
							<td class="product-name">${resena.venta}</td>
							<td class="product-name">${resena.puntaje}</td>
							<td class="product-name"><aviso:entityState state="${resena.state}"/></td>
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