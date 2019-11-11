package Movie;
import java.util.Date;

public class MovieReview {
    private String review;
    private int rating;
    //private Date date;
    //private User author;

    public MovieReview(String review, int rating){
        this.rating = rating;
        this.review = review;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
