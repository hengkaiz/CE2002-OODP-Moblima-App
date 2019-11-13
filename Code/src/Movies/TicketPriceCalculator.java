package Movies;
import java.time.LocalDate;

import Cinema.MovieFormat;
import Cinema.ShowTime;
import user.User;

public class TicketPriceCalculator {
	enum AgeGroup {
		SENIOR, CHILD, ADULT;
	}
	private static double basePrice;
	private double weekendOrPHSurcharge;
	private double ageDiscount;
	private double cinemaSurcharge;
	private double threeDimensionMovieSurcharge;
	private double blockbusterMovieSurcharge;
	
	public AgeGroup getAgeGroup(int age) {
		
		if (age<19 && age>0)
			return AgeGroup.CHILD;
		else if (age<66)
			return AgeGroup.ADULT;
		else 
			return AgeGroup.SENIOR;
	}
	
	public boolean isBookingDateAWeekend(LocalDate date) {

		if (date.getDayOfWeek()== java.time.DayOfWeek.SATURDAY || date.getDayOfWeek()== java.time.DayOfWeek.SUNDAY)
			return true;
		else 
			return false;
	}
	
	public double calculatePrice(User user, ShowTime showtime, Holiday holiday) {
		double price=basePrice;
		
		if (getAgeGroup(user.getAge()) == AgeGroup.CHILD || getAgeGroup(user.getAge()) == AgeGroup.SENIOR)
			price-=ageDiscount;
		
		LocalDate localDate = LocalDate.ofInstant(showtime.getDate().toInstant(), showtime.getDate().getTimeZone().toZoneId());
		
		if (isBookingDateAWeekend(localDate) || holiday.isHoliday(localDate))
			price+=weekendOrPHSurcharge;
			
		if (showtime.getCinemaType() == "Platinum")
			price+= cinemaSurcharge;
		
		if (showtime.getMovieformat() == MovieFormat.BLOCKBUSTER)
			price+= blockbusterMovieSurcharge;
		
		if (showtime.getMovieformat() == MovieFormat.THREE_DIMENSION)
			price+= threeDimensionMovieSurcharge;
		
		return price;
	}
}
