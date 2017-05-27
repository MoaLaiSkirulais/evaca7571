<html>
	
    <head>
        <meta name="layout" content="sham" />
    </head>
	
    <body>

		<evaca:breadcrums/>
		
		<div class="page-wrapper">
			
				<div class="container">
					<div class="row">
						<g:if test="${flash.message}">
							<div class="flash">
								${flash.message}
							</div>
						</g:if>
						
						<g:hasErrors>
							<div class="errors">
								<g:renderErrors bean="${categoria}" as="list" />
							</div>
						</g:hasErrors>

						<div class="col-sm-6">				
							<div class="box">
								<h2>categoria</h2><br>
								<table>
								<g:form controller="categoria" action="save" class="inputs-border">

									<f:with bean="categoria">

										
										<f:field property="id" />
										<f:display property="usuario"/>
										<f:display property="fechaCreacion">
											<g:formatDate format="dd MMM yyyy hh:mm:ss" date="${value}"/>
										</f:display>										
										<f:field property="nombre" />

									</f:with>
									
									<div class="form-group text-right">
										<g:link class="btn btn-default" action="create">Nuevo</g:link>
										<g:submitButton name="save" value="Guardar" class="btn btn-default"/>
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