
	<div class="row">
		<div class="col-md-6 col-sm-12">
			<ol class="reviews">
				<g:each status="i" in="${attrs.ofertas}" var="oferta">
				<li class="review">
					<div class="media">
						<div class="media-left media-middle">
							<a href="#!">
								<img class="media-object avatar" 
									src="<g:createLink controller='usuario' action='get_image' id='${oferta?.propietario?.id}'/>" />
							</a>
						</div>
						<div class="media-body">
							<div class="rating pull-right">
								<!-- <div class="star-rating"> -->
									<!-- <span style="width:90%"></span> -->
								<!-- </div> -->
							</div>
							<h4 class="media-heading">${oferta.propietario}</h4>
							<time datetime="${oferta.fechaCreacion}">
								<b>#${i+1}</b> - 
								<b><g:formatDate date="${oferta.fechaCreacion}" type="datetime" style="FULL" timeStyle="SHORT"/></b>

							</time>
							<div class="description">
								Precio ofertado: ${oferta.precio}<br>
								Plazo ofertado: ${oferta.plazo}<br>
							Estado: <aviso:entityState state="${oferta.state}"/>
								
							</div>

							<!-- <div class="description"> -->
								<!-- Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the standard dummy text. -->
							<!-- </div> -->
						</div>
					</div>
				</li>
				</g:each>						
			</ol><!-- /.reviews -->
		</div>		
	</div><!-- /.row --><br><br>
