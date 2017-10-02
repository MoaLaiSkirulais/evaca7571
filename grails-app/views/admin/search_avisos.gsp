<g:applyLayout name="admin_layout">
	
    <content tag="body">

		<h2>avisos</h2>	
		
		<evaca:cruderror modelo="${avisos}"/>
		
		<g:form method="GET">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<fieldset action="index" class="form">

						<div class="fieldcontain">
							<myform:field label="username" name="filter.username" value="${params.filter?.username}"/>

							<myform:select 
								label="state" 
								name="filter.state" 
								from="${filter.states}" 
								value="${params?.filter?.state}"/>
							
							<myform:select 
								label="plazo" 
								name="filter.plazo.id" 
								from="${filter.plazos}" 
								optionKey="id" 
								optionValue="id"								
								value="${params?.filter?.plazo?.id}"/>
							
							<myform:select 
								label="consignatario" 
								name="filter.consignatario.id" 
								from="${filter.consignatarios}" 
								optionKey="id" 
								optionValue="id"
								value="${params?.filter?.consignatario?.id}"/>

						</div>

					</fieldset>
				</tbody>
			</table>
			<g:actionSubmit value="Limpiar" action="index" class="btn btn-default"/>
			<g:actionSubmit value="Buscar" action="search_avisos" class="btn btn-default"/>
		</g:form>
		
		<div class="table-responsive" id="admin">
		
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr class="item">
						<th>fechaCreacion</th>
						<th>propietario</th>
						<th>lote</th>
						<th>consignatario</th>
						<th>precio</th>
						<th>plazo</th>
						<th>tbState</th>
					</tr>
				</thead>
				
				<tbody>								
					<g:each in="${avisos}" var="aviso" status="i">

						<tr class="item">
							<td><g:formatDate date="${aviso.fechaCreacion}" type="datetime"/></td>
							<td>
								<g:link params="['filter.username': aviso.propietario]" action="search_usuarios">
									${aviso.propietario}
								</g:link>
							</td>

							<td>${aviso.lote.raza}</td>
							
							<td>
								<g:link params="['filter.username': aviso.consignatario]" action="search_usuarios">
									${aviso.consignatario}
								</g:link>
							</td>

							<td>${aviso.precio}</td>    
							<td>${aviso.plazo}</td>    
							<td><aviso:entityState state="${aviso.state}"/></td>
						</tr>
						
						<tr class="actions">
							<td colspan="6" >
								<g:link params="['filter.aviso.id': aviso.id]" class="admin-action" action="search_ofertas">
									ver Ofertas (${aviso.ofertas.size()})
								</g:link>
								
								<g:link class="admin-action" action="admin" id="${aviso.id}">
									ver Reseñas
								</g:link>

								<g:link params="['aviso.id': aviso.id]" class="admin-action" action="aprobar_aviso" id="${aviso.id}">
									Aprobar
								</g:link>
								
								<g:link params="['aviso.id': aviso.id]" class="admin-action" action="desaprobar_aviso" id="${aviso.id}">
									Desaprobar
								</g:link>
							</td>
						</tr>					
					</g:each>					            
				</tbody>
			</table>
		</div>
	</content>

</g:applyLayout>