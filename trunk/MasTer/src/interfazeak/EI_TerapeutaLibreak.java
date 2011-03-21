package interfazeak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

import klinikakoInterfaz.EI_Idazkaria;

public class EI_TerapeutaLibreak {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutaLibreak window = new EI_TerapeutaLibreak(null);
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
	public EI_TerapeutaLibreak(Vector<String> terapeutaLibreenZerrenda) {
		initialize(terapeutaLibreenZerrenda);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Vector<String> terapeutaLibreenZerrenda) {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTerapeutaLibreenZerrenda = new JLabel("Terapeuta libreen zerrenda");
		lblTerapeutaLibreenZerrenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTerapeutaLibreenZerrenda.setBounds(58, 11, 191, 28);
		frame.getContentPane().add(lblTerapeutaLibreenZerrenda);
		
		//Terapeuta libreen zerrendako terapeutak String bakar batean sartuko ditugu
		String terapeutak = "";
		String Nan;
		String izena;
		for (int i = 0; i < terapeutaLibreenZerrenda.size(); i = i + 2) {
			Nan = terapeutaLibreenZerrenda.get(i);
			izena = terapeutaLibreenZerrenda.get(i + 1);			
			terapeutak = terapeutak + "Nan zenbakia:\t" + Nan 
			+ "Izena:\t"+ izena + "\n";		
		}
				
		JTextArea textArea = new JTextArea(terapeutak);
		textArea.setBounds(23, 50, 249, 348);
		frame.getContentPane().add(textArea);
		
		JLabel lblTerapeutarenNanaSartu = new JLabel("Terapeutaren Nan-a sartu:");
		lblTerapeutarenNanaSartu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTerapeutarenNanaSartu.setBounds(23, 423, 135, 28);
		frame.getContentPane().add(lblTerapeutarenNanaSartu);
		
		textField = new JTextField();
		textField.setBounds(168, 423, 101, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnOnartu.setBounds(41, 477, 101, 28);
		frame.getContentPane().add(btnOnartu);
		
		JButton btnEzeztatu = new JButton("Ezeztatu");
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_Idazkaria eiIdazkaria = new EI_Idazkaria();
			}
		});
		btnEzeztatu.setBounds(152, 477, 101, 28);
		frame.getContentPane().add(btnEzeztatu);
	}
}
