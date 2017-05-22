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

						<div class="col-sm-6">				
							<div class="box">
								<h2>login</h2><br>
							
								<f:all bean="lote"/> 

								<g:form controller="lote" action="register">
									<p><g:submitButton name="update" value="Update"/></td></p>			
								</g:form>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>

	</body>

</html>