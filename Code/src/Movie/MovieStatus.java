package Movie;

public enum MovieStatus {
    COMING_SOON("Coming Soon"),
    PREVIEW("Preview"),
    NOW_SHOWING("Now Showing"),
    END_OF_SHOWING("End of Showing");

    private String name;
    MovieStatus(String s) {
        this.name = s;
    }
}
