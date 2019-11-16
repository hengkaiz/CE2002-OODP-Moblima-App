package admin;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import moblima.SaveAndLoadDB;
import cinema.*;
import movies.*;

public class AdminShowtimeEditor {
	private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
	private int cineplexNumber;
	private MovieDatabase mdb;
	private ShowTimeDatabase stdb;
	private Cineplex cineplex;
	private ShowTime st;
	
	public AdminShowtimeEditor(int cineplexNumber){
		this.cineplexNumber = cineplexNumber;
		this.mdb = saveAndLoadDB.loadMovieDB();
		this.stdb = saveAndLoadDB.loadShowTimeDB(this.cineplexNumber);
		this.cineplex = saveAndLoadDB.loadCineplex(this.cineplexNumber);
	}
	
	public void createShowtimes(int cinemaNum) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
		int sel=0, i=1;
		Movie m = null;
		ArrayList<String> movieTitles = mdb.getMovieTitlesList(); //only gets 'now showing' and 'preview' movies
		ArrayList<Movie> movieList = mdb.getMovies();
		
		//get timing
		System.out.println("Enter Timing (hhhh format):");
		int timing = sc.nextInt();
		
		//get movie
		System.out.println("Current movies showing: ");
		i=1;
		for(String title : movieTitles){
			System.out.printf("%d. %s\n", i, title);
			i++;
		}

        try {
    		System.out.println("Please enter your choice:"); 
    		//need exception in case they enter the movie string instead?
			sel = sc.nextInt();
			if (sel<1 || sel>i-1) { 
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.printf("Invalid movie. Try Again.");
		}
        System.out.println();
		
		String movieTitle = movieTitles.get(sel-1);
		for(Movie movie : movieList){
			if(movieTitle.equals(movie.getMovieTitle())) {
				m = movie;
				break;
			}
		}
		
		//get number of days from current
		int numOfDaysFromCurrent=0;
		Calendar date = Calendar.getInstance();
		//prints out dates of next 5 days
		System.out.println("Select Date:");
		for(i=0; i<5; i++) {
			String output = sdf.format(date.getTime()); //converts it to dd/MM format
			System.out.printf("%d. %s\n", i+1, output);
			date.add(Calendar.DAY_OF_MONTH, 1);
		}

		try {
			System.out.print("Please enter your choice (-1 to return): ");
			numOfDaysFromCurrent = sc.nextInt();
			if (numOfDaysFromCurrent == -1) {
				return;
			}
			if(numOfDaysFromCurrent<1 || numOfDaysFromCurrent>5) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Invalid Date. Try Again.");
		}
		System.out.println();
		
		//get movie format
		MovieFormat movieFormat = movieFormatSelection();
		
		//create new ST object
		this.st = new ShowTime(timing, m, numOfDaysFromCurrent-1, this.cineplexNumber, cinemaNum, movieFormat);
		stdb.addSTToDB(this.st);
		
		//update showtime database
		saveAndLoadDB.saveShowTimeDB(stdb, cineplexNumber);
	}

	public void updateByMovie() {
		Scanner sc = new Scanner(System.in);
		int i=0, sel=0;
		ArrayList<String> movieTitles = mdb.getMovieTitlesList();
		
		//select movie to show showtimes
		System.out.println("Current movies showing: ");
		i=1;
		for(String title : movieTitles){
			System.out.printf("%d. %s\n", i, title);
			i++;
		}

        try {
    		System.out.println("Please enter your choice:"); 
    		//need exception in case they enter the movie string instead?
			sel = sc.nextInt();
			if (sel<1 || sel>i-1) { 
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.printf("Invalid movie. Try Again.");
		}
        System.out.println();
		
        //get selected movie title
		String movieTitle = movieTitles.get(sel-1);
		
		//get list of showtimes for the selected movie
		ArrayList<ShowTime> stByMovie = stdb.searchByMovie(movieTitle);

		//update main
		int chooseST = 0;
		do {
			if(stByMovie.size() == 0) {
				System.out.println("No showtimes available for " + movieTitle);
				break;
			}
			//print current showtimes for movie selected
			System.out.println("Current showtimes for " + movieTitle);
			i=1;
			for(ShowTime sT : stByMovie) {
				System.out.println(i + ". Showing at " + sT.timeToString() + " on " + sT.toStringGetDate());
				i++;
			}

	        try {
	        	System.out.println("Please enter your choice (enter -1 to return):"); 
				chooseST = sc.nextInt();
				if(chooseST == -1) {
					break;
				}
				if (chooseST<1 || chooseST>i-1) {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.printf("Invalid showtime. Try Again.");
			}
	        System.out.println();

	        //get ST to update
			st = stByMovie.get(sel-1);
			
			//choosing what to update
			int updateChoice = 0;
			do {
				System.out.println("---Update Menu---");
				System.out.println("1. Change Timing"); //same date new timing
				System.out.println("2. Change Cinema Number");
				System.out.println("3. Change Movie Format");
				System.out.println("4. Return");

		        try {
		        	System.out.println("Please enter your choice:"); 
		        	updateChoice = sc.nextInt();
					if (updateChoice<1 || updateChoice>4) { //check exceptions?
						throw new Exception();
					}
				} catch (Exception e) {
					System.out.printf("Invalid choice. Try Again.");
				}
		        System.out.println();

				switch(updateChoice) {
				case 1: //change timing
					String oldTiming = st.timeToString();
					System.out.println("Enter new timing");
					//no error checking if another st have the same timing as newtiming
					st.setTiming(sc.nextInt());
					System.out.println(st.getMovie() + " now showing at "+ st.timeToString() + " instead of " + oldTiming);
					break;
				case 2: //change cinema number
					st.setCinemaNum(cinemaSelection());
					System.out.println(st.getMovie() + " now showing at cinema Number " + st.getCinemaNum());
					break;
				case 3: //change movie format
					st.setMovieFormat(movieFormatSelection());
					System.out.println(st.getMovie() + " now showing in " + st.getMovieFormat().getName());
					break;
				case 4: //return
					break;
				default:
					break;
				}
			}while(updateChoice != 4);
		} while(chooseST != -1);
		//update showtime database
		saveAndLoadDB.saveShowTimeDB(stdb, cineplexNumber);
	}
	public void updateByDate() {
		Scanner sc = new Scanner(System.in);
		int i=0;
		ArrayList<String> movieTitles = mdb.getMovieTitlesList();
		ArrayList<Movie> movieList = mdb.getMovies();
		
		System.out.println("Enter date (dd/mm): ");
		String date = sc.nextLine(); //exception handling?
		ArrayList<ShowTime> stByDate = stdb.searchByDate(date); //get list of all the ST at that date	
		
		//update main
		int chooseST = 0;
		do {
			if(stByDate.size() == 0) {
				System.out.println("No showtimes available for " + date);
				break;
			}
			//print current showtimes for movie selected
			System.out.println("Current showtimes showing on " + date);
			i=1;
			for(ShowTime sT : stByDate){
				System.out.println(i + ". " + sT.getMovie() + " showing at " + sT.timeToString());
				i++;
			}

	        try {
	        	System.out.println("Please enter your choice (enter -1 to return):"); 
				chooseST = sc.nextInt();
				if(chooseST == -1) {
					break;
				}
				if (chooseST<1 || chooseST>i-1) { 
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.printf("Invalid showtime. Try Again.");
			}
	        System.out.println();
			
			st = stByDate.get(chooseST-1);
			
			//choosing what to update
			int updateChoice = 0;
			do {
				System.out.println("---Update Menu---");
				System.out.println("1. Change Timing"); //same date new timing
				System.out.println("2. Change Movie"); //same timing new movie
				System.out.println("3. Change Cinema Number");
				System.out.println("4. Change Movie Format");
				System.out.println("5. Return");

		        try {
		        	System.out.println("Please enter selection: "); 
		        	updateChoice = sc.nextInt();
					if (updateChoice<1 || updateChoice>5) { //check exceptions?
						throw new Exception();
					}
				} catch (Exception e) {
					System.out.printf("Invalid choice. Try Again.");
				}
		        System.out.println();
				switch(updateChoice) {
				case 1: //change timing
					String oldTiming = st.timeToString();
					System.out.println("Enter new timing (hhhh format):");
					//no error checking if another st have the same timing as newtiming
					st.setTiming(sc.nextInt());
					System.out.println(st.getMovie() + " now showing at "+ st.timeToString() + " instead of " + oldTiming);
					break;
				case 2: //change movie
					i=1;
					int newMovieChoice=0;
					i=1;
					for(String title : movieTitles){
						System.out.println(i + ". " + title);
						i++;
					}

			        try {
						System.out.println("Please enter your choice: ");
			    		//need exception in case they enter the movie string instead?
						newMovieChoice = sc.nextInt();
						if (newMovieChoice<1 || newMovieChoice>i-1) {
							throw new Exception();
						}
					} catch (Exception e) {
						System.out.printf("Invalid movie. Try Again.");
					}
			        System.out.println();

					String newMovieTitle = movieTitles.get(newMovieChoice -1);
					for(Movie movie : movieList) {
						if(newMovieTitle.equals(movie.getMovieTitle())) {
							st.setMovie(movie);
						}
					}
					System.out.println(st.getMovie() + " now showing at " + st.timeToString());
					break;
				case 3: //change cinema number
					st.setCinemaNum(cinemaSelection());
					System.out.println(st.getMovie() + " now showing at Cinema Number " + st.getCinemaNum());
					break;
				case 4: //change movie format
					st.setMovieFormat(movieFormatSelection());
					System.out.println(st.getMovie() + " now showing in " + st.getMovieFormat().getName());
					break;
				case 5: //return
					break;
				default:
					break;
				}
			}while(updateChoice != 5);
		}while(chooseST != -1);
		
		//update showtime database
		saveAndLoadDB.saveShowTimeDB(stdb, cineplexNumber);
	}
	public void removeShowtimes() {
		Scanner sc = new Scanner(System.in);
		int i=0;
		ArrayList<ShowTime> stList = stdb.getShowTimes();
		
		int stChoice = 0;
		i=1;
		for(ShowTime st : stList) {
			System.out.println(i + ". " + st.getMovie() + " showing at " + st.timeToString() + " on " + st.toStringGetDate());
			i++;
		}

        try {
        	System.out.println("Please enter your choice (-1 to return):");
    		//need exception in case they enter the movie string instead?
        	stChoice = sc.nextInt();
    		if(stChoice == -1) {
    			return;
    		}
			if (stChoice<1 || stChoice>i-1) { 
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.printf("Invalid showtime. Try Again.");
		}
        System.out.println();

		st = stList.get(stChoice-1);
		
		String movieTitle = st.getMovie();
		String timing = st.timeToString();
		stdb.removeSTToDB(st);
		System.out.println(movieTitle + " at " + timing + " removed!");
		saveAndLoadDB.saveShowTimeDB(stdb, cineplexNumber);
	}
	
	public int cinemaSelection() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Cinema> cinemaList = cineplex.getCinemas();
		int sel=0,i=1;
		
		System.out.println("---Select Cinema---");
		i=1;
		for(Cinema cinema : cinemaList) {
			System.out.printf("%d. Cinema %d: %s\n", i, cinema.getCinemaNumber(), cinema.getType());
			i++;
		}

        try {
        	System.out.println("Please enter your choice:");
			sel = sc.nextInt();
			if (sel<1 || sel>i-1) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Invalid cinema number. Try Again.");
		}
        System.out.println();
		
        return (sel-1);
	}
	
	public MovieFormat movieFormatSelection() {
		Scanner sc = new Scanner(System.in);
		int sel=0, i=0;
		
		System.out.println("---Choose Movie Format--- ");
		i=1;
		for(MovieFormat mf : MovieFormat.values()) {
			System.out.println(i + ". " + mf.getName());
			i++;
		}

        try {
    		System.out.println("Please enter your choice:"); 
    		//need exception in case they enter the movie string instead?
    		sel = sc.nextInt();
			if (sel<1 || sel>i-1) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.printf("Invalid format. Try Again.");
		}
        System.out.println();
		
        MovieFormat movieFormat = null;
		for(MovieFormat mf : MovieFormat.values()) { //go through array until find the one equal to user input
			if(mf.ordinal() == sel-1){
				movieFormat = mf;
				break;
			}
		}
		return movieFormat;
	}
}
