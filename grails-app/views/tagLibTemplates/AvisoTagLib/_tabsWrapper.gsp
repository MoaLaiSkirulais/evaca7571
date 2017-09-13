<div class="tabs-wrapper">
	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<li>
			<a href="#tab-description" aria-controls="tab-description" data-toggle="tab">Description</a>
		</li>
		<li class="active">
			<a href="#tab-information" aria-controls="tab-information" data-toggle="tab">Additional Information</a>
		</li>
		<li>
			<a href="#tab-reviews" aria-controls="tab-reviews" data-toggle="tab">Reviews (3)</a>
		</li>
	</ul>
	<!-- Tab panes -->
	<div class="tab-content">
		<div class="tab-pane" id="tab-description">
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the standard dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the standard dummy text.Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>

			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the standard dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
		</div>

		<!-- <div class="tab-pane" id="tab-information"> -->
			<!-- <aviso:tabInformation/> -->
		<!-- </div> -->

		<div class="tab-pane active" id="tab-information">
			<aviso:tabOfertas ofertas="${attrs.aviso.ofertas}"/>
		</div>		

		<div class="tab-pane" id="tab-reviews">
			<aviso:tabResenas resenas="${attrs.aviso.resenas}"/>
		</div>
	</div>
</div><!-- /.tabs-wrapper -->