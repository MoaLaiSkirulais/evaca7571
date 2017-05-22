<html>
	
    <head>
        <title>An Example Page!</title>        
        <meta name="layout" content="sham" />
    </head>
	
    <body>
	
		<div class="page-wrapper">
			<section class="section" id="contact-info">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<h3 class="no-margin-top">Why not say <span class="autotype">Hello</span><span class="typed-cursor">?</span></h3>
							<p class="description">
								Speak to our team if you have any questions, need advice or if you're curious to hear more about what we have to offer. Give us a call or send us an email.
							</p>

							<div>
								<p><strong>Phone:</strong> +90 555 888 111</p>
								<p><strong>Email:</strong> info@mercadovacuno.com</p>
								<p><strong>Address:</strong> Avcılar NO:9 DAİRE :2, Istanbul, Rey Castro</p>
							</div>
						</div>
						<div class="col-md-8">
							<g:form controller="contact" action="send" class="inputs-border">
								<div class="form-group">
									<input class="form-control" type="text" placeholder="Nombre" name="name">
								</div>
								<div class="form-group">
									<input class="form-control" type="text" placeholder="Email" name="email">
								</div>
								<div class="form-group">
									<textarea class="form-control" name="message" placeholder="Mensaje"></textarea>
								</div>
								<div class="form-group text-right">
									<g:submitButton name="update" value="Update" class="btn btn-default"/>
								</div>
							</g:form>
						</div>
					</div><!-- /.row -->
				</div><!-- /.container -->
			</section>
		</div><!-- /.page-wrapper -->
	</body>

</html>