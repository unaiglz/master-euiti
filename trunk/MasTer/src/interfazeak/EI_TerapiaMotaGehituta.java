package interfazeak;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EI_TerapiaMotaGehituta extends JFrame {

	public EI_TerapiaMotaGehituta(String izena, int iraupena, float prezioa) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"/home/unai/workspace/Master/Marrazkiak/info_icon.png"));
		setTitle("TerapiaMota Gehituta");
		getContentPane().setLayout(null);

		JLabel lblTerapiamotaBerriaGehitu = new JLabel(
				"TerapiaMota berria gehitu da:");
		lblTerapiamotaBerriaGehitu.setBounds(76, 22, 244, 21);
		getContentPane().add(lblTerapiamotaBerriaGehitu);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Panel.background"));
		textArea.setBounds(49, 50, 259, 61);
		getContentPane().add(textArea);

		JLabel image = new JLabel("");
		image.setBounds(12, 8, 60, 48);
		image.setIcon(new ImageIcon(
				"/home/unai/workspace/Master/Marrazkiak/info_icon.png"));
		getContentPane().add(image);

		String mezua = "Terapiaren izena: \t " + izena + "\n"
				+ "Terapiaren iraupena: \t " + iraupena + "\n"
				+ "Terapiaren Prezioa:  \t " + prezioa;
		textArea.setText(mezua);
		setVisible(true);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnOnartu.setBounds(115, 110, 117, 25);
		getContentPane().add(btnOnartu);
		setSize(340, 179);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapiaMotaGehituta frame = new EI_TerapiaMotaGehituta(
							"JAJA", 1, 1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
