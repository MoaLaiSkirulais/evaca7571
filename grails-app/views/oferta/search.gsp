<g:applyLayout name="layoutTwoColumnsUserLogged">

	<content tag="left1">	
		<h3 class="widget-title">Ofertas</h3>
		
		<div class="table-responsive" id="admin">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th>fechaCreacion</th>
						<th>propietario</th>
						<th>aviso</th>
						<th>plazo</th>
						<th>precio</th>
						<th>tbState</th>
					</tr>
				</thead>
					
				<tbody>								
					<g:each in="${ofertas}" var="item" status="i">
						<tr class="item">
							
							<td>
								<g:formatDate date="${item.fechaCreacion}" type="datetime"/>
							</td>
							
							<td>${item.propietario}</td>
							<td>${item.aviso.id}</td>																		
							<td>${item.plazo}</td>
							<td>${item.precio}</td>

							<td>
								<aviso:entityState state="${item.state}"/>
							</td>

						</tr>
						
						<tr class="actions">
							<td colspan="6" >
								<g:link controller="aviso" params="['oferta.id': item.id]" class="admin-action" action="aceptar_oferta" id="${item.id}">Aceptar</g:link>
							</td>
						</tr>

					</g:each>					            
				</tbody>
			</table>
			<g:link action="create" class="btn btn-default">Nuevo</g:link>
		</div><!-- /.table-responsive -->
	</content>

</g:applyLayout>