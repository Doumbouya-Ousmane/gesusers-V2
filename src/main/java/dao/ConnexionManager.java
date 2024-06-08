package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Utilisateurs;

public class ConnexionManager {
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/gesusers", "root", "");
			return connexion;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		
		}
		
		
		
	}

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/gesusers", "root", "");
			System.out.println("Connexion effectué avec succès à la base de données");
			Statement statement = connexion.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM users");
			ArrayList<Utilisateurs> utilisateurs = new ArrayList<Utilisateurs>();
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
			
			System.out.println("La liste des utilisateurs");
			for(Utilisateurs utilisateur:utilisateurs) {
				
				System.out.printf("ID      : %d\n", utilisateur.getId());
				System.out.printf("PRENOM  : \n", utilisateur.getPrenom());
				System.out.printf("NOM     : %s", utilisateur.getNom());
				System.out.printf("LOGIN   : %s", utilisateur.getLogin());
				System.out.printf("PASSWORD: %s", utilisateur.getPassword());
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

		
		

	}

}
