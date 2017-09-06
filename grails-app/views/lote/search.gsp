<g:applyLayout name="layoutTwoColumnsUserLogged">
	
	<content tag="left1">	
		<h3 class="widget-title">Lotes</h3>							
		
		<div class="table-responsive">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th>fechaCreacion</th>
						<th>propietario</th>
						<th>raza</th>
						<th>categoria</th>
						<th>cantidad</th>
						<th>aviso</th>
						<th>foto</th>
					</tr>
				</thead>
				
				<tbody>

					<g:each in="${lotes}" var="lote" status="i">
						<tr class="item">
							
							<td>
								${lote.fechaCreacion}
							</td>

							<td>
								${lote.usuario}
							</td>
							
							<td>
								${lote.raza}
							</td>
							
							<td>
								${lote.categoria}
							</td>
							
							<td>
								${lote.cantidad}
							</td>
							
							<td>
								${lote.aviso}
							</td>    
							
							<td>
								<img src="<g:createLink controller='lote' action='get_image' id='${lote.id}'/>" height="70px" />
							</td>    
							
							<td class="product-add-to-cart">
								<g:link action="edit" id="${lote.id}" class="btn btn-default">
									Modificar
								</g:link>
							</td>
						</tr><!-- <tr><td colspan="6"></td></tr> -->
					</g:each>					            
				</tbody>
			</table>
			<g:link action="create" class="btn btn-default">Nuevo</g:link>
		</div><!-- /.table-responsive -->
	</content>
</g:applyLayout>