<%--
  Created by IntelliJ IDEA.
  User: jchollet2017
  Date: 14/11/2018
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>Menu</h3>
<a href="./login/accesAnimateurPage">Accès administrateur</a><br />
<a href="${pageContext.request.contextPath}/authentification">Accès candidat</a><br />
<br /><br />
<form method="get" action="http://www.google.fr/search" target="window">
    <div class="form-group">
        <input type="hidden" name="hl" value="fr" />
        <input class="form-control" type="text" name="q" />
    </div>
    <button type="submit" class="btn btn-default">
        <span class="glyphicon glyphicon-search"></span> Rechercher
    </button>
</form>