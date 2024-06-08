package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Utilisateurs;

public class UtilisateursDao {
	public final static ArrayList<Utilisateurs> utilisateurs = new ArrayList<Utilisateurs>();
	public static int lastId = 0;
	
	static {
		
		Utilisateurs utilisateur = new Utilisateurs("Ousmane","Doumbouya","odoumbouya","passer");
	}
	
	
	public static ArrayList<Utilisateurs> lister()
	{
		ArrayList<Utilisateurs> utilisateurs = new ArrayList<Utilisateurs>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/gesusers", "root", "");
			Statement statement = connexion.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM users");
			int id;
			String prenom, nom, login, password;
			while(resultat.next()) {
				id = resultat.getInt("id");
				prenom = resultat.getString("prenom");
				nom = resultat.getString("nom");
				login = resultat.getString("nom");
				password = resultat.getString("password");
				
				utilisateurs.add(new Utilisateurs(id, prenom, nom, login, password));
				
			}
			
			resultat.close();
			connexion.close();
			
		} catch (Exception e) {
			System.err.println("Erreur" + e.getMessage());
		}
		return utilisateurs;
			
	
	}
	
	public static boolean Ajouter(Utilisateurs utilisateur) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/gesusers", "root", "");
			String requete = "INSERT INTO users(prenom, nom, login, password) VALUES(?, ?, ?, ?)";
			PreparedStatement preparedStatement = connexion.prepareStatement(requete); 
			preparedStatement.setString(1, utilisateur.getPrenom());
			preparedStatement.setString(2, utilisateur.getNom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getPassword());
			int insertedRows = preparedStatement.executeUpdate();
			
			if (insertedRows == 1) {
				
				return true;
			}
			
		preparedStatement.close();
		connexion.close();
		
		} catch (Exception e) {
			System.err.println("Erreur" + e.getMessage());
		}
		
		return false;
		
	}
	
	public static boolean supprimer(int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/gesusers", "root", "");
			String requete = "delete from users where id = ?";
			PreparedStatement preparedStatement = connexion.prepareStatement(requete); 
			preparedStatement.setInt(1, id);
			
			int deletedRows = preparedStatement.executeUpdate();
			
			if (deletedRows == 1) {
				
				return true;
			}
			
		preparedStatement.close();
		connexion.close();
		
		} catch (Exception e) {
			System.err.println("Erreur" + e.getMessage());
		}
		
		return false;
	}
	
	public static Utilisateurs get(int id) {
		Utilisateurs utilisateur = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/gesusers", "root", "");
			PreparedStatement requete = connexion.prepareStatement("SELECT * From users where id = ?"); 
			requete.setInt(1, id);
			ResultSet resultat = requete.executeQuery();
			
			String prenom, nom, login, password;
			
			if(resultat.next()) {
				id = resultat.getInt("id");
				prenom = resultat.getString("prenom");
				nom = resultat.getString("nom");
				login = resultat.getString("login");
				password = resultat.getString("password");
				
				utilisateur = new Utilisateurs(id, prenom, nom, login, password);
				
			}
			
			resultat.close();
			connexion.close();
			
			
		} catch (Exception e) {
			System.err.println("Erreur" + e.getMessage());
		}
		return utilisateur;
	}
	
	public static Utilisateurs get(String login) {
		Utilisateurs utilisateur = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/gesusers", "root", "");
			PreparedStatement requete = connexion.prepareStatement("SELECT * From users where login = ?"); 
			requete.setString(1, login);
			ResultSet resultat = requete.executeQuery();
			
			int id;
			String prenom, nom, password;
			
			if(resultat.next()) {
				id = resultat.getInt("id");
				prenom = resultat.getString("prenom");
				nom = resultat.getString("nom");

				password = resultat.getString("password");
				
				utilisateur = new Utilisateurs(id, prenom, nom, login, password);
				
			}
			
			resultat.close();
			connexion.close();
			
			
		} catch (Exception e) {
			System.err.println("Erreur" + e.getMessage());
		}
		return utilisateur;
	}
	
	
	
	public static boolean modification(Utilisateurs utilisateur) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/gesusers", "root", "");
			String requete = "UPDATE users SET prenom = ?, nom = ?, login = ?, password = sha1(?) where id = ?";
			PreparedStatement preparedStatement = connexion.prepareStatement(requete); 
			preparedStatement.setString(1, utilisateur.getPrenom());
			preparedStatement.setString(2, utilisateur.getNom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getPassword());
			preparedStatement.setInt(5, utilisateur.getId());
			int updatedRows = preparedStatement.executeUpdate();
			
			if (updatedRows == 1) {
				
				return true;
			}
			
		} catch (Exception e) {
			System.err.println("Erreur" + e.getMessage());
		}
		
		return false;
	}
	
	

}
