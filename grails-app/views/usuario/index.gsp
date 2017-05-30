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
			<section class="section">
				<div class="container">
					<div class="row">
						<div class="col-sm-12">						
						
							<div class="table-responsive">
								<table class="table cart-table wishlist-table" cellspacing="0">
									<thead>
										<tr>
											<th class="product-name">id</th>
											<th class="product-name">fechaCreacion</th>
											<th class="product-name">nombre</th>
											<th class="product-name">apellido</th>
											<th class="product-name">email</th>
											<th class="product-name">tbTipo</th>
											<th class="product-name">tbSate</th>
										</tr>
									</thead>
									
									<tbody>

										<g:each in="${usuarios}" var="usuario" status="i">
											<tr class="item">
												
												<td class="product-name">
													${usuario.id}
												</td>
												
												<td class="product-name">
													${usuario.fechaCreacion}
												</td>
												
											   <td class="product-name">
													${usuario.nombre}
												</td>
												
											   <td class="product-name">
													${usuario.apellido}
												</td>
												
											   <td class="product-name">
													${usuario.email}
												</td>
												
											   <td class="product-name">
													${usuario.tbTipo}
												</td>    
												
											   <td class="product-name">
													${usuario.tbState}
												</td>
												
												<td class="product-add-to-cart">
													<g:link action="edit" id="${usuario.id}" class="btn btn-default">Edit</g:link>
												</td>
											</tr><!-- <tr><td colspan="6"></td></tr> -->
										</g:each>					            
									</tbody>
								</table>
							</div><!-- /.table-responsive -->
						</div>
					</div><!-- /.row -->
				</div><!-- /.container -->
			</section><!-- /#wishlist -->
		</div><!-- /.page-wrapper -->

	</body>

</html>
