package strategy.pricingStrategy;

import trip.TripMetaData;

public interface PricingStrategy {
	
	public double calculatePricing(TripMetaData metadata);
	public String getStrategyName();
	
	
	
}