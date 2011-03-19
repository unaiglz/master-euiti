package interfazeak;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import kudeatzaileak.TerapeutaKudeatzaile;

public class EI_TerapeutaDatuAldaketa extends JFrame {
	private JTextField textIzena;
	private JTextField textHelbidea;
	JComboBox comboBox;
	private JTextField textField;

	public EI_TerapeutaDatuAldaketa(final String id, String izena,
			String helbidea, int aktiboa) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		setTitle("Terapeuta Datuak");
		getContentPane().setLayout(null);

		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(44, 53, 70, 15);
		getContentPane().add(lblIzena);

		JLabel lblHelbidea = new JLabel("Helbidea:");
		lblHelbidea.setBounds(44, 80, 70, 15);
		getContentPane().add(lblHelbidea);

		JLabel lblAktiboa = new JLabel("Aktiboa:");
		lblAktiboa.setBounds(44, 136, 70, 15);
		getContentPane().add(lblAktiboa);

		textIzena = new JTextField(izena);
		textIzena.setBounds(161, 51, 197, 19);
		getContentPane().add(textIzena);
		textIzena.setColumns(10);

		textHelbidea = new JTextField(helbidea);
		textHelbidea.setColumns(10);
		textHelbidea.setBounds(161, 78, 197, 19);
		getContentPane().add(textHelbidea);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Bai", "Ez" }));
		comboBox.setBounds(161, 131, 57, 24);
		getContentPane().add(comboBox);
		if (aktiboa == 1) {
			comboBox.setSelectedItem("Bai");
		} else {
			comboBox.setSelectedItem("Ez");
		}

		JButton btnOnartu = new JButton("Onartu");
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textIzena.getText().equals("")
						|| textHelbidea.getText().equals("")) {
					new EI_Error_Hutsuneak();
					textIzena.requestFocus();
				} else {
					if (comboBox.getSelectedItem() == "Bai") {
						TerapeutaKudeatzaile.getInstantzia().terapeutaAldatu(
								id, textIzena.getText(),
								textHelbidea.getText(), 1);
					} else {
						TerapeutaKudeatzaile.getInstantzia().terapeutaAldatu(
								id, textIzena.getText(),
								textHelbidea.getText(), 0);
					}

					setVisible(false);
				}
			}
		});
		btnOnartu.setBounds(59, 182, 117, 25);
		getContentPane().add(btnOnartu);

		JLabel image = new JLabel("");
		image.setBounds(364, 19, 57, 49);
		image.setIcon(new ImageIcon(
				"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		getContentPane().add(image);

		JLabel lblTerapeutarenDatuenAldaketa = new JLabel(
				"Terapeutaren datuen aldaketa hemen egin:");
		lblTerapeutarenDatuenAldaketa.setBounds(33, 12, 325, 15);
		getContentPane().add(lblTerapeutarenDatuenAldaketa);

		JLabel lblJaiotzeData = new JLabel("Jaiotze Data:");
		lblJaiotzeData.setBounds(44, 109, 110, 15);
		getContentPane().add(lblJaiotzeData);

		textField = new JTextField("<dynamic>");
		textField.setColumns(10);
		textField.setBounds(161, 107, 197, 19);
		getContentPane().add(textField);

		JButton btnPassAldatu = new JButton("Pass Aldatu");
		btnPassAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EI_Pasahitza_Aldatu(id);
			}
		});
		btnPassAldatu.setBounds(214, 182, 144, 25);
		getContentPane().add(btnPassAldatu);

		textIzena.requestFocus();
		setVisible(true);
		setSize(423, 296);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapeutaDatuAldaketa frame = new EI_TerapeutaDatuAldaketa(
							"1", "Junito", "Kantoi", 1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
