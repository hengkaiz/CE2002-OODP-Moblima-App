package Moblima;
import Booking.BookingDatabase;
import Database.*;
import movies.*;
import user.*;
import Cinema.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sel;
        boolean exit = false;

        // importing the different database
        DataBase db = new DataBase();
        UserDatabase udb = new UserDatabase();
        MovieDatabase mdb = new MovieDatabase();
        BookingDatabase bdb = new BookingDatabase();

        //select what type of login
        while(!exit) {
            System.out.println("---MOBLMIA BOYS---");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice: ");
            sel = sc.nextInt();
            System.out.println();
            sc.nextLine(); //clear the buffer

            switch (sel) {
                case 1: //use app
                    //user login
                    UserLoginApp userLoginApp = new UserLoginApp();
                    String username = userLoginApp.UserLogin(); //login/create acc
                    if(username.contentEquals(""))break;

                    //search showtime by movie or time and selecting the showtime
                    UserSearchApp userSearchApp = new UserSearchApp();
                    ShowTime copyOfSelShowTime;
                    copyOfSelShowTime = userSearchApp.showtimelist(mdb);

                    //selecting the seat
                    int [] seat = new int[2];
                    ChooseSeats chooseSeats = new ChooseSeats(copyOfSelShowTime);
                    seat = chooseSeats.chooseSeats(username);

                    //add to booking database
                    bdb.addNewBooking(username, copyOfSelShowTime, seat[0], seat[1]);

                    break;
                case 2:
                    //admin login
                    break;
                case 3:
                    exit = true;
                    break;
            }
        }
    }
}
