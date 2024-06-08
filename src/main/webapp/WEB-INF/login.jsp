<%@ page language="java" pageEncoding="UTF8"%>
<!DOCTYPE html>
<html></html>
<head>
<meta charset="UTF8">
<title>Authentification</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body></body>
	<%@include file="assets/header.jsp"%>
	<div class="container">
	    <h2>Se connecter</h1>
	    <form method="post">
	  		<div class="formItem" style="text-align:center;">
				<span class="invalide" style="color:red">${ statusMessage }</span>
			</div>
	    	<div class="formItem" style="text-align:center;">
	    		<label for="login">Login :</label><br>
	        	<input type="text" name="login" id="login" value ="${ login }">
	    	</div>
	    	<div class="formItem" style="text-align:center;">
	    		<label for="password">Mot de passe :</label><br>
	        	<input type="password" name="password" id="password">
	    	</div>   
	        <div class="submit">
	        	<input type="submit" value="Connexion">
	        </div>
	    </form>
		<div class="image">
			<img src="img/image.png" alt="" class="image2">
		</div>
	</div>
<%@include file="assets/footer.jsp"%>

	