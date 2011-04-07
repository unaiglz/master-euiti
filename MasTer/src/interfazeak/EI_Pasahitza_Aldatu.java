package interfazeak;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import datuBaseKonexioa.Cargador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Color;

import kudeatzaileak.ErabiltzaileKudeatzaile;

public class EI_Pasahitza_Aldatu extends JFrame {
	private JPasswordField zaharra;
	private JPasswordField berria;
	private JPasswordField berria2;
	private static JLabel errorLbl;

	public EI_Pasahitza_Aldatu(final String id) {
		BufferedImage imagen = Cargador.getImagen("Images/icon.png");
		setIconImage(imagen);
		setTitle("Pasahitz Aldaketa");
		getContentPane().setLayout(null);

		JLabel lblPasahitza = new JLabel("Pasahitz Zaharra:");
		lblPasahitza.setBounds(30, 12, 138, 15);
		getContentPane().add(lblPasahitza);

		JLabel lblSartuBerriz = new JLabel("Sartu berriz:");
		lblSartuBerriz.setBounds(30, 82, 127, 15);
		getContentPane().add(lblSartuBerriz);

		JLabel lblPasahitzBerria = new JLabel("Pasahitz berria:");
		lblPasahitzBerria.setBounds(30, 46, 138, 15);
		getContentPane().add(lblPasahitzBerria);

		zaharra = new JPasswordField();
		zaharra.setBounds(194, 10, 138, 19);
		getContentPane().add(zaharra);

		berria = new JPasswordField();
		berria.setBounds(194, 44, 138, 19);
		getContentPane().add(berria);

		berria2 = new JPasswordField();
		berria2.setBounds(194, 80, 138, 19);
		getContentPane().add(berria2);

		JButton btnAldatu = new JButton("Aldatu");
		btnAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String zah = String.valueOf(zaharra.getPassword());
				String ber = String.valueOf(berria.getPassword());
				String ber1 = String.valueOf(berria2.getPassword());
				if (zah.equals("") || ber.equals("") || ber1.equals("")) {
					new EI_Error_Hutsuneak();
				} else {
					if (ber.equals(ber1)) {
						ErabiltzaileKudeatzaile.getInstantzia()
								.pasahitzAldaketa(id, zah, ber, ber1);
						setVisible(false);
					} else {
						errorea(1);
						zaharra.requestFocus();
					}
				}
			}
		});
		btnAldatu.setBounds(124, 109, 117, 25);
		getContentPane().add(btnAldatu);

		errorLbl = new JLabel("");
		errorLbl.setForeground(Color.RED);
		errorLbl.setFont(new Font("Dialog", Font.ITALIC, 13));
		errorLbl.setBounds(30, 109, 302, 15);
		getContentPane().add(errorLbl);

		setSize(366, 176);
		setVisible(true);
	}

	public static void errorea(int zein) {
		if (zein == 1) {
			errorLbl.setText("Pasahitz berriak ez dira berdinak");
		} else if (zein == 2) {
			errorLbl.setText("Pasahitz zahar OKERRA");
		}

	}

}
