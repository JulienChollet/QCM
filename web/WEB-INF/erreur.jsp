<%--
  Created by IntelliJ IDEA.
  User: jchollet2017
  Date: 29/11/2018
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>erreur</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div class="jumbotron text-center">
    <h1>Veuillez vérifier votre email ou  mot de passe </h1>

   <a href="${pageContext.request.contextPath}/authentification">Cliquer sur ce lien pour vous reconnecter</a>
</div>
</body>
</html>
