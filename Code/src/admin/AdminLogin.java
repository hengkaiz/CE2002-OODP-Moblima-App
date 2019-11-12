package admin;

import java.util.ArrayList;
import admin.AdminDatabase;
import java.util.Scanner;

public class AdminLogin extends AdminAccount {
	//pseudo admin account to check against the admin database
	public AdminLogin() {
		super();
	}
	public AdminLogin(String id, String password) {
		super(id,password);
	}
	public boolean checkDatabase(AdminDatabase db) {
		ArrayList<AdminAccount> adminList = db.getAdminList();
		for(int i=0; i < adminList.size(); i++) {
			
			if((this.getID()).equals(adminList.get(i).getID()) && (this.getPassword()).equals(adminList.get(i).getPassword())){ 
				//account exists
				return true;
			}
		}
		//account does not exist
		return false;
	}	
}
