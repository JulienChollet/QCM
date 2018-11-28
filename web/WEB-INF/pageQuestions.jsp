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

<!-- EN TETE -->
		<label style="text-align: left;">Epreuve : Le language SQL avec SQLServeur </label>
		<label style="float: right;">Candidat :</label> <!-- #TODO le nom qui s'affiche sur toutes les pages -->
<!-- QUESTIONISATION / AFFICHE ALEATOIREMENT _ Servlet Question -->	
	
	<div>
		<h1>Question</h1>
		
		<% ArrayList<Question> questions = (ArrayList<Question>)request.getAttribute("questions");
		if(!questions.isEmpty()){ 
			Random randomGenerator = new Random();
			int indexAleatoire = randomGenerator.nextInt(questions.size());		
			
				for(Question q : questions){
					if(indexAleatoire==q.getIdQuestion()){
						%><p><%=questions.get(indexAleatoire).getEnonce()%></p><%
					}
				}%> 
		<!-- <img alt="fig" src="<--%=q.getImage()%>" width="500" height="50"> -->
		<%}else{%>
		<p> Erreur : pas de questions en mémoire </p>
		<%}%>
	</div>
	
<!-- REPONSISATION / MEMORISATION EN BDD _ Servlet Reponse
	<div>
		<form action="${pageContext.request.contextPath}/GestionReponseServlet" method="post">
				
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