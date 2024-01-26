package Ticket;

import car.Car;

public class Parking_Ticket {
	public String EnterDate;
	public String EnterTime;
	public int SpotNumber;
	public long CardNumber;
	public String CardType;
	
	public Car car;
	
	public void setAssignedCar(Car _car) {
		this.car=_car;
	}
	
	public void setEnterDate(String _enterDate) {
		this.EnterDate=_enterDate;
	}
	
	public void setEnterTime(String _enterTime) {
		this.EnterTime=_enterTime;
	}
	
	public void setSpotNumber(int _spotNumber) {
		this.SpotNumber=_spotNumber;
	}
	
	public void setCardNumber(long _cardNumber) {
		this.CardNumber=_cardNumber;
	}
	
	public void setCardType(String _cardType) {
		this.CardType=_cardType;
	}
	
	public String getEnterDate() {
		return EnterDate;
	}
	
	public Car getAssignedCar() {
		return car;
	}
	
	public String getEnterTime() {
		return EnterTime;
	}
	
	public int getSpotNumber() {
		return SpotNumber;
	}
	
	public long getCardNumber() {
		return CardNumber;
	}
	
	public String getCardType() {
		return CardType;
	}
	
}