package admin;

import java.util.Scanner;

import movies.*;

import java.util.ArrayList;
public class MovieListingEditor {
	
	Scanner sc = new Scanner(System.in);
	MovieDatabase movieDatabase = new MovieDatabase();
	ArrayList<Movie> mdb = movieDatabase.getMovies();
	Movie selectedMovie = null;
	
	public void createMovieListing() { //creating a new Movie object
		movieDatabase.addMovieToDB();
	}
	public void updateMovieListing() {
		//getting movie to update
		System.out.println("Which Movie do you want to update?");
		int i=0;
		for(i=0; i<mdb.size(); i++) {
			System.out.println((i+1) + ". " + mdb.get(i).getMovieTitle());
		}
		int updateMovieChoice = sc.nextInt();
		selectedMovie = mdb.get(updateMovieChoice-1);
		
		//selection of update
		if(checkMovie(selectedMovie)) { //valid movie entry
			int updateChoice = 0;
			do {
				//updating of movie title not allowed
				System.out.println("What would you like to update for " + selectedMovie.getMovieTitle());
				System.out.println("1. Update Movie Synopsis");
				System.out.println("2. Update Movie Cast");
				System.out.println("3. Update Movie Director");
				System.out.println("4. Update Movie Overall Rating");
				System.out.println("5. Update Movie Status");
				System.out.println("6. Exit");
				
				updateChoice = sc.nextInt();
				switch(updateChoice) {
				case 1: //update movie synopsis
					System.out.println("Enter new Movie Synopsis: ");
					selectedMovie.setMovieSynopsis(sc.nextLine());
					System.out.println(selectedMovie.getMovieTitle() + " Synopsis updated");
					break;
				case 2: //update movie cast
					int castChoice = 0;
					String cast = null; 
					
					System.out.println("Current Cast List:");
					System.out.println(selectedMovie.toStringMovieCast()); //prints the current cast list
					System.out.println("1. Add Cast Member");
					System.out.println("2. Remove Cast Member");
					
					castChoice = sc.nextInt();
					switch(castChoice) {
					case 1: //add cast member
						do {
							System.out.println("Enter Cast Member to add: (-1 to exit)");
							cast = sc.nextLine();
							selectedMovie.addMovieCast(cast);
						} while(cast != "-1");
						System.out.println("Cast added");
						break;
					case 2: //remove cast member
						do {
							System.out.println("Enter Cast Member to remove: (-1 to exit)");
							cast = sc.nextLine();
							selectedMovie.removeMovieCast(cast);
						} while(cast != "-1");
						break;
					default:
						break;
					}
					break;
				case 3: //update movie director
					int directorChoice = 0;
					String director = null;
					
					System.out.println("Current Director List:");
					System.out.println(selectedMovie.toStringMovieDirector()); //prints the current director list
					System.out.println("1. Add Director");
					System.out.println("2. Remove Director");
					
					directorChoice = sc.nextInt();
					switch(directorChoice) {
					case 1: //add director
						do {
							System.out.println("Enter Director to add: (-1 to exit)");
							director = sc.nextLine();
							selectedMovie.addMovieDirector(director);
						} while(director != "-1");
						System.out.println("Director added");
						break;
					case 2: //remove director
						do {
							System.out.println("Enter Director to remove: (-1 to exit)");
							director = sc.nextLine();
							selectedMovie.removeMovieDirector(director);
						} while(director != "-1");
						break;
					default:
						break;
					}
					break;
				case 4: //update movie overall rating
					System.out.println("Enter new Movie Overall Rating: ");
					selectedMovie.setMovieOverallRating(sc.nextFloat());
					System.out.println(selectedMovie.getMovieTitle() + " Overall Rating updated");
					break;
				case 5: //update movie status
					System.out.println("Choose new status for " + selectedMovie.getMovieTitle() + " :");
					i=1;
					for(MovieStatus status : MovieStatus.values()) {
						System.out.println(i + ". " + status.getName());
						i++;
					}
					int statusChoice = sc.nextInt();
					for(MovieStatus status : MovieStatus.values()) {				//go through array until find the one equal to user input
						if(status.ordinal()==statusChoice-1){
							selectedMovie.setStatus(status);
						}
					}
					System.out.println("Movie Status updated");
					break;
				case 6: //exit out of function
					System.out.println("Exiting");
					return;
				default: //while loop again
					break;
				}
			} while(updateChoice != 6);
		}
		else { //invalid movie entry
			System.out.println("Movie not available!");
			return;
		}
	}
	public void removeMovieListing() { //remove by setting status to "END_OFSHOWING"		
		//choosing movie to remove
		System.out.println("Which Movie do you want to remove?");
		int i=0;
		for(i=0; i<mdb.size(); i++) {
			System.out.println((i+1) + ". " + mdb.get(i).getMovieTitle());
		}
		int updateMovieChoice = sc.nextInt();
		selectedMovie = mdb.get(updateMovieChoice-1);
		
		//set status of selectedMovie to "END_OF_SHOWING"
		selectedMovie.setStatus(MovieStatus.END_OF_SHOWING);
	}
	public boolean checkMovie(Movie m) {
		for(int i=0; i < mdb.size(); i++) {
			if(selectedMovie.equals(mdb.get(i))) {
				return true;
			}
		}
		return false;
	}
}
