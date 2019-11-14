package cinema;

import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {
    private CinemaType type;
    private int code;
    private int cinemaNumber;
    private String ofCinemaCode;
    private String ofCineplexName;

    public Cinema(CinemaType type, int cinemaNumber){
        this.type = type;
        this.cinemaNumber = cinemaNumber;
    }

    public String getType(){
        return type.getName();
    }

    public void setType(CinemaType type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
//    public void
}
