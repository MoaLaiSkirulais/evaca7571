<g:applyLayout name="searchContainerCriteria">
	
	<content tag="result">
		<h2>Plazos</h2>

		<table class="table cart-table wishlist-table" cellspacing="0">	
			<thead>
				<tr>
					<th>id</th>
					<th>fechaCreacion</th>
					<th>owner</th>
					<th>nombre</th>											
				</tr>
			</thead>

			<tbody>

				<g:each in="${plazos}" var="plazo" status="i">
					<tr class="item">
						
						<td>
							${plazo.id}
						</td>
						
						<td>
							${plazo.fechaCreacion}
						</td>
						
						<td>
							${plazo.usuario}
						</td>
						
						<td>
							${plazo.nombre}
						</td>
						
						<td class="product-add-to-cart">
							<g:link action="edit" id="${plazo.id}" class="btn btn-default">Modificar</g:link>
						</td>
					</tr><!-- <tr><td colspan="6"></td></tr> -->
				</g:each>					            
			</tbody>
		</table>
		<g:link action="create" class="btn btn-default">Nuevo</g:link>
		
	</content>				

</g:applyLayout>