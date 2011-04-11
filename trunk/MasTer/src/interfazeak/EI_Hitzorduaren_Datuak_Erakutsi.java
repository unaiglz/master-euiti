package interfazeak;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import datuBaseKonexioa.Cargador;
import datuBaseKonexioa.DBKudeatzaile;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import kudeatzaileak.TerapeutaKudeatzaile;
import java.awt.Toolkit;

public class EI_Hitzorduaren_Datuak_Erakutsi extends JFrame {

	private JLabel lblHitzorduarenDatuak;
	private JLabel lblData;
	private JLabel lblOrdua;
	private JLabel lblTerapeuta;
	private JLabel lblBezeroa;
	private JLabel lblTerapia;
	private JLabel lblData2;
	private JLabel lblOrdua2;
	private JLabel lblTerapeuta2;
	private JLabel lblBezeroa2;
	private JLabel lblTerapia2;
	private JLabel lblOharra2;
	private JLabel lblOrdainduta2;
	private JButton btnOnartu;
	private JButton btnDataAldatu;
	private JButton btnTerapeutaAldatu;
	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

	private void terapeutaPosibleakLortu() {
		new EI_Terapeutak(TerapeutaKudeatzaile.getInstantzia()
				.terapeutaLibreakLortu(lblData2.getText(), lblOrdua2.getText(),
						lblTerapia2.getText()), lblData2.getText(),
				lblOrdua2.getText(), lblTerapeuta2.getText());
		setVisible(false);

	}

	private void agendaKontsultatu() {
		String dataOrdua=lblData2.getText() + " " + lblOrdua2.getText();
		EI_AgendaDataOrduaAldatu agenda = new EI_AgendaDataOrduaAldatu(lblTerapeuta2.getText(),dataOrdua);
		setVisible(false);	
	}

	public EI_Hitzorduaren_Datuak_Erakutsi(Vector<String> datuak) {
		BufferedImage imagen = Cargador.getImagen("Images/icon.png");
		setIconImage(imagen);
		setTitle("Hitzordua: Aldaketa Eskaera");
		getContentPane().setLayout(null);
		setSize(463, 403);
		setVisible(true);
		lblHitzorduarenDatuak = new JLabel("Hitzorduaren datuak");
		lblHitzorduarenDatuak.setFont(new Font("Tahoma", Font.BOLD
				| Font.ITALIC, 14));
		lblHitzorduarenDatuak.setBounds(123, 10, 178, 31);
		getContentPane().add(lblHitzorduarenDatuak);

		lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblData.setBounds(44, 53, 119, 31);
		getContentPane().add(lblData);

		lblOrdua = new JLabel("Ordua:");
		lblOrdua.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblOrdua.setBounds(44, 112, 119, 31);
		getContentPane().add(lblOrdua);

		lblTerapeuta = new JLabel("Terapeuta:");
		lblTerapeuta.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTerapeuta.setBounds(44, 171, 119, 31);
		getContentPane().add(lblTerapeuta);

		lblBezeroa = new JLabel("Bezeroa:");
		lblBezeroa.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBezeroa.setBounds(44, 230, 119, 31);
		getContentPane().add(lblBezeroa);

		lblTerapia = new JLabel("Terapia:");
		lblTerapia.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTerapia.setBounds(44, 289, 119, 31);
		getContentPane().add(lblTerapia);

		lblData2 = new JLabel(datuak.get(0));
		lblData2.setBounds(141, 52, 153, 31);
		getContentPane().add(lblData2);

		lblOrdua2 = new JLabel(datuak.get(1));
		lblOrdua2.setBounds(141, 111, 153, 31);
		getContentPane().add(lblOrdua2);

		lblTerapeuta2 = new JLabel(datuak.get(2));
		lblTerapeuta2.setBounds(141, 170, 153, 31);
		getContentPane().add(lblTerapeuta2);

		lblBezeroa2 = new JLabel(datuak.get(3));
		lblBezeroa2.setBounds(141, 229, 153, 31);
		getContentPane().add(lblBezeroa2);

		lblTerapia2 = new JLabel(datuak.get(4));
		lblTerapia2.setBounds(141, 288, 153, 31);
		getContentPane().add(lblTerapia2);

		/*
		 * lblOharra2 = new JLabel(datuak.get(5)); lblOharra2.setBounds(141,
		 * 347, 153, 31); getContentPane().add(lblOharra2);
		 * 
		 * lblOrdainduta2 = new JLabel(datuak.get(6));
		 * lblOrdainduta2.setBounds(141, 406, 153, 31);
		 * getContentPane().add(lblOrdainduta2);
		 */

		btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnOnartu.setBounds(175, 331, 89, 23);
		getContentPane().add(btnOnartu);

		btnDataAldatu = new JButton("Data aldatu");
		btnDataAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agendaKontsultatu();
			}

		});
		btnDataAldatu.setBounds(272, 84, 164, 23);
		getContentPane().add(btnDataAldatu);

		btnTerapeutaAldatu = new JButton("Terapeuta aldatu");
		btnTerapeutaAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				terapeutaPosibleakLortu();
			}
		});
		btnTerapeutaAldatu.setBounds(272, 174, 164, 23);
		getContentPane().add(btnTerapeutaAldatu);

	}
}
