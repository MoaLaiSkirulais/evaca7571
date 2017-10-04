<g:applyLayout name="layoutTwoColumnsUserLogged">
	
	<content tag="left1">

		<h3 class="widget-title">Mis avisos</h3>
		
		<div class="table-responsive" id="admin">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr class="item">
						<th>id</th>
						<th>fechaCreacion</th>
						<th>raza</th>
						<th>categoria</th>
						<th>state</th>
						<th>consignatario</th>
						<th>precio</th>
						<th>state</th>
					</tr>
				</thead>
				
				<tbody>

					<g:each in="${lotes}" var="lote" status="i">
						<tr class="item">
							
							<td>#${lote.id}</td>
							<td>
								<g:formatDate date="${lote.fechaCreacion}" type="datetime"/>
							</td>
							<td>${lote.raza}</td>
							<td>${lote.categoria}</td>
							<td><aviso:entityState state="${lote.state}"/></td>
							<td>${lote.aviso.consignatario}</td>
							<td>$${lote.aviso.precio}</td>
							<td><aviso:entityState state="${lote.aviso.state}"/></td>

						</tr>

						<tr class="actions">
							<td colspan="8" >
								<g:link controller="oferta" params="['filter.lote.aviso.id': lote.aviso.id]" class="admin-action" action="search">
									Ofertas(${lote.aviso.ofertas.size()})
								</g:link>

								<g:link class="admin-action" action="admin" id="${lote.aviso.id}">
									Reseñas(${lote.aviso.resenas.size()})
								</g:link>

								<g:link id="${lote.id}" class="admin-action" action="show" id="${lote.id}">
									Ver
								</g:link>

								<g:link id="${lote.id}" class="admin-action" action="edit" id="${lote.id}">
									Modificar
								</g:link>
							</td>
						</tr>
					</g:each>					            
				</tbody>
			</table>
			<g:link action="create" class="btn btn-default">Nuevo aviso</g:link>
		</div><!-- /.table-responsive -->
    </content>
</g:applyLayout>