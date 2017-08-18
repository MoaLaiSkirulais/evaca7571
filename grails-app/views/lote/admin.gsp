<g:applyLayout name="crudContainerTwoCols">

    <content tag="left1">
	
		<h2>Lote</h2>
		<evaca:cruderror modelo="${lote}"/>
		
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<myform:display name="id" label="#id" value="${lote.id}"/>
					<myform:display name="usuario" label="Usuario" value="${lote.usuario}"/>
					<myform:display name="fechaCreacion" label="Fecha creacion" value="${lote.fechaCreacion}"/>
					
					<myform:display label="Categoria" value="${lote?.categoria}"/>
					<myform:display label="Raza" value="${lote?.raza}" />				
					
					<myform:separator label="Detalles"/>
					<myform:display label="Edad" value="${lote.edad}"/>
					<myform:display label="Ubicacion" value="${lote.ubicacion}"/>
					<myform:display label="Cantidad" value="${lote.cantidad}"/>
					<myform:display label="Peso maximo" value="${lote.pesoMaximo}"/>
					<myform:display label="Peso minimo" value="${lote.pesoMinimo}"/>
					<myform:display label="Peso promedio" value="${lote.pesoPromedio}"/>
					<myform:display label="Imagen url" value="${lote.imagen}"/>

				</tbody>
			</table>			

		</form>
	</content>
	
    <content tag="left2">
		<img src="${lote.imagen}">
	</content>
	
	</div>
</g:applyLayout>