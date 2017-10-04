<g:applyLayout name="layoutTwoColumnsUserLogged">
	
    <content tag="left1">
	
		<h3 class="widget-title">usuarios</h3>

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
					<tr class="item">
						<th>id</th>
						<th>fechaCreacion</th>
						<th>username</th>
						<th>email</th>
						<th>tbTipo</th>
						<th>tbSate</th>
					</tr>
				</thead>
				
				<tbody>
					<g:each in="${usuarios}" var="usuario" status="i">

						<tr class="item">
							<td>${usuario.id}</td>			
							<td><g:formatDate date="${usuario.fechaCreacion}" type="datetime"/></td>
								
							<td>
								<g:link controller="usuario" action="show_profile" id="${usuario.id}">
									${usuario.username} 
								</g:link>								
							</td>

							<td>${usuario.email}</td>
							<td>${usuario.profile}</td>
							<td><usuario:state value="${usuario.state}"/></td>
						</tr>

						<tr class="actions">
							<td class="product-name" colspan="6" style="text-align:right">

								<g:link params="['filter.username': usuario.username]" class="admin-action" action="search_avisos">
									Avisos(${usuario.lotes.size()})
								</g:link>

								<g:link class="admin-action" action="search_avisos" id="${usuario.id}">
									Ofertas(${usuario.ofertas.size()})
								</g:link>

								<g:link class="admin-action" action="admin" id="${usuario.id}">
									Reseñas
								</g:link>

								<g:link params="['usuario.id': usuario.id]" class="admin-action" action="aprobar_usuario" id="${usuario.id}">
									Aprobar
								</g:link>
								
								<g:link params="['usuario.id': usuario.id]" class="admin-action" action="desaprobar_usuario" id="${usuario.id}">
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