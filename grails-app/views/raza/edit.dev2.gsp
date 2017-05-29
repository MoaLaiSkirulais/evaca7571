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
								<table>
								<g:form controller="raza" action="update" class="inputs-border">

									<f:with bean="raza">

										<b>id:</b>&nbsp;<f:display property="id"/><br>
										<b>usuario:</b>&nbsp;<f:display property="usuario"/><br>
										<b>fechaCreacion:</b>&nbsp;<f:display property="fechaCreacion">
											<g:formatDate format="dd MMM yyyy" date="${value}"/>
										</f:display><br><br>
										
										<f:field property="nombre"/>

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