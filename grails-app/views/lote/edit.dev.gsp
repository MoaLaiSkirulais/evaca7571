<html>
	
    <head>
        <title>An Example Page</title>        
        <meta name="layout" content="sham" />
    </head>
	
    <body>
		<div class="page-wrapper">
			<section class="section" id="page-login">
				<div class="container">
					<div class="row">
						<g:if test="${flash.message}">
							<div class="flash">
								${flash.message}
							</div>
						</g:if>
						
						<g:hasErrors>
							<div class="errors">
								<g:renderErrors bean="${usuario}" as="list" />
							</div>
						</g:hasErrors>
						
						<f:all bean="lote"/>

						<div class="col-sm-6">				
							<div class="box">
								<h2>Lote</h2><br>

								<g:form controller="lote" action="create" class="inputs-border">

									<div class="form-group">
										<div class="required">
											<input class="form-control" type="text" placeholder="fechaCreacion" name="fechaCreacion" value="${lote?.fechaCreacion}"/></p>
										</div>								
									</div>

									<div class="form-group">
										<div class="required">
											<input class="form-control" type="text" placeholder="cantidad" name="cantidad" value="${lote?.cantidad}"/></p>
										</div>								
									</div>
									<f:with bean="lote">
										<f:field property="categoria" />
										<f:field property="provincia" />
										<f:field property="raza" />
										<f:field property="edad" />
										<f:field property="pesoMaximo" />
										<f:field property="pesoMinimo" />
										<f:field property="pesoPromedio" />
										<f:field property="cantidad" />
										<f:input property="cantidad"/>
										<f:display property="cantidad"/>
										
										<f:display bean="lote" property="fechaCreacion">
											<g:formatDate format="dd MMM yyyy" date="${value}"/>
										</f:display>
									</f:with>
									
									<div class="form-group">
										<div class="required">
											<input class="form-control" type="text" placeholder="ubicacion" name="ubicacion" value="${lote?.ubicacion}"/></p>
										</div>								
									</div>
									
									<f:field  bean="lote" property="ubicacion" />
									<f:field  bean="lote" property="edad" />
									
									<div class="form-group text-right">
										<g:submitButton name="update" value="Update" class="btn btn-default"/></td></p>
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