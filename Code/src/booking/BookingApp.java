package booking;

import cinema.ShowTime;
import moblima.SaveAndLoadDB;
import movies.HolidayDatabase;
import movies.TicketPriceCalculator;
import user.User;
import user.UserDatabase;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * represents the booking application used when booking a movie
 *
 */
public class BookingApp {
	/**
	 * instantiates the saveAndLoadDB object. Allows saving and loading of the actual database to and from a local copy
	 */
    private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
    /**
     * the database for booking
     */
    private BookingDatabase bdb;
    /**
     * the username of users
     */
    private String username;
    /**
     * the showtime 
     */
    private ShowTime st;

    /**
     * array that represents seats
     */
    private int[] seat;
    /**
     * the cineplex's number
     */
    private int cinplexNum;
    
    /**
     * a list of bookings and details
     */
    private ArrayList<BookingDetails>  bookinglist;
    
    /**
     * booking app that retrieves that booking database 
     * Allows saving and loading of the actual database to and from a local copy
     * @param username input for user's username
     */
    public BookingApp(String username){
        bdb = saveAndLoadDB.loadBookingDB();
        this.username = username;
    }
    
    /**
     * retrieves booking details from the booking database and prints out the booking history 
     */
    public void getBooking(){
        bookinglist = bdb.getBookingDetails(username);

        if (bookinglist == null) return;
        System.out.printf("\n---%s booking history---\n", username);
        for (int i = 0; i < bookinglist.size(); i++) {
            System.out.println("Booking " + (i+1));
            System.out.println(bookinglist.get(i).getCineplexName() + " - Cinema " + bookinglist.get(i).getCinemaNum());
            System.out.println("Movie: " + bookinglist.get(i).getMovieTitle());
            System.out.println("Showtime: " + bookinglist.get(i).getDate() + " - " + bookinglist.get(i).getShowTime());
            System.out.println("Seats chosen: " + (char)(bookinglist.get(i).getSeat()[0] + 65) + bookinglist.get(i).getSeat()[1]);
            System.out.println("Transaction ID: " + bookinglist.get(i).getTID() + "\n");
        }
    }
    
    /**
     * searches username against user database, calculates ticket prices adds a booking to the booking database, using cineplex number, showtime and seats selected as its parameters
     * prints out booking details
     * @param cineplexNum input for the cineplex's number
     * @param st input for the showtime
     * @param seat input for the seat selected
     */
    public void addBooking(int cineplexNum, ShowTime st,int[] seat){
        this.st = st;
        this.seat = seat;
        this.cinplexNum = cineplexNum;
        Scanner sc = new Scanner(System.in);
        HolidayDatabase hdb = saveAndLoadDB.loadHolidayDB();
        TicketPriceCalculator ticketPriceCalculator = saveAndLoadDB.loadTicketPrice();
        UserDatabase udb = saveAndLoadDB.loadUserDB();
        User user = null;

        for(User u: udb.getUserList()){
            if(u.getUsername().contentEquals(username)) {
                user = u;
                break;
            }
        }

        double price = ticketPriceCalculator.calculatePrice(user, st, hdb);

        System.out.println("\n---Booking Confirmation---");
        System.out.println(st.getMovie());
        System.out.println(st.getTiming());
        if(cineplexNum == 0) System.out.print("Jurong Point");
        else if (cineplexNum == 1) System.out.print("Bishan");
        else System.out.print("Nex");
        System.out.println(" Cineplex - Cinema " + st.getCinemaNum() + " - " + st.getCinemaType());
        System.out.printf("\nSeat: %s%d\n", (char)(seat[0]+65), seat[1]);
        System.out.println("Price: "+ price);

        System.out.print("Confirm purchase? (y/n): ");
        Character choice = sc.nextLine().charAt(0);
        if(choice.equals('y')) {
            System.out.print("Booking confirmed!");
            bdb.addNewBooking(username, cineplexNum, st, seat, price);
            saveAndLoadDB.saveBookingDB(bdb);
        }
    }
}
