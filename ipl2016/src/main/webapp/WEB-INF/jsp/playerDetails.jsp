<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link rel="stylesheet" href="./css/world.css" type="text/css" />
<%-- <title><spring:message code="player.details" /></title> --%>
</head>
<body>
	<h1>
		<spring:message code="application.name" />
	</h1>
	<table class="silver" width="260">
		<tr>
			<th colspan=2><spring:message code="player.details" /></th>
		</tr>
		<tr>
			<td><spring:message code="player.playerName" /></td>
			<td>${player.playerName}</td>
		</tr>
		<tr>
			<td><spring:message code="player.role" /></td>
			<td>${player.role}</td>
		</tr>
		<tr>
			<td><spring:message code="player.battingStyle" /></td>
			<td>${player.battingStyle}</td>
		</tr>
		<tr>
			<td><spring:message code="player.bowlingStyle" /></td>
			<td>${player.bowlingStyle}</td>
		</tr>
		<tr>
			<td><spring:message code="player.nationality" /></td>
			<td>${player.nationality}</td>
		</tr>
		<tr>
			<td><spring:message code="player.dateOfBirth" /></td>
			<td><fmt:formatDate value="${player.dateOfBirth}" /></td>
		</tr>
	</table>
	<a href="playerList.html"> &lt;&lt;<spring:message
			code="navigation.back" />
	</a>
</body>
</html>