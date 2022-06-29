function submit_edit(){
	var rotate = document.querySelector('.rotate');
	rotate.animate(
		[
		{ transform: 'rotate(0deg)' },
		{ transform: 'rotate(360deg)' }
		],
		{ duration: 3000,
		  easing: 'linear'
		}
			);
}