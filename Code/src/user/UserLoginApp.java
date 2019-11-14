package user;

import java.util.Scanner;

public class UserLoginApp extends UserDatabase{
	private User login_user;

	//checking username and password entered
	private boolean loginCheck(String name, String password){
		login_user = super.searchByName(name);
		//code in exception here if username not found

		if (!login_user.getPassword().contentEquals(password)){
			return false;
		}
		return true;
	}

	public String UserLogin() {
		Scanner sc = new Scanner(System.in);
		int sel;

		System.out.println("---USER---");
		System.out.println("1. Login");
		System.out.println("2. Create Account");
		System.out.println("3. Return");
		System.out.print("Please enter your choice: ");
		sel = sc.nextInt();
		System.out.println();
		sc.nextLine(); //clear the buffer

		switch (sel) {
			case 1: //login
				System.out.print("Enter ID: ");
				String ID = sc.nextLine();
				System.out.print("Enter password: ");
				String Password = sc.nextLine();

				if (loginCheck(ID, Password)) {
					System.out.println("Welcome, " + ID + "\n");
					return ID;
				}
				//System.out.println("Sorry, account does not exist. Would you like to create an account instead?");
				//exception for wrong password or wrong username
				break;

			case 2: //create new account
				System.out.print("Enter desired ID: ");
				String dID = sc.nextLine();
				boolean result2 = super.checkExistingID(dID);
				if (result2) { //username does not exist
					System.out.print("Enter desired Password: ");
					String dPassword = sc.nextLine();
					System.out.print("Please retype your Password: ");
					String dPassword2 = sc.nextLine();
					if (!dPassword.contentEquals(dPassword2)) {
						System.out.println("The passwords do not match, please try again!");
					}
					//exception for mismatch password
					super.addUser(dID, dPassword2);
					System.out.print("Welcome, " + dID + "\n");
					return dID;
					//add account into database
				}
				//exception if username already exist
				//System.out.println("Sorry, username is already taken, please use another username");
				break;

			case 3:
				break;
		}
		return "";
	}
}
