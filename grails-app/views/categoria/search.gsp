<g:applyLayout name="searchContainerCriteria">
	
	<content tag="result">
		<h2>Categorias</h2>
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

				<g:each in="${categorias}" var="categoria" status="i">
					<tr class="item">
						
						<td class="product-name">
							${categoria.id}
						</td>
						
						<td class="product-name">
							${categoria.fechaCreacion}
						</td>
						
						<td class="product-name">
							${categoria.usuario}
						</td>
						
						<td class="product-name">
							${categoria.nombre}
						</td>
						
						<td class="product-add-to-cart">
							<g:link action="edit" id="${categoria.id}" class="btn btn-default">Editar</g:link>
						</td>
					</tr><!-- <tr><td colspan="6"></td></tr> -->
				</g:each>					            
			</tbody>
		</table>
		<g:link action="create" class="btn btn-default">Nuevo</g:link>
	</content>				

</g:applyLayout>