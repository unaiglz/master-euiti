package interfazeak;

import javax.swing.JFrame;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import datuBaseKonexioa.Cargador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class EI_Luzera_Ez_Egokia extends JFrame {

	public EI_Luzera_Ez_Egokia(String hutsunea, int luzera) {
		BufferedImage imagen = Cargador.getImagen("Images/error_icon.png");
		setIconImage(imagen);
		setTitle("ERROR");
		getContentPane().setLayout(null);

		JLabel img = new JLabel("");
		img.setBounds(28, 25, 48, 49);
		img.setIcon(new ImageIcon(
				imagen));
		getContentPane().add(img);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnOnartu.setBounds(149, 86, 117, 25);
		getContentPane().add(btnOnartu);

		JTextArea textArea = new JTextArea(hutsunea
				+ "      hutsuneak ez du luzera egokia. \nLuzera zuzena: "
				+ luzera + "   da");
		textArea.setBackground(UIManager.getColor("Panel.background"));
		textArea.setBounds(94, 25, 316, 49);
		getContentPane().add(textArea);

		setVisible(true);
		setSize(430, 165);

	}
}
