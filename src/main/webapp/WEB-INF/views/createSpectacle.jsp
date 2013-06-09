<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Nouveau spectacle</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/style.css"/>"/>
</head>
<body>
<form:form commandName="spectacle" action="create" method="post">

    <form:label path="artiste" cssErrorClass="error">Artiste</form:label>
    <form:input path="artiste" cssErrorClass="error"/>
    <form:errors path="artiste" cssClass="error"/>
    
    <br/>

<form:label path="titre">Titre</form:label><form:input path="titre" /><form:errors path="titre"/><br/>
<form:label path="type">Type</form:label>
<form:select path="type" >
    <form:option value=""></form:option>
    <form:options items="${typesDeSpectacle}"/>
</form:select>
<form:errors path="type"/><br/>

<button type="submit">Créer</button>
</form:form>
</body>
</html>