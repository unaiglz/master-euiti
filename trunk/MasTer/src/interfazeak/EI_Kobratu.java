package interfazeak;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import datuBaseKonexioa.DBKudeatzaile;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class EI_Kobratu extends JFrame{
		
		public EI_Kobratu(String Nan) {
			setIconImage(Toolkit.getDefaultToolkit().getImage("/home/unai/workspace/Master/Marrazkiak/icon.png"));
		setTitle("Kobratu");
		getContentPane().setLayout(null);
		
		//kobrantzaren agiria sortzeko
		JButton btnAgiriaAtera = new JButton("Inprimatu");
		btnAgiriaAtera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//new Agiria(dataOrdua, terapeutaID, bezeroID, terapiaMotaID);
			}
		});
		
		btnAgiriaAtera.setBounds(147, 214, 144, 23);
		getContentPane().add(btnAgiriaAtera);
		
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1= "SELECT dataOrdua, terapeutaID, bezeroID, terpiaMotaID From Hitzordu WHERE bezeroID='" + Nan + "' AND kobratu='0'";
		ResultSet rs = dbk.execSQL(K1);
		sartuTuplak(rs);
		this.setVisible(true);
	}

	private void sartuTuplak(ResultSet rs) {
		//taula sortuko dugu SQL emaitzarekin
			DefaultTableModel modelo = new DefaultTableModel();
			JTable tabla = new JTable(modelo);
			
			modelo.addColumn("dataOrdua");
			modelo.addColumn("terapiaID");
			modelo.addColumn("bezeroID");
			modelo.addColumn("terapiaMotaID");
			
			try {
				while(rs.next()){
					Vector<String> fila =new Vector<String>();
									
					fila.add(rs.getString("dataOrdua"));
					fila.add(rs.getString("terapiaID"));
					fila.add(rs.getString("bezeroID"));
					fila.add(rs.getString("terapiaMotaID"));
					
				modelo.addRow(fila);
				}
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(12, 12, 684, 271);
				tabla.add(scrollPane_1);
				this.getContentPane().add(tabla);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
}	
}
