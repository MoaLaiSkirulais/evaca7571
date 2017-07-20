<g:applyLayout name="searchContainerCriteria">
					
    <content tag="criteria">
		<h2>Avisos</h2>
		<g:form method="GET">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<fieldset action="index" class="form">
							<div class="fieldcontain">
								<!-- <myform:field label="Nombre" name="nombre" value="${params.nombre}"/> -->
								<!-- <myform:field label="consignatario" name="consignatario.nombre" value="${params?.consignatario?.nombre}"/> -->
								<!-- <myform:field label="id" name="usuario.id" value="${params?.usuario?.id}"/> -->
								<!-- <g:datePicker name="mydate" default="none" noSelection="['':'-Choose-']" years="${2012..2020}"/> -->
								
								<myform:select 
									label="Vendedor" 
									name="lote.usuario.id" 
									from="${lote["vendedores"]}" 
									optionKey="id" 
									optionValue="id"
									value="${params.lote?.usuario?.id}"/>
								
								<myform:select 
									label="Consignatarios" 
									name="consignatario.id" 
									from="${lote["consignatarios"]}"
									optionKey="id" 
									optionValue="id"
									value="${params?.consignatario?.id}"/>
								
								<myform:select 
									label="Categoria" 
									name="categoria.id" 
									from="${lote["categorias"]}" 
									value="${params?.lote?.categoria?.id}"/>

								<myform:select 
									label="Raza" 
									name="raza.id" 
									from="${lote["razas"]}" 
									value="${params?.lote?.raza?.id}"/>

								<myform:select 
									label="tbState" 
									name="tbState" 
									from="['Borrador', 'Publicado', 'Finalizado', 'Vendido','Aprobacion']" 
									value="${params?.tbState}"/>

							</div>
							
					</fieldset>
				</tbody>
			</table>
			<g:actionSubmit value="Limpiar" action="index" class="btn btn-default"/>
			<g:actionSubmit value="Buscar" action="index" class="btn btn-default"/>
		</g:form>
    </content>

	<content tag="result">
		<table class="table cart-table wishlist-table" cellspacing="0">
			<thead>
				<tr>
					<th class="product-name">fechaCreacion / lote</th>
					<!-- <th class="product-name">lote</th> -->
					<th class="product-name">tbState</th>
					<th class="product-name">consignatario</th>
					<th class="product-name">precio</th>
				</tr>
			</thead>
			
			<tbody>								
				<g:each in="${avisos}" var="item" status="i">
					<tr class="item">
						
						<td class="product-name">
							${item.fechaCreacion}<br>
							${item.lote}
						</td>
						
						<!-- <td class="product-name"> -->
							<!-- ${item.lote} -->
						<!-- </td> -->
						
						<td class="product-name">
							${item.state}
						</td>
						
						<td class="product-name">
							${item.consignatario}
						</td>
						
						<td class="product-name">
							${item.precio}
						</td>    
						
						<td class="product-add-to-cart">
							<g:link action="edit" id="${item.id}" class="btn btn-default">Modificar</g:link>
						</td>
					</tr><!-- <tr><td colspan="6"></td></tr> -->
				</g:each>					            
			</tbody>
		</table>
		<g:link action="create" controller="aviso" class="btn btn-default">create</g:link>
    </content>

</g:applyLayout>