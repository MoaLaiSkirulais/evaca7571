<g:applyLayout name="layoutTwoColumns">
	
	    <content tag="sidebar">
			<aviso:finder/>						
		</content>
	
	    <content tag="left1">

			<section class="section products second-style"  id="home-products" style="padding: 0;">
				<div class="container">
					<div class="row">
						<div class="col-sm-9 section-title text-center">
							<h3><i class="line"></i>Ultimos Avisos<i class="line"></i></h3>
							<p>Avisos ingresados recientemente durante las últimas 24 horas</p>
						</div>
						<!-- <div class="col-sm-12"> -->
						<div class="col-sm-9">
							<div class="masonry row">
								
								<g:each in="${avisos}" var="aviso">
									<evaca:productBox aviso="${aviso}"/>
								</g:each>						
							
							</div><!-- /.masonry -->
						</div>
						<div class="col-sm-12 text-center">
							<a href="#!" class="btn btn-default">Show More</a>
						</div>
					</div><!-- /.row -->
				</div><!-- /.container -->
			</section><!-- /.products -->
		</content>
	

</g:applyLayout>