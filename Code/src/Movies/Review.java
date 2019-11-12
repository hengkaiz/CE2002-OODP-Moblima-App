package Movies;

import java.util.Scanner;

public class Review {
	private String reviewer;
	private double rating;
	private String reviewContent;
	
	public Review() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String reviewer=sc.nextLine();
		this.reviewer = reviewer;
		
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
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
}
