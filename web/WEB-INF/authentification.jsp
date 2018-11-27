<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>QUESTIONNAIRE</title>
  <meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="../resources/css/style.css">
	<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<fieldset>
		<div class="jumbotron text-center">
			<h1>Authentification</h1>
		</div>
		  
		<div class="container">
			<div class="row">
				<div class="col-sm-9">
					<form action="${pageContext.request.contextPath}/gestionAuthentification" method="POST">
					  	<div class="form-group">
					    	<label for="mail">Email :</label>
					    	<input type="email" class="form-control" id="mail" name="mail" required>
					  	</div>
					  	<div class="form-group">
					    	<label for="motdepasse">Mot de passe :</label>
					    	<input type="password" class="form-control" id="motdepasse" name="motdepasse" required>
					  	</div>
					  	<button type="submit" class="btn btn-default">Connexion</button>
					</form>
				</div>
			</div>
		</div>
	</fieldset>
</body>
</html>


