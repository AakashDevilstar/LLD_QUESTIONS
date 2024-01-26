package strategy.pricingStrategy;

import trip.TripMetaData;

public class RatingBasedPricingStrategy implements PricingStrategy {
	
	@Override
	public double calculatePricing(TripMetaData metaData) {
		return 300;
	}
	
	@Override
	public String getStrategyName() {
		return "Rating Based Pricing Strategy";
	}
}