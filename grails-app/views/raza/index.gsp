<html>
	
    <head>
        <title>An Example Page</title>        
        <meta name="layout" content="sham" />
    </head>
	
    <body>
	
		<div class="page-head ">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-sm-7">
						<ol class="breadcrumb">
							<li><a href="index.html">Home</a></li>
							<li class="active"><a href="#!">Mis Lotes</a></li>
						</ol>
					</div>					
				</div><!-- /.row -->
			</div><!-- /.container -->
		</div><!-- /.page-head -->
			
		<div class="page-wrapper">
			
				<div class="container">
					<div class="row">
						<h2>Razas</h2><br>
						<div class="col-sm-12">
						
							<div class="table-responsive">
								<table class="table cart-table wishlist-table" cellspacing="0">
									<thead>
										<tr>
											<th class="product-name">id</th>
											<th class="product-name">fechaCreacion</th>
											<th class="product-name">owner</th>
											<th class="product-name">nombre</th>											
										</tr>
									</thead>
									
									<tbody>

										<g:each in="${razas}" var="raza" status="i">
											<tr class="item">
												
												<td class="product-name">
													${raza.id}
												</td>
												
												<td class="product-name">
													${raza.fechaCreacion}
												</td>
												
											    <td class="product-name">
													${raza.usuario}
												</td>
												
											    <td class="product-name">
													${raza.nombre}
												</td>
												
												<td class="product-add-to-cart">
													<!-- <button class="btn btn-default" type="button">Editar</button> -->
													<g:link action="edit" id="${raza.id}" class="btn btn-default">[edit]</g:link>

												</td>
											</tr><!-- <tr><td colspan="6"></td></tr> -->
										</g:each>					            
									</tbody>
								</table>
								<g:link action="create" class="btn btn-default">create</g:link>
							</div><!-- /.table-responsive -->
						</div>
					</div><!-- /.row -->
				</div><!-- /.container -->
		
		</div><!-- /.page-wrapper -->

	</body>

</html>