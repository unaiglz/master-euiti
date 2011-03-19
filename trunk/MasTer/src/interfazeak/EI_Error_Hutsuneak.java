package interfazeak;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EI_Error_Hutsuneak extends JFrame {
	public EI_Error_Hutsuneak() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"/home/unai/workspace/Master/Marrazkiak/error.png"));
		setTitle("ERROR");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Ezin da hutsunerik libre utzi!!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.ITALIC, 14));
		lblNewLabel.setBounds(80, 12, 241, 80);
		getContentPane().add(lblNewLabel);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnOnartu.setBounds(80, 104, 117, 25);
		getContentPane().add(btnOnartu);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(32, 12, 48, 80);
		lblNewLabel_1.setIcon(new ImageIcon(
				"/home/unai/workspace/Master/Marrazkiak/error_icon.png"));
		getContentPane().add(lblNewLabel_1);
		setSize(310, 190);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_Error_Hutsuneak frame = new EI_Error_Hutsuneak();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
