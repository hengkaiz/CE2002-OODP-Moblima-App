package Movies;
import java.util.Calendar;

public class TicketPriceCalculator {
	enum AgeGroup {
		SENIOR, CHILD, ADULT;
	}
	private double basePrice;
	private double weekendOrPHSurcharge;
	private double ageDiscount;
	private double cinemaSurcharge;
	
	public AgeGroup getAgeGroup(int age) {
		
		if (age<19 && age>0)
			return AgeGroup.CHILD;
		else if (age<66)
			return AgeGroup.ADULT;
		else 
			return AgeGroup.SENIOR;
	}
	
	public boolean isWeekend() {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		if (day==Calendar.SUNDAY || day==Calendar.SATURDAY)
			return true;
		else return false;		
	}
	
	//public boolean isHoliday() {
		
	//}
	
	public double calculatePrice(int age, Date date, String cinemaType) {
		double price=basePrice;
		
		if (getAgeGroup(age) == AgeGroup.CHILD || getAgeGroup(age) == AgeGroup.SENIOR)
			price-=ageDiscount;
		
		if (date.isWeekend() || date.isHoliday())
			price+=weekendOrPHSurcharge;
			
		if (cinemaType == "Platinum")
			price+= cinemaSurcharge;
		
		return price;
	}
}
