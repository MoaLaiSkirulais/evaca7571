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
								<g:form controller="categoria" action="update" class="inputs-border">

									<f:with bean="categoria">

										<f:display property="id"/><br>
										<f:display property="usuario"/><br>
										<f:display property="fechaCreacion">
											<g:formatDate format="dd MMM yyyy" date="${value}"/>
										</f:display><br><br>
										
										<f:field property="nombre" />

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