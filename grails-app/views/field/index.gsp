<% now = new Date() %>
<h3><%=now%></h3>

<g:form>    
	<f:all bean="raza"/>
</g:form>

<g:form>
    <f:field bean="raza" property="name"/>    
</g:form>
			
<g:form>
    <f:with bean="raza">
        <f:field property="name"/>
        
    </f:with>
</g:form>
		
			
<h3>
    <f:field bean="raza" property="fechaCreacion"/><br>
	<f:display bean="raza" property="fechaCreacion"/>
</h3>

<f:display bean="raza" property="fechaCreacion">
    <g:formatDate format="dd MMM yyyy" date="${value}"/>
</f:display>

!!




