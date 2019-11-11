package admin;

public class AdminAccount {
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
}
