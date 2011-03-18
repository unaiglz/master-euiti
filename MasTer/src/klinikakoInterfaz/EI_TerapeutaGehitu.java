package klinikakoInterfaz;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EI_TerapeutaGehitu {

	private JFrame frame;
	private JPanel panel_1;
	private JTextPane txtpnSartuTerapeutarenDatuak;
	private JTextPane txtpnNan;
	private JTextPane txtpnPasahitza;
	private JTextPane txtpnIzena;
	private JTextPane txtpnHelbidea;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textfield_3;
	private JButton OnartuBotoia;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutaGehitu window = new EI_TerapeutaGehitu();
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
	public EI_TerapeutaGehitu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 292, 266);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtpnSartuTerapeutarenDatuak = new JTextPane();
		txtpnSartuTerapeutarenDatuak.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnSartuTerapeutarenDatuak.setEditable(false);
		txtpnSartuTerapeutarenDatuak.setText("Sartu terapeutaren datuak");
		txtpnSartuTerapeutarenDatuak.setBounds(74, 23, 167, 20);
		panel_1.add(txtpnSartuTerapeutarenDatuak);
		
		txtpnNan = new JTextPane();
		txtpnNan.setEditable(false);
		txtpnNan.setText("NAN:");
		txtpnNan.setBounds(10, 100, 79, 20);
		panel_1.add(txtpnNan);
		
		txtpnPasahitza = new JTextPane();
		txtpnPasahitza.setEditable(false);
		txtpnPasahitza.setText("Pasahitza:");
		txtpnPasahitza.setBounds(10, 131, 79, 20);
		panel_1.add(txtpnPasahitza);
		
		txtpnIzena = new JTextPane();
		txtpnIzena.setEditable(false);
		txtpnIzena.setText("Izena:");
		txtpnIzena.setBounds(10, 69, 79, 20);
		panel_1.add(txtpnIzena);
		
		txtpnHelbidea = new JTextPane();
		txtpnHelbidea.setEditable(false);
		txtpnHelbidea.setText("Helbidea:");
		txtpnHelbidea.setBounds(10, 162, 79, 20);
		panel_1.add(txtpnHelbidea);
		
				
		textField = new JTextField();
		textField.setBounds(99, 69, 183, 20);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 100, 183, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 131, 183, 20);
		panel_1.add(textField_2);
		
		OnartuBotoia = new JButton("Onartu");
		/**
		 * Erabiltzaile kudeatzaileari sartutako datuekin 
		 * terapeuta berri bat sartzeko esango dio
		 */
		OnartuBotoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ErabiltzaileKudeatzaile.getInstantzia().terapeutaGehitu(textField.getText(),
						textField_1.getText(), textField_2.getText(), textfield_3.getText());				
			}
		});
		
		textfield_3 = new JTextField();
		textfield_3.setBounds(99, 162, 183, 20);
		panel_1.add(textfield_3);
		OnartuBotoia.setBounds(109, 193, 79, 23);
		panel_1.add(OnartuBotoia);
	}
}
