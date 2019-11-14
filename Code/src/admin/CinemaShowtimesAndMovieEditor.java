package admin;

import java.util.ArrayList;
import java.util.Scanner;
import cinema.*;
import database.*;
import movies.*;

public class CinemaShowtimesAndMovieEditor {

	Scanner sc = new Scanner(System.in);
	ShowTime s = null;
	ShowTimeDatabase db = new ShowTimeDatabase();
	ArrayList<ShowTime> stdb = db.getShowTimes();
	MovieDatabase mdb = new MovieDatabase();
	ArrayList<Movie> msdb = mdb.getMovies();
	
	public void createCinemaShowtimesAndMovie() {
		ShowTime s = new ShowTime();
		
		System.out.println("Enter Timing:");
		s.setTiming(sc.nextInt());
		
		System.out.println("Enter cinema Number: ");
		s.setCinemaNum(sc.nextInt());
		
		System.out.println("Choose Movie Format: ");
		int i = 1;
		for(MovieFormat mf : MovieFormat.values()) {
			System.out.println(i + ". " + mf.name());
			i++;
		}
		int movieFormatChoice = sc.nextInt();
		MovieFormat movieFormat=null;
		for(MovieFormat mf : MovieFormat.values()) { //go through array until find the one equal to user input
			if(mf.ordinal() == movieFormatChoice-1){
				movieFormat = mf;
			}
		}
		s.setMovieformat(movieFormat);

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
				//print all the movies for the admin to choose to update
				ArrayList<String> movieTitles = mdb.getMovieTitlesList();
				for(i=0;i<movieTitles.size();i++);{
					System.out.println((i+1) + ". " + movieTitles.get(i));
				}
				System.out.println("Choose movie to update");
				updateByMovie(movieTitles.get(sc.nextInt()-1));
				break;
			case 2: //select by date
				System.out.println("Enter date (dd/mm): ");
				updateByDate(sc.nextLine());
				break;
			case 3: //exit
				break;
			default:
				break;
			}
		}while(selectChoice != 3);
	}
	private void updateByMovie(String movieTitle) {
		int i=0;
		ArrayList<ShowTime> stByMovie = db.searchByMovie(movieTitle);

		//update
		int chooseST = 0;
		do {
			//print current showtimes for movie selected
			System.out.println("Current showtimes for " + movieTitle);
			for(i=0;i<stByMovie.size();i++) {
				s = stByMovie.get(i);
				System.out.println((i+1) + ". Showing at " + s.getTiming() + " on " + s.getDate());
			}
			System.out.println("Choose showtime to update: (enter -1 to exit)");
			chooseST = sc.nextInt();
			if(chooseST == -1) {
				break;
			}
			s = stByMovie.get(chooseST-1);
			
			int updateChoice = 0;
			do {
				System.out.println("1. Change Timing"); //same date new timing
				System.out.println("2. Change cinema Number");
				System.out.println("3. Change Movie Format");
				System.out.println("4. Exit");
				updateChoice = 0;
				switch(updateChoice) {
				case 1: //change timing
					System.out.println("Enter new timing");
					//no error checking if another st have the same timing as newtiming
					s.setTiming(sc.nextInt());
					System.out.println("Timing changed for " + s.getMovie());
					break;
				case 2: //change cinema number
					System.out.println("Enter new cinema Number");
					s.setCinemaNum(sc.nextInt());
					System.out.println(s.getMovie() + " now showing at cinema Number " + s.getCinemaNum());
					break;
				case 3: //change movie format
					System.out.println("Choose new Movie Format: ");
					i=1;
					for(MovieFormat mf : MovieFormat.values()) {
						System.out.println(i + ". " + mf.name());
						i++;
					}
					int movieFormatChoice = sc.nextInt();
					MovieFormat movieFormat=null;
					for(MovieFormat mf : MovieFormat.values()) {//go through array until find the one equal to user input
						if(mf.ordinal() == movieFormatChoice-1){
							movieFormat = mf;
						}
					}
					s.setMovieformat(movieFormat);
					System.out.println(s.getMovie() + " now showing in " + s.getMovieformat());
					break;
				case 4: //exit
					break;
				default:
					break;
				}
			}while(updateChoice != 4);
		} while(chooseST != -1);
	}
	private void updateByDate(String date) {
		int i=0;
		ArrayList<ShowTime> stByDate = db.searchByDate(date); //get list of all the ST at that date
		
		//update
		int chooseST = 0;
		do {
			//print current showtimes for movie selected
			System.out.println("Current showtimes showing on " + date);
			for(i=0;i<stByDate.size();i++) {
				s = stByDate.get(i);
				System.out.println((i+1) + ". " + s.getMovie() + "Showing at " + s.getTiming());
			}
			System.out.println("Choose showtime to update: (enter -1 to exit)");
			chooseST = sc.nextInt();
			if(chooseST == -1) {
				break;
			}
			s = stByDate.get(chooseST-1);
			
			int updateChoice = 0;
			do {
				System.out.println("1. Change Timing"); //same date new timing
				System.out.println("2. Change Movie"); //same timing new movie
				System.out.println("3. Change cinema Number");
				System.out.println("4. Change Movie Format");
				System.out.println("5. Exit");
				updateChoice = 0;
				switch(updateChoice) {
				case 1: //change timing
					System.out.println("Enter new timing");
					//no error checking if another st have the same timing as newtiming
					s.setTiming(sc.nextInt());
					System.out.println("Timing changed for " + s.getMovie());
					break;
				case 2: //change movie
					ArrayList<String> movieTitles = mdb.getMovieTitlesList();
					for(i=0;i<movieTitles.size();i++);{
						System.out.println(movieTitles.get(i));
					}
					System.out.println("Enter choice for new movie showing at " + s.getTiming());
					//no error checking for user input of choice of movie
					int newMovieChoice = sc.nextInt();
					String newMovieTitle = movieTitles.get(newMovieChoice -1);
					for(i=0; i<msdb.size(); i++) {
						if(newMovieTitle.equals(msdb.get(i).getMovieTitle())) {
							s.setMovie(msdb.get(i));
						}
					}
					System.out.println(s.getMovie() + " now showing at " + s.getTiming());
					break;
				case 3: //change cinema number
					System.out.println("Enter new cinema Number");
					s.setCinemaNum(sc.nextInt());
					System.out.println(s.getMovie() + " now showing at cinema Number " + s.getCinemaNum());
					break;
				case 4: //change movie format
					System.out.println("Choose new Movie Format: ");
					i=1;
					for(MovieFormat mf : MovieFormat.values()) {
						System.out.println(i + ". " + mf.name());
						i++;
					}
					int movieFormatChoice = sc.nextInt();
					MovieFormat movieFormat=null;
					for(MovieFormat mf : MovieFormat.values()) {//go through array until find the one equal to user input
						if(mf.ordinal() == movieFormatChoice-1){
							movieFormat = mf;
						}
					}
					s.setMovieformat(movieFormat);
					System.out.println(s.getMovie() + " now showing in " + s.getMovieformat());
					break;
				case 5: //exit
					break;
				default:
					break;
				}
			}while(updateChoice != 5);
		}while(chooseST != -1);
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
	}
}
