package booking;

import moblima.MenuTemplate;
import user.*;
import cinema.*;

import java.util.Scanner;

public class BookingMenu extends MenuTemplate {
    private MenuTemplate nextMenu;

    public BookingMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }

    public MenuTemplate run(){
        //your booking code here
        Scanner sc = new Scanner(System.in);
        int sel = 0;

        System.out.print("\n");
        if(super.getCineplexNum() == 1) System.out.print("---Jurong Point");
        else if (super.getCineplexNum() == 2) System.out.print("---Bishan");
        else System.out.print("---Nex");
        System.out.printf(" Booking Menu---\n");
        System.out.println("1. Get booking details");
        System.out.println("2. Search for movies and book");
        System.out.println("3. Return");
        System.out.print("Please enter your choice: ");

        try {
        	sel = sc.nextInt();
        	if (sel < 0 || sel > 3) {
        		throw new Exception();
        	}
        } catch (Exception e) {
        	System.out.println("Selection Invalid. Try Again.");
        }
        
        System.out.println();
        sc.nextLine(); //clear the buffer

        BookingApp bookingApp = new BookingApp(super.getUsername());

        nextMenu = this;
        switch (sel) {
        case 1: //get booking details
        	bookingApp.getBooking();
        	break;

        case 2: //add new booking
        	nextMenu = new UserSearchMenu(this);
        	break;

        case 3: //return
            super.returnPrevious();
        }
        nextMenu.setCineplexNum(super.getCineplexNum());
        nextMenu.setUsername(super.getUsername());
        return nextMenu.run();
    }
}
