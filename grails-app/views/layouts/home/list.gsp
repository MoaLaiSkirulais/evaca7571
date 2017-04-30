<html>
    <head>
        <title><g:layoutTitle default="An example decorator milayout.gsp" /></title>
        <g:layoutHead />
    </head>
    <body onload="${pageProperty(name:'body.onload')}">
	
		<g:emoticon happy="true">Hi John</g:emoticon>
		<g:dateFormat format="dd-MM-yyyy" date="${new Date()}" />
		<g:formatBook book="${myBook}" />

        <div class="menu"><!--my common menu goes here--></div>
        <div class="body">
            <g:layoutBody />
				List!
        </div>
    </body>
</html>
