package user;


import moblima.SaveAndLoadDB;

import java.util.Scanner;

public class UserLoginApp{
	private User login_user;
    private UserDatabase udb;
    private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();

    public UserLoginApp(){
        this.udb = saveAndLoadDB.loadUserDB();
    }
	//checking username and password entered
	public String loginCheck(String ID, String password){
		login_user = udb.searchByName(ID);

		if(login_user == null)return"";

		if (!login_user.getPassword().contentEquals(password)){
			return "";
		}
		return ID;
	}

	//check if created ID already exist in database
    public boolean checkID(String dID){
	    return udb.checkExistingID(dID);
    }

    //add account into database
    public String addUser(String dID, String password){
        udb.addUser(dID, password);
        saveAndLoadDB.saveUserDB(udb);
        return dID;
    }
}
