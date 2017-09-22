<div class="row">
	<div class="col-md-6 col-sm-12">
		<ol class="reviews">
		
			<g:each status="i" in="${attrs.resenas}" var="resena">
				<li class="review">
					<div class="media">
						<div class="media-left media-middle">
							<a href="#!">
								<img class="media-object avatar" 
									src="<g:createLink controller='usuario' action='get_image' id='${resena.propietario.id}'/>" />
							</a>
						</div>
						<div class="media-body">
							
							<div class="rating pull-right">
								<div class="star-rating">
									<span style="width:${resena.puntaje * 100 / 5}%">
								</div>
							</div>
							
							<h4 class="media-heading">
								${resena.propietario}
							</h4>

							<time datetime="${resena.fechaCreacion}">
								<b>#${i+1}</b> - 
								<b><g:formatDate date="${resena.fechaCreacion}" type="datetime" style="FULL" timeStyle="SHORT"/></b>
							</time>
							
							<div class="description">
								<b>${resena.comentario}</b><br>
								Estado: <aviso:entityState state="${resena.state}"/>
							</div>
						</div>
					</div>
				</li>
			</g:each>
			
		</ol><!-- /.reviews -->
	</div>
	<!-- <div class="col-md-5 col-sm-12 col-md-offset-1 review-form-wrapper"> -->
		<!-- <form action="#!" method="post" class="review-form"> -->
			<!-- <div class="form-group"> -->
				<!-- <input type="text" class="form-control" placeholder="Name*" required> -->
			<!-- </div> -->
			<!-- <div class="form-group"> -->
				<!-- <input type="email" class="form-control" placeholder="Email*" required> -->
			<!-- </div> -->
			<!-- <div class="form-group"> -->
				<!-- <label for="rating">Rating</label> -->
				<!-- <div class="rating-stars" data-rating="4"></div> -->
				<!-- <input type="hidden" name="rating" value="4" required> -->
			<!-- </div> -->
			<!-- <div class="form-group"> -->
				<!-- <textarea class="form-control" placeholder="Your Review*" rows="5" required></textarea> -->
			<!-- </div> -->
			<!-- <div class="form-group"> -->
				<!-- <button type="button" class="btn btn-default">Leave Rating</button> -->
			<!-- </div> -->
		<!-- </form> -->
	<!-- </div> -->
</div><!-- /.row -->