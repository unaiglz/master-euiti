package interfazeak;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EI_PasahitzaEzZuzena extends  JFrame{
	public EI_PasahitzaEzZuzena() {
		getContentPane().setLayout(null);
		
		JLabel lblPasahitzaTxartoSartu = new JLabel("Pasahitza txarto sartu duzu");
		lblPasahitzaTxartoSartu.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPasahitzaTxartoSartu.setBounds(58, 12, 199, 46);
		getContentPane().add(lblPasahitzaTxartoSartu);
		
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnOnartu.setBounds(96, 58, 117, 25);
		getContentPane().add(btnOnartu);
	}
}
