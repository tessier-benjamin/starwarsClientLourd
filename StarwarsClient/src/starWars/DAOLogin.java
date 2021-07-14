package starWars;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOLogin {

	private String bddName = "starwars";
    private String bddLogin = "root";
    private String bddPassword = "";
    private String bddIP = "localhost";
    private String bddPort = "3306";
    private String bddUrl = "jdbc:mysql://"+this.bddIP+":"+this.bddPort+"/"+this.bddName;
    
    //-Attributs du driver JDBC
    private final String strClassName = "com.mysql.jdbc.Driver";
    private Statement stLogin;
    private Connection conn;
    
    /**
     * Constructor
     * 
     * DAOFilm()
     */
    public DAOLogin(){
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
    
    /**
     * Requète de lecture des films dans une base de donnée
     * 
     * checkPassword(String login, String password)
     * @param login
     * @param password
     * @return Acces
     * @throws java.sql.SQLException
     */
    public acces checkPassword(String login, String password) throws SQLException{
    	acces accesSelectionne = null;
        try{
            ResultSet datas = this.stLogin.executeQuery("SELECT * FROM acces");
            ArrayList resultDatas = new ArrayList();
                while (datas.next()) {
                    acces newAcces = new acces(datas.getInt(1), datas.getString(2), datas.getString(3), 
                            datas.getString(4), datas.getString(5), datas.getInt(6));
                    resultDatas.add(newAcces);
                    if( (newAcces.getLogin() == null ? login == null : newAcces.getLogin().equals(login))
                        && (newAcces.getPassword() == null ? password == null : newAcces.getPassword().equals(password)) ){
                        accesSelectionne = newAcces;
                        System.out.println("->Correspondance du login et mdp OK");
                    }
                }
                conn.close();
                return accesSelectionne;
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
            return accesSelectionne;
        }
    }
    
    /**
     * Fermeture de la connexion JDBC
     * 
     * close()
     * @throws java.sql.SQLException
     */
    public void close() throws SQLException{
        this.conn.close();
        System.out.println("[La connexion à été fermée]");
    }
    
    // The methods of basic getter below.
    public String getBddName() {  return bddName;  }
    public String getBddLogin() { return bddLogin; }
    public String getBddPassword() { return bddPassword; }
    public String getBddIP() { return bddIP; }
    public String getBddPort() { return bddPort; }
    public String getBddUrl() { return bddUrl; }
    
    // The methods of basic setter below.
    public void setBddName(String bddName) { this.bddName = bddName; }
    public void setBddLogin(String bddLogin) { this.bddLogin = bddLogin; }
    public void setBddPassword(String bddPassword) { this.bddPassword = bddPassword; }
    public void setBddIP(String bddIP) { this.bddIP = bddIP; }
    public void setBddPort(String bddPort) { this.bddPort = bddPort; }
    public void setBddUrl(String bddUrl) {  this.bddUrl = bddUrl; }
	
}
