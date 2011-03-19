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

public class EI_TerapeutaZerrenda {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutaZerrenda window = new EI_TerapeutaZerrenda(null);
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTerapeutenZerrenda = new JLabel("Terapeuten zerrenda:");
		lblTerapeutenZerrenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTerapeutenZerrenda.setBounds(144, 7, 155, 38);
		frame.getContentPane().add(lblTerapeutenZerrenda);
		
		
		//TextArean terapeutan sartuko ditut
		String textuOsoa = "";
		for (int i = 0; i < terapeutaZerrenda.size(); i = i + 2) {
			String Nan = terapeutaZerrenda.get(i);
			String izena = terapeutaZerrenda.get(i+1);
			String lerroa = "Nan:\t" + Nan + "Izena:\t" + izena;
			textuOsoa = textuOsoa + lerroa;			
		}		
		JTextArea textArea = new JTextArea(textuOsoa);
		textArea.setBounds(30, 56, 380, 298);
		frame.getContentPane().add(textArea);
		
		
		
		
		JLabel lblTerapeutarenNanaSartu = new JLabel("Terapeutaren Nan-a sartu:");
		lblTerapeutarenNanaSartu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTerapeutarenNanaSartu.setBounds(30, 365, 161, 31);
		frame.getContentPane().add(lblTerapeutarenNanaSartu);
		
		textField = new JTextField();
		textField.setBounds(215, 370, 195, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Idazkariak terapeutaren Nan-a sartezn duenean 
				//bere informazio pertsonala ikusi beharko litzateke.
				
				
				String Nan = textField.getText();
				String k1 = " SELECT * FROM Erabiltzailea WHERE Nan=" + Nan;
				DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
				ResultSet emaitza1 = dbk.execSQL(k1);
				try {
					emaitza1.next();
					String izena = emaitza1.getString("izena");
					String helbidea = emaitza1.getString("helbidea");
					//egoera boolean bezala hartu da, baina hau aldatu behar da
					Boolean egoera = emaitza1.getBoolean("Aktiboa");
					EI_TerapeutarenInformazioPertsonala eiInformazioPertsonala = 
						new EI_TerapeutarenInformazioPertsonala(Nan, izena, helbidea, egoera);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
			}
		});
		btnOnartu.setBounds(102, 414, 89, 23);
		frame.getContentPane().add(btnOnartu);
		
		JButton btnEzeztatu = new JButton("Ezeztatu");
		btnEzeztatu.setBounds(215, 414, 89, 23);
		frame.getContentPane().add(btnEzeztatu);
	}
}
