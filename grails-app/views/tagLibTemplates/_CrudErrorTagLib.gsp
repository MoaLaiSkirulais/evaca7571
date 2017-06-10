<g:if test="${flash.message}">
	<div class="alert alert-success active">
		${flash.message}
	</div>
</g:if>


<div class="errors">
	<g:renderErrors bean="${attrs.modelo}" as="list" />
</div>

<!-- <g:hasErrors> -->
	<!-- <div class="errors"> -->
		<!-- <g:renderErrors bean="${model.usuario}" as="list" /> -->
	<!-- </div> -->
<!-- </g:hasErrors> -->