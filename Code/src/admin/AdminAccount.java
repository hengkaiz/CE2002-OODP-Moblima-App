package admin;

import java.io.Serializable;
import java.util.ArrayList;

public class AdminAccount implements Serializable {
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
	    return id == acc.getID() && password == acc.getPassword();
    }*/

}
