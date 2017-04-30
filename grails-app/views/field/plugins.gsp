<% now = new Date() %>
<h3><%=now%></h3>
<h3><%=plugins%></h3>

<g:each in="${plugins}" var="p">
	<h4>${p}</h4>
</g:each>

