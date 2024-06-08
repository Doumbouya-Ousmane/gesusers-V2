package servlets;

import java.io.IOException;

import dao.UtilisateursDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		
		if(id != null && id.matches("[0-9]+")){
			
			UtilisateursDao.supprimer(Integer.parseInt(id));
		}
		
		response.sendRedirect("list");
	}
}
