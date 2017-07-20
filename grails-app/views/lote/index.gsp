<g:applyLayout name="searchContainer">
	
	<h2>Lotes</h2>
	<div class="col-sm-12">						
	
		<div class="table-responsive">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th class="product-name">fechaCreacion</th>
						<th class="product-name">usuario</th>
						<th class="product-name">raza</th>
						<th class="product-name">categoria</th>
						<th class="product-name">cantidad</th>
						<th class="product-name">ubicacion</th>
						<th class="product-name">pesoPromedio</th>
					</tr>
				</thead>
				
				<tbody>

					<g:each in="${lotes}" var="lote" status="i">
						<tr class="item">
							
							<td class="product-name">
								${lote.fechaCreacion}
							</td>

							<td class="product-name">
								${lote.usuario}
							</td>
							
							<td class="product-name">
								${lote.raza}
							</td>
							
							<td class="product-name">
								${lote.categoria}
							</td>
							
							<td class="product-name">
								${lote.cantidad}
							</td>
							
							<td class="product-name">
								${lote.ubicacion}
							</td>    
							
							<td class="product-name">
								${lote.pesoPromedio}
							</td>
							
							<td class="product-add-to-cart">
								<g:link action="edit" id="${lote.id}" class="btn btn-default">Modificar</g:link>
							</td>
						</tr><!-- <tr><td colspan="6"></td></tr> -->
					</g:each>					            
				</tbody>
			</table>
			<g:link action="create" class="btn btn-default">Nuevo</g:link>
		</div><!-- /.table-responsive -->
</g:applyLayout>