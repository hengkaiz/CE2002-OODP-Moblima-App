package admin;

import java.util.ArrayList;
import admin.AdminDatabase;
import java.util.Scanner;
import java.lang.Object;

public class AdminLogin {

	//private AdminAccount temp;
	
	
	
    /*public boolean equals(Object obj) { 
  	    // checking if both the object references are  
	    // referring to the same object. 
	    if(this == obj) 
	    	return true;
          
        // it checks if the argument is of the  
        // type Geek by comparing the classes  
        // of the passed argument and this object. 
        // if(!(obj instanceof Geek)) return false; ---> avoid. 
	    if(obj == null || obj.getClass()!= this.getClass()) 
            return false;
	    AdminAccount acc = (AdminAccount) obj;
	    return 
    }
    
	public boolean checkDatabase(AdminAccount temp, AdminDatabase db) {
		ArrayList<AdminAccount> adminList = db.getAdminList();
		for(int i=0; i < adminList.size(); i++) {
			System.out.println(adminList.get(i).getID());
			/*if(temp.equals(adminList.get(i))) {
				return true;
			}*/
			/*if((temp.getID()).equals(adminList.get(i).getID()) && (temp.getPassword()).equals(adminList.get(i).getPassword())){ 
				//account exists
				return true;
			}*/
		/*}
		//account does not exist
		return false;
	}*/
	public boolean checkDatabase(AdminAccount temp, AdminDatabase db) {
		ArrayList<AdminAccount> adminList = db.getAdminList();
		for(int i=0; i < adminList.size(); i++) {
			/*if(temp.equals(adminList.get(i))) {
				return true;
			}*/
			if((temp.getID()).equals(adminList.get(i).getID()) && (temp.getPassword()).equals(adminList.get(i).getPassword())){ 
				//account exists
				return true;
			}
		}
		//account does not exist
		return false;
	}

	public boolean login(AdminDatabase db) {
		//AdminDatabase db = new AdminDatabase();
		Scanner sc = new Scanner(System.in);
		AdminAccount temp = new AdminAccount();
		System.out.println("enter id");
		String ID = sc.nextLine();
		System.out.println("enter password");
		String Password = sc.nextLine();
		temp.setID(ID);
		temp.setPassword(Password);
		return (checkDatabase(temp, db));
	}

	
}
