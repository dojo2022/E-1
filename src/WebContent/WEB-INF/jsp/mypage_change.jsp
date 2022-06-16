<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>どこがちゃ｜マイページ変更</title>
<link rel= "stylesheet" type="text/css" href ="/dokogacha/css/mypage_change.css">
<!----> <style>*{outline: 1px solid #ff0000;}</style>

</head>
<body>

<div class="wapper">
<form action="/Nyample/FileUploadSampleServlet" method="post" enctype="multipart/form-data" class="form">
<table class="formtable">
	<tr>
		<td rowspan="4" class="image" >
			<input type="file" name="IMAGE" accept="image/*" onchange="previewImage(this);"><br>
			<canvas id="preview" ></canvas><br></td>
		<td>ユーザネーム<br><input type="text" name="user_id" ></td>
	</tr>
	<tr><td>お気に入り公開/非公開</td></tr>
	<tr><td>
	<div>
	    <input type="radio" id="ublic" name="chose_public" value="yes">
    	<label for="ublic">公開</label>
    	<input type="radio" id="" name="chose_public" value="no">
    	<label for="no_public">非公開</label>
    </div>
	</tr>
	<tr><td>　</td></tr>
</table>
<input type="submit" value="送信">
</form>
</div>
</body>
<script>
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
			console.log(fileReader.result) // ← (確認用)

			image.onload = (function () {
				canvas.width = image.width;
				canvas.height = image.height;
				ctx.drawImage(image, 0, 0);
			});
		});
		// 画像読み込み
		fileReader.readAsDataURL(obj.files[0]);
		console.log(fileReader.result) // ← (確認用)null
	}
</script>
</html>