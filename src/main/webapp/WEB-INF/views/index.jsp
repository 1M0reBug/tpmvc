<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Spectacles</title>
</head>
<body>
<h1>Spectacles</h1>

<p>Visit count : ${visitCount}</p>

<table>
    <thead>
        <tr>
            <th>Titre</th>
            <th>Artiste</th>
            <th>Type</th>
            <th>API</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="spectacle" items="${spectacles}">
            <tr>
                <td><a href="<spring:url value='/spectacle/{id}'>
                                 <spring:param name="id" value="${spectacle.id}"/>
                             </spring:url>"><c:out value="${spectacle.titre}"/></a></td>
                <td><c:out value="${spectacle.artiste}"/></td>
                <td><c:out value="${spectacle.type}"/></td>
                <td><a href="<spring:url value='/api/spectacles/{id}'>
                                 <spring:param name="id" value="${spectacle.id}"/>
                             </spring:url>">API</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<p>
<a href="<spring:url value='/api/spectacles/'/>">API spectacles list</a><br/>
<a href="<spring:url value='/spectacle/create'/>">Nouveau spectacle</a>
</p>

</body>
</html>