<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <form method="POST" action="/dokogacha/ReviewServlet">
  <table class="info">
   <tr><td><input type="text" name="product_name" placeholder="商品名" required></td></tr>
   <tr><td><input type="text" name="title" placeholder="タイトル" required></td></tr>
   <tr><td><select name="genre" required>
          <option value="">----ジャンルを選択する----</option>
          <option value="1" >1</option>
          <option value="2" >2</option>
          <option value="3" >3</option>
          <option value="4" >4</option>
          <option value="5" >5</option>
          </select></td></tr>
   <tr><td><input type="text" name="series" placeholder="シリーズ" required></td></tr>
  </table>

  <h4 class="gacha_detail">ガチャ詳細</h4>
  <table class="detail">
   <tr><td><textarea name="thought" rows="10"id="thought" placeholder="レビュー内容（種類、大きさ、クオリティなど）" maxlength="255"></textarea></td></tr>
   <tr><td><input type="text" name="price" placeholder="金額"></td></tr>
   <tr><td><input type="text" name="address" placeholder="目撃位置情報"></td></tr>
   <tr><td><label><strong>五段階評価</strong></label>
   <div>
    <span class="star_rating">
      <input type="radio" name="evalution" value="1"><i></i>
      <input type="radio" name="evalution" value="2"><i></i>
      <input type="radio" name="evalution" value="3"><i></i>
      <input type="radio" name="evalution" value="4"><i></i>
      <input type="radio" name="evalution" value="5"><i></i>
    </span>
   </div></td></tr>
   <tr><td><input type="file" name="insert_image" accept="image/jpeg, image/png"></td></tr>
   <tr><td><input type="submit" id="review" name="submit" value="投稿"></td></tr>
  </table>
 </form>
</body>
</html>