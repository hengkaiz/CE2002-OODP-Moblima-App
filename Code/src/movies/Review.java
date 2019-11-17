package movies;

import java.io.Serializable;
import java.util.Scanner;

/**
 * represents a user review
 */
public class Review implements Serializable{
	/**
	 * To identify the version of the class used in Serialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * reviewer name
	 */
	private String reviewer;
	/**
	 * rating out of 5
	 */
	private double rating;
	/**
	 * content of the review
	 */
	private String reviewContent;
	
	/**
	 * creates a review by asking user to key in name,
	 * rating out of 5 and the review contents
	 */
	public Review() {
		String reviewer = null;
		double rating = 0;
		String reviewContent = null;

		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter your name: ");
		reviewer = sc.nextLine();

		try {
			System.out.print("Enter a rating out of 5: ");
			rating = sc.nextDouble();

			if (rating <= 0 || rating > 5) {
				throw new Exception("Enter a rating between 1 - 5!");
			}
		}
		catch (Exception e){
				System.out.println("Enter a rating between 1 - 5!");
				return;
			}

			
		System.out.println("Enter your review: ");
		String dummy = sc.nextLine();
		reviewContent = sc.nextLine();

		
		this.reviewer = reviewer;
		this.rating = rating;
		this.reviewContent = reviewContent;	
	}
	/**
	 * constructs a review based on the parameters given
	 * @param reviewer name of reviewer
	 * @param rating rating out of 5
	 * @param reviewContent content of review
	 */
	public Review(String reviewer, double rating, String reviewContent) {
		this.reviewer = reviewer;
		this.rating = rating;
		this.reviewContent = reviewContent;
	}

	/**
	 * @return current reviewer name
	 */
	public String getReviewer() {
		return reviewer;
	}
	
	/**
	 * @param reviewer name to be set
	 */
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	/**
	 * @return current rating out of 5
	 */
	public double getRating() {
		return rating;
	}
	
	/**
	 * @param rating rating to be set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	/**
	 * @return current review content
	 */
	public String getReviewContent() {
		return reviewContent;
	}
	
	/**
	 * @param reviewContent review content to be set
	 */
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	/**
	 * @return String the rating out of 5 and name of reviewer in proper format
	 */
	public String toStringRating() {
		return "Rated " + this.rating + " out of 5 by: " + this.reviewer; 
	}
	
	/**
	 * @return String the review content in proper format
	 */
	public String toStringReview() {
		return  "Review: " + this.reviewContent;
	}
}
