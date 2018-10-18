$(document).ready(function() {
	$('#header a').click(function() {
		var aClicked = $(this).attr('href');
		$('#header a').each(function() {
			if ($(this).attr('href') == aClicked) {
				$(this).css('color', '#ff6700');
				$(this).css('font-weight', 'bold');
				$(this).css('text-decoration', 'none');
			} else {
				$(this).css('color', '#fff');
				$(this).css('font-weight', 'bold');
			}
		});
		var page = $(this).attr('href');
		$.ajax({
			url : page,
		}).done(function(html) {
			$('#main').html('<h2><div class="loader"></div><div class="spinner">Loading <div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div></h2>');
			window.setTimeout(function() {
				$('#main').empty().append(html);
			}, 5000)
			
		});
		return false;
	});
	
	$('#ok a').click(function() {
		var page = $(this).attr('href');
	});
});
