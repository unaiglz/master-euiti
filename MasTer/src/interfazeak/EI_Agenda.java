package interfazeak;

import java.awt.EventQueue;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import kudeatzaileak.TerapeutaKudeatzaile;

public class EI_Agenda {

	private JFrame frame;
	private JLabel lblAgenda;
	private JButton btnOnartu;
	private DefaultTableModel modeloa;
	private JTable tabla;
	private JScrollPane scrollPane;
	

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
	public EI_Agenda(String terapeutaNAN) {
		initialize(terapeutaNAN);
		//Taulan lerroak txertatzeko

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String terapeutaNAN) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,452);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		lblAgenda = new JLabel("Agenda");
		lblAgenda.setBounds(158, 11, 68, 32);
		lblAgenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		frame.getContentPane().add(lblAgenda);
		
		DefaultTableModel modelo = new DefaultTableModel();
		final TableRowSorter<DefaultTableModel> ordenatzenDuena = new TableRowSorter<DefaultTableModel>(
				modelo);
		TerapeutaKudeatzaile tk = TerapeutaKudeatzaile.getInstantzia();
		tk.terapeutaInterfazTaulaBete(modelo, terapeutaNAN);
		
		btnOnartu = new JButton("Onartu");
		btnOnartu.setBounds(147, 351, 89, 23);
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnOnartu);		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 57, 345, 268);
		frame.getContentPane().add(scrollPane);
		// Instanciamos el TableRowSorter y lo añadimos al JTable
		tabla = new JTable(modelo);
		scrollPane.setViewportView(tabla);
		tabla.setRowSorter(ordenatzenDuena);
		tabla.setFillsViewportHeight(true);
		// bakarrik selekzio bat egin ahal izateko
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
	
	private void lerroakTxertatu(Vector<Vector<String>> informazioa) {
		for (int i = 0; i < informazioa.size(); i++) {			
			modeloa.addRow(informazioa.get(i));			
		}				
	}
	}


	
	

