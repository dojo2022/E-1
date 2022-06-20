/**
 *
 */
 $('tr[data]').click(function (e) {
	if (!$(e.target).is('a')) {
		window.location = $(e.target).data('href');
	};
});