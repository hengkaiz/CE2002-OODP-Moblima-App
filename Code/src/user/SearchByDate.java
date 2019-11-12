package user;
import java.util.ArrayList;
import java.util.Scanner;

import Showtime;
import Database

public class SearchByDate implements SearchFunction {
	private int date;
	private String movie;
	
	
	public void SearchResults(int date) {
		//creates object dateList
		ArrayList<Database> dateList = new ArrayList<>();
		
		//prints out date list
		for(int i = 0; i < dateList.size(); i++) {
            System.out.println(i+1, ".", dateList.get(i).getDate());
		} 
        
        System.out.println("Please select dates based on index");
        Scanner sc = new Scanner(System.in);
        int sel = sc.nextInt();
        
        //set movieSelected as the input user selected. *need to change movie 
        int dateSelected =  Database.get(sel-1).getDate();
        
        //searches through BookingDatabase, compareTo returns timing
        Database.searchByDate(dateSelected);
                
	}
}
