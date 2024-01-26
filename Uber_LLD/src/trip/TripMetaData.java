package trip;

import location.Location;

import rating.Rating;

public class TripMetaData {
	private Rating rating;
	private Location srcLocation;
	private Location destLocation;
	
	public TripMetaData(Rating _rating,Location _srcL,Location _destL) {
		this.rating=_rating;
		this.srcLocation=_srcL;
		this.destLocation=_destL;
	}
	
	public Location getSrcLocation() {
		return this.srcLocation;
	}
	
	public Location getDestLocation() {
		return this.destLocation;
	}
	
	public Rating getRating() {
		return this.rating;
	}
}