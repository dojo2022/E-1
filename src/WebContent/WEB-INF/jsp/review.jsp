<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿情報入力</title>
<link rel="stylesheet" type="text/css" href="/dokogacha/css/review.css">
</head>
<body>
	<h1>投稿情報の入力</h1>
	<h4 class="gacha_name">ガチャ名※全項目必須</h4>
	<form method="POST" action="/dokogacha/ReviewServlet" id="review_form">
		<span id="error_message">${error_message}</span>
		<table class="info">
			<tr>
				<td><input type="text" name="product_name" placeholder="商品名"
					required></td>
			</tr>
			<tr>
				<td><input type="text" name="title" placeholder="タイトル" required></td>
			</tr>
			<tr>
				<td><select name="genre" required>
						<option value="">----ジャンルを選択する----</option>
						<option value="1">車</option>
						<option value="2">船</option>
						<option value="3">飛行機</option>
						<option value="4">電車</option>
						<option value="5">その他乗り物</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="text" name="series" placeholder="シリーズ"
					required></td>
			</tr>
		</table>

		<h4 class="gacha_detail">ガチャ詳細</h4>
		<table class="detail">
			<tr>
				<td><textarea name="thought" id="thought"
						placeholder="レビュー内容（種類、大きさ、クオリティなど）" maxlength="255"></textarea></td>
			</tr>
			<tr>
				<td><input type="text" name="price" placeholder="金額"></td>
			</tr>
			<tr>
				<td><input type="text" name="address" placeholder="目撃位置情報"></td>
			</tr>
			<tr>
				<td><strong>五段階評価</strong>
					<div class="stars">
						<input id="star5" type="radio" name="star" value="5" /> <label
							for="star5">★</label> <input id="star4" type="radio" name="star"
							value="4" /> <label for="star4">★</label> <input id="star3"
							type="radio" name="star" value="3" /> <label for="star3">★</label>
						<input id="star2" type="radio" name="star" value="2" /> <label
							for="star2">★</label> <input id="star1" type="radio" name="star"
							value="1" /> <label for="star1">★</label>
					</div></td>
			</tr>
			<tr>
				<td><p>
						<strong>画像の挿入</strong><br>
					</p> <input type="file" name="insert_image" accept='image/*'
					multiple="multiple" onchange="loadImage(this);b">
					<p id="insert_image"></p></td>
			</tr>
			<tr>
				<td><input type="submit" id="review" name="submit" value="投稿"></td>
			</tr>
		</table>
	</form>
	<span id="error_message"></span>
	<script type="text/javascript" src="/dokogacha/js/review.js"></script>
</body>
</html>