<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni.qcm.beans.Question"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title> TP QCM </title>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
<!-- EN TETE -->
		<label style="text-align: left;">Epreuve : Le language SQL avec SQLServeur </label>
		<label style="float: right;"></label> <!-- #TODO le nom qui s'affiche sur toutes les pages -->
<!-- QUESTIONISATION / AFFICHE ALEATOIREMENT _ Servlet Question -->	
	
	<div>
		<h1>Question</h1>
		
		<% ArrayList<Question> questions = (ArrayList<Question>)request.getAttribute("questions");
			for(Question q : questions){
				%><p><%=q.getEnonce()%> <%=q.getIdQuestion()%>%></p><%

				}%> 
		<!-- <img alt="fig" src="<--%=q.getImage()%>" width="500" height="50"> -->

	</div>
	
<!-- REPONSISATION / MEMORISATION EN BDD _ Servlet Reponse
	<div>
		<form action="/GestionReponseServlet" method="post">
				
			<--% ArrayList<ReponseEpreuve> reponses = (ArrayList<ReponseEpreuve>)request.getAttribute("reponses");
				if(!reponses.isEmpty()){ 	
					for(Reponse rep : reponses){%>
					<input type="checkbox" name="reponseDonnee">
					<--% reponses.getReponses()%>
			<--%}}else{%>
			<p> Erreur </p>
			<--%}%>
		
		</form>
	</div>
	 
	-->  
	
	
</body>
</html>