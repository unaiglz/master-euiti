package interfazeak;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class EI_DataGaizki extends JFrame {

	public EI_DataGaizki(String dateTime) {
		BufferedImage imagen = Cargador.getImagen("Images/error_icon.png");
		setIconImage(imagen);
		setTitle("ERROR");
		getContentPane().setLayout(null);
		setSize(383, 157);
		setVisible(true);

		JLabel img = new JLabel("");
		img.setBounds(25, 22, 56, 50);
		img.setIcon(new ImageIcon(
				imagen));
		getContentPane().add(img);

		JTextArea textArea = new JTextArea(
				"Sartutako ordua | data uneko momentutik \n aurrerakoa izan behar da, ez hau:\n "
						+ dateTime);
		textArea.setBackground(UIManager.getColor("Panel.background"));
		textArea.setForeground(Color.BLACK);
		textArea.setBounds(99, 27, 347, 45);
		getContentPane().add(textArea);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnOnartu.setBounds(131, 81, 117, 25);
		getContentPane().add(btnOnartu);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_DataGaizki frame = new EI_DataGaizki("2001-11-11 11:11");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
