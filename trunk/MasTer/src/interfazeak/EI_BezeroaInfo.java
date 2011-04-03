package interfazeak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.mysql.jdbc.ResultSet;

import datuBaseKonexioa.DBKudeatzaile;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EI_BezeroaInfo {

	private JFrame frmBezeroarenInformazioa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_BezeroaInfo window = new EI_BezeroaInfo(null);
					window.frmBezeroarenInformazioa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public EI_BezeroaInfo(String nan) throws SQLException {
		initialize(nan);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize(String nan) throws SQLException {
		frmBezeroarenInformazioa = new JFrame();
		frmBezeroarenInformazioa.setTitle("Bezeroaren Informazioa");
		frmBezeroarenInformazioa.setBounds(100, 100, 450, 300);
		frmBezeroarenInformazioa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBezeroarenInformazioa.getContentPane().setLayout(null);
		frmBezeroarenInformazioa.setVisible(true);
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		// Terapeuta datu-basean dagoen begiratzeko
		String k1 = "SELECT * FROM Bezeroa WHERE NAN= '" + nan + " ' ";

		java.sql.ResultSet emaitza1 = dbk.execSQL(k1);
		emaitza1.next();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 448, 270);
		frmBezeroarenInformazioa.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(238, 32, 157, 20);
		panel.add(textArea);
		textArea.setText(nan);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(238, 78, 157, 20);
		panel.add(textArea_1);
		textArea_1.setText(emaitza1.getString("izena"));
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setBounds(238, 123, 157, 20);
		panel.add(textArea_2);
		textArea_2.setText(emaitza1.getString("jaiotzeData"));
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		textArea_3.setBounds(238, 165, 157, 20);
		panel.add(textArea_3);
		textArea_3.setText(emaitza1.getString("helbidea"));

		
		JLabel lblNan = new JLabel("NAN:");
		lblNan.setBounds(89, 32, 70, 15);
		panel.add(lblNan);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(89, 78, 70, 15);
		panel.add(lblIzena);
		
		JLabel lblJaiotzeData = new JLabel("Jaiotze data:");
		lblJaiotzeData.setBounds(89, 123, 95, 15);
		panel.add(lblJaiotzeData);
		
		JLabel lblHelbidea = new JLabel("Helbidea:");
		lblHelbidea.setBounds(89, 165, 70, 15);
		panel.add(lblHelbidea);
		
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBezeroarenInformazioa.setVisible(true);
			}
		});
		btnOnartu.setBounds(171, 233, 117, 25);
		panel.add(btnOnartu);
	}
}
