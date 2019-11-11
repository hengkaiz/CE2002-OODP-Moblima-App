package admin;

import java.util.Scanner;
public class CinemaShowtimesAndMovieEditor {

	Scanner sc = new Scanner(System.in);
	
	public void createCinemaShowtimesAndMovie() {
		Showtime s = new Showtime();
		
		System.out.println("Enter Timing:");
		s.setTiming(sc.nextInt());
		
		System.out.println("Enter Movie Title: ");
		s.setMovie(sc.nextLine());
		
		System.out.println("Enter Cinema Number: ");
		s.setCinemaNum(sc.nextInt());
		
		System.out.println("Enter Cinema Type: ");
		s.setCinemaType(sc.nextLine());
		
		//should just enter an empty seat plan for the booking class to update whenever
		//s.setSeatPlan();
	}
	public void updateCinemaShowtimesAndMovie(Showtime s) {
		if(checkShowtimes(s)) { //valid showtime
			int showtimeChoice = 0;
			do {
				System.out.println("What would you like to update?");
				System.out.println("1. Timing of " + s.getMovie()); //change timing of that movie
				System.out.println("2. Movie shown at " + s.getTiming()); //change movie shown at that timing
				System.out.println("3. Cinema Number of " + s.getMovie() + " shown at " + s.getTiming()); //change cinemaNum
				System.out.println("4. Cinema Type of " + s.getMovie() + " shown at " + s.getTiming()); //change cinemaType
				System.out.println("5. Exit");
				
				showtimeChoice = sc.nextInt();
				switch(showtimeChoice) {
				case 1: //change timing
					System.out.println("Enter new timing for showing of " + s.getMovie());
					s.setTiming(sc.nextInt());
					System.out.println("Timing changed for " + s.getMovie());
					break;
				case 2: //change movie
					System.out.println("Movies currently available for showing: ");
					for(int i=0; i < len(MovieDatabase.getMovies()); i++) {
						System.out.println((i+1) + ". " + MovieDatabase.getMovies()[i].getMovieTitle());
					}
					System.out.println("Enter choice for new movie showing at " + s.getTiming());
					//no error checking for user input of choice of movie
					int newMovieChoice = sc.nextInt();
					s.setMovie(MoviesDatabase.getMovies()[newMovieChoice - 1].getMovieTitle());
					System.out.println(s.getMovie() + " now showing at " + s.getTiming());
					break;
				case 3: //change cinema num
					System.out.println("Enter new cinema number to show " + s.getMovie() + " at " + s.getTiming());
					//check if cinema is available at that time
					//if free,
					s.setCinemaNum(sc.nextInt());
					System.out.println(s.getMovie() + " now showing at " + s.getTiming() + " in cinema number " + s.getCinemaNum());
					break;
				case 4: //change cinema type
					System.out.println("Enter new cinema type to show " + s.getMovie() + " at " + s.getTiming());
					s.setCinemaType(sc.nextLine());
					System.out.println(s.getMovie() + " now showing at " + s.getTiming() + " in " + s.getCinemaType());
					break;
				case 5: //exit
					return;
				default: 
					break;
				}
			} while(showtimeChoice != 5);

		}
	}
	public void removeCinemaShowtimesAndMovie(Showtime s) {
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
	public boolean checkShowtimes(Showtime s) {
		//Showtime[] showtimes =  ?????
		for(int i=0; i < len(ShowtimeDatabase.getShowtimes()); i++) {
			if(s.getTiming() == ShowtimeDatabase.getShowtimes()[i].getTiming() && s.getMovie() == ShowtimeDatabase.getShowtimes()[i].getMovie() && s.getCinemaNum() == ShowtimeDatabase.getShowtimes()[i].getCinemaNum() && s.getCinemaType() == ShowtimeDatabase.getShowtimes()[i].getCinemaType()) {// && s.getSeatPlan() == ShowtimeDatabase.getShowtimes()[i].getSeatPlan()) {
				//found showtime match
				return true;
			}
		}
		//no match found
		return false;
	}
}
