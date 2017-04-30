<% now = new Date() %>

<html>
	<head>
		<meta name="layout" content="public"/>
		<title>Home Page</title>
	</head>
	
	<body>
	
		${now}<br>
		<g:form name="myForm" url="[controller:'usuario',action:'list']">...</g:form><br>
		<g:textField name="myField" value="${myValue}" /><br>
		<g:render template="bookTemplate" model="[book: myBook]" /><br>
		<g:render template="/home/bookTemplate" model="[book: myBook]" />



	</body>
</html>