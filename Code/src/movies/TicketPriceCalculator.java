package movies;
import java.io.Serializable;
import java.time.LocalDate;

import cinema.*;
import user.User;
/**
 * represents a ticket price calculator with the relevant prices used for calculation
 */
public class TicketPriceCalculator implements Serializable{
	/**
	 * To identify the version of the class used in Serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * enumerates all the age groups possible
	 */
	enum AgeGroup {
		SENIOR, CHILD, ADULT;
	}
	/**
	 * base price of a ticket
	 */
	private double basePrice;
	/**
	 * surcharge if date chosen is a weekend or holiday
	 */
	private double weekendOrPHSurcharge;
	/**
	 * discount if user is a child or senior
	 */
	private double ageDiscount;
	/**
	 * surcharge if cinema chosen is platinum
	 */
	private double platinumSurcharge;
	/**
	 * surcharge if cinema chosen is gold class
	 */
	private double goldClassSurcharge;
	/**
	 * surcharge if movie is in 3D
	 */
	private double threeDimensionMovieSurcharge;
	/**
	 * surcharge if movie is blockbuster
	 */
	private double blockbusterMovieSurcharge;
	
	/**
	 * @param age age of user
	 * @return the age group user belongs to
	 */
	public AgeGroup getAgeGroup(int age) {
		if (age<19 && age>0)
			return AgeGroup.CHILD;
		else if (age<66)
			return AgeGroup.ADULT;
		else 
			return AgeGroup.SENIOR;
	}
	
	/**
	 * checks if booking date is a weekend
	 * @param date date of booking
	 * @return true if date is on a weekend; falls if not
	 */
	public boolean isBookingDateAWeekend(LocalDate date) {
		if (date.getDayOfWeek()== java.time.DayOfWeek.SATURDAY || date.getDayOfWeek()== java.time.DayOfWeek.SUNDAY)
			return true;
		else 
			return false;
	}
	
	/**
	 * calculates the ticket price based on the base price, surcharges and discounts that apply
	 * @param user current user doing the booking
	 * @param showtime the showtime that is being booked
	 * @param holiday the holiday database
	 * @return ticket price
	 */
	public double calculatePrice(User user, ShowTime showtime, HolidayDatabase holiday) {
		double price=basePrice;
		
		if (getAgeGroup(user.getAge()) == AgeGroup.CHILD || getAgeGroup(user.getAge()) == AgeGroup.SENIOR) {
			//System.out.println("old/young");
			price-=ageDiscount;
		}
			
		
		LocalDate localDate = LocalDate.ofInstant(showtime.getDate().toInstant(), showtime.getDate().getTimeZone().toZoneId());
		
		if (isBookingDateAWeekend(localDate) || holiday.isHoliday(localDate)) {
			//System.out.println("holiday/weekend");
			price+=weekendOrPHSurcharge;
		}
			


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

	/**
	 * @return current base price
	 */
	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * @param basePrice basePRice to be set
	 */
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * @return current weekend/public holiday surcharge
	 */
	public double getWeekendOrPHSurcharge() {
		return weekendOrPHSurcharge;
	}
	/**
	 * @param weekendOrPHSurcharge weekend/public holiday surcharge to be set
	 */
	public void setWeekendOrPHSurcharge(double weekendOrPHSurcharge) {
		this.weekendOrPHSurcharge = weekendOrPHSurcharge;
	}

	/**
	 * @return current age discount
	 */
	public double getAgeDiscount() {
		return ageDiscount;
	}

	/**
	 * @param ageDiscount age discount to be set
	 */
	public void setAgeDiscount(double ageDiscount) {
		this.ageDiscount = ageDiscount;
	}

	/**
	 * @return current platinum cinema surcharge
	 */
	public double getPlatinumSurcharge() {
		return platinumSurcharge;
	}

	/**
	 * @param platinumSurcharge platinum cinema surcharge to set
	 */
	public void setPlatinumSurcharge(double platinumSurcharge) {
		this.platinumSurcharge = platinumSurcharge;
	}

	/**
	 * @return current gold class cinema surcharge
	 */
	public double getGoldClassSurcharge() {
		return goldClassSurcharge;
	}

	/**
	 * @param goldClassSurcharge gold class cinema surcharge to set
	 */
	public void setGoldClassSurcharge(double goldClassSurcharge) {
		this.goldClassSurcharge = goldClassSurcharge;
	}

	/**
	 * @return current 3D movie surcharge
	 */
	public double getThreeDimensionMovieSurcharge() {
		return threeDimensionMovieSurcharge;
	}

	/**
	 * @param threeDimensionMovieSurcharge 3D movie surcharge to set
	 */
	public void setThreeDimensionMovieSurcharge(double threeDimensionMovieSurcharge) {
		this.threeDimensionMovieSurcharge = threeDimensionMovieSurcharge;
	}

	/**
	 * @return current blockbuster movie surcharge
	 */
	public double getBlockbusterMovieSurcharge() {
		return blockbusterMovieSurcharge;
	}

	/**
	 * @param blockbusterMovieSurcharge blockbuster movie surcharge to set
	 */
	public void setBlockbusterMovieSurcharge(double blockbusterMovieSurcharge) {
		this.blockbusterMovieSurcharge = blockbusterMovieSurcharge;
	}
}
