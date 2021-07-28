<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>send page</title>
</head>
<body>
<h1>사진 전송 페이지</h1>
<hr />
<form action="/image" method="post" enctype="multipart/form-data">
	<input type="file" name="pic" />
	<button>사진 전송</button>
</form>
</body>
</html>