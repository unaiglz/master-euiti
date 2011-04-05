package interfazeak;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import klinikakoInterfaz.EI_Idazkaria;
import java.awt.Toolkit;

public class EI_TerapeutaOndoSartuDa{

	private JFrame frmTerapeutaGehituta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutaOndoSartuDa window = new EI_TerapeutaOndoSartuDa();
					window.frmTerapeutaGehituta.setVisible(true);
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
		frmTerapeutaGehituta = new JFrame();
		BufferedImage imagen = Cargador.getImagen("Images/info_icon.png");
		frmTerapeutaGehituta.setIconImage(imagen);
		frmTerapeutaGehituta.setTitle("Terapeuta Gehituta");
		frmTerapeutaGehituta.setBounds(100, 100, 200, 200);
		frmTerapeutaGehituta.getContentPane().setLayout(null);
		
		JLabel lblTerapeutaOndoSartu = new JLabel("Terapeuta ondo gehitu da");
		lblTerapeutaOndoSartu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTerapeutaOndoSartu.setBounds(106, 12, 230, 61);
		frmTerapeutaGehituta.getContentPane().add(lblTerapeutaOndoSartu);
		
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_Idazkaria eiIdazkaria = new EI_Idazkaria();
			}
		});
		btnOnartu.setBounds(106, 85, 123, 23);
		frmTerapeutaGehituta.getContentPane().add(btnOnartu);
		
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(
		imagen));
		img.setBounds(28, 18, 49, 48);
		frmTerapeutaGehituta.getContentPane().add(img);
		frmTerapeutaGehituta.setSize(329,167);
		frmTerapeutaGehituta.setVisible(true);
	}
}
