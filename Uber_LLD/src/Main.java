import java.util.Map;

import location.Location;

import driver.Driver;
import driver.DriverManager;
import rating.Rating;
import rider.Rider;
import rider.RiderManager;
import trip.TripManager;
import trip.Trip;

public class Main {
	public static void main(String args[]) {
		// Create Rating for 1,2 driver
		Rating driverRating1=new Rating();
		driverRating1.addRating(4);
		driverRating1.addRating(5);
		Rating driverRating2=new Rating();
		driverRating2.addRating(3);
		driverRating2.addRating(4);
		
		//create driver along with name and it's rating
		Driver driver1=new Driver("Akki",driverRating1);
		Driver driver2=new Driver("Mikku",driverRating2);
		
		//Create rating for rider
		Rating riderating1=new Rating();
		riderating1.addRating(3);
		riderating1.addRating(5);
		
		//create rider along with name and it's rating
		Rider rider1=new Rider("Aakash",riderating1);
		
		// Now we have to store the information of driver and rider in it's Manager
		DriverManager driverManagerInstance = DriverManager.getDrivermanagerInstances();
		RiderManager riderManagerInstance = RiderManager.getRiderManagerInstances();
		
		driverManagerInstance.addDriver(driver1.getDriverName(), driver1);
		driverManagerInstance.addDriver(driver2.getDriverName(), driver2);
		
		riderManagerInstance.addRider(rider1.getRiderName(), rider1);
		
		// We have to create TripManager Instance to createtrip
		
		TripManager tripManagerInstances=TripManager.getTripManagerInstance();
		//Create Location
		Location src=new Location("Sector-24");
		Location dest=new Location("Bpit");
		
		tripManagerInstances.createTrip(rider1,src,dest);
		
		Map<Integer, Trip> map = tripManagerInstances.getAllTrips();
		
		Trip t=map.get(69);
		t.displayTripDetails();
	}
}