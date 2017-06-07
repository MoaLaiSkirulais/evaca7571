<div class="tabs-wrapper">
	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<li class="active">
			<a href="#tab-description" aria-controls="tab-description" data-toggle="tab">Description</a>
		</li>
		<li>
			<a href="#tab-information" aria-controls="tab-information" data-toggle="tab">Additional Information</a>
		</li>
		<li>
			<a href="#tab-reviews" aria-controls="tab-reviews" data-toggle="tab">Reviews (3)</a>
		</li>
	</ul>
	<!-- Tab panes -->
	<div class="tab-content">
		<div class="tab-pane active" id="tab-description">
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the standard dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the standard dummy text.Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>

			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the standard dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
		</div>
		<div class="tab-pane" id="tab-information">
			<table class="table shop_attributes">
				<tbody>
					<tr>
						<th>Color</th>
						<td>
							<p>Red, Black, Yellow</p>
						</td>
					</tr>
					<tr>
						<th>Materials</th>
						<td>
							<p>Wood</p>
						</td>
					</tr>
					<tr>
						<th>Dimensions</th>
						<td>
							<p>H:1.5″ x W: 2.75″ x D: 3.0″</p>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="tab-pane" id="tab-reviews">
			<div class="row">
				<div class="col-md-6 col-sm-12">
					<ol class="reviews">
						<li class="review">
							<div class="media">
								<div class="media-left media-middle">
									<a href="#!">
										<img class="media-object avatar" src="build/img/users/1.jpg">
									</a>
								</div>
								<div class="media-body">
									<div class="rating pull-right">
										<div class="star-rating">
											<span style="width:90%"></span>
										</div>
									</div>
									<h4 class="media-heading">Hussam 3bd</h4>
									<time datetime="2016-06-07T11:44:50+00:00">June 7, 2016</time>
									<div class="description">
										Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the standard dummy text.
									</div>
								</div>
							</div>
						</li>

						<li class="review">
							<div class="media">
								<div class="media-left media-middle">
									<a href="#!">
										<img class="media-object avatar" src="build/img/users/2.jpg">
									</a>
								</div>
								<div class="media-body">
									<div class="rating pull-right">
										<div class="star-rating">
											<span style="width:60%">
										</div>
									</div>
									<h4 class="media-heading">Toyler</h4>
									<time datetime="2016-06-07T11:44:50+00:00">June 25, 2016</time>
									<div class="description">
										Lorem Ipsum is simply dummy text of the printing and typesetting industry.
									</div>
								</div>
							</div>
						</li>

						<li class="review">
							<div class="media">
								<div class="media-left media-middle">
									<a href="#!">
										<img class="media-object avatar" src="build/img/users/3.jpg">
									</a>
								</div>
								<div class="media-body">
									<div class="rating pull-right">
										<div class="star-rating">
											<span style="width:75%">
										</div>
									</div>
									<h4 class="media-heading">Alex</h4>
									<time datetime="2016-06-07T11:44:50+00:00">Feb 10, 2016</time>
									<div class="description">
										Lorem Ipsum is simply dummy text of the printing and typesetting industry.
									</div>
								</div>
							</div>
						</li>
					</ol><!-- /.reviews -->
				</div>
				<div class="col-md-5 col-sm-12 col-md-offset-1 review-form-wrapper">
					<form action="#!" method="post" class="review-form">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Name*" required>
						</div>
						<div class="form-group">
							<input type="email" class="form-control" placeholder="Email*" required>
						</div>
						<div class="form-group">
							<label for="rating">Rating</label>
							<div class="rating-stars" data-rating="4"></div>
							<input type="hidden" name="rating" value="4" required>
						</div>
						<div class="form-group">
							<textarea class="form-control" placeholder="Your Review*" rows="5" required></textarea>
						</div>
						<div class="form-group">
							<button type="button" class="btn btn-default">Leave Rating</button>
						</div>
					</form>
				</div>
			</div><!-- /.row -->
		</div>
	</div>
</div><!-- /.tabs-wrapper -->