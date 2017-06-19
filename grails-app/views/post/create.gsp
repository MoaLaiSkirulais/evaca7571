<style>
	body {
		font-size: 30px;
	}
</style>


<form method="post">
	post.content: <input name="post.content" value="hola"><br>
	
	post.reply.content: <input name="post.replies[0].content" value="que tal"><br>
	post.reply.content: <input name="post.replies[1].content" value="bien vos"><br>
	post.reply.content: <input name="post.replies[2].content" value=""><br>
	
	<g:actionSubmit action="save" value="Guardar" class="btn btn-default"/>	
</form>
