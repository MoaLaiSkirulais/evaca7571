<g:if test="${flash.message}">
	<g:if test="${flash.type == 'ok'}">
		<div class="alert alert-success active" style="background-color:green; border:none">
			${flash.message}
		</div>
	</g:if>
	<g:else>
		<div class="alert alert-success active">
			${flash.message}
		</div>
	</g:else>
</g:if>

<div class="errors">
	<g:renderErrors bean="${attrs.modelo}" as="list" />
</div>
