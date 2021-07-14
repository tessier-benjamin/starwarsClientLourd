package StarwarsClient;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import starWars.film;

public class tableModelFilm extends AbstractTableModel {

    private ArrayList<film> filmsArrayList;
    private String[] columns;

    /**
     * Constructor
     * 
     * @param daoFilmList
     */
    public tableModelFilm(ArrayList<film> daoFilmList) {
        super();
        filmsArrayList = daoFilmList;
        columns = new String[]{"ID", "Titre", "Année", "Nb épisode", "Coût", "Recette", "Bénéfice", "Avis"};
    }

    // Number of column of your table
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    // The object to render in a cell
    @Override
    public Object getValueAt(int row, int col) {
        film film = filmsArrayList.get(row);
        switch (col) {
            case 0:
                return film.getId();
            case 1:
                return film.getTitre();
            case 2:
                return film.getAnneeSortie();
            case 3:
                return film.getNumeroEpisode();
            case 4:
                return film.getCout();
            case 5:
                return film.getRecette();
            case 6:
                double benefice = (double) film.calculBenefice().get(1);
                return benefice;
            case 7:
                int moyenne = 0;
                try{
                    moyenne = (int) film.calculMoyenneAvis();
                }catch(Exception e){ System.err.println(e); }
                return moyenne+"/5";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }
    
    @Override
    public int getRowCount() {
        return filmsArrayList.size();
    }


}