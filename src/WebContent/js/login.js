var formObj = document.getElementById('form_login');
var errorMessageObj = document.getElementById('error_message');

formObj.onsubmit = function(){

	if(!formObj.id.value || !formObj.pw.value){
	errorMessageObj.textContent = 'ユーザ名とパスワードを両方入力してください。';
	return false;
	}
};