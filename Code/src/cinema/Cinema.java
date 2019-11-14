package cinema;

import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {
    private CinemaType type;
    private String code;
    private int cinemaNumber;
    private String ofCineplexCode;
    private String ofCineplexName;

    public Cinema(CinemaType type, int cinemaNumber){
        this.type = type;
        this.cinemaNumber = cinemaNumber;
    }
    public Cinema(String ofCineplexCode, String ofCineplexName) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter cinema number");
    	this.cinemaNumber=sc.nextInt();
    	
    	System.out.println("Enter cinema type");
    	System.out.println("1: Platinum");
    	System.out.println("2: Gold Class");
    	System.out.println("3: Normal");
    	int choice=sc.nextInt();
    	switch (choice) {
    		case 1: 
    			this.type = CinemaType.PLATINUM;
    			break;
    		case 2: 
    			this.type = CinemaType.GOLD_CLASS;
    			break;
    		case 3:
    			this.type = CinemaType.NORMAL;
    			break;
    		default: break;
    	}
    	this.code = ofCineplexCode + Integer.toString(this.cinemaNumber);
    	this.ofCineplexCode = ofCineplexCode;
    	this.ofCineplexName = ofCineplexName;
    }

    public String getType(){
        return type.getName();
    }

    public void setType(CinemaType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
	public int getCinemaNumber() {
		return cinemaNumber;
	}
	public String getOfCineplexCode() {
		return ofCineplexCode;
	}
	public String getOfCineplexName() {
		return ofCineplexName;
	}
}
