<g:form controller="aviso">

	<!-- <myform:field name="id" label="" value="1"/>	 -->
	<myform:field name="aviso.id" label="" value="${attrs.aviso.id}" style="display:non"/>	
	<myform:field name="precio" label="Precio" style="width:100px" value="2"/>
	<myform:select label="Plazo" name="plazo.id" from="${attrs.plazos}" value="1" optionKey="id" style="width:200px"/>
	<g:actionSubmit action="postular_oferta" value="Ofertar" class="btn btn-default"/>	

</g:form>