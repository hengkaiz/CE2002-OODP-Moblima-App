package cinema;

public enum CinemaType {
	PLATINUM("Platinum"),
	GOLD_CLASS("Gold Class"),
	NORMAL("Normal");

    private String name;
    
    /**
     * construct a CinemaType object for CinemaType class, using name as parameters.
     * @param name
     */

	CinemaType(String name) {
        this.name = name;
    }
	/**
	 * 
	 * @return current name
	 */
    public String getName() {
		return name;
	}
}
