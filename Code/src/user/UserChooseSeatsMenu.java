package user;

import booking.BookingApp;
import booking.BookingMenu;
import cinema.ShowTime;
import moblima.MainMenu;
import moblima.MenuTemplate;
import movies.TicketPriceCalculator;

import java.awt.print.Book;
import java.util.Scanner;
/**
 * a menu that lets user view movie details, view seats or book seats
 */
public class UserChooseSeatsMenu extends MenuTemplate{
    /**
     * the next menu to run
     */
    private MenuTemplate nextMenu;
    /**
     * selected showtime
     */
    private ShowTime selST;
    /**
     * menu constructor
     * @param previousMenu points to the previous menu
     * @param selST is the user's selected showtime
     */
    public UserChooseSeatsMenu(MenuTemplate previousMenu, ShowTime selST) {
        super(previousMenu);
        this.selST = selST;
    }
    /**
     * prints menu options and asks user to pick an option
     * the next menu will be run based on user input
     */
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
			if (sel<0 || sel>4) {
				throw new Exception("Input only from 1-4");
			}
		} catch (Exception e) {
			System.out.println("Selection Invalid. Try Again.");
		}

        System.out.println();
        sc.nextLine(); //clear the buffer

        nextMenu = this;
        switch(sel){
            case 1: //view movie details
                System.out.printf("---%s---\n", selST.getMovie());
                System.out.println(selST.getMovieObject().getStatus().getName());
                System.out.printf("%s - %s\n", selST.getCinemaType(), selST.getMovieFormat().getName());
                System.out.println("Synopsis: "+selST.getMovieObject().getMovieSynopsis());
                System.out.println("Actors: "+selST.getMovieObject().toStringMovieCast());
                System.out.println("Total Sales: "	+ selST.getMovieObject().getTotalSales());
        		System.out.println("Age Rating: "	+ selST.getMovieObject().getAgeRating().getName());
                System.out.printf("Overall rating: ");
                selST.getMovieObject().printMovieOverallRating();
                System.out.println("Reviews: ");
                selST.getMovieObject().printReviewList(5); //show 5 reviews
                break;

            case 2: //get movie details
                userChooseSeatsApp.printSeats();
                break;

            case 3: //choose seats
                BookingApp bookingApp = new BookingApp(super.getUsername());
                UserCheckAge userCheckAge = new UserCheckAge(selST, super.getUsername());
                if(!userCheckAge.checkAge()) super.returnPrevious();
                System.out.print("How many seats would you like to book? ");
                try {
                    sel = sc.nextInt();
                    if (sel<0 || sel>5) {
                        throw new Exception("Input only from 1-5!");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }
                int[] seat = null;
                for(int i=0;i<sel;i++) {
                	while(seat == null) {
                    	System.out.println("\n---Choose seat for ticket " + (i+1) + " ---");
                		seat = userChooseSeatsApp.chooseSeats(super.getUsername());
                    	if(seat!= null)bookingApp.addBooking(super.getCineplexNum(), selST, seat);
                	}
                    seat = null;
                }
                System.out.println("Thanks for booking!");
                nextMenu = new BookingMenu(new MainMenu());
                break;

            case 4:
                super.returnPrevious();
        }
        nextMenu.setCineplexNum(super.getCineplexNum());
        nextMenu.setUsername(super.getUsername());
        return nextMenu.run();
    }
}
