package interfazeak;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import datuBaseKonexioa.Cargador;

import kudeatzaileak.AgiriKudeatzaile;
import kudeatzaileak.BezeroKudeatzaile;
import java.awt.Toolkit;

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
		BufferedImage imagen = Cargador.getImagen("Images/icon.png");
		frmKobratu = new JFrame();
		frmKobratu.setIconImage(imagen);
		frmKobratu.setTitle("Kobratu");
		frmKobratu.setSize(461, 300);
		frmKobratu.setBounds(100, 100, 450, 300);
		frmKobratu.getContentPane().setLayout(null);

		taulaSortu(nan);

		btnAgiria();

		frmKobratu.setVisible(true);
	}

	private void btnAgiria() {
		JButton btnAgiria = new JButton("Agiria");
		btnAgiria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agiriaEgin();
				// new Agiria(dataOrdua, terapeutaID, bezeroID, terapiaMotaID);
			}
		});
		btnAgiria.setBounds(163, 231, 117, 25);
		frmKobratu.getContentPane().add(btnAgiria);

	}

	private void agiriaEgin() {
		Object data = table.getValueAt(table.getSelectedRow(), 0);
		Object terapeuta = table.getValueAt(table.getSelectedRow(), 1);
		Object bezero = table.getValueAt(table.getSelectedRow(), 2);
		Object terapiaMota = table.getValueAt(table.getSelectedRow(), 3);
		AgiriKudeatzaile.getInstantzia()
				.SortuPdf(data.toString(), terapeuta.toString(),
						bezero.toString(), terapiaMota.toString());
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

		BezeroKudeatzaile.getInstantzia().kobratuTaulaBete(modelo, nan);
	}
}
