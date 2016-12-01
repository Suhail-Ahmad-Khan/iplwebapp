<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="./css/world.css" type="text/css" />
<title><spring:message code="player.details" /></title>
</head>
<body>
	<h1>
		<spring:message code="application.name" />
	</h1>
	<form:form modelAttribute="player" action="playerForm.html"
		method="post">
		<table>
			<tr>
				<td align="right" valign="bottom"><c:choose>
						<c:when test="${player['new']}">
							<button type="submit" name="create">Create</button>
						</c:when>
						<c:otherwise>
							<button type="submit" name="delete"
								onclick="return confirm('Are you sure you want to delete ${player.playerName}?')">
								Delete</button>
							<button type="submit" name="update">Update</button>
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td>
					<table class="silver">
						<tr>
							<th colspan=2><spring:message code="player.details" /></th>
						</tr>
						<tr>
							<td><spring:message code="player.playerName" /></td>
							<td><form:input path="playerName" size="20" maxlength="50" />
								<form:errors path="playerName" cssClass="errors" /></td>
						</tr>
						<tr>
							<td><spring:message code="player.role" /></td>
							<td><form:input path="role" size="20" maxlength="50" /> <form:errors
									path="role" cssClass="errors" /></td>
						</tr>
						<tr>
							<td><spring:message code="player.battingStyle" /></td>
							<td><form:input path="battingStyle" size="20" maxlength="50" />
								<form:errors path="playerName" cssClass="errors" /></td>
						</tr>
						<tr>
							<td><spring:message code="player.bowlingStyle" /></td>
							<td><form:input path="bowlingStyle" size="20" maxlength="50" />
								<form:errors path="bowlingStyle" cssClass="errors" /></td>
						</tr>
						<tr>
							<td><spring:message code="player.nationality" /></td>
							<td><form:input path="nationality" size="20" maxlength="50" />
								<form:errors path="nationality" cssClass="errors" /></td>
						</tr>
						<tr>
							<td><spring:message code="player.dateOfBirth" /></td>
							<td><form:input path="dateOfBirth" size="20" maxlength="50" />
								<form:errors path="dateOfBirth" cssClass="errors" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
	<a href="playerList.html"> &lt;&lt;<spring:message
			code="navigation.back" />
	</a>
</body>
</html>