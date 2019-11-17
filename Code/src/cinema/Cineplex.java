package cinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * represents the cineplexes 
 *
 */
public class Cineplex implements Serializable{
	/**
	 * To identify the version of the class used in Serialization 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * A list of cinemas
	 */
	private ArrayList<Cinema> cinemas;
	/**
	 * The name of cineplex
	 */
    private String cineplexName;
    /**
     * The code of the cineplex
     */
    private String cineplexCode;
    /**
     * The number of the cineplex
     */
    private int cineplexNumber;

    /**
     * 
     * @return current cineplex number
     */
    public int getCineplexNumber() {
		return cineplexNumber;
	}
    /**
     * construct a cineplex object for the cineplex class
     */
	public Cineplex() {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter cineplex name");
    	this.cineplexName=sc.nextLine();
    	
    	System.out.println("Enter 2 letter cineplex code");
    	this.cineplexCode=sc.nextLine();
    	
    	System.out.println("Enter cineplex number");	
    	this.cineplexNumber=sc.nextInt();
    	
    	this.cinemas = new ArrayList<Cinema>();
    }
	/**
	 * creates a cinema object and adds it to to the cinema database
	 */
    public void addCinemasToCineplex() {
    	Scanner sc = new Scanner(System.in);
    	boolean loop=true;
    	while(loop) {
    		System.out.println("Creating Cinema...");
    		cinemas.add(new Cinema(this.cineplexCode, this.cineplexName));
    		System.out.println("Create more? Y or N");
    		if (sc.nextLine().equals("N"))
    			loop = false;
    		else 
    			continue;
    	}
    }
    
    /**
     * 
     * @return current list of cinemas
     */
	public ArrayList<Cinema> getCinemas() {
		return cinemas;
	}
	/**
	 * 
	 * @return current cineplex's name
	 */
	public String getCineplexName() {
		return cineplexName;
	}
	/**
	 * 
	 * @return current cineplex's code
	 */
	public String getCineplexCode() {
		return cineplexCode;
	}
	
//	public static void main(String[] args) {
//		Cineplex cine = new Cineplex();
//		cine.addCinemasToCineplex();
//		for (int i=0; i<cine.cinemas.size();i++)
//			System.out.println(cine.cinemas.get(i).getCinemaNumber() + "..." + cine.cinemas.get(i).getCode()+ "..." + cine.cinemas.get(i).getType());
//	}
}
