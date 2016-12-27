
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body background="${pageContext.request.contextPath}/images/Lords.jpg"
	style="text-align: center; background-size: cover">

	<p style="font-size:20px; font-weight:bolder">IPL 2016 Team List</p>

	<c:forEach var="team" items="${teamInfo}">
		<a href="<c:url value="teamDetails"/>?teamName=${team.name}"><img
			src="${team.logo}" height="275px" width="275px" /></a>
	</c:forEach>

</body>