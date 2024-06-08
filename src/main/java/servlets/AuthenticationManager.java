package servlets;

import java.io.IOException;

import forms.LoginForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet({"/login","/add/","/logout"})
public class AuthenticationManager extends HttpServlet {

	private static final String VUE_CONNEXION = "/WEB-INF/login.jsp";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		switch (request.getServletPath()) {
		case "/login": {
			
			getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
		}
		default:
			LoginForm form = new LoginForm(request);
			form.logout();
			response.sendRedirect("login");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginForm form = new LoginForm(request);
		if(form.login()) {
			response.sendRedirect("list");
		}
		else {
			request.setAttribute("status", form.getStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
		}
	}
}
