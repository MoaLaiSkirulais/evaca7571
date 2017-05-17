jQuery(document).ready(function() {

    // Run slim scroll.
	$('[slim-scroll]').slimScroll({
		size: '5px',
		height: '100%'
	});

	// Make code pretty demo
    window.prettyPrint && prettyPrint();

    $('.docs a').attr('target', '_blank');

    $(".sidebar-nav li:not(.ex) > a").click(function(e){
        e.preventDefault();
        $('.sidebar-nav li:not(.ex)').removeClass('active');
        $(this).addClass('active');
        $("html,body").animate({scrollTop: $(this.hash).offset().top}, 'slow');
	});

    $('body').scrollspy();
});