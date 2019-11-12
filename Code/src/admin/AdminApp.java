package admin;

import java.util.ArrayList;
import java.util.Scanner;
import Database.*;

public class AdminApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDatabase db = new AdminDatabase();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id");
		String ID = sc.nextLine();
		System.out.println("enter password");
		String Password = sc.nextLine();
		AdminLogin temp = new AdminLogin(ID, Password);
		boolean result = temp.checkDatabase(db);
		if(result) {
			AdminAccount hk = new AdminAccount("hk", "002");
			db.addAdmin(hk);
			ArrayList<AdminAccount> list = db.getAdminList();
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).getID());
				System.out.println(list.get(i).getPassword());
			}
		}
	}

}
