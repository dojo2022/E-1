function submit_regist(){
	var formObj = document.getElementById('form_regist');
	var errorMessageObj = document.getElementById('error_message');
	if(!formObj.id.value || !formObj.pw.value){
		errorMessageObj.textContent = 'ユーザ名とパスワードを両方入力してください。';
		event.preventDefault();
		return false;
	}else if(formObj.pw.value.length < 6 || formObj.pw.value.lenght > 16){
		errorMessageObj.textContent = 'パスワードは６～１６文字以内で入力してください。';
		event.preventDefault();
		return false;
	}else if(formObj.id.value != "" && formObj.id.value != ""){
		errorMessageObj.textContent=null;
	}
};