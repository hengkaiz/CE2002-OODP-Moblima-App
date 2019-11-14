package admin;

import java.util.Scanner;
import movies.*;

public class ConfigureSystemSettings {

	/*public ConfigureSystemSettings() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	
	Scanner sc = new Scanner(System.in);
	
	public void updateTicketPrice(TicketPriceCalculator ticketPrice) {
		int updateChoice=0;
		do {
			//print current prices
			System.out.println("-----Current Prices----");
			System.out.println("Current base price: " + ticketPrice.getBasePrice());
			System.out.println("Current price offsets: ");
			System.out.println("1. Weekend/PH Surcharge: " + ticketPrice.getWeekendOrPHSurcharge());
			System.out.println("2. Student/Senior Discount: " + ticketPrice.getAgeDiscount());
			System.out.println("3. Platinum Surcharge: " + ticketPrice.getPlatinumSurcharge());
			System.out.println("4. Gold Class Surcharge: " + ticketPrice.getGoldClassSurcharge());
			System.out.println("5. 3D Surcharge: " + ticketPrice.getThreeDimensionMovieSurcharge());
			System.out.println("6. Blockbuster Surcharge: " + ticketPrice.getBlockbusterMovieSurcharge());
			
			//choose which to update
			System.out.println();
			System.out.println("What would you like to update?");
			System.out.println("1. Change Base Price");
			System.out.println("2. Change Weekend/PH Surcharge");
			System.out.println("3. Change Student/Senior Discount");
			System.out.println("4. Change Platinum Surcharge");
			System.out.println("5. Change Gold Class Surcharge");
			System.out.println("6. Change 3D Surcharge");
			System.out.println("7. Change Blockbuster Surcharge");
			System.out.println("8. Exit");
			
			updateChoice = sc.nextInt();
			switch(updateChoice) {
			case 1: //change base price
				System.out.println("Enter new Base Price: ");
				//no exception handling
				ticketPrice.setBasePrice((double)sc.nextInt());
				System.out.println("New Base Price is " + ticketPrice.getBasePrice());
				break;
			case 2: //change weekend/ph surcharge
				System.out.println("Enter new Weekend/PH Surcharge: ");
				//no exception handling
				ticketPrice.setWeekendOrPHSurcharge((double)sc.nextInt());
				System.out.println("New Weekend/PH Surcharge is " + ticketPrice.getWeekendOrPHSurcharge());
				break;
			case 3: //change student/senior discount
				System.out.println("Enter new Student/Senior Discount: ");
				//no exception handling
				ticketPrice.setAgeDiscount((double)sc.nextInt());
				System.out.println("New Student/Senior Discount is " + ticketPrice.getAgeDiscount());
				break;
			case 4: //change platinum surcharge
				System.out.println("Enter new Platinum Surcharge: ");
				//no exception handling
				ticketPrice.setPlatinumSurcharge((double)sc.nextInt());
				System.out.println("New Platinum Surcharge is " + ticketPrice.getPlatinumSurcharge());
				break;
			case 5: //change gold class surcharge
				System.out.println("Enter new Gold Class Surcharge: ");
				//no exception handling
				ticketPrice.setGoldClassSurcharge((double)sc.nextInt());
				System.out.println("New Gold Class Surcharge is " + ticketPrice.getGoldClassSurcharge());
				break;
			case 6: //change 3D surcharge
				System.out.println("Enter new 3D Surcharge: ");
				//no exception handling
				ticketPrice.setThreeDimensionMovieSurcharge((double)sc.nextInt());
				System.out.println("New 3D Surcharge is " + ticketPrice.getThreeDimensionMovieSurcharge());
				break;
			case 7: //change blockbuster surcharge
				System.out.println("Enter new Blockbuster Surcharge: ");
				//no exception handling
				ticketPrice.setBlockbusterMovieSurcharge((double)sc.nextInt());
				System.out.println("New Blockbuster Surcharge is " + ticketPrice.getBlockbusterMovieSurcharge());
				break;
			case 8: //exit
				break;
			default:
				break;
			}
		}while(updateChoice != 8);
	}
	
	public void updateHolidays(HolidayDatabase holidayDB) {
		holidayDB.printHolidays();
		
		int updateChoice = 0;
		do {
			//choose add/delete
			System.out.println("What would you like to do?");
			System.out.println("1. Add Holiday");
			System.out.println("2. Remove Holiday");
			System.out.println("3. Exit");
			
			updateChoice = sc.nextInt();
			switch(updateChoice) {
			case 1: //add holiday
				holidayDB.addHoliday();
				break;
			case 2: //remove holiday
				holidayDB.removeHoliday();
				break;
			case 3: //exit
				break;
			default:
				break;
			}
		}while(updateChoice != 3);
	}
	
	public void resetSettings(SystemSettings ss, TicketPriceCalculator ticketPrice) {
		ss.initTicketPrice(ticketPrice);
		System.out.println("resetted");
	}
}
