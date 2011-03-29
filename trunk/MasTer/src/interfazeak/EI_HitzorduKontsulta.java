package interfazeak;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import datuBaseKonexioa.DBKudeatzaile;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class EI_HitzorduKontsulta extends JFrame {

	public EI_HitzorduKontsulta(String ID) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		setTitle("HitzorduKontsulta");
		getContentPane().setLayout(null);

		// botoia sakatzerakoan lehio hau itxi behar da
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// lehioa itxiko du
				itxi();
			}
		});
		btnOk.setBounds(171, 216, 89, 23);
		getContentPane().add(btnOk);

		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "SELECT dataOrdua, terapeutaID, bezeroID, terpiaMotaID " +
				"From Hitzordu WHERE terapeutaID='"+ ID + "'";
		ResultSet rs = dbk.execSQL(K1);
		sartuTuplak(rs);
		this.setVisible(true);
	}

	protected void itxi() {
		this.setVisible(false);
	}

	private void sartuTuplak(ResultSet rs) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 424, 213);
		this.getContentPane().add(scrollPane);

		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		// Instanciamos el TableRowSorter y lo añadimos al JTable
		final TableRowSorter<DefaultTableModel> oredenatzenDuena = new TableRowSorter<DefaultTableModel>(
				modelo);
		table.setRowSorter(oredenatzenDuena);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		// bakarrik selekzio bat egin ahal izateko
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// taula sortuko dugu SQL emaitzarekin

		modelo.addColumn("dataOrdua");
		modelo.addColumn("terapiaID");
		modelo.addColumn("bezeroID");
		modelo.addColumn("terapiaMotaID");

		try {
			while (rs.next()) {
				Vector<String> fila = new Vector<String>();

				fila.add(rs.getString("dataOrdua"));
				fila.add(rs.getString("terapiaID"));
				fila.add(rs.getString("bezeroID"));
				fila.add(rs.getString("terapiaMotaID"));

				modelo.addRow(fila);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
