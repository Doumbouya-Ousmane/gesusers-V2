<%@page import="beans.Utilisateurs"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification Utilisateur</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body></body>
	<%@include file="assets/header.jsp"%>
	<%
	Utilisateurs utilisateur = (Utilisateurs) request.getAttribute("utilisateur");
	%>

	<div class="container3">
		<h2>Modification d'un utilisateur</h2>
		<form method="post" class="form2">
			<label for="prenom">Prénom :</label> <input type="text" name="prenom"
				id="prenom" value="<%=utilisateur.getPrenom()%>"> <label
				for="nom">Nom :</label> <input type="text" name="nom" id="nom"
				value="<%=utilisateur.getNom()%>"> <label for="login">Login
				:</label><br> <input type="text" name="login" id="login"
				value="<%=utilisateur.getLogin()%>"> <label for="password">Mot
				de passe :</label><br> <input type="password" name="password"
				id="password" value="<%=utilisateur.getPassword()%>"> 
				<div class="submit">
					<input type="submit" value="Modifier">
				</div>
				
		</form>
	</div>
<%@include file="assets/footer.jsp"%>
