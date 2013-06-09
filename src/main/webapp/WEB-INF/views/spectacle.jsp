<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Spectacle</title>
</head>
<body>
<h1>Spectacle : <c:out value="${spectacle.titre}"/></h1>

<div>
Artiste : <c:out value="${spectacle.artiste}"/>
</div>

<h2>Représentations</h2>
<ul>
    <c:forEach var="representation" items="${spectacle.representations }">
        <li><fmt:formatDate value="${representation.date}" type="date" dateStyle="full"/></li>
    </c:forEach>
</ul>
</body>
</html>