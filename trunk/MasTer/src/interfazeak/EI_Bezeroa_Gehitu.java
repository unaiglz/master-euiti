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

public class EI_Bezeroa_Gehitu {

	private JFrame frmBezeroaGehitu;
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
		frmBezeroaGehitu.setTitle("Bezeroa gehitu");
		frmBezeroaGehitu.setBounds(100, 100, 450, 300);
		frmBezeroaGehitu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBezeroaGehitu.getContentPane().setLayout(null);
		
		nanField = new JTextField();
		nanField.setBounds(184, 50, 164, 19);
		frmBezeroaGehitu.getContentPane().add(nanField);
		nanField.setColumns(10);
		
		izenaField = new JTextField();
		izenaField.setBounds(184, 93, 164, 19);
		frmBezeroaGehitu.getContentPane().add(izenaField);
		izenaField.setColumns(10);
		
		helbideaField = new JTextField();
		helbideaField.setBounds(184, 138, 164, 19);
		frmBezeroaGehitu.getContentPane().add(helbideaField);
		helbideaField.setColumns(10);
		
		jaiotzeField = new JTextField();
		jaiotzeField.setBounds(184, 181, 164, 19);
		frmBezeroaGehitu.getContentPane().add(jaiotzeField);
		jaiotzeField.setColumns(10);
		
		JLabel lblNan = new JLabel("NAN:");
		lblNan.setBounds(78, 54, 70, 15);
		frmBezeroaGehitu.getContentPane().add(lblNan);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(78, 97, 70, 15);
		frmBezeroaGehitu.getContentPane().add(lblIzena);
		
		JLabel lblHelbidea = new JLabel("Helbidea:");
		lblHelbidea.setBounds(78, 142, 70, 15);
		frmBezeroaGehitu.getContentPane().add(lblHelbidea);
		
		JLabel lblJaiotzeData = new JLabel("Jaiotze data:");
		lblJaiotzeData.setBounds(78, 183, 102, 15);
		frmBezeroaGehitu.getContentPane().add(lblJaiotzeData);
		
		JButton btnGehitu = new JButton("Gehitu");
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (izenaField.getText().equals("")
					||nanField.getText().equals("")
					|| helbideaField.getText().equals("") || jaiotzeField.getText().equals("")) {
				new EI_Error_Hutsuneak();
				nanField.requestFocus();
			} else if(BezeroKudeatzaile.getInstantzia().bezeroaBilatu(nanField.getText())){
				EI_Error_BezeroaExistitu errorea = new EI_Error_BezeroaExistitu();
				frmBezeroaGehitu.setVisible(false);
				errorea.frmErrorea.setVisible(true);
				
				
			}else{
			
				BezeroKudeatzaile.getInstantzia().bezeroaGehitu(
						nanField.getText(),
						izenaField.getText(),
						jaiotzeField.getText(),helbideaField.getText()
						);
				frmBezeroaGehitu.setVisible(false);
			
				EI_BezeroaGehituta bezeroaGehituta = new EI_BezeroaGehituta(nanField.getText(),izenaField.getText(),helbideaField.getText(),jaiotzeField.getText());
			bezeroaGehituta.setVisible(true);
			}
			}
		});
		btnGehitu.setBounds(161, 231, 117, 25);
		frmBezeroaGehitu.getContentPane().add(btnGehitu);
	}
}
