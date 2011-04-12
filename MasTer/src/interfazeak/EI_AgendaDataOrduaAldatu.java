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

import kudeatzaileak.HitzorduKudeatzailea;
import kudeatzaileak.TerapeutaKudeatzaile;
import javax.swing.JTextField;

public class EI_AgendaDataOrduaAldatu {

	private JFrame frame;
	private JLabel lblAgenda;
	private JButton btnOnartu;
	private DefaultTableModel modeloa;
	private JTable tabla;
	private JScrollPane scrollPane;
	private JTextField dataTextField;
	private JTextField orduTextField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_AgendaDataOrduaAldatu window = new EI_AgendaDataOrduaAldatu(null,null);
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
	public EI_AgendaDataOrduaAldatu(String terapeutaNAN, String dataOrdua) {
		initialize(terapeutaNAN,dataOrdua);
		//Taulan lerroak txertatzeko

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String terapeutaNAN,final String dataOrdua) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(673,452);
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
				String dataOrdua1 = dataTextField.getText() + " " + orduTextField.getText();
				frame.setVisible(false);
				HitzorduKudeatzailea hk = HitzorduKudeatzailea.getInstantzia();
				hk.hitzorduaAldatuOrduaz(dataOrdua, terapeutaNAN, dataOrdua1);
				
			}
		});
		frame.getContentPane().add(btnOnartu);		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 57, 386, 268);
		frame.getContentPane().add(scrollPane);
		// Instanciamos el TableRowSorter y lo añadimos al JTable
		tabla = new JTable(modelo);
		scrollPane.setViewportView(tabla);
		tabla.setRowSorter(ordenatzenDuena);
		tabla.setFillsViewportHeight(true);
		// bakarrik selekzio bat egin ahal izateko
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		dataTextField = new JTextField();
		dataTextField.setBounds(454, 108, 186, 19);
		frame.getContentPane().add(dataTextField);
		dataTextField.setColumns(10);
		
		orduTextField = new JTextField();
		orduTextField.setBounds(454, 256, 186, 19);
		frame.getContentPane().add(orduTextField);
		orduTextField.setColumns(10);
		
		JLabel lblDataBerria = new JLabel("Data berria:");
		lblDataBerria.setBounds(454, 81, 108, 15);
		frame.getContentPane().add(lblDataBerria);
		
		JLabel lblOrduBerria = new JLabel("Ordu berria:");
		lblOrduBerria.setBounds(454, 233, 95, 15);
		frame.getContentPane().add(lblOrduBerria);
		}
	
	private void lerroakTxertatu(Vector<Vector<String>> informazioa) {
		for (int i = 0; i < informazioa.size(); i++) {			
			modeloa.addRow(informazioa.get(i));			
		}				
	}
	}


	
	

