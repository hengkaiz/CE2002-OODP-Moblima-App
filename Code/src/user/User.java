package user;

import java.io.Serializable;
/**
 * represents the User
 *
 */
public class User implements Serializable{
	/**
	 * To identify the version of the class used in Serialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * the user's username
	 */
	private String username;
	/**
	 * the user's password
	 */
	private String password;
	/**
	 * the user's full name
	 */
	private String name;
	/**
	 * the user's email
	 */
	private String email;
	/**
	 * the user's mobile number
	 */
	private int mobile;
	/**
	 * the user's age
	 */
	private int age;

	/**
	 * This construct a user object for user class, using the following as parameters.
	 * @param username input for the user's username
	 * @param password input for user's password
	 * @param name input for user's full name
	 * @param age input for the user's age
	 * @param email input for the user's email
	 * @param mobile input for the user's mobile number
	 * @param age input for the user's age
	 */
	public User(String username, String password, String name, int age, String email, int mobile){
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
	}

	//User(){};

	/**
	 *
	 * @return user's age
	 */
	public int getAge() {
		return age;
	}
	/**
	 *
	 * @param age set user's age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 *
	 * @return user's username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 *
	 * @param username set user's username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 *
	 * @return user's password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 *
	 * @param password set user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 *
	 * @return user's full name
	 */
	public String getName() {
		return name;
	}
	/**
	 *
	 * @param name set user's full name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 *
	 * @return user's email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 *
	 * @param email set user's email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 *
	 * @return user's mobile number
	 */
	public int getMobile() {
		return mobile;
	}
	/**
	 *
	 * @param mobile set user's mobile number
	 */
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
}
