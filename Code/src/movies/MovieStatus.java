package movies;
/**
 * enumerates all the possible movie statuses
 */
public enum MovieStatus {
    COMING_SOON("Coming Soon"),
    PREVIEW("Preview"),
    NOW_SHOWING("Now Showing"),
    END_OF_SHOWING("End of Showing");
	/**
	 * name of the movie status in proper format
	 */
    private String name;

    /**
     * constructs a movie status with the given name
     * @param name
     */
	MovieStatus(String name) {
        this.name = name;
    }
	
	/**
	 * returns name of status for example "Coming Soon"
	 * @return String name of status
	 */
    public String getName() {
		return name;
	}
}
