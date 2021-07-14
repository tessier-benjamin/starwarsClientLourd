package starWars;

import java.util.ArrayList;

public class acteur {
	String nom;
	String prenom;
	private ArrayList<personnage> duetPersonnages = new ArrayList(1);
	
	public acteur(String nom,String prenom) 
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
	
	 public ArrayList getDuetPersonnages() 
	 { 
		 return duetPersonnages; 
	 }
	
	void setNom(String nom)
	{
		this.nom=nom;
	}
	
	void setPrenom(String prenom)
	{
		this.prenom=prenom;
	}
	
	 public void setDuetPersonnages(ArrayList duetPersonnages) 
	 { 
		 this.duetPersonnages = duetPersonnages; 
	 }
	
	public String toString() 
	{
		return "nom: "+this.nom+" prenom: "+this.prenom;
	}
	
	public int getNombrePersonnages()
	{ 
		return this.duetPersonnages.size(); 
	}

}
