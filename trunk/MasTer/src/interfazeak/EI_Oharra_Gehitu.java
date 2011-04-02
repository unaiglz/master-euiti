package interfazeak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class EI_Oharra_Gehitu {

	private JFrame frmOharGehiketaInterfazea;
	JEditorPane editorPane ;
	private EI_Tratatu inst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//EI_Oharra_Gehitu window = new EI_Oharra_Gehitu();
					//window.frmOharGehiketaInterfazea.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param inst 
	 * @wbp.parser.entryPoint
	 */
	public EI_Oharra_Gehitu(EI_Tratatu inst) {
		this.inst= inst;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// cuando le de al JButton llama a EI_Tratatu para que guarde los datos
		frmOharGehiketaInterfazea = new JFrame();
		frmOharGehiketaInterfazea.setIconImage(Toolkit.getDefaultToolkit().getImage("/home/unai/workspace/Master/Marrazkiak/icon.png"));
		frmOharGehiketaInterfazea.setTitle("Ohar Gehiketa: Interfazea");
		frmOharGehiketaInterfazea.setBounds(100, 100, 450, 300);
		frmOharGehiketaInterfazea.setSize(585, 346);
		frmOharGehiketaInterfazea.setVisible(true);
		frmOharGehiketaInterfazea.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 46, 497, 205);
		frmOharGehiketaInterfazea.getContentPane().add(scrollPane);
		
		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(12, 0, 129, 21);
		frmOharGehiketaInterfazea.getContentPane().add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmHasieratu = new JMenuItem("Hasieratu");
		mntmHasieratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editorPane.setText("Idatzi hemen...");
				editorPane.requestFocus();
			}
		});
		mnMenu.add(mntmHasieratu);
		
		JMenuItem mntmIrten = new JMenuItem("Irten");
		mntmIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmOharGehiketaInterfazea.setVisible(false);
			}
		});
		mnMenu.add(mntmIrten);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inst.setIdatzitakoOharra(editorPane.getText());
			}
		});
		btnGorde.setFont(new Font("Dialog", Font.BOLD, 13));
		btnGorde.setBounds(233, 277, 117, 25);
		frmOharGehiketaInterfazea.getContentPane().add(btnGorde);
		
		JLabel lblIdatziNahiDuzun = new JLabel("Idatzi nahi duzun oharra:");
		lblIdatziNahiDuzun.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblIdatziNahiDuzun.setBounds(185, 24, 212, 15);
		frmOharGehiketaInterfazea.getContentPane().add(lblIdatziNahiDuzun);
		
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(
		"/home/unai/workspace/Master/Marrazkiak/icon.png"));
		img.setBounds(521, 0, 50, 49);
		frmOharGehiketaInterfazea.getContentPane().add(img);
	}
}
