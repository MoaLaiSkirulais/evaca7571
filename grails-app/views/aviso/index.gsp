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
							<li class="active"><a href="#!">Mis Avisos</a></li>
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
											<th class="product-name">lote</th>
											<th class="product-name">tbState</th>
											<th class="product-name">consignatario</th>
											<th class="product-name">precio</th>
										</tr>
									</thead>
									
									<tbody>								
										<g:each in="${avisos}" var="item" status="i">
											<tr class="item">
												
												<td class="product-name">
													${item.fechaCreacion}
												</td>
												
											   <td class="product-name">
													${item.lote}
												</td>
												
											   <td class="product-name">
													${item.tbState}
												</td>
												
											   <td class="product-name">
													${item.consignatario}
												</td>
												
											   <td class="product-name">
													${item.precio}
												</td>    
												
												<td class="product-add-to-cart">
													<!-- <button class="btn btn-default" type="button">Editar</button> -->
													<g:link action="edit" id="${item.id}">Edit</g:link>

												</td>
											</tr><!-- <tr><td colspan="6"></td></tr> -->
										</g:each>					            
									</tbody>
								</table>
								<g:link action="create" controller="aviso" class="btn btn-default">create</g:link>
							</div><!-- /.table-responsive -->
						</div>
					</div><!-- /.row -->
				</div><!-- /.container -->
			</section><!-- /#wishlist -->
		</div><!-- /.page-wrapper -->

	</body>

</html>