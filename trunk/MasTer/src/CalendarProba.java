import java.util.Calendar;

import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;
import javax.swing.JTable;

public class CalendarProba {

	private Calendar cal = Calendar.getInstance();

	public CalendarProba() {
		JCalendar calendar = new JCalendar();
		System.out.println(cal.getTime());
	}

	public static void main(String[] args) {
		CalendarProba inst = new CalendarProba();
	}

}
