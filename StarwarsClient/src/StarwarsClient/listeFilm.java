package StarwarsClient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class listeFilm extends JFrame {

	/**
	 * Launch the application.
	 */
	

    private String[] tableCoulmnsName = {"Nom", "Valeur", "Utiliser"};
    private Object[][] tableDatas = {
        {"pi", 3.14159, false},
        {"phi", 1.68803, true},
        {"e", 2.71828, false},
        {"euro", 1.0, false},
        {"franc", 6.59, true},
        {"pi", 3.14159, false},
        {"phi", 1.68803, true},
        {"e", 2.71828, false},
        {"euro", 1.0, false},
        {"franc", 6.59, true},
        {"pi", 3.14159, false},
        {"phi", 1.68803, true},
        {"e", 2.71828, false},
        {"euro", 1.0, false},
        {"franc", 6.59, true},
        {"pi", 3.14159, false},
        {"phi", 1.68803, true},
        {"e", 2.71828, false},
        {"euro", 1.0, false},
        {"franc", 6.59, true},
        {"pi", 3.14159, false},
        {"phi", 1.68803, true},
        {"e", 2.71828, false},
        {"euro", 1.0, false},
        {"franc", 6.59, true},
        {"pi", 3.14159, false},
        {"phi", 1.68803, true},
        {"e", 2.71828, false},
        {"euro", 1.0, false},
        {"franc", 6.59, true}
    };
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listeFilm frame = new listeFilm();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.addComponentListener(new ComponentAdapter() {
			            @Override
			            public void componentResized(ComponentEvent e) {
			                titleAlign(frame);
			            }

			        });

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public listeFilm() {
		super("STARWARS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 564);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(new FlowLayout());

		
        JTable usersListTable = new JTable(this.tableDatas, this.tableCoulmnsName);
        usersListTable.setPreferredScrollableViewportSize(new Dimension(300, 200));
        usersListTable.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(usersListTable);
        contentPanel.add(scrollPane);
		
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
		
		DefaultTableModel model = new DefaultTableModel();
		
		
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
}
