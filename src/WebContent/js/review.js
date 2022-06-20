 function loadImage(obj)
{
	document.getElementById('insert_image');
	for (i = 0; i < obj.files.length; i++) {
		var fileReader = new FileReader();
		fileReader.onload = (function (e) {
			document.getElementById('insert_image').innerHTML += '<img src="' + e.target.result + '" >';
		});
		fileReader.readAsDataURL(obj.files[i]);
	}
}

var formObj = document.getElementById('review_form');
var errorMessageObj = document.getElementById('error_message');
formObj.onsubmit = function() {
	  if (!formObj.product_name.value || !formObj.title.value || !formObj.genre.value || !formObj.series.value) {
	    errorMessageObj.textContent = '必須項目を入力してください';
	    return false;
	  }
	  errorMessageObj.textContent = null;
	};
