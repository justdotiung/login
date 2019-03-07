<%@page import="user.db.User"%>
<%@page import="user.db.UserDb"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<% 
String error = (String)request.getAttribute("errormasage");
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Loginpage</title>
</head>
<body>
..
<%if(error != null){ %>
<%=error %>
<%} %>
<form action="login"method="post">
ID <input type="text" name="userId" size="5"><br>
Pw <input type="password" name="userPw" size="5"><br>
<input type="submit" value="로그인">
<a href="form">회원가입</a>
</form>
</body>
</html>