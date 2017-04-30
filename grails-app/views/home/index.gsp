<%-- @ page contentType="application/json" --%>

<% now = new Date() %>

<html>
	<head>
		<meta name="layout" content="public"/>
		<title>Home Page</title>
	</head>
	
	<body>
	
		<g:link controller="usuario">usuario List</g:link><br>	
		<g:link controller="usuario" action="show" id="1">usuario show 1</g:link><br>	
		<g:link action="show" id="1">Usuario 1</g:link><br>
	
		Stephen King's Books:
		<g:findAll in="${books}" expr="it.author == 'Stephen King'">
			<p>Title: ${it.title}</p>
		</g:findAll>

	
		<g:each in="${[1,2,3]}" var="num">
			<p>Number ${num}</p>
		</g:each>

		<g:set var="num" value="${1}" />
		<g:while test="${num < 5 }">
			<p>Number ${num++}</p>
		</g:while>

	
		<g:set var="myHTML">
			Some re-usable code on: ${new Date()}
		</g:set>

	
		<g:example attr="${new Date()}" attr2="[one:'one', two:'two']">
			Hello world
		</g:example>



		<h3><%-- This is my comment --%></h3>
		<h3><% out << "Hello GSP!" %></h3>
		<h3><%="Hello GSP!!" %></h3>
		<h3><%=now%></h3>
		<h3>Hello ${params.name}</h3>
		
		<% [1,2,3,4].each { num -> %>
			<p><%="Hello ${num}!" %></p>
		<%}%>
		
		<% if (params.hello == 'true') {%>
			<%="Hello!"%>
		<% }else {%>
			<%="Goodbye!"%>
		<% }%>
		 
		<div id="content" role="main">
			<section class="row colset-2-its">
				<h1>Welcome ${name}!</h1>
				<g:if test="${flash.message}"> 
					<div class="message" role="status">${flash.message}</div>
				</g:if>
			</section>
		</div>

	</body>
</html>