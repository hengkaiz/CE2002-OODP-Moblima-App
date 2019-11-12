package admin;

import java.util.ArrayList;
public class AdminDatabase {
	
	private ArrayList<AdminAccount> adminList;
	public AdminDatabase() {
		// TODO Auto-generated construcator stub
		this.adminList = new ArrayList<AdminAccount>();
	}
	public void addAdmin(AdminAccount admin) {
		adminList.add(admin);
	}
	public void removeAdmin(AdminAccount admin) {
		if(adminList.remove(admin)) {
			System.out.println("removed");
		}
		else {
			System.out.println("Admin account does not exist");
		}
	}
	public ArrayList<AdminAccount> getAdminList(){
		return this.adminList;
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
