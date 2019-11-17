package user;

import moblima.MenuTemplate;

import java.util.Scanner;
/**
 * a menu that lets user choose enter login information
 */
public class UserLoginMenu extends MenuTemplate {
    /**
     * the next menu to run
     */
    private MenuTemplate nextMenu;
    /**
     * menu constructor
     * @param previousMenu points to the previous menu
     */
    public UserLoginMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }
    /**
     * gets user's username and password
     * the next menu will be run based on user input
     */
    public MenuTemplate run(){
        Scanner sc = new Scanner(System.in);
        UserLoginApp userLoginApp = new UserLoginApp();
        String ID = null;
        String Password = null;
        String username;


        System.out.print("\nEnter ID: ");
        ID = sc.nextLine();

        System.out.print("Enter password: ");
        Password = sc.nextLine();

        nextMenu = this;

        username = userLoginApp.loginCheck(ID, Password);
        if(username.contentEquals("")) {
            System.out.println("\nInvalid ID/Password!");
            super.returnPrevious();
        }
        //login successful
        super.setUsername(username);
        System.out.println("Welcome, " + ID + "\n");
        nextMenu = new UserCineplexMenu(super.previousMenu);

        nextMenu.setCineplexNum(super.getCineplexNum());
        nextMenu.setUsername(super.getUsername());
        return nextMenu.run();
    }
}
