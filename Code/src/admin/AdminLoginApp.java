package admin;

import java.util.ArrayList;
import moblima.SaveAndLoadDB;

/**
 * Takes in id and password and checks against the admin database.
 */
public class AdminLoginApp {
	
	/**
	 * Object reference to store local copy of AdminDatabase.
	 */
	private AdminDatabase adb;
	
	/**
	 * Allows saving and loading of the actual database to and from a local copy.
	 */
	private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
	
	/**
	 * 
	 */
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
