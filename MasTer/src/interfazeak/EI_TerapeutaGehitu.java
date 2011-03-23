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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import kudeatzaileak.ErabiltzaileKudeatzaile;
import kudeatzaileak.TerapeutaKudeatzaile;
import java.awt.Color;
import javax.swing.JPasswordField;

public class EI_TerapeutaGehitu {

	public JFrame frmTerapeutaGehitu;
	private JPanel panel_1;
	private JTextField textIzenaSartu;
	private JTextField textNANSartu;
	private JTextField textHelbideaSartu;
	private JButton OnartuBotoia;
	private JLabel lblSartuTerapeutarenDatuak;
	private JLabel lblIzena;
	private JLabel lblNan;
	private JLabel lblPasahitza;
	private JLabel lblHelbidea;
	private JLabel image;
	private JTextField textJaiotzeDataSartu;
	private JLabel lblFormatuaYyyymmdd;
	private JPasswordField textPasahitzaSartu;
	private JLabel lblPasahitzaBerriroSartu;
	private JPasswordField TextPasahitzaBerriroSartu;

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
		frmTerapeutaGehitu.setBounds(100, 100, 507, 396);
		frmTerapeutaGehitu.getContentPane().setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 502, 368);
		frmTerapeutaGehitu.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		textIzenaSartu = new JTextField();
		textIzenaSartu.setBounds(193, 60, 287, 25);
		panel_1.add(textIzenaSartu);

		textNANSartu = new JTextField();
		textNANSartu.setBounds(193, 98, 287, 25);
		panel_1.add(textNANSartu);
		/**
		 * Erabiltzaile kudeatzaileari sartutako datuekin terapeuta berri bat
		 * sartzeko esango dio
		 */

		textHelbideaSartu = new JTextField();
		textHelbideaSartu.setBounds(193, 212, 287, 25);
		panel_1.add(textHelbideaSartu);

		lblSartuTerapeutarenDatuak = new JLabel("Sartu Terapeutaren datuak:");
		lblSartuTerapeutarenDatuak.setFont(new Font("Dialog", Font.BOLD
				| Font.ITALIC, 13));
		lblSartuTerapeutarenDatuak.setBounds(12, 23, 240, 15);
		panel_1.add(lblSartuTerapeutarenDatuak);

		lblIzena = new JLabel("Izena");
		lblIzena.setBounds(12, 65, 70, 15);
		panel_1.add(lblIzena);

		lblNan = new JLabel("NAN");
		lblNan.setBounds(12, 103, 70, 15);
		panel_1.add(lblNan);

		lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setBounds(12, 139, 79, 15);
		panel_1.add(lblPasahitza);

		lblHelbidea = new JLabel("Helbidea");
		lblHelbidea.setBounds(12, 217, 70, 15);
		panel_1.add(lblHelbidea);

		image = new JLabel("");
		image.setBounds(421, 6, 59, 49);
		panel_1.add(image);
		image.setIcon(new ImageIcon(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		
				OnartuBotoia = new JButton("Onartu");
				OnartuBotoia.setBounds(175, 294, 111, 23);
				panel_1.add(OnartuBotoia);
				
				JLabel lblJaiotzeData = new JLabel("Jaiotze data");
				lblJaiotzeData.setBounds(12, 250, 87, 20);
				panel_1.add(lblJaiotzeData);
				
				textJaiotzeDataSartu = new JTextField();
				textJaiotzeDataSartu.setBounds(193, 249, 287, 23);
				panel_1.add(textJaiotzeDataSartu);
				textJaiotzeDataSartu.setColumns(10);
				
				lblFormatuaYyyymmdd = new JLabel("Jaiotze dataren formatua: yyyy-MM-dd");
				lblFormatuaYyyymmdd.setFont(new Font("Dialog", Font.ITALIC, 10));
				lblFormatuaYyyymmdd.setForeground(Color.DARK_GRAY);
				lblFormatuaYyyymmdd.setBounds(271, 329, 209, 20);
				panel_1.add(lblFormatuaYyyymmdd);
				
				textPasahitzaSartu = new JPasswordField();
				textPasahitzaSartu.setBounds(193, 135, 287, 23);
				panel_1.add(textPasahitzaSartu);
				
				lblPasahitzaBerriroSartu = new JLabel("Pasahitza berriro sartu");
				lblPasahitzaBerriroSartu.setBounds(12, 179, 183, 15);
				panel_1.add(lblPasahitzaBerriroSartu);
				
				TextPasahitzaBerriroSartu = new JPasswordField();
				TextPasahitzaBerriroSartu.setBounds(193, 170, 287, 25);
				panel_1.add(TextPasahitzaBerriroSartu);
				OnartuBotoia.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(textPasahitzaSartu == TextPasahitzaBerriroSartu){
						TerapeutaKudeatzaile.getInstantzia().terapeutaGehitu(
								textIzenaSartu.getText(), textNANSartu.getText(),
								String.valueOf(textPasahitzaSartu.getPassword()), textHelbideaSartu.getText(), 
								sortuData(textJaiotzeDataSartu.getText()));
						}else {
							EI_PasahitzaEzZuzena eiError = new EI_PasahitzaEzZuzena();
						}
								
					}
					
					public Calendar sortuData(String str_date) {
						Calendar jaiotzeData = Calendar.getInstance();
						try {
							DateFormat formatter;
							Date date;
							formatter = new SimpleDateFormat("yyyy-MM-dd");
							date = (Date) formatter.parse(str_date);
							jaiotzeData.setTime(date);
						} catch (ParseException e) {
							System.out.println("Exception :" + e);
						}
						return jaiotzeData;
					}
				});
	}
}
