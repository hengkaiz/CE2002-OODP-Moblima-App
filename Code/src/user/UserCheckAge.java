package user;

import cinema.ShowTime;
import moblima.SaveAndLoadDB;
/**
 * check if user is old enough to watch the movie
 */
public class UserCheckAge {
    /**
     * ShowTime of the movie user selected
     */
    private ShowTime st;
    /**
     * User's username
     */
    private String username;
    /**
     * loads the movie database on to mdb object reference
     */
    public UserCheckAge(ShowTime st, String username){
        this.st = st;
        this.username = username;
    }
    /**
     * compares the user's age against the Movie's age rating
     * @return boolean true = user is old enough to watch the movie, false = not old enough
     */
    public boolean checkAge(){
        SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
        UserDatabase udb = saveAndLoadDB.loadUserDB();
        User user = null;

        for(User u: udb.getUserList()){
            if(u.getUsername().contentEquals(username)){
                user = u;
                break;
            }
        }

        int ageLimit = 0;
        if(st.getMovieObject().getAgeRating().getName().contentEquals("PG13")) ageLimit = 13;
        else if(st.getMovieObject().getAgeRating().getName().contentEquals("NC16")) ageLimit = 16;
        else if(st.getMovieObject().getAgeRating().getName().contentEquals("M18")) ageLimit = 18;
        else if(st.getMovieObject().getAgeRating().getName().contentEquals("R21")) ageLimit = 21;
        else return true;

        if (ageLimit > user.getAge()){
            System.out.println("Sorry you are not old enough to watch this movie!");
            return false;
        }

        return true;
    }
}
