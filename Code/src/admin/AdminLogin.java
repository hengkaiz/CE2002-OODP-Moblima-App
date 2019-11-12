package admin;

import java.util.ArrayList;
public class AdminLogin extends AdminAccount {
	// temp class as a pseudo admin account to check against the admin database

	/*public AdminLogin() {
		super();
	}
	public AdminLogin(String id, String password) {
		super(id,password);
	}*/
	public boolean checkDatabase(AdminAccount temp) {
		AdminDatabase admindatabase = new AdminDatabase();
		for(int i=0; i < admindatabase.size(); i++) {
			if(temp.getID() == admindatabase.getAdminList()[i].getID() && temp.getPassword() == admindatabase.getAdminList().getPassword()){ 
				//account exists
				return true;
			}
		}
		//account does not exist
		return false;
	}
}
