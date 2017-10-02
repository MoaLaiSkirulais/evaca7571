<g:applyLayout name="layoutTwoColumnsUserLogged">
	
	<content tag="left1">	

		<h3 class="widget-title">Resenas</h3>					
		<div class="table-responsive" id="admin">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr class="item">
						<th>id</th>
						<th>fechaCreacion</th>
						<th>aviso</th>
						<th>revisor</th>
						<th>puntaje</th>											
					</tr>
				</thead>

				<tbody>
					<g:each in="${resenas}" var="resena" status="i">
						<tr class="item">							
							<td>#${resena.id}</td>
							<td>
								<g:formatDate date="${resena.fechaCreacion}" type="datetime"/>
							</td>
							<td>${resena.aviso.id}</td>
							<td>${resena.propietario}</td>
							<td>${resena.puntaje}</td>							
						</tr>

						<tr class="actions">
							<td colspan="5">
								<g:link controller="resena" class="admin-action" action="show" id="${resena.id}">[Ver reseña]</g:link>
							</td>
						</tr>
					</g:each>					            
				</tbody>
			</table>
		</div>
	</content>

</g:applyLayout>