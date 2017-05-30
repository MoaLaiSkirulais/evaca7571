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
										<myform:select 
											label="Categoria" 	
											name="categoria.id" 
											from="${model.lote.categoria.list()}" value="${model.lote.categoria.id}" optionKey="id"
										/>
										<myform:display label="#id" value="${model.lote.id}"/>
										<myform:display label="Usuario" value="${model.lote.usuario}"/>
										<myform:display label="Fecha creacion" value="${model.lote.fechaCreacion}"/>
										<myform:field label="Raza" value="${model.lote.raza}"/>
										<myform:field label="Edad" value="${model.lote.edad}"/>
										<myform:field label="Ubicacion" value="${model.lote.ubicacion}"/>
										<myform:field label="Peso maximo" value="${model.lote.pesoMaximo}"/>
										<myform:field label="Peso minimo" value="${model.lote.pesoMinimo}"/>
										<myform:field label="Peso promedio" value="${model.lote.pesoPromedio}"/>

										<!-- <f:field bean="${model.lote}" property="trazada" /> -->
										<!-- <f:field bean="${model.lote}" property="marcaLiquida" /> -->
										
										<tr class="order-total">
											<th>
												
										<!-- <g:radio name="myGroup" value="1"/>! -->
										<!-- <g:radio name="myGroup" value="2" checked="true"/>! -->
												</th>
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