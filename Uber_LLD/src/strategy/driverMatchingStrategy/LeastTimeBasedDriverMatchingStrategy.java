package strategy.driverMatchingStrategy;

import driver.Driver;
import driver.DriverManager;
import trip.TripMetaData;

public class LeastTimeBasedDriverMatchingStrategy implements DriverMatchingStrategy{
	@Override
	public Driver matchDriver(TripMetaData metaData) {
		DriverManager driverManagerInstance=DriverManager.getDrivermanagerInstances();
		return driverManagerInstance.getDriver("Akki");
	}
	
	@Override
	public String getStrategyName() {
		return "Least Time Based Driver Matching Strategy";
	}
}