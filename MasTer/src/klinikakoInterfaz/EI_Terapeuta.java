package klinikakoInterfaz;

import interfazeak.EI_BezeroaInfo;
import interfazeak.EI_Tratatu;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import kudeatzaileak.TerapeutaKudeatzaile;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import datuBaseKonexioa.Clock;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.Toolkit;

public class EI_Terapeuta {

	private JFrame frmTerapeuta;
	private JTable table;
	private JTextField textField;
	private String terapeutaNAN;
	private JPanel panel;

	public String getTerapeutaNAN() {
		return terapeutaNAN;
	}

	public void setTerapeutaNAN(String terapeutaNAN) {
		this.terapeutaNAN = terapeutaNAN;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_Terapeuta window = new EI_Terapeuta(null);
					window.frmTerapeuta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EI_Terapeuta(String terapeutaNAN) {
		initialize(terapeutaNAN);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String terapeutaNAN) {
		frmTerapeuta = new JFrame();
		frmTerapeuta.setIconImage(Toolkit.getDefaultToolkit().getImage("/home/unai/workspace/Master/Marrazkiak/icon.png"));
		frmTerapeuta.getContentPane().setEnabled(false);
		frmTerapeuta.setTitle("Terapeuta Interfaz");
		frmTerapeuta.setBounds(100, 100, 1008, 447);
		frmTerapeuta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTerapeuta.getContentPane().setLayout(null);
		setTerapeutaNAN(terapeutaNAN);

		panel = new JPanel();
		panel.setBounds(0, 0, 1006, 417);
		frmTerapeuta.getContentPane().add(panel);
		panel.setLayout(null);

		final TableRowSorter<DefaultTableModel> ordenatzenDuena = taula(
				terapeutaNAN, panel);

		tratatuBotoia(panel);

		birkargatuBotoia(panel);

		bilaketa(panel, ordenatzenDuena);

		bezeroaIkusiBotoia(panel);

		bigarrenAtalaSortu();
	}

	private void bigarrenAtalaSortu() {
		JPanel calendarPanel = new JPanel();
		calendarPanel.setBounds(12, 30, 273, 181);
		panel.add(calendarPanel);

		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().setLocation(15, 24);
		calendarPanel.add(calendar);

		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		img.setBounds(116, 223, 50, 49);
		panel.add(img);

		JLabel kudVersion = new JLabel("MasTer Kud v1.0");
		kudVersion.setBounds(82, 290, 118, 15);
		panel.add(kudVersion);

		JPanel clockPanel = new JPanel();
		Clock clock = new Clock();
		clock.start();
		clockPanel.add(clock.getTime());
		clockPanel.setBounds(82, 362, 118, 27);
		panel.add(clockPanel);

		frmTerapeuta.setVisible(true);
	}

	private void tratatuBotoia(JPanel panel) {
		JButton btnOharraGehitu = new JButton("Hitzordua Tratatu");
		btnOharraGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object dataOrdua = table.getValueAt(table.getSelectedRow(), 0);
				Object bezeroID = table.getValueAt(table.getSelectedRow(), 1);
				Object terapiaID = table.getValueAt(table.getSelectedRow(), 2);
				EI_Tratatu tratatu = new EI_Tratatu(dataOrdua.toString(),
						getTerapeutaNAN(), bezeroID.toString(), terapiaID
								.toString());
			}
		});
		btnOharraGehitu.setBounds(289, 380, 168, 25);
		panel.add(btnOharraGehitu);
	}

	private TableRowSorter<DefaultTableModel> taula(String terapeutaNAN,
			JPanel panel) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(289, 40, 705, 270);
		panel.add(scrollPane);

		DefaultTableModel modelo = new DefaultTableModel();
		// Instanciamos el TableRowSorter y lo añadimos al JTable
		table = new JTable(modelo);
		final TableRowSorter<DefaultTableModel> ordenatzenDuena = new TableRowSorter<DefaultTableModel>(
				modelo);

		table.setRowSorter(ordenatzenDuena);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		// bakarrik selekzio bat egin ahal izateko
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TerapeutaKudeatzaile tk = TerapeutaKudeatzaile.getInstantzia();
		tk.terapeutaInterfazTaulaBete(modelo, terapeutaNAN);

		JLabel lblHauDaZure = new JLabel("Eguneko Agenda:");
		lblHauDaZure.setBounds(289, 12, 149, 15);
		panel.add(lblHauDaZure);
		return ordenatzenDuena;
	}

	private void bezeroaIkusiBotoia(JPanel panel) {
		JButton btnBezeroaIkusi = new JButton("Bezeroa Ikusi");
		btnBezeroaIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object bezeroID = table.getValueAt(table.getSelectedRow(), 1);
				try {
					EI_BezeroaInfo infor = new EI_BezeroaInfo(bezeroID
							.toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBezeroaIkusi.setBounds(518, 380, 149, 25);
		panel.add(btnBezeroaIkusi);
	}

	private void bilaketa(JPanel panel,
			final TableRowSorter<DefaultTableModel> ordenatzenDuena) {
		textField = new JTextField();
		textField.setBounds(387, 325, 420, 19);
		panel.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				filtroa();
			}

			public void filtroa() {
				// TODO Auto-generated method stub
				// Obtiene el valor del JTextField para el filtro
				String filtro = textField.getText();
				ordenatzenDuena.setRowFilter(RowFilter.regexFilter(filtro, 1));
			}
		});

		JLabel lblBilaketa = new JLabel("Bilaketa:");
		lblBilaketa.setBounds(299, 327, 70, 15);
		panel.add(lblBilaketa);
	}

	private void birkargatuBotoia(JPanel panel) {
		JButton btnBirkargatu = new JButton("Birkargatu");
		btnBirkargatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modelo = new DefaultTableModel();
				TerapeutaKudeatzaile tk = TerapeutaKudeatzaile.getInstantzia();
				tk.terapeutaInterfazTaulaBete(modelo, getTerapeutaNAN());
				table.setModel(modelo);
				TableRowSorter<DefaultTableModel> oredenatzenDuena = new TableRowSorter<DefaultTableModel>(
						modelo);
				table.setRowSorter(oredenatzenDuena);
			}
		});
		btnBirkargatu.setBounds(877, 322, 117, 25);
		panel.add(btnBirkargatu);
	}
}
