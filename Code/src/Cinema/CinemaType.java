package Cinema;

public enum CinemaType {
	PLATINUM("Platinum"),
	GOLD_CLASS("Gold Class");

    private String name;

	CinemaType(String name) {
        this.name = name;
    }
    public String getName() {
		return name;
	}
}
