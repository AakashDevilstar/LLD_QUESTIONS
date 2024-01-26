package strategy;

import strategy.driverMatchingStrategy.DriverMatchingStrategy;
import strategy.driverMatchingStrategy.LeastTimeBasedDriverMatchingStrategy;
import strategy.pricingStrategy.DefaultPricingStrategy;
import strategy.pricingStrategy.PricingStrategy;
import trip.TripMetaData;

public class StrategyManager{
	public static StrategyManager strategyManegerInstance;
	
	private StrategyManager() {
		
	}
	
	public static StrategyManager getStrategyManegerInstance() {
		if(strategyManegerInstance==null) {
			synchronized (StrategyManager.class) {
				if(strategyManegerInstance==null) {
					strategyManegerInstance=new StrategyManager();
				}
			}
		}
		return strategyManegerInstance;
	}
	
	public DriverMatchingStrategy determinedriverMatchingStrategy(TripMetaData metaData) {
		return new LeastTimeBasedDriverMatchingStrategy();
	}
	
	public PricingStrategy pricingStrategy(TripMetaData metaData) {
		return new DefaultPricingStrategy();
	}
}