package starWars;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class film {
	int id;
	String titre;
	String annee_de_sortie;
	int numero_episode;
	int cout;
	int recette;
	ArrayList<acteur> duet;
	private int moyenneAvis = 0;
	private int numeroEpisode;
	private ArrayList<avis> daoAvisList;
	
	public film(boolean nouveauFilm) 
	{
		 if(nouveauFilm==true){
			 	System.out.println("[Nouveau film]");
	            Scanner scan = new Scanner(System.in);
	            System.out.println("-  titre du film : ");
	            String titreFilm = scan.nextLine();
	            this.titre = titreFilm;
	            System.out.println("-  année du film : ");
	            String anneeDeSortieFilm = scan.next();
	            this.annee_de_sortie = anneeDeSortieFilm;
	            System.out.println("-  numéro du film : ");
	            int numeroEpisodeFilm = scan.nextInt();
	            this.numero_episode = numeroEpisodeFilm;
	            System.out.println("-  coût du film : ");
	            int coutFilm = scan.nextInt();
	            this.cout = coutFilm;
	            System.out.println("- recette du film : ");
	            int recetteFilm = scan.nextInt();
	            this.recette = recetteFilm;
	            this.duet = new ArrayList();
	            System.out.println("[Nouveau film enregistré]");
	        }
	}
	
	   public film(String titre, String anneeDeSortie, int numeroEpisode, int cout, int recette) {
	        this.titre = titre;
	        this.annee_de_sortie = anneeDeSortie;
	        this.numero_episode = numeroEpisode;
	        this.cout = cout;
	        this.recette = recette;
	        this.duet = new ArrayList();
	    }
	   
	   public film(int id, String titre, String anneeDeSortie, int numeroEpisode, int cout, int recette) {
	        this.id = id;
	        this.titre = titre;
	        this.annee_de_sortie = anneeDeSortie;
	        this.numeroEpisode = numeroEpisode;
	        this.cout = cout;
	        this.recette = recette;
	        this.duet = new ArrayList();
	    }
	
	public film() {
	}

	public String getTitre()
	{
		return this.titre;
	}
	
	public String getAnneeSortie()
	{
		return this.annee_de_sortie;
	}
	
	public int getNumeroEpisode()
	{
		return this.numero_episode;
	}
	public int getCout()
	{
		return this.cout;
	}
	
	public int getRecette()
	{
		return this.recette;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	 public ArrayList<acteur> getDuet() 
	 { 
		 return this.duet; 
	 }

	
	void setTitre(String titre)
	{
		this.titre=titre;
	}
	
	void setAnneeSortie(String annee_de_sortie)
	{
		this.annee_de_sortie=annee_de_sortie;
	}
	
	void setNumeroEpisode(int numero_episode)
	{
		this.numero_episode=numero_episode;
	}
	void setCout(int cout)
	{
		this.cout=cout;
	}
	
	void setRecette(int recette)
	{
		this.recette=recette;
	}
	
	void setId(int id)
	{
		this.id=id;
	}
	
	public void setActeurs(ArrayList<acteur> acteurs) 
	{ 
		this.duet = acteurs; 
	}
	
	public String toString() 
	{
		return "Le film: "+this.titre+" est l'episode numero "+this.numero_episode+" est sortie en "+this.annee_de_sortie+" sa production à couté "+this.cout+" et a produit une recette de "+this.recette;
	}
	
	public static void afficherTrilogie(Collection<film> Trilogie) {
		
		for(film Value : Trilogie) {
			System.out.println(Value);
		}
		
	}
	
	public int nbActeurs(Collection<acteur> duet) 
	{
		 return !this.duet.isEmpty() && this.duet.size()>0 ? this.duet.size() : 0 ;
	}
	
	public int nbPersonnages(Collection<personnage> duet) 
	{
		  int i = 0;
	        for(acteur acteur : this.duet){
	            i +=acteur.getNombrePersonnages();
	        }
	        return i;
	}
	
	  public ArrayList calculBenefice(){
	        double x = this.recette-this.cout;
	        ArrayList result = new ArrayList();
	        if(x >= 0){
	            result.add(true);
	            result.add(x);
	        } else {
	            result.add(false);
	            result.add(x);
	        }
	        return result;
	    }
	  
	  public int calculMoyenneAvis() throws SQLException{
	        try {
	            DAOAvis daoAvis = new DAOAvis();
	            this.moyenneAvis = daoAvis.getMoyenne(this.id);
	            daoAvis.close();
	        } catch (Exception e) { System.err.println(e); }
	        return this.moyenneAvis;
	    }
	
	  public boolean isBefore(String anneeInserted) throws ParseException{
	        DateFormat format = new SimpleDateFormat("YYYY", Locale.FRANCE);
	        Date anneeDeSortieToDate = format.parse(this.annee_de_sortie);
	        Date anneeInsertedToDate = format.parse(anneeInserted);
	        return anneeDeSortieToDate.compareTo(anneeInsertedToDate) < 0;
	    }
	  
	  
	  public ArrayList tri(){
	        ArrayList<acteur> acteursTries = new ArrayList();
	        if(this.duet!=null && !this.duet.isEmpty() && this.duet.size()>0){
	            Collections.sort(this.duet, new Comparator<acteur>() {
	                @Override
	                public int compare(acteur acteur1, acteur acteur2){ return  acteur1.getNom().compareTo(acteur2.getNom()); }
	            });
	            acteursTries.addAll(this.duet);       
	        } else{
	            acteursTries = null;
	        }
	        return acteursTries;
	    }
	  
	
	
}
