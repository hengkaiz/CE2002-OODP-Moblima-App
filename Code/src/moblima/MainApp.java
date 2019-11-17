package moblima;

public class MainApp {
    public static void main(String[] args){
        MainMenu mainMenu = new MainMenu();

        try {
        	mainMenu.run();
        }
        catch (Exception e) {
        	System.out.println("Moblima is currently down. Please try again later.");
        	return;
        }
        
    }
}