<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="./css/world.css" type="text/css" />
<title><spring:message code="team.details" /></title>
</head>
<body>
	<h1>
		<spring:message code="application.name" />
	</h1>
	<form:form modelAttribute="team" action="teamForm.html" method="post">
		<table>
			<tr>
				<td align="right" valign="bottom"><c:choose>
						<c:when test="${team['new']}">
							<button type="submit" name="create">Create</button>
						</c:when>
						<c:otherwise>
							<button type="submit" name="delete"
								onclick="return confirm('Are you sure you want to delete ${team.teamName}?')">
								Delete</button>
							<button type="submit" name="update">Update</button>
						</c:otherwise>

					</c:choose></td>
			</tr>
			<tr>
				<td>
					<table class="silver" width=400">
						<tr>
							<th colspan=2><spring:message code="team.details" /></th>
						</tr>
						<tr>
							<td><spring:message code="team.teamName" /></td>
							<td><form:input path="teamName" size="30" maxlength="50" />
								<form:errors path="teamName" cssClass="errors" /></td>
						</tr>
						<tr>
							<td><spring:message code="team.coachName" /></td>
							<td><form:input path="coachName" size="30" maxlength="50" />
								<form:errors path="coachName" cssClass="errors" /></td>
						</tr>
						<tr>
							<td><spring:message code="team.ownerName" /></td>
							<td><form:input path="ownerName" size="30" maxlength="50" />
								<form:errors path="ownerName" cssClass="errors" /></td>
						</tr>
						<tr>
							<td><spring:message code="team.captainName" /></td>
							<td><form:input path="captainName" size="30" maxlength="50" />
								<form:errors path="captainName" cssClass="errors" /></td>
						</tr>
						<tr>
							<td><spring:message code="team.homeVenue" /></td>
							<td><form:input path="homeVenue" size="30" maxlength="50" />
								<form:errors path="homeVenue" cssClass="errors" /></td>
						</tr>
					</table>
			</td>
			</tr>
		</table>
	</form:form>
	<a href="teamList.html"> &lt;&lt;<spring:message
			code="navigation.back" />
	</a>
</body>
</html>