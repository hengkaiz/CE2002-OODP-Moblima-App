package user;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Scanner;

public class UserDatabase implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<User> userlist = new ArrayList<User>();
    private ArrayList<User> copylist;

    public UserDatabase(){
//        User u1 = new User("hk", "123", "hk1", 3, "email", 123);
//        userlist.add(u1);
//        User u2 = new User("hk2", "1235", "hk1", 140, "email", 123);
//        userlist.add(u2);
    }

    private User sortNames(String name){
        User returndata = null;
        for (User user: userlist){
            if (user.getUsername().contentEquals(name)){
                returndata = user;
            }
        }
        return returndata;
    }

    public User searchByName(String name){ //search username
        return sortNames(name);
    }
    
    public boolean checkExistingID(String name) {
    	for (User user: userlist){
            if (user.getUsername().contentEquals(name)){
                return false;
            }
        }
        return true;
    }

    public void addUser(String un, String pw){
        Scanner sc = new Scanner(System.in);

        try {
			System.out.println("\n---Update personal information---");
			System.out.print("Enter Full Name: ");
			String fn = sc.nextLine();
			System.out.print("Enter Age: ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Email: ");
			String em = sc.nextLine();
			System.out.print("Enter Phone Number: ");
			int mn = sc.nextInt();

			userlist.add(new User(un, pw, fn, age, em ,mn));
			System.out.println("\nAccount added! ");
		} catch (Exception e) {
			System.out.println("Error in input. Try again.");
			addUser(un, pw);
		}

    }

    public boolean delUser(){
        Scanner sc = new Scanner(System.in);
        String un = null;
		String pw = null;
		boolean loop1 = true;
		do {
		try {
			System.out.print("Enter Username: ");
			un = sc.nextLine();
			System.out.print("Enter Password: ");
			pw = sc.nextLine();
			loop1 = false;
		} catch (Exception e) {
			System.out.println("Error in input. Try again.");
		}
		} while (loop1);
        User del_acc;
        del_acc = searchByName(un);

        if(del_acc.getUsername() == pw)
            return false;

        for (int i=0;i<userlist.size();i++){
            if (del_acc.getUsername() == userlist.get(i).getUsername()){
                userlist.remove(i);
                System.out.println("Account is removed!");
                break;
            }
        }
        return true;
    }

    public void printUsers(){
        for(User u:userlist){
            System.out.println(u.getName());
        }
    }
    
    public ArrayList<User> getUserList() {
    	return this.userlist;
    }
}
