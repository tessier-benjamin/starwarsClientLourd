package starWars;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.table.TableModel;

public class DAOFilm {

	private String bddName = "starwars";
	private String bddLogin = "root";
	private String bddPassword = "";
	private String bddIP = "localhost";
	private String bddPort = "3306";
	String strClassName = "com.mysql.jdbc.Driver";
	Connection conn;
	Statement stLogin;
	private String bddUrl = "jdbc:mysql://" + this.bddIP + ":" + this.bddPort + "/" + this.bddName;

	public DAOFilm(String bddName, String Login, String Password, String Host, String Port) {
		try {

			this.bddName = bddName;
			this.bddLogin = Login;
			this.bddPassword = Password;
			this.bddIP = Host;
			this.bddPort = Port;
			this.conn = DriverManager.getConnection(
					"jdbc:mysql://" + Host + ":" + Port + "/" + bddName + "?autoReconnect=true&useSSL=false", Login,
					Password);
			Class.forName(this.strClassName);
			this.stLogin = conn.createStatement();
		} catch (ClassNotFoundException e) {

			System.err.println("Driver non chargé !");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public DAOFilm() {
		try {
			Class.forName(this.strClassName);
			this.conn = DriverManager.getConnection(this.bddUrl, this.bddLogin, this.bddPassword);
			this.stLogin = (Statement) conn.createStatement();
			System.out.println("=> DAOFilm ready");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver non chargé !");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Autre erreur !");
			e.printStackTrace();
		}
	}

	public void Close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Lister() {
		try {
			String strQuery = "SELECT * FROM Film;";
			ResultSet rsUsers = this.stLogin.executeQuery(strQuery);
			while (rsUsers.next()) {
				System.out.println("Id : " + rsUsers.getInt(1) + " Titre : " + rsUsers.getString(2)
						+ " Date de sortie : " + rsUsers.getInt(3) + " Numéro : " + rsUsers.getString(4) + " coût : "
						+ rsUsers.getInt(5) + " recette : " + rsUsers.getInt(6));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void AjouterFilm(int id, String Titre, int sortie, String numero, int cout, int recette) {
		try {
			String query = " insert into film (id,Titre,sortie,numero,cout,recette)" + " values (?,?,?,?,?,?);";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.setString(2, Titre);
			preparedStmt.setInt(3, sortie);
			preparedStmt.setString(4, numero);
			preparedStmt.setInt(5, cout);
			preparedStmt.setInt(6, recette);
			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList listReadingArrayList() throws SQLException {
		try {
			ResultSet datas = this.stLogin.executeQuery("SELECT * FROM film;");
			ArrayList resultDatas = new ArrayList();
			while (datas.next()) {
				film newFilm = new film(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getInt(4),
						datas.getInt(5), datas.getInt(6));
				resultDatas.add(newFilm);
			}
			conn.close();
			System.out.println("->Sélection des datas OK");
			return resultDatas;
		} catch (SQLException e) {
			System.err.println("Autre erreur !");
			e.printStackTrace();
			return null;
		}
	}

	public TableModel listReadingListTableModel() throws SQLException {
		try {
			ResultSet datas = this.stLogin.executeQuery("SELECT * FROM film;");
			ArrayList<film> resultDatas = new ArrayList();
			TableModel result;
			while (datas.next()) {
				film newFilm = new film(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getInt(4),
						datas.getInt(5), datas.getInt(6));
				resultDatas.add(newFilm);
			}
			conn.close();
			result = (TableModel) resultDatas;
			System.out.println("->Sélection des datas OK");
			return result;
		} catch (SQLException e) {
			System.err.println("Autre erreur !");
			e.printStackTrace();
			return null;
		}
	}

	public void deleteFilm(String tableBDD, int datasId) throws SQLException {
		try {
			String sql = "DELETE FROM " + tableBDD + " WHERE id=" + datasId + ";";
			System.out.println(sql);
			stLogin.executeUpdate(sql);
			System.out.println("->Suppression de la ligne " + datasId + " dans la table [" + tableBDD + "] OK");
		} catch (SQLException e) {
			System.err.println("Autre erreur !");
			e.printStackTrace();
		}
	}

	public void deleteFilm(String tableBDD, film film) throws SQLException {
		try {
			String sql = "DELETE FROM " + tableBDD + " WHERE id=" + film.getId() + ";";
			System.out.println(sql);
			stLogin.executeUpdate(sql);
			System.out.println("->Suppression de la ligne " + film.getId() + " dans la table [" + tableBDD + "] OK");
		} catch (SQLException e) {
			System.err.println("Autre erreur !");
			e.printStackTrace();
		}
	}

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		DAOFilm co = new DAOFilm("starwars", "root", "", "localhost", "3306");
		co.Lister();
		System.out.println("Vous voulez supprimez quelle film ? (id) : ");
		String id = sc.nextLine();
		co.Lister();
		co.AjouterFilm(2, "L'attaque des clones", 2002, "II", 500000, 560000);
		co.Lister();
	}

}
