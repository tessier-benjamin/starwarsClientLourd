package starWars;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.TableModel;

public class DAOAvis {
    
    //-Attributs de base
    private String bddName = "starwars";
    private String bddLogin = "root";
    private String bddPassword = "";
    private String bddIP = "localhost";
    private String bddPort = "3306";
    private String bddUrl = "jdbc:mysql://"+this.bddIP+":"+this.bddPort+"/"+this.bddName;
    
    //-Attributs du driver JDBC
    private final String strClassName = "com.mysql.jdbc.Driver";
    private Statement statement;
    private Connection conn;
    
    /**
     * Constructor
     * 
     * DAOAvis()
     */
    public DAOAvis(){
        try {
            Class.forName(this.strClassName);
            this.conn = DriverManager.getConnection(this.bddUrl, this.bddLogin, this.bddPassword);
            this.statement = (Statement) conn.createStatement();
            System.out.println("=> DAOAvis ready");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver non chargé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    /**
     * Requète de lecture des avis dans une base de donnée
     * 
     * listReadingConsole(String sqlQuery)
     * @param sqlQuery
     * @throws java.sql.SQLException
     */
    public void listReadingConsole(String sqlQuery) throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery(sqlQuery);
            System.out.println("->Sélection des datas OK");
            while (datas.next()) {
            	System.out.println("Avis :"
                        +"\n- id du avis : "+datas.getInt(1)
                        +"\n- titre du avis : "+datas.getString(2)
                        +"\n- description : "+datas.getString(3)
                        );
            }
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    /**
     * Requète de lecture des Avis dans une base de donnée
     * 
     * listReadingArrayList()
     * @return ArrayList
     * @throws java.sql.SQLException
     */
    public ArrayList listReadingArrayList() throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery("SELECT * FROM avis");
            ArrayList resultDatas = new ArrayList();
                while (datas.next()) {
                    avis newAvis = new avis(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getInt(4));
                    resultDatas.add(newAvis);
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
    
    /**
     * Requète de lecture des Avis d'un film dans une base de donnée
     * 
     * listReadingArrayList()
     * @return ArrayList
     * @throws java.sql.SQLException
     */
    public ArrayList listReadingArrayList(int idFilm) throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery("SELECT * FROM films_acces_avis WHERE films_id="+idFilm+"");
            ArrayList resultDatas = new ArrayList();
                while (datas.next()) {
                    avis newAvis = new avis(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getInt(4));
                    resultDatas.add(newAvis);
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
    
    /**
     * Requète de lecture des avis dans une base de donnée
     * 
     * listReadingListTableModel()
     * @return TableModel
     * @throws java.sql.SQLException
     */
    public TableModel listReadingListTableModel() throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery("SELECT * FROM avis");
            ArrayList<avis> resultDatas = new ArrayList();
            TableModel result;
                while (datas.next()) {
                    avis newAvis = new avis(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getInt(4));
                    resultDatas.add(newAvis);
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
    
    /**
     * Requète d'ajout d'un avis dans une base de donnée
     * 
     * addAvis(Avis avis)
     * @param avis
     * @throws java.sql.SQLException
     */
    public void addAvis(avis avis) throws SQLException{
        try{
            String sql = "INSERT INTO `avis` (`title`, `description`, `note_avis`) VALUES ";
            String sqlElements = "("
                            +"\""+avis.getTitre()+"\""+","
                            +"\""+avis.getDescription()+"\""+","
                            +avis.getNoteAvis()
                            +")";
            sql += sqlElements;
            System.out.println(sql);
            statement.executeUpdate(sql);
            System.out.println("->Insertion des datas dans la [avis] OK");
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    /**
     * Requète d'ajout d'un avis dans une base de donnée
     * 
     * addAvis(String tableBDD, Avis avis)
     * @param tableBDD
     * @param avis
     * @throws java.sql.SQLException
     */
    public void addAvis(String tableBDD, avis avis) throws SQLException{
        try{
            String sql = "INSERT INTO "+tableBDD+" (`title`, `description`, `note_avis`) VALUES ";
            String sqlElements = "("
                            +"\""+avis.getTitre()+"\""+","
                            +"\""+avis.getDescription()+"\""+","
                            +avis.getNoteAvis()
                            +")";
            sql += sqlElements;
            System.out.println(sql);
            statement.executeUpdate(sql);
            System.out.println("->Insertion des datas dans la ["+tableBDD+"] OK");
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    /**
     * Requète d'ajout d'un avis dans une base de donnée
     * 
     * addAvis(Avis avis)
     * @param avis
     * @throws java.sql.SQLException
     */
    public int getAvisID(avis avis) throws SQLException{
        try{
            ResultSet datas = this.statement.executeQuery("SELECT `id`, `title` FROM `avis` WHERE `title` LIKE \"%"+avis.getTitre()+"%\"");
            int resultData = 0;
                while (datas.next()) {
                    resultData = Integer.parseInt(datas.getString(2));
                }
                conn.close();
                System.out.println("->Sélection des datas OK");
                return resultData;
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
            return 0;
        }
    }
    
   /**
     * Requète de récupération du dernier avis ajouté
     * 
     * @return avis
     * @throws java.sql.SQLException
     */
    public avis getLastAvis() throws SQLException{
        avis avisRecuperer = null;
        try{
            ResultSet datas = this.statement.executeQuery("SELECT * FROM avis ORDER BY id DESC LIMIT 0,1");
            while (datas.next()) {
                avisRecuperer = new avis(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getInt(4));
            }
            conn.close();
            System.out.println("->Sélection des datas OK");
            return avisRecuperer;
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
            return avisRecuperer;
        }
    }
    
    /**
     * Requète de récupération de la moyenne d'un film
     * 
     * @param id
     * @return int
     */
    public int getMoyenne(int id){
        int moyenne = 0;
        try{
            String sql = "SELECT avg(a.note_avis) as moyenne_avis FROM films_acces_avis faa, films f, avis a WHERE faa.films_id=f.id AND faa.avis_id=a.id AND faa.films_id="+id+";";
            ResultSet datas = this.statement.executeQuery(sql);
            while (datas.next()) {
                moyenne = datas.getInt(1);
            }
            conn.close();
            System.out.println("->Sélection des datas OK");
            return moyenne;
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
            return moyenne;
        }
    }
    
    /**
     * Requète de suppression d'un avis dans une base de donnée
     * 
     * deleteAvis(String table, int datasId)
     * @param tableBDD
     * @param datasId
     * @throws java.sql.SQLException
     */
    public void deleteAvis(String tableBDD, int datasId) throws SQLException{
        try{
            String sql = "DELETE FROM "+tableBDD+" WHERE id="+datasId+";";
            System.out.println(sql);
            statement.executeUpdate(sql);
            System.out.println("->Suppression de la ligne "+datasId+" dans la table ["+tableBDD+"] OK");
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
    
    /**
     * Requète de suppression d'un avis dans une base de donnée
     * 
     * deleteAvis(String table, int datasId)
     * @param tableBDD
     * @param avis
     * @throws java.sql.SQLException
     */
    public void deleteAvis(String tableBDD, avis avis) throws SQLException{
        try{
            String sql = "DELETE FROM "+tableBDD+" WHERE id="+avis.getId()+";";
            System.out.println(sql);
            statement.executeUpdate(sql);
            System.out.println("->Suppression de la ligne "+avis.getId()+" dans la table ["+tableBDD+"] OK");
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
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