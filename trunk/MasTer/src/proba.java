import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.toedter.calendar.JCalendar;

public class proba extends JFrame {
	public proba() {
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel((Icon) new JCalendar());
		lblNewLabel.setBounds(45, 55, 70, 15);
		getContentPane().add(lblNewLabel);
	}

}
