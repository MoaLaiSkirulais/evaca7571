<html>
	
    <head>
        <title>An Example Page</title>        
        <meta name="layout" content="evaca" />
    </head>
	
    <body>
	
		<div style="float:left; border: 1px solid red; width:800px">

			<f:table collection="avisos" 
				properties="[
							'lote', 
							'fechaCreacion', 
							'fechaPublicacion', 
							'tbState', 
							'consignatario', 
							'precio'
						]"/>

		</div>	

	</body>

</html>