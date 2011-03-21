package interfazeak;

import java.awt.EventQueue;

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
import java.sql.ResultSet;
import java.util.Vector;

import klinikakoInterfaz.EI_Idazkaria;
import kudeatzaileak.HitzorduKudeatzailea;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class EI_TerapeutaLibreak {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutaLibreak window = new EI_TerapeutaLibreak(null);
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
	public EI_TerapeutaLibreak(ResultSet rs) {
		initialize(rs);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ResultSet rs) {
		frame = new JFrame();
		frame.setBounds(100, 100, 352, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTerapeutaLibreenZerrenda = new JLabel("Terapeuta libreen zerrenda");
		lblTerapeutaLibreenZerrenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTerapeutaLibreenZerrenda.setBounds(58, 11, 231, 28);
		frame.getContentPane().add(lblTerapeutaLibreenZerrenda);
		
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnOnartu.setBounds(77, 269, 101, 28);
		frame.getContentPane().add(btnOnartu);
		
		JButton btnEzeztatu = new JButton("Ezeztatu");
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EI_Idazkaria eiIdazkaria = new EI_Idazkaria();
			}
		});
		btnEzeztatu.setBounds(188, 269, 101, 28);
		frame.getContentPane().add(btnEzeztatu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 57, 302, 200);
		frame.getContentPane().add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);
     // Instanciamos el TableRowSorter y lo añadimos al JTable
        final TableRowSorter<DefaultTableModel> oredenatzenDuena = new TableRowSorter<DefaultTableModel>(model);
        table.setRowSorter(oredenatzenDuena);
        table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		HitzorduKudeatzailea hk = HitzorduKudeatzailea.getInstantzia();
		hk.taulaBete(model,rs);
		//bakarrik selekzio bat egin ahal izateko
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
}
