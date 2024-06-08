package servlets;

import java.io.IOException;
import java.util.ArrayList;

import beans.Utilisateurs;
import dao.UtilisateursDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/list",""})
public class ListerUsers extends HttpServlet{
	
	public static final String VUE_LISTER_UTILISATEURS = "/WEB-INF/listerUtilisateurs.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(VUE_LISTER_UTILISATEURS);
		ArrayList<Utilisateurs> listerUtilisateurs = UtilisateursDao.lister();
		request.setAttribute("Utilisateurs", listerUtilisateurs);
		dispatcher.forward(request, response);
	}


}
