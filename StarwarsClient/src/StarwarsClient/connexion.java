package StarwarsClient;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class connexion extends JFrame {

	private JPanel contentPane;
	private JTextField txtTextfield;
	private JPasswordField pwdMotdepasse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel() );
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
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("IDENTIFIANT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(89, 97, 81, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("MOT DE PASSE");
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMotDePasse.setBounds(89, 128, 81, 39);
		getContentPane().add(lblMotDePasse);
		
		JButton btnNewButton = new JButton("SE CONNECTER");
		btnNewButton.setBounds(222, 168, 139, 23);
		getContentPane().add(btnNewButton);
		
		txtTextfield = new JTextField();
		txtTextfield.setText("Textfield");
		txtTextfield.setColumns(10);
		txtTextfield.setBounds(180, 106, 259, 20);
		getContentPane().add(txtTextfield);
		
		JLabel lblNewLabel_1 = new JLabel("ERREUR DE LOGIN/MOT DE PASSE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(180, 262, 229, 23);
		getContentPane().add(lblNewLabel_1);
		
		pwdMotdepasse = new JPasswordField("motdepasse");
		pwdMotdepasse.setBounds(180, 137, 259, 20);
		getContentPane().add(pwdMotdepasse);
		
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
