package Movie;

public enum AgeLimit {
    G("G"),
    PG("PG"),
    PG13("PG13"),
    NC16("NC16"),
    M18("M18"),
    R21("R21");

    private String name;

    AgeLimit(String name) {
        this.name = name;
    }
}
