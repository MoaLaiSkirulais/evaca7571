<g:applyLayout name="layoutTwoColumnsUserLogged">
	
	<content tag="left1">	

		<h3 class="widget-title">Resenas</h3>					
		<div class="table-responsive">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th class="product-name">id</th>
						<th class="product-name">fechaCreacion</th>
						<th class="product-name">usuario</th>
						<th class="product-name">venta</th>											
						<th class="product-name">puntaje</th>											
					</tr>
				</thead>

				<tbody>

					<g:each in="${resenas}" var="resena" status="i">
						<tr class="item">
							
							<td class="product-name">
								${resena.id}
							</td>
							
							<td class="product-name">
								${resena.fechaCreacion}
							</td>
							
							<td class="product-name">
								${resena.propietario}
							</td>
							
							<td class="product-name">
								${resena.venta}
							</td>
							
							<td class="product-name">
								${resena.puntaje}
							</td>
							
							<td class="product-add-to-cart">
								<g:link action="edit" id="${resena.id}" class="btn btn-default">Modificar</g:link>
							</td>
						</tr><!-- <tr><td colspan="6"></td></tr> -->
					</g:each>					            
				</tbody>
			</table>
			<g:link action="create" class="btn btn-default">Nuevo</g:link>
		</div><!-- /.table-responsive -->
	</content>

</g:applyLayout>