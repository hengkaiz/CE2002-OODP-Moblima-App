package admin;

import java.util.Scanner;
import moblima.SaveAndLoadDB;
import movies.*;

/**
 * Contains the functions to configure system settings.
 * System settings available for configurations: update ticket base price and price offsets,
 *                                               update holiday dates,
 *                                               reset system settings.
 */
public class AdminConfigureSystemSettings {
	
	/**
	 * Allows saving and loading of the actual database to and from a local copy.
	 */
	private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
	
	/**
	 * Object reference to store local copy of HolidayDatabase.
	 */
	private HolidayDatabase hdb;
	
	/**
	 * Object reference to store local copy of TicketPriceCalculator.
	 */
	private TicketPriceCalculator ticketPriceCalculator;
	
	/**
	 * Constructs AdminConfigureSystemSettings object.
	 * Relevant databases are loaded and stored into local copies for method use.
	 * Relevant databases needed: Holiday Database (hdb)
	 * 							  TicketPriceCalculator (ticketPriceCalculator)
	 */
	public AdminConfigureSystemSettings() {
		this.hdb = saveAndLoadDB.loadHolidayDB();
		this.ticketPriceCalculator = saveAndLoadDB.loadTicketPrice();
	}
	
	/**
	 * Prints current base price and price offsets.
	 * Prints options for the admin to choose which price to update and asks for admin input.
	 * Allows admin to enter new price depending on which option they choose.
	 * Saves updated local copy to actual TicketPriceCalculator.
	 */
	public void updateTicketPrice() {
		Scanner sc = new Scanner(System.in);
		
		int updateChoice=0;
		do {
			//print current prices
			System.out.println("-----Current Prices----");
			System.out.println("Current base price: " + ticketPriceCalculator.getBasePrice());
			System.out.println("Current price offsets: ");
			System.out.println("1. Weekend/PH Surcharge: " + ticketPriceCalculator.getWeekendOrPHSurcharge());
			System.out.println("2. Student/Senior Discount: " + ticketPriceCalculator.getAgeDiscount());
			System.out.println("3. Platinum Surcharge: " + ticketPriceCalculator.getPlatinumSurcharge());
			System.out.println("4. Gold Class Surcharge: " + ticketPriceCalculator.getGoldClassSurcharge());
			System.out.println("5. 3D Surcharge: " + ticketPriceCalculator.getThreeDimensionMovieSurcharge());
			System.out.println("6. Blockbuster Surcharge: " + ticketPriceCalculator.getBlockbusterMovieSurcharge());
			
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
			System.out.println("8. Return");

	        try {
	    		System.out.println("Please enter your choice: ");
	    		updateChoice = sc.nextInt();
	    		if (updateChoice<1 || updateChoice>8) { //check exceptions?
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Invalid choice. Try Again.");
				return;
			}
	        System.out.println();

			switch(updateChoice) {
			case 1: //change base price
				System.out.println("Enter new Base Price: ");
				//no exception handling
				ticketPriceCalculator.setBasePrice((double)sc.nextInt());
				System.out.println("New Base Price is " + ticketPriceCalculator.getBasePrice());
				break;
			case 2: //change weekend/ph surcharge
				System.out.println("Enter new Weekend/PH Surcharge: ");
				//no exception handling
				ticketPriceCalculator.setWeekendOrPHSurcharge((double)sc.nextInt());
				System.out.println("New Weekend/PH Surcharge is " + ticketPriceCalculator.getWeekendOrPHSurcharge());
				break;
			case 3: //change student/senior discount
				System.out.println("Enter new Student/Senior Discount: ");
				//no exception handling
				ticketPriceCalculator.setAgeDiscount((double)sc.nextInt());
				System.out.println("New Student/Senior Discount is " + ticketPriceCalculator.getAgeDiscount());
				break;
			case 4: //change platinum surcharge
				System.out.println("Enter new Platinum Surcharge: ");
				//no exception handling
				ticketPriceCalculator.setPlatinumSurcharge((double)sc.nextInt());
				System.out.println("New Platinum Surcharge is " + ticketPriceCalculator.getPlatinumSurcharge());
				break;
			case 5: //change gold class surcharge
				System.out.println("Enter new Gold Class Surcharge: ");
				//no exception handling
				ticketPriceCalculator.setGoldClassSurcharge((double)sc.nextInt());
				System.out.println("New Gold Class Surcharge is " + ticketPriceCalculator.getGoldClassSurcharge());
				break;
			case 6: //change 3D surcharge
				System.out.println("Enter new 3D Surcharge: ");
				//no exception handling
				ticketPriceCalculator.setThreeDimensionMovieSurcharge((double)sc.nextInt());
				System.out.println("New 3D Surcharge is " + ticketPriceCalculator.getThreeDimensionMovieSurcharge());
				break;
			case 7: //change blockbuster surcharge
				System.out.println("Enter new Blockbuster Surcharge: ");
				//no exception handling
				ticketPriceCalculator.setBlockbusterMovieSurcharge((double)sc.nextInt());
				System.out.println("New Blockbuster Surcharge is " + ticketPriceCalculator.getBlockbusterMovieSurcharge());
				break;
			case 8: //exit
				break;
			default:
				break;
			}
		}while(updateChoice != 8);
		saveAndLoadDB.saveTicketPrice(ticketPriceCalculator);
	}
	
	/**
	 * Prints current holidays.
	 * Prints options for the admin to choose to update holiday dates.
	 * Allows admin to enter add or remove holidays from the database based on the option chosen.
	 * Saves updated local copy to actual HolidayDatabase.
	 */
	public void updateHolidays() {
		Scanner sc = new Scanner(System.in);
		
		hdb.printHolidays();
		
		int updateChoice = 0;
		do {
			//choose add/delete
			System.out.println("What would you like to do?");
			System.out.println("1. Add Holiday");
			System.out.println("2. Remove Holiday");
			System.out.println("3. Return");

	        try {
	    		System.out.println("Please enter your choice: ");
	    		updateChoice = sc.nextInt();
	    		if (updateChoice<1 || updateChoice>3) { //check exceptions?
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Invalid choice. Try Again.");
				return;
			}

	        System.out.println();
			
			switch(updateChoice) {
			case 1: //add holiday
				try {
					hdb.addHoliday();
				} catch (Exception e) {
					System.out.println("Invalid Choice. Try Again.");
					return;
				}
				break;
			case 2: //remove holiday
				try {
				hdb.removeHoliday();
				} catch (Exception e) {
					System.out.println("Invalid Choice. Try Again.");
					return;
				}
				break;
			case 3: //exit
				break;
			default:
				break;
			}
		}while(updateChoice != 3);
		saveAndLoadDB.saveHolidayDB(hdb);
	}
	
	/**
	 * Resets the ticket base price and price offsets to initial values.
	 * Saves updated local copy to actual TicketPriceCalculator.
	 */
	public void resetSettings() {
		ticketPriceCalculator.setBasePrice(8.00);
		ticketPriceCalculator.setWeekendOrPHSurcharge(2.00);
		ticketPriceCalculator.setAgeDiscount(2.00);
		ticketPriceCalculator.setPlatinumSurcharge(5.00);
		ticketPriceCalculator.setGoldClassSurcharge(4.00);
		ticketPriceCalculator.setThreeDimensionMovieSurcharge(3.00);
		ticketPriceCalculator.setBlockbusterMovieSurcharge(2.00);
		System.out.println("System Settings Resetted");
		saveAndLoadDB.saveTicketPrice(ticketPriceCalculator);
	}
}
