package interfazeak;

import java.util.Vector;

import javax.swing.JFrame;

import kudeatzaileak.HitzorduKudeatzailea;
import kudeatzaileak.TerapeutaKudeatzaile.Terapeuta;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

import datuBaseKonexioa.Cargador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EI_Terapeutak extends JFrame {
	JComboBox terapeutaBox;
	private String dataOrdua;
	private String aurrekoTer;

	public EI_Terapeutak(Vector<Terapeuta> terapeutak, String data,
			String ordua, String terapeutaZaharra) {
		BufferedImage imagen = Cargador.getImagen("Images/icon.png");
		setIconImage(imagen);
		setTitle("Terapeuta Libreak");
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(469, 142);

		dataOrdua = data + " " + ordua;
		aurrekoTer= terapeutaZaharra;

		terapeutaBox = new JComboBox(terapeutak);
		terapeutaBox.setBounds(157, 14, 152, 24);
		getContentPane().add(terapeutaBox);

		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HitzorduKudeatzailea.getInstantzia().hitzorduaAldatu(
						((Terapeuta) terapeutaBox.getSelectedItem()).getNan(),
						dataOrdua, aurrekoTer);
				setVisible(false);
			}
		});
		btnGorde.setBounds(175, 61, 117, 25);
		getContentPane().add(btnGorde);

		JLabel img = new JLabel("");
		img.setBounds(405, 30, 50, 49);
		img.setIcon(new ImageIcon(imagen));
		getContentPane().add(img);

		JLabel lblTerapeutak = new JLabel("Terapeutak:");
		lblTerapeutak.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblTerapeutak.setBounds(12, 17, 117, 19);
		getContentPane().add(lblTerapeutak);
		// TODO Auto-generated constructor stub
	}
}
