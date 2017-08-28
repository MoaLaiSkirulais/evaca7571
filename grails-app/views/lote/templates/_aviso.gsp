<h3 class="widget-title">Aviso</h3>	

<g:form method="post" controller="lote">

	<table class="table table-condensed" cellspacing="0">
		<tbody>
			
			<myform:display name="id" label="#id" value="${lote.aviso.id}"/>
			<myform:field name="id" value="${lote.aviso.id}" style="display:none"/>
			<myform:display name="state" label="State" value="${lote.aviso.state}"/>
			<myform:field name="precio" label="Precio" value="${lote.aviso.precio}"/>

			<myform:select 
				label="Consignatario" 	
				name="consignatario.id" 
				from="${consignatarios}" value="${lote.aviso?.consignatario?.id}" 
				optionKey="id"
			/>

			<myform:field name="lote.id" value="${lote.id}" style="display:none"/>

		</tbody>
	</table>

	<div class="buttons">
		<g:actionSubmit action="postular" class="btn btn-default" value="Postular()"/>
		<g:actionSubmit action="cancelar" class="btn btn-default" value="Cancelar()"/>				
	</div>
		
</g:form>