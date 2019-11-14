package admin;

import java.util.Scanner;
import movies.*;
import java.util.ArrayList;
import java.lang.Object;

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
		int updateMovieChoice = 0;
		System.out.println("Current movies: ");
		int i=0;
		for(i=0; i<mdb.size(); i++) {
			System.out.println((i+1) + ". " + mdb.get(i).getMovieTitle());
		}
		System.out.println("Which Movie do you want to update? (-1 to exit)");
		updateMovieChoice = sc.nextInt();
		if(updateMovieChoice == -1) {
			return;
		}
		selectedMovie = mdb.get(updateMovieChoice-1);
		
		//selection of update
		//if(checkMovie(selectedMovie)) { //valid movie entry
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
				sc.nextLine(); //dummy
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
				System.out.println("3. Exit");
				
				castChoice = sc.nextInt();
				switch(castChoice) {
				case 1: //add cast member
					do {
						sc.nextLine(); //dummy
						System.out.println("Enter Cast Member to add: (-1 to exit)");
						cast = sc.nextLine();
						selectedMovie.addMovieCast(cast);
					} while(cast != "-1");
					System.out.println("Cast added");
					break;
				case 2: //remove cast member
					do {
						sc.nextLine(); //dummy
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
						sc.nextLine(); //dummy
						System.out.println("Enter Director to add: (-1 to exit)");
						director = sc.nextLine();
						selectedMovie.addMovieDirector(director);
					} while(director != "-1");
					System.out.println("Director added");
					break;
				case 2: //remove director
					do {
						sc.nextLine(); //dummy
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
			case 6: //exit
				break;
			default: //while loop again
				break;
			}
		} while(updateChoice != 6);

		/*else { //invalid movie entry
			System.out.println("Movie not available!");
			return;
		}*/
	}
	public void removeMovieListing() { //remove by setting status to "END_OFSHOWING"		
		ArrayList<String> mtdb = movieDatabase.getMovieTitlesList();
		System.out.println("Do you want to delete from database or remove from user view?");
		System.out.println("1. Delete from database ");
		System.out.println("2. Remove from user view (marking movie as \"End of Showing\")");
		
		int choice = sc.nextInt();
		if(choice == 1) { //remove from database
			movieDatabase.removeMovieFromDB();
			System.out.println("Movie deleted from database");
		}
		if(choice == 2) {
			//choosing movie to remove
			System.out.println("Movies currently in user view:");
			int i=0;
			for(i=0; i<mtdb.size(); i++) {
				System.out.println((i+1) + ". " + mtdb.get(i));
			}
			System.out.println("Which Movie do you want to remove?");
			int updateMovieChoice = sc.nextInt();
			String title = mtdb.get(updateMovieChoice-1);
			for(i=0; i<mdb.size(); i++) {
				if(title.equals(mdb.get(i).getMovieTitle())) {
					selectedMovie = mdb.get(i);
				}
			}
			
			//set status of selectedMovie to "END_OF_SHOWING"
			selectedMovie.setStatus(MovieStatus.END_OF_SHOWING);
			System.out.println("Movie removed from user view");
		}

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
