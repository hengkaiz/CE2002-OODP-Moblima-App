package admin;

import java.util.ArrayList;

public class AdminAccount {
	private String id;
	private String password;
	
	public AdminAccount() {
		id = null;
		password = null;
	}
	public AdminAccount(String id, String password) {
		this.id = id;
		this.password = password;
	}
	public String getID() {
		return this.id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
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
