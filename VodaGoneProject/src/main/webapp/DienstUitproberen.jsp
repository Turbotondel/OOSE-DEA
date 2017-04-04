<%@ page import ="oose.dea.presentation.model.DienstModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/CSS.css?1.1">
    <title>Dienst Uitproberen</title>
</head>
<body>

<link rel="stylesheet" href="/css/CSS.css">


<form action ="/Zoekdienst" method="get">
    Zoek <input type="text" name="dienstopzoeken">
    <input type="submit" value="Zoek">
</form>

<table class="container">
    <tr>
        <th>Bedrijf</th>
        <th>Dienstnaam</th>
        <th>Beschrijving</th>
        <th>Maandprijs</th>
        <th>Halfjaarprijs</th>
        <th>Jaarprijs</th>
        <th>Deelbaar</th>
        <th>Verdubbelbaar</th>
    </tr>
    <c:forEach items="${DienstModel.dienstList}" var="dienst">
        <tr>
            <td><c:out value="${dienst.bedrijf}"/></td>
            <td><c:out value="${dienst.getNaam()}"/></td>
            <td><c:out value="${dienst.beschrijving}"/></td>
            <td><c:out value="${dienst.maandPrijs}"/></td>
            <td><c:out value="${dienst.halfJaarPrijs}"/></td>
            <td><c:out value="${dienst.jaarPrijs}"/></td>
            <td><c:out value="${dienst.verdubbelbaar}"/></td>
            <td><c:out value="${dienst.deelbaar}"/></td>
            <td> <form action ="/Dienstuitproberen" method="post">
                <input type="hidden" name="dienstnaam" value="${dienst.getNaam()}">
                <input type="submit" value="Dienst Proberen">
            </form></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
