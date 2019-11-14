package movies;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDatabase {
	private ArrayList<Movie> movieList;
	
	Scanner sc = new Scanner(System.in);
	
	public MovieDatabase(){
		this.movieList = new ArrayList<Movie>();
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void addMovieToDB(){
		Movie m = new Movie();
		this.movieList.add(m);
	}

	public void removeMovieFromDB(){
		System.out.println("Which movie do you want to remove?");
		int i=1;
		for (Movie movie : movieList) {
			System.out.println(i + ". " + movie.getMovieTitle());
			i++;
		}
		int choice = sc.nextInt();
		
		movieList.remove(choice-1);
	}
	
	
	
	public void printMovieDetails(){
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
