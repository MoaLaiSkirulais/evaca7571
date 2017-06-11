<g:each in="${attrs.ofertas}" var="oferta">

	<div class="row">
		<div class="col-md-6 col-sm-12">
			<ol class="reviews">
				<li class="review">
					<div class="media">
						<div class="media-left media-middle">
							<a href="#!">
								<img class="media-object avatar" src="build/img/users/1.jpg">
							</a>
						</div>
						<div class="media-body">
							<div class="rating pull-right">
								<div class="star-rating">
									<span style="width:90%"></span>
								</div>
							</div>
							<h4 class="media-heading">${oferta.usuario}</h4>
							<time datetime="${oferta.fechaCreacion}">
								${oferta.fechaCreacion}
							</time>
							<div class="description">
								Oferta: ${oferta.precio} | Plazo: ${oferta.plazo}
							</div>
							<div class="description">
								Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the standard dummy text.
							</div>
						</div>
					</div>
				</li>
			</ol><!-- /.reviews -->
		</div>		
	</div><!-- /.row -->

</g:each>						