<%--
  Created by IntelliJ IDEA.
  User: jchollet2017
  Date: 27/11/2018
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div class="jumbotron text-center">
    <h1> Accueil - QCM</h1>
    <p>ENI école</p>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-9">
            <h3>Page d'accueil</h3>
            <p>Bienvenue sur le QCM !</p>
            <p>Accédez à toutes les fonctionnalités qui vous sont autorisées en vous rendant sur votre rubrique d'accès (animateur ou candidat)</p>
            <p>Pour faire une recherche sur Google, utilisez le formulaire de recherche.</p>
        </div>
        <div class="col-sm-3">
            <%@include file="menu.jsp"%>
        </div>
    </div>
    <div class="row">
        <%@include file="footer.jsp"%>
    </div>
</div>
</body>
</html>
