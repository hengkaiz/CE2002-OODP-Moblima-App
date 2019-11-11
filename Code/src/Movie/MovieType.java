package Movie;

public enum MovieType{
    COMING_SOON("Coming Soon"),
    PREVIEW("Preview"),
    NOW_SHOWING("Now Showing"),
    END_OF_SHOWING("End of Showing");

    private String type;
    MovieType(String s) {
        this.type = s;
    }
}
