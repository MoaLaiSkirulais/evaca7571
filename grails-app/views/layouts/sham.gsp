<html>

    <head>
        <title>
			<g:layoutTitle default="An example decorator milayout.gsp" />
		</title>

		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Sham - Creative Shopping Theme</title>

		<!-- Load Fonts -->
		<link rel="stylesheet" type="text/css" media="all" href="http://fonts.googleapis.com/css?family=Inconsolata:300,400,500,700|Unica+One:300,400,500,700">
		<!-- All theme style -->
		<link rel="stylesheet" href="${resource(dir: 'sham/css', file: 'min.css')}" type="text/css">

        <g:layoutHead />
    </head>
    
	<body>

		<div class="nav-container navbar-fixed-top nav-sticky" style="position: relative">
			<nav class="sub-navbar">
				<ul class="pull-right list-inline">
					<li><a href="#!">My account</a></li>
					<li><a href="wishlist.html">My Wishlist</a></li>
				</ul>
				<div class="clearfix"></div>
			</nav><!-- /.sub-navbar -->

			<nav class="navbar navbar-default">
				<div class="container">
					
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="index.html">
							<img style="border:0px solid red" src="${resource(dir: 'sham/img', file: 'logo.jpg')}" alt="Sham Theme">
						</a>
					</div>
					
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-left">
							<li><a href="about.html">About</a></li>
							<li><a href="contact.html">Contact</a></li>
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
							<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the standard dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div><!-- ./widget -->
						
						<evaca:links/>
						
						<div class="col-sm-3 widget widget-instagram">
							<h3 class="widget-title">Instagram</h3>
							<ul class="row">
								<li class="col-xs-4">
									<a href="#!">
										<img src="${resource(dir: 'sham/img/products', file: '23.jpg')}" class="img-responsive" alt="">
									</a>
								</li>
								<li class="col-xs-4">
									<a href="#!">
										<img src="${resource(dir: 'sham/img/products', file: '20.jpg')}" class="img-responsive" alt="">
									</a>
								</li>
								<li class="col-xs-4">
									<a href="#!">
										<img src="${resource(dir: 'sham/img/products', file: '18.jpg')}" class="img-responsive" alt="">
									</a>
								</li>
								<li class="col-xs-4">
									<a href="#!">
										<img src="${resource(dir: 'sham/img/products', file: '19.jpg')}" class="img-responsive" alt="">
									</a>
								</li>
								<li class="col-xs-4">
									<a href="#!">
										<img src="${resource(dir: 'sham/img/products', file: '24.jpg')}" class="img-responsive" alt="">
									</a>
								</li>
								<li class="col-xs-4">
									<a href="#!">
										<img src="${resource(dir: 'sham/img/products', file: '12.jpg')}" class="img-responsive" alt="">
									</a>
								</li>
							</ul>
						</div><!-- /.widget -->
						<div class="col-sm-3 widget widget-newsletter">
							<h3 class="widget-title">Join our Newsletter</h3>
							<form action="#!" method="POST" class="inputs-border clearfix">
								<div class="form-group">
									<input type="email" name="email" placeholder="Your Email" class="form-control" autocomplete="off">
									<button type="submit" class="btn btn-primary"><i class="lil-long-arrow-right"></i></button>
								</div>
							</form>
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
				<p>© Copyright 2016. All Rights Reserved. Created by <a href="#!" class="effect">Liliom</a></p>
			</div>
		</footer><!-- /.footer -->

		<!-- Go to top -->
		<a href="#top" class="go-to-top">
			<i class="lil-angle-double-down"></i>
		</a>
    </body>
	
</html>
