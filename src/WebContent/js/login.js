var formObj = document.getElementById('form_login');
var errorMessageObj = document.getElementById('error_message');

function submit_login(){
	console.log('function動作完了！');
	if(!formObj.id.value || !formObj.pw.value){
	errorMessageObj.textContent = 'ユーザ名とパスワードを両方入力してください。';
	return false;
	}
};