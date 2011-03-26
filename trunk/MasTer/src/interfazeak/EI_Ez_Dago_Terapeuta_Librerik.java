package interfazeak;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EI_Ez_Dago_Terapeuta_Librerik extends JFrame {

	public EI_Ez_Dago_Terapeuta_Librerik(String date, String time,
			String terapiaMota) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"/home/unai/workspace/Master/Marrazkiak/error_icon.png"));
		setAlwaysOnTop(true);
		setVisible(true);
		setSize(407,168);
		setTitle("ERROR: Terapeutarik EZ");
		getContentPane().setLayout(null);

		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(
				"/home/unai/workspace/Master/Marrazkiak/error_icon.png"));
		img.setBounds(43, 32, 48, 49);
		getContentPane().add(img);

		JTextArea mezua = new JTextArea(
				date
						+ "\t"
						+ time
						+ " \n -en ez dago terapeuta librerik \n terapia honetarako: \t"
						+ terapiaMota);
		mezua.setBackground(UIManager.getColor("Panel.background"));
		mezua.setForeground(Color.BLACK);
		mezua.setBounds(115, 32, 277, 63);
		getContentPane().add(mezua);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			}
		});
		btnOnartu.setBounds(145, 99, 117, 25);
		getContentPane().add(btnOnartu);

	}

}
