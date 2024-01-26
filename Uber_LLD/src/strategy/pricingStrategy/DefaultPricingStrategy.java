package strategy.pricingStrategy;

import trip.TripMetaData;

public class DefaultPricingStrategy implements PricingStrategy {
	@Override
	public double calculatePricing(TripMetaData metaData) {
		return 200;
	}
	
	@Override
	public String getStrategyName() {
		return "Default Pricing Stratefy";
	}
	
}