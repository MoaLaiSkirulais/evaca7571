<g:applyLayout name="admin_layout">
	
    <content tag="body">
	
		<h2>usuarios</h2>

		<evaca:cruderror modelo="${usuario}"/>
		
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
								value="${params.filter?.state}"/>
							
							<myform:select 
								label="profile" 
								name="filter.profile" 
								from="${filter.profiles}" 
								value="${params.filter?.profile}"/>

						</div>

					</fieldset>
				</tbody>
			</table>
			<g:actionSubmit value="Limpiar" action="index" class="btn btn-default"/>
			<g:actionSubmit value="Buscar" action="search_usuarios" class="btn btn-default"/>
		</g:form>
		
		<div class="table-responsive" id="admin">
		
			<table class="table cart-table wishlist-table" cellspacing="0">
				<thead>
					<tr>
						<th class="product-name">id</th>
						<th class="product-name">fechaCreacion</th>
						<th class="product-name">username</th>
						<th class="product-name">email</th>
						<th class="product-name">tbTipo</th>
						<th class="product-name">tbSate</th>
					</tr>
				</thead>
				
				<tbody>
					<g:each in="${usuarios}" var="usuario" status="i">

						<tr class="item">
							<td class="product-name">${usuario.id}</td>			
							<td><g:formatDate date="${usuario.fechaCreacion}" type="datetime"/></td>
							<td class="product-name">${usuario.username}</td>
							<td class="product-name">${usuario.email}</td>
							<td class="product-name">${usuario.profile}</td>
							<td class="product-name"><usuario:state value="${usuario.state}"/></td>
						</tr>

						<tr class="actions">
							<td class="product-name" colspan="6" style="text-align:right">
								<g:link params="['filter.username': usuario.username]" class="admin-action" action="search_avisos">
									ver Avisos (${usuario.lotes.size()})|
								</g:link>
								<g:link class="admin-action" action="search_avisos" id="${usuario.id}">ver Ofertas  (${usuario.ofertas.size()})|</g:link>
								<g:link class="admin-action" action="admin" id="${usuario.id}">ver Reseñas</g:link>&nbsp;&nbsp;&nbsp;&nbsp;
								<g:link params="['usuario.id': usuario.id]" class="admin-action" action="aprobar_usuario" id="${usuario.id}">Aprobar | </g:link>
								<g:link params="['usuario.id': usuario.id]" class="admin-action" action="desaprobar_usuario" id="${usuario.id}">Desaprobar</g:link>
							</td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>

	</content>

</g:applyLayout>