package moblima;

import cinema.ShowTimeDatabase;
import movies.MovieDatabase;
import user.UserDatabase;
import admin.AdminDatabase;
import movies.HolidayDatabase;
import booking.BookingDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//initialize the databases here
public class SaveAndLoadDB {

    public void saveShowTimeDB(ShowTimeDatabase stdb, int cineplexNumber) {
		try {
			switch (cineplexNumber){
				case 1: 
					FileOutputStream fos = new FileOutputStream("ShowTimeDB1.txt");
				    ObjectOutputStream oos = new ObjectOutputStream(fos);
				    oos.writeObject(stdb);
				    oos.close();
				    fos.close();
				    System.out.println("ShowTime DB Serialized and saved");
				    break;
				case 2:
					FileOutputStream fos2 = new FileOutputStream("ShowTimeDB2.txt");
				    ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
				    oos2.writeObject(stdb);
				    oos2.close();
				    fos2.close();
				    System.out.println("ShowTime DB Serialized and saved");
				    break;
				case 3:
					FileOutputStream fos3 = new FileOutputStream("ShowTimeDB3.txt");
				    ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
				    oos3.writeObject(stdb);
				    oos3.close();
				    fos3.close();
				    System.out.println("ShowTime DB Serialized and saved");
				    break;
			}
//			FileOutputStream fos = new FileOutputStream("ShowTimeDB.txt");
//		    ObjectOutputStream oos = new ObjectOutputStream(fos);
//		    oos.writeObject(stdb);
//		    oos.close();
//		    fos.close();
//		    System.out.println("ShowTime DB Serialized and saved");
		}
		catch(IOException ie) {
			System.out.println("Saving error occurred " + ie);
		}
    }
    
    public ShowTimeDatabase loadShowTimeDB(int cineplexNum) {
        try {
			switch (cineplexNum){
			case 1: 
				FileInputStream fis = new FileInputStream("ShowTimeDB1.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				ShowTimeDatabase stdb = (ShowTimeDatabase) ois.readObject();
				ois.close();
				fis.close();
				System.out.println("ShowTime DB Deserialized and loaded");
		        return stdb;
			case 2:
				FileInputStream fis2 = new FileInputStream("ShowTimeDB2.txt");
				ObjectInputStream ois2 = new ObjectInputStream(fis2);
				ShowTimeDatabase stdb2 = (ShowTimeDatabase) ois2.readObject();
				ois2.close();
				fis2.close();
				System.out.println("ShowTime DB Deserialized and loaded");
		        return stdb2;
			case 3:
				FileInputStream fis3 = new FileInputStream("ShowTimeDB3.txt");
				ObjectInputStream ois3 = new ObjectInputStream(fis3);
				ShowTimeDatabase stdb3 = (ShowTimeDatabase) ois3.readObject();
				ois3.close();
				fis3.close();
				System.out.println("ShowTime DB Deserialized and loaded");
		        return stdb3;
			}
//			FileInputStream fis = new FileInputStream("ShowTimeDB.txt");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//
//			ShowTimeDatabase stdb = (ShowTimeDatabase) ois.readObject();
//			ois.close();
//			fis.close();
//			System.out.println("ShowTime DB Deserialized and loaded");
//	        return stdb;
		        
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			
		} catch (IOException e) {
			System.out.println("Loading error occurred");
		}
        return null;
    }
    
	public void saveMovieDB(MovieDatabase mdb) {
		try {
			FileOutputStream fos = new FileOutputStream("MovieDB.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(mdb);
		    oos.close();
		    fos.close();
		    System.out.println("MovieDB Serialized and saved");
		}
		catch(IOException ie) {
			System.out.println("Saving error occurred " + ie);
		}
	}
	
	public MovieDatabase loadMovieDB() {
        try {
			FileInputStream fis = new FileInputStream("MovieDB.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			MovieDatabase mdb = (MovieDatabase) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("MovieDB Deserialized and loaded");
	        return mdb;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			
		} catch (IOException e) {
			System.out.println("Loading error occurred" + e);
		}
        return null;
	}
	
	
	public void saveUserDB(UserDatabase udb) {
		try {
			FileOutputStream fos = new FileOutputStream("UserDB.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(udb);
		    oos.close();
		    fos.close();
		    System.out.println("UserDB Serialized and saved");
		}
		catch(IOException ie) {
			System.out.println("Saving error occurred " + ie);
		}
	}
	
	public UserDatabase loadUserDB() {
        try {
			FileInputStream fis = new FileInputStream("UserDB.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			UserDatabase udb = (UserDatabase) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("UserDB Deserialized and loaded");
	        return udb;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			
		} catch (IOException e) {
			System.out.println("Loading error occurred");
		}
        return null;
	}
    
	public void saveAdminDB(AdminDatabase adb) {
		try {
			FileOutputStream fos = new FileOutputStream("AdminDB.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(adb);
		    oos.close();
		    fos.close();
		    System.out.println("AdminDB Serialized and saved");
		}
		catch(IOException ie) {
			System.out.println("Saving error occurred " + ie);
		}
	}
	
	public AdminDatabase loadAdminDB() {
        try {
			FileInputStream fis = new FileInputStream("AdminDB.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			AdminDatabase adb = (AdminDatabase) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("UserDB Deserialized and loaded");
	        return adb;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			
		} catch (IOException e) {
			System.out.println("Loading error occurred");
		}
        return null;
	}
	
	public void saveHolidayDB(HolidayDatabase hdb) {
		try {
			FileOutputStream fos = new FileOutputStream("HolidayDB.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(hdb);
		    oos.close();
		    fos.close();
		    System.out.println("HolidayDB Serialized and saved");
		}
		catch(IOException ie) {
			System.out.println("Saving error occurred " + ie);
		}
	}
	
	public HolidayDatabase loadHolidayDB() {
        try {
			FileInputStream fis = new FileInputStream("HolidayDB.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			HolidayDatabase hdb = (HolidayDatabase) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("HolidayDB Deserialized and loaded");
	        return hdb;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			
		} catch (IOException e) {
			System.out.println("Loading error occurred");
		}
        return null;
	}
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		MovieDatabase mdb = new MovieDatabase();
//		MovieDatabase mdbcopy = null;
//		SaveAndLoadDB fff2 = new SaveAndLoadDB();
//		fff2.saveMovieDB(mdb);
//		mdbcopy = fff2.loadMovieDB();
//		mdbcopy.printMovieDetails();
//		System.out.println(mdbcopy.getMovieTitlesList());
//	}
		
//		ShowTimeDatabase stdb = new ShowTimeDatabase();
//		ShowTimeDatabase stdbcopy = null;
//		fff2.saveShowTimeDB(stdb);
//		stdbcopy = fff2.loadShowTimeDB();
//		System.out.println(stdbcopy.getShowTimes());
		
//		AdminDatabase adb = new AdminDatabase();
//		AdminDatabase adbcopy = null;
//		fff2.saveAdminDB(adb);
//		adbcopy = fff2.loadAdminDB();
//		System.out.println(adbcopy.getAdminList());
		
//		UserDatabase udb = new UserDatabase();
//		UserDatabase udbcopy = new UserDatabase();
//		fff2.saveUserDB(udb);
//		udbcopy = fff2.loadUserDB();
//		System.out.println(udbcopy.getUserList());
		
		
//	}
}
