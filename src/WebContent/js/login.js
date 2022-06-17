function submit_login(){
	var formObj = document.getElementById('form_login');
	var errorMessageObj = document.getElementById('error_message');
	if(!formObj.id.value || !formObj.pw.value){
		errorMessageObj.textContent = 'ユーザ名とパスワードを両方入力してください。';
		event.preventDefault();
		return false;
	}
	else if(formObj.id.value != "" && formObj.id.value != ""){
		errorMessageObj.textContent=null;
	}
	errorMessageObj.textContent=null;
};