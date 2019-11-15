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
        
        System.out.println("---Booking Menu---");
        System.out.println("1. Get booking details");
        System.out.println("2. Add new booking");
        System.out.println("3. Return");
        System.out.println("Please enter your choice: ");
        boolean loop = true;
        do {
        try {
        	sel = sc.nextInt();
        	if (sel < 0 || sel > 3) {
        		throw new Exception();
        	}
        	loop = false;
        } catch (Exception e) {
        	System.out.println("Selection Invalid. Try Again.");
        }
        } while (loop);
        
        System.out.println();
        sc.nextLine(); //clear the buffer
        
        BookingDatabase bdb = new BookingDatabase();
        nextMenu = this;
        
        switch (sel) {
        case 1: //get booking details
        	
        	
        case 2: //add new booking
        	
        }

        nextMenu = this;

        return nextMenu.run();
    }
}
