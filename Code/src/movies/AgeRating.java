package movies;
/**
 * Enumerations of the different age ratings for movies
 */
public enum AgeRating {
    GENERAL("G"),
    PARENTAL_GUIDANCE13("PG13"),
    NO_CHILDREN_UNDER16("NC16"),
    MATURE18("M18"),
    RESTRICTED21("R21");
	/**
	 * this is the name of the age rating in proper format
	 */
    private String name;
    /**
     * constructs an age rating with the name
     * @param name
     */
	AgeRating(String name) {
        this.name = name;
    }
	/**
	 * returns name of age rating for example "PG13"
	 * @return String name of age rating
	 */
    public String getName() {
		return name;
	}
}
