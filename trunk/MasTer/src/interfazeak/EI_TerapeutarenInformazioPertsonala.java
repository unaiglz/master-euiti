package interfazeak;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import kudeatzaileak.TerapeutaKudeatzaile;
import java.awt.Toolkit;

public class EI_TerapeutarenInformazioPertsonala {
	// Te falta Jaiotze Data y xfavor hazme las interfaces un poco bonicas anda
	// xD

	public JFrame frmTerapetuaInfo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton agendaKontsultatu;
	private String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutarenInformazioPertsonala window = new EI_TerapeutarenInformazioPertsonala(
							null, null, null, null, false);
					window.frmTerapetuaInfo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param jaiotzeD 
	 */
	public EI_TerapeutarenInformazioPertsonala(String Nan, String izena,
			String helbidea, String jaiotzeD, boolean egoera) {
		initialize(Nan, izena, helbidea, egoera);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String Nan, String izena, String helbidea,
			boolean egoera) {

		id = Nan;
		frmTerapetuaInfo = new JFrame();
		BufferedImage imagen = Cargador.getImagen("Images/info.png");
		frmTerapetuaInfo.setIconImage(imagen);
		frmTerapetuaInfo.setTitle("Terapetua Info");
		frmTerapetuaInfo.setBounds(100, 100, 350, 288);
		frmTerapetuaInfo.getContentPane().setLayout(null);

		JLabel lblNan = new JLabel("Nan:");
		lblNan.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNan.setBounds(35, 57, 71, 27);
		frmTerapetuaInfo.getContentPane().add(lblNan);

		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIzena.setBounds(35, 95, 71, 27);
		frmTerapetuaInfo.getContentPane().add(lblIzena);

		JLabel lblHelbidea = new JLabel("Helbidea:");
		lblHelbidea.setFont(new Font("Dialog", Font.BOLD, 12));
		lblHelbidea.setBounds(35, 133, 71, 27);
		frmTerapetuaInfo.getContentPane().add(lblHelbidea);

		JLabel lblEgoera = new JLabel("Egoera:");
		lblEgoera.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEgoera.setBounds(35, 171, 71, 27);
		frmTerapetuaInfo.getContentPane().add(lblEgoera);

		JLabel lblTerapeutarenInformazioa = new JLabel(
				"Terapeutaren informazioa:");
		lblTerapeutarenInformazioa.setFont(new Font("Tahoma", Font.BOLD
				| Font.ITALIC, 12));
		lblTerapeutarenInformazioa.setBounds(23, 18, 257, 27);
		frmTerapetuaInfo.getContentPane().add(lblTerapeutarenInformazioa);

		textField = new JTextField(Nan);
		textField.setBounds(134, 57, 160, 27);
		frmTerapetuaInfo.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(izena);
		textField_1.setBounds(133, 95, 161, 27);
		frmTerapetuaInfo.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField(helbidea);
		textField_2.setBounds(134, 133, 160, 27);
		frmTerapetuaInfo.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		String aktiboa;
		if (egoera == true) {
			aktiboa = "Bai";
		} else
			aktiboa = "EZ";

		textField_3 = new JTextField(aktiboa);
		textField_3.setBounds(133, 174, 161, 24);
		frmTerapetuaInfo.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		agendaKontsultatu = new JButton("Agenda Kontsultatu");
		agendaKontsultatu.setSize(190, 27);
		agendaKontsultatu.setLocation(86, 210);
		frmTerapetuaInfo.getContentPane().add(agendaKontsultatu);

		JLabel img = new JLabel("");
		img.setBounds(278, 4, 62, 55);
		img.setIcon(new ImageIcon(
				imagen));
		frmTerapetuaInfo.getContentPane().add(img);

		agendaKontsultatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TerapeutaKudeatzaile.getInstantzia().AgendaKontsultatu(id);
			}
		});

	}
}
