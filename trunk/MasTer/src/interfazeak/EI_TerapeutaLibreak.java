package interfazeak;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.util.Vector;

import klinikakoInterfaz.EI_Idazkaria;
import kudeatzaileak.HitzorduKudeatzailea;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import datuBaseKonexioa.Cargador;
import datuBaseKonexioa.DBKudeatzaile;
import java.awt.Toolkit;

public class EI_TerapeutaLibreak {

	public JFrame frmTerapeutaLibreak;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutaLibreak window = new EI_TerapeutaLibreak(null,
							null, null, null);
					window.frmTerapeutaLibreak.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EI_TerapeutaLibreak(ResultSet rs, String dataOrdua, String bezeroID,
			String terapiaMotaID) {
		initialize(rs, dataOrdua, bezeroID, terapiaMotaID);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ResultSet rs, final String dataOrdua,
			final String bezeroID, final String terapiaMotaID) {
		frmTerapeutaLibreak = new JFrame();
		BufferedImage imagen = Cargador.getImagen("Images/icon.png");
		frmTerapeutaLibreak.setIconImage(imagen);
		frmTerapeutaLibreak.setTitle("Terapeuta Libreak");
		frmTerapeutaLibreak.setBounds(100, 100, 352, 335);
		frmTerapeutaLibreak.getContentPane().setLayout(null);

		JLabel lblTerapeutaLibreenZerrenda = new JLabel(
				"Terapeuta libreen zerrenda");
		lblTerapeutaLibreenZerrenda.setFont(new Font("Tahoma", Font.BOLD
				| Font.ITALIC, 14));
		lblTerapeutaLibreenZerrenda.setBounds(22, 12, 231, 28);
		frmTerapeutaLibreak.getContentPane().add(lblTerapeutaLibreenZerrenda);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
				String terapeutaID = terapeutaIDlortu();
				String k1 = "INSERT INTO Hitzordua VALUES(" + dataOrdua + ","
						+ terapeutaID + "," + bezeroID + "," + terapiaMotaID
						+ ",null,0)";
				dbk.execSQL(k1);
			}
		});
		btnOnartu.setBounds(77, 269, 101, 28);
		frmTerapeutaLibreak.getContentPane().add(btnOnartu);

		JButton btnEzeztatu = new JButton("Ezeztatu");
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_Idazkaria eiIdazkaria = new EI_Idazkaria();
			}
		});
		btnEzeztatu.setBounds(188, 269, 101, 28);
		frmTerapeutaLibreak.getContentPane().add(btnEzeztatu);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 57, 302, 200);
		frmTerapeutaLibreak.getContentPane().add(scrollPane);

		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		// Instanciamos el TableRowSorter y lo añadimos al JTable
		final TableRowSorter<DefaultTableModel> oredenatzenDuena = new TableRowSorter<DefaultTableModel>(
				model);
		table.setRowSorter(oredenatzenDuena);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		HitzorduKudeatzailea hk = HitzorduKudeatzailea.getInstantzia();
		hk.terapeutaTaulaBete(model, rs);
		// bakarrik selekzio bat egin ahal izateko
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel img = new JLabel("");
		img.setBounds(286, 2, 54, 49);
		img.setIcon(new ImageIcon(
		imagen));
		frmTerapeutaLibreak.getContentPane().add(img);
		frmTerapeutaLibreak.setSize(354,344);
	}

	public String terapeutaIDlortu() {
		Object zelda = table.getValueAt(table.getSelectedRow(), 0);
		String emaitza = (String) zelda;

		return emaitza;
	}
}
