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
											<th class="product-name">fechaCreacion</th>
											<th class="product-name">raza</th>
											<th class="product-name">categoria</th>
											<th class="product-name">cantidad</th>
											<th class="product-name">ubicacion</th>
											<th class="product-name">pesoPromedio</th>
										</tr>
									</thead>
									
									<tbody>

										<g:each in="${lotes}" var="lote" status="i">
											<tr class="item">
												
												<td class="product-name">
													${lote.fechaCreacion}
												</td>
												
											   <td class="product-name">
													${lote.raza}
												</td>
												
											   <td class="product-name">
													${lote.categoria}
												</td>
												
											   <td class="product-name">
													${lote.cantidad}
												</td>
												
											   <td class="product-name">
													${lote.ubicacion}
												</td>    
												
											   <td class="product-name">
													${lote.pesoPromedio}
												</td>
												
												<td class="product-add-to-cart">
													<!-- <button class="btn btn-default" type="button">Editar</button> -->
													<g:link action="edit" id="${lote.id}" class="btn btn-default">Edit</g:link>

												</td>
											</tr><!-- <tr><td colspan="6"></td></tr> -->
										</g:each>					            
									</tbody>
								</table>
								<g:link action="create" class="btn btn-default">Nuevo</g:link>
							</div><!-- /.table-responsive -->
						</div>
					</div><!-- /.row -->
				</div><!-- /.container -->
			</section><!-- /#wishlist -->
		</div><!-- /.page-wrapper -->

	</body>

</html>