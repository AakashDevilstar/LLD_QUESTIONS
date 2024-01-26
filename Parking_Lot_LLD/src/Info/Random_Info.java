package Info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Random_Info{
	static Random rand=new Random();
	
	static String[] states = {"MH", "GJ", "RJ", "DL", "MP", "UP", "KA", "JK", "LA"};
	static String[] dist = {"02", "27", "12", "19", "22", "08", "05", "26", "30"};
	static String[] alpha = {"AB", "CV", "RT", "ZX", "WE", "JK", "RL", "AQ", "PO", "DH"};
	static String[] color = {"Red", "Yellow", "Green", "white", "Brown", "Violet", "Pink"};
	static String[] type = {"Sedan", "van", "Minivan", "Bus", "Pickup-truck", "Hatchback"};
	static String[] cardtype= {"Debit","Credit"};
	
	public static String NumberPlate() {
		int st=rand.nextInt(states.length);
		int di=rand.nextInt(dist.length);
		int al=rand.nextInt(alpha.length);
		
		return states[st]+"-"+dist[di]+alpha[al]+rand.nextInt((99 - 10)+ 1) + 10;
	}
	
	public static String carColor() {
		int res=rand.nextInt(color.length);
		return color[res];
	}
	
	public static String cartype() {
		int res=rand.nextInt(type.length);
		return type[res];
	}
	
	public String EnterTime(){
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		String enterTime = localTime.format(dateTimeFormatter);
		return enterTime;
	}

	public String ExitTime(){
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		String exitTime = localTime.format(dateTimeFormatter);
		return exitTime;
	}
	
	public String enterDate() {
		LocalDate enterdate=LocalDate.now();
		return enterdate.toString();
	}
	
	public String existDate() {
		LocalDate exitdate=LocalDate.now();
		return exitdate.toString();
	}
	
	public static String cardType() {
		int res=rand.nextInt(cardtype.length);
		return cardtype[res];
	}
	
	public long CardNumber() {
		return ((rand.nextLong() % 100000000000000L) + 5200000000000000L);
	}
	
}