package user;

import java.util.ArrayList;
import java.util.Scanner;

import user.UserDatabase;
import user.UserFunctions;
import user.User;

public class UserLoginApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDatabase db = new UserDatabase();
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Login");
		System.out.println("2. Create Account");
		System.out.println("Please enter your choice");
		int sel = sc.nextInt();
		
		if (sel == 1) {		
			System.out.println("enter id");
			String ID = sc.nextLine();
			System.out.println("enter password");
			String Password = sc.nextLine();
			UserFunctions temp = new UserFunctions();
			boolean result = temp.login(ID, Password);
			if(result) {
				System.out.println("Welcome," + db.searchByName(ID));
				// return true;remove main func next time, login successful
				}
			else {
				System.out.println("Sorry, account does not exist. Would you like to create an account instead?");
			}
				
			}
		
		
		if (sel == 2) {			
			System.out.println("enter desired id");
			String dID = sc.nextLine();
			boolean result2 = db.checkExistingID(dID);
			if (result2) { //username does not exist
				db.addUser();
				}
					
					/*newUser.setUsername(dID);
					newUser.setPassword(dPassword);
					System.out.println("enter your name");
					String name = sc.nextLine();
					System.out.println("enter your email");
					String email = sc.nextLine();
					System.out.println("enter your mobile");
					int mobile = sc.nextInt();
					System.out.println("enter your age");
					int age = sc.nextInt();
					
					newUser.setName(name);
					newUser.setEmail(email);
					newUser.setMobile(mobile);
					newUser.setAge(age);*/
					
					//add account into database
					
			
			else {
				System.out.println("Sorry, username is already taken, please use another username");
			}
				
		}
	}
}
		//add exception

