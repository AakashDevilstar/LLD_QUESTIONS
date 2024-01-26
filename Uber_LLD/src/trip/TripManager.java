package trip;
import location.Location;
import java.util.Map;
import java.util.TreeMap;


import driver.Driver;
import rider.Rider;
import strategy.StrategyManager;
import strategy.driverMatchingStrategy.DriverMatchingStrategy;
import strategy.pricingStrategy.PricingStrategy;

public class TripManager {
	public static TripManager tripManagerInstances;
	private Map<Integer, Trip> tripsInfo = new TreeMap<>();	
	private Map<Integer, TripMetaData> tripsMetaDataInfo = new TreeMap<>();
	
	private TripManager() {
		
	}
	
	public static TripManager getTripManagerInstance() {
		if(tripManagerInstances==null) {
			synchronized (TripManager.class) {
				if(tripManagerInstances==null) {
					tripManagerInstances=new TripManager();
				}
			}
		}
		return tripManagerInstances;
	}
	
	public void createTrip(Rider rider, Location src,Location dest){
		StrategyManager strategymanagerInstance=StrategyManager.getStrategyManegerInstance();
		TripMetaData metaData=new TripMetaData(rider.getRating(),src,dest);
		PricingStrategy ps=strategymanagerInstance.pricingStrategy(metaData);
		DriverMatchingStrategy ds=strategymanagerInstance.determinedriverMatchingStrategy(metaData);
		Driver driver=ds.matchDriver(metaData);
		double tripPrice=ps.calculatePricing(metaData);
		Trip tp=new Trip(rider,driver,src,dest,ps,ds,tripPrice);
		tripsInfo.put(tp.getTripId(),tp);
		tripsMetaDataInfo.put(tp.getTripId(), metaData);
	}
	
	public Map<Integer, Trip> getAllTrips() {
		return this.tripsInfo;
	}
	
}