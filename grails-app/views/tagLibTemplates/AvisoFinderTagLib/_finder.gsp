<div class="widget widget-search">
	<h3 class="widget-title">Qué buscás?
		<span class="typed-cursor">?</span>
	</h3>
	<form action="#!" method="GET" class="inputs-border inputs-bg">
		<input class="form-control" placeholder="Search Products.." type="text">
	</form>
</div><!-- /.widget-search -->

<!-- <div class="widget widget-price-filter"> -->
	
	<!-- <h3 class="widget-title">Filter By Price</h3> -->
	
	<!-- <div class="price-slider-wrapper"> -->
		<!-- <div id="filter-slider" class="filter-slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all" data-min="10" data-max="1000" data-values="150,700"> -->
			<!-- <div class="ui-slider-range ui-widget-header ui-corner-all" style="left: 14.1414%; width: 55.5556%;"></div> -->
			<!-- <span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0" style="left: 14.1414%;"></span> -->
			<!-- <span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0" style="left: 69.697%;"></span> -->
		<!-- </div> -->
	<!-- </div> -->
	
	<!-- <form action=""> -->
		<!-- <div id="amount-slider"> -->
			<!-- <strong>Price: </strong><span>$150 — $700</span> -->
		<!-- </div> -->
		<!-- <input id="price" value="150,700" type="hidden"> -->
		<!-- <button type="button" class="btn btn-default">Filter</button> -->
	<!-- </form> -->
<!-- </div><!-- /.widget-price-filter -->

<div class="widget widget-sizes">
	<h3 class="widget-title">por Categoria</h3>
	<ul>
		<g:each in="${categorias}" var="categoria">
			<li>
				<a href="#!" style="margin: 5px 0 0 0;">
					${categoria.nombre}
				</a>
			</li>
		</g:each>		
	</ul>
</div><!-- /.widget-sizes -->

<div class="widget widget-categories">
	<h3 class="widget-title">por Raza</h3>
	<ul>
		<g:each in="${razas}" var="raza">
			<li>
				<a href="#!">
					${raza.nombre} <span class="count">(6)</span>
				</a>
			</li>
		</g:each>
	</ul>
</div><!-- /.widget-categories -->

<div class="widget widget-top-seller">
	<h3 class="widget-title">Top Seller</h3>
	<ul>
	
		<g:each in="${topVendedores}" var="topVendedor">
			<li class="clearfix">
				<div class="media">
					<div class="media-left pull-left">
						<a href="#">
							<img class="media-object img-responsive" src="<g:createLink controller='usuario' action='get_image' id='${topVendedor.id}'/>" style="border: 0px solid gray;  opacity: 1.0; width:90px" />
						</a>
					</div>
					<div class="media-body">
						<h4 class="media-heading"><a href="product.html">${topVendedor.username}</a></h4>
						<div class="rating">
							<div class="star-rating">
								<span style="width:90%"></span>
							</div>
						</div>
						<!-- <p class="price"> -->
							<!-- <del> -->
								<!-- <span class="amount">$200.00</span> -->
							<!-- </del> -->
							<!-- <ins> -->
								<!-- <span class="amount">$450.00</span> -->
							<!-- </ins> -->
						<!-- </p> -->
					</div>
				</div>
			</li>	
		</g:each>
	</ul>
</div><!-- /.widget-top-seller -->

<div class="widget widget-instagram">
	<h3 class="widget-title">Bienvenidos</h3>
	<ul class="row">	
		<g:each in="${nuevoUsuarios}" var="nuevoUsuario">
			<li class="col-xs-4">
				<a href="#!">
					<img src="<g:createLink controller='usuario' action='get_image' id='${nuevoUsuario.id}'/>" style="border: 0px solid gray;  opacity: 1.0; width:90px" />
				</a>
			</li>
		</g:each>	
	</ul>
</div><!-- /.widget-instagram -->