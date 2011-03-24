package klinikakoInterfaz;

import interfazeak.EI_Bezeroa_Gehitu;
import interfazeak.EI_HitzorduaEskatu;
import interfazeak.EI_KobratuOna;
import interfazeak.EI_TerapeutaDatuAldaketa;
import interfazeak.EI_TerapeutaGehitu;
import interfazeak.EI_TerapeutarenInformazioPertsonala;
import interfazeak.EI_TerapiaMotaGehitu;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
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
import datuBaseKonexioa.Clock;
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
import javax.swing.JTextArea;

import com.toedter.calendar.JCalendar;

import java.awt.Toolkit;

public class EI_Idazkaria {

	private JFrame frmMasterKudeatzailea;
	private JTable table;
	private JTextField textField;
	public int comboEmaitza;
	public int comboEmaitza2;
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
		JTabbedPane tabbedPane = hasierakoFrameSortu();

		terapeutaZatiaSortu(tabbedPane);

		terapiaZatiaSortu(tabbedPane);
		
		hitzorduakZatiaSortu(tabbedPane);

		bezeroakZatiaSortu(tabbedPane);
		
		bigarrenAtalaSortu();
	}

	private void bigarrenAtalaSortu() {
		JPanel calendar = new JPanel();
		calendar.setBounds(12, 12, 273, 181);
		frmMasterKudeatzailea.getContentPane().add(calendar);
		calendar.add(new JCalendar());
		
		JPanel clockPnl = new JPanel();
		Clock clock = new Clock();
		clock.start();
		clockPnl.add(clock.getTime());
		clockPnl.setBounds(82, 376, 118, 27);
		frmMasterKudeatzailea.getContentPane().add(clockPnl);
		
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(
		"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		img.setBounds(116, 205, 50, 49);
		frmMasterKudeatzailea.getContentPane().add(img);
		
		JLabel msg = new JLabel("MasTer Kud v1.0");
		msg.setBounds(82, 304, 118, 15);
		frmMasterKudeatzailea.getContentPane().add(msg);
		
		frmMasterKudeatzailea.setVisible(true);
	}

	private void bezeroakZatiaSortu(JTabbedPane tabbedPane) {
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Bezeroak", null, panel_2, null);
		panel_2.setLayout(null);

		final TableRowSorter<DefaultTableModel> oredenatzenDuena = bezeroakTaulaSortu(panel_2);

		hitzorduaEskatuBotoia(panel_2);

		bezeroaGehituBotoia(panel_2);

		bezeroakBirkargatuBotoia(panel_2);

		bilaketaBezeroak(panel_2, oredenatzenDuena);

		kobratuBotoia(panel_2);

		frmMasterKudeatzailea.setVisible(true);
	}

	private void kobratuBotoia(JPanel panel_2) {
		JButton btnKobratu = new JButton("Kobratu");
		btnKobratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object nan = table.getValueAt(table.getSelectedRow(), 0);
				EI_KobratuOna kobratu = new EI_KobratuOna((String)nan);

			}
		});
		btnKobratu.setBounds(342, 352, 117, 25);
		panel_2.add(btnKobratu);
	}

	private void bilaketaBezeroak(JPanel panel_2,
			final TableRowSorter<DefaultTableModel> oredenatzenDuena) {
		bezBilaketaTextField(panel_2, oredenatzenDuena);

		bezBilaketaComboBox(panel_2);
	}

	private void bezBilaketaTextField(JPanel panel_2,
			final TableRowSorter<DefaultTableModel> oredenatzenDuena) {
		textField = new JTextField();
		textField.setBounds(114, 315, 216, 19);
		panel_2.add(textField);
		textField.setColumns(10);

		bezTextFieldEntzulea(oredenatzenDuena);

		JLabel lblBilatu = new JLabel("Bilatu:");
		lblBilatu.setBounds(52, 317, 70, 15);
		panel_2.add(lblBilatu);
	}

	private void bezTextFieldEntzulea(
			final TableRowSorter<DefaultTableModel> oredenatzenDuena) {
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				filtroa(comboEmaitza);
			}

			public void filtroa(int zutabe) {
				// TODO Auto-generated method stub
				// Obtiene el valor del JTextField para el filtro
				String filtro = textField.getText();
				oredenatzenDuena.setRowFilter(RowFilter.regexFilter(filtro,
						zutabe));
			}
		});
		
	}

	private void bezBilaketaComboBox(JPanel panel_2) {
		final JComboBox comboAukeratuBilaketa = new JComboBox();
		comboAukeratuBilaketa.setModel(new DefaultComboBoxModel(new String[] {
				"NAN", "Izena", "Jaiotze Data", "Helbidea" }));
		comboAukeratuBilaketa.setBounds(361, 312, 179, 24);
		panel_2.add(comboAukeratuBilaketa);


		comboAukeratuBilaketa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboEmaitza = comboAukeratuBilaketa.getSelectedIndex();
			}

		});
	}

	private void bezeroakBirkargatuBotoia(JPanel panel_2) {
		JButton btnBirkargatu = new JButton("Birkargatu");
		bezBirkargatuEntzulea(btnBirkargatu);
		btnBirkargatu.setBounds(567, 315, 117, 25);
		panel_2.add(btnBirkargatu);
	}

	private void bezBirkargatuEntzulea(JButton btnBirkargatu) {
		btnBirkargatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel modelo = new DefaultTableModel();
				bezTaulaBete(modelo);
				table.setModel(modelo);
				TableRowSorter<DefaultTableModel> oredenatzenDuena = new TableRowSorter<DefaultTableModel>(
						modelo);
				table.setRowSorter(oredenatzenDuena);
			}
		});
	}

	private void bezeroaGehituBotoia(JPanel panel_2) {
		JButton btnBezeroaGehitu = new JButton("Bezeroa gehitu");
		btnBezeroaGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_Bezeroa_Gehitu window = new EI_Bezeroa_Gehitu();
				window.frmBezeroaGehitu.setVisible(true);

			}
		});
		btnBezeroaGehitu.setBounds(180, 352, 150, 25);
		panel_2.add(btnBezeroaGehitu);
	}

	private void hitzorduaEskatuBotoia(JPanel panel_2) {
		JButton btnHitzorduaEskatu = new JButton("Hitzordua Eskatu");
		btnHitzorduaEskatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_HitzorduaEskatu orduaEskatu = new EI_HitzorduaEskatu();
				orduaEskatu.frmHitzorduaGehitu.setVisible(true);
				Object zelda = table.getValueAt(table.getSelectedRow(), 0);
				orduaEskatu.textField.setText((String) zelda);
			}
		});
		btnHitzorduaEskatu.setBounds(12, 352, 156, 25);
		panel_2.add(btnHitzorduaEskatu);
	}

	private TableRowSorter<DefaultTableModel> bezeroakTaulaSortu(JPanel panel_2) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 672, 291);
		panel_2.add(scrollPane);

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
		
		bezTaulaBete(modelo);
		return oredenatzenDuena;
	}

	private void bezTaulaBete(DefaultTableModel modelo) {
		BezeroKudeatzaile bk = BezeroKudeatzaile.getInstantzia();
		bk.taulaBete(modelo);
	}

	private void hitzorduakZatiaSortu(JTabbedPane tabbedPane) {
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Hitzorduak", null, panel_3, null);
		panel_3.setLayout(null);
		
				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(12, 12, 677, 174);
				panel_3.add(scrollPane_2);
				
				hitzorduakTaulaSortu(scrollPane_2);
			
				
				hitzorduakBirkargatuBotoia(panel_3);
				
				hitzorduaKontsultatuBotoia(panel_3);
						
				hitzorduaAldatuBotoia(panel_3);
				
				hitzorduaBilaketa(panel_3);
																
				hitzorduakTerapeutaOharra(panel_3);
	}

	private void hitzorduakTerapeutaOharra(JPanel panel_3) {
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(73, 215, 422, 77);
		panel_3.add(scrollPane_4);
		
		JTextArea textArea = new JTextArea();
		scrollPane_4.setViewportView(textArea);
		
		JLabel lblTerapeutarenOharra = new JLabel("Terapeutaren oharra:");
		lblTerapeutarenOharra.setBounds(73, 198, 162, 15);
		panel_3.add(lblTerapeutarenOharra);
	}

	private void hitzorduaBilaketa(JPanel panel_3) {
		JLabel lblBilatu_2 = new JLabel("Bilatu:");
		lblBilatu_2.setBounds(22, 304, 70, 15);
		panel_3.add(lblBilatu_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(73, 304, 280, 19);
		panel_3.add(textField_2);
		textField_2.setColumns(10);

										
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(365, 304, 139, 24);
		panel_3.add(comboBox_1);
	}

	private void hitzorduaAldatuBotoia(JPanel panel_3) {
		JButton btnAldatu = new JButton("Aldatu");
		btnAldatu.setBounds(343, 352, 117, 25);
		panel_3.add(btnAldatu);
	}

	private void hitzorduaKontsultatuBotoia(JPanel panel_3) {
		JButton btnKontsultatu = new JButton("Kontsultatu");
		btnKontsultatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnKontsultatu.setBounds(168, 352, 134, 25);
		panel_3.add(btnKontsultatu);
	}

	private void hitzorduakBirkargatuBotoia(JPanel panel_3) {
		JButton btnBirkargatu_2 = new JButton("Birkargatu");
		hitzorduaBirkargatuBotEntzulea(btnBirkargatu_2);
		btnBirkargatu_2.setBounds(572, 299, 117, 25);
		panel_3.add(btnBirkargatu_2);
	}

	private void hitzorduaBirkargatuBotEntzulea(JButton btnBirkargatu_2) {
		btnBirkargatu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modelo2 = new DefaultTableModel();
				hitzTaulaBete(modelo2);
				table_2.setModel(modelo2);
				TableRowSorter<DefaultTableModel> oredenatzenDuena2 = new TableRowSorter<DefaultTableModel>(
						modelo2);
				table_2.setRowSorter(oredenatzenDuena2);
			}
		});
	}

	private void hitzorduakTaulaSortu(JScrollPane scrollPane_2) {
		hitzTaulaSortu(scrollPane_2);
		hitzorduakTaulaEntzulea();
	}

	private void hitzTaulaSortu(JScrollPane scrollPane_2) {
		DefaultTableModel modelo2 = new DefaultTableModel();
		table_2 = new JTable(modelo2);
		// Instanciamos el TableRowSorter y lo añadimos al JTable
		final TableRowSorter<DefaultTableModel> oredenatzenDuena2 = new TableRowSorter<DefaultTableModel>(
				modelo2);
		table_2.setRowSorter(oredenatzenDuena2);
		table_2.setFillsViewportHeight(true);
		scrollPane_2.setViewportView(table_2);
		// bakarrik selekzio bat egin ahal izatek
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		hitzTaulaBete(modelo2);
	}

	private void hitzTaulaBete(DefaultTableModel modelo2) {
		HitzorduKudeatzailea hk = HitzorduKudeatzailea.getInstantzia();
		hk.taulaBete(modelo2);
	}

	private void hitzorduakTaulaEntzulea() {
		table_2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        Point p = new Point(evt.getX(), evt.getY());
		        int col = table.columnAtPoint(p);
		        int row = table.rowAtPoint(p);
		        Object zelda = table_2.getValueAt(row, 0);
		        String data = (String) zelda;
		        HitzorduKudeatzailea.getInstantzia().terapeutarenOharra(data);
		        //falta el setText area
		    }
		}
		);
	}

	private void terapiaZatiaSortu(JTabbedPane tabbedPane) {
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Terapiak", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 12, 679, 324);
		panel_1.add(scrollPane_3);

		terapiaTaulaSortu(scrollPane_3);

		terapiaGehituBotoia(panel_1);
		
		terapiakBirkargatuBotoia(panel_1);
	}

	private void terapiakBirkargatuBotoia(JPanel panel_1) {
		JButton btnBirkargatu_3 = new JButton("Birkargatu");
		terapiaBirkargatuEntzulea(btnBirkargatu_3);
		btnBirkargatu_3.setBounds(574, 348, 117, 25);
		panel_1.add(btnBirkargatu_3);
	}

	private void terapiaBirkargatuEntzulea(JButton btnBirkargatu_3) {
		btnBirkargatu_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modelo3 = new DefaultTableModel();
				terapiaTaulaBete(modelo3);
				table_3.setModel(modelo3);
				TableRowSorter<DefaultTableModel> oredenatzenDuena3 = new TableRowSorter<DefaultTableModel>(
						modelo3);
				table_3.setRowSorter(oredenatzenDuena3);
			}
		});
	}

	private void terapiaGehituBotoia(JPanel panel_1) {
		JButton btnTerapiaGehitu = new JButton("Terapia Gehitu");
		btnTerapiaGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_TerapiaMotaGehitu tmGehitu = new EI_TerapiaMotaGehitu();
				tmGehitu.setVisible(true);
			}
		});
		btnTerapiaGehitu.setBounds(267, 352, 157, 25);
		panel_1.add(btnTerapiaGehitu);
	}

	private void terapiaTaulaSortu(JScrollPane scrollPane_3) {
		DefaultTableModel modelo3 = terpiaTaulaDefinitu(scrollPane_3);
		terapiaTaulaBete(modelo3);
	}

	private DefaultTableModel terpiaTaulaDefinitu(JScrollPane scrollPane_3) {
		DefaultTableModel modelo3 = new DefaultTableModel();
		table_3 = new JTable(modelo3);
		// Instanciamos el TableRowSorter y lo añadimos al JTable
		final TableRowSorter<DefaultTableModel> oredenatzenDuena3 = new TableRowSorter<DefaultTableModel>(
				modelo3);
		table_3.setRowSorter(oredenatzenDuena3);
		table_3.setFillsViewportHeight(true);
		scrollPane_3.setViewportView(table_3);

		// bakarrik selekzio bat egin ahal izateko
		table_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return modelo3;
	}

	private void terapiaTaulaBete(DefaultTableModel modelo3) {
		TerapiaMotaKudeatzaile tmk = TerapiaMotaKudeatzaile.getInstantzia();
		tmk.taulaBete(modelo3);
	}

	private void terapeutaZatiaSortu(JTabbedPane tabbedPane) {
		JPanel panel = new JPanel();
		tabbedPane.addTab("Terapeutak", null, panel, null);
		panel.setLayout(null);

		final TableRowSorter<DefaultTableModel> oredenatzenDuena1 = terapeutaTaulaSortu(panel);

		terapeutaInfoIkusiBotoia(panel);

		terapeutaBilaketa(panel, oredenatzenDuena1);

		birkargatuBotoia(panel);

		terapeutaGehituBotoia(panel);

		terapeutaAldatuBotoia(panel);
	}

	private void terapeutaInfoIkusiBotoia(JPanel panel) {
		JButton btnTerapeutaInfoIkusi = terapeutaInfoBotoia();
		btnTerapeutaInfoIkusi.setBounds(12, 352, 182, 25);
		panel.add(btnTerapeutaInfoIkusi);
	}

	private void terapeutaBilaketa(JPanel panel,
		final TableRowSorter<DefaultTableModel> oredenatzenDuena1) {

		terapeutaBilaketaTextField(panel, oredenatzenDuena1);
		terapeutaBilaketaComboBox(panel);
	}

	private void terapeutaBilaketaComboBox(JPanel panel) {
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "NAN",
				"Izena" }));
		comboBox.setBounds(311, 290, 125, 24);
		panel.add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboEmaitza2 = comboBox.getSelectedIndex();
			}

		});

	}

	private void terapeutaBilaketaTextField(JPanel panel,
			final TableRowSorter<DefaultTableModel> oredenatzenDuena1) {
		textField_1 = new JTextField();
		textField_1.setBounds(62, 293, 234, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		terapeutaBilTxtFieldEntzulea(oredenatzenDuena1);
		
		JLabel lblBilatu_1 = new JLabel("Bilatu:");
		lblBilatu_1.setBounds(12, 295, 70, 15);
		panel.add(lblBilatu_1);
	}

	private void terapeutaBilTxtFieldEntzulea(
			final TableRowSorter<DefaultTableModel> oredenatzenDuena1) {
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				filtroa(comboEmaitza2);
			}

			public void filtroa(int zutabe) {
				// TODO Auto-generated method stub
				// Obtiene el valor del JTextField para el filtro
				String filtro = textField_1.getText();
				oredenatzenDuena1.setRowFilter(RowFilter.regexFilter(filtro,
						zutabe));
			}
		});
	}

	private void terapeutaAldatuBotoia(JPanel panel) {
		JButton btnTerapeutaAldatu = new JButton("Terapeuta Aldatu");
		terapeutaAldatuBtnEntzulea(btnTerapeutaAldatu);
		btnTerapeutaAldatu.setBounds(412, 352, 158, 25);
		panel.add(btnTerapeutaAldatu);
	}

	private void terapeutaAldatuBtnEntzulea(JButton btnTerapeutaAldatu) {
		btnTerapeutaAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object zelda = table_1.getValueAt(table_1.getSelectedRow(), 0);
				Object zelda1 = table_1.getValueAt(table_1.getSelectedRow(), 1);
				Object zelda2 = table_1.getValueAt(table_1.getSelectedRow(), 2);
				Object zelda3 = table_1.getValueAt(table_1.getSelectedRow(), 3);
				String Nan = (String) zelda;
				String izena = (String) zelda1;
				String helbidea = (String) zelda2;
				Boolean egoera = (Boolean) zelda3;
				if (egoera == true) {
					new EI_TerapeutaDatuAldaketa(Nan, izena, helbidea, 1);
				} else {
					new EI_TerapeutaDatuAldaketa(Nan, izena, helbidea, 0);
				}

			}
		});
	}

	private void terapeutaGehituBotoia(JPanel panel) {
		JButton btnTerapeutaGehitu = new JButton("Terapeuta Gehitu");
		btnTerapeutaGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_TerapeutaGehitu gehitu = new interfazeak.EI_TerapeutaGehitu();
				gehitu.frmTerapeutaGehitu.setVisible(true);

			}
		});
		btnTerapeutaGehitu.setBounds(218, 352, 168, 25);
		panel.add(btnTerapeutaGehitu);
	}

	private void birkargatuBotoia(JPanel panel) {
		JButton btnBirkargatu_1 = new JButton("Birkargatu");
		btnBirkargatu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TerapeutaKudeatzaile tk = TerapeutaKudeatzaile.getInstantzia();
				DefaultTableModel modelo1 = new DefaultTableModel();
				tk.taulaBete(modelo1);
				TableRowSorter<DefaultTableModel> oredenatzenDuena1 = new TableRowSorter<DefaultTableModel>(
						modelo1);
				table_1.setRowSorter(oredenatzenDuena1);
			}
		});
		btnBirkargatu_1.setBounds(579, 295, 117, 25);
		panel.add(btnBirkargatu_1);
	}

	private JButton terapeutaInfoBotoia() {
		JButton btnTerapeutaInfoIkusi = new JButton("Terapeuta Info Ikusi");
		terapeutaInfoIkusiBtnEntzulea(btnTerapeutaInfoIkusi);
		return btnTerapeutaInfoIkusi;
	}

	private void terapeutaInfoIkusiBtnEntzulea(JButton btnTerapeutaInfoIkusi) {
		btnTerapeutaInfoIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Object zelda = table_1.getValueAt(table_1.getSelectedRow(), 0);
				Object zelda1 = table_1.getValueAt(table_1.getSelectedRow(), 1);
				Object zelda2 = table_1.getValueAt(table_1.getSelectedRow(), 2);
				Object zelda3 = table_1.getValueAt(table_1.getSelectedRow(), 2);
				Object zelda4 = table_1.getValueAt(table_1.getSelectedRow(), 4);
				String Nan = (String) zelda;
				String izena = (String) zelda1;
				String helbidea = (String) zelda2;
				String jaiotzeD = (String) zelda3;
				Boolean egoera = (Boolean) zelda4;
				EI_TerapeutarenInformazioPertsonala informazioa = new EI_TerapeutarenInformazioPertsonala(
						Nan, izena, helbidea, jaiotzeD, egoera);
				informazioa.frmTerapetuaInfo.setVisible(true);
			}
		});
	}

	private TableRowSorter<DefaultTableModel> terapeutaTaulaSortu(JPanel panel) {
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 12, 684, 271);
		panel.add(scrollPane_1);

		DefaultTableModel modelo1 = new DefaultTableModel();
		table_1 = new JTable(modelo1);
		scrollPane_1.setViewportView(table_1);
		// Instanciamos el TableRowSorter y lo añadimos al JTable
		final TableRowSorter<DefaultTableModel> oredenatzenDuena1 = new TableRowSorter<DefaultTableModel>(
				modelo1);
		table_1.setRowSorter(oredenatzenDuena1);
		table_1.setFillsViewportHeight(true);
		// bakarrik selekzio bat egin ahal izateko
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		terapeutaTaulaBete(modelo1);
		return oredenatzenDuena1;
		
	}

	private void terapeutaTaulaBete(DefaultTableModel modelo1) {
		TerapeutaKudeatzaile tk = TerapeutaKudeatzaile.getInstantzia();
		tk.taulaBete(modelo1);
	}

	private JTabbedPane hasierakoFrameSortu() {
		frmMasterKudeatzailea = new JFrame();
		frmMasterKudeatzailea.setIconImage(Toolkit.getDefaultToolkit().getImage("/home/unai/workspace/Master/Marrazkiak/icon.png"));
		frmMasterKudeatzailea.setTitle("MasTer Kudeatzailea");
		frmMasterKudeatzailea.setBounds(100, 100, 1008, 447);
		frmMasterKudeatzailea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMasterKudeatzailea.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(297, 0, 709, 416);
		frmMasterKudeatzailea.getContentPane().add(tabbedPane);
		return tabbedPane;
	}
}
