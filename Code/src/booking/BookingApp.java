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

        for (int i = 0; i < bookinglist.size(); i++) {
            System.out.println("Hello " + username + ", here are your current bookings.");
            System.out.println(bookinglist.get(i).getCineplexName() + " - " + bookinglist.get(i).getCinemaNum());
            System.out.println("Movie: " + bookinglist.get(i).getMovieTitle());
            System.out.println("Showtime: " + bookinglist.get(i).getShowTime());
            System.out.println("Seats chosen: " + bookinglist.get(i).getSeat()+ "\n");
        }
    }

    public void addBooking(int cineplexNum, ShowTime st,int[] seat){
        this.st = st;
        this.seat = seat;
        this.cinplexNum = cineplexNum;
        Scanner sc = new Scanner(System.in);
        HolidayDatabase hdb = saveAndLoadDB.loadHolidayDB();
        TicketPriceCalculator ticketPriceCalculator = new TicketPriceCalculator();
        UserDatabase udb = saveAndLoadDB.loadUserDB();
        User user = null;

        for(User u: udb.getUserList()){
            if(u.getUsername().contentEquals(username)) {
                user = u;
                break;
            }
        }

        double price = ticketPriceCalculator.calculatePrice(user, st, hdb);

        System.out.println("---Booking Confirmation---");
        System.out.println(st.getMovie());
        System.out.println(st.getTiming());
        System.out.println("Cinema " + st.getCinemaNum());
        System.out.println("\nPrice: "+ price);

        System.out.println("Confirm purchase? (y/n)");
        Character choice = sc.nextLine().charAt(0);
        if(!choice.equals("y")) return;

        bdb.addNewBooking(username, cineplexNum, st, seat, price);
        saveAndLoadDB.saveBookingDB(bdb);
    }
}
