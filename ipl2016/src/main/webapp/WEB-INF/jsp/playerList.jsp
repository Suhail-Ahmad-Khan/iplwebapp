<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link rel="stylesheet" href="./css/world.css" type="text/css" />
<%-- <title><spring:message code="player.plural" /></title> --%>
</head>
<body>
	<h1>
		<spring:message code="application.name" />
	</h1>
	<table>
		<tr>
			<td align="right" valign="bottom">
				<button onclick="window.location='playerForm.html'">Create</button>
			</td>
		</tr>
		<tr>
			<td>
				<table class="silver" width="350">
					<tr>
						<th></th>
						<%-- <th><spring:message code="player.plural" /></th> --%>
					</tr>
					<c:forEach items="${players}" var="player">
						<tr>
							<td width="20"><a
								href="<c:url value='playerForm.html?id=${player.id}'/>"> <img
									src="images/edit.gif" style="border-style: none;" />
							</a></td>
							<td><a href="playerDetails.html?id=${player.id}">
									${player.playerName} </a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>