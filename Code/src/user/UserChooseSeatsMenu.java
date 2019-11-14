package user;

import cinema.ShowTime;
import moblima.MainMenu;
import moblima.MenuTemplate;
import movies.TicketPriceCalculator;

import java.util.Scanner;

public class UserChooseSeatsMenu extends MenuTemplate{
    private MenuTemplate nextMenu;
    private ShowTime selST;

    public UserChooseSeatsMenu(MenuTemplate previousMenu, ShowTime selST) {
        super(previousMenu);
        this.selST = selST;
    }

    public MenuTemplate run(){
        UserChooseSeatsApp userChooseSeatsApp = new UserChooseSeatsApp(selST);
        Scanner sc = new Scanner(System.in);
        int sel;

        System.out.printf("---%s---\n", selST.getMovie());
        System.out.println("1. View seats available");
        System.out.println("2. Book tickets");
        System.out.println("3. Return");
        System.out.print("Please enter your choice: ");
        sel = sc.nextInt();
        System.out.println();
        sc.nextLine(); //clear the buffer

        nextMenu = this;
        switch(sel){
            case 1: //get movie details
                userChooseSeatsApp.printSeats();
                nextMenu = new MainMenu();
                break;

            case 2: //choose seats
                TicketPriceCalculator tpc = new TicketPriceCalculator();
                int[] seat = userChooseSeatsApp.chooseSeats(super.getUsername());
                System.out.println("Ticket Booked!");
                nextMenu = new MainMenu();
                break;

            case 3:
                super.returnPrevious();
        }


        return nextMenu.run();
    }
}
