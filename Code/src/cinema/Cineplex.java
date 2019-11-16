package cinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Cineplex implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Cinema> cinemas;
    private String cineplexName;
    private String cineplexCode;
    private int cineplexNumber;

    
    public int getCineplexNumber() {
		return cineplexNumber;
	}
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
	
//	public static void main(String[] args) {
//		Cineplex cine = new Cineplex();
//		cine.addCinemasToCineplex();
//		for (int i=0; i<cine.cinemas.size();i++)
//			System.out.println(cine.cinemas.get(i).getCinemaNumber() + "..." + cine.cinemas.get(i).getCode()+ "..." + cine.cinemas.get(i).getType());
//	}
}
