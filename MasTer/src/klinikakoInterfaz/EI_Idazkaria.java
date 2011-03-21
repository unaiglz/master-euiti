package klinikakoInterfaz;

import interfazeak.EI_Bezeroa_Gehitu;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;

import datuBaseKonexioa.DBKudeatzaile;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import kudeatzaileak.BezeroKudeatzaile;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EI_Idazkaria {

	private JFrame frmMasterKudeatzailea;
	private JTable table;
	private JTextField textField;
	public int comboEmaitza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_Idazkaria window = new EI_Idazkaria();
					window.frmMasterKudeatzailea.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EI_Idazkaria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMasterKudeatzailea = new JFrame();
		frmMasterKudeatzailea.setTitle("MasTer Kudeatzailea");
		frmMasterKudeatzailea.setBounds(100, 100, 774, 448);
		frmMasterKudeatzailea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMasterKudeatzailea.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 772, 416);
		frmMasterKudeatzailea.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Terapeutak", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Terapiak", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Bezeroak", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 672, 291);
		panel_2.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
        table = new JTable(modelo);
     // Instanciamos el TableRowSorter y lo añadimos al JTable
        final TableRowSorter<DefaultTableModel> oredenatzenDuena = new TableRowSorter<DefaultTableModel>(modelo);
        table.setRowSorter(oredenatzenDuena);
        table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		BezeroKudeatzaile bk = BezeroKudeatzaile.getInstantzia();
		bk.taulaBete(modelo);
		//bakarrik selekzio bat egin ahal izateko
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnHitzorduaEskatu = new JButton("Hitzordua Eskatu");
		btnHitzorduaEskatu.setBounds(12, 352, 156, 25);
		panel_2.add(btnHitzorduaEskatu);
		
		JButton btnBezeroaGehitu = new JButton("Bezeroa gehitu");
		btnBezeroaGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_Bezeroa_Gehitu window = new EI_Bezeroa_Gehitu();
				window.frmBezeroaGehitu.setVisible(true);


			}
			});
		btnBezeroaGehitu.setBounds(180, 352, 150, 25);
		panel_2.add(btnBezeroaGehitu);
		
		JButton btnBirkargatu = new JButton("Birkargatu");
		btnBirkargatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel modelo = new DefaultTableModel();
				BezeroKudeatzaile bk = BezeroKudeatzaile.getInstantzia();
				bk.taulaBete(modelo);
				table.setModel(modelo);
				TableRowSorter<DefaultTableModel> oredenatzenDuena = new TableRowSorter<DefaultTableModel>(modelo);
			    table.setRowSorter(oredenatzenDuena);
			}
		});
		btnBirkargatu.setBounds(567, 352, 117, 25);
		panel_2.add(btnBirkargatu);
		
		textField = new JTextField();
		textField.setBounds(114, 315, 216, 19);
		panel_2.add(textField);
		textField.setColumns(10);
 
		textField.addKeyListener(new KeyAdapter() { 
            public void keyReleased(final KeyEvent e) { 
                filtroa(comboEmaitza); 
            }

			public void filtroa(int zutabe) {
		    		// TODO Auto-generated method stub
		    		//Obtiene el valor del JTextField para el filtro 
		            String filtro = textField.getText(); 
		            oredenatzenDuena.setRowFilter(RowFilter.regexFilter(filtro, zutabe));
			} 
        });  
		
		JLabel lblBilatu = new JLabel("Bilatu:");
		lblBilatu.setBounds(52, 317, 70, 15);
		panel_2.add(lblBilatu);
		
		final JComboBox comboAukeratuBilaketa = new JComboBox();
		comboAukeratuBilaketa.setModel(new DefaultComboBoxModel(new String[] {"NAN", "Izena", "Jaiotze Data", "Helbidea"}));
		comboAukeratuBilaketa.setBounds(361, 312, 179, 24);
		panel_2.add(comboAukeratuBilaketa);
		comboAukeratuBilaketa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboEmaitza=comboAukeratuBilaketa.getSelectedIndex();
			}

	});
}}
