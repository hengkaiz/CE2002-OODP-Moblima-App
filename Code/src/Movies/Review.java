package Movies;

import java.util.Scanner;

public class Review {
	private String reviewer;
	private double rating;
	//date
	private String reviewContent;

	public Review createReview() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String reviewer=sc.nextLine();
		this.reviewer = reviewer;
		
		System.out.println("Enter a rating out of 10: ");
		double rating=sc.nextDouble();
		this.rating = rating;
		
		System.out.println("Enter your review: ");
		String reviewContent=sc.nextLine();
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
}
