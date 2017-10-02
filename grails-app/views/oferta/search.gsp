<g:applyLayout name="layoutTwoColumnsUserLogged">

	<content tag="left1">	
		<h3 class="widget-title">Ofertas</h3>
		
		<div class="table-responsive" id="admin">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr class="item">
						<th>id</th>
						<th>fechaCreacion</th>
						<th>aviso</th>
						<th>comprador</th>
						<th>plazo</th>
						<th>precio</th>
						<th>tbState</th>
					</tr>
				</thead>
					
				<tbody>								
					<g:each in="${ofertas}" var="oferta" status="i">
						<tr class="item">
							
							<td>${oferta.id}</td>
							<td>
								<g:formatDate date="${oferta.fechaCreacion}" type="datetime"/>
							</td>

							<td>${oferta.aviso.lote.id}</td>
							<td>${oferta.propietario}</td>
							<td>${oferta.plazo}</td>
							<td>${oferta.precio}</td>

							<td>
								<aviso:entityState state="${oferta.state}"/>
							</td>

						</tr>
						
						<tr class="actions">
							<td colspan="6" >
								<g:link controller="aviso" params="['oferta.id': oferta.id]" class="admin-action" action="aceptar_oferta" id="${oferta.id}">Aceptar</g:link>
							</td>
						</tr>

					</g:each>					            
				</tbody>
			</table>
			<g:link action="create" class="btn btn-default">Nuevo</g:link>
		</div><!-- /.table-responsive -->
	</content>

</g:applyLayout>