package admin;

import java.util.ArrayList;
import moblima.SaveAndLoadDB;

public class AdminLoginApp {
	private AdminDatabase adb;
	private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
	
	public AdminLoginApp() {
		this.adb = saveAndLoadDB.loadAdminDB();
	}

	public boolean loginCheck(String id, String password) {
		ArrayList<AdminAccount> adminList = adb.getAdminList();
		for(AdminAccount admin : adminList) {
			if(id.equals(admin.getID()) && password.equals(admin.getPassword())){ 
				//account exists
				return true;
			}
		}
		//account does not exist
		return false;
	}	
}
