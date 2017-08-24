<g:applyLayout name="layoutUserLogged">

    <content tag="left1">	
		<h3 class="widget-title">Lote</h3>	
		
		<evaca:cruderror modelo="${lote}"/>
		
		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:display name="id" label="#id" value="${lote.id}"/>
					<myform:display name="usuario" label="Propietario" value="${lote.usuario}"/>
					<g:hiddenField name="usuario.id" value="${lote.usuario.id}"/>
					<myform:display name="fechaCreacion" label="Creacion" value="${lote.fechaCreacion}"/>
					
					<myform:select 
						label="Categoria" 	
						name="categoria.id" 
						from="${categorias}" value="${lote?.categoria?.id}" 
						optionKey="id"
					/>
					<myform:select 
						label="Raza" 	
						name="raza.id" 
						from="${razas}" value="${lote?.raza?.id}" 
						optionKey="id"
					/>				
					
					<myform:separator label="Detalles"/>
					<myform:field name="edad" label="Edad" value="${lote.edad}"/>
					<myform:field name="ubicacion" label="Ubicacion" value="${lote.ubicacion}"/>
					<myform:field name="cantidad" label="Cantidad" value="${lote.cantidad}"/>
					<myform:field name="pesoMaximo" label="Peso maximo" value="${lote.pesoMaximo}"/>
					<myform:field name="pesoMinimo" label="Peso minimo" value="${lote.pesoMinimo}"/>
					<myform:field name="pesoPromedio" label="Peso promedio" value="${lote.pesoPromedio}"/>					

					<tr class="order-total">
						<th></th>
						<td class="text-right">
							<div class="form-group text-right">
								
							</div>
						</td>
					</tr>
				</tbody>
			</table>			
			
			<div class="buttons">
				<g:link action="index" class="btn btn-default">buscar</g:link>
				<g:link action="create" class="btn btn-default">nuevo lote</g:link>
				<g:actionSubmit action="save" value="guardar" class="btn btn-default"/>
			</div>
			
		</form>
	</content>
	
    <content tag="left2">
	
		<h3 class="widget-title">Imagen</h3>	

		<g:uploadForm name="uploadFeaturedImage" action="save_image">
			<table class="table table-condensed" cellspacing="0">
				<tbody>					
					<img src="<g:createLink controller='lote' action='get_image' id='${lote.id}'/>"/>
					<g:hiddenField name="loteId" value="${lote.id}" />
					<input type="file" name="image" />					
				</tbody>
			</table>

			<div class="buttons">
				<input class="btn btn-default" type="submit" value="Upload" />
			</div>
			
		</g:uploadForm>

	</content>
	
	</div>
</g:applyLayout>