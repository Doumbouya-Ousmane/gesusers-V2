<%@ page language="java" pageEncoding="UTF8"%>
<!DOCTYPE html>
<html></html>
<head>
<meta charset="UTF8">
<title>Ajout utilisateur</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body></body>
	<%@include file="assets/header.jsp"%>
	<div class="container2">
	    <h2>Ajout d'un utilisateur</h2>
	    <form method="post" class="form2">
	    	<div class="formItem" style="text-align:center;">
	    		<label for="prenom">Prénom :</label><br> 
	        	<input type="text" name="prenom" id="prenom" value ="${utilisateurs.prenom}">
	        	<span class="invalide" style="color:red">${ erreurs.prenom }</span>
	    	</div>
	    	<div class="formItem" style="text-align:center;">
	    		<label for="nom">Nom :</label><br>
	        	<input type="text" name="nom" id="nom" value ="${ utilisateurs.nom}">
	        	<span class="invalide" style="color:red">${ erreurs.nom }</span>
	    	</div>
	    	<div class="formItem" style="text-align:center;">
	    		<label for="login">Login :</label><br>
	        	<input type="text" name="login" id="login" value ="${ utilisateurs.login}">
	        	<span class="invalide" style="color:red">${ erreurs.login }</span>
	    	</div>
	    	<div class="formItem" style="text-align:center;">
	    		<label for="password">Mot de passe :</label><br>
	        	<input type="password" name="password" id="password">
	        	<span class="invalide" style="color:red; text-align:center;">${ erreurs.password }</span>
	    	</div>
	    	<div class="formItem" style="text-align:center;">
	    		<label for="passwordBis">Confirmation mot de passe :</label>
	        	<input type="password" name="passwordBis" id="passwordBis">
	        	<span class="invalide" style="color:red">${ erreurs.passwordBis }</span>
	    	</div>      
	        <div class="submit">
	        	<input type="submit" value="Ajouter">
	        </div>
	    </form>
	</div>

<%@include file="assets/footer.jsp"%>


	