<%--
  Created by IntelliJ IDEA.
  User: jchollet2017
  Date: 28/11/2018
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil Candidat</title>

    <%@include file="head.jsp"%>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light row">
    <div class="navbar-collapse col-lg-12 col-md-12 col-sm-12" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <form method="post" action="${pageContext.request.contextPath}/ListerEpreuve">
                    <input class="btn btn-outline-primary" type="submit" value="Epreuves" name="typeListeAAfficher">
                </form>
            </li>
            <li class="nav-item active">
                <form method="post" action="${pageContext.request.contextPath}/ListerEpreuve">
                    <input class="btn btn-outline-secondary" type="submit" value="Resultats" name="typeListeAAfficher">
                </form>
            </li>
            <li class="nav-item active">
                <form method="post" action="${pageContext.request.contextPath}/deconnexion">
                    <input class="btn btn-outline-danger" type="submit" value="Deconnexion">
                </form>
            </li>
        </ul>
        <span class="form-inline my-2 my-lg-0">
            <p class="form-control " disabled type="text" name="sessionEnCours"><%= session.getAttribute("prenom")%> <%= session.getAttribute("nom")%></p>
        </span>
    </div>
</nav>

</body>
</html>
