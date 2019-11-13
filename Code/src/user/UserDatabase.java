package user;

import java.util.ArrayList;

public class UserDatabase{
    private ArrayList<User> userlist = new ArrayList<User>();
    private ArrayList<User> copylist;

    public UserDatabase(){}

    private User sortNames(String name){
        for (User user: userlist){
            if (user.getUsername() == name){
                break;
            }
        }
        return user;
    }

    public User searchByName(String name){ //search username
        return sortNames(name);
    }
    
    public boolean checkExistingID(String name) {
    	for (User user: userlist){
            if (user.getUsername() == name){
                return false;
            }
        }
        return true;
    }

}
