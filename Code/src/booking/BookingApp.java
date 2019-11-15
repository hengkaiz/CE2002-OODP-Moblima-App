package booking;

import cinema.ShowTime;
import moblima.SaveAndLoadDB;

import java.util.ArrayList;

public class BookingApp {
    private SaveAndLoadDB saveAndLoadDB;
    private BookingDatabase bdb;
    private String username;
    private ShowTime st;
    private int[] seat;
    private ArrayList<BookingDetails>  bookinglist;

    public BookingApp(String username, ShowTime st,int[] seat){
        bdb = saveAndLoadDB.loadBookingDB();
        this.username = username;
        this.st = st;
        this.seat = seat;
    }

    public void getBooking(){
        bookinglist = bdb.getBookingDetails(username, st, seat);

        for (int i = 0; i < bookinglist.size(); i++) {
            System.out.println("Hello " + username + ", here are your current bookings.");
            System.out.println(bookinglist.get(i).getCineplexNum() + " - " + bookinglist.get(i).getCinemaNum());
            System.out.println("Movie: " + bookinglist.get(i).getShowtime().getMovie());
            System.out.println("Showtime: " + bookinglist.get(i).getShowtime().getTiming());
            System.out.println("Seats chosen: " + bookinglist.get(i).getSeat()+ "\n");
        }
    }
}
