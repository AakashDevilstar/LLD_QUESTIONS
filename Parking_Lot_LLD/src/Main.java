import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Info.Random_Info;
import Pay.Payment;
import Scan.Scanning_Ticket;
import Ticket.Parking_Ticket;
import car.Car;
import parking.Parking_Spot;
import time.Toal_Time;

public class Main {
	public static void main(String args[]) {
		ArrayList<Parking_Ticket> assignedspotlist = new ArrayList<>();
		
		Parking_Spot parkingspot=new Parking_Spot();
		Random_Info randominfo=new Random_Info();
		Scanner scan =new Scanner(System.in);
		
		while(true) {
			System.out.print("You Want to park your vehicle:");
			String userinput=scan.nextLine();
			int size=userinput.length();
			
			Parking_Ticket parkingticket=new Parking_Ticket();
			Car car=new Car();
			
			if(size==5) {
				System.out.print("Most Welcome come these side:");
				
				//Assign car details
				String carcolor=Random_Info.carColor();
				String numberPlate=Random_Info.NumberPlate();
				String carType=Random_Info.cardType();
				
				System.out.println("Moti chain mota pesa : "+numberPlate);
				
				parkingticket.setAssignedCar(car);
				parkingticket.getAssignedCar().setCarColor(carcolor);
				parkingticket.getAssignedCar().setCarType(carType);
				parkingticket.getAssignedCar().setNumberPlate(numberPlate);
				
				//get free spot from the parking_lot
				
				int spot=parkingspot.SpotNum();
				if(spot==0) {
					System.out.print("Sorry, Spot is not Available");
					break;
				}
				parkingticket.setSpotNumber(spot);
				
				String cardtype=randominfo.cardType();
				String time=randominfo.EnterTime();
				String date=randominfo.enterDate();
				long cardnumber=randominfo.CardNumber();
				
				parkingticket.setCardType(cardtype);
				parkingticket.setEnterTime(time);
				parkingticket.setEnterDate(date);
				parkingticket.setCardNumber(cardnumber);
				
				System.out.println("\t\t==Parking Ticket ==\n" +
				"Car Number : "+numberPlate+"  Car Color : "+carcolor+" Car Type : "+cardtype+
				"\nParking Time : "+time+" Date : "+date+
				"\nSpot Number : "+spot+"\n"
				);
				
			}
			
			else if(size==4) {
				System.out.print("Thanks to enjoy our Service");
				int check=parkingspot.Si();
				if(check==10) {
					System.out.print("Sorry there is no car in Parking");
					continue;
				}
				else {
					System.out.print("Enter your Car Number :");
					String number = scan.nextLine();
					Scanning_Ticket scanticket=new Scanning_Ticket();
					Toal_Time totaltime=new Toal_Time();
					Payment payment=new Payment();
					
					for(Parking_Ticket cp:assignedspotlist) {
						String carnumber=cp.getAssignedCar().getNumberPlate();
						int cmp=scanticket.Scan_Conform(carnumber, number);
						if(cmp==0) {
							continue;
						}
						else if(cmp==1) {
							int spot=assignedspotlist.indexOf(cp);
							String exitDate=randominfo.existDate();
							String exitTime=randominfo.ExitTime();
							
							String enterDate=assignedspotlist.get(spot).getEnterDate();
							String enterTime=assignedspotlist.get(spot).getEnterTime();
							
							int time[]=totaltime.CalculateTime(enterDate, exitDate, enterTime, exitTime);
							float amount=payment.TotalAmount(time[0],time[1]);
							
							System.out.print("\n\t\t=== Your Parking Information ===\n"+
						    " Car Number : "+assignedspotlist.get(spot).getAssignedCar().getNumberPlate()+
						    " Car Color : "+assignedspotlist.get(spot).getAssignedCar().getCarColor()+
						    " Car Type : "+assignedspotlist.get(spot).getAssignedCar().getCarType()+
						    "\nExit Time : "+exitTime+
						    " Exit Date : "+exitDate+
						    " Spot Number : "+assignedspotlist.get(spot).getSpotNumber()+
						    " \nTotal Time : "+time[0]+" Hour "+time[1]+" Minute "+
						    "\nTotal Amount : "+amount+" Rupess\n"
							);
							parkingspot.FreeSpace(assignedspotlist.get(spot).getSpotNumber());
							assignedspotlist.remove(spot);
							break;
						}
					}
					
				}
				
			}
			else if(size==6) {
				System.out.println("All Car Information");
				for(Parking_Ticket cp:assignedspotlist) {
					System.out.println("\n\nCar Number : "+cp.getAssignedCar().getNumberPlate()+
					 " Car Color : "+cp.getAssignedCar().getCarColor()+
					 " Car Type : "+cp.getAssignedCar().getCarType()+
					 " \n Parking time : "+cp.getEnterTime()+" Date : "+cp.getEnterDate()+
					 " Spot Number : "+cp.getSpotNumber()
					);
				}
				parkingspot.sipe();
				System.out.println();
			}
			
		}
		
	}
}