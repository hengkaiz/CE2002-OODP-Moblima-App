package Database;

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
        return date.get(Calendar.DATE);
    }


}
