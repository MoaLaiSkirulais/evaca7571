<g:applyLayout name="searchContainer">
					
	<h2>Razas</h2>
	<div class="col-sm-12">

		<div class="table-responsive">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th class="product-name">id</th>
						<th class="product-name">fechaCreacion</th>
						<th class="product-name">owner</th>
						<th class="product-name">nombre</th>											
					</tr>
				</thead>

				<tbody>

					<g:each in="${razas}" var="raza" status="i">
						<tr class="item">
							
							<td class="product-name">
								${raza.id}
							</td>
							
							<td class="product-name">
								${raza.fechaCreacion}
							</td>
							
							<td class="product-name">
								${raza.usuario}
							</td>
							
							<td class="product-name">
								${raza.nombre}
							</td>
							
							<td class="product-add-to-cart">
								<!-- <button class="btn btn-default" type="button">Editar</button> -->
								<g:link action="edit" style="color:#e74c3c" id="${raza.id}">[edit]</g:link>

							</td>
						</tr><!-- <tr><td colspan="6"></td></tr> -->
					</g:each>					            
				</tbody>
			</table>
			<g:link action="create" class="btn btn-default">create</g:link>
		</div><!-- /.table-responsive -->
	</div>

</g:applyLayout>