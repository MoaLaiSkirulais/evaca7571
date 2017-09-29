<g:applyLayout name="admin_layout">
	
    <content tag="body">
	
		<h2>ofertas</h2>
		
		<evaca:cruderror modelo="${ofertas}"/>
		
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
						<th>plazo</th>
						<th>precio</th>
						<th>tbState</th>
					</tr>
				</thead>
					
				<tbody>								
					<g:each in="${ofertas}" var="oferta" status="i">
						
						<tr class="item">							
							<td><g:formatDate date="${oferta.fechaCreacion}" type="datetime"/></td>
							<td>${oferta.propietario}</td>
							<td>${oferta.aviso.id} ${oferta.aviso.lote.raza}</td>
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