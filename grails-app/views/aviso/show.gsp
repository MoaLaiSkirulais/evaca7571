<html>
	
    <head>
        <title>An Example Page</title>        
        <meta name="layout" content="sham" />
    </head>
	
    <body>
	
		<evaca:breadcrums/>

		<section class="section single-product-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-sm-5">
						<aviso:productImages aviso="${aviso}"/>
					</div>

					<div class="col-sm-7 col-sm-offset-0">
						<evaca:cruderror modelo="${aviso}"/>
						<aviso:productDetails aviso="${aviso}"/>
					</div>

					<div class="col-sm-12">
						<aviso:tabsWrapper aviso="${aviso}"/>
					</div>
				</div><!-- /.row -->
			</div><!-- /.container -->
		</section><!-- /.products -->
			
	</body>

</html>