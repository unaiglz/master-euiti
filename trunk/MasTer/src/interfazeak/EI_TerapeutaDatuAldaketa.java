package interfazeak;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPasswordField;

import datuBaseKonexioa.Cargador;

import kudeatzaileak.TerapeutaKudeatzaile;
import java.awt.Font;

public class EI_TerapeutaDatuAldaketa extends JFrame {
	private JTextField textIzena;
	private JTextField textHelbidea;
	JComboBox aktiBox;
	private JTextField textJaioD;

	public EI_TerapeutaDatuAldaketa(final String id, String izena,
			String helbidea, String jaiotzeData, int aktiboa) {
		BufferedImage imagen = Cargador.getImagen("Images/info_icon.png");
		setIconImage(imagen);
		setTitle("Terapeuta Datuak");
		getContentPane().setLayout(null);

		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(44, 63, 70, 19);
		getContentPane().add(lblIzena);

		JLabel lblHelbidea = new JLabel("Helbidea:");
		lblHelbidea.setBounds(44, 107, 70, 19);
		getContentPane().add(lblHelbidea);

		JLabel lblAktiboa = new JLabel("Aktiboa:");
		lblAktiboa.setBounds(44, 199, 70, 15);
		getContentPane().add(lblAktiboa);

		textIzena = new JTextField(izena);
		textIzena.setBounds(161, 63, 197, 19);
		getContentPane().add(textIzena);
		textIzena.setColumns(10);

		textHelbidea = new JTextField(helbidea);
		textHelbidea.setColumns(10);
		textHelbidea.setBounds(161, 107, 197, 19);
		getContentPane().add(textHelbidea);
		textHelbidea.setText(helbidea);

		aktiBox = new JComboBox();
		aktiBox.setModel(new DefaultComboBoxModel(new String[] { "Bai", "Ez" }));
		aktiBox.setBounds(161, 194, 57, 24);
		getContentPane().add(aktiBox);
		if (aktiboa == 0) {
			aktiBox.setSelectedItem("Bai");
		} else {
			aktiBox.setSelectedItem("Ez");
		}

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textIzena.getText().equals("")
						|| textHelbidea.getText().equals("")
						|| textJaioD.getText().equals("")) {
					new EI_Error_Hutsuneak();
					textIzena.requestFocus();
				} else {
					if (aktiBox.getSelectedItem() == "Bai") {
						TerapeutaKudeatzaile.getInstantzia().terapeutaAldatu(
								id, textIzena.getText(),
								textHelbidea.getText(), textJaioD.getText(), 0);
					} else {
						TerapeutaKudeatzaile.getInstantzia().terapeutaAldatu(
								id, textIzena.getText(),
								textHelbidea.getText(), textJaioD.getText(), 1);
					}

					setVisible(false);
				}
			}
		});
		btnOnartu.setBounds(144, 291, 117, 25);
		getContentPane().add(btnOnartu);

		JLabel image = new JLabel("");
		image.setBounds(363, 12, 57, 49);
		image.setIcon(new ImageIcon(imagen));
		getContentPane().add(image);

		JLabel lblTerapeutarenDatuenAldaketa = new JLabel(
				"Terapeutaren datuen aldaketa hemen egin:");
		lblTerapeutarenDatuenAldaketa.setBounds(33, 12, 325, 15);
		getContentPane().add(lblTerapeutarenDatuenAldaketa);

		JLabel lblJaiotzeData = new JLabel("Jaiotze Data:");
		lblJaiotzeData.setBounds(44, 151, 110, 19);
		getContentPane().add(lblJaiotzeData);

		textJaioD = new JTextField(jaiotzeData);
		textJaioD.setColumns(10);
		textJaioD.setBounds(161, 151, 197, 19);
		getContentPane().add(textJaioD);
		textJaioD.setText(jaiotzeData);

		JButton btnPassAldatu = new JButton("Pass Aldatu");
		btnPassAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EI_Pasahitza_Aldatu(id);
			}
		});
		btnPassAldatu.setBounds(161, 238, 144, 25);
		getContentPane().add(btnPassAldatu);

		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(44, 243, 99, 15);
		getContentPane().add(lblPasahitza);

		JLabel lblFormatuaYyyymmdd = new JLabel("formatua: yyyy-mm-dd");
		lblFormatuaYyyymmdd.setFont(new Font("Dialog", Font.ITALIC, 10));
		lblFormatuaYyyymmdd.setBounds(241, 172, 117, 15);
		getContentPane().add(lblFormatuaYyyymmdd);

		textIzena.requestFocus();
		setVisible(true);
		setSize(422, 373);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutaDatuAldaketa frame = new EI_TerapeutaDatuAldaketa(
							"90897867X", "Sandalio Botín Descalzo",
							"Ibarrangelu", "1987-09-28", 1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
