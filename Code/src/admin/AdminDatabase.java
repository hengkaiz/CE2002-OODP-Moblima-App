package admin;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A database that records all admin accounts.
 *
 */
public class AdminDatabase implements Serializable{

	/**
	 * To identify the version of the class used in Serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ArrayList adminList that stores all AdminAccounts in the database.
	 */
	//private static ArrayList<AdminAccount> adminList;
	private ArrayList<AdminAccount> adminList = new ArrayList<AdminAccount>();
	
	/**
	 * Constructs AdminDatabase object.
	 */
	public AdminDatabase() {
		/*AdminAccount acc = new AdminAccount("hope", "070999");
		adminList.add(acc);
		AdminAccount acc1 = new AdminAccount("jordan", "180998");
		adminList.add(acc1);
		AdminAccount acc2 = new AdminAccount("xm", "141099");
		adminList.add(acc2);
		System.out.println(adminList);*/
	}
	
	/**
	 * Add an AdminAccount to the ArrayList
	 * @param admin AdminAccount to be added to the database
	 */
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
