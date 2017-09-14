<div class="product-details">
	<div class="rating">
		<div class="star-rating">
			<span style="width:90%"></span>
		</div>
		<span class="rating-text">${attrs.aviso.resenas.size()} Reviews</span>
		<span class="pull-right">ID <span>#${attrs.aviso.id} | </span><span style="color:#E74C3C">${attrs.aviso.state}</span>
	</div>

	<div class="product-title">
		<h3 class="product-name">${attrs.aviso.lote.raza}</h3>		
		<p class="product-available">Publicado: ${attrs.aviso.fechaCreacion}</p>
		<p class="product-available">Ubicación: ${attrs.aviso.lote.provincia} / ${attrs.aviso.lote.ubicacion}</p>
		<p class="product-available">Categoria: ${attrs.aviso.lote.categoria}</p>
		<p class="product-available">Edad: 33</p>		
		<hr>
	</div>

	<div class="description">	
		<p class="product-available">Peso Promedio: 100 | Peso Minimo: 80 | Peso Máximo: 200</p>
		<hr>
		<p>
			Muy buenos animales, excelente sanidad.
		</p>
		<p>
			Buen lote de novillos trazados, de buen hueso, buena caja. Todos marca líquida, de buena genética, ideal para darle kilos. Se destaca mansedumbre.
		</p>
		<p>
			Están criados a leche, alimento balanceado y rollos de alfalfa. La filmación corresponde a un tambo, los demás terneros se completan en 3 tambos más. Buen desarrollo y sanidad.

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