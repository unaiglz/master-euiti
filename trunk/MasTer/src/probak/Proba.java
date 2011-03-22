package probak;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Proba {

	public Calendar sortuData(String str_date) {
		Calendar cal = Calendar.getInstance();
		try {
			DateFormat formatter;
			Date date;
			formatter = new SimpleDateFormat("dd-MM-yyyy");
			date = (Date) formatter.parse(str_date);
			cal.setTime(date);
			System.out.println("Today is " + cal);

		} catch (ParseException e) {
			System.out.println("Exception :" + e);
		}

		return cal;
	}

	public static void main(String[] args) {
		Proba p = new Proba();
		Calendar cal = p.sortuData("26-03-2011");
		
		
		        int day = cal.get(Calendar.DATE);
		        int month = cal.get(Calendar.MONTH)+1;
		        int year = cal.get(Calendar.YEAR);
		        int dow = cal.get(Calendar.DAY_OF_WEEK);
		        int dom = cal.get(Calendar.DAY_OF_MONTH);
		        int doy = cal.get(Calendar.DAY_OF_YEAR);
		
		System.out.println("Current Date: " + cal.getTime());
		        System.out.println("Day: " + day);
		        System.out.println("Month: " + month);
		        System.out.println("Year: " + year);
		        System.out.println("Day of Week: " + dow);
		        System.out.println("Day of Month: " + dom);
		        System.out.println("Day of Year: " + doy);
		
		}
}
