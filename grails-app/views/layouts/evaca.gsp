<html>

    <head>
        <title><g:layoutTitle default="An example decorator milayout.gsp" /></title>
        <g:layoutHead />
    </head>
    
	<body>
        
		<div class="menu" style="border: 1px solid red; height:100px">
			<!--my common menu goes here-->
		</div>
		
        <div class="body" style="border: 1px solid blue; height:700px">
            <g:layoutBody />			
        </div>
		
		<div class="footer" style="border: 1px solid green; height:100px">
			<!--my common menu goes here-->
		</div>
    </body>
	
</html>
