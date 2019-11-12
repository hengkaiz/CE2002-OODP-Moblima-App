package admin;

import java.util.Scanner;
import Movie.*;
public class MovieListingEditor {
	
	Scanner sc = new Scanner(System.in);
	/*enum Status{
		NOW_SHOWING, COMING_SOON, PREVIEW, ENDING_SOON;
	}
	private Status status;
	private String movie;
	
	Movie selectedMovie; //create movie ref
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}*/
	public void createMovieListing() { //creating a new Movie object
		Movie m = new Movie(); //create new movie object
		
		System.out.println("Enter Movie Title: ");
		m.setMovieTitle(sc.nextLine());
		
		System.out.println("Enter Movie Sypnosis: ");
		m.setMovieSypnosis(sc.nextLine());
		
		System.out.println("Enter Movie Cast: (-1 to exit)");
		String cast = null; 
		String[] castList; //array to store cast list
		int i = 0; //marker for array index
		cast = sc.nextLine();
		while(cast != "-1") {
			castList[i] = cast;
			i++;
			cast = sc.nextLine();
		}
		m.setMovieCast(castList);
		
		System.out.println("Enter Movie Director: (-1 to exit)");
		String director = null;
		String[] dirList;
		i = 0;
		director = sc.nextLine();
		while(director != "-1") {
			dirList[i] = director;
			i++;
			director = sc.nextLine();
		}
		m.setMovieDirector(dirList);
		
		System.out.println("Enter Movie Overall Rating: ");
		m.setOverallRating(sc.nextFloat());
		
		System.out.println("Choose status for " + m.getMovieTitle() + " :");
		MovieStatus status;
		int i = 1;
		for(status : MovieStatus.values()) {
			System.out.println(i + ". " + status);
		}
		System.out.println("1. Now Showing ");
		System.out.println("2. Coming Soon ");
		System.out.println("3. Preview ");
		System.out.println("4. Ending Soon ");
		m.setMovieStatus(sc.nextInt());
		
		System.out.println(m.getMovieTitle() + " created!");
		MovieDatabase.updateMovieDatabase(m); //update movie database
	}
	public void updateMovieListing(Movie m) {
		//selectedMovie = m;
		if(this.checkMovie(m)) { //valid movie entry
			int updateChoice = 0;
			do {
				//updating of movie title not allowed
				System.out.println("What would you like to update for " + m.getMovieTitle());
				System.out.println("1. Update Movie Sypnosis");
				System.out.println("2. Update Movie Cast");
				System.out.println("3. Update Movie Director");
				System.out.println("4. Update Movie Overall Rating");
				System.out.println("5. Update Movie Status");
				System.out.println("6. Exit");
				
				updateChoice = sc.nextInt();
				switch(updateChoice) {
				case 1: //update movie sypnosis
					System.out.println("Enter new Movie Sypnosis: ");
					m.setMovieSypnosis(sc.nextLine());
					System.out.println(m.getMovieTitle() + " Sypnosis updated");
					break;
				case 2: //update movie cast
					int castChoice = 0;
					int x = 0;
					String cast = null; 
					String[] castList; //array to store cast list
					
					System.out.println("Current Cast List:");
					for (int i=0; i < len(m.getMovieCast()); i++) {
						System.out.println(m.getMovieCast()[i]);
					}
					System.out.println("1. Add Cast Member");
					System.out.println("2. Remove Cast Member");
					castChoice = sc.nextInt();
					switch(castChoice) {
					case 1: //add cast member
						System.out.println("Enter Cast Member to add: (-1 to exit)");
						castList = null; //clear array before using
						cast = sc.nextLine();
						x = 0; //reset x
						while(cast != "-1") {
							castList[x] = cast;
							x++;
							cast = sc.nextLine();
						}
						m.addMovieCast(castList);
						System.out.println("Cast added for " + m.getMovieTitle());
						break;
					case 2: //remove cast member						
						System.out.println("Enter Cast Member to remove: (-1 to exit)");
						castList = null; //clear array before using
						cast = sc.nextLine();
						x = 0; //reset x
						while(cast != "-1") {
							castList[x] = cast;
							x++;
							cast = sc.nextLine();
						}
						m.removeMovieCast(castList);
						System.out.println("Cast removed for " + m.getMovieTitle());
						break;
					default:
						break;
					}
					break;
				case 3: //update movie director
					int dirChoice = 0;
					int j = 0;
					String dir = null; 
					String[] dirList; //array to store cast list
					
					System.out.println("Current Cast List:");
					for (int i=0; i < len(m.getMovieDirector()); i++) {
						System.out.println(m.getMovieDirector()[i]);
					}
					System.out.println("1. Add Director");
					System.out.println("2. Remove Director");
					dirChoice = sc.nextInt();
					switch(dirChoice) {
					case 1: //add director
						System.out.println("Enter Director to add: (-1 to exit)");
						dirList = null; //clear array before using
						dir = sc.nextLine();
						j = 0; //reset j
						while(dir != "-1") {
							dirList[j] = dir;
							j++;
							dir = sc.nextLine();
						}
						m.addMovieDirector(dirList);
						System.out.println("Director added for " + m.getMovieTitle());
						break;
					case 2: //remove director					
						System.out.println("Enter Director to remove: (-1 to exit)");
						dirList = null; //clear array before using
						dir = sc.nextLine();
						j = 0; //reset j
						while(dir != "-1") {
							dirList[x] = dir;
							j++;
							dir = sc.nextLine();
						}
						m.removeMovieDirector(dirList);
						System.out.println("Director removed for " + m.getMovieTitle());
						break;
					default:
						break;
					}
					break;
				case 4: //update movie overall rating
					System.out.println("Enter new Movie Overall Rating: ");
					m.setMovieOverallRating(sc.nextFloat());
					System.out.println(m.getMovieTitle() + " Overall Rating updated");
					break;
				case 5: //update movie status
					System.out.println("Choose new status for " + m.getMovieTitle() + " :");
					System.out.println("1. Now Showing ");
					System.out.println("2. Coming Soon ");
					System.out.println("3. Preview ");
					System.out.println("4. Ending Soon ");
					m.setMovieStatus(sc.nextInt());
					System.out.println(m.getMovieTitle() + " Status updated");
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
	public void removeMovieListing(Movie m) {
		if(this.checkMovie(m)) { //valid movie entry
			String movieTitle = m.getMovieTitle();
			m = null;		
			System.out.println(movieTitle + " removed!");
		}
		else { //invalid movie entry
			System.out.println("Movie not available!");
		}
	}
	public boolean checkMovie(Movie m) {
		//Movie[] movieDatabase =  ?????
		for(int i=0; i < len(MovieDatabase.getMovies()); i++) {
			if(m.getMovieTitle() == Movie[i].getMovieTitle() && m.getMovieSypnosis() == Movie[i].getMovieSypnosis() && m.getMovieCast() == Movie[i].getMovieCast() && m.getMovieDirector() == Movie[i].getMovieDirector() && m.getMovieOverallRating() == Movie[i].getMovieOverallRating() && m.getMovieStatus() == Movie[i].getMovieStatus()) {
				//found movie match
				return true;
			}
		}
		//no match found
		return false;
	}
}
