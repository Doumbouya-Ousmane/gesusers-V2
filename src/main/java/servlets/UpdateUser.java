package servlets;

import java.io.IOException;

import javax.swing.text.html.HTMLEditorKit.Parser;

import beans.Utilisateurs;
import dao.UtilisateursDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateUser extends HttpServlet{
	
	private static final String VUE_UPDATE_UTILISATEUR = "/WEB-INF/updateUtilisateur.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		
		if (id != null && id.matches("[0-9]+")) {
			
			Utilisateurs utilisateur = UtilisateursDao.get(Integer.parseInt(id));
			
			if (utilisateur != null) {
				
				request.setAttribute("utilisateur", utilisateur);
				getServletContext().getRequestDispatcher(VUE_UPDATE_UTILISATEUR).forward(request, response);
				return;
			}
			
		}
		response.sendRedirect("list");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Utilisateurs utilisateur = new Utilisateurs(Integer.parseInt(id), prenom, nom, login, password);
		
		UtilisateursDao.modification(utilisateur);
		response.sendRedirect("list");
	}

}
