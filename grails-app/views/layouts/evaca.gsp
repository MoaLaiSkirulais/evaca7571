<html>

    <head>
        <title>
			<g:layoutTitle default="An example decorator milayout.gsp" />
		</title>
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'evaca.css')}" type="text/css">

        <g:layoutHead />
    </head>
    
	<body>

		<div class="menu" style="border: 1px solid red; height:100px">
			<!--my common menu goes here-->
			<div style="float:left; border: 1px solid red; width:400px">
				<h1>eVaca</h1>
			</div>
			<!-- <evaca:sayHi to="Mortimer" /> -->
			<evaca:actions/>
		</div>
		
        <div class="body" style="border: 1px solid blue; height:700px">
            <g:layoutBody />			
			</div>
		
		<div class="footer" style="border: 1px solid green; height:100px">
			<!--my common menu goes here-->
		</div>
    </body>
	
</html>
