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
							<li class="active"><a href="#!">Categorias</a></li>
						</ol>
					</div>					
				</div><!-- /.row -->
			</div><!-- /.container -->
		</div><!-- /.page-head -->
			
		<div class="page-wrapper">
			
				<div class="container">
					<div class="row">
						<h2>Categorias</h2><br>
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

										<g:each in="${categorias}" var="categoria" status="i">
											<tr class="item">
												
												<td class="product-name">
													${categoria.id}
												</td>
												
												<td class="product-name">
													${categoria.fechaCreacion}
												</td>
												
											    <td class="product-name">
													${categoria.usuario}
												</td>
												
											    <td class="product-name">
													${categoria.nombre}
												</td>
												
												<td class="product-add-to-cart">
													<!-- <button class="btn btn-default" type="button">Editar</button> -->
													<g:link action="edit" id="${categoria.id}">[edit]</g:link>

												</td>
											</tr><!-- <tr><td colspan="6"></td></tr> -->
										</g:each>					            
									</tbody>
								</table>
							</div><!-- /.table-responsive -->
						</div>
					</div><!-- /.row -->
				</div><!-- /.container -->
			
		</div><!-- /.page-wrapper -->

	</body>

</html>