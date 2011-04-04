package interfazeak;

import java.awt.EventQueue;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EI_Agenda {

	private JFrame frame;
	private JLabel lblAgenda;
	private JButton btnOnartu;
	private DefaultTableModel modeloa;
	private JTable tabla;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_Agenda window = new EI_Agenda(null);
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
	public EI_Agenda(Vector<Vector<String>> informazioa) {
		initialize(informazioa);
		//Taulan lerroak txertatzeko
		lerroakTxertatu(informazioa);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Vector<Vector<String>> informazioa) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		lblAgenda = new JLabel("Agenda");
		lblAgenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAgenda.setBounds(162, 21, 68, 32);
		frame.getContentPane().add(lblAgenda);
		
		//Modeloa sortu eta zutabeen izenak jartzen ditugu
		modeloa = new DefaultTableModel();
		modeloa.addColumn("Bezeroa");
		modeloa.addColumn("Data");
		modeloa.addColumn("Terapia mota");
		
		tabla = new JTable(modeloa);
		tabla.setBounds(29, 78, 333, 209);
		frame.getContentPane().add(tabla);
		
		btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnOnartu.setBounds(151, 312, 89, 23);
		frame.getContentPane().add(btnOnartu);		
		}
	
	private void lerroakTxertatu(Vector<Vector<String>> informazioa) {
		for (int i = 0; i < informazioa.size(); i++) {			
			modeloa.addRow(informazioa.get(i));			
		}				
	}
	}


	
	

