package interfazeak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EI_BezeroaGehituta extends JFrame {

	private JPanel contentPane;
	private static String nan, izena, jaiotzeData, helbidea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_BezeroaGehituta frame = new EI_BezeroaGehituta(nan,
							izena, jaiotzeData, helbidea);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EI_BezeroaGehituta(String nan, String izena, String jaiotzeData,
			String helbidea) {
		setTitle("Bezeroa Ondo Gehituta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBezeroaOndoSartu = new JLabel("Bezeroa ondo sartu egin da:");
		lblBezeroaOndoSartu.setBounds(136, 47, 203, 15);
		contentPane.add(lblBezeroaOndoSartu);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setBounds(69, 80, 336, 115);
		contentPane.add(textArea);
		this.nan = nan;
		this.izena = izena;
		this.jaiotzeData = jaiotzeData;
		this.helbidea = helbidea;
		String mezua = "Bezeroaren NAN: \t " + nan + "\n\n"
				+ "Bezeroaren izena: \t " + izena + "\n\n"
				+ "Bezeroaren jaiotze data:  \t " + jaiotzeData + "\n\n"
				+ "Bezeroaren helbidea: \t" + helbidea;
		textArea.setText(mezua);

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnOnartu.setBounds(222, 231, 117, 25);
		contentPane.add(btnOnartu);
	}
}
