<g:renderErrors bean="${this}" as="list" />
<g:uploadForm name="uploadFeaturedImage" action="uploadFeaturedImage">
    <g:hiddenField name="id" value="${this.restaurant?.id}" />
    <g:hiddenField name="version" value="${this.restaurant?.version}" />
    <input type="file" name="featuredImageFile" />
    <fieldset class="buttons">
        <input class="save" type="submit" value="${message(code: 'restaurant.featuredImage.upload.label', default: 'Upload')}" />
    </fieldset>
</g:uploadForm>




	<img src="<g:createLink controller='lote' action='featuredImage' id='1'/>" width="400"/>
