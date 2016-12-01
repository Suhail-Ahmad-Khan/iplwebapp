<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link rel="stylesheet" href="./css/world.css" type="text/css" />
<title><spring:message code="team.details" /></title>
</head>
<body>
	<h1>
		<spring:message code="application.name" />
	</h1>

	<table class="silver" width="350">

		<tr>
			<th colspan=2><spring:message code="team.details" /></th>
		</tr>
		<tr>
			<td><spring:message code="team.teamName" /></td>
			<td>${team.teamName}</td>
		</tr>
		<tr>
			<td><spring:message code="team.coachName" /></td>
			<td>${team.coachName}</td>
		</tr>
		<tr>
			<td><spring:message code="team.ownerName" /></td>
			<td>${team.ownerName}</td>
		</tr>
		<tr>
			<td><spring:message code="team.captainName" /></td>
			<td>${team.captainName}</td>
		</tr>
		<tr>
			<td><spring:message code="team.homeVenue" /></td>
			<td>${team.homeVenue}</td>
		</tr>
	</table>
	<div>
		<a href="playerList.html?teamId=${team.id}">Player Details</a>
	</div>


	<a href="teamList.html"> &lt;&lt;<spring:message
			code="navigation.back" />
	</a>
</body>
</html>