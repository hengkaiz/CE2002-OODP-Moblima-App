package admin;

import java.util.ArrayList;
import java.util.Scanner;
import Database.*;

public class AdminApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDatabase db = new AdminDatabase();
		Scanner sc = new Scanner(System.in);

		AdminLogin temp = new AdminLogin(ID, Password);
		boolean result = temp.checkDatabase(db);
		if(result) {
			
			System.out.println("What would you like to do?");
			System.out.println("1. Edit Showtimes");
			System.out.println("2. Edit Movies");
			System.out.println("3. Configure system settings");
			System.out.println("4. List Top 5");
			
			
			
			
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
	}

}
