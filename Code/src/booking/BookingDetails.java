package booking;

import java.io.Serializable;

import cinema.*;
import user.*;
import movies.*;


public class BookingDetails implements Serializable {
    private String username;
    private String cineplexName;
    private int cinemaNum;
    private String movieTitle;
    private int showTime;
    private int[] seat;
    private double price;
    private String TID;

    public BookingDetails(String username, int cineplexNum, ShowTime st,
                          int[] seat, double price, String TID) {
        this.username = username;

        //set the cineplex based on its number
        if (cineplexNum == 1) cineplexName = "Jurong Point";
        else if (cineplexNum == 2) cineplexName = "Bishan";
        else this.cineplexName = "Nex";

        this.cinemaNum = st.getCinemaNum();
        this.movieTitle = st.getMovie();
        this.showTime = st.getTiming();
        this.seat = seat;
        this.price = price;
        this.TID = TID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCineplexName() {
        return cineplexName;
    }

    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    public int getCinemaNum() {
        return cinemaNum;
    }

    public void setCinemaNum(int cinemaNum) {
        this.cinemaNum = cinemaNum;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getShowTime() {
        return showTime;
    }

    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }

    public int[] getSeat() {
        return seat;
    }

    public void setSeat(int[] seat) {
        this.seat = seat;
    }
}





































































































