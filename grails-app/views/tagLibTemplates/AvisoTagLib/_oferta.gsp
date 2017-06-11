<g:form controller="aviso">
	
	<myform:field label="" name="nombre"/>
	<myform:field label="" name="aviso.id" value="${attrs.aviso.id}" />	
	<myform:field name="precio" label="Precio"/>
	<myform:select label="Plazo" name="plazo.id" from="${attrs.plazos}" value="1" optionKey="id"/>
	<g:actionSubmit action="ofertar" value="Ofertar" class="btn btn-default"/>	
	
</g:form>