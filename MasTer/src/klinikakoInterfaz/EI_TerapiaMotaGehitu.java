package klinikakoInterfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EI_TerapiaMotaGehitu extends JFrame {
	private JTextField izenaField;
	private JTextField iraupenaField;
	private JTextField prezioaField;

	public EI_TerapiaMotaGehitu() {
		setTitle("TerapiaMota Gehitu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Izena");
		lblNewLabel.setBounds(12, 14, 187, 15);
		getContentPane().add(lblNewLabel);

		izenaField = new JTextField();
		izenaField.setBounds(100, 10, 187, 19);
		getContentPane().add(izenaField);
		izenaField.setColumns(10);

		iraupenaField = new JTextField();
		iraupenaField.setBounds(100, 41, 187, 19);
		getContentPane().add(iraupenaField);

		JLabel lblIraupena = new JLabel("Iraupena");
		lblIraupena.setBounds(12, 45, 187, 15);
		getContentPane().add(lblIraupena);

		prezioaField = new JTextField();
		prezioaField.setColumns(10);
		prezioaField.setBounds(100, 74, 187, 19);
		getContentPane().add(prezioaField);

		JLabel lblPrezioa = new JLabel("Prezioa");
		lblPrezioa.setBounds(12, 78, 187, 15);
		getContentPane().add(lblPrezioa);

		JButton btnGehitu = new JButton("Gehitu");
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (izenaField.getText().equals("")
						|| iraupenaField.getText().equals("")
						|| prezioaField.getText().equals("")) {
					new EI_Error_Hutsuneak();
					izenaField.requestFocus();
				} else {
					TerapiaMotaKudeatzaile.getInstantzia().terapiaMotaGehitu(
							izenaField.getText(),
							Integer.parseInt(iraupenaField.getText()),
							Float.parseFloat(prezioaField.getText()));
					setVisible(false);
				}
			}
		});
		btnGehitu.setBounds(100, 105, 117, 25);
		getContentPane().add(btnGehitu);
		setSize(330, 166);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapiaMotaGehitu frame = new EI_TerapiaMotaGehitu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}