package movies;

import java.util.Scanner;

public class Review {
	private String reviewer;
	private double rating;
	//date
	private String reviewContent;
	
	public Review() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String reviewer = sc.nextLine();
		
		System.out.println("Enter a rating out of 5: ");
		double rating = sc.nextDouble();
		
		System.out.println("Enter your review: ");
		String reviewContent = sc.nextLine();
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
