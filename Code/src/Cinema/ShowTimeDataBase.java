package Cinema;

import java.util.Comparator;
import java.util.ArrayList;

public class ShowTimeDataBase {
    private ArrayList<ShowTime> showtimelist = new ArrayList<ShowTime>();

    public ShowTimeDataBase(){
        //import existing show times from file?
    }

    //add ne show times
    public void updateShowTime(int t, String m, int cn,  String ct){
        showtimelist.add(new ShowTime(t, m , cn ,ct));
    }


}