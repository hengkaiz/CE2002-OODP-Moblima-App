package moblima;
/**
 * 
 *represents the main application to run MOBLIMA
 */
public class MainApp {
	/**
	 * main method
	 * @param args
	 */
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