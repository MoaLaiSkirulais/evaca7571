<g:form controller="aviso">

	<myform:field name="aviso.id" label="" value="${attrs.aviso.id}" style="display:none"/>	
	<myform:field name="precio" label="Precio" style="width:100px"/>
	<myform:select label="Plazo" name="plazo.id" from="${attrs.plazos}" value="1" optionKey="id" style="width:200px"/>
	<g:actionSubmit action="ofertar" value="Ofertar" class="btn btn-default"/>	

</g:form>