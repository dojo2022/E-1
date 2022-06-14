<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこがちゃ|| トップメニュー</title>
<link rel= "stylesheet" type="text/css" href ="/dokogacha/css/common.css">
<link rel= "stylesheet" type="text/css" href ="/dokogacha/css/top.css">
</head>
<body>
<script src="${pageContext.request.contextPath}/js/top.js"></script>
<!-- ヘッダー -->
<header class="header">
  <h1 class="logo">トップページ</h1>
  <nav class="nav">
  <ul>
    <li><a href="/dokogacha/SearchServlet">
    <img class="img_search" src="/dokogacha/img/cap_search.png" alt="検索"></a></li>
    <li><a href="/dokogacha/ReviewServlet">
    <img class="img_post" src="/dokogacha/img/cap_post.png" alt="投稿"></a></li>
    <li><a href="/dokogacha/MypageServlet">
    <img class="img_mypage" src="/dokogacha/img/cap_mypage.png" alt="マイページ"></a></li>
    <li><a href="/dokogacha/LogoutServlet">
    <img class="img_logout" src="/dokogacha/img/cap_logout.png" alt="ログアウト"></a></li>
    </ul>
    </nav>
    </header>
    <img class="button_null" src="/dokogacha/img/button_null.png">
    <!-- トレンド表示 -->
</body>

<!-- ヘッダー -->
</html>