<g:applyLayout name="layoutTwoColumns">
	
	
	 <content tag="sidebar">
	
	
		<div class="widget widget-search">
			<h3 class="widget-title">What's on your mind<span class="typed-cursor">?</span></h3>
			<form action="#!" method="GET" class="inputs-border inputs-bg">
				<input type="text" class="form-control" placeholder="Search Products..">
			</form>
		</div><!-- /.widget-search -->
	
		<div class="widget widget-price-filter">
			<h3 class="widget-title">Filter By Price</h3>
			<div class="price-slider-wrapper">
				<div id="filter-slider" class="filter-slider" data-min="10" data-max="1000" data-values="150,700"></div>
			</div>
			<form action="">
				<div id="amount-slider">
					<strong>Price: </strong><span>$150 — $700</span>
				</div>
				<input type="hidden" id="price" value="150,700">
				<button type="button" class="btn btn-default">Filter</button>
			</form>
		</div><!-- /.widget-price-filter -->

		<div class="widget widget-sizes">
			<h3 class="widget-title">Sizes</h3>
			<ul>
				<li><a href="#!">XS</a></li>
				<li><a href="#!">S</a></li>
				<li><a href="#!">M</a></li>
				<li><a href="#!">L</a></li>
				<li><a href="#!">XL</a></li>
			</ul>
		</div><!-- /.widget-sizes -->
		
		<div class="widget widget-categories">
			<h3 class="widget-title">Categories</h3>
			<ul>
				<li>
					<a href="#!">Chairs <span class="count">(6)</span></a>
				</li>
				<li>
					<a href="#!">Tables <span class="count">(7)</span></a>
					<ul class="children">
						<li>
							<a href="#!">Side Tables <span class="count">(2)</span></a>
						</li>
						<li>
							<a href="#!">Lunch Tables <span class="count">(5)</span></a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#!">Couches <span class="count">(3)</span></a>
				</li>
				<li>
					<a href="#!">Lighting <span class="count">(4)</span></a>
				</li>
			</ul>
		</div><!-- /.widget-categories -->
	</content>	

    <content tag="left1">	
	
		<div class="masonry row">
			
			<g:each in="${avisos}" var="aviso">
				<evaca:productBox aviso="${aviso}"/>
			</g:each>						
		
		</div><!-- /.masonry -->
		
	</content>
	
</g:applyLayout>