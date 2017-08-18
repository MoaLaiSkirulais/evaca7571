<g:applyLayout name="usuario">

    <content tag="left1">
		<h2>cambiar avatar</h2>
		<evaca:cruderror modelo="${usuario}"/>

		<g:uploadForm name="uploadFeaturedImage" action="setAvatar">
			<table class="table table-condensed" cellspacing="0">
				<tbody>
					<img src="<g:createLink controller='usuario' action='getAvatarImage' id='1'/>" width="400"/>
					<g:hiddenField name="id" value="${usuario.id}" />
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