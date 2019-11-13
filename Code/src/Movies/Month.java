package Movies;

public enum Month {
	
	JANUARY("January"), FEBUARY("February"), MARCH("March"), APRIL("April"), MAY("May"), JUNE("June"), 
	JULY("July"), AUGUST("August"), SEPTEMBER("September"), OCTOBER("October"), NOVEMBER("November"), 
	DECEMBER("December");
	
	private String name;
	
	Month(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
}
