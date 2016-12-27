<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Player List</title>
</head>
<body background="${pageContext.request.contextPath}/images/Lords.jpg"
	style="text-align: center; background-size: cover">
	<h4>Player List</h4>
	<c:forEach var="player" items="${playerInfo}">
		<a href='<c:url value="playerDetails"/>?id=${player.id}'><img
			src="${player.image}" style="border: 3px solid red;" height="225px"
			width="225px" /></a>
	</c:forEach>
</body>
</html>