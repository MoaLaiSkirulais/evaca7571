<g:applyLayout name="layoutTwoColumnsUserLogged">
	
	<content tag="sidebar">
		<h2>Lotes</h2>
		<g:form method="GET">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<fieldset action="index" class="form">
						<div class="fieldcontain">
						</div>							
					</fieldset>
				</tbody>
			</table>
			<g:actionSubmit value="Buscar" action="index" class="btn btn-default"/>
		</g:form>
    </content>
	
	<content tag="left1">
		
		<div class="table-responsive" id="admin">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th>fechaCreacion</th>
						<th>id</th>
						<th>propietario</th>
						<th>raza</th>
						<th>categoria</th>
						<th>cantidad</th>
						<th>aviso</th>
						<!-- <th>foto</th> -->
					</tr>
				</thead>
				
				<tbody>

					<g:each in="${lotes}" var="lote" status="i">
						<tr class="item">
							
							<td>
								<g:formatDate date="${lote.fechaCreacion}" type="datetime"/>
							</td>

							<td>${lote.id}</td>						
							<td>${lote.propietario}</td>						
							<td>${lote.raza}</td>							
							<td>${lote.categoria}</td>						
							<td>${lote.cantidad}</td>
							<td>${lote.aviso.state}</td>

						</tr>

						<tr class="actions">
							<td colspan="7" >
								<g:link id="${lote.id}" class="admin-action" action="show" id="${lote.id}">Ver |</g:link>
								<g:link id="${lote.id}" class="admin-action" action="edit" id="${lote.id}">Modificar</g:link>
							</td>
						</tr>
					</g:each>					            
				</tbody>
			</table>
			<g:link action="create" class="btn btn-default">Nuevo</g:link>
		</div><!-- /.table-responsive -->
    </content>
</g:applyLayout>