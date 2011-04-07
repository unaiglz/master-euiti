package interfazeak;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JButton;

import datuBaseKonexioa.Cargador;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Calendar;

public class EI_Terapeuta_Datuak_Bistaratu extends JFrame {

	public EI_Terapeuta_Datuak_Bistaratu(String izena, String helbidea,
			String jaioD, int aktiboa) {
		setTitle("Terapeuta Datuak");
		BufferedImage imagen = Cargador.getImagen("Images/info_icon.png");
		setIconImage(imagen);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Terapeutaren datuak eguneratu dira:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(87, 14, 294, 23);
		getContentPane().add(lblNewLabel);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnOnartu.setBounds(163, 167, 117, 25);
		getContentPane().add(btnOnartu);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Dialog", Font.PLAIN, 12));
		textArea.setForeground(UIManager.getColor("OptionPane.foreground"));
		if (aktiboa == 0) {
			textArea.setText("Terapeutaren izena: \t" + izena + "\n"
					+ "Helbidea: \t" + helbidea + "\n" + "JaioD: \t" + jaioD
					+ "\n" + "Egoera:  \t Aktiboa");
		} else {
			textArea.setText("Terapeutaren izena: \t" + izena + "\n"
					+ "Helbidea: \t" + helbidea + "\n"
					+ "Egoera:  \t + Inaktiboa");
		}
		textArea.setBounds(87, 43, 320, 112);
		getContentPane().add(textArea);

		JLabel image = new JLabel("");
		image.setBounds(12, 1, 75, 48);
		image.setIcon(new ImageIcon(imagen));
		getContentPane().add(image);

		setVisible(true);
		setSize(447, 252);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// EI_Terapeuta_Datuak_Bistaratu frame = new
					// EI_Terapeuta_Datuak_Bistaratu("Junito", "Kantoi kalea",
					// "1990-11-11", 1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
