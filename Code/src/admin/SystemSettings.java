package admin;

import movies.*;
import java.lang.Object;
public class SystemSettings {

	/*public SystemSettings() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	
	public void initTicketPrice(TicketPriceCalculator initialPrices) {
		initialPrices.setBasePrice(8.00);
		initialPrices.setWeekendOrPHSurcharge(2.00);
		initialPrices.setAgeDiscount(2.00);
		initialPrices.setPlatinumSurcharge(5.00);
		initialPrices.setGoldClassSurcharge(4.00);
		initialPrices.setThreeDimensionMovieSurcharge(3.00);
		initialPrices.setBlockbusterMovieSurcharge(2.00);
	}
	
	/*public void initHolidays(Holiday) {
		
	}*/

}
