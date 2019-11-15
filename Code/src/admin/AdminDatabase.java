package admin;

import java.io.Serializable;
import java.util.ArrayList;
public class AdminDatabase implements Serializable{
	
	//private static ArrayList<AdminAccount> adminList;
	private ArrayList<AdminAccount> adminList = new ArrayList<AdminAccount>();
	public AdminDatabase() {
		// TODO Auto-generated construcator stub
		//this.adminList = new ArrayList<AdminAccount>();
		AdminAccount acc = new AdminAccount("hope", "070999");
		adminList.add(acc);
		AdminAccount acc1 = new AdminAccount("jordan", "180998");
		adminList.add(acc1);
		AdminAccount acc2 = new AdminAccount("xm", "141099");
		adminList.add(acc2);
		System.out.println(adminList);
	}
	public void addAdmin(AdminAccount admin) {
		adminList.add(admin);
	}
	public void removeAdmin(AdminAccount admin) {
		if(adminList.remove(admin)) {
			admin = null;
			System.out.println("removed");
		}
		else {
			System.out.println("Admin account does not exist");
		}
	}
	public ArrayList<AdminAccount> getAdminList(){
		return this.adminList;
	}
}
