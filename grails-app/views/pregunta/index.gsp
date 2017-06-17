<g:applyLayout name="searchContainer">
					
	<h2>Pregunta</h2>
	<div class="col-sm-12">

		<div class="table-responsive">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th class="product-name">id</th>
						<th class="product-name">fechaCreacion</th>
						<th class="product-name">owner</th>
						<th class="product-name">pregunta</th>											
					</tr>
				</thead>

				<tbody>

					<g:each in="${preguntas}" var="pregunta" status="i">
						<tr class="item">
							
							<td class="product-name">
								${pregunta.id}
							</td>
							
							<td class="product-name">
								${pregunta.fechaCreacion}
							</td>
							
							<td class="product-name">
								${pregunta.usuario}
							</td>
							
							<td class="product-name">
								${pregunta.label}
							</td>
							
							<td class="product-add-to-cart">
								<g:link action="edit" id="${pregunta.id}" class="btn btn-default">Modificar</g:link>
							</td>
						</tr><!-- <tr><td colspan="6"></td></tr> -->
					</g:each>					            
				</tbody>
			</table>
			<g:link action="create" class="btn btn-default">Nuevo</g:link>
		</div><!-- /.table-responsive -->
	</div>

</g:applyLayout>