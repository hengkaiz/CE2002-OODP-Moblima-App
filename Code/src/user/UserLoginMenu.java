package user;

import moblima.MenuTemplate;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserLoginMenu extends MenuTemplate {
    private MenuTemplate nextMenu;

    public UserLoginMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }

    public MenuTemplate run(){
        Scanner sc = new Scanner(System.in);
        UserLoginApp userLoginApp = new UserLoginApp();
        String ID = null;
        String Password = null;
        boolean loop = true;
        while (loop)
	        try {
		        System.out.print("Enter ID: ");
		        ID = sc.nextLine();
		        
		        System.out.print("Enter password: ");
		        Password = sc.nextLine();
		        loop = false;
	        }
	        catch (InputMismatchException e) {
	        	System.out.println("Invalid ID/Password. Try Again");
	        }
        
        nextMenu = this;

        if (userLoginApp.loginCheck(ID, Password)) {
            System.out.println("Welcome, " + ID + "\n");
            //nextMenu =
        }

        return nextMenu.run();
    }
}
