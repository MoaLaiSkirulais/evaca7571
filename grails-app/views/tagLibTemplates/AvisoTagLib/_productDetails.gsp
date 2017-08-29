<div class="product-details">
	<div class="rating">
		<div class="star-rating">
			<span style="width:90%"></span>
		</div>
		<span class="rating-text">3 Reviews</span>
		<span class="pull-right">ID: <span>${attrs.aviso.id}</span></span>
	</div>

	<div class="product-title">
		<h3 class="product-name">${attrs.aviso.lote.raza}</h3>
		<p class="product-available">${attrs.aviso.consignatario} / ${attrs.aviso.fechaCreacion}</p>
		<p class="product-available">${attrs.aviso.lote.ubicacion}</p>
		<hr>
	</div>

	<div class="description">
		<p>
			Muy buenos animales, excelente sanidad.
		</p>
		<p>
			Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
			tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
			consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
			cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
			proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
		</p>
		<p>
			Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the standard dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry.
		</p>
	</div>

	<p class="price">
		<del>
			<span class="amount">$1000</span>
		</del>
		<ins>
			<span class="amount">$${attrs.aviso.precio}</span>
		</ins>
	</p>

	<aviso:oferta aviso="${aviso}" plazos="${plazos}"/>
	
	<div class="product-share">
		<span>Share on</span>
		<ul class="social">
			<li><a href="#!"><i class="lil-facebook"></i></a></li>
			<li><a href="#!"><i class="lil-twitter"></i></a></li>
			<li><a href="#!"><i class="lil-google-plus"></i></a></li>
			<li><a href="#!"><i class="lil-linkedin"></i></a></li>
			<li><a href="#!"><i class="lil-pinterest"></i></a></li>
		</ul>
	</div>
</div><!-- /.product-details -->