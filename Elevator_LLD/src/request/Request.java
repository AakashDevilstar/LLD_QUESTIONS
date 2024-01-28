package request;

import direction.Direction;
import location.Location;

public class Request {
	public int currentFloor;
	public int destinationFloor;
	public Direction direction;
	public Location location;
	
	public Request(int _currentFloor,int _destinationFloor, Direction _direction,Location _location){
		this.currentFloor=_currentFloor;
		this.destinationFloor=_destinationFloor;
		this.direction=_direction;
		this.location=_location;
	}

	public int getDestinationFloor() {
		return this.destinationFloor;
	}
}