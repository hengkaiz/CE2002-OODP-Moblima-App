package movies;

public enum Month {
	
	JANUARY("January"), FEBUARY("February"), MARCH("March"), APRIL("April"), MAY("May"), JUNE("June"), 
	JULY("July"), AUGUST("August"), SEPTEMBER("September"), OCTOBER("October"), NOVEMBER("November"), 
	DECEMBER("December");
	
	private String name;
	
	Month(String name) {
		this.name=name;
	}

	/**
	 * returns name of month for example "January"
	 * @return String name of month
	 */
	public String getName() {
		return name;
	}
}