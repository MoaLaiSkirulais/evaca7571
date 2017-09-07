<div class="product col-md-3 col-sm-6 col-xs-12" data-product-id="1" >
	

	<div class="inner-product">
		<div class="product-thumbnail" 
				style="background-image: url('/lote/get_image/${attrs.aviso?.lote?.id}'); background-color: #cccccc; width:259px; height:329px" >

			<!-- <img src="${resource(dir: 'sham/img/products', file: 'v4.gif')}" alt="Sham Theme"> -->
			<!-- <img src="<g:createLink controller='lote' action='get_image' id='${attrs.aviso?.lote?.id}'/>"/> -->
			<div style="width:259px; border:none; background-color:  rgba(224, 218, 218, 0.9); 
							position:absolute; bottom:0; left:0; 
							text-align: left; padding:10px;
							text-transform: uppercase;">
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