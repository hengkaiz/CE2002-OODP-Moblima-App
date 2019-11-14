package cinema;

public enum MovieFormat {
    TWO_DIMENSION("2D"),
    THREE_DIMENSION("3D"),
    BLOCKBUSTER("Blockbuster");

    private String name;
    MovieFormat(String s) {
        this.name = s;
    }
	public String getName() {
		return name;
	}  
}
