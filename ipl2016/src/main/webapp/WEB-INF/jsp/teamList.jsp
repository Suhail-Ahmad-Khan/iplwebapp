<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link rel="stylesheet" href="./css/world.css" type="text/css" />
<title><spring:message code="team.plural" /></title>
</head>
<body>
	<h1>
		<spring:message code="application.name" />
	</h1>
	<table>
		<tr>
			<td align="right" valign="bottom">
				<button onclick="window.location='teamForm.html'">Create</button>
			</td>		
		</tr>
		<tr>
			<td>
				<table class="silver" width="350">
					<tr>
						<th></th>
						<th><spring:message code="team.plural" /></th>
					</tr>
					<c:forEach items="${teams}" var="team">
						<tr>
							<td width="50"><a
								href="<c:url value='teamForm.html?id=${team.id}'/>"> <img
									src="images/edit.gif" style="border-style: none;" />
							</a></td>
							<td><a href="teamDetails.html?id=${team.id}">
									${team.teamName} </a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>