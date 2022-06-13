<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<link rel= "stylesheet" type="text/css" href ="/dokogacha/css/common.css">
<link rel= "stylesheet" type="text/css" href ="/dokogacha/css/mypage.css">
<!--  -->
<style>*{outline: 1px solid #ff0000;}</style>
</head>
<body>
<!-- ナビゲーションバー -->

<!-- メイン -->
<!-- ユーザアイコン、ユーザ名、お気に入り投稿リンクの表示 -->
<a href="/dokogacha/LogoutServlet"><img src="/dokogacha/img/cap_logout.png" alt="ログアウト" width=100px class="capsule_logout" ></a>
<div class ="user_inf1">
	<div class ="user_image	">
		<img src="/dokogacha/img/icon_panda.png" alt="ユーザアイコン" width=100px >
	</div>
	<div class ="user_name_title">
		<span class ="user_name">ユーザ―ネーム</span>
		 <img src="/dokogacha/img/shiro_panda.png" alt="称号" width=100px class="title"><br>
		 <a href="/dokogacha/FavoriteReviewListServlet" class="favorite_review_list">お気に入り投稿一覧</a>
	</div>
</div>

<!-- 累計いいね数とお気に入りジャンルの表示 -->
<div class="user_inf2">
	<div class="total_good">累積いいね数 <!--ページスコープで持ってくる？--></div>
	<div class="Favorite_Genre">お気に入りジャンル<br></div><!-- 繰り返しN文字異常なら折り返し -->
</div>

<!-- 編集ボタンと自分の最新投稿、自分の投稿一覧リンクの表示 -->
<div class="user_inf3">
	<div class="do_change"><a href="/dokogacha/MypageChangeServlet">
			<img src="/dokogacha/img/button_edit.png" alt="編集" width=100px class="botton_edit" ></a></div>
	<div class="my_new_review">＃ジャンル<br>金額　商品名　<br>♡いいね数　<br>
	<a href="/dokogacha/MyReviewListServlet">自分の投稿一覧へ</a>
	</div>
</div>


<!-- フッター -->

</body>
</html>