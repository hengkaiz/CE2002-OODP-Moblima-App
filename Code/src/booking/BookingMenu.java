package booking;

import moblima.MenuTemplate;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookingMenu extends MenuTemplate {
    private MenuTemplate nextMenu;

    public BookingMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }

    public MenuTemplate run(){
        nextMenu = this;


        return nextMenu.run();
    }
}
