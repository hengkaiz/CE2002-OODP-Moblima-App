package cinema;
/**
 *enumerations of the format of the movies 
 *
 */
public enum MovieFormat {
    TWO_DIMENSION("2D"),
    THREE_DIMENSION("3D"),
    BLOCKBUSTER("Blockbuster");
	
	/**
	 * this is the name of the format of movie in a proper format
	 */
    private String name;
    MovieFormat(String s) {
        this.name = s;
    }
    /**
     * 
     * @return current name
     */
	public String getName() {
		return name;
	}  
}
