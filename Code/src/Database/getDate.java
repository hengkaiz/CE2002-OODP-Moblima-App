package Database;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class getDate {
    private Calendar date;
    public getDate() {
        date = Calendar.getInstance();
    }

    public int getYear(){
        return date.get(Calendar.YEAR);
    }

    public int getMonth(){
        return date.get(Calendar.MONTH);
    }

    public int getDay(){
        return date.get(Calendar.DAY_OF_MONTH);
    }

    public String printDate(){ //print the date in dd/MM format
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        return sdf.format(date.getTime());
    }

}
