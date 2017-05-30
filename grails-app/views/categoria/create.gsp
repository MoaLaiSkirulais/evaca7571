<html>
	
    <head>
        <meta name="layout" content="sham" />
    </head>
	
    <body>

		<evaca:breadcrums/>
		
		<div class="page-wrapper">
			
				<div class="container">
					<div class="row">

						<g:if test="${flash.message}">
							<div class="flash">
								${flash.message}
							</div>
						</g:if>

						<g:hasErrors>
							<div class="errors">
								<g:renderErrors bean="${model.categoria}" as="list" />
							</div>
						</g:hasErrors>

						<div class="col-sm-6">
						
							<h2>Categoria</h2>
							<form method="post">
							<table class="table table-condensed" cellspacing="0">
								<tbody>
								
									<myform:display label="Nombre" value="${model.categoria.id}"/>									
									<myform:display label="Usuario" value="${model.categoria.usuario}"/>
									<myform:display label="Fecha creacion" value="${model.categoria.fechaCreacion}"/>
									<myform:field label="Nombre" value="${model.categoria.nombre}"/>

									<tr class="order-total">
										<th>Nombre</th>
										<td class="text-right">
											<span class="amount">
												<f:field bean="${model.categoria}" property="nombre" />
											</span>
										</td>
									</tr>

									<tr class="order-total">
										<th></th>
										<td class="text-right">
											<div class="form-group text-right">
												<g:link action="create" class="btn btn-default">create</g:link>
												<g:actionSubmit action="save" value="save" class="btn btn-default"/>	
											</div>
										</td>
									</tr>
								</tbody>
							</table>
							</form>
								
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>

	</body>

</html>