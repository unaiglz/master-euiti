package interfazeak;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.ResultSet;

import klinikakoInterfaz.EI_Idazkaria;
import kudeatzaileak.BezeroKudeatzaile;
import kudeatzaileak.HitzorduKudeatzailea;
import kudeatzaileak.TerapiaMotaKudeatzaile;

import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.awt.Color;
import java.util.Vector;

public class EI_HitzorduaEskatu {

	public JFrame frmHitzorduaGehitu;
	public JTextField nanField;
	private JTextField dateField;
	private JTextField timeField;
	private JComboBox teMoComBox;
	private JLabel errorNanLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_HitzorduaEskatu window = new EI_HitzorduaEskatu();
					window.frmHitzorduaGehitu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EI_HitzorduaEskatu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		interfazeaSortu();

		labelakHasieratu();

		botoiakHasieratu();

		bigarrenInfoa();

		// Egingo duena: TerapiaMota bat hautatzean Formakuntza eta dataOrdua
		// taulan begiratuko du, eta hurrengo ComboBox-ean jarriko ditu hori
		// egin dezaketen Terapeutak, ORDUA-DATA eta TerapiaMota kontuan hartuz.

		// errore Mezu bat sortu esaten duena ez dagoela ezer eskuragarri
		// (POP-UP)
		// eskuragarri dagoen ordua ikusteko, currentDate()-etik aurrera dela
		// begiratu eta dataOrdua-n ez dela agertzen

	}

	private void bigarrenInfoa() {
		JLabel img = new JLabel("");
		img.setBounds(28, 7, 50, 49);
		img.setIcon(new ImageIcon(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		frmHitzorduaGehitu.getContentPane().add(img);

		JLabel lblFormatuaHhmm = new JLabel("Formatua: hh:mm");
		lblFormatuaHhmm.setFont(new Font("Dialog", Font.ITALIC, 9));
		lblFormatuaHhmm.setBounds(284, 188, 85, 15);
		frmHitzorduaGehitu.getContentPane().add(lblFormatuaHhmm);

		JLabel lblFormatuaYyyymm = new JLabel("Formatua: yyyy-mm-dd");
		lblFormatuaYyyymm.setFont(new Font("Dialog", Font.ITALIC, 9));
		lblFormatuaYyyymm.setBounds(284, 135, 125, 15);
		frmHitzorduaGehitu.getContentPane().add(lblFormatuaYyyymm);

		JLabel lblTerapeuta = new JLabel("Terapeuta:");
		lblTerapeuta.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblTerapeuta.setBounds(88, 282, 116, 27);
		frmHitzorduaGehitu.getContentPane().add(lblTerapeuta);

		JLabel lblTerapiaHoriHonako = new JLabel(
				"Terapia hori honako Terapeutek eman dezakete:");
		lblTerapiaHoriHonako.setBounds(28, 257, 368, 15);
		frmHitzorduaGehitu.getContentPane().add(lblTerapiaHoriHonako);
	}

	private void botoiakHasieratu() {
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (BezeroKudeatzaile.getInstantzia().bezeroaBilatu(
						nanField.getText())) {
					HitzorduKudeatzailea.getInstantzia().HitzorduaEskatu(
							nanField.getText(), dateField.getText(),
							timeField.getText(),
							teMoComBox.getSelectedItem().toString());
					frmHitzorduaGehitu.setVisible(false);
				} else {
					errorNanLbl.setText("Nan ez zuzena");
				}
			}
		});
		btnOnartu.setBounds(88, 334, 109, 27);
		frmHitzorduaGehitu.getContentPane().add(btnOnartu);

		JButton btnEzeztatu = new JButton("Ezeztatu");
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmHitzorduaGehitu.setVisible(false);
			}
		});
		btnEzeztatu.setBounds(214, 334, 109, 27);
		frmHitzorduaGehitu.getContentPane().add(btnEzeztatu);
	}

	private void labelakHasieratu() {
		JLabel lblHitzorduEskaera = new JLabel("Hitzordu eskaera");
		lblHitzorduEskaera.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				14));
		lblHitzorduEskaera.setBounds(137, 18, 190, 27);
		frmHitzorduaGehitu.getContentPane().add(lblHitzorduEskaera);

		JLabel lblSartuNanZenbakia = new JLabel("Sartu Nan zenbakia:");
		lblSartuNanZenbakia.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSartuNanZenbakia.setBounds(88, 57, 116, 27);
		frmHitzorduaGehitu.getContentPane().add(lblSartuNanZenbakia);

		JLabel lblSartuData = new JLabel("Sartu data:");
		lblSartuData.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSartuData.setBounds(88, 111, 116, 27);
		frmHitzorduaGehitu.getContentPane().add(lblSartuData);

		JLabel lblSartuOrdua = new JLabel("Sartu ordua:");
		lblSartuOrdua.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSartuOrdua.setBounds(88, 164, 116, 27);
		frmHitzorduaGehitu.getContentPane().add(lblSartuOrdua);

		JLabel lblTerapia = new JLabel("Terapia:");
		lblTerapia.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTerapia.setBounds(88, 215, 116, 27);
		frmHitzorduaGehitu.getContentPane().add(lblTerapia);

		nanField = new JTextField();
		nanField.setBounds(214, 58, 146, 24);
		frmHitzorduaGehitu.getContentPane().add(nanField);
		nanField.setColumns(10);

		dateField = new JTextField();
		dateField.setBounds(214, 112, 146, 24);
		frmHitzorduaGehitu.getContentPane().add(dateField);
		dateField.setColumns(10);

		timeField = new JTextField();
		timeField.setBounds(214, 165, 146, 24);
		frmHitzorduaGehitu.getContentPane().add(timeField);
		timeField.setColumns(10);

		teMoComBox = new JComboBox(TerapiaMotaKudeatzaile.getInstantzia()
				.lortuTerapiak());
		teMoComBox.setBounds(214, 215, 146, 24);
		frmHitzorduaGehitu.getContentPane().add(teMoComBox);

		errorNanLbl = new JLabel("");
		errorNanLbl.setForeground(Color.RED);
		errorNanLbl.setFont(new Font("Dialog", Font.ITALIC, 10));
		errorNanLbl.setBounds(284, 81, 70, 15);
		frmHitzorduaGehitu.getContentPane().add(errorNanLbl);

		JComboBox terapeutaBox = new JComboBox();
		terapeutaBox.setBounds(214, 284, 146, 24);
		frmHitzorduaGehitu.getContentPane().add(terapeutaBox);
	}

	private void interfazeaSortu() {
		frmHitzorduaGehitu = new JFrame();
		frmHitzorduaGehitu.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		frmHitzorduaGehitu.setTitle("Hitzordua Gehitu");
		frmHitzorduaGehitu.setBounds(100, 100, 409, 403);
		frmHitzorduaGehitu.getContentPane().setLayout(null);
	}
}
