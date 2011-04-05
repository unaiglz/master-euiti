package interfazeak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class EI_Trataketa_Amaitua {

	private JFrame frmHitzorduAmaiera;
	private String dataOrdua;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//EI_Trataketa_Amaitua window = new EI_Trataketa_Amaitua();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param terapiaMotaID 
	 * @param bezeroID 
	 * @param terapeutaID 
	 * @param dataOrdua 
	 * @wbp.parser.entryPoint
	 */
	public EI_Trataketa_Amaitua(String dataOrdua) {
		this.dataOrdua= dataOrdua;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHitzorduAmaiera = new JFrame();
		BufferedImage imagen = Cargador.getImagen("Images/icon.png");
		frmHitzorduAmaiera.setIconImage(imagen);
		frmHitzorduAmaiera.setTitle("Hitzordu Amaiera");
		frmHitzorduAmaiera.setBounds(100, 100, 450, 300);
		frmHitzorduAmaiera.setVisible(true);
		frmHitzorduAmaiera.setSize(412,163);
		frmHitzorduAmaiera.getContentPane().setLayout(null);
		
		JLabel img = new JLabel("");
		BufferedImage imagen1 = Cargador.getImagen("Images/info_icon.png");
		img.setIcon(new ImageIcon(
		imagen1));
		img.setBounds(19, 11, 49, 48);
		frmHitzorduAmaiera.getContentPane().add(img);
		
		JLabel infoLbl = new JLabel(dataOrdua + "-ko \nHitzordua amaitu da");
		infoLbl.setBounds(87, 20, 304, 31);
		frmHitzorduAmaiera.getContentPane().add(infoLbl);
		
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmHitzorduAmaiera.setVisible(false);
			}
		});
		btnOnartu.setFont(new Font("Dialog", Font.BOLD, 13));
		btnOnartu.setBounds(146, 78, 117, 25);
		frmHitzorduAmaiera.getContentPane().add(btnOnartu);
	}

}
