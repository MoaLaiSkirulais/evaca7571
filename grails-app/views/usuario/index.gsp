<html>
	
    <head>
        <title>An Example Page</title>        
        <meta name="layout" content="evaca" />
    </head>
	
    <body>

		usuario

		<g:textField name="userId" value="${newuser?.userId}"/>

		<g:each in="${['Cat', 'Dog' ,'Elephant']}">
			Animal: ${it} <br/>
		</g:each>
		
		<g:form action="login" >
			<div style="float:left; border: 1px solid red; width:400px">
			<h1>login</h1>
			<p>username<input name="username"/></p>
			<p>password<input name="password"/></p>
			<p><g:submitButton name="login" value="Login"/></td></p>
		</div>	
		</g:form>
		
		<g:if test="${flash.message}">
		<div class="flash">
		${flash.message}
		</div>
		</g:if>


		 <g:hasErrors>!!
			 <div class="errors">
				<g:renderErrors bean="${usuario}" as="list" />
			 </div>
		 </g:hasErrors>
		 
				
		<g:form controller="usuario" action="register" >
		        
		<p>myBook.title: ${myBook.title}</p>
		<p>myBook: ${myBook}</p>
		<p>usuario: ${usuario}</p>
		<p>${params}</p>

		<div style="float:left; border: 1px solid red; width:400px">
			<h1>nuevo usuario</h1>
			<p>nombre<input name="nombre" value="${params.nombre}"/></p>
			<p>apellido<g:textField name="apellido" value="${params.apellido}" /></p>

			<!-- <p>apellido<input name="apellido"/></p> -->
			<p>email<input name="email" value="${usuario?.email}"/></p>
			<p>username<input value="${usuario?.username}" name="username"/></p> 
			<p>tbTipo<input value="${usuario?.tbTipo}" name="tbTipo"/></p>
			<p>tbState<input value="${usuario?.tbState}" name="tbState"/></p>
			<p>comision<input value="${usuario?.comision}" name="comision"/></p>
			<p>password<input value="${usuario?.password}" name="password"/></p>
			<p>repassword<input name="repassword"/></p>
			<p>repassword<input name="repassword"/></p>
			<p><g:submitButton name="update" value="Update"/></td></p>
			
		</div>
		</g:form>
		
	</body>

</html>