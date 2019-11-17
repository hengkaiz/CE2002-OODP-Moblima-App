package movies;

public enum AgeRating {
    GENERAL("G"),
    PARENTAL_GUIDANCE13("PG13"),
    NO_CHILDREN_UNDER16("NC16"),
    MATURE18("M18"),
    RESTRICTED21("R21");

    private String name;

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
