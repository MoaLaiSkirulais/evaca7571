<g:applyLayout name="layoutThreeColumns">

    <content tag="sidebar">
		<div class="widgets">
			<div class="widget widget-categories">
				
				<user:links/>

				<ul>		
					<li><br><br><h3>Accesos</h3></li>
					<li><g:link controller="lote" action="search">Lotes</g:link></li>
					<li><g:link controller="aviso" action="search">Avisos</g:link></li>
					<li><g:link controller="oferta" action="index">Ofertas</g:link></li>
					<li><g:link controller="venta" action="index">Ventas</g:link></li>
					<li><g:link controller="resena" action="index">Resena</g:link></li>
				</ul>	

				<admin:links/>				
					
			</div>
		</div>
	</content>	
	
    <content tag="left1">
	
		<div>
			<div>
				<g:pageProperty name="page.left1" />
			</div>
		</div>
		
	</content>
	
	<content tag="left2">

		<div>
			<div>
				<g:pageProperty name="page.left2" />
			</div>
		</div>
	</content>
	
</g:applyLayout>