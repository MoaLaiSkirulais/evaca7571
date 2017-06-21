<g:applyLayout name="searchContainerCriteria">
					
    <content tag="criteria">
		<h2>Razas</h2>
		<g:form method="GET">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<fieldset action="index" class="form">
							<div class="fieldcontain">
								<myform:field label="Nombre" name="nombre" value="${params.nombre}"/>
								<myform:field label="usuario" name="usuario.nombre" value="${params?.usuario?.nombre}"/>
								<myform:field label="id" name="usuario.id" value="${params?.usuario?.id}"/>
							</div>
							
					</fieldset>
				</tbody>
			</table>
			<g:actionSubmit value="Buscar" action="index" class="btn btn-default"/>
		</g:form>
    </content>

	<content tag="result">
		
		<table class="table cart-table wishlist-table" cellspacing="0">
			<thead>
				<tr>
					<th class="product-name">id</th>
					<th class="product-name">fechaCreacion</th>
					<th class="product-name">owner</th>
					<th class="product-name">nombre</th>											
				</tr>
			</thead>

			<tbody>

				<g:each in="${razas}" var="raza" status="i">
					<tr class="item">
						
						<td class="product-name">
							${raza.id}
						</td>
						
						<td class="product-name">
							${raza.fechaCreacion}
						</td>
						
						<td class="product-name">
							${raza.usuario}
						</td>
						
						<td class="product-name">
							${raza.nombre}
						</td>
						
						<td class="product-add-to-cart">
							<g:link action="edit" id="${raza.id}" class="btn btn-default">Modificar</g:link>
						</td>
					</tr><!-- <tr><td colspan="6"></td></tr> -->
				</g:each>					            
			</tbody>
		</table>
		<g:link action="create" class="btn btn-default">Nuevo</g:link>		
    </content>

</g:applyLayout>