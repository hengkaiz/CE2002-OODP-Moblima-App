package booking;

import cinema.*;

import java.time.LocalDateTime;
import java.text.SimpleDateFormat;

//format: XXXYYYYMMDDhhmm, X:cinema code
/**
 * 
 * This represents the transaction
 */
public class Transaction {
	/**
	 * changes current year to string
	 * @return year in string format
	 */
	public String yearToString() {
		LocalDateTime now = LocalDateTime.now();
		String year = Integer.toString(now.getYear());
		return year;	
	}
	/**
	 * changes current month to string
	 * @return year in month format
	 */
	public String monthToString() {
		LocalDateTime now = LocalDateTime.now();
		String month = Integer.toString(now.getMonthValue());
		
		if (now.getMonthValue() < 10)
			month = ("0" + month);
		return month;
	}
	/**
	 * changes current day to string
	 * @return day in string format
	 */
	public String dayToString() {
		LocalDateTime now = LocalDateTime.now();
		int intday = now.getDayOfMonth();
		String day = Integer.toString(intday);
		
		if (now.getDayOfMonth() < 10)
			day = ("0" + day);
		return day;
	}
	/**
	 * changes current hour to string
	 * @return hour in string format
	 */
	public String hourToString() {
		LocalDateTime now = LocalDateTime.now();
		String hour = Integer.toString(now.getHour());
		
		if (now.getHour() < 10)
			hour = ("0" + hour);
		
		return hour;
	}
	/**
	 * changes current minute to string
	 * @return minute in string format
	 */
	public String minuteToString() {
		LocalDateTime now = LocalDateTime.now();
		String minute = Integer.toString(now.getMinute());
		
		if (now.getMinute() < 10)
			minute = ("0" + minute);
		
		return minute;
	}
	/**
	 * creates a transaction ID, using the date of booking, username and showtime as it parameters
	 * @param username input for user's username
	 * @param st input for showtime
	 * @return transaction ID 
	 */
	public String makeTID(String username, ShowTime st) {
		String TID = "";
		
		TID = TID.concat(st.getCinemeCode());
		TID = TID.concat(yearToString());
		TID = TID.concat(monthToString());
		TID = TID.concat(dayToString());
		TID = TID.concat(hourToString());
		TID = TID.concat(minuteToString());
		
		return TID;
	}
	
//	//test test only
//	public static void main(String[] args) {
//		LocalDateTime now = LocalDateTime.now();
//		int intyear = now.getYear();
//		String year = Integer.toString(intyear);
//		System.out.println(year);
//		
//		LocalDateTime now1 = LocalDateTime.now();
//		int intmonth = now1.getMonthValue();
//		String month = Integer.toString(intmonth);
//		System.out.println(month);
//		
//		LocalDateTime now2 = LocalDateTime.now();
//		String hour = Integer.toString(now2.getHour());
//		
//		if (now2.getHour() < 10)
//			hour=("0" + hour);
//		System.out.println(hour);
//	}	
	
}

