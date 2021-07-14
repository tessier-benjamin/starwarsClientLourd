package StarwarsClient;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import starWars.DAOLogin;
import starWars.acces;

public class connexion extends JFrame implements ActionListener {

	private acces user;
	private boolean userConnecte;

	private JPanel contentPane;
	private JTextField txtTextfield;
	private JPasswordField pwdMotdepasse;
	private JButton connexion;
	private JButton deconnexionButton;
	private JButton filmsListButton;
	private JButton usersListButton;

	private String messageString;
	private String loginString;
	private JLabel loginLabel;

	private listeFilm filmsList;
	private listeUser usersList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					connexion frame = new connexion();
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
	public connexion() {
		super("STARWARS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(626, 448));
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane = (JPanel) this.getContentPane();

		userConnecte = false;

		JLabel lblNewLabel = new JLabel("IDENTIFIANT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(89, 97, 81, 39);
		getContentPane().add(lblNewLabel);

		JLabel lblMotDePasse = new JLabel("MOT DE PASSE");
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMotDePasse.setBounds(89, 147, 81, 39);
		getContentPane().add(lblMotDePasse);

		txtTextfield = new JTextField();
		txtTextfield.setColumns(10);
		txtTextfield.setBounds(180, 102, 259, 29);
		getContentPane().add(txtTextfield);

		pwdMotdepasse = new JPasswordField();
		pwdMotdepasse.setBounds(180, 156, 259, 20);
		getContentPane().add(pwdMotdepasse);

		JLabel lblNewLabel_1 = new JLabel("Erreur de login / Mot de Passe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(180, 262, 229, 23);
		lblNewLabel_1.setVisible(false);
		getContentPane().add(lblNewLabel_1);

		JButton filmsListButton = new JButton("Liste des films");
		filmsListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					filmsList = new listeFilm();
				} catch (SQLException ex) {
					Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		filmsListButton.setBounds(224, 156, 185, 39);
		getContentPane().add(filmsListButton);
		filmsListButton.setVisible(false);

		JButton usersListButton = new JButton("Liste des users");
		usersListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					usersList = new listeUser();
				} catch (SQLException ex) {
					Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		usersListButton.setBounds(224, 97, 185, 39);
		getContentPane().add(usersListButton);
		usersListButton.setVisible(false);

		JButton deconnexionButton = new JButton("deconnexion");
		deconnexionButton.setBounds(224, 222, 185, 29);
		getContentPane().add(deconnexionButton);
		deconnexionButton.setVisible(false);

		connexion = new JButton("SE CONNECTER");
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("[Demande de connexion]");
				DAOLogin daoLogin = new DAOLogin();
				String login = txtTextfield.getText();
				System.out.println(login);
				String password = pwdMotdepasse.getText();
				// String password = Arrays.toString(pwdMotdepasse.getPassword());
				System.out.println("Login : " + login + " - Password : " + password);
				try {
					userConnecte = true;
					if (userConnecte == true) {
						user = daoLogin.checkPassword(login, password);
						if (user != null) {
							System.out.println("user : " + user.getLogin() + " / " + user.getPassword());
							filmsListButton.setVisible(true);
							usersListButton.setVisible(true);
							deconnexionButton.setVisible(true);
							pwdMotdepasse.setVisible(false);
							txtTextfield.setVisible(false);
							connexion.setVisible(false);
							lblNewLabel.setVisible(false);
							lblMotDePasse.setVisible(false);

						}
					}
				} catch (SQLException ex) {
					Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

		});
		connexion.setBounds(224, 203, 139, 23);

		getContentPane().add(connexion);

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

	public void actionPerformed(ActionEvent event) {

	}
}
