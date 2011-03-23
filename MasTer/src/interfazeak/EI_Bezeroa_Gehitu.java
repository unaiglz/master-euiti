package interfazeak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;

import kudeatzaileak.BezeroKudeatzaile;
import java.awt.Font;
import java.awt.Toolkit;

public class EI_Bezeroa_Gehitu {

	public JFrame frmBezeroaGehitu;
	private JTextField nanField;
	private JTextField izenaField;
	private JTextField helbideaField;
	private JTextField jaiotzeField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_Bezeroa_Gehitu window = new EI_Bezeroa_Gehitu();
					window.frmBezeroaGehitu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EI_Bezeroa_Gehitu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBezeroaGehitu = new JFrame();
		frmBezeroaGehitu.setIconImage(Toolkit.getDefaultToolkit().getImage("/home/unai/workspace/Master/Marrazkiak/icon.png"));
		frmBezeroaGehitu.setTitle("Bezeroa gehitu");
		frmBezeroaGehitu.setBounds(100, 100, 350, 301);
		frmBezeroaGehitu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBezeroaGehitu.getContentPane().setLayout(null);

		nanField = new JTextField();
		nanField.setBounds(128, 33, 164, 19);
		frmBezeroaGehitu.getContentPane().add(nanField);
		nanField.setColumns(10);

		izenaField = new JTextField();
		izenaField.setBounds(128, 76, 164, 19);
		frmBezeroaGehitu.getContentPane().add(izenaField);
		izenaField.setColumns(10);

		helbideaField = new JTextField();
		helbideaField.setBounds(128, 121, 164, 19);
		frmBezeroaGehitu.getContentPane().add(helbideaField);
		helbideaField.setColumns(10);

		jaiotzeField = new JTextField();
		jaiotzeField.setBounds(128, 164, 164, 19);
		frmBezeroaGehitu.getContentPane().add(jaiotzeField);
		jaiotzeField.setColumns(10);

		JLabel lblNan = new JLabel("NAN:");
		lblNan.setBounds(22, 37, 70, 15);
		frmBezeroaGehitu.getContentPane().add(lblNan);

		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(22, 80, 70, 15);
		frmBezeroaGehitu.getContentPane().add(lblIzena);

		JLabel lblHelbidea = new JLabel("Helbidea:");
		lblHelbidea.setBounds(22, 125, 70, 15);
		frmBezeroaGehitu.getContentPane().add(lblHelbidea);

		JLabel lblJaiotzeData = new JLabel("Jaiotze data:");
		lblJaiotzeData.setBounds(22, 166, 102, 15);
		frmBezeroaGehitu.getContentPane().add(lblJaiotzeData);

		JButton btnGehitu = new JButton("Gehitu");
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nanField.getText().length() != 9) {
					new EI_Luzera_Ez_Egokia("nan", 9);
				} else {
					if (izenaField.getText().equals("")
							|| nanField.getText().equals("")
							|| helbideaField.getText().equals("")
							|| jaiotzeField.getText().equals("")) {
						new EI_Error_Hutsuneak();
						nanField.requestFocus();
					} else if (BezeroKudeatzaile.getInstantzia().bezeroaBilatu(
							nanField.getText())) {
						EI_Error_BezeroaExistitu errorea = new EI_Error_BezeroaExistitu();
						frmBezeroaGehitu.setVisible(false);
						errorea.frmErrorea.setVisible(true);

					} else {

						BezeroKudeatzaile.getInstantzia()
								.bezeroaGehitu(nanField.getText(),
										izenaField.getText(),
										jaiotzeField.getText(),
										helbideaField.getText());
						frmBezeroaGehitu.setVisible(false);

						EI_BezeroaGehituta bezeroaGehituta = new EI_BezeroaGehituta(
								nanField.getText(), izenaField.getText(),
								helbideaField.getText(), jaiotzeField.getText());
						bezeroaGehituta.setVisible(true);
					}
				}

			}
		});
		btnGehitu.setBounds(161, 231, 117, 25);
		frmBezeroaGehitu.getContentPane().add(btnGehitu);
		
		JLabel lblFormatuaYyyymmdd = new JLabel("Formatua: YYYY-MM-DD");
		lblFormatuaYyyymmdd.setFont(new Font("Dialog", Font.ITALIC, 10));
		lblFormatuaYyyymmdd.setBounds(200, 195, 136, 15);
		frmBezeroaGehitu.getContentPane().add(lblFormatuaYyyymmdd);
	}
}
