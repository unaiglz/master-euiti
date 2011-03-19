package interfazeak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import datuBaseKonexioa.DBKudeatzaile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import kudeatzaileak.ErabiltzaileKudeatzaile;
import kudeatzaileak.TerapeutaKudeatzaile;
import java.awt.Toolkit;

public class EI_TerapeutaZerrenda {
	// Tu aber, no es un JTextArea, es una JTable... asiq ya sabes

	private JFrame frmSistemakoTerapeutak;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutaZerrenda window = new EI_TerapeutaZerrenda(null);
					window.frmSistemakoTerapeutak.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EI_TerapeutaZerrenda(Vector<String> terapeutaZerrenda) {
		initialize(terapeutaZerrenda);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Vector<String> terapeutaZerrenda) {
		frmSistemakoTerapeutak = new JFrame();
		frmSistemakoTerapeutak.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("/home/unai/workspace/Master/Marrazkiak/icon.png"));
		frmSistemakoTerapeutak.setTitle("Sistemako Terapeutak");
		frmSistemakoTerapeutak.setBounds(100, 100, 450, 500);
		frmSistemakoTerapeutak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemakoTerapeutak.getContentPane().setLayout(null);

		JLabel lblTerapeutenZerrenda = new JLabel("Terapeuten zerrenda:");
		lblTerapeutenZerrenda.setFont(new Font("Tahoma", Font.BOLD
				| Font.ITALIC, 14));
		lblTerapeutenZerrenda.setBounds(102, 12, 238, 38);
		frmSistemakoTerapeutak.getContentPane().add(lblTerapeutenZerrenda);

		// TextArean terapeutan sartuko ditut
		String textuOsoa = "";
		for (int i = 0; i < terapeutaZerrenda.size(); i = i + 2) {
			String Nan = terapeutaZerrenda.get(i);
			String izena = terapeutaZerrenda.get(i + 1);
			String lerroa = "Nan:\t" + Nan + "Izena:\t" + izena;
			textuOsoa = textuOsoa + lerroa;
		}
		JTextArea textArea = new JTextArea(textuOsoa);
		textArea.setBounds(30, 56, 380, 298);
		frmSistemakoTerapeutak.getContentPane().add(textArea);

		JLabel lblTerapeutarenNanaSartu = new JLabel(
				"Terapeutaren Nan-a sartu:");
		lblTerapeutarenNanaSartu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTerapeutarenNanaSartu.setBounds(47, 365, 187, 31);
		frmSistemakoTerapeutak.getContentPane().add(lblTerapeutarenNanaSartu);

		textField = new JTextField();
		textField.setBounds(241, 370, 195, 20);
		frmSistemakoTerapeutak.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Idazkariak terapeutaren Nan-a sartezn duenean
				// bere informazio pertsonala ikusi beharko litzateke.

				String Nan = textField.getText();
				String k1 = " SELECT * FROM Erabiltzailea WHERE Nan=" + Nan;
				DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
				ResultSet emaitza1 = dbk.execSQL(k1);
				try {
					emaitza1.next();
					String izena = emaitza1.getString("izena");
					String helbidea = emaitza1.getString("helbidea");
					// egoera boolean bezala hartu da, baina hau aldatu behar da
					Boolean egoera = emaitza1.getBoolean("Aktiboa");
					EI_TerapeutarenInformazioPertsonala eiInformazioPertsonala = new EI_TerapeutarenInformazioPertsonala(
							Nan, izena, helbidea, egoera);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnOnartu.setBounds(89, 414, 102, 23);
		frmSistemakoTerapeutak.getContentPane().add(btnOnartu);

		JButton btnEzeztatu = new JButton("Ezeztatu");
		btnEzeztatu.setBounds(265, 414, 125, 23);
		frmSistemakoTerapeutak.getContentPane().add(btnEzeztatu);
	}
}
