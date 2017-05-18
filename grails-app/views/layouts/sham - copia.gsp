<html>

    <head>
        <title>
			<g:layoutTitle default="An example decorator milayout.gsp" />
		</title>

		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Sham - Creative Shopping Theme</title>

		<!-- Load Fonts -->
		<link rel="stylesheet" type="text/css" media="all" href="http://fonts.googleapis.com/css?family=Inconsolata:300,400,500,700|Unica+One:300,400,500,700">
		<!-- All theme style -->
		<!-- <link rel="stylesheet" type="text/css" media="all" href="sham/css/min.css"> -->
		<link rel="stylesheet" href="${resource(dir: 'sham/css', file: 'min.css')}" type="text/css">

        <g:layoutHead />
    </head>
    
	<body>

		<div class="menu" style="border: 1px solid red; height:100px">
			<!--my common menu goes here-->
			<div style="float:left; border: 1px solid red; width:400px">
				<h1>eVaca</h1>
			</div>
			<!-- <evaca:sayHi to="Mortimer" /> -->
			<evaca:sayHo/>
			<evaca:actions/>
		</div>

        <div class="body" style="border: 1px solid blue; height:700px">
            <g:layoutBody />			
		</div>
		
		<div class="footer" style="border: 1px solid green; height:100px">
			<!--my common menu goes here-->
		</div>
		<!-- <script type="text/javascript" src="build/js/min.js"></script> -->
    </body>
	
</html>
