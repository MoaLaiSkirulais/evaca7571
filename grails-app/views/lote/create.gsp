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
							<h2>raza</h2><br>
							<form method="post">
							
								<f:with bean="${model.lote}">
								
									id: <f:display property="id"/><br>
									usuario: <f:display property="usuario"/><br>
									fechaCreacion: <f:display property="fechaCreacion">
										<g:formatDate format="dd MMM yyyy hh:mm:ss" date="${value}"/>
									</f:display><br>		
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
									<g:link action="create" class="btn btn-default">create</g:link>
									<g:actionSubmit action="save" value="save" class="btn btn-default"/>	
								</div>
							</form>
								
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>