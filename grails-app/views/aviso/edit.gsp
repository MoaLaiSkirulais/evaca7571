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

						<!-- <evaca:cruderror/> -->
						<div class="col-sm-6">				
							<div class="box">
								<h2>Aviso</h2><br>
								<table>
								<g:form controller="aviso" action="update" class="inputs-border">

									<f:with bean="aviso">

										<b>fechaCreacion:</b><f:display property="fechaCreacion">
											<g:formatDate format="dd MMM yyyy hh:mm" date="${value}"/>
										</f:display><br><br>
										
										<b>fechaPublicacion:</b><f:display property="fechaPublicacion">
											<g:formatDate format="dd MMM yyyy hh:mm" date="${value}"/>
										</f:display><br><br>
										<f:field property="id" />
										<f:field property="precio" />
										<f:field property="tbState" />
										<f:field property="consignatario" />
										<f:field property="lote" />

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