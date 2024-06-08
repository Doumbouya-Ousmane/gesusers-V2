<%@page import="dao.UtilisateursDao"%>
<%@page import="beans.Utilisateurs"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="UTF8"%>
<%@include file="assets/header.jsp" %>
	<div class="container">
    <section>
        <h2>Liste des Utilisateurs</h2>
        <% 
            ArrayList<Utilisateurs> users = (ArrayList<Utilisateurs>) request.getAttribute("Utilisateurs");
            if (users.isEmpty()) {
                out.print("Désolé, la liste des utilisateurs est vide");
            } else { %>
            <table class="user-table">
                <tr>
                    <th>ID</th>
                    <th>Prénom</th>
                    <th>Nom</th>
                    <th>Login</th>
                    <th>Password</th>
                    <th colspan="2">Actions</th>
                </tr>
                <% for (Utilisateurs user : users) { %>
                <tr> 
                    <td><%= user.getId() %></td>
                    <td><%= user.getPrenom() %></td>
                    <td><%= user.getNom() %></td>
                    <td><%= user.getLogin() %></td>
                    <td><%= user.getPassword() %></td>
                    <td><a href="update?id=<%= user.getId() %>" class="modifier">Modifier</a></td>
                    <td><a href="delete?id=<%= user.getId() %>" onclick="return confirm('Êtes-vous sûr de vouloir supprimer')" class="supprimer">Supprimer</a></td>
                </tr> 
                <% } %>
            </table>
        <% } %>
    </section>
</div>
</body>
</html>
<%@include file="assets/footer.jsp"%>