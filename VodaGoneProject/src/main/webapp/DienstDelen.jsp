<%@ page import ="oose.dea.presentation.model.AbonnementModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nymtesx
  Date: 20-10-2016
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/CSS.css?1.1">
    <title>Dienst Delen</title>
</head>
<body>

<h1>Dienst Delen</h1>

<form action ="/Dienstdelen" method="post">
    Abonnee naam: <input type="text" name="delenabonneenaam">
    <input type="hidden" name="dienstnaam" value="<%= request.getAttribute("dienstnaam")%>">
    <input type="hidden" name="abonneenaam" value="<%= request.getAttribute("abonneenaam")%>">
    <input type="submit" value="Delen">
</form>

</form>
</body>
</html>
