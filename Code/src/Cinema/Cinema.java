package Cinema;

import java.util.ArrayList;
import java.util.Scanner;


public class Cinema extends Cineplex{
    private String type;
    private int code;
    private ArrayList<ShowTime> showtime;

    public Cinema(String type, int code){
        this.type = type;
        this.code = code;
        this.showtime = new ArrayList<ShowTime>();
    }

    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<ShowTime> getShowtime() {
        return showtime;
    }

    public void addShowTime(){
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();

    }
}
