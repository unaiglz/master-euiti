package klinikakoInterfaz;

import interfazeak.EI_Bezeroa_Gehitu;
import interfazeak.EI_HitzorduaEskatu;
import interfazeak.EI_TerapeutaGehitu;
import interfazeak.EI_TerapeutarenInformazioPertsonala;
import interfazeak.EI_TerapiaMotaGehitu;

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
import kudeatzaileak.HitzorduKudeatzailea;
import kudeatzaileak.TerapeutaKudeatzaile;
import kudeatzaileak.TerapiaMotaKudeatzaile;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EI_Idazkaria {

	private JFrame frmMasterKudeatzailea;
	private JTable table;
	private JTextField textField;
	public int comboEmaitza;
	private JTable table_1;
	private JTextField textField_1;
	private JTable table_2;
	private JTextField textField_2;
	private JTable table_3;

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
		frmMasterKudeatzailea.setBounds(100, 100, 708, 448);
		frmMasterKudeatzailea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMasterKudeatzailea.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 772, 416);
		frmMasterKudeatzailea.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Terapeutak", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 12, 684, 271);
		panel.add(scrollPane_1);
		

		DefaultTableModel modelo1 = new DefaultTableModel();
		table_1 = new JTable(modelo1);
		scrollPane_1.setViewportView(table_1);
     // Instanciamos el TableRowSorter y lo añadimos al JTable
        final TableRowSorter<DefaultTableModel> oredenatzenDuena1 = new TableRowSorter<DefaultTableModel>(modelo1);
        table_1.setRowSorter(oredenatzenDuena1);
        table_1.setFillsViewportHeight(true);
		TerapeutaKudeatzaile tk = TerapeutaKudeatzaile.getInstantzia();
		tk.taulaBete(modelo1);
		//bakarrik selekzio bat egin ahal izateko
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnTerapeutaInfoIkusi = new JButton("Terapeuta Info Ikusi");
		btnTerapeutaInfoIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object zelda = table.getValueAt(table.getSelectedRow(),0);
				Object zelda1 = table.getValueAt(table.getSelectedRow(),1);
				Object zelda2 = table.getValueAt(table.getSelectedRow(),3);
				Object zelda3 = table.getValueAt(table.getSelectedRow(),6);
				String Nan = (String) zelda;
				String izena = (String) zelda1;
				String helbidea = (String) zelda2;
				Boolean egoera = (Boolean) zelda3;
				EI_TerapeutarenInformazioPertsonala informazioa = new EI_TerapeutarenInformazioPertsonala(Nan, izena, helbidea, egoera);
				informazioa.frmTerapetuaInfo.setVisible(true);
			}
		});
		btnTerapeutaInfoIkusi.setBounds(12, 352, 182, 25);
		panel.add(btnTerapeutaInfoIkusi);
		
		JLabel lblBilatu_1 = new JLabel("Bilatu:");
		lblBilatu_1.setBounds(12, 295, 70, 15);
		panel.add(lblBilatu_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(62, 293, 234, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() { 
            public void keyReleased(final KeyEvent e) { 
                filtroa(comboEmaitza); 
            }
            public void filtroa(int zutabe) {
	    		// TODO Auto-generated method stub
	    		//Obtiene el valor del JTextField para el filtro 
	            String filtro = textField.getText(); 
	            oredenatzenDuena1.setRowFilter(RowFilter.regexFilter(filtro, zutabe));
		} 
        });
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NAN", "Izena"}));
		comboBox.setBounds(311, 290, 125, 24);
		panel.add(comboBox);
		
		JButton btnBirkargatu_1 = new JButton("Birkargatu");
		btnBirkargatu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TerapeutaKudeatzaile tk = TerapeutaKudeatzaile.getInstantzia();
				DefaultTableModel modelo1 = new DefaultTableModel();
				tk.taulaBete(modelo1);
				TableRowSorter<DefaultTableModel> oredenatzenDuena1 = new TableRowSorter<DefaultTableModel>(modelo1);
		        table_1.setRowSorter(oredenatzenDuena1);
			}
		});
		btnBirkargatu_1.setBounds(579, 295, 117, 25);
		panel.add(btnBirkargatu_1);
		
		JButton btnTerapeutaGehitu = new JButton("Terapeuta Gehitu");
		btnTerapeutaGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_TerapeutaGehitu gehitu = new interfazeak.EI_TerapeutaGehitu();
				gehitu.frmTerapeutaGehitu.setVisible(true);
				
			}
		});
		btnTerapeutaGehitu.setBounds(218, 352, 168, 25);
		panel.add(btnTerapeutaGehitu);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Terapiak", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 12, 679, 324);
		panel_1.add(scrollPane_3);
		
		DefaultTableModel modelo3 = new DefaultTableModel();
        table_3 = new JTable(modelo3);
     // Instanciamos el TableRowSorter y lo añadimos al JTable
        final TableRowSorter<DefaultTableModel> oredenatzenDuena3 = new TableRowSorter<DefaultTableModel>(modelo3);
        table_3.setRowSorter(oredenatzenDuena3);
        table_3.setFillsViewportHeight(true);
		scrollPane_3.setViewportView(table_3);
		TerapiaMotaKudeatzaile tmk = TerapiaMotaKudeatzaile.getInstantzia();
		tmk.taulaBete(modelo3);
		//bakarrik selekzio bat egin ahal izateko
		table_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnTerapiaGehitu = new JButton("Terapia Gehitu");
		btnTerapiaGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_TerapiaMotaGehitu tmGehitu = new EI_TerapiaMotaGehitu();
				tmGehitu.setVisible(true);
			}
		});
		btnTerapiaGehitu.setBounds(267, 352, 157, 25);
		panel_1.add(btnTerapiaGehitu);
		
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
		btnHitzorduaEskatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_HitzorduaEskatu orduaEskatu = new EI_HitzorduaEskatu();
				orduaEskatu.frame.setVisible(true);
				Object zelda = table.getValueAt(table.getSelectedRow(),0);
				orduaEskatu.textField.setText((String) zelda);
			}
		});
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
		btnBirkargatu.setBounds(567, 315, 117, 25);
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
		
		JButton btnKobratu = new JButton("Kobratu");
		btnKobratu.setBounds(342, 352, 117, 25);
		panel_2.add(btnKobratu);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Hitzorduak", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 12, 677, 280);
		panel_3.add(scrollPane_2);
		
		DefaultTableModel modelo2 = new DefaultTableModel();
		table_2 = new JTable(modelo2);
		scrollPane_2.setViewportView(table_2);
     // Instanciamos el TableRowSorter y lo añadimos al JTable
        final TableRowSorter<DefaultTableModel> oredenatzenDuena2 = new TableRowSorter<DefaultTableModel>(modelo2);
        table_2.setRowSorter(oredenatzenDuena2);
        table_2.setFillsViewportHeight(true);
		HitzorduKudeatzailea hk2 = HitzorduKudeatzailea.getInstantzia();
		hk2.taulaBete(modelo2);
		//bakarrik selekzio bat egin ahal izateko
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblBilatu_2 = new JLabel("Bilatu:");
		lblBilatu_2.setBounds(22, 304, 70, 15);
		panel_3.add(lblBilatu_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(73, 304, 280, 19);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBirkargatu_2 = new JButton("Birkargatu");
		btnBirkargatu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modelo3 = new DefaultTableModel();
				HitzorduKudeatzailea hk = HitzorduKudeatzailea.getInstantzia();
				hk.taulaBete(modelo3);
				table_3.setModel(modelo3);
				TableRowSorter<DefaultTableModel> oredenatzenDuena3 = new TableRowSorter<DefaultTableModel>(modelo3);
			    table_3.setRowSorter(oredenatzenDuena);
			}
		});
		btnBirkargatu_2.setBounds(572, 299, 117, 25);
		panel_3.add(btnBirkargatu_2);
		
		JButton btnKontsultatu = new JButton("Kontsultatu");
		btnKontsultatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnKontsultatu.setBounds(168, 352, 134, 25);
		panel_3.add(btnKontsultatu);
		
		JButton btnAldatu = new JButton("Aldatu");
		btnAldatu.setBounds(343, 352, 117, 25);
		panel_3.add(btnAldatu);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(365, 304, 139, 24);
		panel_3.add(comboBox_1);
		
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboEmaitza=comboBox.getSelectedIndex();
			}

	});
		
		comboAukeratuBilaketa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboEmaitza=comboAukeratuBilaketa.getSelectedIndex();
			}

	});
}	
}
