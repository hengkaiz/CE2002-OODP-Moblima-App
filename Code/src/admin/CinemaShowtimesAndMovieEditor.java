package admin;

import java.util.ArrayList;
import java.util.Scanner;
//import java.lang.Enum;
import Cinema.*;
import Database.*;
import Movies.*;

public class CinemaShowtimesAndMovieEditor {

	Scanner sc = new Scanner(System.in);
	//ShowTime s = null;
	DataBase db = new DataBase();
	ArrayList<ShowTime> stdb = db.getShowTimes();
	MovieDatabase mdb = new MovieDatabase();
	ArrayList<Movie> msdb = mdb.getMovies();
	
	public void createCinemaShowtimesAndMovie() {
		ShowTime s = new ShowTime();
		
		System.out.println("Enter Timing:");
		s.setTiming(sc.nextInt());
		
		//System.out.println("Enter Movie Title: ");
		//s.setMovie(sc.nextLine());
		//System.out.println(date.);.
		
		System.out.println("Enter Cinema Number: ");
		s.setCinemaNum(sc.nextInt());
		
		System.out.println("Choose Movie Format: ");
		int i = 1;
		for(MovieFormat mf : MovieFormat.values()) {
			System.out.println(i + ". " + mf.name());
			//System.out.println(i + ". " + status);
			i++;
		}
		int movieFormatChoice = sc.nextInt();
		MovieFormat movieFormat=null;
		for(MovieFormat mf : MovieFormat.values()) {				//go through array until find the one equal to user input
			if(mf.ordinal() == movieFormatChoice-1){
				movieFormat = mf;
			}
		}
		s.setMovieformat(movieFormat);
		/*System.out.println("Enter Cinema Type: ");
		s.setCinemaType(sc.nextLine());*/
		
		//should just enter an empty Seat plan for the booking class to update whenever
		//s.setSeatPlan();
	}
	public void updateCinemaShowtimesAndMovie(ShowTime s) {
		if(checkShowtimes(s)) { //valid showtime
			int showtimeChoice = 0;
			do {
				System.out.println("What would you like to update?");
				System.out.println("1. Timing of " + s.getMovie()); //change timing of that movie
				System.out.println("2. Movie shown at " + s.getTiming()); //change movie shown at that timing
				System.out.println("3. Cinema Number of " + s.getMovie() + " shown at " + s.getTiming()); //change cinemaNum
				//System.out.println("4. Cinema Type of " + s.getMovie() + " shown at " + s.getTiming()); //change cinemaType
				System.out.println("4. Movie Format of " + s.getMovie() + " shown at " + s.getTiming());
				System.out.println("5. Exit");
				
				showtimeChoice = sc.nextInt();
				switch(showtimeChoice) {
				case 1: //change timing
					System.out.println("Enter new timing for showing of " + s.getMovie());
					s.setTiming(sc.nextInt());
					System.out.println("Timing changed for " + s.getMovie());
					break;
				case 2: //change movie
					int i=0;
					//give list of movies currently showing/preview
					System.out.println("Movies currently available for showing: ");
					for(i=0; i < msdb.size(); i++) {
						if(msdb.get(i).getStatus()==MovieStatus.NOW_SHOWING || msdb.get(i).getStatus()==MovieStatus.PREVIEW) {
							System.out.println((i+1) + ". " + msdb.get(i).getMovieTitle());
						}
						//System.out.println((i+1) + ". " + msdb.get(i));
					}
					System.out.println("Enter choice for new movie showing at " + s.getTiming());
					//no error checking for user input of choice of movie
					//int newMovieChoice = sc.nextInt();
					s.setMovie(msdb.get(sc.nextInt()-1));
					System.out.println(s.getMovie() + " now showing at " + s.getTiming());
					break;
				case 3: //change cinema num
					System.out.println("Enter new cinema number to show " + s.getMovie() + " at " + s.getTiming());
					//check if cinema is available at that time
					//if free,
					s.setCinemaNum(sc.nextInt());
					System.out.println(s.getMovie() + " now showing at " + s.getTiming() + " in cinema number " + s.getCinemaNum());
					break;
				/*case 4: //change cinema type
					System.out.println("Enter new cinema type to show " + s.getMovie() + " at " + s.getTiming());
					s.setCinemaType(sc.nextLine());
					System.out.println(s.getMovie() + " now showing at " + s.getTiming() + " in " + s.getCinemaType());
					break;*/
				case 4: //change movie format
					System.out.println("Change movie format of " + s.getMovie() + " to:");
					i = 1;
					for(MovieFormat mf : MovieFormat.values()) {
						System.out.println(i + ". " + mf.name());
						//System.out.println(i + ". " + status);
						i++;
					}
					int movieFormatChoice = sc.nextInt();
					MovieFormat movieFormat=null;
					for(MovieFormat mf : MovieFormat.values()) {				//go through array until find the one equal to user input
						if(mf.ordinal() == movieFormatChoice-1){
							movieFormat = mf;
						}
					}
					s.setMovieformat(movieFormat);
					System.out.println(s.getMovie() + " is now showing in " + s.getMovieformat());
					break;
				case 5: //exit
					return;
				default: 
					break;
				}
			} while(showtimeChoice != 5);
		}
		//db.updateDB(s);
	}
	public void removeCinemaShowtimesAndMovie(ShowTime s) {
		if(checkShowtimes(s)) { //valid showtime
			String movieTitle = s.getMovie();
			int timing = s.getTiming();
			s = null; // deleting its ref so garbage collector can collect
			System.out.println(movieTitle + " at " + timing + " removed!");
		}
		else {
			System.out.println("Showtime not available!");
		}
	}
	public boolean checkShowtimes(ShowTime s) {
		for(int i=0; i<stdb.size(); i++) {
			if(s.equals(stdb.get(i))) {
				//found showtime match
				return true;
			}
		}
		//no match found
		return false;
		
		/*for(int i=0; i<stdb.size(); i++) {
			if(s.getTiming() == stdb.get(i).getTiming() && s.getMovie() == stdb.get(i).getMovie() && s.getCinemaNum() == stdb.get(i).getCinemaNum() && s.getCinemaType() == ShowtimeDatabase.getShowtimes()[i].getCinemaType()) {// && s.getSeatPlan() == ShowtimeDatabase.getShowtimes()[i].getSeatPlan()) {
		}
		
		for(int i=0; i < len(ShowtimeDatabase.getShowtimes()); i++) {
			if(s.getTiming() == ShowtimeDatabase.getShowtimes()[i].getTiming() && s.getMovie() == ShowtimeDatabase.getShowtimes()[i].getMovie() && s.getCinemaNum() == ShowtimeDatabase.getShowtimes()[i].getCinemaNum() && s.getCinemaType() == ShowtimeDatabase.getShowtimes()[i].getCinemaType()) {// && s.getSeatPlan() == ShowtimeDatabase.getShowtimes()[i].getSeatPlan()) {
				//found showtime match
				return true;
			}
		}
		//no match found
		return false;*/
	}
}
