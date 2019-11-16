package user;

import booking.BookingApp;
import booking.BookingMenu;
import cinema.ShowTime;
import moblima.MainMenu;
import moblima.MenuTemplate;
import movies.TicketPriceCalculator;

import java.awt.print.Book;
import java.util.Scanner;

public class UserChooseSeatsMenu extends MenuTemplate{
    private MenuTemplate nextMenu;
    private ShowTime selST;

    public UserChooseSeatsMenu(MenuTemplate previousMenu, ShowTime selST) {
        super(previousMenu);
        this.selST = selST;
    }

    public MenuTemplate run(){
        UserChooseSeatsApp userChooseSeatsApp = new UserChooseSeatsApp(selST, super.getCineplexNum());
        Scanner sc = new Scanner(System.in);
        int sel = 0;

        System.out.printf("\n---%s: %d---\n", selST.getMovie(), selST.getTiming());
        System.out.println("1. View movie details");
        System.out.println("2. View seats available");
        System.out.println("3. Book tickets");
        System.out.println("4. Return");
        System.out.print("Please enter your choice: ");

        try {
			sel = sc.nextInt();
			if (sel<0 || sel>3) {
				throw new Exception("Input only from 1-3");
			}
		} catch (Exception e) {
			System.out.println("Selection Invalid. Try Again.");
			run();
		}

        System.out.println();
        sc.nextLine(); //clear the buffer

        nextMenu = this;
        switch(sel){
            case 1: //view movie details
                System.out.printf("---%s---\n", selST.getMovie());
                System.out.println(selST.getMovieObject().getStatus().getName());
                System.out.println("Synopsis: "+selST.getMovieObject().getMovieSynopsis());
                System.out.println("Actors: "+selST.getMovieObject().toStringMovieCast());
                break;

            case 2: //get movie details
                userChooseSeatsApp.printSeats();
                break;

            case 3: //choose seats
                UserCheckAge userCheckAge = new UserCheckAge(selST, super.getUsername());
                if(!userCheckAge.checkAge()) super.returnPrevious();
                System.out.print("How many seats would you like to book? ");
                try {
                    sel = sc.nextInt();
                    if (sel<0 || sel>5) {
                        throw new Exception("Input only from 1-5");
                    }
                } catch (Exception e) {
                    System.out.println("Selection Invalid. Try Again.");
                    run();
                }
                for(int i=0;i<sel;i++) {
                    int[] seat = userChooseSeatsApp.chooseSeats(super.getUsername());
                    run();
                }
                System.out.println("Thanks for booking!");
                nextMenu = new UserSearchMenu(new MainMenu());
                break;

            case 4:
                super.returnPrevious();
        }
        nextMenu.setCineplexNum(super.getCineplexNum());
        nextMenu.setUsername(super.getUsername());
        return nextMenu.run();
    }
}
