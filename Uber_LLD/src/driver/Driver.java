package driver;

import rating.Rating;

public class Driver {
	private String name;
	private boolean availability;
	private Rating rating;
	
	public Driver(String name,Rating rating) {
		this.name=name;
		this.rating=rating;
		this.availability=true;
	}
	
	public void updateAvail(boolean avail) {
		this.availability=avail;
	}
	
	public String getDriverName() {
		return this.name;
	}
	
	public Rating getRating() {
		return this.rating;
	}
}