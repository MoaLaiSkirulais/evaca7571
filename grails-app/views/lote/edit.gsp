<html>
	
    <head>
        <title>An Example Page</title>        
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
								<h2>Lote</h2><br>

								<g:form controller="lote" action="update" class="inputs-border">

									<f:with bean="lote">

										<f:display property="usuario"/>
										<f:display property="fechaCreacion">
											<g:formatDate format="dd MMM yyyy hh:mm" date="${value}"/>
										</f:display>
										<f:field property="categoria" />
										<f:field property="raza" />
										<f:field property="edad" />
										<f:field property="ubicacion" />
										<f:field property="pesoMaximo" />
										<f:field property="pesoMinimo" />
										<f:field property="pesoPromedio" />
										<f:field property="cantidad" />
										<f:field property="trazada" />
										<f:field property="marcaLiquida" />

									</f:with>

									<div class="form-group text-right">
										<g:submitButton name="update" value="Update" class="btn btn-default"/>
									</div>

								</g:form>
								
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>

	</body>

</html>