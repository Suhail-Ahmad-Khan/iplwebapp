<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team Details</title>
</head>
<body>
	<center>
		<h1>Team Details</h1>
		<table>

			<c:forEach var="team" items="${teamDetails}">
				<tr>
					<th>Id</th>
					<td>${team.id}</td>
				</tr>
				<tr>
					<th>Name</th>
					<td>${team.name}</td>
				</tr>
				<tr>
					<th>Coach</th>
					<td>${team.coachName}</td>
				</tr>
				<tr>
					<th>Owner</th>
					<td>${team.ownerName}</td>
				</tr>
				<tr>
					<th>Captain</th>
					<td>${team.captainName}</td>
				</tr>
				<tr>
					<th>Captain</th>
					<td>${team.homeVenue}</td>
				</tr>
				<tr>
					<td><a href="<c:url value="playerList"/>?teamId=${team.id}">ViewPlayers</a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>