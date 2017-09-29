<g:applyLayout name="layoutTwoColumnsUserLogged">

    <content tag="left1">

		<h3 class="widget-title">cambiar avatar</h3>

		<g:uploadForm name="uploadFeaturedImage" action="save_image">
			<table class="table table-condensed" cellspacing="0">
				<tbody>					
					<img src="<g:createLink controller='usuario' action='get_image' id='${usuario.id}'/>"/>
					<g:hiddenField name="usuario.id" value="${usuario.id}" />
					<input type="file" name="image" />					
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