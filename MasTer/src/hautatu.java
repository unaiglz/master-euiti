import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class hautatu extends JFrame implements ActionListener {
	private String[] taldekoak = { "Lander", "Oliver", "Jagoba", "Unai" };
	private JFrame frame = new JFrame("-Hautaketa-");
	private JPanel panela = new JPanel();
	private JLabel labelZuz = new JLabel("Zuzendaria:");
	private JLabel labelIdaz = new JLabel("Idazkaria:");
	private JTextArea textZuz = new JTextArea();
	private JTextArea textIda = new JTextArea();
	private JButton botoia = new JButton("Berdinak");

	public hautatu() {
		leihoaPrestatu();
		marron();
		frame.setVisible(true);
		frame.pack();
	}

	private void marron() {
		String idazkari = taldekoak[(int) (Math.random() * 4)];
		textIda.setText(idazkari);
		String zuzendari = taldekoak[(int) (Math.random() * 4)];
		while (zuzendari == idazkari) {
			zuzendari = taldekoak[(int) (Math.random() * 4)];
		}
		textZuz.setText(zuzendari);
	}

	private void leihoaPrestatu() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
		frame.getContentPane().add(panela);
		panela.add(labelIdaz);
		panela.add(textIda);
		panela.add(labelZuz);
		panela.add(textZuz);
		panela.add(botoia);
		botoia.addActionListener(this);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				hautatu EI = new hautatu();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		marron();
	}

}
