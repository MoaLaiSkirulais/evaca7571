<g:applyLayout name="layoutTwoColumnsUserLogged">
	
	<content tag="left1">	

		<h3 class="widget-title">Resenas</h3>					
		<div class="table-responsive" id="admin">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th>id</th>
						<th>fechaCreacion</th>
						<th>usuario</th>
						<th>venta</th>											
						<th>puntaje</th>											
					</tr>
				</thead>

				<tbody>
					<g:each in="${resenas}" var="resena" status="i">
						<tr class="item">							
							<td>${resena.id}</td>
							<td>${resena.fechaCreacion}</td>
							<td>${resena.propietario}</td>
							<td>${resena.venta}</td>
							<td>${resena.puntaje}</td>							
						</tr>

						<tr class="actions">
							<td colspan="5">
								<g:link controller="resena" class="admin-action" action="edit" id="${resena.id}">Ver</g:link>
							</td>
						</tr>
					</g:each>					            
				</tbody>
			</table>
			<g:link action="create" class="btn btn-default">Nuevo</g:link>
		</div><!-- /.table-responsive -->
	</content>

</g:applyLayout>