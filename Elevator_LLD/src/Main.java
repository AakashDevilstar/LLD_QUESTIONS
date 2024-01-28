import direction.Direction;
import elevator.Elevator;
import location.Location;
import request.Request;

public class Main {
	public static void main(String args[]) {
		Elevator elevator=new Elevator(0);
		// Up Request by the users
		Request upreq1=new Request(elevator.currentFloor,6,Direction.UP,Location.INSIDE_ELEVATOR);
		Request upreq2=new Request(elevator.currentFloor,4,Direction.UP,Location.INSIDE_ELEVATOR);
		
		Request downreq1=new Request(elevator.currentFloor,1,Direction.DOWN,Location.INSIDE_ELEVATOR);
		Request downreq2=new Request(elevator.currentFloor,2,Direction.DOWN,Location.INSIDE_ELEVATOR);
		Request downreq3=new Request(5,0,Direction.DOWN,Location.OUTSIDE_ELEVATOR);
		
		elevator.sendupRequest(upreq1);
		elevator.sendupRequest(upreq2);
		
		elevator.senddownRequest(downreq3);
		
		elevator.senddownRequest(downreq2);
		elevator.senddownRequest(downreq1);
		
		elevator.run();
	}
}