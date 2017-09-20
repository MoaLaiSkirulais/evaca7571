<g:form controller="aviso" action="postular_oferta">
	
	<myform:field name="aviso.id" label="" value="${attrs.aviso.id}" style="display:none"/>	

	<div class="product-attributes row">

		<div class="form-group col-md-3">
			<label for="attr_1">Precio</label>									
			<input style="width:150px; background-color: #eee;" value="" class="form-control" type="number" name="precio">
		</div>

		<div class="form-group col-md-6">
			<label for="attr_2">Plazo</label>
			<g:select 
				style="width:300px; background-color: #eee;"
				name="plazo.id" 
				from="${attrs.plazos}" 
				value="1" 
				optionKey="id"  
				noSelection="${['':'Select One...']}"
				class="form-control"
			/>
		</div>

		<div class="form-group col-md-3">
			<label for="attr_2" style="color:white">oferta</label>
			<button type="submit" class="btn btn-default">
				<i class="lil-add_shopping_cart"></i>Ofertar
			</button>
		</div>
		
	</div>

	

</g:form>
