package forms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import beans.Utilisateurs;
import dao.UtilisateursDao;
import jakarta.servlet.http.HttpServletRequest;

public class AddUserForm {
	
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORDBIS = "passwordBis";
	
	
	private Map<String, String> erreurs;
	private String statusMessage;
	private boolean status;
	private HttpServletRequest request;
	private Utilisateurs utilisateur;
	
	
	public AddUserForm(HttpServletRequest request) {
		
		this.request = request;
		this.erreurs = new HashMap<String, String>();
	}
	
	
	public boolean ajouter() {
		
		String nom = this.getParameter(CHAMP_NOM);
		String prenom = this.getParameter(CHAMP_PRENOM);
		String login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		this.utilisateur = new Utilisateurs(prenom, nom, login, password);
		
		this.statusMessage ="Echec d'ajout";
		this.status = false;
		
		this.validerChamps(CHAMP_PRENOM, CHAMP_NOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_PASSWORDBIS);
		this.validerPassword();
		
		if (this.erreurs.isEmpty()) {
			
			if (UtilisateursDao.Ajouter(utilisateur)) {
				this.statusMessage = "Ajout effectué avec succès";
				this.status = true;
			}
		}
		
		
		return this.status;
	}
	
	public String getParameter(String parametre) {
		
		String valeur = this.request.getParameter(parametre);
		
		if (valeur == null || valeur.isBlank()) {
			return null;
		}
		
		return valeur.trim();
	}
	
	public void validerChamps(String... champs) {
		
		for (String champ:champs) {
			
			if (this.getParameter(champ) == null) {
				
				this.erreurs.put(champ, "Ce champ ne doit pas être vide");
			}
		}
	}
	
	public void validerPassword() {
		
		String password = this.getParameter(CHAMP_PASSWORD);
		String passwordBis = this.getParameter(CHAMP_PASSWORDBIS);
		
		if (password != null && !password.equals(passwordBis)) {
			this.erreurs.put(CHAMP_PASSWORD, "Les mots de passe ne sont pas conforme");
			this.erreurs.put(CHAMP_PASSWORDBIS, "Les mots de passe ne sont pas conforme");
		}
	}


	public Map<String, String> getErreurs() {
		return erreurs;
	}


	public boolean getStatus() {
		return status;
	}


	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}


	public String getStatusMessage() {
		return statusMessage;
	}
	
	
	
	
	
	
	

}
