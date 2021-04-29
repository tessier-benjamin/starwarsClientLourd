package StarwarsClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JList;
import java.awt.List;

public class listeFilm extends JFrame {

	/**
	 * Launch the application.
	 */
	
	String label[] = { "Mars","Vénus","Mercure","Jupiter","Saturne","Uranus","Six",
    "Neptune" };
	JList list;
	
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
		
		JList list = new JList();
		list.setBounds(10, 11, 784, 377);
		getContentPane().add(list);
		
		JButton btnNewButton_2 = new JButton("SE CONNECTER");
		btnNewButton_2.setBounds(586, 446, 132, 23);
		getContentPane().add(btnNewButton_2);
		
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
