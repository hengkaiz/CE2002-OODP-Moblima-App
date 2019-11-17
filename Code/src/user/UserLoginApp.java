package user;


import moblima.SaveAndLoadDB;

import java.util.Scanner;
/**
 * check user login details and create new account
 */
public class UserLoginApp{
    /**
     * User object of logged in user
     */
	private User login_user;
    /**
     * User's database
     */
    private UserDatabase udb;
    /**
     *  Allows saving and loading of the actual database to and from a local copy
     */
    private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
    /**
     * UserLoginApp constructor
     */
    public UserLoginApp(){
        this.udb = saveAndLoadDB.loadUserDB();
    }
    /**
     * check login username and password
     * @return the username is able to login, returns "" otherwise
     */
	//checking username and password entered
	public String loginCheck(String ID, String password){
		login_user = udb.searchByName(ID);

		if(login_user == null)return"";

		if (!login_user.getPassword().contentEquals(password)){
			return "";
		}
		return ID;
	}
    /**
     * check if created ID already exist in the database
     * @return false if it exist, true otherwise
     */
	//check if created ID already exist in database
    public boolean checkID(String dID){
	    return udb.checkExistingID(dID);
    }
    /**
     * add account into database
     * @param dID is the entered username
     * @param password is the entered password
     * @return dID if account is successfully created, "" otherwise
     */
    //add account into database
    public String addUser(String dID, String password){
        udb.addUser(dID, password);
        saveAndLoadDB.saveUserDB(udb);
        return dID;
    }
}
