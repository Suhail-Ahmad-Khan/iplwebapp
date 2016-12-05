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
<body>
	<center>
		<h4>Player List</h4>
		<table>
			<c:forEach var="player" items="${playerInfo}">
				<tr>
					<td><a href='<c:url value="playerDetails"/>?id=${player.id}'>${player.name}</a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>