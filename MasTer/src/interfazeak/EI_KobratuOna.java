package interfazeak;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import kudeatzaileak.BezeroKudeatzaile;

public class EI_KobratuOna {

	private JFrame frmKobratu;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_KobratuOna window = new EI_KobratuOna(null);
					window.frmKobratu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EI_KobratuOna(String nan) {
		initialize(nan);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nan) {
		frmKobratu = new JFrame();
		frmKobratu.setTitle("Kobratu\n");
		frmKobratu.setBounds(100, 100, 450, 300);
		frmKobratu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKobratu.getContentPane().setLayout(null);
		
		taulaSortu(nan);
		
		btnAgiria();
		
		frmKobratu.setVisible(true);
	}

	private void btnAgiria() {
		JButton btnAgiria = new JButton("Agiria");
		btnAgiria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//new Agiria(dataOrdua, terapeutaID, bezeroID, terapiaMotaID);
			}
		});
		btnAgiria.setBounds(163, 231, 117, 25);
		frmKobratu.getContentPane().add(btnAgiria);

	}

	private void taulaSortu(String nan) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 424, 213);
		frmKobratu.getContentPane().add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		// Instanciamos el TableRowSorter y lo añadimos al JTable
		final TableRowSorter<DefaultTableModel> oredenatzenDuena = new TableRowSorter<DefaultTableModel>(
				modelo);
		table.setRowSorter(oredenatzenDuena);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		// bakarrik selekzio bat egin ahal izateko
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		BezeroKudeatzaile.getInstantzia().kobratuTaulaBete(modelo,nan);
	}
}
