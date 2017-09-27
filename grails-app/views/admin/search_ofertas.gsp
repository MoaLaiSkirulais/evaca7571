<g:applyLayout name="admin_layout">
	
    <content tag="body">
	
		<h2>ofertas</h2>
		
		<evaca:cruderror modelo="${ofertas}"/>		
		
		<div class="table-responsive" id="admin">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th class="product-name">fechaCreacion</th>
						<th class="product-name">oferente</th>
						<th class="product-name">aviso</th>
						<th class="product-name">plazo</th>
						<th class="product-name">precio</th>
						<th class="product-name">tbState</th>
					</tr>
				</thead>
					
				<tbody>								
					<g:each in="${ofertas}" var="oferta" status="i">
						<tr class="item">
							
							<td class="product-name">${oferta.fechaCreacion}</td>							
							<td class="product-name">${oferta.propietario}</td>
							<td class="product-name">${oferta.aviso.id} ${oferta.aviso.lote.raza}</td>
							<td class="product-name">${oferta.plazo}</td>
							<td class="product-name">${oferta.precio}</td>
							<td class="product-name"><aviso:entityState state="${oferta.state}"/></td>
																		
						</tr>
						
						<tr class="actions">
							<td class="product-name" colspan="6" style="text-align:right">
								<g:link params="['oferta.id': oferta.id]" class="admin-action" action="aprobar_oferta" id="${oferta.id}">Aprobar | </g:link>
								<g:link params="['oferta.id': oferta.id]" class="admin-action" action="desaprobar_oferta" id="${oferta.id}">Desaprobar</g:link>
							</td>
						</tr>	
					</g:each>					            
				</tbody>
			</table>

		</div>
	</content>
	
</g:applyLayout>