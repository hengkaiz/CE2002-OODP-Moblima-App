package admin;

import java.util.Scanner;
import cinema.*;
import movies.*;
import java.lang.Object;

public class AdminApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDatabase db = new AdminDatabase();
		AdminLogin adminLogin = new AdminLogin();
		CinemaShowtimesAndMovieEditor csme = new CinemaShowtimesAndMovieEditor();
		MovieListingEditor mle = new MovieListingEditor();
		ConfigureSystemSettings css = new ConfigureSystemSettings();
		SystemSettings ss = new SystemSettings();
		ShowtimeEditorApp stEdit = new ShowtimeEditorApp();
		MovieEditorApp mEdit = new MovieEditorApp();
		ConfigureApp cssApp = new ConfigureApp();
		TicketPriceCalculator tcc = new TicketPriceCalculator();
		HolidayDatabase hdb = new HolidayDatabase();
		MovieDatabase mdb = new MovieDatabase();
		
		Scanner sc = new Scanner(System.in);

		boolean result = adminLogin.login(db);
		if(result) {
			int adminChoice=0;
			do {
				System.out.println("What would you like to do?");
				System.out.println("1. Edit Showtimes");
				System.out.println("2. Edit Movies");
				System.out.println("3. Configure system settings");
				System.out.println("4. List Top 5");
				System.out.println("5. Exit");
				adminChoice = sc.nextInt();
				switch(adminChoice) {
				case 1: //edit showtimes
					stEdit.edit(csme);
					break;
				case 2: //edit movies
					mEdit.edit(mle);
					break;
				case 3: //configure system settings
					cssApp.configure(css,tcc,hdb,ss);
					break;
				case 4: //list top 5s
					mdb.printTop5();
					break;
				case 5: //exit
					break;
				default:
					break;
				}
			
			}while(adminChoice != 5);

		}
		else {
			System.out.println("BOOO GET OUT of the admin you nonadmin");
		}
	}
	/*AdminAccount hk = new AdminAccount("hk", "002");
	db.addAdmin(hk);
	ArrayList<AdminAccount> list = db.getAdminList();
	for(int i=0; i<list.size(); i++) {
		System.out.println(list.get(i).getID());
		System.out.println(list.get(i).getPassword());
	}
	System.out.println("enter new password");
	hk.setPassword(sc.nextLine());
	System.out.println(hk.getPassword());*/

}
