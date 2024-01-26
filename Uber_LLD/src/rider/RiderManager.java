package rider;

import java.util.Map;
import java.util.TreeMap;

public class RiderManager {
	
	public static RiderManager ridermanagerInstance;
	private Map<String,Rider> riderMap=new TreeMap<>();
	
	private RiderManager() {
		
	}
	
	public static RiderManager getRiderManagerInstances() {
		if(ridermanagerInstance==null) {
			synchronized (RiderManager.class) {
				if(ridermanagerInstance==null) {
					ridermanagerInstance=new RiderManager();
				}
			}
		}
		return ridermanagerInstance;
	}
	
	public Rider getRider(String riderName) {
		Rider rider=riderMap.get(riderName);
		return rider;
	}
	
	public void addRider(String riderName, Rider rider) {
		riderMap.put(riderName, rider);
	}
}