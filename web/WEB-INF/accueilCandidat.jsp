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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <form method="post" action="#">
                    <input class="btn btn-outline-primary" type="submit" value="Epreuves">
                </form>
            </li>
            <li class="nav-item active">
                <form method="post" action="#">
                    <input class="btn btn-outline-secondary" type="submit" value="Résultats">
                </form>
            </li>
            <li class="nav-item active">
                <form method="post" action="${pageContext.request.contextPath}/deconnexion">
                    <input class="btn btn-outline-danger" type="submit" value="Deconnection">
                </form>
            </li>
        </ul>
        <span class="form-inline my-2 my-lg-0">
            <p class="form-control mr-sm-2" disabled type="text" name="sessionEnCours"><%=session.getAttribute("prenom")%> <%=session.getAttribute("nom")%></p>
        </span>
    </div>
</nav>
</body>
</html>
