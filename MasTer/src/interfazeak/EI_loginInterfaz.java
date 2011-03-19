package interfazeak;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import kudeatzaileak.ErabiltzaileKudeatzaile;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class EI_loginInterfaz extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static JTextField textField;
	private static JPasswordField passwordField;
	private static JLabel erroreMezua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_loginInterfaz frame = new EI_loginInterfaz();
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
	public EI_loginInterfaz() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		setTitle("Erabiltzailearen Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowText);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(147, 94, 377, 176);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(150, 139, 77, 25);
		panel.add(btnLogIn);

		passwordField = new JPasswordField();
		passwordField.setBounds(177, 82, 156, 20);
		panel.add(passwordField);

		JLabel lblErabiltzailea = new JLabel("Erabiltzailea");
		lblErabiltzailea.setForeground(SystemColor.text);
		lblErabiltzailea.setBackground(SystemColor.text);
		lblErabiltzailea.setBounds(50, 26, 89, 20);
		panel.add(lblErabiltzailea);

		textField = new JTextField();
		textField.setBounds(177, 27, 156, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setForeground(SystemColor.text);
		lblPasahitza.setBounds(50, 84, 89, 15);
		panel.add(lblPasahitza);

		erroreMezua = new JLabel("");
		erroreMezua.setHorizontalAlignment(SwingConstants.CENTER);
		erroreMezua.setForeground(Color.RED);
		erroreMezua.setBounds(50, 112, 283, 15);
		panel.add(erroreMezua);

		JLabel lblMasterKlinika = new JLabel("MasTer Klinika");
		lblMasterKlinika.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblMasterKlinika.setBounds(224, 0, 201, 68);
		contentPane.add(lblMasterKlinika);

		JLabel lblLogeatuZaitezJarraitzeko = new JLabel(
				"Logeatu zaitez jarraitzeko:");
		lblLogeatuZaitezJarraitzeko.setBounds(201, 67, 224, 15);
		contentPane.add(lblLogeatuZaitezJarraitzeko);

		JLabel img1 = new JLabel("");
		img1.setBounds(12, 343, 70, 57);
		img1.setIcon(new ImageIcon(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		contentPane.add(img1);

		JLabel img4 = new JLabel("");
		img4.setIcon(new ImageIcon(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		img4.setBounds(576, 343, 70, 56);
		contentPane.add(img4);

		JLabel img3 = new JLabel("");
		img3.setIcon(new ImageIcon(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		img3.setBounds(576, 11, 70, 56);
		contentPane.add(img3);

		JLabel img2 = new JLabel("");
		img2.setIcon(new ImageIcon(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		img2.setBounds(12, 11, 60, 56);
		contentPane.add(img2);
		btnLogIn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (ErabiltzaileKudeatzaile.getInstantzia().identifikazioaKonprobatu(
				textField.getText(), passwordField.getPassword())) {
			setVisible(false);
		}

	}

	/**
	 * 
	 */
	public static void errorea() {
		erroreMezua.setText("Erabiltzaile/Pasahitz OKERRA");
		textField.requestFocus();
		passwordField.setText("");
	}
}
