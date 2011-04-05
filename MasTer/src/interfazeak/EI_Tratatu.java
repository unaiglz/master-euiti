package interfazeak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.Font;

import kudeatzaileak.BezeroKudeatzaile;
import kudeatzaileak.HitzorduKudeatzailea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class EI_Tratatu {

	private JFrame frmTratatuHitzordua;
	private String dataOrdua;
	private String terapeutaID;
	private String bezeroID;
	private String terapiaMotaID;
	private String idatzitakoOharra = null;
	private EI_Tratatu instantzia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_Tratatu window = new EI_Tratatu("2011-11-11", "1234182",
							"12345678", "Thai Dantza");
					window.frmTratatuHitzordua.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public EI_Tratatu(String dataOrdua, String terapeutaID, String bezeroID,
			String terapiaMotaID) {
		this.dataOrdua = dataOrdua;
		this.bezeroID = bezeroID;
		this.terapeutaID = terapeutaID;
		this.terapiaMotaID = terapiaMotaID;
		instantzia = this;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTratatuHitzordua = new JFrame();
		frmTratatuHitzordua.setTitle("Tratatu Hitzordua");
		BufferedImage imagen = Cargador.getImagen("Images/icon.png");
		frmTratatuHitzordua.setIconImage(imagen);
		frmTratatuHitzordua.setBounds(100, 100, 450, 300);
		frmTratatuHitzordua.setSize(671, 433);
		frmTratatuHitzordua.setVisible(true);
		frmTratatuHitzordua.getContentPane().setLayout(null);

		labelHasieraketa();

		infoLblHasieraketa();

		botoiHasieraketa();

		imgHasieraketa();
	}

	private void imgHasieraketa() {
		JLabel img = new JLabel("");
		BufferedImage imagen1 = Cargador.getImagen("Images/terapia.png");
		img.setIcon(new ImageIcon(
				imagen1));
		img.setBounds(12, 103, 192, 197);
		frmTratatuHitzordua.getContentPane().add(img);

		JLabel img2 = new JLabel("");
		BufferedImage imagen2 = Cargador.getImagen("Images/icon.png");
		img2.setIcon(new ImageIcon(
				imagen2));
		img2.setBounds(176, 12, 50, 49);
		frmTratatuHitzordua.getContentPane().add(img2);

		JLabel img3 = new JLabel("");
		img3.setIcon(new ImageIcon(
				imagen2));
		img3.setBounds(422, 12, 50, 49);
		frmTratatuHitzordua.getContentPane().add(img3);
	}

	private void infoLblHasieraketa() {
		JLabel dataOrduInfoLbl = new JLabel(dataOrdua);
		dataOrduInfoLbl
				.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		dataOrduInfoLbl.setBounds(454, 70, 96, 15);
		frmTratatuHitzordua.getContentPane().add(dataOrduInfoLbl);

		JLabel bezeroInfoLbl = new JLabel(BezeroKudeatzaile.getInstantzia()
				.lortuIzena(bezeroID));
		bezeroInfoLbl.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		bezeroInfoLbl.setBounds(454, 153, 96, 15);
		frmTratatuHitzordua.getContentPane().add(bezeroInfoLbl);

		JLabel terapMotaInfoLbl = new JLabel(terapiaMotaID);
		terapMotaInfoLbl
				.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		terapMotaInfoLbl.setBounds(454, 236, 96, 15);
		frmTratatuHitzordua.getContentPane().add(terapMotaInfoLbl);
	}

	private void botoiHasieraketa() {
		JButton btnOharraGehitu = new JButton("Oharra Gehitu");
		btnOharraGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EI_Oharra_Gehitu(instantzia);
			}
		});
		btnOharraGehitu.setBounds(454, 311, 158, 25);
		frmTratatuHitzordua.getContentPane().add(btnOharraGehitu);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HitzorduKudeatzailea.getInstantzia().hitzorduaTratatuta(
						dataOrdua, terapeutaID, bezeroID, terapiaMotaID,
						idatzitakoOharra);
				frmTratatuHitzordua.setVisible(false);
			}
		});
		btnOnartu.setBounds(204, 364, 117, 25);
		frmTratatuHitzordua.getContentPane().add(btnOnartu);

		JButton btnEzeztatu = new JButton("Ezeztatu");
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmTratatuHitzordua.setVisible(false);
			}
		});
		btnEzeztatu.setBounds(385, 364, 117, 25);
		frmTratatuHitzordua.getContentPane().add(btnEzeztatu);
	}

	private void labelHasieraketa() {
		JLabel lblDataordua = new JLabel("DataOrdua:");
		lblDataordua.setBounds(221, 70, 96, 15);
		frmTratatuHitzordua.getContentPane().add(lblDataordua);

		JLabel lblNewLabel = new JLabel("Bezeroa:");
		lblNewLabel.setBounds(221, 153, 96, 15);
		frmTratatuHitzordua.getContentPane().add(lblNewLabel);

		JLabel lblTerapiamota = new JLabel("TerapiaMota:");
		lblTerapiamota.setBounds(221, 236, 96, 15);
		frmTratatuHitzordua.getContentPane().add(lblTerapiamota);

		JLabel lblOharra = new JLabel("Oharra:");
		lblOharra.setBounds(221, 316, 110, 15);
		frmTratatuHitzordua.getContentPane().add(lblOharra);
	}

	public void setIdatzitakoOharra(String text) {
		this.idatzitakoOharra = text;

	}
}
