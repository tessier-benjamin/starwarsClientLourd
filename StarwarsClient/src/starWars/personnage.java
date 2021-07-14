package starWars;

public class personnage {
	String nom;
	String prenom;
	
	public personnage(String nom,String prenom) 
	{
		this.nom=nom;
		this.prenom=prenom;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public String getPrenom()
	{
		return this.prenom;
	}
	
	void setNom(String nom)
	{
		this.nom=nom;
	}
	
	void setPrenom(String prenom)
	{
		this.prenom=prenom;
	}
	
	public String toString() 
	{
		return "nom: "+this.nom+" prenom: "+this.prenom;
	}
}
