<g:applyLayout name="layoutTwoColumnsUserLogged">
	
    <content tag="left1">

		<evaca:cruderror modelo="${lote}"/>

		<div class="container">
			<div class="row">

				<div class="col-sm-5">
					
					<!-- lote -->
					<h3 class="widget-title">Lote</h3>	
		
					<form method="post">
						<table class="table table-condensed" cellspacing="0">
							<tbody>
								<myform:display name="id" label="#id" value="${lote.id}"/>
								<myform:display name="state" label="State" value="${lote.state}"/>
								<myform:display name="propietario" label="Propietario" value="${lote.propietario}"/>
								<g:hiddenField name="propietario.id" value="${lote.propietario.id}"/>
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
							</tbody>
						</table>			

						<div class="buttons">		
							<g:link action="create" class="btn btn-default">nuevo lote</g:link>
							<g:actionSubmit action="actualizar" value="actualizar" class="btn btn-default"/>
						</div>
	
					</form>
					
					<!-- Aviso -->
					<h3 class="widget-title">Aviso</h3>	

					<g:form method="post" controller="lote">

						<table class="table table-condensed" cellspacing="0">
							<tbody>
								
								<myform:display name="aviso.id" label="#id" value="${lote.aviso.id}"/>
								<myform:display name="state" label="State" value="${lote.aviso.state}"/>
								<myform:field name="aviso.id" value="${lote.aviso.id}" style="display:none"/>
								<myform:field name="aviso.precio" label="Precio" value="${lote.aviso.precio}"/>

								<myform:select 
									label="Plazo" 	
									name="aviso.plazo.id" 
									from="${plazos}" value="${lote.aviso?.plazo?.id}" 
									optionKey="id"
								/>

								<myform:select 
									label="Consignatario" 	
									name="aviso.consignatario.id" 
									from="${consignatarios}" value="${lote.aviso?.consignatario?.id}" 
									optionKey="id"
								/>

							</tbody>
						</table>

						<div class="buttons">
							<g:actionSubmit action="postular_aviso" class="btn btn-default" value="Postular()"/>
							<g:actionSubmit action="cancelar_aviso" class="btn btn-default" value="Cancelar()"/>
						</div>
							
					</g:form>

					<!-- <g:form method="post" controller="aviso"> -->
						<!-- <myform:field name="aviso.id" value="${lote.aviso.id}" style="display:non"/> -->
						<!-- <g:actionSubmit action="aprobar" class="btn btn-default" value="Aprobar()"/> -->
						<!-- <g:actionSubmit action="desaprobar" class="btn btn-default" value="Desaprobar()"/> -->
					<!-- </g:form> -->
				</div>
				
				<!-- Imagen -->
				<div class="col-sm-4">
					<h3 class="widget-title">Imagen</h3>

					<g:uploadForm name="uploadFeaturedImage" action="save_image">
						<table class="table table-condensed" cellspacing="0">
							<tbody>					
								<img src="<g:createLink controller='lote' action='get_image' id='${lote.id}'/>"/>
								<g:hiddenField name="lote.id" value="${lote.id}" />
								<input type="file" name="image" />					
							</tbody>
						</table>
						<div class="buttons">
							<input class="btn btn-default" type="submit" value="Upload" />
						</div>			
					</g:uploadForm>
				</div>
			</div>
		</div>

	</content>
	
</g:applyLayout>