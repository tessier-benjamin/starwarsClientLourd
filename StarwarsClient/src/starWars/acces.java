package starWars;

public class acces {
	
	 private int id;
	    private String prenom;
	    private String login;
	    private String password;
	    private String statut;
	    private int age;
	    
	    /**
	     * Constructor
	     * 
	     * Acces()
	     */
	    public acces(){}
	    
	    /**
	     * Constructor
	     * 
	     * Acces()
	     * @param id
	     * @param prenom
	     * @param login
	     * @param password
	     * @param statut
	     * @param age
	     */
	    public acces(int id, String prenom, String login, String password, String statut, int age){
	        this.id = id;
	        this.prenom = prenom;
	        this.login = login;
	        this.password = password;
	        this.statut = statut;
	        this.age = age;
	    }

	    // The methods of basic getter below.
	    public int getId() { return id; }
	    public String getPrenom() { return prenom; }
	    public String getLogin() { return login; }
	    public String getPassword() { return password; }
	    public String getStatut() { return statut; }
	    public int getAge() { return age; }

	    // The methods of basic setter below.
	    public void setId(int id) { this.id = id; }
	    public void setPrenom(String prenom) { this.prenom = prenom; }
	    public void setLogin(String login) { this.login = login; }
	    public void setPassword(String password) { this.password = password; }
	    public void setStatut(String statut) { this.statut = statut; }
	    public void setAge(int age) { this.age = age; }

}
