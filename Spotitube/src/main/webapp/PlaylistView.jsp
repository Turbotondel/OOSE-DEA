<%@ page import ="oose.dea.presentation.model.AbonnementModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Abonnementen</title>
</head>
<body>

<link rel="stylesheet" type="text/css" href="css/CSS.css?1.1">
<form action="/HomeView.jsp" method="get">
    <input type="submit" value="Terug" />
</form>
<h1><span class="blue">Abonnementen</span> <span class="yellow">Table</span></h1>
<table class="container">
    <tr>
        <thead>
        <th>Abonneenaam</th>
        <th>Dienstnaam</th>
        <th colspan="2">Deler</th>
        <th>Startdatum</th>
        <th>Verdubbeld</th>
        <th>Soort</th>
        <th>Status</th>
        <th>Maandprijs</th>
        <th>Opzeggen</th>
        <th>Upgraden</th>
        <th>Delen</th>
        </thead>
        <tbody>
        </tr>
    <c:forEach items="${AbonnementModel.abonnementList}" var="abonnement">
    <tr>
        <td><c:out value="${abonnement.abonneeHouder.abonneenaam}"/></td>
        <td><c:out value="${abonnement.dienst.getNaam()}"/></td>
        <td><c:out value="${abonnement.abonneeDelen1.abonneenaam}"/></td>
        <td><c:out value="${abonnement.abonneeDelen2.abonneenaam}"/></td>
        <td><c:out value="${abonnement.startDatum}"/></td>
        <td><c:out value="${abonnement.verdubbeld}"/></td>
        <td><c:out value="${abonnement.abonnementSoort}"/></td>
        <td><c:out value="${abonnement.abonnementStatus}"/></td>
        <td><c:out value="${abonnement.berekenMaandPrijs()}"/></td>
        <td>
        <c:choose>
            <c:when test="${abonnement.abonnementStatus != 'OPGEZEGD'}">
                 <form action ="/Dienstopzeggen" method="post">
                    <input type="hidden" name="dienstnaam" value="${abonnement.dienst.getNaam()}">
                    <input type="hidden" name="abonneenaam" value="${abonnement.abonneeHouder.abonneenaam}">
                    <input type="submit" value="Opzeggen">
                </form>
            </c:when>
        </c:choose>
        </td>
        <td>
        <c:choose>
            <c:when test="${abonnement.abonnementStatus != 'OPGEZEGD' && abonnement.dienst.isVerdubbelbaar() == true && abonnement.verdubbeld == false}">
                <form action ="/Dienstupgraden" method="post">
                    <input type="hidden" name="dienstnaam" value="${abonnement.dienst.getNaam()}">
                    <input type="hidden" name="abonneenaam" value="${abonnement.abonneeHouder.abonneenaam}">
                    <input type="submit" value="Upgraden">
                </form>
            </c:when>
        </c:choose>
        </td>
        <td>
        <c:choose>
            <c:when test="${abonnement.abonnementStatus != 'OPGEZEGD' && abonnement.dienst.isDeelbaar() && (abonnement.abonneeDelen1.getAbonneenaam() == null || abonnement.abonneeDelen2.getAbonneenaam() == null)}">
                 <form action ="/Startdienstdelen" method="get">
                    <input type="hidden" name="dienstnaam" value="${abonnement.dienst.getNaam()}">
                    <input type="hidden" name="abonneenaam" value="${abonnement.abonneeHouder.abonneenaam}">
                    <input type="submit" value="Delen">
                </form>
            </c:when>
        </c:choose>
        </td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
<form action ="/Zoekdienst" method="get">
    </br><input type="submit" value="Dienst Uitproberen">
</form>
</body>
</html>




