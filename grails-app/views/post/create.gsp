<style>
	body {
		font-size: 30px;
	}
</style>

 <g:renderErrors bean="${post}"/>

<form method="post">
	post.content: <input name="content" value="${post.content}"><br>	
	post.reply.content: <input name="replies[0].content" value="${post.replies[0].content}"><br>
	post.reply.content: <input name="replies[1].content" value="${post.replies[1].content}"><br>
	post.reply.content: <input name="replies[2].content" value="${post.replies[2].content}"><br>
	<g:actionSubmit action="save" value="Guardar" class="btn btn-default"/>	
</form>
