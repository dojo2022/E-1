<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>どこがちゃ｜マイページ変更</title>
<link rel= "stylesheet" type="text/css" href ="/dokogacha/css/mypage_change.css">
<style>*{outline: 1px solid #ff0000;}</style>
<!-- -->
</head>
<body>

<div class="wapper">
<form action="/dokogacha/MypageChangeServlet" method="post" enctype="multipart/form-data" class="form">
<table class="formtable">
	<tr>
	<td rowspan="3" class="image" >
		<input type="file" name="IMAGE" accept="image/*" onchange="previewImage(this);"><br>
		<canvas id="preview"></canvas><br>
	</td>
	<td class = "table1" >ユーザネーム<br><input type="text" name="user_id" value="${user.id}"></td>
	</tr>
	<tr><td>お気に入り公開/非公開</td></tr>
	<tr><td class = "table1">
	<div > <!-- JSで取ってきたpublicからどちらかにデフォルトを付ける-->
	    <input type="radio" id="yes_ublic" name="chose_public" value="yes">
    	<label for="yes_ublic">公開</label>
    	<input type="radio" id="no_public" name="chose_public" value="no">
    	<label for="no_public">非公開</label>
    </div>
	</tr>
</table>
<input type="image" src="/dokogacha/img/button_change.png" name="button_change" alt="変更"  >
</form>
</div>
</body>
<script>
///*
window.onload = function(){
	// ページ読み込み時に実行したい処理
	var fileReader = new FileReader();
	// 読み込み後に実行する処理
	// canvas にプレビュー画像を表示
	var canvas = document.getElementById('preview');
	var ctx = canvas.getContext('2d');// getContext()メソッドに引数"2d"を渡して実行すると、
									  //2Dグラフィックを描画するためのメソッドやプロパティをもつオブジェクトを返す
	var image = new Image();
	image.src = "${'/dokogacha/img/user_image/'+= user.user_image}";
	//image.src = fileReader.result;
	//console.log(fileReader.result) // ← (確認用)

	image.onload = (function () {
		canvas.width = image.width;
		canvas.height = image.height;
		ctx.drawImage(image, 0, 0);
		});

	// 画像読み込み
	fileReader.readAsDataURL();
	//console.log(fileReader.result) // ← (確認用)null
	}
//*/
function previewImage(obj){

	var fileReader = new FileReader();

	// 読み込み後に実行する処理
	fileReader.onload = (function() {

		// canvas にプレビュー画像を表示
		var canvas = document.getElementById('preview');
		var ctx = canvas.getContext('2d');// getContext()メソッドに引数"2d"を渡して実行すると、
										  //2Dグラフィックを描画するためのメソッドやプロパティをもつオブジェクトを返す
		var image = new Image();
		image.src = fileReader.result;
		//console.log(fileReader.result) // ← (確認用)

		image.onload = (function () {
			canvas.width = image.width;
			canvas.height = image.height;
			ctx.drawImage(image, 0, 0);
		});
	});
	// 画像読み込み
	fileReader.readAsDataURL(obj.files[0]);
	//console.log(fileReader.result) // ← (確認用)null
	console.log(obj.files[0].name);
	console.log(obj.files[0]);

}
</script>
</html>