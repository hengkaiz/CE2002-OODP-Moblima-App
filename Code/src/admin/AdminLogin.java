package admin;

public class AdminLogin extends AdminAccount {
	// temp class as a pseudo admin account to check against the admin database

	/*public AdminLogin() {
		super();
	}
	public AdminLogin(String id, String password) {
		super(id,password);
	}*/
	public boolean checkDatabase(AdminAccount temp) {
		for(int i=0; i < len(AdminDatabase.getAdmins()); i++) {
			if(temp.getID() == AdminDatabase.getAdmins()[i].getID() && temp.getPassword() == AdminDatabase.getAdmins().getPassword()){ 
				//account exists
				return true;
			}
		}
		//account does not exist
		return false;
	}
}
