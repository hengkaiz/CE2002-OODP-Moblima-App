package admin;

import java.util.ArrayList;
import java.util.Scanner;
import moblima.SaveAndLoadDB;
import cinema.*;
import movies.*;

public class CinemaShowtimesAndMovieEditor {
	private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
	private int cineplexNumber;
	private MovieDatabase mdb;
	private ShowTimeDatabase stdb;
	private Cineplex cineplex;
	
	CinemaShowtimesAndMovieEditor(int cineplexNumber){
		this.cineplexNumber = cineplexNumber;
		this.mdb = saveAndLoadDB.loadMovieDB();
		this.stdb = saveAndLoadDB.loadShowTimeDB(this.cineplexNumber);
		this.cineplex = saveAndLoadDB.loadCineplex(this.cineplexNumber);
	}
	
	/*ShowTime s = null;
	ShowTimeDatabase db = new ShowTimeDatabase();
	ArrayList<ShowTime> stdb = db.getShowTimes();
	MovieDatabase mdb = new MovieDatabase();
	ArrayList<Movie> msdb = mdb.getMovies();*/
	
	public void createCinemaShowtimesAndMovie() {
		
		Scanner sc = new Scanner(System.in);
		int i=0;
		Movie m = null;
		
		System.out.println("Enter Timing (hhhh format):");
		int timing = sc.nextInt();
		
		ArrayList<String> movieTitles = mdb.getMovieTitlesList();
		System.out.println("Current movies showing: ");
		System.out.println(movieTitles.size());
		for(i=0;i<movieTitles.size();i++){
			System.out.println((i+1) + ". " + movieTitles.get(i));
		}
		System.out.println("Choose movie to add");
		int movieToAdd = sc.nextInt();
		if(movieToAdd-1 > movieTitles.size()) {
			System.out.println("No such movie at index " + movieToAdd + ".");
			return;
		}
		String movieTitle = movieTitles.get(movieToAdd-1);
		for(i=0;i<msdb.size();i++){
			if(movieTitle.equals(msdb.get(i).getMovieTitle())) {
				m = msdb.get(i);
				break;
			}
		}
		
		System.out.println("Enter number of days from current: ");
		int numOfDaysFromCurrent = sc.nextInt();
		
		System.out.println("Enter Cinema Number: ");
		int cinemaNum = sc.nextInt();
		
		System.out.println("Choose Movie Format: ");
		i = 1;
		for(MovieFormat mf : MovieFormat.values()) {
			System.out.println(i + ". " + mf.getName());
			i++;
		}
		int movieFormatChoice = sc.nextInt();
		MovieFormat movieFormat=null;
		for(MovieFormat mf : MovieFormat.values()) { //go through array until find the one equal to user input
			if(mf.ordinal() == movieFormatChoice-1){
				movieFormat = mf;
			}
		}
		
		s = new ShowTime(timing, m, numOfDaysFromCurrent, cineplexNum, cinemaNum, movieFormat);
		db.addSTToDB(s);
	}
	public void updateCinemaShowtimesAndMovie() {
		Scanner sc = new Scanner(System.in);
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
				for(i=0;i<movieTitles.size();i++){
					System.out.println((i+1) + ". " + movieTitles.get(i));
				}
				System.out.println("Choose movie to update");
				int movieToAdd = sc.nextInt();
				if(movieToAdd-1 > movieTitles.size()) {
					System.out.println("No such movie at index " + movieToAdd + ".");
					return;
				}
				updateByMovie(movieTitles.get(movieToAdd-1));
				break;
			case 2: //select by date
				sc.nextLine(); //dummy
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
		Scanner sc = new Scanner(System.in);
		int i=0;
		ArrayList<ShowTime> stByMovie = db.searchByMovie(movieTitle);

		//update
		int chooseST = 0;
		do {
			if(stByMovie.size() == 0) {
				System.out.println("No showtimes available for " + movieTitle);
				break;
			}
			//print current showtimes for movie selected
			System.out.println("Current showtimes for " + movieTitle);
			for(i=0;i<stByMovie.size();i++) {
				s = stByMovie.get(i);
				System.out.println((i+1) + ". Showing at " + s.timeToString() + " on " + s.toStringGetDate());
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
				System.out.println("2. Change Cinema Number");
				System.out.println("3. Change Movie Format");
				System.out.println("4. Exit");
				updateChoice = sc.nextInt();
				switch(updateChoice) {
				case 1: //change timing
					String oldTiming = s.timeToString();
					System.out.println("Enter new timing");
					//no error checking if another st have the same timing as newtiming
					s.setTiming(sc.nextInt());
					System.out.println(s.getMovie() + " now showing at "+ s.timeToString() + " instead of " + oldTiming);
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
						System.out.println(i + ". " + mf.getName());
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
					System.out.println(s.getMovie() + " now showing in " + s.getMovieformat().getName());
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
		Scanner sc = new Scanner(System.in);
		int i=0;
		ArrayList<ShowTime> stByDate = db.searchByDate(date); //get list of all the ST at that date
		
		//update
		int chooseST = 0;
		do {
			if(stByDate.size() == 0) {
				System.out.println("No showtimes available for " + date);
				break;
			}
			//print current showtimes for movie selected
			System.out.println("Current showtimes showing on " + date);
			for(i=0;i<stByDate.size();i++){
				s = stByDate.get(i);
				System.out.println((i+1) + ". " + s.getMovie() + " showing at " + s.timeToString());
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
				System.out.println("3. Change Cinema Number");
				System.out.println("4. Change Movie Format");
				System.out.println("5. Exit");
				updateChoice = sc.nextInt();
				switch(updateChoice) {
				case 1: //change timing
					String oldTiming = s.timeToString();
					System.out.println("Enter new timing");
					//no error checking if another st have the same timing as newtiming
					s.setTiming(sc.nextInt());
					System.out.println(s.getMovie() + " now showing at "+ s.timeToString() + " instead of " + oldTiming);
					break;
				case 2: //change movie
					ArrayList<String> movieTitles = mdb.getMovieTitlesList();
					for(i=0;i<movieTitles.size();i++){
						System.out.println((i+1) + ". " + movieTitles.get(i));
					}
					System.out.println("Enter choice for new movie showing at " + s.timeToString());
					//no error checking for user input of choice of movie
					int newMovieChoice = sc.nextInt();
					String newMovieTitle = movieTitles.get(newMovieChoice -1);
					for(i=0; i<msdb.size(); i++) {
						if(newMovieTitle.equals(msdb.get(i).getMovieTitle())) {
							s.setMovie(msdb.get(i));
						}
					}
					System.out.println(s.getMovie() + " now showing at " + s.timeToString());
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
						System.out.println(i + ". " + mf.getName());
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
					System.out.println(s.getMovie() + " now showing in " + s.getMovieformat().getName());
					break;
				case 5: //exit
					break;
				default:
					break;
				}
			}while(updateChoice != 5);
		}while(chooseST != -1);
	}
	public void removeCinemaShowtimesAndMovie() {
		Scanner sc = new Scanner(System.in);
		int i=0;
		ArrayList<ShowTime> stList = db.getShowTimes();
		
		int stChoice = 0;
		for(i=0;i<stList.size();i++) {
			System.out.println((i+1) + ". " + stList.get(i).getMovie() + " showing at " + stList.get(i).timeToString() + " on " + stList.get(i).toStringGetDate());
		}
		System.out.println("Which Showtime do you want to remove? (-1 to exit)");
		stChoice = sc.nextInt();
		if(stChoice == -1) {
			return;
		}
		if(stChoice-1 > stList.size()) {
			System.out.println("No such ShowTime at index " + stChoice + ".");
			return;
		}
		s = stList.get(stChoice-1);
		if(checkShowtimes(s)) { //valid showtime
			String movieTitle = s.getMovie();
			String timing = s.timeToString();
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
	
	public int cinemaSelection() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Cinema> cinemaList = cineplex.getCinemas();
		int sel=0,i=1;
		
		System.out.println("---Select Cinema to create Showtime in---");
		for(Cinema cinema : cinemaList) {
			System.out.printf("%d. Cinema %d: %s\n", i, cinema.getCinemaNumber(), cinema.getType());
			i++;
		}
        boolean loop = true;
        do {
        try {
        	System.out.println("Please enter Cinema number: ");
			sel = sc.nextInt();
			if (sel<1 || sel>i) { //check exceptions?
				throw new Exception();
			}
			loop =false;
		} catch (Exception e) {
			System.out.println("No such cinema number. Try Again.");
		}
        } while (loop);
		
        return (sel-1);
	}
}
