<g:applyLayout name="searchContainer">
	
	<h2>Usuarios</h2>
	<div class="col-sm-12">						
	
		<div class="table-responsive">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th class="product-name">id</th>
						<th class="product-name">fechaCreacion</th>
						<th class="product-name">nombre</th>
						<th class="product-name">apellido</th>
						<th class="product-name">email</th>
						<th class="product-name">tbTipo</th>
						<th class="product-name">tbSate</th>
					</tr>
				</thead>
				
				<tbody>

					<g:each in="${usuarios}" var="usuario" status="i">
						<tr class="item">
							
							<td class="product-name">
								${usuario.id}
							</td>
							
							<td class="product-name">
								${usuario.fechaCreacion}
							</td>
							
						   <td class="product-name">
								${usuario.nombre}
							</td>
							
						   <td class="product-name">
								${usuario.apellido}
							</td>
							
						   <td class="product-name">
								${usuario.email}
							</td>
							
						   <td class="product-name">
								${usuario.profile}
							</td>    
							
						   <td class="product-name">
								<usuario:state value="${usuario.state}"/>
							</td>
							
							<td class="product-add-to-cart">
								<g:link action="edit" id="${usuario.id}" class="btn btn-default">Modificar</g:link>
							</td>
						</tr><!-- <tr><td colspan="6"></td></tr> -->
					</g:each>
				</tbody>
			</table>
			<g:link action="create" controller="usuario" class="btn btn-default">Nuevo</g:link>
		</div><!-- /.table-responsive -->
		
</g:applyLayout>