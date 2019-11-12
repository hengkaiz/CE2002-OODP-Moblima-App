package Cinema;

import java.util.Calendar;
public class Test {
    public static void main(String[] args){
        Calendar d = Calendar.getInstance();
        int year = d.get(Calendar.YEAR);

        int day = d.get(Calendar.DATE);
        d.add(Calendar.DATE, 20);
        int month = d.get(Calendar.MONTH);
        System.out.println(month);
    }
}
