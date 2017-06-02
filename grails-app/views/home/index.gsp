<html>
	
    <head>
        <title>An Example Page</title>        
        <meta name="layout" content="sham" />
    </head>
	
    <body>
	
		<evaca:breadcrums/>
		<evaca:cruderror />

		<section class="section products second-style"  id="home-products">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 section-title text-center">
						<h3><i class="line"></i>Ultimos Avisos<i class="line"></i></h3>
						<p>Avisos ingresados recientemente durante las últimas 24 horas</p>
					</div>
					<div class="col-sm-12">
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

	</body>

</html>