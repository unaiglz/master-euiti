package interfazeak;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import datuBaseKonexioa.DBKudeatzaile;

import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EI_Hitzorduaren_Datuak_Erakutsi extends JFrame {
	
	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		
	public EI_Hitzorduaren_Datuak_Erakutsi(Vector<String> datuak) {
		getContentPane().setLayout(null);

		JLabel lblHitzorduarenDatuak = new JLabel("Hitzorduaren datuak");
		lblHitzorduarenDatuak.setFont(new Font("Tahoma", Font.BOLD
				| Font.ITALIC, 14));
		lblHitzorduarenDatuak.setBounds(137, 11, 153, 31);
		getContentPane().add(lblHitzorduarenDatuak);

		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblData.setBounds(10, 69, 119, 31);
		getContentPane().add(lblData);

		JLabel lblTerapeuta = new JLabel("Terapeuta:");
		lblTerapeuta.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTerapeuta.setBounds(10, 111, 119, 31);
		getContentPane().add(lblTerapeuta);

		JLabel lblBezeroa = new JLabel("Bezeroa:");
		lblBezeroa.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBezeroa.setBounds(10, 153, 119, 31);
		getContentPane().add(lblBezeroa);

		JLabel lblTerapia = new JLabel("Terapia:");
		lblTerapia.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTerapia.setBounds(10, 191, 119, 37);
		getContentPane().add(lblTerapia);

		JLabel lblOharra = new JLabel("Oharra:");
		lblOharra.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblOharra.setBounds(10, 239, 119, 31);
		getContentPane().add(lblOharra);

		JLabel lblOrdainduta = new JLabel("Ordainduta:");
		lblOrdainduta.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblOrdainduta.setBounds(10, 281, 119, 31);
		getContentPane().add(lblOrdainduta);

		JLabel lblData2 = new JLabel(datuak.get(0));
		lblData2.setBounds(128, 69, 153, 31);
		getContentPane().add(lblData2);

		JLabel lblTerapeuta2 = new JLabel(datuak.get(1));
		lblTerapeuta2.setBounds(128, 111, 153, 31);
		getContentPane().add(lblTerapeuta2);

		JLabel lblBezeroa2 = new JLabel(datuak.get(2));
		lblBezeroa2.setBounds(128, 153, 153, 31);
		getContentPane().add(lblBezeroa2);

		JLabel lblTerapia2 = new JLabel(datuak.get(3));
		lblTerapia2.setBounds(128, 194, 153, 31);
		getContentPane().add(lblTerapia2);

		JLabel lblOharra2 = new JLabel(datuak.get(4));
		lblOharra2.setBounds(128, 239, 153, 31);
		getContentPane().add(lblOharra2);

		JLabel lblOrdainduta2 = new JLabel(datuak.get(5));
		lblOrdainduta2.setBounds(128, 281, 153, 31);
		getContentPane().add(lblOrdainduta2);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnOnartu.setBounds(169, 327, 89, 23);
		getContentPane().add(btnOnartu);
		
		JButton btnDataAldatu = new JButton("Aldatu");
		btnDataAldatu.setBounds(285, 73, 89, 23);
		getContentPane().add(btnDataAldatu);
		
		JButton btnTerapeutaAldatu = new JButton("Aldatu");
		btnTerapeutaAldatu.setBounds(285, 115, 89, 23);
		getContentPane().add(btnTerapeutaAldatu);
		
		JButton btnTerapiaMotaAldatu = new JButton("Aldatu");
		btnTerapiaMotaAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Terapia mota lortuko dugu eta terapeuta hori egin 
				//dezakeen begiratuko dugu, bestela errore mezua agertuko da
				String terapiaMota = lblTerapia2.getText();
				String terapeuta = lblTerapeuta2.getText();
				String k1 = "SELECT * FROM Formakuntza " +
						"WHERE erabltzaileaID='" + terapeuta + "' AND" +
								"terapiaMotaID='" + terapiaMota + "'";
				ResultSet emaitza1 = dbk.execSQL(k1);
				emaitza1.next();
				if(emaitza1.getRow() == 0){
					//Terapeuta ezin du terapia hori egin eta orduan
					//terapia hori egin dezaketen terapeutak erakutsi behar da
					
				}else {
					//Ondo dago beraz ez da ezer egin behar, hau ezabatu behar da
				}
				
				
			}
		});
		btnTerapiaMotaAldatu.setBounds(285, 198, 89, 23);
		getContentPane().add(btnTerapiaMotaAldatu);
	}
}
