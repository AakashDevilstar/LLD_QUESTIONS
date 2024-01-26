package trip;



import driver.Driver;
import location.Location;
import rider.Rider;
import strategy.driverMatchingStrategy.DriverMatchingStrategy;
import strategy.pricingStrategy.PricingStrategy;

public class Trip{
	private Rider rider;
	private Driver driver;
	private Location srcLocation;
	private Location destLocation;
	private PricingStrategy priceStrategy;
	private DriverMatchingStrategy driverStrategy;
	private boolean available;
	private double tripPrice;
	private Integer tripId;
	
	Trip(Rider _rider,Driver _driver,Location _src,Location _dest,PricingStrategy _priceStrategy, DriverMatchingStrategy _driverStrategy,double _tripPrice){
		this.rider=_rider;
		this.driver=_driver;
		this.srcLocation=_src;
		this.destLocation=_dest;
		this.priceStrategy=_priceStrategy;
		this.driverStrategy=_driverStrategy;
		this.tripPrice=_tripPrice;
		this.available=true;
		this.tripId=69;
	}
	
	public int getTripId() {
		return this.tripId;
	}
	
	
	public void displayTripDetails() {
		System.out.println("Trip ID: " + this.tripId);
		System.out.println("Rider Name: " + this.rider.getRiderName());
		System.out.println("DriverName: " + this.driver.getDriverName());
		System.out.println("Source: " + this.srcLocation.getLocationName());
		System.out.println("Destination: " + this.destLocation.getLocationName());
		System.out.println("Total Fare: " + this.tripPrice);
		System.out.println("Pricing Strategy: " + this.priceStrategy.getStrategyName());
		System.out.println("Driver Matching Strategy: " + this.driverStrategy.getStrategyName());
		System.out.println("Trip Status: " + this.available);
	}
}