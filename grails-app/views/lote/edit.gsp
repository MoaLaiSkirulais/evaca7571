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
					
						<g:if test="${flash.message}">
							<div class="alert alert-success active">
								${flash.message}	
							</div>
						</g:if>
						
						
						
						<g:hasErrors>
							<div class="errors">
								<g:renderErrors bean="${lote}" as="list" />
							</div>
						</g:hasErrors>

						<div class="col-sm-6">				
							<div class="box">
								<h2>Lote</h2><br>
								<table>
								<g:form controller="lote" action="update" class="inputs-border">

									<f:with bean="lote">

										<b>usuario:</b>&nbsp;<f:display property="usuario"/><br>
										<b>fechaCreacion:</b><f:display property="fechaCreacion">
											<g:formatDate format="dd MMM yyyy hh:mm" date="${value}"/>
										</f:display><br><br>
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
										<g:submitButton name="update" value="Update" class="btn btn-default"/></td></p>
									</div>
								
								</g:form>
								</table>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>

	</body>

</html>