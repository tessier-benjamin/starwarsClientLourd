package StarwarsClient;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import starWars.DAOFilm;
import starWars.film;

public class viewListFilm extends JFrame implements ActionListener {
	
	private String closeViewString;
    private JButton closeViewButton;
    //-
    private ArrayList<film> daoFilmList;
    
    /**
     * Constructor
     * 
     * @throws java.sql.SQLException
     */
    public viewListFilm() throws SQLException{
        super("Star Wars");
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(800, 350));
        this.setLocationRelativeTo(null);
        
        JPanel contentPanel = (JPanel) this.getContentPane();
        contentPanel.setLayout(new FlowLayout());
        
        DAOFilm daoFilm = new DAOFilm();
        this.daoFilmList = daoFilm.listReadingArrayList();
        daoFilm.Close();
        
        TableModel filmsTableModel = new tableModelFilm(this.daoFilmList);
        JTable usersListTable = new JTable(filmsTableModel);
        usersListTable.setPreferredScrollableViewportSize(new Dimension(780, 250));
        usersListTable.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(usersListTable);
        contentPanel.add(scrollPane);
        
        closeViewString = "Fermer";
        closeViewButton = new JButton(closeViewString);
        closeViewButton.addActionListener(this);
        contentPanel.add(closeViewButton);
        
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if((JButton)event.getSource() == closeViewButton){
           System.out.println("[Fermeture fenêtre]");
            this.dispose();
        }
    }
	
}
