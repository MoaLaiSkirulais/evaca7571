<html>

    <head>
        <title>
			<g:layoutTitle default="Mercado Vacuno" />
		</title>

		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- Load Fonts -->
		<!-- <link rel="stylesheet" type="text/css" media="all" href="http://fonts.googleapis.com/css?family=Inconsolata:300,400,500,700|Unica+One:300,400,500,700"> -->
		<link rel="stylesheet" href="${resource(dir: 'sham/fonts', file: 'Inconsolata.css')}" type="text/css">

		<!-- All theme style -->
		<link rel="stylesheet" href="${resource(dir: 'sham/css', file: 'min.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'sham/css', file: 'myMin.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'sham/css', file: 'usuario.css')}" type="text/css">

        <g:layoutHead />
    </head>
    
	<body>

		<div class="nav-container navbar-fixed-top nav-sticky" style="position: relative">
			<nav class="sub-navbar">
				<ul class="pull-right list-inline">
					<li><evaca:showSession/></li>
					<li><a href="/usuario/show_profile">Mi cuenta</a></li>
					<!-- <li><a href="wishlist.html">My Wishlist</a></li> -->
				</ul>
				<div class="clearfix"></div>
			</nav><!-- /.sub-navbar -->

			<nav class="navbar navbar-default" style="border-bottom: 1px solid #e4dddd">
				<div class="container">
					
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="/home">
							<img style="border:0px solid red" src="${resource(dir: 'sham/img', file: 'logo.jpg')}" alt="Sham Theme">
						</a>
					</div>
					
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-left">

							<li><a href="/contact/about">Quienes somos</a></li>
							<li><a href="/contact">Contactenos</a></li>
							<!-- <li> -->
								<!-- <a href="#!" data-toggle="dropdown" aria-haspopup="false" aria-expanded="false">Tablas <i class="caret"></i></a> -->
								<!-- <ul class="dropdown-menu"> -->
									<!-- <li><a href="raza">Razas</a></li> -->
									<!-- <li><a href="categoria">Categorias</a></li> -->
								<!-- </ul> -->
							<!-- </li> -->
							
						</ul>
					</div><!--/.nav-collapse -->
				</div><!--/.container -->
			</nav>
		</div><!-- /.nav-container -->
		
		<g:layoutBody />		

		<footer class="footer">
			<div class="container">
				<div class="widgets">
					<div class="row">
						<div class="col-sm-3 widget widget-about">
							<h3 class="widget-title">Mercado Vacuno</h3>
							<p>Ofrecé tus tropas de gordo y recibí ofertas de los principales compradores del país. Cotizá tus tropas en minutos, sin costo y con las condiciones comerciales y de plazo que necesités. Mantené la documentación prolija y en un solo lugar, con un exhaustivo análisis de resultados.</p>
						</div><!-- ./widget -->
						
						<evaca:links/>
						
						<div class="col-sm-3 widget widget-instagram">
							<!-- <evaca:instagram/>	-->
						</div><!-- /.widget -->
						<div class="col-sm-3 widget widget-newsletter">
							
							<ul class="social">
								<li><a href="#!" target="_blank"><i class="lil-facebook"></i></a></li>
								<li><a href="#!" target="_blank"><i class="lil-twitter"></i></a></li>
								<li><a href="#!" target="_blank"><i class="lil-instagram"></i></a></li>								
							</ul>
						</div><!-- ./widget -->
					</div><!-- /.row -->
				</div><!-- /.widgets -->
			</div><!-- /.container -->
			<div class="copy-right text-center">
				<p>© Copyright 2017. All Rights Reserved. Created by <a href="#!" class="effect">delios</a></p>
			</div>
		</footer><!-- /.footer -->

		<!-- Go to top -->
		<a href="#top" class="go-to-top">
			<i class="lil-angle-double-down"></i>
		</a>
		
		<script type="text/javascript" src="${resource(dir: 'sham/js', file: 'min.js')}"></script>
    </body>
	
</html>
