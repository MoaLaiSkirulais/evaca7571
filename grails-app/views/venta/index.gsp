<g:applyLayout name="searchContainer">
	
	<h2>Ventas</h2>
	
	<div class="col-sm-12">		
	
		<div class="table-responsive">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th class="product-name">id</th>
						<th class="product-name">fechaCreacion</th>
						<th class="product-name">usuario</th>
						<th class="product-name">aviso</th>
						<th class="product-name">oferta</th>
						<th class="product-name">precio</th>
						<th class="product-name">tbState</th>
					</tr>
				</thead>
				
				<tbody>								
					<g:each in="${ventas}" var="item" status="i">
						<tr class="item">
							
							<td class="product-name">
								${item.id}
							</td>
							
							<td class="product-name">
								${item.fechaCreacion}
							</td>
							
							<td class="product-name">
								${item.oferta.usuario}
							</td>
							
							<td class="product-name">
								${item.oferta.aviso}
							</td>
																		
							<td class="product-name">
								${item.oferta}
							</td>
																		
							<td class="product-name">
								${item.oferta.precio}
							</td>
																		
							<td class="product-name">
								${item.oferta.tbState}
							</td>
																		
							<td class="product-add-to-cart">
								<g:link action="edit" id="${item.id}" class="btn btn-default">Modificar</g:link>
							</td>
						</tr><!-- <tr><td colspan="6"></td></tr> -->
					</g:each>					            
				</tbody>
			</table>
			<g:link action="create" class="btn btn-default">Nuevo</g:link>
		</div><!-- /.table-responsive -->
	</div>

</g:applyLayout>