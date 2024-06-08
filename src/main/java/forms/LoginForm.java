package forms;

import java.util.HashMap;
import java.util.Map;

import beans.Utilisateurs;
import dao.UtilisateursDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginForm {

	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	
	
	private String statusMessage;
	private boolean status;
	private HttpServletRequest request;
	private String login;
	
	
	public LoginForm(HttpServletRequest request) {
		
		this.request = request;
		this.statusMessage ="Connexion impossible: login et/ou mot de passe incorrecte";
		this.status = false;
		
	}
	
	public boolean login() {
		
		this.login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		Utilisateurs loggerUser = UtilisateursDao.get(login);
		
		
		
		if( loggerUser != null && loggerUser.getPassword().equals(password)) {
			
			HttpSession session= request.getSession();
			session.setAttribute("utilisateur", loggerUser);
			
			return true;
		
		}
		else {
			return false;
		}
	}
	
	public void logout() {

		
		HttpSession session = request.getSession();

		if (session.getAttribute("utilisateur") != null) {

			session.invalidate();		
		}

	}
	
	public String getParameter(String parametre) {

		String valeur = this.request.getParameter(parametre);

		if (valeur == null || valeur.isBlank()) {
			return null;
		}

		return valeur.trim();
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public boolean getStatus() {
		return status;
	}

	public String getLogin() {
		return login;
	}
	
	
	
	
}
