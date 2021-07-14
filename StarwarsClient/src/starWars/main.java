package starWars;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.sql.*;

public class main {
	public static void main(String[] arg) throws ParseException {
		
		 film filmA = new film("Star wars I","1977", 1, 1234123, 6443123);
		 film filmB = new film("Star wars II","1980", 2, 1234123, 6443123);
		 film filmC = new film("Star wars III","1983", 3, 1234123, 6443123);
		 ArrayList<film> films = new ArrayList();
	        films.add(filmA);
	        films.add(filmB);
	        films.add(filmC);
	        
	        int y = 1;
	        for(film film : films){
	        	System.out.println("[Film "+y+"]"+film.toString());
	            y++;
	        }
	        
	        personnage persoA = new personnage("Skywalker", "Anakin");
	        personnage persoB = new personnage("Skywalker", "Luke");
	        personnage persoC = new personnage("Skywalker", "Shmi");
	        personnage persoD = new personnage("Skywalker", "Ben");

	        
	        acteur acteur1 = new acteur("Ford", "Harrison");
	        acteur acteur2 = new acteur("Hamill", "Mark");
	        acteur acteur3 = new acteur("Fisher", "Carrie");
	        acteur acteur4 = new acteur("Guinness", "Alec");
	        
	        ArrayList<personnage> personnagesActeurA = new ArrayList(1);
	        personnagesActeurA.add(persoA);
	        personnagesActeurA.add(persoB);
	        acteur1.setDuetPersonnages(personnagesActeurA);
	        ArrayList<personnage> personnagesActeurB = new ArrayList(1);
	        personnagesActeurB.add(persoC);
	        personnagesActeurB.add(persoD);
	        acteur2.setDuetPersonnages(personnagesActeurB);
	        ArrayList<personnage> personnagesActeurC = new ArrayList(1);
	        personnagesActeurC.add(persoC);
	        personnagesActeurC.add(persoD);
	        acteur3.setDuetPersonnages(personnagesActeurC);
	        ArrayList<personnage> personnagesActeurD = new ArrayList(1);
	        personnagesActeurD.add(persoC);
	        personnagesActeurD.add(persoD);
	        acteur4.setDuetPersonnages(personnagesActeurD);
	        
	        ArrayList<acteur> acteursList1 = new ArrayList();
	        acteursList1.add(acteur1);
	        acteursList1.add(acteur2);
	        acteursList1.add(acteur3);
	        acteursList1.add(acteur4);
	        filmA.setActeurs(acteursList1);
	        System.out.println("\n"+filmA.toString());
	        
	        boolean isBefore = filmA.isBefore("2020");
	        System.out.println("\n isBefore : "+isBefore);
	        
	        System.out.println("\n"+filmA.getDuet());
	        filmA.tri();
	        System.out.println("\n"+filmA.getDuet());
	        
	        System.out.println("\nHashMap Dico");
	        HashMap<String,film> dicoFilms = new HashMap();
	        dicoFilms.put(filmA.getAnneeSortie(), filmA);
	        dicoFilms.put(filmB.getAnneeSortie(), filmB);
	        dicoFilms.put(filmC.getAnneeSortie(), filmC);
	        //dicoFilms.put(filmD.getAnneeDeSortie(), filmD);
	        
	        makeBackUp(dicoFilms);
	        
	    }
	    
	    public static void makeBackUp(HashMap dicoFilms){
	        Set dicoFilmsSetIterator = dicoFilms.entrySet();
	        Iterator dicoFilmsList = dicoFilmsSetIterator.iterator();
	        while(dicoFilmsList.hasNext()) {
	            Map.Entry film = (Map.Entry)dicoFilmsList.next();
	            String filmKey = (String) film.getKey();
	            film filmValue = (film) film.getValue();
	            String filmTitre = filmValue.getTitre();
	            String filmBenefice = filmValue.calculBenefice().get(1).toString();
	            System.out.println(""+filmKey+" - "+filmTitre+" - "+filmBenefice);
	        }
	    }

}
