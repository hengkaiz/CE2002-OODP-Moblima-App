package admin;

import java.util.ArrayList;
import java.util.Scanner;
//import java.lang.Enum;
import Cinema.*;
import Database.*;
import Movies.*;

public class CinemaShowtimesAndMovieEditor {

	Scanner sc = new Scanner(System.in);
	ShowTime s = null;
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
		db.addSTToDB(s);
	}
	public void updateCinemaShowtimesAndMovie() {
		int i=0;
		int selectChoice=0;
		do {
			System.out.println("Which ShowTime do you want to update?");
			System.out.println("1. Select by Movie");
			System.out.println("2. Select by Date");
			System.out.println("3. Exit");
			
			selectChoice = sc.nextInt();
			switch(selectChoice) {
			case 1: //select by movie
				
				//print all the movie for the admin to choose to update
				ArrayList<String> movieTitles = mdb.getMovieTitlesList();
;				for(i=0;i<movieTitles.size();i++);{
					System.out.println(movieTitles.get(i));
				}
				updateByMovie(movieTitles.get(sc.nextInt()-1));
				break;
			case 2: //select be timing
				updateByDate();
				break;
			case 3: //exit
				return;
			default:
				break;
			}
		}while(selectChoice != 3);
	}
	private void updateByMovie(String movieTitle) {
		int i=0;
		ArrayList<ShowTime> stByMovie = db.searchByMovie(movieTitle);
		
		/*//get the movie chosen
		for(i=0; i<stdb.size(); i++) {
			System.out.println((i+1) + ". " + stdb.get(i).getMovie());
		}
		int movieUpdateChoice = sc.nextInt();
		s = stdb.get(movieUpdateChoice-1);
		
		//get ST for the movie chosen
		stByMovie = db.searchByMovie(s.getMovie());*/
		
		//update
		do {
			//print current showtimes for movie selected
			System.out.println("Current showtimes for " + movieTitle);
			for(i=0;i<stByMovie.size();i++) {
				s = stByMovie.get(i);
				System.out.println((i+1) + ". " + "Showing at " + s.getTiming() + " on " + s.getDate());
			}
			System.out.println("Choose showtime to update:");
			s = stByMovie.get(sc.nextInt());
			
			do {
				System.out.println("1. Change Timing"); //same date new timing
				System.out.println("2. Change Cinema Number");
				System.out.println("3. Change Movie Format");
				System.out.println("4. Exit");
				int updateChoice = 0;
				switch(updateChoice) {
				case 1: //change timing
					System.out.println("Enter new timing");
					//int newTiming = sc.nextInt();
					//no error checking if another st have the same timing as newtiming
					s.setTiming(sc.nextInt());
					/*for(i=0;i<stdb.size();i++) {
						if(newTiming == stdb.get(i).getTiming() && s.)
					}*/
					System.out.println("Timing changed for " + s.getMovie());
					break;
				case 2: //change cinema number
					break;
				case 3: //change movie format
					break;
				case 4: //exit
					return;
				default:
					break;
				}
			}while();
			
			/*System.out.println("What would you like to update for " + movieTitle + "?");
			System.out.println("1. Timing of " + movieTitle); //change timing of that movie
			System.out.println("3. Cinema Number of " + movieTitle + " shown at " + s.getTiming()); //change cinemaNum
			System.out.println("4. Movie Format of " + s.getMovie() + " shown at " + s.getTiming());  //change movieFormat for that movie
			System.out.println("5. Exit");
			int updateChoice = sc.nextInt();
			switch(updateChoice) {
			case 1: //update timing for that movie
				System.out.println("Current showtimes for " + s.getMovie());
				for(i=0;i<stByMovie.size();i++) {
					System.out.println((i+1) + ". " + "Showing at " + s.getTiming() + " on " + s.getDate());
				}
				System.out.println("Choose showtime to update:");
				i = sc.nextInt();
				
				System.out.println("Enter new timing for showing of " + s.getMovie() + " on " + s.getDate());
				int newTiming = sc.nextInt();
				for(i=0;i<stdb.size();i++) {
					if(newTiming == stdb.get(i).getTiming() && )
				}
				System.out.println("Timing changed for " + s.getMovie());
				break;
			case 2: //update cinema number for that movie
				break;
			case 3: //update movie format shown for that movie
				break;
			case 4: //exit
				return;
			default:
				break;
			}*/
		} while();
		
		

		
	}
	private void updateByDate()

		
		//select by movie
		
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
			db.removeSTToDB(s);
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
