package admin;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents an Admin Account registered in the system.
 */
public class AdminAccount implements Serializable {

	/**
	 * To identify the version of the class used in Serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The ID of this Admin Account.
	 */
	private String id;
	
	/**
	 * The password of this Admin Account.
	 */
	private String password;
	
	/**
	 * Constructs a new AdminAccount object for the AdminAccount class.
	 */
	public AdminAccount() {
		id = null;
		password = null;
	}
	
	/**
	 * Constructs a new AdminAccount object for the AdminAccount, with the given ID and given password.
	 * @param id Input for the ID for this Admin Account
	 * @param password Input for the password for this Admin Account
	 */
	public AdminAccount(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	/**
	 * 
	 * @return current id of this AdminAccount.
	 */
	public String getID() {
		return this.id;
	}
	
	/**
	 * 
	 * @param id Set ID of this AdminAccount.
	 */
	public void setID(String id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return current password of this AdminAccount.
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * 
	 * @param password Set password of this AdminAccount
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
