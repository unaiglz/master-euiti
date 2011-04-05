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
import java.awt.image.BufferedImage;

import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class EI_HitzorduKontsulta extends JFrame {

	public EI_HitzorduKontsulta(String terapeutaNAN) {
		BufferedImage imagen = Cargador.getImagen("Images/icon.png");
		setIconImage(imagen);
		setTitle("HitzorduKontsulta");
		getContentPane().setLayout(null);
		setSize(456,300);

		// botoia sakatzerakoan lehio hau itxi behar da
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// lehioa itxiko du
				itxi(); 
			}
		});
		
		btnOk.setBounds(174, 230, 89, 23);
		getContentPane().add(btnOk);

		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "SELECT dataOrdua, terapeutaID, bezeroID, terapiaMotaID " +
				"From Hitzordua WHERE terapeutaID='"+ terapeutaNAN + "'";
		ResultSet rs = dbk.execSQL(K1);
		sartuTuplak(rs);
		this.setVisible(true);
	
	}

	protected void itxi() {
		this.dispose();
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
		modelo.addColumn("terapeutaID");
		modelo.addColumn("bezeroID");
		modelo.addColumn("terapiaMotaID");

		try {
			while (rs.next()) {
				Vector<String> fila = new Vector<String>();

				fila.add(rs.getString("dataOrdua"));
				fila.add(rs.getString("terapeutaID"));
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
