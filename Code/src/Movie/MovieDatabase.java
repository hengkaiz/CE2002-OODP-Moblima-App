package Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieDatabase {
    private ArrayList<Movie> movielist;

    public MovieDatabase(){
        movielist = new ArrayList<Movie>();
    }

    public void addMovie(){
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        String type = sc.nextLine();
        String status = sc.nextLine();
        String agelimit = sc.nextLine();
        int runtime = sc.nextInt();
        movielist.add(new Movie(title, type, status, agelimit, runtime));
    }


}
