package starWars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class select {

	public static void main(String[] arg) {
		try {
			String strClassName = "com.mysql.jdbc.Driver";
			String dbName = "starwars";
			String login = "root";
			String motdepasse = "";
			String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?autoReconnect=true&useSSL=false";
			Class.forName(strClassName);

			Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
			String strQuery = "SELECT * FROM film;";
			Statement stLogin = conn.createStatement();
			ResultSet rsLogin = stLogin.executeQuery(strQuery);
			while (rsLogin.next()) {
				System.out.print(rsLogin.getInt(1) + " " + rsLogin.getString(2) + " " + rsLogin.getString(3) + " "
						+ rsLogin.getString(4) + " " + rsLogin.getString(5) + " " + rsLogin.getString(6));
			}
			rsLogin.close();

			Scanner sc = new Scanner(System.in);

			
			/*
			 * System.out.println("Vous voulez supprimez quelle film ? (id) : "); String id
			 * = sc.nextLine(); String deleteQuery = "DELETE FROM film where id = "+id+";";
			 * System.out.println(deleteQuery); stLogin.executeUpdate(deleteQuery);
			 */

			System.out.println("Vous voulez update quelle film (id) : ");
			String id = sc.nextLine();
			System.out.println("Quelle est sont nouveau Titre : ");
			String UpdateTitre = sc.nextLine();
			String updateQuery = "Update film set Titre = '" + UpdateTitre + "' where id = " + id + ";";
			stLogin.executeUpdate(updateQuery);

			conn.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Driver non chargé !");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("autre erreur !");
			e.printStackTrace();
		}
	}

}
