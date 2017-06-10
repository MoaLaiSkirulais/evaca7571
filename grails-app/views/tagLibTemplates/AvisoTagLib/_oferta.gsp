<g:form controller="oferta">
	<myform:field label="" name="nombre"/>
	<myform:field label="" name="aviso.id" value="${attrs.aviso.id}" />	
	<g:actionSubmit controller="oferta" action="save" value="Ofertar" class="btn btn-default"/>	
</g:form>