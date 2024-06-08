package servlets;

import java.io.IOException;

import beans.Utilisateurs;
import dao.UtilisateursDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddUser extends HttpServlet{
	
	public static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/ajouterUtilisateur.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Utilisateurs utilisateur = new Utilisateurs(1, prenom, nom, login, password);
		
		UtilisateursDao.Ajouter(utilisateur);
		response.sendRedirect("list");
		
		
	}
}
