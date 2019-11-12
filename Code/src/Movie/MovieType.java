package Movie;

public enum MovieType{
    TWO_DIMENSION("2D"),
    THREE_DIMENSION("3D"),
    BLOCKBUSTER("Blockbuster");

    private String name;
    MovieType(String s) {
        this.name = s;
    }
}
