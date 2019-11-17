package movies;

import java.io.Serializable;
import java.util.Scanner;

public class Review implements Serializable{
	private static final long serialVersionUID = 1L;
	private String reviewer;
	private double rating;
	//date
	private String reviewContent;
	
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
		reviewContent = sc.nextLine();

		
		this.reviewer = reviewer;
		this.rating = rating;
		this.reviewContent = reviewContent;	
	}

	public Review(String reviewer, double rating, String reviewContent) {
		this.reviewer = reviewer;
		this.rating = rating;
		this.reviewContent = reviewContent;
	}

	
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String toStringRating() {
		return "Rated " + this.rating + " out of 5 by: " + this.reviewer; 
	}
	public String toStringReview() {
		return  "Review: " + this.reviewContent;
	}
}
