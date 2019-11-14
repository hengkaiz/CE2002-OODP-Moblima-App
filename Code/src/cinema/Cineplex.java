package cinema;

import java.util.ArrayList;
import java.util.Scanner;

public class Cineplex {
    private ArrayList<Cinema> cinemas;
    private String cineplexName;
    private String cineplexCode;
    private int cineplexNumber;
    private ShowTimeDatabase showTimeDataBase;
    
    public Cineplex() {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter cineplex name");
    	this.cineplexName=sc.nextLine();
    	
    	System.out.println("Enter 2 digit cineplex code");
    	this.cineplexCode=sc.nextLine();
    	this.cineplexNumber=Integer.parseInt(this.cineplexCode);
    	
    	this.cinemas = new ArrayList<Cinema>();
    	
    	this.showTimeDataBase = new ShowTimeDatabase();
    }
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
    
    
	public ArrayList<Cinema> getCinemas() {
		return cinemas;
	}
	public String getCineplexName() {
		return cineplexName;
	}
	public String getCineplexCode() {
		return cineplexCode;
	}
	public ShowTimeDatabase getShowTimeDataBase() {
		return showTimeDataBase;
	}
	
//	public static void main(String[] args) {
//		Cineplex cine = new Cineplex();
//		cine.addCinemasToCineplex();
//		for (int i=0; i<cine.cinemas.size();i++)
//			System.out.println(cine.cinemas.get(i).getCinemaNumber() + "..." + cine.cinemas.get(i).getCode()+ "..." + cine.cinemas.get(i).getType());
//	}
}
