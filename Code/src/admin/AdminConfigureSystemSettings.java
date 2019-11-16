package admin;

import java.util.Scanner;
import moblima.SaveAndLoadDB;
import movies.*;

public class AdminConfigureSystemSettings {
	private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
	private HolidayDatabase hdb;
	//private TicketPriceDB tpdb;
	private TicketPriceCalculator ticketPrice;
	

	public AdminConfigureSystemSettings() {
		this.hdb = saveAndLoadDB.loadHolidayDB();
		//this.tpdb = saveAndLoadDBTick.loadTicketPrice();
	}
	
	public void updateTicketPrice() {
		Scanner sc = new Scanner(System.in);
		
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
			System.out.println("8. Return");
			boolean loop = true;
	        do {
	        try {
	    		System.out.println("Please enter your choice: ");
	    		updateChoice = sc.nextInt();
	    		if (updateChoice<1 || updateChoice>8) { //check exceptions?
					throw new Exception();
				}
				loop = false;
			} catch (Exception e) {
				System.out.printf("Invalid choice. Try Again.");
			}
	        } while (loop);
	        System.out.println();

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
		//update ticketpriceDB
		//saveAndLoadDB.saveTicketPrice(tpdb);
	}
	
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
			boolean loop = true;
	        do {
	        try {
	    		System.out.println("Please enter your choice: ");
	    		updateChoice = sc.nextInt();
	    		if (updateChoice<1 || updateChoice>3) { //check exceptions?
					throw new Exception();
				}
				loop = false;
			} catch (Exception e) {
				System.out.printf("Invalid choice. Try Again.");
			}
	        } while (loop);
	        System.out.println();
			
			switch(updateChoice) {
			case 1: //add holiday
				hdb.addHoliday();
				break;
			case 2: //remove holiday
				hdb.removeHoliday();
				break;
			case 3: //exit
				break;
			default:
				break;
			}
		}while(updateChoice != 3);
		saveAndLoadDB.saveHolidayDB(hdb);
	}
	
	public void resetSettings() {
		ticketPrice.setBasePrice(8.00);
		ticketPrice.setWeekendOrPHSurcharge(2.00);
		ticketPrice.setAgeDiscount(2.00);
		ticketPrice.setPlatinumSurcharge(5.00);
		ticketPrice.setGoldClassSurcharge(4.00);
		ticketPrice.setThreeDimensionMovieSurcharge(3.00);
		ticketPrice.setBlockbusterMovieSurcharge(2.00);
		System.out.println("System Settings Resetted");
		//saveAndLoadDB.saveTicketPrice(tpdb);
	}
}
