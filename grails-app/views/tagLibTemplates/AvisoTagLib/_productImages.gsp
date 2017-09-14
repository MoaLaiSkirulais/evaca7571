<div class="product-images">
	<div class="product-thumbnail">
		<a href="build/img/products/13.jpg" class="fancybox" rel="gallery">
			<!-- <img src="build/img/products/13.jpg" class="img-responsive"> -->
			<div class="product-thumbnail" 
				style="background-image: url('/lote/get_image/${attrs.aviso?.lote?.id}'); background-color: #cccccc; width:259px; height:329px" >
			</div>
			<!-- <img src="<g:createLink controller='lote' action='get_image' id='${attrs.aviso?.lote?.id}'/>"/> -->
		</a>
	</div>
	
	<div style="width:250px; border:0px solid red">

		<div style="width:250px; border:0px solid blue; height:88px">
			<div style="float:left; width:90px">
				<img src="<g:createLink controller='usuario' action='get_image' id='${attrs.aviso.propietario.id}'/>" style="border: 0px solid gray;  opacity: 1.0; width:90px" />
			</div>
			<div style="float:right; width:160px; height:88px; border:0px solid green;">
				<div style="margin-top:35px">Vendedor</div>
				<h3 style="margin:0px">${attrs.aviso.propietario}</h3>
			</div>			
		</div><br>
		
		<div style="width:250px; border:0px solid blue; height:88px">
			<div style="float:left; width:90px">
				<img src="<g:createLink controller='usuario' action='get_image' id='${attrs.aviso.consignatario.id}'/>" style="border: 0px solid gray;  opacity: 1.0; width:90px" />
			</div>
			<div style="float:right; width:160px; height:88px; border:0px solid green;">
				<div style="margin-top:35px">Consignatario</div>
				<h3 style="margin:0px">${attrs.aviso.consignatario}</h3>
			</div>			
		</div>
	
		<!-- <div style="position:absolute; left:10; border:1px solid blue; width:100%;"> -->
			<!-- consignatario<br> -->
			<!-- <h3 class="product-name"> -->
				<!-- ${attrs.aviso.consignatario}<br> -->
			<!-- </h3> -->
			<!-- <img src="<g:createLink controller='usuario' action='get_image' id='${attrs.aviso.consignatario.id}'/>" style="border: 1px solid gray; opacity: 1.0;"/> -->
		<!-- </div> -->
	</div>
	<!-- <div class="product-images-carousel"> -->
		<!-- <div class="item"> -->
			<!-- <a href="build/img/products/1.jpg" class="fancybox" rel="gallery"> -->
				<!-- <img src="build/img/products/1.jpg" class="img-responsive"> -->
			<!-- </a> -->
		<!-- </div> -->
		<!-- <div class="item"> -->
			<!-- <a href="build/img/products/19.jpg" class="fancybox" rel="gallery"> -->
				<!-- <img src="build/img/products/19.jpg" class="img-responsive" alt=""> -->
			<!-- </a> -->
			<!-- </div> -->
		<!-- <div class="item"> -->
			<!-- <a href="build/img/products/12.jpg" class="fancybox" rel="gallery"> -->
				<!-- <img src="build/img/products/12.jpg" class="img-responsive" alt=""> -->
			<!-- </a> -->
		<!-- </div> -->
		<!-- <div class="item"> -->
			<!-- <a href="build/img/products/3.jpg" class="fancybox" rel="gallery"> -->
				<!-- <img src="build/img/products/3.jpg" class="img-responsive"> -->
			<!-- </a> -->
		<!-- </div> -->
		<!-- <div class="item"> -->
			<!-- <a href="build/img/products/18.jpg" class="fancybox" rel="gallery"> -->
				<!-- <img src="build/img/products/18.jpg" class="img-responsive" alt=""> -->
			<!-- </a> -->
		<!-- </div> -->
	<!-- </div> -->
</div><!-- /.product-images -->