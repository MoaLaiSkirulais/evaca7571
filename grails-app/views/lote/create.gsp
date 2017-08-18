<g:applyLayout name="crudContainerTwoCols">

    <content tag="left1">
	
		<h2>Lote</h2>
		<evaca:cruderror modelo="${lote}"/>
		
		<form method="post">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:display name="id" label="#id" value="${lote.id}"/>
					<myform:display name="usuario" label="Usuario" value="${lote.usuario}"/>
					<myform:display name="fechaCreacion" label="Fecha creacion" value="${lote.fechaCreacion}"/>
					
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
					<myform:field name="imagen" label="Imagen url" value="${lote.imagen}"/>

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
		<img src="${lote.imagen}">
		
		<g:uploadForm name="uploadFeaturedImage" action="uploadFeaturedImage">
			<g:hiddenField name="id" value="${this.restaurant?.id}" />
			<g:hiddenField name="version" value="${this.restaurant?.version}" />
			<input type="file" name="featuredImageFile" />
			<fieldset class="buttons">
				<input class="save" type="submit" value="${message(code: 'restaurant.featuredImage.upload.label', default: 'Upload')}" />
			</fieldset>
		</g:uploadForm>

	</content>
	
	</div>
</g:applyLayout>