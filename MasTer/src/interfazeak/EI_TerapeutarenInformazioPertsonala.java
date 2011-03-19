package interfazeak;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import kudeatzaileak.TerapeutaKudeatzaile;

public class EI_TerapeutarenInformazioPertsonala {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton agendaKontsultatu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutarenInformazioPertsonala window = new EI_TerapeutarenInformazioPertsonala(null, null, null, false);
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
	public EI_TerapeutarenInformazioPertsonala(String Nan, 
			String izena, String helbidea, boolean egoera) {
		initialize(Nan, izena, helbidea, egoera);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String Nan,	String izena, 
			String helbidea, boolean egoera) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNan = new JLabel("Nan:");
		lblNan.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNan.setBounds(10, 57, 71, 27);
		frame.getContentPane().add(lblNan);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblIzena.setBounds(10, 95, 71, 27);
		frame.getContentPane().add(lblIzena);
		
		JLabel lblHelbidea = new JLabel("Helbidea:");
		lblHelbidea.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblHelbidea.setBounds(10, 133, 71, 27);
		frame.getContentPane().add(lblHelbidea);
		
		JLabel lblEgoera = new JLabel("Egoera:");
		lblEgoera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblEgoera.setBounds(10, 171, 71, 27);
		frame.getContentPane().add(lblEgoera);
		
		JLabel lblTerapeutarenInformazioa = new JLabel("Terapeutaren informazioa:");
		lblTerapeutarenInformazioa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTerapeutarenInformazioa.setBounds(71, 19, 170, 27);
		frame.getContentPane().add(lblTerapeutarenInformazioa);
		
		textField = new JTextField(Nan);
		textField.setBounds(81, 57, 160, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(izena);
		textField_1.setBounds(80, 95, 161, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(helbidea);
		textField_2.setBounds(81, 133, 160, 27);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		String aktiboa;
		if(egoera == true){
			aktiboa="Bai";
		}else aktiboa="EZ";
		
		textField_3 = new JTextField(aktiboa);
		textField_3.setBounds(80, 174, 161, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		agendaKontsultatu = new JButton("Agenda Kontsultatu");
		agendaKontsultatu.setSize(160, 27);
		agendaKontsultatu.setLocation(68, 215);		
		frame.getContentPane().add(agendaKontsultatu);
		agendaKontsultatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TerapeutaKudeatzaile.getInstantzia().AgendaKontsultatu(Nan);
			}
		});
		
		
		
		
	}

}
