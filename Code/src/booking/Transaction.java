package booking;

import cinema.*;

import java.time.LocalDateTime;
import java.text.SimpleDateFormat;

//format: XXXYYYYMMDDhhmm, X:cinema code
public class Transaction {
	
	public String yearToString() {
		LocalDateTime now = LocalDateTime.now();
		String year = Integer.toString(now.getYear());
		return year;	
	}
	
	public String monthToString() {
		LocalDateTime now = LocalDateTime.now();
		String month = Integer.toString(now.getMonthValue());
		
		if (now.getMonthValue() < 10)
			month = ("0" + month);
		return month;
	}
	
	public String dayToString() {
		LocalDateTime now = LocalDateTime.now();
		int intday = now.getDayOfMonth();
		String day = Integer.toString(intday);
		
		if (now.getDayOfMonth() < 10)
			day = ("0" + day);
		return day;
	}
	
	public String hourToString() {
		LocalDateTime now = LocalDateTime.now();
		String hour = Integer.toString(now.getHour());
		
		if (now.getHour() < 10)
			hour = ("0" + hour);
		
		return hour;
	}
	
	public String minuteToString() {
		LocalDateTime now = LocalDateTime.now();
		String minute = Integer.toString(now.getMinute());
		
		if (now.getMinute() < 10)
			minute = ("0" + minute);
		
		return minute;
	}
	
	public String makeTID(String username, Cinema cinema) {
		String code = Integer.toString(cinema.getCode());
		String TID = null;
		
		TID.concat(code);
		TID.concat(yearToString());
		TID.concat(monthToString());
		TID.concat(dayToString());
		TID.concat(hourToString());
		TID.concat(minuteToString());
		
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

