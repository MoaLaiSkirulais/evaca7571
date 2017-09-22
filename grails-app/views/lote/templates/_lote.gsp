<h3 class="widget-title">Lote</h3>	
		
<form method="post">
	<table class="table table-condensed" cellspacing="0">
		<tbody>
			<myform:display name="id" label="#id" value="${lote.id}"/>
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
		<g:actionSubmit action="save" value="guardar" class="btn btn-default"/>
	</div>
	
</form>