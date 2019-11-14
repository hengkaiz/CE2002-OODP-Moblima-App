package cinema;

import java.util.ArrayList;
import java.util.Scanner;

public class CineplexDatabase {
	private ArrayList<Cineplex> cineplexes;
	
	public CineplexDatabase() {
		System.out.println("Creating cineplex DB");
		cineplexes = new ArrayList<Cineplex>();
		Scanner sc = new Scanner(System.in);
		System.out.println("How many cineplexes to create?");
		int num = sc.nextInt();
		for (int i=0; i<num; i++) {
			System.out.println("Creating cineplex...");
			cineplexes.add(new Cineplex());
			cineplexes.get(i).addCinemasToCineplex();
		}
	}
	
	
	public ArrayList<Cineplex> getCineplexes() {
		return cineplexes;
	}


//	public static void main(String[] args) {
//		CineplexDatabase cdb = new CineplexDatabase();
//		System.out.println(cdb);
//		for (int i=0; i<cdb.cineplexes.size(); i++) {
//			for (int k=0; k<cdb.cineplexes.get(i).getCinemas().size(); k++)
//			System.out.println(cdb.cineplexes.get(i).getCinemas().get(k).getCinemaNumber() + "..." + cdb.cineplexes.get(i).getCinemas().get(k).getCode()+ "..." + cdb.cineplexes.get(i).getCinemas().get(k).getType());
//		}
//	}
	
}