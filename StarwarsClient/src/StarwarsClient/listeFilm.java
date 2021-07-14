package StarwarsClient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import starWars.DAOFilm;
import starWars.acces;
import starWars.film;

public class listeFilm extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String deconnexionString;
	private JButton deconnexionButton;
	// -
	private ArrayList<film> daoFilmList;


	/**
	 * Create the frame.
	 */
	public listeFilm() throws SQLException {
		super("STARWARS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 447);
		getContentPane().setLayout(null);
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


        deconnexionString = "Déconnexion";
        deconnexionButton = new JButton(deconnexionString);
        deconnexionButton.addActionListener(this);
        contentPanel.add(deconnexionButton);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JButton btnNewButton = new JButton("LISTER");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		menuBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("?");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		menuBar.add(btnNewButton_1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	private static void titleAlign(JFrame frame) {

		Font font = frame.getFont();

		String currentTitle = frame.getTitle().trim();
		FontMetrics fm = frame.getFontMetrics(font);
		int frameWidth = frame.getWidth();
		int titleWidth = fm.stringWidth(currentTitle);
		int spaceWidth = fm.stringWidth(" ");
		int centerPos = (frameWidth / 2) - (titleWidth / 2);
		int spaceCount = centerPos / spaceWidth;
		String pad = "";
		pad = String.format("%" + (spaceCount - 14) + "s", pad);
		frame.setTitle(pad + currentTitle);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource() == deconnexionButton){
			System.out.println("[Demande de déconnexion]");
            this.dispose();
        }
	}
}
