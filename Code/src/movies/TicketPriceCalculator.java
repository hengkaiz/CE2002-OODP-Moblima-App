package movies;
import java.io.Serializable;
import java.time.LocalDate;

import cinema.*;
import user.User;

public class TicketPriceCalculator implements Serializable{
	private static final long serialVersionUID = 1L;

	enum AgeGroup {
		SENIOR, CHILD, ADULT;
	}
	private double basePrice;
	private double weekendOrPHSurcharge;
	private double ageDiscount;
	private double platinumSurcharge;
	private double goldClassSurcharge;
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
	
	public double calculatePrice(User user, ShowTime showtime, HolidayDatabase holiday) {
		double price=basePrice;
		
		if (getAgeGroup(user.getAge()) == AgeGroup.CHILD || getAgeGroup(user.getAge()) == AgeGroup.SENIOR)
			price-=ageDiscount;
		
		LocalDate localDate = LocalDate.ofInstant(showtime.getDate().toInstant(), showtime.getDate().getTimeZone().toZoneId());
		
		if (isBookingDateAWeekend(localDate) || holiday.isHoliday(localDate))
			price+=weekendOrPHSurcharge;


		if (showtime.getCinemaType().equals("Platinum") )
			price+= platinumSurcharge;
		
		if (showtime.getCinemaType().equals("Gold Class"))
			price+= goldClassSurcharge;

		if (showtime.getMovieFormat() == MovieFormat.BLOCKBUSTER)
			price+= blockbusterMovieSurcharge;
		
		if (showtime.getMovieFormat() == MovieFormat.THREE_DIMENSION)
			price+= threeDimensionMovieSurcharge;
		
		return price;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getWeekendOrPHSurcharge() {
		return weekendOrPHSurcharge;
	}

	public void setWeekendOrPHSurcharge(double weekendOrPHSurcharge) {
		this.weekendOrPHSurcharge = weekendOrPHSurcharge;
	}

	public double getAgeDiscount() {
		return ageDiscount;
	}

	public void setAgeDiscount(double ageDiscount) {
		this.ageDiscount = ageDiscount;
	}

	public double getPlatinumSurcharge() {
		return platinumSurcharge;
	}

	public void setPlatinumSurcharge(double platinumSurcharge) {
		this.platinumSurcharge = platinumSurcharge;
	}

	public double getGoldClassSurcharge() {
		return goldClassSurcharge;
	}

	public void setGoldClassSurcharge(double goldClassSurcharge) {
		this.goldClassSurcharge = goldClassSurcharge;
	}

	public double getThreeDimensionMovieSurcharge() {
		return threeDimensionMovieSurcharge;
	}

	public void setThreeDimensionMovieSurcharge(double threeDimensionMovieSurcharge) {
		this.threeDimensionMovieSurcharge = threeDimensionMovieSurcharge;
	}

	public double getBlockbusterMovieSurcharge() {
		return blockbusterMovieSurcharge;
	}

	public void setBlockbusterMovieSurcharge(double blockbusterMovieSurcharge) {
		this.blockbusterMovieSurcharge = blockbusterMovieSurcharge;
	}
}//comment
