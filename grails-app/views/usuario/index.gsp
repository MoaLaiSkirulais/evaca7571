<html>
	
    <head>
        <title>An Example Page!</title>        
        <meta name="layout" content="sham" />
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
			<g:form action="login" >
				<h1>login</h1>
				<p>username<input name="username"/></p>
				<p>password<input name="password"/></p>
				<p><g:submitButton name="login" value="login"/></td></p>
			</g:form>
		</div>	
				
		<div style="float:left; border: 1px solid red; width:400px">
			<g:form controller="usuario" action="register">

				<h1>nuevo usuario</h1>
				<p>nombre<g:textField name="nombre" value="${params.nombre}" /></p>
				<p>apellido<g:textField name="apellido" value="${params.apellido}" /></p>
				<p>email<input name="email" value="${usuario?.email}"/></p>
				<p>username<input value="${usuario?.username}" name="username"/></p> 
				<p>tbTipo<input value="${usuario?.tbTipo}" name="tbTipo"/></p>
				<p>tbState<input value="${usuario?.tbState}" name="tbState"/></p>
				<p>comision<input value="${usuario?.comision}" name="comision"/></p>
				<p>password<input value="${usuario?.password}" name="password"/></p>
				<p>repassword<input name="repassword"/></p>
				<p><g:submitButton name="update" value="Update"/></td></p>
			
			</g:form>
		</div>

	</body>

</html>