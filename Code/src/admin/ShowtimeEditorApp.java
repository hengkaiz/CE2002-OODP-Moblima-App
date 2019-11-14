package admin;

import java.util.Scanner;
import java.lang.Object;

public class ShowtimeEditorApp {

	/*public ShowtimeEditorApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	Scanner sc = new Scanner(System.in);
	
	public void edit(CinemaShowtimesAndMovieEditor csme) {
		//CinemaShowtimesAndMovieEditor csme = new CinemaShowtimesAndMovieEditor();
		int editChoice = 0;
		do {
			System.out.println("1. Create");
			System.out.println("2. Update");
			System.out.println("3. Remove");
			System.out.println("4. Exit");
			editChoice = sc.nextInt();
			switch(editChoice) {
			case 1: //create ST
				csme.createCinemaShowtimesAndMovie();
				break;
			case 2: //update ST
				csme.updateCinemaShowtimesAndMovie();
				break;
			case 3: //remove ST
				csme.removeCinemaShowtimesAndMovie();
				break;
			case 4: //exit
				break;
			default:
				break;
			}
		}while(editChoice != 4);

		
	}
}
