<html>
	
    <head>
        <title>An Example Page</title>        
        <meta name="layout" content="evaca" />
    </head>
	
    <body>
	
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

				
		<div style="float:left; border: 1px solid red; width:400px">
		
			<f:all bean="lote"/> 

			<g:form controller="lote" action="register">
				<p><g:submitButton name="update" value="Update"/></td></p>			
			</g:form>
		</div>

	</body>

</html>