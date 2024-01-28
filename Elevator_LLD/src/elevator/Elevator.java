package elevator;

import java.util.PriorityQueue;

import direction.Direction;
import location.Location;
import request.Request;

public class Elevator {
	public int currentFloor;
	Direction direction;
	PriorityQueue<Request> up;
	PriorityQueue<Request> down;
	
	public Elevator(int _currentFloor){
		this.currentFloor=_currentFloor;
		this.direction=Direction.IDLE;
		// Intialize the min heap for the up
		up=new PriorityQueue<>((a,b)->a.destinationFloor-b.destinationFloor);
		// Intialize the max heap for the down
		down=new PriorityQueue<>((a,b)->b.getDestinationFloor()-a.getDestinationFloor());
	}
	
	public void sendupRequest(Request uprequest) {
		// if the user at the outside of the elevator than lift has to be stop for the user to receive.
		// and than goto the destination of the user.
		if(uprequest.location==Location.OUTSIDE_ELEVATOR) {
			// create new stop for the lift
			up.offer(new Request(uprequest.currentFloor,uprequest.currentFloor,Direction.UP,Location.OUTSIDE_ELEVATOR));
			System.out.println("Getting Request from the "+uprequest.currentFloor+" Floor");
		}
		// Go to it's Destination Floor also
		up.offer(uprequest);
		System.out.println("Getting Request from the "+uprequest.destinationFloor+" Floor");
	}
	
	public void senddownRequest(Request downrequest) {
		// if the user at the outside of the elevator than lift has to be stop for the user to receive.
		// and than goto the destination of the user.
		if(downrequest.location==Location.OUTSIDE_ELEVATOR) {
			// create new stop for the lift
			down.offer(new Request(downrequest.currentFloor,downrequest.currentFloor,Direction.DOWN,Location.OUTSIDE_ELEVATOR));
			System.out.println("Getting Request from the "+downrequest.currentFloor+" Floor");
		}
		// Go to it's Destination Floor also
		down.offer(downrequest);
		System.out.println("Getting Request from the "+downrequest.destinationFloor+" Floor");
	}
	
	public void run() {
		while(!up.isEmpty() || !down.isEmpty()) {
			processRequests();
		}
		System.out.print("Requests are Finished:");
		this.direction=Direction.IDLE;
	}
	
	private void processRequests() {
		if(this.direction==Direction.UP || this.direction==Direction.IDLE) {
			processupReq();
			processdownReq();
		}
		else {
			processdownReq();
			processupReq();
		}
	}
	
	private void processupReq() {
		while(!up.isEmpty()) {
			Request req=up.poll();
			this.currentFloor=req.destinationFloor;
			System.out.println("Reaching the Destination "+this.currentFloor+" Floor");
		}
		if(!down.isEmpty()) {
			this.direction=Direction.DOWN;
		}
		else {
			this.direction=Direction.IDLE;
		}
	}
	
	private void processdownReq() {
		while(!down.isEmpty()) {
			Request reqs=down.poll();
			this.currentFloor=reqs.destinationFloor;
			System.out.println("Reaching the Destination "+this.currentFloor+"Floor");
		}
		if(!up.isEmpty()) {
			this.direction=Direction.UP;
		}
		else {
			this.direction=Direction.IDLE;
		}
	}
	
}