package Moblima;
import Booking.Booking;
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
        String username = "";
        ShowTime copyOfSelShowTime = null;

        // importing the different database
        DataBase db = new DataBase();
        UserDatabase udb = new UserDatabase();
        MovieDatabase mdb = new MovieDatabase();
        BookingDatabase bdb = new BookingDatabase();

        //initializing all the classes
        UserLoginApp userLoginApp = new UserLoginApp();
        UserSearchApp userSearchApp = new UserSearchApp();

        int page_choice = 0;
        //select what type of login
        while(!exit) {
            switch(page_choice) {
                case 0: //main page
                    System.out.println("---MOBLMIA BOYS---");
                    System.out.println("1. User");
                    System.out.println("2. Admin");
                    System.out.println("3. Exit");
                    System.out.print("Please enter your choice: ");
                    sel = sc.nextInt();
                    if (sel == 1) page_choice = 1; //use login page
                    else if (sel == 2) page_choice = 5; //admin login page
                    else exit = true;
                    System.out.println();
                    sc.nextLine(); //clear the buffer
                    break;

                case 1: //user login page
                    username = userLoginApp.UserLogin(); //login/create acc
                    if (username.contentEquals("")) page_choice = 0; //back to main page
                    else page_choice = 2; //choose booking or book tix
                    break;

                case 2: //choose booking history or book tix
                    System.out.printf("---Welcome %s---\n", username);
                    System.out.println("1. Book movie tickets");
                    System.out.println("2. View booking history");
                    System.out.println("3. Logout");
                    System.out.print("Please enter your choice: ");
                    sel = sc.nextInt();
                    if (sel == 1) page_choice = 3; //search movie page
                    else if (sel == 2) page_choice = 10; //view booking tix page
                    else page_choice = 1; //back to user login page
                    System.out.println();
                    sc.nextLine(); //clear the buffer
                    break;

                case 3: //search showtime by movie or time and selecting the showtime
                    copyOfSelShowTime = userSearchApp.showtimelist(mdb);
                    if(copyOfSelShowTime != null) page_choice = 4;

                case 4:
                    //selecting the seat
                    int[] seat = new int[2];
                    ChooseSeats chooseSeats = new ChooseSeats(copyOfSelShowTime, db);
                    seat = chooseSeats.chooseSeats(username);

                    //add to booking database
                    bdb.addNewBooking(username, copyOfSelShowTime, seat[0], seat[1]);

                    break;
                case 5:
                    //admin login
                    break;
                case 6:
                    exit = true;
                    break;
            }
        }
    }
}
