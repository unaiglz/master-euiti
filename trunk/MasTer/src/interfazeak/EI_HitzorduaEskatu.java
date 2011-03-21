package interfazeak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;

import klinikakoInterfaz.EI_Idazkaria;
import kudeatzaileak.HitzorduKudeatzailea;

public class EI_HitzorduaEskatu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_HitzorduaEskatu window = new EI_HitzorduaEskatu();
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
	public EI_HitzorduaEskatu() {
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
		
		JLabel lblHitzorduEskaera = new JLabel("Hitzordu eskaera");
		lblHitzorduEskaera.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblHitzorduEskaera.setBounds(92, 11, 125, 27);
		frame.getContentPane().add(lblHitzorduEskaera);
		
		JLabel lblSartuNanZenbakia = new JLabel("Sartu Nan zenbakia:");
		lblSartuNanZenbakia.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSartuNanZenbakia.setBounds(10, 68, 116, 27);
		frame.getContentPane().add(lblSartuNanZenbakia);
		
		JLabel lblSartuData = new JLabel("Sartu data:");
		lblSartuData.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSartuData.setBounds(10, 106, 116, 32);
		frame.getContentPane().add(lblSartuData);
		
		JLabel lblSartuOrdua = new JLabel("Sartu ordua:");
		lblSartuOrdua.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSartuOrdua.setBounds(10, 149, 116, 24);
		frame.getContentPane().add(lblSartuOrdua);
		
		JLabel lblTerapia = new JLabel("Terapia:");
		lblTerapia.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTerapia.setBounds(10, 184, 116, 27);
		frame.getContentPane().add(lblTerapia);
		
		textField = new JTextField();
		textField.setBounds(136, 71, 146, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(136, 110, 146, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);		
		
		textField_2 = new JTextField();
		textField_2.setBounds(136, 147, 146, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(136, 182, 146, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HitzorduKudeatzailea.getInstantzia().HitzorduaEskatu(textField.getText(), 
						textField_1.getText(), textField_2.getText(), textField_3.getText());
			}
		});
		btnOnartu.setBounds(27, 228, 109, 27);
		frame.getContentPane().add(btnOnartu);
		
		JButton btnEzeztatu = new JButton("Ezeztatu");
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_Idazkaria eiIdazkaria = new EI_Idazkaria();
			}
		});
		btnEzeztatu.setBounds(146, 228, 109, 27);
		frame.getContentPane().add(btnEzeztatu);
		
		
		
		
		
		
	}
}
