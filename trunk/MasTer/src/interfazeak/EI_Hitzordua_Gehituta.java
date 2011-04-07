package interfazeak;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;

import datuBaseKonexioa.Cargador;

import kudeatzaileak.BezeroKudeatzaile;
import kudeatzaileak.TerapeutaKudeatzaile;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EI_Hitzordua_Gehituta extends JFrame {

	public EI_Hitzordua_Gehituta(String nanZenbakia, String data, String ordua,
			String terapeutaID, String terapiaMota) {
		setIconImage(Cargador.getImagen("Images/icon.png"));
		setTitle("Hitzordua Gehituta");
		getContentPane().setLayout(null);
		setSize(417,417);

		lblHasieraketa();

		infoLblHasieraketa(nanZenbakia, data, ordua, terapeutaID, terapiaMota);

		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(Cargador.getImagen("Images/info_icon.png")));
		img.setBounds(310, 16, 49, 48);
		getContentPane().add(img);

		JLabel lblHitzorduaGehituDa = new JLabel(
				"Hitzordu berria gehitu egin da:");
		lblHitzorduaGehituDa.setBounds(44, 33, 227, 15);
		getContentPane().add(lblHitzorduaGehituDa);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnOnartu.setBounds(136, 321, 117, 25);
		getContentPane().add(btnOnartu);
		
		setVisible(true);

	}

	private void infoLblHasieraketa(String nanZenbakia, String data,
			String ordua, String terapeutaID, String terapiaMota) {
		JLabel bezeroInfoLbl = new JLabel(BezeroKudeatzaile.getInstantzia()
				.lortuIzena(nanZenbakia));
		bezeroInfoLbl.setBounds(233, 81, 137, 15);
		getContentPane().add(bezeroInfoLbl);

		JLabel terapeutaInfoLbl = new JLabel(TerapeutaKudeatzaile
				.getInstantzia().lortuIzena(terapeutaID));
		terapeutaInfoLbl.setBounds(233, 129, 137, 15);
		getContentPane().add(terapeutaInfoLbl);

		JLabel terapiaInfoLbl = new JLabel(terapiaMota);
		terapiaInfoLbl.setBounds(233, 177, 137, 15);
		getContentPane().add(terapiaInfoLbl);

		JLabel dataInfoLbl = new JLabel(data);
		dataInfoLbl.setBounds(233, 225, 137, 15);
		getContentPane().add(dataInfoLbl);

		JLabel orduInfolbl = new JLabel(ordua);
		orduInfolbl.setBounds(233, 273, 137, 15);
		getContentPane().add(orduInfolbl);
	}

	private void lblHasieraketa() {
		JLabel lblBezeroa = new JLabel("Bezeroa:");
		lblBezeroa.setBounds(44, 81, 70, 15);
		getContentPane().add(lblBezeroa);

		JLabel lblTerapeuta = new JLabel("Terapeuta:");
		lblTerapeuta.setBounds(44, 129, 98, 15);
		getContentPane().add(lblTerapeuta);

		JLabel lblTerapia = new JLabel("Terapia:");
		lblTerapia.setBounds(44, 177, 70, 15);
		getContentPane().add(lblTerapia);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(44, 225, 70, 15);
		getContentPane().add(lblData);

		JLabel lblOrdua = new JLabel("Ordua:");
		lblOrdua.setBounds(44, 273, 70, 15);
		getContentPane().add(lblOrdua);
	}
}
