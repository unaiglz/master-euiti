import java.sql.Date;
import java.util.Calendar;

import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;
import javax.swing.JTable;

public class CalendarProba {

	private Calendar cal = Calendar.getInstance();
	java.util.Date utilDate = new java.util.Date(); // fecha actual
	long lnMilisegundos = utilDate.getTime();
	private Date dat = new Date(lnMilisegundos);

	public CalendarProba() {
		JCalendar calendar = new JCalendar();
		System.out.println(cal.getTime());
		System.out.println(dat);

	}

	public static void main(String[] args) {
		CalendarProba inst = new CalendarProba();
	}

}
