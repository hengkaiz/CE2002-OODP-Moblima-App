package cinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Cinema implements Serializable{
	private static final long serialVersionUID = 1L;
	private CinemaType type;
    private String code;
    private int cinemaNumber;
    private String ofCineplexCode;
    private String ofCineplexName;
    
    /**
     * This construct a cinema object for cinema class, using the CinemaType and cinemaNumber as parameters.
     * @param type input for the type of cinema
     * @param cinemaNumber input for the cinema number associated with cinema
     */

    public Cinema(CinemaType type, int cinemaNumber){
        this.type = type;
        this.cinemaNumber = cinemaNumber;
    }
    
    /**
     * This construct a cinema object for cinema class, using the ofCineplexCode(Cineplex's Code) and ofCineplexName (Cineplex's Name) as parameters.
     * @param ofCineplexCode input for code of the Cineplex the cinema is in
     * @param ofCineplexName input for name of Cineplex the cinema is in
     */
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
    	
    	System.out.println("Enter cinema letter");
    	String dummy = sc.nextLine();
    	String cinemaLetter=sc.nextLine();
    	this.code = ofCineplexCode + cinemaLetter;
    	this.ofCineplexCode = ofCineplexCode;
    	this.ofCineplexName = ofCineplexName;
    }
	/**
	 * 
	 * @return current type
	 */
    public String getType(){
        return type.getName();
    }
    /**
     * 
     * @param type type to set
     */
    public void setType(CinemaType type) {
        this.type = type;
    }
    /**
     * 
     * @return current code
     */
    public String getCode() {
        return code;
    }
    /**
     * 
     * @param code code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * 
     * @return current Cinema Number
     */
	public int getCinemaNumber() {
		return cinemaNumber;
	}
	/**
	 * 
	 * @param num Cinema Number to set
	 */
	public void setCinemaNumber(int num){this.cinemaNumber = num;}
	/**
	 * 
	 * @return current cineplex's code
	 */
	public String getOfCineplexCode() {
		return ofCineplexCode;
	}
	/**
	 * 
	 * @return current cineplex's name
	 */
	public String getOfCineplexName() {
		return ofCineplexName;
	}
}
