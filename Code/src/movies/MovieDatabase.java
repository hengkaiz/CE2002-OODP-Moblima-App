package movies;
import java.util.ArrayList;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class MovieDatabase implements Serializable{
	private ArrayList<Movie> movieList;
	
	public MovieDatabase(){ //existing movie list
		this.movieList = new ArrayList<Movie>();
		movieList.add(new Movie("Charlie's Angel", "Sypnosis: Charlie's Angels have always provided security and investigative skills to private clients. Now the Townsend Agency has expanded internationally with the smartest and most highly trained women from all over the globe — multiple teams of Angels guided by multiple Bosleys, completing the toughest missions around the world. When a young systems engineer blows the whistle on a dangerous technology, these Angels are called into action, putting their lives on the line to protect people.", MovieStatus.COMING_SOON));
		movieList.add(new Movie("Terminator: Dark Fate", "Sypnosis:In Mexico City, a newly modified liquid Terminator -- the Rev-9 model -- arrives from the future to kill a young factory worker named Dani Ramos. Also sent back in time is Grace, a hybrid cyborg human who must protect Ramos from the seemingly indestructible robotic assassin. But the two women soon find some much-needed help from a pair of unexpected allies -- seasoned warrior Sarah Connor and the T-800 Terminator.", MovieStatus.NOW_SHOWING));
		movieList.add(new Movie("Gemini Man", "Sypnosis:Henry Brogan is an elite 51-year-old assassin who's ready to call it quits after completing his 72nd job. His plans get turned upside down when he becomes the target of a mysterious operative who can seemingly predict his every move. To his horror, Brogan soon learns that the man who's trying to kill him is a younger, faster, cloned version of himself.", MovieStatus.NOW_SHOWING));
		movieList.add(new Movie("The Addams Family", "Sypnosis:Members of the mysterious and spooky Addams family -- Gomez, Morticia, Pugsley, Wednesday, Uncle Fester and Grandma -- are readily preparing for a visit from their even creepier relatives. But trouble soon arises when shady TV personality Margaux Needler realizes that the Addams' eerie hilltop mansion is standing in the way of her dream to sell all the houses in the neighborhood.", MovieStatus.NOW_SHOWING));
		movieList.add(new Movie("Frozen 2", "Sypnosis: Elsa the Snow Queen and her sister Anna embark on an adventure far away from the kingdom of Arendelle. They are joined by friends, Kristoff, Olaf, and Sven.", MovieStatus.COMING_SOON));
		movieList.add(new Movie("Joker", "Sypnosis: Forever alone in a crowd, failed comedian Arthur Fleck seeks connection as he walks the streets of Gotham City. Arthur wears two masks -- the one he paints for his day job as a clown, and the guise he projects in a futile attempt to feel like he's part of the world around him. Isolated, bullied and disregarded by society, Fleck begins a slow descent into madness as he transforms into the criminal mastermind known as the Joker.", MovieStatus.END_OF_SHOWING));
		movieList.add(new Movie("Maleficent", "Sypnosis: Maleficent travels to a grand old castle to celebrate young Aurora's upcoming wedding to Prince Phillip. While there, she meets Aurora's future mother-in-law -- a conniving queen who hatches a devious plot to destroy the land's fairies. Hoping to stop her, Maleficent joins forces with a seasoned warrior and a group of outcasts to battle the queen and her powerful army.", MovieStatus.NOW_SHOWING));
		movieList.add(new Movie("Pokemon Detective Pikachu", "Sypnosis: Ace detective Harry Goodman goes mysteriously missing, prompting his 21-year-old son, Tim, to find out what happened. Aiding in the investigation is Harry's former Pokémon partner, wise-cracking, adorable super-sleuth Detective Pikachu. Finding that they are uniquely equipped to work together, as Tim is the only human who can talk with Pikachu, they join forces to unravel the tangled mystery.", MovieStatus.NOW_SHOWING));
		movieList.add(new Movie("Last Christmas", "Sypnosis: Nothing seems to go right for young Kate, a frustrated Londoner who works as an elf in a year-round Christmas shop. But things soon take a turn for the better when she meets Tom -- a handsome charmer who seems too good to be true. As the city transforms into the most wonderful time of the year, Tom and Kate's growing attraction turns into the best gift of all -- a Yuletide romance.", MovieStatus.COMING_SOON));
		movieList.add(new Movie("IT 2", "Sypnosis: Defeated by members of the Losers' Club, the evil clown Pennywise returns 27 years later to terrorize the town of Derry, Maine, once again. Now adults, the childhood friends have long since gone their separate ways. But when people start disappearing, Mike Hanlon calls the others home for one final stand. Damaged by scars from the past, the united Losers must conquer their deepest fears to destroy the shape-shifting Pennywise -- now more powerful than ever.", MovieStatus.END_OF_SHOWING));
	}
	
//	public MovieDatabase(){
//		this.movieList = new ArrayList<Movie>();
//	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void addMovieToDB(){
		Movie m = new Movie();
		this.movieList.add(m);
	}

	public void removeMovieFromDB(){
<<<<<<< HEAD
=======
		Scanner sc = new Scanner(System.in);
		System.out.println("Which movie do you want to remove?");
		int i=1;
		for (Movie movie : movieList) {
			System.out.println(i + ". " + movie.getMovieTitle());
			i++;
		}
		int choice = sc.nextInt();
>>>>>>> branch 'Master' of https://github.com/hengkaiz/moblima.git
		
		try {
			System.out.println("Which movie do you want to remove?");
			int i=1;
			for (Movie movie : movieList) {
				System.out.println(i + ". " + movie.getMovieTitle());
				i++;
			}
			int choice = sc.nextInt();
			
			movieList.remove(choice-1);
		} catch (Exception e) {
			
		}
	}
	
	
	
	public void printMovieDetails(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Which movie do you want to know more about?");
		int i=1;
		for (Movie movie : movieList) {
			System.out.println(i + ". " + movie.getMovieTitle());
			i++;
		}
		int choice = sc.nextInt();
		
		Movie chosenMovie = movieList.get(choice-1);
		
		System.out.println("Title: "		+ chosenMovie.getMovieTitle());
		System.out.println("Synopsis: "		+ chosenMovie.getMovieSynopsis());
		System.out.println("Cast: "			+ chosenMovie.toStringMovieCast());
		System.out.println("Director: "		+ chosenMovie.toStringMovieDirector());
		System.out.println("Status: "		+ chosenMovie.getStatus().getName());
		System.out.println("Total Sales: "	+ chosenMovie.getTotalSales());
		System.out.println("Age Rating: "	+ chosenMovie.getAgeRating().getName());
		System.out.print("Overall Rating: " );
		chosenMovie.printMovieOverallRating();
		System.out.println("Reviews: " );
		chosenMovie.printReviewList(3);
	}
	
	public ArrayList<String> getMovieTitlesList(){
		ArrayList <String> titlesOnly = new ArrayList<String>();
		
		for (Movie movie: movieList) {
			if(movie.getStatus().getName().contentEquals("Now Showing") || movie.getStatus().getName().contentEquals("Preview")) {
				titlesOnly.add(movie.getMovieTitle());
			}
		}
		return titlesOnly;
	}

	public ArrayList<Movie> getMovies(){
		return movieList;
	}
	
	public void printTop5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Print top 5 movies by?");
		System.out.println("1. By Overall Rating");
		System.out.println("2. By Ticket Sales");
		int choice = sc.nextInt();
		if (movieList.isEmpty()) {
			System.out.println("There are no movies in the system yet.");
			return;
		}
		
		if (choice==1) {
			int i=1;
			for (Movie movie : topByOverallRating(5)) {
				System.out.println(i + ". " + movie.getMovieTitle());
				i++;
			}
		}
		
		else if (choice==2) {
			int i=1;
			for (Movie movie : topByTotalSales(5)) {
				System.out.println(i + ". " + movie.getMovieTitle());
				i++;
			}
		}
	}
	
	public List<Movie> topByOverallRating(int num){
		movieList.sort(new OverallRatingSorter());
		if (num>movieList.size())
			return movieList.subList(0, movieList.size());
		else
			return movieList.subList(0, num);
	}
	
	public List<Movie> topByTotalSales(int num){
		movieList.sort(new TotalSalesSorter());
		if (num>movieList.size())
			return movieList.subList(0, movieList.size());
		else
			return movieList.subList(0, num);
	}
	//comment
	
//	public static void main(String[] args) {
//		MovieDatabase mdb = new MovieDatabase();
//		mdb.printTop5();
//		mdb.printTop5();
//		mdb.addMovieToDB();
//		mdb.movieList.get(0).addReview();
//		mdb.movieList.get(0).addReview();
//		//mdb.movieList.get(0).addReview();
//		mdb.printMovieDetails();
//		System.out.println(mdb.getMovieTitlesList());
//		//mdb.printTop5();
//		//mdb.printTop5();
//		
//		mdb.addMovieToDB();
//		mdb.movieList.get(1).addReview();
//		mdb.movieList.get(1).addReview();
//		//mdb.movieList.get(1).addReview();
//		mdb.printMovieDetails();
//		System.out.println(mdb.getMovieTitlesList());
//		mdb.printTop5();
//		mdb.printTop5();
//		
//		mdb.addMovieToDB();
//		mdb.movieList.get(2).addReview();
//		mdb.movieList.get(2).addReview();
//		mdb.movieList.get(2).addReview();
//		mdb.printMovieDetails();
//		System.out.println(mdb.getMovieTitlesList());
//		
//		mdb.printTop5();
//		mdb.printTop5();
//	}
}