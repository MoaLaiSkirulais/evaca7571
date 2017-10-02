<g:applyLayout name="layoutThreeColumnsUserLogged">
	
    <content tag="left1">

		<evaca:cruderror modelo="${lote}"/>

		<table class="table table-condensed" cellspacing="0">
			<tbody>

				<myform:separator label="Lote"/>
				<myform:show label="#id" value="${lote.id}"/>
				<myform:show label="State" value="${aviso.entityState([state: lote.state])}"/>
				<myform:show label="Propietario" value="${lote.propietario}"/>
				<myform:show label="Creacion" value="${lote.fechaCreacion}"/>
				<myform:show label="Categoria" value="${lote.categoria}"/>
				<myform:show label="Raza" value="${lote.raza}"/>
				
				<myform:separator label="Detalles"/>
				<myform:show label="Edad" value="${lote.edad}"/>
				<myform:show label="Ubicacion" value="${lote.ubicacion}"/>
				<myform:show label="Cantidad" value="${lote.cantidad}"/>
				<myform:show label="Peso maximo" value="${lote.pesoMaximo}"/>
				<myform:show label="Peso minimo" value="${lote.pesoMinimo}"/>
				<myform:show label="Peso promedio" value="${lote.pesoPromedio}"/>					
				<myform:separator label="Aviso"/>
				<myform:show label="#id" value="${lote.aviso.id}"/>
				<myform:show label="State" value="${aviso.entityState([state: lote.aviso.state])}"/>

				<myform:show label="Precio" value="${lote.aviso.precio}"/>
				<myform:show label="Plazo" value="${lote.aviso?.plazo}"/>
				<myform:show label="Consignatario" value="${lote.aviso?.consignatario}"/>

			</tbody>
		</table>
				
	</content>
	
    <content tag="left2">
		<img src="<g:createLink controller='lote' action='get_image' id='${lote.id}'/>"/>
		<ul>		
			<li><br><br><h3>Actividad</h3></li>

			<li>
				<g:link action="search_ofertas">
					ver Ofertas (${lote.aviso.ofertas.size()})
				</g:link>
			</li>

			<li>
				<g:link action="search_ofertas">
					ver Resenas (${lote.aviso.resenas.size()})
				</g:link>
			</li>
		</ul>
	</content>
	
</g:applyLayout>