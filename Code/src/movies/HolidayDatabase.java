package movies;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * a database that records all holidays
 */
public class HolidayDatabase implements Serializable{
	/**
	 * To identify the version of the class used in Serialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * list of holidays as LocalDate objects
	 */
	private ArrayList<LocalDate> holidays = new ArrayList<LocalDate>();
	
	/**
	 * @return the list of holidays
	 */
	public ArrayList<LocalDate> getHolidays() {
		return holidays;
	}
	
	/**
	 * This method asks staff to input a year, month and day to create a LocalDate object
	 * @return LocalDate
	 */
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
	
	/**
	 * Takes in LocalDate object and prints it in a proper format
	 * @param date
	 */
	public void printDate(LocalDate date) {
		System.out.println(Month.values()[date.getMonthValue()-1].getName() +
				" " + date.getDayOfMonth() + ", " + date.getYear());
	}
	
	/**
	 * This calls createDate and adds the date to the ArrayList of holidays.
	 * Then it calls printDate to print the date that was added to holidays.
	 */
	public void addHoliday() {
		System.out.println("Creating a holiday...");
		LocalDate date = createDate();
		this.holidays.add(date);
		System.out.print("Holiday added on: ");
		printDate(date);
	}
	/**
	 * This prints out the list of existing holidays and asks user to pick one.
	 * The date picked is removed from the list of holidays.
	 */
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
	/**
	 * This calls printDate to print all existing holidays in the database.
	 * If there are no holidays currently, it will print that there are no current holidays in the system.
	 */
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
	/**
	 * This checks whether the input LocalDate object is on the list of holidays.
	 * @param date this is the date to be checked
	 * @return boolean This returns true if date is a holiday; false if it is not
	 */
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
}
