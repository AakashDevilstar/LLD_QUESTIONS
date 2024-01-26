package rider;

import rating.Rating;

public class Rider {
	private String name;
	private Rating rating;
	
	public Rider(String name,Rating rating) {
		this.name=name;
		this.rating=rating;
	}
	
	public String getRiderName() {
		return this.name;
	}
	
	public Rating getRating() {
		return this.rating;
	}
}