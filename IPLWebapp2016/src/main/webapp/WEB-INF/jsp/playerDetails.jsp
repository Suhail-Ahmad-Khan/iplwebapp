<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Player Details</title>
</head>
<body>
	<center>
		<h1>Player Details</h1>
		<table>

			<c:forEach var="player" items="${playerDetails}">
				<tr>
					<th>Id</th>
					<td>${player.id}</td>
				</tr>
				<tr>
					<th>Team Id</th>
					<td>${player.teamId}</td>
				</tr>
				<tr>
					<th>Name</th>
					<td>${player.name}</td>
				</tr>
				<tr>
					<th>Role</th>
					<td>${player.role}</td>
				</tr>
				<tr>
					<th>Batting Style</th>
					<td>${player.battingStyle}</td>
				</tr>
				<tr>
					<th>Bowling Style</th>
					<td>${player.bowlingStyle}</td>
				</tr>
				<tr>
					<th>Bowling Style</th>
					<td>${player.bowlingStyle}</td>
				</tr>
				<tr>
					<th>Nationality</th>
					<td>${player.nationality}</td>
				</tr>
				<tr>
					<th>Date Of Birth</th>
					<td>${player.DOB}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>