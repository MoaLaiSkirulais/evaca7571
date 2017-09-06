<g:applyLayout name="layoutTwoColumnsUserLogged">

	<content tag="left1">	
		<h3 class="widget-title">Ofertas</h3>
		
		<div class="table-responsive">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th class="product-name">fechaCreacion</th>
						<th class="product-name">propietario</th>
						<th class="product-name">aviso</th>
						<th class="product-name">plazo</th>
						<th class="product-name">precio</th>
						<th class="product-name">tbState</th>
					</tr>
				</thead>
					
				<tbody>								
					<g:each in="${ofertas}" var="item" status="i">
						<tr class="item">
							
							<td class="product-name">
								${item.fechaCreacion}
							</td>
							
							<td class="product-name">
								${item.propietario}
							</td>
							
							<td class="product-name">
								${item.aviso}
							</td>
																		
							<td class="product-name">
								${item.plazo}
							</td>
																		
							<td class="product-name">
								${item.precio}
							</td>
																		
							<td class="product-name">
								${item.state}
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
	</content>

</g:applyLayout>