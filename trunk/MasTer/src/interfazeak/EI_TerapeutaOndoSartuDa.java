package interfazeak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import klinikakoInterfaz.EI_Idazkaria;

public class EI_TerapeutaOndoSartuDa {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutaOndoSartuDa window = new EI_TerapeutaOndoSartuDa();
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
	public EI_TerapeutaOndoSartuDa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTerapeutaOndoSartu = new JLabel("Terapeuta ondo sartu da");
		lblTerapeutaOndoSartu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTerapeutaOndoSartu.setBounds(20, 11, 162, 61);
		frame.getContentPane().add(lblTerapeutaOndoSartu);
		
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_Idazkaria eiIdazkaria = new EI_Idazkaria();
			}
		});
		btnOnartu.setBounds(42, 109, 123, 23);
		frame.getContentPane().add(btnOnartu);
	}
}
