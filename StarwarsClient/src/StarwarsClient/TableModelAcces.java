package StarwarsClient;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import starWars.acces;

public class TableModelAcces extends AbstractTableModel {

    private ArrayList<acces> usersList;
    private String[] columns;

    /**
     * Constructor
     * 
     * TableModelAcces(ArrayList<Acces> daoUsersList)
     * 
     * @param daoUsersList
     */
    public TableModelAcces(ArrayList<acces> daoUsersList) {
        super();
        usersList = daoUsersList;
        columns = new String[]{"ID", "Prénom", "Login", "Password", "Statut", "Age"};
    }

    // Number of column of your table
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    // The object to render in a cell
    @Override
    public Object getValueAt(int row, int col) {
        acces user = usersList.get(row);
        switch (col) {
            case 0:
                return user.getId();
            case 1:
                return user.getPrenom();
            case 2:
                return user.getLogin();
            case 3:
                return user.getPassword();
            case 4:
                return user.getStatut();
            case 5:
                return user.getAge();
            default:
                return null;
        }
    }

    // Optional, the name of your column
    @Override
    public String getColumnName(int col) {
        return columns[col];
    }
    
    // Number of row of your table
    @Override
    public int getRowCount() {
        return usersList.size();
    }

    

}