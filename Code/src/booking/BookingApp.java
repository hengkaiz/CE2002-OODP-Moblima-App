package booking;

import cinema.ShowTime;
import moblima.SaveAndLoadDB;
import movies.HolidayDatabase;
import movies.TicketPriceCalculator;
import user.User;
import user.UserDatabase;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingApp {
    private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
    private BookingDatabase bdb;
    private String username;
    private ShowTime st;
    private int[] seat;
    private int cinplexNum;

    private ArrayList<BookingDetails>  bookinglist;

    public BookingApp(String username){
        bdb = saveAndLoadDB.loadBookingDB();
        this.username = username;
    }

    public void getBooking(){
        bookinglist = bdb.getBookingDetails(username);

        if (bookinglist == null) return;
        for (int i = 0; i < bookinglist.size(); i++) {
            System.out.println("Hello " + username + ", here are your bookings:");
            System.out.println(bookinglist.get(i).getCineplexName() + " - Cinema " + bookinglist.get(i).getCinemaNum());
            System.out.println("Movie: " + bookinglist.get(i).getMovieTitle());
            System.out.println("Showtime: " + bookinglist.get(i).getShowTime());
            System.out.println("Seats chosen: " + (char)(bookinglist.get(i).getSeat()[0] + 97) + bookinglist.get(i).getSeat()[1]);
            System.out.println("Transaction ID: " + bookinglist.get(i).getTID() + "\n");
        }
    }

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
        System.out.print(" Cineplex - Cinema " + st.getCinemaNum());
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
