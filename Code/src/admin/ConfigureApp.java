package admin;

import java.util.Scanner;
import cinema.*;
import movies.*;

public class ConfigureApp {

	/*public ConfigureApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	
	Scanner sc = new Scanner(System.in);
	
	public void configure(ConfigureSystemSettings css, TicketPriceCalculator tcc, HolidayDatabase hdb, SystemSettings ss) {
		int editChoice = 0;
		do {
			System.out.println("1. Update Ticket Prices");
			System.out.println("2. Update Holidays");
			System.out.println("3. Reset");
			System.out.println("4. Exit");
			editChoice = sc.nextInt();
			switch(editChoice) {
			case 1: //update ticket price
				css.updateTicketPrice(tcc);
				break;
			case 2: //update holidays
				css.updateHolidays(hdb);
				break;
			case 3: //reset
				css.resetSettings(ss,tcc);
				break;
			case 4: //exit
				break;
			default:
				break;
			}
		}while(editChoice != 4);
	}

}
