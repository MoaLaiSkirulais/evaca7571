${model.lote.errors}

<g:if test="${flash.message}">
	<div class="alert alert-success active">
		${flash.message}
	</div>
</g:if>

<g:hasErrors>
	<div class="errors">
		<g:renderErrors bean="${model.lote}" as="list" />
	</div>
</g:hasErrors>