<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty user.userId }">
			<h1>ȸ������</h1>
	<c:set var="action" value="create"/>
	<c:set var="sum" value="���"/>

		</c:when>
		<c:otherwise>
	<c:set var="action" value="update"/>
	<c:set var="sum" value="����"/>
			<h1>ȸ������</h1>
		</c:otherwise>
	</c:choose>
	
	<form action="${action}" method="post">
		<c:choose>
			<c:when test="${empty user.userId}">
		ID <input type="text" name="userId" value="${user.userId}">
				<br>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="userId" value="${user.userId}" />
		ID ${user.userId}<br>
			</c:otherwise>
		</c:choose>
		PW<input type="password" name="userPw"><br> name <input
			type="text" name="userName" value="${user.userName}"><br>
		Email <input type="text" name="userEmail" value="${user.userEmail}"><br>
		<input type="submit" value="${sum}">
		
	</form>
</body>
</html>