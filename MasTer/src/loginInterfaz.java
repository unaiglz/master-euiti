import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;


public class loginInterfaz extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginInterfaz frame = new loginInterfaz();
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
	public loginInterfaz() {
		setTitle("Erabiltzailearen Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(102, 87, 117, 25);
		contentPane.add(btnLogIn);
		
		textField = new JTextField();
		textField.setBounds(144, 12, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 55, 158, 20);
		contentPane.add(passwordField);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea");
		lblErabiltzailea.setBounds(37, 11, 89, 20);
		contentPane.add(lblErabiltzailea);
		
		JLabel lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setBounds(37, 57, 89, 15);
		contentPane.add(lblPasahitza);
	}
}
