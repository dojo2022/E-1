var formObj = document.getElementById('form_login');
var errorMessageObj = document.getElementById('error_message');
	
function submit_login(){
	if(!formObj.id.value || !formObj.pw.value){
		errorMessageObj.textContent = 'ユーザ名とパスワードを両方入力してください。';
		event.preventDefault();
		return false;
	}
	elseif(){
		
	}
	errorMessageObj.textContent=null;
};