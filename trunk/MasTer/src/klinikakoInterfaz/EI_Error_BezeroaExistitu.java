package klinikakoInterfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EI_Error_BezeroaExistitu {

	JFrame frmErrorea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_Error_BezeroaExistitu window = new EI_Error_BezeroaExistitu();
					window.frmErrorea.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EI_Error_BezeroaExistitu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmErrorea = new JFrame();
		frmErrorea.setTitle("ERROREA");
		frmErrorea.setBounds(100, 100, 298, 160);
		frmErrorea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmErrorea.getContentPane().setLayout(null);
		
		JLabel lblBezeroaExistitzenDa = new JLabel("Bezeroa existitzen da");
		lblBezeroaExistitzenDa.setBounds(69, 27, 191, 15);
		frmErrorea.getContentPane().add(lblBezeroaExistitzenDa);
		
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmErrorea.setVisible(false);
			}
		});
		btnOnartu.setBounds(93, 75, 117, 25);
		frmErrorea.getContentPane().add(btnOnartu);
	}
}
