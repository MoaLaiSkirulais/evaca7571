<html>
	
    <head>
        <meta name="layout" content="sham" />
    </head>

    <body>
		<evaca:breadcrums/>

		<div class="page-wrapper">			
			<div class="container">
				<div class="row">
					<evaca:cruderror/>

					<div class="col-sm-6">
						<div class="box">
							<h2>raza</h2>

							<form method="post">
								<table class="table table-condensed" cellspacing="0">
									<tbody>
										<myform:display name="id" label="#id" value="${model.lote.id}"/>
										<myform:select 
											label="Categoria" 	
											name="categoria.id" 
											from="${model.categorias}" value="${model.lote?.categoria?.id}" 
											optionKey="id"
										/>
										<myform:select 
											label="Raza" 	
											name="raza.id" 
											from="${model.razas}" value="${model.lote?.raza?.id}" 
											optionKey="id"
										/>										
										<myform:display name="usuario" label="Usuario" value="${model.lote.usuario}"/>
										<myform:display name="fechaCreacion" label="Fecha creacion" value="${model.lote.fechaCreacion}"/>
										<myform:field name="edad" label="Edad" value="${model.lote.edad}"/>
										<myform:field name="ubicacion" label="Ubicacion" value="${model.lote.ubicacion}"/>
										<myform:field name="cantidad" label="Cantidad" value="${model.lote.cantidad}"/>
										<myform:field name="pesoMaximo" label="Peso maximo" value="${model.lote.pesoMaximo}"/>
										<myform:field name="pesoMinimo" label="Peso minimo" value="${model.lote.pesoMinimo}"/>
										<myform:field name="pesoPromedio" label="Peso promedio" value="${model.lote.pesoPromedio}"/>

										<tr class="order-total">
											<th></th>
											<td class="text-right">
												<div class="form-group text-right">
													<g:link action="create" class="btn btn-default">create</g:link>
													<g:actionSubmit action="save" value="save" class="btn btn-default"/>	
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</form>
								
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>