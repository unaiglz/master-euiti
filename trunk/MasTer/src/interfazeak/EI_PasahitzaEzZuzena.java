package interfazeak;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class EI_PasahitzaEzZuzena extends  JFrame{
	public EI_PasahitzaEzZuzena() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/unai/workspace/Master/Marrazkiak/error_icon.png"));
		setTitle("ERROR: Pasahitza");
		getContentPane().setLayout(null);
		
		JLabel lblPasahitzaTxartoSartu = new JLabel("Pasahitza txarto sartu duzu");
		lblPasahitzaTxartoSartu.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPasahitzaTxartoSartu.setBounds(96, 12, 199, 46);
		getContentPane().add(lblPasahitzaTxartoSartu);
		
		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnOnartu.setBounds(96, 63, 117, 25);
		getContentPane().add(btnOnartu);
		
		JLabel img = new JLabel("");
		img.setBounds(25, 12, 48, 46);
		img.setIcon(new ImageIcon(
		"/home/unai/workspace/Master/Marrazkiak/error_icon.png"));
		getContentPane().add(img);
		setSize(324,132);
	}
}
