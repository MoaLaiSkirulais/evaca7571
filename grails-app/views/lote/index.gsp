<html>
	
    <head>
        <title>An Example Page</title>        
        <meta name="layout" content="evaca" />
    </head>
	
    <body>
	
		<div style="float:left; border: 1px solid red; width:800px">

			<f:table collection="lotes" 
				properties="['cantidad', 
							'fechaCreacion', 
							'raza', 
							'categoria', 
							'pesoPromedio', 
							'ubicacion'
							]"/>

		</div>	

	</body>

</html>