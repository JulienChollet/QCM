<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="fr">
<head>
  <title>Vos résultats</title>
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

	<h1>Vos résultats</h1>
	<p>voici le récapitulatif des résultats que vous avez obtenus aux épreuves.</p>
	<br>
	 
	<form action="/ServletListeResulats" method="get">
	
		<c:forEach var="epreuve" items="${tableauEpreuves}">
			<div id="accordion">
			
			
			  <div class="card">
			    <div class="card-header" id="headingOne">
			      <h5 class="mb-0">
			        <button name="idEpreuve" value="" class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
			         	 ${epreuve.test.nom}
			         	
			         	 
			        </button>
			      </h5>
			    </div>
			
			    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
			      <div class="card-body">
			      		  <p>note obtenue : ${epreuve.note} </p>
			         	 <p>niveau d'acquisition :  ${epreuve.niveauAcquisition}</p> 
	      		          
			      </div>
			    </div>
			  </div>
 
		</c:forEach>
		<input type="submit">
	</form>



	<script>
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