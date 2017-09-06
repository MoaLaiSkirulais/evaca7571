<g:applyLayout name="layoutTwoColumns">

    <content tag="sidebar">
		<div class="widgets">
			<div class="widget widget-categories">
				
				<user:links/>

				<ul>		
					<li><br><br><h3>Accesos</h3></li>
					<li><g:link controller="lote" action="search">Lotes</g:link></li>
					<!-- <li><g:link controller="aviso" action="search">Avisos</g:link></li> -->
					<li><g:link controller="oferta" action="search">Ofertas</g:link></li>
					<!-- <li><g:link controller="venta" action="search">Ventas</g:link></li> -->
					<li><g:link controller="resena" action="search">Resena</g:link></li>
				</ul>	

				<admin:links/>
					
			</div>
		</div>
	</content>
	
    <content tag="left1">
	
		<div class="widgets">
			<div class="widget widget-categories">
				<g:pageProperty name="page.left1"/>
			</div>
		</div>

	</content>

</g:applyLayout>