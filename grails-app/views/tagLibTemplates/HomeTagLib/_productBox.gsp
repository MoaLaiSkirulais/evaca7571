<div class="product col-md-3 col-sm-6 col-xs-12" data-product-id="1" >
	

	<div class="inner-product">
		<div class="product-thumbnail"
				style="background-image: url('/lote/get_image/${attrs.aviso?.lote?.id}'); background-color: #cccccc; width:259px; height:329px" >

			<div style="position:absolute; bottom:110; right:10;">
				<img src="<g:createLink controller='usuario' action='get_image' id='${attrs.aviso.propietario.id}'/>" style="border: 1px solid gray; width:40px; opacity: 0.7;"/>
			</div>
			
			

			<div style="width:259px; border:none; background-color:  rgba(224, 218, 218, 0.9); 
							position:absolute; bottom:0; left:0; 
							text-align: left; padding:10px;
							text-transform: uppercase;">
							
				<!-- <div style="position:absolute; bottom:10; right:10;"> -->
					<!-- <img src="<g:createLink controller='usuario' action='get_image' id='${attrs?.aviso?.consignatario?.id}'/>" style="border: 1px solid gray; width:20px; opacity: 0.9;"/> -->
				<!-- </div> -->
				
				<span class="amount">fecha: ${attrs.aviso.lote.fechaCreacion}<br></span>
				<span class="amount">aviso: #${attrs.aviso.lote.id}<br></span>
				<span class="amount">categoría: ${attrs.aviso.lote.categoria}</span><br>
				<span class="amount">consignatario: ${attrs.aviso.consignatario}</span>
			</div>
		</div>
		<div class="product-details text-center">
			<div class="product-btns">
				<span data-toggle="tooltip" data-placement="top" title="Add To Cart">
					<a href="#!" class="li-icon add-to-cart"><i class="lil-shopping_cart"></i></a>
				</span>
				<span data-toggle="tooltip" data-placement="top" title="Add to Favorites">
					<a href="#!" class="li-icon"><i class="lil-favorite"></i></a>
				</span>
				<span data-toggle="tooltip" data-placement="top" title="View">
					<a href="product.html" class="li-icon view-details"><i class="lil-search"></i></a>
				</span>
			</div>
		</div>
	</div>
	<h3 class="product-title">
		<a href="#!">
			<g:link controller="aviso" action="show" id="${attrs.aviso.id}">
				${attrs.aviso.lote.raza}
			</g:link>
		</a>
	</h3>

	<div class="star-rating">
		<span style="width:50%"></span>
	</div>

	<p class="product-price">
		<ins>
			<span class="amount">
				$${attrs.aviso.precio}
			</span>
		</ins>
	</p>
</div><!-- /.product -->