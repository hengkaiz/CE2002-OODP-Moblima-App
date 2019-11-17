package cinema;
/**
 * 
 *Enumerates the types of cinemas
 */
public enum CinemaType {
	PLATINUM("Platinum"),
	GOLD_CLASS("Gold Class"),
	NORMAL("Normal");
	/**
	 * this is the name of the cinema type in a proper format
	 */
    private String name;
    
    /**
     * construct a CinemaType object for CinemaType class, using name as parameters.
     * @param name input for name of cinema type
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
