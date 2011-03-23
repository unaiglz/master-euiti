import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;

import datuBaseKonexioa.Clock;

import javax.swing.JLabel;

public class probaA {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					probaA window = new probaA();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public probaA() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 637, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel cal = new JPanel();
		cal.setBounds(47, 23, 267, 181);
		frame.getContentPane().add(cal);
		cal.add(new JCalendar());

		Clock clock = new Clock();
		clock.start();
		clock.time.setBounds(244, 285, 70, 15);
		frame.getContentPane().add(clock.time);

	}
}
