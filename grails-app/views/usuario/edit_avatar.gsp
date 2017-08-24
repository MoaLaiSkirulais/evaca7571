<g:applyLayout name="layoutUserLogged">

    <content tag="left1">

		<h3 class="widget-title">cambiar avatar</h3>

		<g:uploadForm name="uploadFeaturedImage" action="save_avatar">
			<table class="table table-condensed" cellspacing="0">
				<tbody>					
					<img src="<g:createLink controller='usuario' action='get_avatar_image' id='${usuario.id}'/>"/>
					<g:hiddenField name="usuarioId" value="${usuario.id}" />
					<input type="file" name="avatarImageFile" />					
				</tbody>
			</table>

			<div class="buttons">
				<input class="btn btn-default" type="submit" value="Upload" />
			</div>
			
		</g:uploadForm>
	
	</content>
	
    <content tag="left2">	
	</content>

</g:applyLayout>