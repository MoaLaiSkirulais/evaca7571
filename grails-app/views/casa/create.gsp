<h1>casa lab</h1>
${casa}<br>
${request}<br><br>

<h2>casa</h2>
<h4>${model.casa.errors}</h4>

<form method="post">

	id: 	${model.casa.id}									<br>
	color: 	<input value="${model.casa.color}" 	name="color"/>	<br>
	tipo: 	<input value="${model.casa.tipo}" 	name="tipo"/>	<br>
	barrio: <input value="${model.casa.barrio}" name="barrio"/>	<br>
	<g:link action="create">create</g:link>
	<g:actionSubmit action="save" value="save" />	

</form>

<h2>casas</h2>
<f:table collection="${model.casas}"/>
