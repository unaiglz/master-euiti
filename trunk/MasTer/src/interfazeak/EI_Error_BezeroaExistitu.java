package interfazeak;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

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
		frmErrorea.setIconImage(Toolkit.getDefaultToolkit().getImage("/home/unai/workspace/Master/Marrazkiak/error_icon.png"));
		frmErrorea.setTitle("ERROREA");
		frmErrorea.setBounds(100, 100, 355, 160);
		frmErrorea.getContentPane().setLayout(null);
		
		JLabel lblBezeroaExistitzenDa = new JLabel("Bezeroa jada sisteman dago");
		lblBezeroaExistitzenDa.setBounds(96, 28, 211, 15);
		frmErrorea.getContentPane().add(lblBezeroaExistitzenDa);
		
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmErrorea.setVisible(false);
			}
		});
		btnOnartu.setBounds(143, 67, 117, 25);
		frmErrorea.getContentPane().add(btnOnartu);
		
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(
		"/home/unai/workspace/Master/Marrazkiak/error_icon.png"));
		img.setBounds(26, 10, 48, 49);
		frmErrorea.getContentPane().add(img);
	}
}
