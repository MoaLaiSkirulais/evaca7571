<g:applyLayout name="layoutTwoColumnsUserLogged">
	
    <content tag="left1">
	
		<h2>ofertas</h2>
		
		<g:form method="GET">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<fieldset action="index" class="form">

						<div class="fieldcontain">
							<myform:field label="username" name="filter.username" value="${params.filter?.username}"/>
							<myform:field label="aviso.id" name="filter.aviso.id" value="${params.filter?.aviso?.id}"/>

							<myform:select 
								label="state" 
								name="filter.state" 
								from="${filter.states}" 
								value="${params?.filter?.state}"/>
						</div>

					</fieldset>
				</tbody>
			</table>
			<g:actionSubmit value="Limpiar" action="index" class="btn btn-default"/>
			<g:actionSubmit value="Buscar" action="search_ofertas" class="btn btn-default"/>
		</g:form>
		
		<div class="table-responsive" id="admin">
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr class="item">
						<th>fechaCreacion</th>
						<th>oferente</th>
						<th>aviso</th>
						<th>plazo ofrecido</th>
						<th>precio ofrecido</th>
						<th>tbState</th>
					</tr>
				</thead>
					
				<tbody>								
					<g:each in="${ofertas}" var="oferta" status="i">
						
						<tr class="item">							
							<td>
								<g:formatDate date="${oferta.fechaCreacion}" type="datetime"/>
							</td>
							
							<td>
								<user:avatar usuario="${oferta.propietario}" size="30"/>
								<g:link controller="usuario" class="link" action="show_profile" id="${oferta.propietario.id}">
									${oferta.propietario}
								</g:link>
							</td>

							<td>
								<g:link controller="aviso" class="link" action="show" id="${oferta.aviso.id}">
									${oferta.aviso.id} ${oferta.aviso.lote.raza}
								</g:link>
							</td>

							<td>${oferta.plazo}</td>
							<td>${oferta.precio}</td>
							<td><aviso:entityState state="${oferta.state}"/></td>
						</tr>
						
						<tr class="actions">
							<td class="product-name" colspan="6" style="text-align:right">
								<g:link params="['oferta.id': oferta.id]" class="admin-action" action="aprobar_oferta" id="${oferta.id}">Aprobar | </g:link>
								<g:link params="['oferta.id': oferta.id]" class="admin-action" action="desaprobar_oferta" id="${oferta.id}">Desaprobar</g:link>
							</td>
						</tr>	
					</g:each>					            
				</tbody>
			</table>

		</div>
	</content>
	
</g:applyLayout>