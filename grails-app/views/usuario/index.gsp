<html>
	
    <head>
        <title>An Example Page!</title>        
        <meta name="layout" content="sham" />
    </head>
	
    <body>
	
		<div class="page-wrapper">
			<section class="section" id="page-login">
		
				<div class="container">				
					<div class="row">

						<g:if test="${flash.message}">
							<div class="flash">
								${flash.message}
							</div>
						</g:if>

						<g:hasErrors>
							<div class="errors">
								<g:renderErrors bean="${usuario}" as="list" />
							</div>
						</g:hasErrors>

						<div class="col-sm-6">
							<div class="box">
								<h2>login</h2><br>
								<g:form controller="usuario" action="register" class="inputs-border">
									<div class="form-group">
										<div class="required">
											<input class="form-control" placeholder="username" type="text" placeholder="username" name="username" value="${usuario?.username}"/></p>
										</div>
									</div>
									
									<div class="form-group">
										<div class="required">
											<input class="form-control" placeholder="password" type="text" placeholder="password" name="password" value="${usuario?.password}"/></p>
										</div>
									</div>

									<div class="form-group text-right">
										<g:submitButton name="login" value="login" class="btn btn-default"/></td></p>
									</div>
									
								</g:form>
							</div>
						</div><!-- /.box -->			
		
						<div class="col-sm-6">						
							<div class="box">
								<h2>nuevo usuario</h2><br>
								<g:form controller="usuario" action="register" class="inputs-border">
									<div class="form-group">
										<div class="required">
											<input class="form-control" placeholder="nombre" type="text" placeholder="nombre" name="nombre" value="${usuario?.nombre}"/></p>
										</div>								
									</div>
									
									<div class="form-group">
										<div class="required">
											<input class="form-control" placeholder="apellido" type="text" placeholder="apellido" name="apellido" value="${usuario?.apellido}"/></p>
										</div>								
									</div>
									
									<div class="form-group">
										<input class="form-control" placeholder="email" type="text" placeholder="email" name="email" value="${usuario?.email}"/></p>
									</div>
									
									<div class="form-group">
										<input class="form-control" placeholder="username" type="text" value="${usuario?.username}" name="username"/></p> 
									</div>
									
									<div class="form-group">
										<input class="form-control" placeholder="tbTipo" type="text" value="${usuario?.tbTipo}" name="tbTipo"/></p>
									</div>
									
									<div class="form-group">
										<input class="form-control" placeholder="tbState" type="text" value="${usuario?.tbState}" name="tbState"/></p>
									</div>
									
									<div class="form-group">
										<input class="form-control" placeholder="comision" type="text" value="${usuario?.comision}" name="comision"/></p>
									</div>
									
									<div class="form-group">
										<input class="form-control" placeholder="password" type="text" value="${usuario?.password}" name="password"/></p>
									</div>
									
									<div class="form-group">
										<input class="form-control" placeholder="repassword" type="text" name="repassword"/></p>
									</div>

									<div class="form-group text-right">
										<g:submitButton name="update" value="Update" class="btn btn-default"/></td></p>
									</div>
								</g:form>
							</div><!-- /.box -->		
						</div>
					</div>
				</div>
			</section><!-- #page-login -->
		</div><!-- /.page-wrapper -->
	</body>

</html>