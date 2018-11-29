
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>--->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="fr">
<head>
  <title>QUESTIONNAIRE</title>
  <meta charset="ISO-8859-1">
   <%@include file="head.jsp"%>
</head>
<body>
<div class="container-fluid">	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <form method="post" action="${pageContext.request.contextPath}/candidat">
                    <input class="btn btn-outline-info" type="submit" value="Accueil">
                </form>
            </li>
            <li class="nav-item active">
                <form method="post" action="${pageContext.request.contextPath}/deconnexion">
                    <input class="btn btn-outline-danger" type="submit" value="Deconnexion">
                </form>
            </li>
        </ul>
        <span class="form-inline my-2 my-lg-0">
            <p class="form-control mr-sm-2" disabled type="text" name="sessionEnCours"><%=session.getAttribute("prenom")%> <%=session.getAttribute("nom")%></p>
        </span>
    </div>
</nav>

	<br>

	<h1>Vos épreuves</h1>
	<p>voici la liste des test auxquels vous êtes inscrits.</p>
	<p>Sélectionnez le test à passer et confirmez son lancement.</p><br>
	 
	<form action="/GestionQuestionsServlet" method="get">
		<div id="accordion">
		<c:forEach var="epreuve" items="${tableauEpreuves}">
			
			  <div class="card">
			    <div class="card-header" id="headingOne">
			      <h5 class="mb-0">
			        <div onclick="recupTestId(this.id)" name="idEpreuve" value="${epreuve.test.idTest}" id="${epreuve.test.idTest}" class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
			         	 ${epreuve.test.nom}
			        </div>
			      </h5>
			    </div>
			
			    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
			      <div class="card-body">
			      	<p>inscription valide du ${epreuve.debutValidite} au ${epreuve.finValidite}</p> 
			      	<p>nombre de questions : ${epreuve.test.totalQuestionPosees} </p>
	         	  	<p>durée du test :  ${epreuve.test.duree}</p> 
			      </div>
			    </div>
			  </div>
 
		</c:forEach>
		<input hidden id="recup" value="" name="idEpreuve" type="text">
		<input type="submit">
	</form>



	<script>
	
	function recupTestId(id){
		$('#recup').attr("value",id)
	}
	
		
		var acc = document.getElementsByClassName("accordion");
		var i;
		
		for (i = 0; i < acc.length; i++) {
		    acc[i].addEventListener("click", function() {
		        this.classList.toggle("active");
		        var panel = this.nextElementSibling;
		        if (panel.style.display === "block") {
		            panel.style.display = "none";
		        } else {
		            panel.style.display = "block";
		        }
		    });
		}
	</script>
	 </div>
</body>
</html>