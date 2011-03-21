package interfazeak;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;

import kudeatzaileak.ErabiltzaileKudeatzaile;
import kudeatzaileak.TerapeutaKudeatzaile;

public class EI_TerapeutaGehitu {

	public JFrame frmTerapeutaGehitu;
	private JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textfield_3;
	private JButton OnartuBotoia;
	private JLabel lblSartuTerapeutarenDatuak;
	private JLabel lblIzena;
	private JLabel lblNan;
	private JLabel lblPasahitza;
	private JLabel lblHelbidea;
	private JLabel image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutaGehitu window = new EI_TerapeutaGehitu();
					window.frmTerapeutaGehitu.setVisible(true);
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
		frmTerapeutaGehitu = new JFrame();
		frmTerapeutaGehitu.setTitle("Terapeuta Gehitu");
		frmTerapeutaGehitu.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		frmTerapeutaGehitu.setBounds(100, 100, 334, 267);
		frmTerapeutaGehitu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTerapeutaGehitu.getContentPane().setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 332, 235);
		frmTerapeutaGehitu.getContentPane().add(panel_1);
		panel_1.setLayout(null);

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
		 * Erabiltzaile kudeatzaileari sartutako datuekin terapeuta berri bat
		 * sartzeko esango dio
		 */
		OnartuBotoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TerapeutaKudeatzaile.getInstantzia().terapeutaGehitu(
						textField.getText(), textField_1.getText(),
						textField_2.getText(), textfield_3.getText());
			}
		});

		textfield_3 = new JTextField();
		textfield_3.setBounds(99, 162, 183, 20);
		panel_1.add(textfield_3);
		OnartuBotoia.setBounds(109, 193, 111, 23);
		panel_1.add(OnartuBotoia);

		lblSartuTerapeutarenDatuak = new JLabel("Sartu Terapeutaren datuak:");
		lblSartuTerapeutarenDatuak.setFont(new Font("Dialog", Font.BOLD
				| Font.ITALIC, 13));
		lblSartuTerapeutarenDatuak.setBounds(12, 23, 240, 15);
		panel_1.add(lblSartuTerapeutarenDatuak);

		lblIzena = new JLabel("Izena");
		lblIzena.setBounds(11, 72, 70, 15);
		panel_1.add(lblIzena);

		lblNan = new JLabel("NAN");
		lblNan.setBounds(11, 103, 70, 15);
		panel_1.add(lblNan);

		lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setBounds(11, 134, 79, 15);
		panel_1.add(lblPasahitza);

		lblHelbidea = new JLabel("Helbidea");
		lblHelbidea.setBounds(11, 165, 70, 15);
		panel_1.add(lblHelbidea);

		image = new JLabel("");
		image.setBounds(261, 8, 59, 49);
		panel_1.add(image);
		image.setIcon(new ImageIcon(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
	}
}
