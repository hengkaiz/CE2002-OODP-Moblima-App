package movies;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;

public class HolidayDatabase implements Serializable{
	private ArrayList<LocalDate> holidays = new ArrayList<LocalDate>();
	
	public ArrayList<LocalDate> getHolidays() {
		return holidays;
	}
	
	public LocalDate createDate() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter year: ");
		int yearChosen = sc.nextInt();
		
		int i=1;
		System.out.println("Choose month: ");
		for (Month month : Month.values()) {
			System.out.println(i + ". " +month.getName());
			i++;
		}
		int monthChosen = sc.nextInt();
		
		YearMonth yearMonthObject = YearMonth.of(yearChosen, monthChosen);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		
		System.out.print("Choose date from 1 to " + daysInMonth + ": ");
		int dayChosen = sc.nextInt();
		
		return LocalDate.of(yearChosen, monthChosen, dayChosen);
	}
	
	public void printDate(LocalDate date) {
		System.out.println(Month.values()[date.getMonthValue()-1].getName() +
				" " + date.getDayOfMonth() + ", " + date.getYear());
	}
	
	public void addHoliday() {
		System.out.println("Creating a holiday...");
		LocalDate date = createDate();
		this.holidays.add(date);
		System.out.print("Holiday added on: ");
		printDate(date);
	}
	
	public void removeHoliday() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the holiday to remove: ");
		int i=1;
		for(LocalDate date : holidays) {
			System.out.print(i + ". ");
			printDate(date);
			i++;
		}
		
		int chosenDate = sc.nextInt();
		System.out.print("Removing holiday: ");
		printDate(holidays.get(chosenDate-1));
		
		holidays.remove(chosenDate-1);
	}
	
	public void printHolidays() {
		if(holidays.size() == 0) {
			System.out.println("There are no current holidays in the system");
			return;
		}
		System.out.println("These are the current holidays in the system: ");
		int i=1;
		for (LocalDate date : holidays) {
			System.out.print(i + ". ");
			printDate(date);
			i++;
		}
	}
	public boolean isHoliday(LocalDate date) {
		for (LocalDate holiday : holidays)
			if (date==holiday)
				return true;
		return false;
	}
	
//	public static void main(String[] args) {
//		Holiday holiday = new Holiday();
//		holiday.addHoliday();
//		holiday.printHolidays();
//		holiday.addHoliday();
//		holiday.printHolidays();
//		holiday.removeHoliday();
//		holiday.printHolidays();
//	}
}	//comment
//comment
