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
	 * Constructs AdminLoginApp.
	 * Relevant databases are loaded and stored in a local copy for method use.
	 * Relevant databases needed: Admin Database (adb)
	 */
	public AdminLoginApp() {
		this.adb = saveAndLoadDB.loadAdminDB();
	}

	/**
	 * Checks if input id and password matches an admin account in the admin database 
	 * @param id Input id from admin
	 * @param password Input password from admin
	 * @return If admin account match found, method returns true. If no match found, return false.
	 */
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
