package interfazeak;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EI_Hitzorduaren_Datuak_Erakutsi extends JFrame {
		
	public EI_Hitzorduaren_Datuak_Erakutsi(Vector<String> datuak) {
		getContentPane().setLayout(null);

		JLabel lblHitzorduarenDatuak = new JLabel("Hitzorduaren datuak");
		lblHitzorduarenDatuak.setFont(new Font("Tahoma", Font.BOLD
				| Font.ITALIC, 14));
		lblHitzorduarenDatuak.setBounds(78, 11, 153, 31);
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
		lblData2.setBounds(127, 69, 171, 31);
		getContentPane().add(lblData2);

		JLabel lblTerapeuta2 = new JLabel(datuak.get(1));
		lblTerapeuta2.setBounds(127, 111, 171, 31);
		getContentPane().add(lblTerapeuta2);

		JLabel lblBezeroa2 = new JLabel(datuak.get(2));
		lblBezeroa2.setBounds(127, 153, 171, 31);
		getContentPane().add(lblBezeroa2);

		JLabel lblTerapia2 = new JLabel(datuak.get(3));
		lblTerapia2.setBounds(127, 194, 171, 31);
		getContentPane().add(lblTerapia2);

		JLabel lblOharra2 = new JLabel(datuak.get(4));
		lblOharra2.setBounds(127, 239, 171, 31);
		getContentPane().add(lblOharra2);

		JLabel lblOrdainduta2 = new JLabel(datuak.get(5));
		lblOrdainduta2.setBounds(127, 281, 171, 31);
		getContentPane().add(lblOrdainduta2);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnOnartu.setBounds(98, 323, 89, 23);
		getContentPane().add(btnOnartu);
	}
}
