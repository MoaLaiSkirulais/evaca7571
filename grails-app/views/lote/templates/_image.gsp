<h3 class="widget-title">Imagen</h3>

<g:uploadForm name="uploadFeaturedImage" action="save_image">

	<table class="table table-condensed" cellspacing="0">
		<tbody>					
			<img src="<g:createLink controller='lote' action='get_image' id='${lote.id}'/>"/>
			<g:hiddenField name="loteId" value="${lote.id}" />
			<input type="file" name="image" />					
		</tbody>
	</table>

	<div class="buttons">
		<input class="btn btn-default" type="submit" value="Upload" />
	</div>
	
</g:uploadForm>