package driver;

import java.util.Map;
import java.util.TreeMap;

public class DriverManager {
	//Thread Save
	public static DriverManager drivermanagerInstances;
	//Declaration Of an Map
	private Map<String,Driver> driverMap=new TreeMap<>();
	
	private DriverManager() {
		
	}
	
	public static DriverManager getDrivermanagerInstances() {
		if(drivermanagerInstances==null) {
			synchronized (DriverManager.class) {
				if(drivermanagerInstances==null) {
					drivermanagerInstances=new DriverManager();
				}
			}
		}
		return drivermanagerInstances;
	}
	
	public void addDriver(String name,Driver driver) {
		driverMap.put(name, driver);
	}
	
	public Driver getDriver(String name) {
		Driver driver=driverMap.get(name);
		return driver;
	}
	
}